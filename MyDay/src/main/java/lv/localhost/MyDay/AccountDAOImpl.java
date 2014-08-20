package lv.localhost.MyDay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAOImpl extends DAOImpl implements AccountDAO {
	
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

}
