package lv.localhost.MyDay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

public class AccountDAOImpl extends DAOImpl implements AccountDAO {
	
	@Override
	public String getByName(String name) throws DBException{
		Connection connection = null;
		String result ="";
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from ACCOUNT where first_name = ?");
			preparedStatement.setString(1, name);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				result =resultSet.getInt(1) + " " + resultSet.getString(2)  + " " +
						resultSet.getString(3) + " " + resultSet.getString(4);
			}		
		} catch (Throwable e) {
			System.out.println("Exception while execute AccountDAOImpl.getByName() ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public boolean createAccount(Account a) throws DBException {
		Connection connection = null;
		boolean result = false;
		int createdRowCount=0;
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into ACCOUNT (NICKNAME,FIRST_NAME, LAST_NAME ) values (?,?,?)");
			preparedStatement.setString(1, a.getNickname());
			preparedStatement.setString(2, a.getFirstName());
			preparedStatement.setString(3, a.getLastName());
			
			createdRowCount = preparedStatement.executeUpdate();
			
	
		} catch (Throwable e) {
			System.out.println("Exception while execute AccountDAOImpl.getByName() ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

	@Override
	public boolean createAccount(String nickName, String firstName,
			String lastName) throws DBException {
		// TODO Auto-generated method stub
		return false;
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
	public boolean updateAccount(int accountID, String nickname,
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

}
