package lv.localhost.MyDay.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lv.localhost.MyDay.common.DBException;

public class DAOImpl {

	/**
	 * Constant storing full path to properties file containing database connection data
	 */
	public static final String DB_CONFIG_FILE = "/lv/localhost/MyDay/common/myday.properties";

	private String dbUrl = null;
	private String userName = null;
	private String password = null;

	public DAOImpl() {
		registerJDBCDriver();
		initDatabaseConnectionProperties();
	}

	
	/**
	 * This method will register MySQL driver  
	 * The method will throw an ClassNotFoundException if 
	 * proper driver is not found
	 * 
	 * @param none
	 * @return void
	 */
	
	private void registerJDBCDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception while registering JDBC driver.");
			e.printStackTrace();
		}
	}

	/**
	 * This method will read database credentials from property file   
	 * The method will throw an IOException if errors during locating/reading  
	 * property file are encountered
	 * 
	 * @param none
	 * @return void
	 */
	
	private void initDatabaseConnectionProperties() {
		Properties properties = new Properties();
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

	
	/**
	 * This method will try to establish connection to the database using 
	 * information stored in private variables 
	 * The method will throw an SQLException if connection fails
	 * 
	 * @param none
	 * @return Connection object
	 */
	
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

	
	/**
	 * This method will close open connection provided as an argument 
	 * The method will throw an SQLException if connection fails
	 * 
	 * @param Connection object
	 * @return void
	 */
	
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
