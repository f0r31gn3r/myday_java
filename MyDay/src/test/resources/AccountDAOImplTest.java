import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import lv.localhost.MyDay.DAO.AccountDAO;
import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;


public class AccountDAOImplTest extends TestCase {
	
	private Connection conn;
	private String url;
	private String user;
	private String pass;
	Log logger = LogFactory.getLog(getClass());

	protected void setUp() throws Exception {
		super.setUp();
		this.url = "jdbc:mysql://localhost:3306/myday";
		this.user = "root";
		this.pass = "abcd1234";
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
		this.conn.setAutoCommit(false);
		System.out.println("Connection successfully established!");
	}

	protected void tearDown() throws Exception {
		try {
			super.tearDown();
			this.conn.close();
			System.out.println("Connection closed!");
		} catch (AssertionFailedError e) {
//			this.logger.error(Percentage.setFailedCount(1, e.getMessage()));
//			this.logger.error(Percentage.setFailedCount(true, 6));
		}
	}

	public void testGetIDByLogin() {
		fail("Not yet implemented");
	}

	public void testGetLoginByID() {
		fail("Not yet implemented");
	}

	public void testCreateAccountAccount() {
		AccountDAO ad = new AccountDAOImpl();
		Account a = new Account("user21", "pass", "fname", "lname");
		
		try {
			ad.createAccount(a);
			assertEquals(ad.initAccount("user21").getLogin(), "user21");
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	public void testCreateAccountStringStringStringString() {
		fail("Not yet implemented");
	}

	public void testRemoveAccountAccount() {
		fail("Not yet implemented");
	}

	public void testRemoveAccountString() {
		fail("Not yet implemented");
	}

	public void testRemoveAccountInt() {
		fail("Not yet implemented");
	}

	public void testUpdateAccountAccount() {
		fail("Not yet implemented");
	}

	public void testUpdateAccountIntStringStringStringString() {
		fail("Not yet implemented");
	}

	public void testInitAccountString() {
		fail("Not yet implemented");
	}

	public void testInitAccountInt() {
		fail("Not yet implemented");
	}

	public void testAccountExistsString() {
		fail("Not yet implemented");
	}

	public void testAccountExistsStringString() {
		fail("Not yet implemented");
	}

	public void testGetAllAccounts() {
		fail("Not yet implemented");
	}

	public void testGetAllAccountsIntInt() {
		fail("Not yet implemented");
	}

}
