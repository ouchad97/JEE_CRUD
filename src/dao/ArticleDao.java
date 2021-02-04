package dao;

import Model.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {
	public List<Article> getAll() throws ClassNotFoundException, SQLException;
	public Article getArticlebyID(int id) throws ClassNotFoundException, SQLException;
	public Article sauveArticle(int idArticle,String nomArticle, String DescriptionArticle, String EtatArticle) throws ClassNotFoundException, SQLException;
	public int  update(int idArticle, String nomArticle, String DescriptionArticle, String EtatArticle) throws ClassNotFoundException, SQLException;
	public int deleteArticle(int id) throws ClassNotFoundException, SQLException;
}
