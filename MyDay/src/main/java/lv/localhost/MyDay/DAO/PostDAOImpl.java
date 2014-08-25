package lv.localhost.MyDay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lv.localhost.MyDay.Model.Post;
import lv.localhost.MyDay.common.DBException;

public class PostDAOImpl extends DAOImpl implements PostDAO{

	@Override
	public boolean createPost(Post p) throws DBException {
		Connection connection = null;
		int createdRowCount=0;
		
		try {
			connection = getConnection();
			
			java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into POSTS (TITLE, AUTHOR, BODY, CREATED ) values (?,?,?,NOW())");
			preparedStatement.setString(1, p.getTitle());
			preparedStatement.setInt(2, p.getAuthorID());
			preparedStatement.setString(3, p.getBody());
			
			createdRowCount = preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement("SELECT * FROM POSTS ORDER BY POST_ID DESC LIMIT 1");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				p.setPostID(resultSet.getInt(1));
				p.setCreated(resultSet.getTimestamp(3));
				System.out.println(p.getCreated());
			}
			
			p.setCreated(sqlDate);
			
	
		} catch (Throwable e) {
			System.out.println("Exception while execute PostDAOImpl.createPost() ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

	@Override
	public boolean removePost(int postID) throws DBException {
		Connection connection = null;
		int createdRowCount=0;
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete from POSTS where POST_ID = ?");
			preparedStatement.setInt(1, postID);
			
			createdRowCount = preparedStatement.executeUpdate();
			
	
		} catch (Throwable e) {
			System.out.println("Exception while execute PostDAOImpl.removePost() ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

	@Override
	public boolean updatePost(Post p) throws DBException {
		Connection connection = null;
		int createdRowCount=0;
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("update POSTS set TITLE = ?, AUTHOR = ?, BODY = ?, LAST_MODIFIED = NOW() where POST_ID = ?");
			preparedStatement.setString(1, p.getTitle());
			preparedStatement.setInt(2, p.getAuthorID());
			preparedStatement.setString(3, p.getBody());
			preparedStatement.setInt(4, p.getPostID());
			
			createdRowCount = preparedStatement.executeUpdate();
			
	
		} catch (Throwable e) {
			System.out.println("Exception while execute PostDAOImpl.updatePost() ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return (createdRowCount > 0 ? true : false);
	}

	@Override
	public Post findPost(int postID) throws DBException {
		Connection connection = null;
		Post result = null;
		
		try {
			connection = getConnection();
			
			
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from POSTS where POST_ID = ?");
			preparedStatement.setInt(1, postID);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){		
				result = new Post(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(5), resultSet.getString(6));
			}		
		} catch (Throwable e) {
			System.out.println("Exception while execute PostDAOImpl.findPosts() ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Post> findLatestPosts() throws DBException {
		Connection connection = null;
		List <Post> results = new ArrayList <Post> ();
		
		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM POSTS ORDER BY CREATED DESC LIMIT 10");
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){		
				results.add(new Post(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(5), resultSet.getString(6)));
			}		
			
		} catch (Throwable e) {
			System.out.println("Exception while execute PostDAOImpl.findLatestPosts() ");
			e.printStackTrace();
			throw new DBException(e);
		}
		finally {
			closeConnection(connection);
		}
		
		return results;
	}
}
