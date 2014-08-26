package lv.localhost.MyDay.DAO;

import java.util.List;

import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

public interface AccountDAO {

	
	/**
	 * Returns a specific Account ID represented by the specified login or 0 if
	 * no match is found. The method will throw an DBException if errors during
	 * execution are encountered.
	 * 
	 * @param login
	 *            - login of Author
	 * 
	 * @return an ID of author
	 */
	int getIDByLogin(String login) throws DBException;

	
	/**
	 * Returns TRUE if Account with specified login exists or FALSE if Account
	 * doesn't exists. The method will throw an DBException if errors during
	 * execution are encountered.
	 * 
	 * @param login
	 *            - login of Author
	 * 
	 * @return TRUE or FALSE
	 */
	boolean accountExists(String login) throws DBException;

	
	/**
	 * Returns TRUE if Account with specified login and password exists or FALSE
	 * if Account doesn't exists. The method will throw an DBException if errors
	 * during execution are encountered.
	 * 
	 * @param login
	 *            - login of Author
	 * @param password
	 *            - password of Author
	 * 
	 * @return TRUE or FALSE
	 */
	boolean accountExists(String login, String password) throws DBException;

	
	/**
	 * This method will attempt to create and insert an Account into the
	 * database. The method will throw an DBException if errors during execution
	 * are encountered.
	 * 
	 * @param a
	 *            - an instance of Account
	 * 
	 * @return the ID of the entry in the database
	 */
	int createAccount(Account a) throws DBException;

	
	/**
	 * Returns a specific Account instance represented by the specified login or
	 * null if no match is found. The method will throw an DBException if errors
	 * during execution are encountered.
	 * 
	 * @param login
	 *            - login of Author
	 * 
	 * @return an Account object
	 */
	Account initAccount(String login) throws DBException;

	// String getLoginByID(int id) throws DBException;

	// List<Account> getAllAccounts() throws DBException;

	// List<Account> getAllAccounts(int from, int amount) throws DBException;

	// int createAccount(String login, String password, String firstName,
	// String lastName) throws DBException;

	// boolean removeAccount(Account a) throws DBException;

	// boolean removeAccount(String login) throws DBException;

	// boolean removeAccount(int accountID) throws DBException;

	// boolean updateAccount(Account a) throws DBException;

	// boolean updateAccount(int accountID, String password, String firstName,
	// String lastName) throws DBException;

	// Account initAccount(int accountID) throws DBException;
}
