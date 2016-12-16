package verif_client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import users_package.Etudiant;
import users_package.ListerAbscencesEtu;
import users_package.Professeur;
import users_package.Secretaire;

/**
 * Servlet implementation class Verif_Authent
 */
@WebServlet("/Verif_Authent")
public class Verif_Authent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("password");
		login = StringEscapeUtils.escapeHtml4(login);
		mdp = StringEscapeUtils.escapeHtml4(mdp);
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://psqlserv/n3p1";
			String nom = "benoistv";
			String passwd = "moi";
			Connection con = DriverManager.getConnection(url, nom, passwd);

			Statement state = con.createStatement();
			String query = "SELECT * from personne where login='" + login + "' and mdp='" + mdp + "'";
			ResultSet rs = state.executeQuery(query);

			if (rs.next()) {
				System.out.println("ok");
				HttpSession session = request.getSession(true);
				System.out.println(rs.getString(5));
				if (rs.getString(5).equals("secretaire")) {
					// si cette personne est une secrataire
					session.setAttribute("client", new Secretaire(login, mdp));
					response.sendRedirect(
							/* page liste abscences avec modif justif */"SaiseJustif");
				} else if (rs.getString(5).equals("etudiant")) {
					// si le resultat dit que cette personne est un etudiant
					session.setAttribute("client", new Etudiant(login, mdp));
					response.sendRedirect(/* page liste abscences */"ListerAbscencesEtu");
				} else if (rs.getString(5).equals("prof")) {
					// si cette personne est un prof
					session.setAttribute("client", new Professeur(login, mdp));
					response.sendRedirect(/* page ajout abscences */"");
				} else {
					System.out.println("redirect");
					response.sendRedirect("index.html");
				}

			} else {
				response.sendRedirect("index.html");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
