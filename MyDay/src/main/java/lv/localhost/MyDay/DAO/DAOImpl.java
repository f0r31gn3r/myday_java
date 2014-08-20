package lv.localhost.MyDay.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lv.localhost.MyDay.common.DBException;

public class DAOImpl {

	public static final String DB_CONFIG_FILE = "/lv/localhost/MyDay/common/myday.properties";

	private String dbUrl = null;
	private String userName = null;
	private String password = null;

	public DAOImpl() {
		registerJDBCDriver();
		initDatabaseConnectionProperties();
	}

	private void registerJDBCDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception while registering JDBC driver.");
			e.printStackTrace();
		}
	}

	private void initDatabaseConnectionProperties() {
		Properties properties = new Properties();
		System.out.print(this.getClass());
		try {
			InputStream test = this.getClass().getResourceAsStream(
					DB_CONFIG_FILE);
			properties.load(test);

			dbUrl = properties.getProperty("dbUrl");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");

		} catch (IOException e) {
			System.out
					.println("Exception while reading JDBC configuration file = "
							+ DB_CONFIG_FILE);
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws DBException {

		try {
			return DriverManager.getConnection(dbUrl, userName, password);
		} catch (SQLException e) {
			System.out
					.println("Exception while getting connection to database");
			e.printStackTrace();
			throw new DBException(e);
		}
	}

	protected void closeConnection(Connection connection) throws DBException {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out
					.println("Exception while closing connection to database");
			e.printStackTrace();
			throw new DBException(e);
		}
	}

}
