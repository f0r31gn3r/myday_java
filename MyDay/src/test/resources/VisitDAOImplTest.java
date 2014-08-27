import java.sql.Connection;
import java.sql.DriverManager;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import lv.localhost.MyDay.DAO.VisitDAO;
import lv.localhost.MyDay.DAO.VisitDAOImpl;
import lv.localhost.MyDay.Model.Visit;
import lv.localhost.MyDay.common.DBException;


public class VisitDAOImplTest extends TestCase {
	
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

	public void testCreateVisit() {
		try {
			VisitDAO v = new VisitDAOImpl();
			assertTrue(v.createVisit(new Visit("testURL123", "testFrom123", 1)));

		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}