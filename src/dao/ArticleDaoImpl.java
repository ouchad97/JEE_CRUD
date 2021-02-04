package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.Article;

public class ArticleDaoImpl implements ArticleDao {
	Statement statement = null;

	public List<Article> getAll() throws ClassNotFoundException, SQLException {

		List<Article> article = new ArrayList<Article>();

		statement = database.getMyConnexion().createStatement();

		// - selectionner la table 
		ResultSet resultat;
		String requete = "Select * From Article";

		resultat = statement.executeQuery(requete);

		while (resultat.next()) {
			int id = resultat.getInt("idArticle");
			String nomArticle = resultat.getString(2);
			String DescriptionArticle = resultat.getString(3);
			String EtatArticle = resultat.getString(4);

			// Creer l'objet Article
			Article A = new Article(id, nomArticle, DescriptionArticle, EtatArticle);
			article.add(A);
			System.out.println(A);
		}
				
		return article;
	}

	// get Article by id
	@Override
	public Article getArticlebyID(int id) throws ClassNotFoundException, SQLException {
		Article article = null;
		String requete = "Select * From Article Where idArticle= ?";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete);

		statement.setLong(1, id);
		ResultSet resultat = statement.executeQuery();

		if (resultat.next()) {
			String nom = resultat.getString("nomArticle");
			String Description = resultat.getString("DescriptionArticle");
			String Etat = resultat.getString("EtatArticle");

			article = new Article(id, nom, Description, Etat);
		}

		return article;
	}
	// ajout

	@Override
	public Article sauveArticle(int idArticle, String nomArticle, String DescriptionArticle, String EtatArticle)
			throws ClassNotFoundException, SQLException {
		Article reponse = null;
		// int id = -1;

		String requete = "Insert into Article (idArticle, nomArticle, DescriptionArticle, EtatArticle) Values (?, ?, ?, ?)";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

		statement.setInt(1, idArticle);
		statement.setString(2, nomArticle);
		statement.setString(3, DescriptionArticle);
		statement.setString(4, EtatArticle);
		statement.executeUpdate();

		ResultSet rs = statement.getGeneratedKeys();

		if (rs.next()) {
			idArticle = rs.getInt(1);
		}
		reponse = new Article(idArticle, nomArticle, DescriptionArticle, EtatArticle);

		return reponse;
	}

	// Update Article

	@Override
	public int update(int idArticle, String nomArticle, String DescriptionArticle, String EtatArticle)
			throws ClassNotFoundException, SQLException {

		String requete = "Update Article set nomArticle = ?, DescriptionArticle = ?,EtatArticle = ?  Where idArticle = ?";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, nomArticle);
		statement.setString(2, DescriptionArticle);
		statement.setString(3, EtatArticle);
		statement.setInt(4, idArticle);

		return statement.executeUpdate();
	}

	@Override
	public int deleteArticle(int idArticle) throws ClassNotFoundException, SQLException {
		String requete = "Delete from Article Where idArticle = ?";
		PreparedStatement statement = database.getMyConnexion().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, idArticle);
		return statement.executeUpdate();

	}

}
