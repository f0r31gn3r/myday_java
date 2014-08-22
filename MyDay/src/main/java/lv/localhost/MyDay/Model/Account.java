package lv.localhost.MyDay.Model;

public class Account {
	
	private int accountID;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	
	public Account(){
		
	}

	public Account(int id, String login, String password, String firstName, String lastName  ){
		setAccountID(id);
		setLogin(login);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
