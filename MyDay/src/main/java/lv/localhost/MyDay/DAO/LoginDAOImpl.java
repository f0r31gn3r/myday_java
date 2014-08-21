package lv.localhost.MyDay.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lv.localhost.MyDay.Model.Login;
import lv.localhost.MyDay.common.DBException;

public class LoginDAOImpl extends DAOImpl implements LoginDAO {

	private Connection conn;

	public List<Login> getAllAccounts() throws DBException {
		conn = getConnection();
		List<Login> loginList = new ArrayList<Login>();
		try {

			PreparedStatement pStmt = null;

			pStmt = conn.prepareStatement("select * from LOGIN");

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				Login login = new Login(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getDate(4), rs.getDate(5));
				loginList.add(login);

			}
		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.getAllAccounts() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
		return loginList;
	}

	public boolean checkUser(String username, String password)
			throws DBException {
		conn = getConnection();
		Login login = null;
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("select USERNAME, PASSWORD from LOGIN where USERNAME=? AND PASSWORD=?");

			pStmt.setString(1, username);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				login = new Login(rs.getString(1), rs.getString(2));

			}
		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.checkUser() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
		if (username.equals(login.getUsername())
				&& password.equals(login.getPassword())) {
			return true;
		} else
			return false;
	}

	public void newAccount(Login login) throws DBException {
		conn = getConnection();
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("insert into LOGIN (ACCOUNT_ID, USERNAME, PASSWORD, CREATED, LAST_VISITED) VALUES (?,?,?,?,?)");

			pStmt.setInt(1, login.getAccountID());
			pStmt.setString(2, login.getUsername());
			pStmt.setString(3, login.getPassword());
			pStmt.setDate(4, login.getCreated());
			pStmt.setDate(5, login.getDate());

			pStmt.executeUpdate();

			// conn.commit();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.newAccount() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
	}

	public String getUserNameByID(int id) throws DBException {
		conn = getConnection();
		Login login = null;
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("select USERNAME, PASSWORD from LOGIN where ACCOUNT_ID=?");

			pStmt.setInt(1, id);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				login = new Login(rs.getString(1), rs.getString(2));

			}
			return login.getUsername();
		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.getUserNameByID() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
	}

	public int getIDByUsername(String username) throws DBException {
		conn = getConnection();
		int id = 0;
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("select ACCOUNT_ID from LOGIN where USERNAME=?");

			pStmt.setString(1, username);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				id = rs.getInt(1);

			}
			return id;
		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.getIDByUsername() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
	}

	public Date getCreatedByID(int id) throws DBException {
		conn = getConnection();
		Date date = null;
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("select CREATED from LOGIN where ACCOUNT_ID=?");

			pStmt.setInt(1, id);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				date = rs.getDate(1);

			}
			return date;
		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.getCreatedByID() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
	}

	public Date getLastVisitedByID(int id) throws DBException {
		conn = getConnection();
		Date date = null;
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("select LAST_VISITED from LOGIN where ACCOUNT_ID=?");

			pStmt.setInt(1, id);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				date = rs.getDate(1);

			}
			return date;
		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.getLastVisitedByID() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
	}

	public Date getCreatedByUserName(String username) throws DBException {
		conn = getConnection();
		Date date = null;
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("select CREATED from LOGIN where USERNAME=?");

			pStmt.setString(1, username);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				date = rs.getDate(1);

			}
			return date;
		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.getCreatedByUserName() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
	}

	public Date getLastVisitedByUserName(String username) throws DBException {
		conn = getConnection();
		Date date = null;
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("select LAST_VISITED from LOGIN where USERNAME=?");

			pStmt.setString(1, username);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				date = rs.getDate(1);

			}
			return date;
		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.getLastVisitedByUserName() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
	}

	public void updatePassword(String username, String password)
			throws DBException {
		conn = getConnection();
		try {

			PreparedStatement pStmt = null;

			pStmt = conn
					.prepareStatement("update LOGIN set PASSWORD=? WHERE USERNAME=?");

			pStmt.setString(1, password);
			pStmt.setString(2, username);

			pStmt.executeUpdate();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute LoginDAOImpl.updatePassword() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}

	}

}
