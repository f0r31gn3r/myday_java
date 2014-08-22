package lv.localhost.MyDay.DAO;

import java.util.List;

import lv.localhost.MyDay.Model.Comment;
import lv.localhost.MyDay.common.DBException;

public interface CommentDAO {

	/**
	 * This method will attempt to create and insert a Comment into the
	 * database. The method will throw an DBException if errors during execution
	 * are encountered
	 * 
	 * @param postID
	 *            - the ID of the post to witch this new comment is related
	 * @param author
	 *            - the ID of the author witch created a comment
	 * @param body
	 *            - the comment content
	 * 
	 * @return the ID of the entry in the database
	 */
	int createComment(int postID, int author, String body) throws DBException;

	/**
	 * This method will attempt to remove a Comment from database. The method
	 * will throw an DBException if errors during execution are encountered
	 * 
	 * @param commentID
	 *            - the ID of the comment witch must be removed
	 * 
	 * @return TRUE if comment is removed from the database successfully or
	 *         FALSE if comment with such ID is not found
	 */
	boolean removeComment(int commentID) throws DBException;

	/**
	 * Returns a specific Comment instance represented by the specified ID or
	 * null if no match is found. The method will throw an HRSSystemException if
	 * errors during execution are encountered
	 * 
	 * @param commentID
	 *            - the ID of the Comment to return
	 * 
	 * @return an Comment object
	 */
	Comment getCommentByID(int commentID) throws DBException;

	/**
	 * Returns a list of Comment objects that contain the specified Post ID.
	 * This will return an empty List of no match is found. The method will
	 * throw an HRSSystemException if errors during execution are encountered.
	 * 
	 * @param postID
	 *            - the ID of the post to witch this comment is related
	 * 
	 * @return a list of Comment objects
	 */
	List<Comment> getCommentList(int postID) throws DBException;

}