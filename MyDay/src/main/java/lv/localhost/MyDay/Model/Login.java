package lv.localhost.MyDay.Model;

import java.sql.Date;

public class Login {
	private int accountID;
	private String username;
	private String password;
	private Date created;
	private Date date;

	public Login(int acc, String user, String pass, Date created, Date date) {
		setAccountID(acc);
		setUsername(user);
		setPassword(pass);
		setCreated(created);
		setDate(date);
	}

	public Login(String user, String pass) {
		username = user;
		password = pass;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
