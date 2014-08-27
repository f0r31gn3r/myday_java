import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

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

	public void testCreateCommentandGetCommentByID() {
		try {
			CommentDAO c = new CommentDAOImpl();
			Comment com = new Comment();
			assertTrue(com != null);
			assertFalse(com == null);
			
			int i = c.createComment(2, 1, "TestComment");
			assertEquals(c.getCommentByID(i).getCommentID(), i);
			assertEquals(c.getCommentByID(i).getPostID(), 2);
			assertEquals(c.getCommentByID(i).getAuthor(), 1);
			assertEquals(c.getCommentByID(i).getBody(), "TestComment");
			assertTrue(c.getCommentByID(i).getCreated() != null);
			assertFalse(c.getCommentByID(i).getCreated() == null);
			c.removeComment(i);

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
			int i = c.createComment(2, 1, "TestComment");
			List<Comment> list = c.getCommentList(1);
			assertEquals(list.size(), 3);
			assertEquals(list.get(1).getBody(), "Com22222");
			List<Comment> list1 = c.getCommentList(1245);
			List<Comment> list2 = new ArrayList<Comment>();
			assertTrue(list1.equals(list2));
			c.removeComment(i);

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
			
			int i = c.createComment(2, 1, "TestComment");
			assertTrue(c.removeComment(i));
			assertFalse(c.removeComment(i));

		} catch (AssertionFailedError e) {
			fail();
		} catch (DBException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}