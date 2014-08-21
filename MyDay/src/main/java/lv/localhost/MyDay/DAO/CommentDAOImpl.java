package lv.localhost.MyDay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import lv.localhost.MyDay.Model.Comment;
import lv.localhost.MyDay.common.DBException;

public class CommentDAOImpl extends DAOImpl implements CommentDAO {

	@Override
	public boolean createComment(Comment c) throws DBException {
		Connection connection = null;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into COMMENT (POST_ID, AUTHOR, BODY) values (?,?,?)");
			preparedStatement.setInt(1, c.getPostID());
			preparedStatement.setInt(2, c.getAuthor());
			preparedStatement.setString(3, c.getBody());

			createdRowCount = preparedStatement.executeUpdate();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getByName() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

	@Override
	public boolean createComment(int postID, int author, String body)
			throws DBException {
		Connection connection = null;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into COMMENT (POST_ID, AUTHOR, BODY) values (?,?,?)");
			preparedStatement.setInt(1, postID);
			preparedStatement.setInt(2, author);
			preparedStatement.setString(3, body);

			createdRowCount = preparedStatement.executeUpdate();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getByName() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

	@Override
	public boolean removeComment(Comment c) throws DBException {
		Connection connection = null;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from COMMENTS where COMMENT_ID = ?");
			preparedStatement.setInt(1, c.getCommentID());

			createdRowCount = preparedStatement.executeUpdate();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getByName() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

	@Override
	public boolean removeComment(int commentID) throws DBException {
		Connection connection = null;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from COMMENTS where COMMENT_ID = ?");
			preparedStatement.setInt(1, commentID);

			createdRowCount = preparedStatement.executeUpdate();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getByName() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

	@Override
	public Comment getCommentByID(int commentID) throws DBException {
		/*Connection connection = null;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM COMMENTS WHERE ID = ?");
			preparedStatement.setInt(1, commentID);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			Comment temp = new Comment(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4));

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getByName() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);*/
		return null;
	}

	/*
	 * public Account findAccount(int id) throws AccountDAOException { Account
	 * temp = null; String selectSQL = "SELECT * FROM Account WHERE ID = ?"; try
	 * { PreparedStatement ps =
	 * conn.prepareStatement("SELECT * FROM Account WHERE ID = ?"); ps.setInt(1,
	 * id); ResultSet rs = ps.executeQuery(); rs.next(); temp = new
	 * AccountImpl(rs.getInt(1), rs.getString(2), rs.getString(3),
	 * rs.getString(4));
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return temp; }
	 */

	@Override
	public List<Comment> getCommentList(int postID) {
		// TODO Auto-generated method stub
		return null;
	}

}
