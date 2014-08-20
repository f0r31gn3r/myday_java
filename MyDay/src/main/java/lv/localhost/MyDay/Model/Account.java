package lv.localhost.MyDay.Model;

public class Account {
	
	private int accountID;
	private String nickName;
	private String firstName;
	private String lastName;
	
	public Account(){
		
	}

	public Account(int id, String nickName, String firstName, String lastName  ){
		setAccountID(id);
		setNickname(nickName);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public String getNickname() {
		return nickName;
	}
	public void setNickname(String nickname) {
		this.nickName = nickname;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
