package lv.localhost.MyDay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lv.localhost.MyDay.Model.Comment;
import lv.localhost.MyDay.common.DBException;

public class CommentDAOImpl extends DAOImpl implements CommentDAO {

	@Override
	public boolean createComment(int postID, int author, String body)
			throws DBException {
		Connection connection = null;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into COMMENTS (POST_ID, AUTHOR, BODY, CREATED) values (?,?,?, NOW())");
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
	public boolean removeComment(int commentID) throws DBException {
		Connection connection = null;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM COMMENTS WHERE COMMENT_ID = ?");
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
		Connection connection = null;
		Comment temp;
		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM COMMENTS WHERE COMMENT_ID = ?");
			preparedStatement.setInt(1, commentID);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			temp = new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					rs.getString(4), rs.getDate(5));

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getCommentByID() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return temp;
	}

	@Override
	public List<Comment> getCommentList(int postID) throws DBException {
		Connection connection = null;
		List<Comment> results = new ArrayList<Comment>();
		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM COMMENTS WHERE POST_ID = ?");
			preparedStatement.setInt(1, postID);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				results.add(new Comment(rs.getInt(1), rs.getInt(2), rs
						.getInt(3), rs.getString(4), rs.getDate(5)));
			}
			rs.close();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute AccountDAOImpl.getByName() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return results;
	}

}
