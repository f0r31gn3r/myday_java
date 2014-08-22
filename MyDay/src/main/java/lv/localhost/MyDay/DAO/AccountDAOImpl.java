package lv.localhost.MyDay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

public class AccountDAOImpl extends DAOImpl implements AccountDAO {
	
	@Override
	public int getIDByName(String login) throws DBException{
		Connection connection = null;
		int result =0;
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select ACCOUNT_ID from ACCOUNT where upper(LOGIN) = ?");
			preparedStatement.setString(1, login.toUpperCase() );
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				result =resultSet.getInt(1);
			}		
		} catch (Throwable e) {
			System.out.println("Exception while execute AccountDAOImpl.getIDByName() ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public int createAccount(Account a) throws DBException {
		Connection connection = null;
		int result =  0;
		
		int createdRowCount=0;
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into ACCOUNT (LOGIN, PASSWORD, FIRST_NAME, LAST_NAME  ) values (?,?,?,?)");
			preparedStatement.setString(1, a.getLogin());
			preparedStatement.setString(2, a.getPassword());
			preparedStatement.setString(3, a.getFirstName());
			preparedStatement.setString(4, a.getLastName());
			
			
			createdRowCount = preparedStatement.executeUpdate();
			
			if (createdRowCount == 1) {
				preparedStatement = connection
					.prepareStatement("select LAST_INSERT_ID()");

				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()){
					result = rs.getInt(1);
				}
			}
	
		} catch (Throwable e) {
			System.out.println("Exception while execute AccountDAOImpl.createAccount(Account a) ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public int createAccount(String login, String password,  
			String firstName, String lastName) throws DBException {
		
		Connection connection = null;
		int result =  0;
		
		int createdRowCount=0;
		
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into ACCOUNT (LOGIN, PASSWORD, FIRST_NAME, LAST_NAME  ) values (?,?,?,?)");
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, lastName);
			
			createdRowCount = preparedStatement.executeUpdate();
			
			if (createdRowCount == 1) {
				preparedStatement = connection
					.prepareStatement("select LAST_INSERT_ID()");

				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()){
					result = rs.getInt(1);
				}
			}
	
		} catch (Throwable e) {
			System.out.println("Exception while execute AccountDAOImpl.createAccount(Account a) ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public boolean removeAccount(Account a) throws DBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAccount(String nickName) throws DBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAccount(int accountID) throws DBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(Account a) throws DBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(int accountID, String login, String password,
			String firstName, String lastName) throws DBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account initAccount(String nickName) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account initAccount(int accountID) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean accountExists(String login) throws DBException {
		Connection connection = null;
		boolean result =  false;
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select count(1) from ACCOUNT where login =?");
			preparedStatement.setString(1, login);
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				result = ( rs.getInt(1) == 0 ? false : true);				
			}
	
		} catch (Throwable e) {
			System.out.println("Exception while execute AccountDAOImpl.accountExists(String login) ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return result;	}

}
