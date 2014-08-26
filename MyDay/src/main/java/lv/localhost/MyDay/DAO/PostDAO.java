package lv.localhost.MyDay.DAO;

import java.util.List;

import lv.localhost.MyDay.Model.Post;
import lv.localhost.MyDay.common.DBException;

public interface PostDAO {

	/**
	 * This method will attempt to create and insert a Post into the
	 * database. The method will throw an DBException if errors during execution
	 * are encountered.
	 * 
	 * @param Post
	 *            - the Post object to insert into database
	 * 
	 * @return true if visit inserted successfully
	 */
	boolean createPost(Post p) throws DBException;

	
	/**
	 * This method will attempt to remove a Post from database. The method
	 * will throw an DBException if errors during execution are encountered.
	 * 
	 * @param postID
	 *            - the ID of the Post which must be removed
	 * 
	 * @return TRUE if Post is removed from the database successfully or
	 *         FALSE if Post with such ID is not found
	 */	
	boolean removePost(int postID) throws DBException;

	
	/**
	 * This method will attempt to update existing Post data in database.
	 * Method is using postID to determine which post should be updated 
	 * The method will throw an DBException if errors during execution are encountered.
	 * 
	 * @param Post
	 *            - the Post object which must be updated
	 * 
	 * @return TRUE if Post is updated successfully or
	 *         FALSE if Post with such ID is not found
	 */		
	boolean updatePost(Post p) throws DBException;

	
	/**
	 * Returns a specific Post instance represented by the specified ID or
	 * null if no match is found. The method will throw an DBException if errors
	 * during execution are encountered.
	 * 
	 * @param postID
	 *            - the ID of the Post to return
	 * 
	 * @return an Post object
	 */
	Post findPost(int postID) throws DBException;

	
	/**
	 * Returns a list of Post objects that are stored in database.
	 * This will return an empty List if no match is found. The method will
	 * throw an DBException if errors during execution are encountered.
	 * 
	 * @param --
	 * 
	 * @return a List of Post objects
	 */
	List<Post> findLatestPosts() throws DBException;

	
	/**
	 * Returns a list of Post objects that are having concrete text string.
	 * This will return an empty List if no match is found. The method will
	 * throw an DBException if errors during execution are encountered.
	 * 
	 * @param key
	 * 				- String to search by
	 * 
	 * @return a List of Post objects
	 */
	List<Post> searchPost(String key) throws DBException;

}
