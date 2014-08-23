package lv.localhost.MyDay.DAO;

import java.util.List;

import lv.localhost.MyDay.Model.Post;
import lv.localhost.MyDay.common.DBException;

public interface PostDAO {
	
	boolean createPost(Post p) throws DBException;
	
	boolean removePost(int postID) throws DBException;
	
	boolean updatePost(Post p) throws DBException;
	
	Post findPosts(int postID) throws DBException;
	List <Post> findLatestPosts() throws DBException;

}
