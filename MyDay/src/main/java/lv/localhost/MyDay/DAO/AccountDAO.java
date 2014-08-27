package lv.localhost.MyDay.DAO;

import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

public interface AccountDAO {

	/**
	 * Returns a specific Account ID represented by the specified Login or 0 if
	 * no match is found. The method will throw an DBException if errors during
	 * execution are encountered.
	 * 
	 * @param login
	 *            - login of Author
	 * 
	 * @return an ID of Author
	 */
	int getIDByLogin(String login) throws DBException;

	/**
	 * Returns a specific Login represented by the specified Account ID or empty
	 * String if no match is found. The method will throw an DBException if
	 * errors during execution are encountered.
	 * 
	 * @param id
	 *            - ID of Author
	 * 
	 * @return a login of Author
	 */
	String getLoginByID(int id) throws DBException;

	/**
	 * Returns TRUE if Account with specified Login exists or FALSE if Account
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
	 * Returns TRUE if Account with specified Login and Password exists or FALSE
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
	 * Returns a specific Account instance represented by the specified Login or
	 * null if no match is found. The method will throw an DBException if errors
	 * during execution are encountered.
	 * 
	 * @param login
	 *            - login of Author
	 * 
	 * @return an Account object
	 */
	Account initAccount(String login) throws DBException;

	/**
	 * This method will attempt to remove an Account from database. The method
	 * will throw an DBException if errors during execution are encountered.
	 * 
	 * @param accountID
	 *            - ID of the Account witch must be removed
	 * 
	 * @return TRUE if Account is removed from the database successfully or
	 *         FALSE if Account with such ID is not found
	 */
	boolean removeAccount(int accountID) throws DBException;

}
