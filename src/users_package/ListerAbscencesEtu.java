package users_package;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

/**
 * Servlet implementation class ListerAbscencesEtu
 */
@WebServlet("/ListerAbscencesEtu")
public class ListerAbscencesEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (session.getAttribute("client") == null || !(session.getAttribute("client") instanceof Etudiant)) {
			// dire erreur
			res.sendRedirect("../index.html");
		} else {
			PrintWriter out = res.getWriter();
			Connection con = null;
			out.print("<!DOCTYPE html>" + "<html>" + "<head>" + "<title>Authentification</title>"
					+ "<meta charset='utf-8'>"
					+ "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
					+ "<meta name='viewport' content='width=device-width, initial-scale=1'>"
					+ "<link rel='stylesheet' href='CSS/bootstrap-3.3.7-dist/css/bootstrap.min.css'>"
					+ "<link rel='stylesheet' href='CSS/font-awesome-4.7.0/css/font-awesome.min.css'>"
					+ "<link rel='stylesheet' href='CSS/style.css'>" + "</head>");

			Etudiant etudiant = (Etudiant) session.getAttribute("client");
			String login = etudiant.getLogin();

			try {
				Class.forName("org.postgresql.Driver");

				String url = "jdbc:postgresql://psqlserv/n3p1";
				String nom = "benoistv";
				String passwd = "moi";
				con = DriverManager.getConnection(url, nom, passwd);
				Statement state = con.createStatement();
				String query = "SELECT * from absence where login='" + login + "'";
				ResultSet rs = state.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
				out.print("<div  align=center>");
				out.println("<table class='table table-hover table-inverse'>");

				out.println("<thead><tr>");
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					out.println("<th>" + rsmd.getColumnName(i) + "</th>");
					out.println();
				}
				out.println("</tr>");
				while (rs.next()) {
					out.println("<tr>");
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {

						out.println("<td>" + rs.getString(i) + "</td>");
						System.out.println(rs.getString(i));
					}

					out.println("</tr>");

				}
				out.print("</table><div><a href='index.html'>Déconnexion </a></div></div>");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}

			}

		}

	}
}
