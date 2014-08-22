package lv.localhost.MyDay.DAO;

import java.util.List;

import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

public interface AccountDAO {

	int getIDByLogin(String login) throws DBException;
	String getLoginByID(int id ) throws DBException;
	
	List<Account> getAllAccounts() throws DBException;
	List<Account> getAllAccounts(int from, int amount) throws DBException;
	
	boolean accountExists(String login) throws DBException;
	boolean accountExists(String login, String password) throws DBException;
	
	int createAccount(Account a) throws DBException;
	int createAccount(String login, String password, String firstName, String lastName) throws DBException;
	
	boolean removeAccount(Account a) throws DBException;
	boolean removeAccount(String login) throws DBException;
	boolean removeAccount(int accountID) throws DBException;

	
	boolean updateAccount(Account a) throws DBException;
	
	boolean updateAccount(int accountID, String password, String login, String firstName, String lastName) throws DBException;
	
	Account initAccount(String login)  throws DBException;
	Account initAccount(int accountID)  throws DBException;
}
