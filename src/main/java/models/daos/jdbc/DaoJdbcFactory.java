package models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DaoJdbcFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";

	private static final String URL = "jdbc:mysql://localhost:3306/miwjee";

	private static final String USER = "root";

	private static final String PASS = "";

	private static Connection connection;

	public static Connection getConnection() {
		try {
			if (connection == null || !connection.isValid(0)) {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USER, PASS);
			}
		} catch (ClassNotFoundException e) {
			LogManager.getLogger(DaoJdbcFactory.class).error("Problemas con el driver: " + e.getMessage());
		} catch (SQLException e) {
			LogManager.getLogger(DaoJdbcFactory.class).error("Problemas con la BD: " + e.getMessage());
		}
		return connection;
	}

}
