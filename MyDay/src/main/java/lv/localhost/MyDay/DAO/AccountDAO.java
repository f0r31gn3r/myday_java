package lv.localhost.MyDay.DAO;

import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

public interface AccountDAO {

	String getByName(String name) throws DBException;
	
	
	boolean createAccount(Account a) throws DBException;
	boolean createAccount(String nickName, String firstName, String lastName) throws DBException;
	
	boolean removeAccount(Account a) throws DBException;
	boolean removeAccount(String nickName) throws DBException;
	boolean removeAccount(int accountID) throws DBException;

	
	boolean updateAccount(Account a) throws DBException;
	
	boolean updateAccount(int accountID, String nickname, String firstName, String lastName) throws DBException;
	
	Account initAccount(String nickName)  throws DBException;
	Account initAccount(int accountID)  throws DBException;
}
