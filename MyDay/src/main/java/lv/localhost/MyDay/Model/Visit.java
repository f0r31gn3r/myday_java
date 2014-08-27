package lv.localhost.MyDay.Model;

public class Visit {
	
	private String url;
	private String referer;
	private int accountID;

	public Visit(String url, String from, int id) {
		setUrl(url);
		setReferer(from);
		setAccountID(id);
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

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
}