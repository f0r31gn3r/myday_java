import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

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
		fail("Not yet implemented");
	}

/*	public void testCreateAccountStringStringStringString() {
		try {
			AccountDAO a = new AccountDAOImpl();
			int i = a.createAccount("user21", "pass", "fname", "lname");
			assertEquals(a.initAccount("user21").getLogin(), "user21");
			assertEquals(a.initAccount("user21").getFirstName(), "fname");
			assertEquals(i, a.initAccount("user21").getAccountID());
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}*/
	
	public void testAccountExistsString() {
		try {
			AccountDAO a = new AccountDAOImpl();
			assertTrue(a.accountExists("user21"));
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	public void testAccountExistsStringString() {
		try {
			AccountDAO a = new AccountDAOImpl();
			assertTrue(a.accountExists("user21", "pass"));
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	public void testRemoveAccountAccount() {
		fail("Not yet implemented");
	}

/*	public void testRemoveAccountString() {
		try {
			AccountDAO a = new AccountDAOImpl();
			a.removeAccount("user21");
			assertNull(a.initAccount("user21"));
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}*/

	public void testRemoveAccountInt() {
		fail("Not yet implemented");
	}

	public void testUpdateAccountAccount() {
		fail("Not yet implemented");
	}

	/*public void testUpdateAccountIntStringStringStringString() {
		try {
			AccountDAO a = new AccountDAOImpl();
			
			a.updateAccount(1, "pass", "fname", "lname");
			assertEquals(a.initAccount(1).getPassword(), "pass");
			assertEquals(a.initAccount(1).getFirstName(), "fname");
			assertEquals(a.initAccount(1).getLastName(), "lname");
			
			a.updateAccount(1, "123", "Vasyly", "Pupkin");
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}*/

	public void testInitAccountString() {
		fail("Not yet implemented");
	}

	public void testInitAccountInt() {
		fail("Not yet implemented");
	}

/*	public void testGetAllAccounts() {
		try {
			AccountDAO a = new AccountDAOImpl();
			List<Account> list = a.getAllAccounts();
			assertEquals(list.size(), 3);
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}*/

/*	public void testGetAllAccountsIntInt() {
		try {
			AccountDAO a = new AccountDAOImpl();
			List<Account> list = a.getAllAccounts(1,2);
			assertEquals(list.size(), 2);
			assertEquals(list.get(1).getLogin(), "Crazy");
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}*/

}
