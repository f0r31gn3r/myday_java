package lv.localhost.MyDay.Model;

import java.util.Date;

public class Comment {
	private int commentID;
	private int postID;
	private int author;
	private String body;
	private Date created;

	public Comment() {
	}

	public Comment(int commentID, int postID, int author, String body,
			Date created) {
		setCommentID(commentID);
		setPostID(postID);
		setAuthor(author);
		setBody(body);
		setCreated(created);
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}