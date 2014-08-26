package lv.localhost.MyDay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lv.localhost.MyDay.Model.Visit;
import lv.localhost.MyDay.common.DBException;

public class VisitDAOImpl extends DAOImpl implements VisitDAO {

	@Override
	public boolean createVisit(Visit v) throws DBException {

		Connection connection = null;

		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into VISITORS (URL, ACCOUNT_ID, REFERER, TIME_VISITED ) "
							+ "	values (?,?,?,NOW())");
			preparedStatement.setString(1, v.getUrl());
			preparedStatement.setInt(2, v.getAccountID());
			preparedStatement.setString(3, v.getReferer());

			createdRowCount = preparedStatement.executeUpdate();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute VisitDAOImpl.createVisit() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

}