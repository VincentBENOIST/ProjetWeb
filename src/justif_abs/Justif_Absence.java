package justif_abs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import users_package.Personne;

/**
 * Servlet implementation class Verif_Authent
 */
@WebServlet("/Justif_Absence")
public class Justif_Absence extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String nometu = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String debut = request.getParameter("datedebut");
		String fin = request.getParameter("datefin");
		String motif = request.getParameter("Libelle");
		Personne p =(Personne) session.getAttribute("client");
		String secre = p.getLogin();
		nometu = StringEscapeUtils.escapeHtml4(nometu);
		prenom = StringEscapeUtils.escapeHtml4(prenom);
		debut = StringEscapeUtils.escapeHtml4(debut);
		fin = StringEscapeUtils.escapeHtml4(fin);
		String log = "" + nometu + prenom.charAt(0);
		Connection con = null;
		try {

			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://psqlserv/n3p1";
			String nom = "benoistv";
			String passwd = "moi";
			con = DriverManager.getConnection(url, nom, passwd);

			Statement state = con.createStatement();
			String query = "SELECT Max(jno) from justificatif";
			ResultSet rs = state.executeQuery(query);
			int max = 0;

			if (rs.next()) {
				max = Integer.parseInt(rs.getString(1))+1;
			}
			String insert = "Insert into justificatif values (" + max + ",'" + motif + "','" + debut + "','" + fin
					+ "','" + secre + "','" + log + "');";
			System.out.println(insert);
			ResultSet rs2 = state.executeQuery(insert);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
