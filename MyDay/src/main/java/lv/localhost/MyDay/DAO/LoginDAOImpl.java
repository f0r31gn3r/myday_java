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
					.println("Exception while execute PostDAOImpl.createPost() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(conn);
		}
		return loginList;
	}

	// public String getUserNameByID(int id) {
	// }
	//
	// public int getIDByUsername(String username) {
	// }
	//
	// public Date getCreatedByID(int id) {
	// }
	//
	// public Date getLastVisitedByID(int id) {
	// }
	//
	// public Date getCreatedByUserName(String username) {
	// }
	//
	// public Date getLastVisitedByUserName(String username) {
	// }
	//
	// public void newAccount(Login login) {
	// }
}
