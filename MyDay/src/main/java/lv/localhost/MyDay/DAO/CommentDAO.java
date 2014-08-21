package lv.localhost.MyDay.DAO;

import java.util.List;

import lv.localhost.MyDay.Model.Comment;
import lv.localhost.MyDay.common.DBException;

public interface CommentDAO {

	boolean createComment(int postID, int author, String body) throws DBException;
	boolean removeComment(int commentID) throws DBException;
	Comment getCommentByID(int commentID) throws DBException;
	List<Comment> getCommentList(int postID) throws DBException;
}