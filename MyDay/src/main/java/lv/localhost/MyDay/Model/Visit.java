package lv.localhost.MyDay.Model;

import java.util.Date;

public class Visit {
	
	private String url;
	private String referer;
	private Date timestamp;
	private int accountID;

	public Visit(String url, String from) {
		setUrl(url);
		setReferer(from);
		setTimestamp(new Date());
		setAccountID(0);
	}

	public Visit(String url, String from, int id) {
		setUrl(url);
		setReferer(from);
		setTimestamp(new Date());
		setAccountID(id);
	}
	
	public Visit(String url, String from, Date timestamp) {
		setUrl(url);
		setReferer(from);
		setTimestamp(timestamp);
		setAccountID(0);
	}
	
	public Visit(String url, String from, Date timestamp, int accountID) {
		setUrl(url);
		setReferer(from);
		setTimestamp(timestamp);
		setAccountID(accountID);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
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