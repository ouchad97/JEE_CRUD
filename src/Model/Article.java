package Model;

public class Article {
	private int idArticle;
	private String nomArticle;
	private String DescriptionArticle;
	private String EtatArticle;
	public Article(int idArticle, String nomArticle, String DescriptionArticle, String EtatArticle) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.DescriptionArticle = DescriptionArticle;
		this.EtatArticle = EtatArticle;
	}
	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescriptionArticle() {
		return DescriptionArticle;
	}
	public void setDescriptionArticle(String DescriptionArticle) {
		this.DescriptionArticle = DescriptionArticle;
	}
	public String getEtatArticle() {
		return EtatArticle;
	}
	public void setEtatArticle(String EtatArticle) {
		this.EtatArticle = EtatArticle;
	}
	
	
	
}
