package verif_client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import users_package.Etudiant;
import users_package.Professeur;
import users_package.Secretaire;


/**
 * Servlet implementation class Verif_Authent
 */
@WebServlet("/Verif_Authent")
public class Verif_Authent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp =  request.getParameter("password");
		login = StringEscapeUtils.escapeHtml4(login);
		mdp = StringEscapeUtils.escapeHtml4(mdp);
		/**
		 * Connection a la base
		 */
		// si le resultat dit que cette personne est un etudiant
		request.setAttribute("client",new Etudiant(login, mdp));
		//si cette personne est une secrataire
		request.setAttribute("client", new Secretaire(login, mdp));
		//si cette personne est un prof
		request.setAttribute("client", new Professeur(login, mdp));
	}

}
