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
	public int createComment(int postID, int author, String body)
			throws DBException {
		int commentID = 0;
		Connection connection = null;
		int createdRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO COMMENTS (POST_ID, AUTHOR, BODY, CREATED) VALUES (?,?,?, NOW())");
			preparedStatement.setInt(1, postID);
			preparedStatement.setInt(2, author);
			preparedStatement.setString(3, body);

			createdRowCount = preparedStatement.executeUpdate();

			if (createdRowCount == 1) {
				preparedStatement = connection
						.prepareStatement("SELECT LAST_INSERT_ID()");
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					commentID = rs.getInt(1);
				}
				rs.close();
			}
			preparedStatement.close();

		} catch (Throwable e) {
			System.out					.println("Exception while execute CommentDAOImpl.createComment() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return commentID;
	}

	@Override
	public boolean removeComment(int commentID) throws DBException {
		Connection connection = null;
		int removedRowCount = 0;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM COMMENTS WHERE COMMENT_ID = ?");
			preparedStatement.setInt(1, commentID);

			removedRowCount = preparedStatement.executeUpdate();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute CommentDAOImpl.removeComment() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return (removedRowCount > 0 ? true : false);
	}

	@Override
	public Comment getCommentByID(int commentID) throws DBException {
		Connection connection = null;
		Comment temp = null;

		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT COMMENT_ID, POST_ID, AUTHOR, BODY, CREATED FROM COMMENTS WHERE COMMENT_ID = ?");
			preparedStatement.setInt(1, commentID);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			temp = new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					rs.getString(4), rs.getDate(5));
			
		} catch (Throwable e) {
			System.out
					.println("Exception while execute CommentDAOImpl.getCommentByID() ");
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
					.prepareStatement("SELECT COMMENT_ID, POST_ID, AUTHOR, BODY, CREATED FROM COMMENTS WHERE POST_ID = ?");
			preparedStatement.setInt(1, postID);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				results.add(new Comment(rs.getInt(1), rs.getInt(2), rs
						.getInt(3), rs.getString(4), rs.getDate(5)));
			}
			rs.close();

		} catch (Throwable e) {
			System.out
					.println("Exception while execute CommentDAOImpl.getCommentList() ");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return results;
	}

}