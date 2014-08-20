package lv.localhost.MyDay.DAO;

import lv.localhost.MyDay.common.DBException;
import lv.localhost.MyDay.Model.Post;

public interface PostDAO {
	
	boolean createPost(Post p) throws DBException;
	
	boolean removePost(Post p) throws DBException;
	boolean removePost(int postID) throws DBException;
	
	boolean updatePost(Post p) throws DBException;
	
	String findPost(Post p) throws DBException;
	String findPost(int postID) throws DBException;
	

}
