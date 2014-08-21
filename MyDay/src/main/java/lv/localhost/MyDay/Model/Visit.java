package lv.localhost.MyDay.Model;

import java.util.Date;

public class Visit {
	
	private String url;
	private String from;
	private Date timestamp;
	private int accountID;

	public Visit(String url, String from) {
		setUrl(url);
		setFrom(from);
		setTimestamp(new Date());
		setAccountID(0);
	}
	
	public Visit(String url, String from, Date timestamp) {
		setUrl(url);
		setFrom(from);
		setTimestamp(timestamp);
		setAccountID(0);
	}
	
	public Visit(String url, String from, Date timestamp, int accountID) {
		setUrl(url);
		setFrom(from);
		setTimestamp(timestamp);
		setAccountID(accountID);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
}
