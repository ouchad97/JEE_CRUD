package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

	String PILOTE = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:8000/JeeArticle?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String dbUser = "root";
	static String dbPass = "admin";
	static Connection connection = null;

	// Connexion a la base de donnees
	public static Connection getMyConnexion() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url, dbUser, dbPass);
		
		return connection;
	}

}