import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import junit.framework.AssertionFailedError;
import lv.localhost.MyDay.DAO.PostDAOImpl;
import lv.localhost.MyDay.Model.Post;
import lv.localhost.MyDay.common.DBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alena Kuznetsova
 *
 */
public class PostDAOImplTest {

	/**
	 * @throws java.lang.Exception
	 */

	private Connection conn;
	private String url;
	private String user;
	private String pass;
	private Log logger = LogFactory.getLog(getClass());
	private Post p;
	private PostDAOImpl pi;
	private static int postID = 0;

	@Before
	public void setUp() throws Exception {
		this.url = "jdbc:mysql://localhost/myday";
		this.user = "root";
		this.pass = "abcd1234";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pass);
		conn.setAutoCommit(false);
		System.out.println("Connection successfully established!");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		try {
			conn.close();
			System.out.println("Connection closed!");
		} catch (AssertionFailedError e) {
			logger.error("Assertion failed");
		}
	}

	/**
	 * Test method for
	 * {@link lv.localhost.MyDay.DAO.PostDAOImpl#createPost(lv.localhost.MyDay.Model.Post)}
	 * .
	 */
	@Test
	public void testCreatePost() {
		p = new Post("PostDAOImpl create Test TITLE", 1,
				"PostDAOImpl create Test BODY");
		pi = new PostDAOImpl();

		try {
			pi.createPost(p);

			postID = p.getPostID();
			assertEquals(pi.findPost(postID).getTitle(),
					"PostDAOImpl create Test TITLE");
			assertEquals(pi.findPost(postID).getAuthorID(), 1);
			assertEquals(pi.findPost(postID).getBody(),
					"PostDAOImpl create Test BODY");

		} catch (DBException e) {

			e.printStackTrace();
		} catch (AssertionFailedError e) {
			logger.error("####### testCreatePost Fail #######");
			fail();
		}
	}

	/**
	 * Test method for {@link lv.localhost.MyDay.DAO.PostDAOImpl#findPost(int)}.
	 */
	@Test
	public void testFindPost() {
		pi = new PostDAOImpl();

		try {

			assertEquals(pi.findPost(postID).getTitle(),
					"PostDAOImpl create Test TITLE");
			assertEquals(pi.findPost(postID).getAuthorID(), 1);
			assertEquals(pi.findPost(postID).getBody(),
					"PostDAOImpl create Test BODY");

		} catch (DBException e) {

			e.printStackTrace();
		} catch (AssertionFailedError e) {
			logger.error("####### testFindPost Fail #######");
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link lv.localhost.MyDay.DAO.PostDAOImpl#updatePost(lv.localhost.MyDay.Model.Post)}
	 * .
	 */
	@Test
	public void testUpdatePost() {
		p = new Post(postID, "PostDAOImpl update Test TITLE", 1,
				"PostDAOImpl update Test BODY");
		pi = new PostDAOImpl();

		try {

			pi.updatePost(p);

			assertEquals(pi.findPost(postID).getTitle(),
					"PostDAOImpl update Test TITLE");
			assertEquals(pi.findPost(postID).getAuthorID(), 1);
			assertEquals(pi.findPost(postID).getBody(),
					"PostDAOImpl update Test BODY");

		} catch (DBException e) {

			e.printStackTrace();
		} catch (AssertionFailedError e) {
			logger.error("####### testUpdatePost Fail #######");
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link lv.localhost.MyDay.DAO.PostDAOImpl#findLatestPosts()}.
	 */
	@Test
	public void testFindLatestPosts() {
		pi = new PostDAOImpl();

		try {
			List<Post> lastPosts = pi.findLatestPosts();

			for (int i = 0; i < lastPosts.size(); i++) {
				if (lastPosts.get(i).getTitle() == "PostDAOImpl update Test TITLE") {
					assertEquals(lastPosts.get(i).getTitle(),
							"PostDAOImpl update Test TITLE");
					assertEquals(lastPosts.get(i).getAuthorID(), 1);
					assertEquals(lastPosts.get(i).getBody(),
							"PostDAOImpl update Test BODY");
				}
			}

		} catch (DBException e) {

			e.printStackTrace();
		} catch (AssertionFailedError e) {
			logger.error("####### testFindLatestPosts Fail #######");
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link lv.localhost.MyDay.DAO.PostDAOImpl#searchPost(java.lang.String)}.
	 */
	@Test
	public void testSearchPost() {
		pi = new PostDAOImpl();

		try {
			List<Post> searchPost = pi.searchPost("Test");

			for (int i = 0; i < searchPost.size(); i++) {
				if (searchPost.get(i).getTitle() == "PostDAOImpl update Test TITLE") {
					assertEquals(searchPost.get(i).getTitle(),
							"PostDAOImpl update Test TITLE");
					assertEquals(searchPost.get(i).getAuthorID(), 1);
					assertEquals(searchPost.get(i).getBody(),
							"PostDAOImpl update Test BODY");
				}
			}

		} catch (DBException e) {

			e.printStackTrace();
		} catch (AssertionFailedError e) {
			logger.error("####### testSearchPost Fail #######");
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link lv.localhost.MyDay.DAO.PostDAOImpl#removePost(int)}.
	 */
	@Test
	public void testRemovePost() {
		pi = new PostDAOImpl();

		try {
			pi.removePost(postID);
			assertNull(pi.findPost(postID));

		} catch (DBException e) {

			e.printStackTrace();
		} catch (AssertionFailedError e) {
			logger.error("####### testRemovePost Fail #######");
			fail();
		}
	}

}
