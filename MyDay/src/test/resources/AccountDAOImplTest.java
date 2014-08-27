import java.sql.Connection;
import java.sql.DriverManager;

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
			fail();
		}
	}

	// @Test
	public void testCreateAccountandInitAccount() {
		try {
			AccountDAO a = new AccountDAOImpl();
			Account acc = new Account();
			assertTrue(acc != null);
			assertFalse(acc == null);
			
			int i = a.createAccount(new Account("user21", "pass", "fname",
					"lname"));
			assertEquals(a.initAccount("user21").getAccountID(), i);
			assertEquals(a.initAccount("user21").getLogin(), "user21");
			assertEquals(a.initAccount("user21").getPassword(), "pass");
			assertEquals(a.initAccount("user21").getFirstName(), "fname");
			assertEquals(a.initAccount("user21").getLastName(), "lname");
			assertTrue(a.initAccount("user21").getCreated() != null);
			assertFalse(a.initAccount("user21").getCreated() == null);
			assertTrue(a.initAccount("user21").getLastVisited() != null);
			assertFalse(a.initAccount("user21").getLastVisited() == null);
			a.removeAccount(i);

		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	// @Test
	public void testGetIDByLogin() {
		try {
			AccountDAO a = new AccountDAOImpl();
			int i = a.createAccount(new Account("user21", "pass", "fname",
					"lname"));
			assertEquals(a.getIDByLogin("user21"), i);
			assertEquals(a.getIDByLogin("user211"), 0);
			a.removeAccount(i);

		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	// @Test
	public void testGetLoginByID() {
		try {
			AccountDAO a = new AccountDAOImpl();
			int i = a.createAccount(new Account("user21", "pass", "fname",
					"lname"));
			assertEquals(a.getLoginByID(i), "user21");
			assertEquals(a.getLoginByID(i+1), "");
			a.removeAccount(i);

		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	// @Test
	public void testAccountExistsString() {
		try {
			AccountDAO a = new AccountDAOImpl();
			int i = a.createAccount(new Account("user21", "pass", "fname",
					"lname"));
			assertTrue(a.accountExists("user21"));
			assertFalse(a.accountExists("user211"));
			a.removeAccount(i);

		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	// @Test
	public void testAccountExistsStringString() {
		try {
			AccountDAO a = new AccountDAOImpl();
			int i = a.createAccount(new Account("user21", "pass", "fname",
					"lname"));
			assertTrue(a.accountExists("user21", "pass"));
			assertFalse(a.accountExists("user211", "pass1"));
			a.removeAccount(i);

		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	// @Test
	public void testRemoveAccount() {
		try {
			AccountDAO a = new AccountDAOImpl();
			int i = a.createAccount(new Account("user21", "pass", "fname",
					"lname"));
			assertTrue(a.removeAccount(i));
			assertFalse(a.removeAccount(i));

		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}