package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Article;
import dao.ArticleDao;
import dao.ArticleDaoImpl;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Houssni Ouchad
	private ArticleDao article;

	public void init() throws ServletException {

		article = new ArticleDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertArticle(request, response);
				break;
			case "/delete":
				deleteArticle(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateArticle(request, response);
				break;
			default:
				listArticle(request, response);
				break;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}

	private void listArticle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		List<Article> listArticle = article.getAll();
		request.setAttribute("listArticle", listArticle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listArticle.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("formArticle.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		Article existingUser = article.getArticlebyID(idArticle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
		request.setAttribute("article", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertArticle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {

		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		String nomArticle = request.getParameter("nomArticle");
		String DescriptionArticle = request.getParameter("DescriptionArticle");
		String EtatArticle = request.getParameter("EtatArticle");
		article.sauveArticle(idArticle, nomArticle, DescriptionArticle, EtatArticle);
		response.sendRedirect("list");
	}

	private void updateArticle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		String nomArticle = request.getParameter("nomArticle");
		String DescriptionArticle = request.getParameter("DescriptionArticle");
		String EtatArticle = request.getParameter("EtatArticle");
		article.update(idArticle, nomArticle, DescriptionArticle, EtatArticle);
		response.sendRedirect("list");
	}

	private void deleteArticle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		article.deleteArticle(idArticle);
		response.sendRedirect("list");

	}

}
