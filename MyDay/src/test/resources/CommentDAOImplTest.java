import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import lv.localhost.MyDay.DAO.CommentDAO;
import lv.localhost.MyDay.DAO.CommentDAOImpl;
import lv.localhost.MyDay.Model.Comment;
import lv.localhost.MyDay.common.DBException;


public class CommentDAOImplTest extends TestCase {
	
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

	public void testCreateComment() {
		try {
			CommentDAO c = new CommentDAOImpl();
			int i = c.createComment(2, 1, "TestComment");
			assertEquals(c.getCommentByID(4).getPostID(), 2);
			assertEquals(c.getCommentByID(4).getBody(), "TestComment");
			assertEquals(i, 4);
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	public void testGetCommentList() {
		try {
			CommentDAO c = new CommentDAOImpl();
			List<Comment> list = c.getCommentList(1);
			assertEquals(list.size(), 3);
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	public void testRemoveComment() {
		try {
			CommentDAO c = new CommentDAOImpl();
			assertTrue(c.removeComment(4));
			assertFalse(c.removeComment(4));
			
		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
