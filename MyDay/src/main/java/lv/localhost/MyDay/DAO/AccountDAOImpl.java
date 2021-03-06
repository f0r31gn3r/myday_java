package lv.localhost.MyDay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

public class AccountDAOImpl extends DAOImpl implements AccountDAO {

	@Override
	public int getIDByLogin(String login) throws DBException {
		Connection connection = null;
		int result = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("select ACCOUNT_ID from ACCOUNT where upper(LOGIN) = ?");
			preparedStatement.setString(1, login.toUpperCase());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getIDByLogin() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public String getLoginByID(int id) throws DBException {
		Connection connection = null;
		String result = "";

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("select LOGIN from ACCOUNT where ACCOUNT_ID = ?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getString(1);
			}
		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getLoginByID() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public boolean accountExists(String login) throws DBException {
		Connection connection = null;
		boolean result = false;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("select count(1) from ACCOUNT where login =?");
			preparedStatement.setString(1, login);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				result = (rs.getInt(1) == 0 ? false : true);
			}

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.accountExists(String login) ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public boolean accountExists(String login, String password)
			throws DBException {
		Connection connection = null;
		boolean result = false;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("select count(1) from ACCOUNT where login =? and password = ?");
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				result = (rs.getInt(1) == 0 ? false : true);
			}

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.accountExists(String login, String password) ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public int createAccount(Account a) throws DBException {
		Connection connection = null;
		int result = 0;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into ACCOUNT (LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, CREATED, LAST_VISITED  ) values (?,?,?,?, NOW(), NOW() )");
			preparedStatement.setString(1, a.getLogin());
			preparedStatement.setString(2, a.getPassword());
			preparedStatement.setString(3, a.getFirstName());
			preparedStatement.setString(4, a.getLastName());

			createdRowCount = preparedStatement.executeUpdate();

			if (createdRowCount == 1) {
				preparedStatement = connection
						.prepareStatement("select LAST_INSERT_ID()");

				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					result = rs.getInt(1);
				}
			}

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.createAccount(Account a) ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public Account initAccount(String login) throws DBException {
		Connection connection = null;
		Account result = null;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("select ACCOUNT_ID, LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, CREATED, LAST_VISITED from ACCOUNT where upper(LOGIN) = ?");

			preparedStatement.setString(1, login.toUpperCase());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				result = new Account(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getDate(7));
			}

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.initAccount(String login)) ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public boolean removeAccount(int accountID) throws DBException {
		Connection connection = null;
		int deletedRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from ACCOUNT where ACCOUNT_ID = ? ");

			preparedStatement.setInt(1, accountID);
			deletedRowCount = preparedStatement.executeUpdate();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.removeAccount(int accountID) ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return (deletedRowCount > 0 ? true : false);
	}

}