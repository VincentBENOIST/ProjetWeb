package users_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class menuProf
 */
@WebServlet("/menuProf")
public class menuProf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (session.getAttribute("client") == null || !(session.getAttribute("client") instanceof Professeur)) {
			// dire erreur
			res.sendRedirect("../index.html");
		} else {
			PrintWriter out = res.getWriter();
			Connection con = null;
			out.print("<!DOCTYPE html>" + "<html>" + "<head>" + "<title>Authentification</title>"
					+ "<!--source : Bootsnip.com -->" + "<meta charset='utf-8'>"
					+ "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
					+ "<meta name='viewport' content='width=device-width, initial-scale=1'>"
					+ "<link rel='stylesheet' href='CSS/bootstrap-3.3.7-dist/css/bootstrap.min.css'>"
					+ "<link rel='stylesheet' href='CSS/font-awesome-4.7.0/css/font-awesome.min.css'>"
					+ "<link rel='stylesheet' href='CSS/style.css'>" + "</head>");

			Professeur prof = (Professeur) session.getAttribute("client");
			String login = prof.getLogin();
			res.sendRedirect("AjoutAbscence.html");
		}
	}
}
