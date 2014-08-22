package lv.localhost.MyDay.DAO;

import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

public interface AccountDAO {

	int getIDByName(String name) throws DBException;
	
	boolean accountExists(String login) throws DBException;
	
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
