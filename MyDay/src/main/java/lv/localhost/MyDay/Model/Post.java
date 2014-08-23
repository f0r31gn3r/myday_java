package lv.localhost.MyDay.Model;

import java.util.Date;

public class Post {
	
	private int postID;
	private String title;
	private Date created;
	private Date modified;
	private int authorID;
	private String body;
	
	public Post(){
		
	}
	
	public Post(int postID, String title, Date created, int authorID, String body){
		setTitle(title);
		setCreated(created);
		setAuthorID(authorID);
		setBody(body);
	}
	
	public Post(int postID, String title, int authorID, String body){
		setTitle(title);
		setAuthorID(authorID);
		setBody(body);
		setPostID(postID);
	}
	
	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	

}
