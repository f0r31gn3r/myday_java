import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.Controllers.PostController;
import lv.localhost.MyDay.DAO.PostDAOImpl;
import lv.localhost.MyDay.Model.Post;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;


/**
 * 
 */

/**
 * @author student
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/root-context.xml" }) 
public class PostControllerTest {

	@Mock 
	private HttpServletRequest request;
	
	@Mock
	private Model model;
	
	@Mock
	private HttpSession session;
	
	@Mock
	private Post p;
	
	@Mock
	private PostDAOImpl pi;
 
    @InjectMocks
    private PostController postController;
 
    private static MockMvc mockMvc;
 

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link lv.localhost.MyDay.Controllers.PostController#createPost(org.springframework.ui.Model, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpSession)}.
	 * @throws Exception 
	 */
	@Test
	public void testCreatePost() throws Exception {
		mockMvc.perform(post("/new_post")
				.param("authorID", "1")
				.param("title", "PostController CREATE Test TITLE")
				.param("body", "PostController CREATE Test BODY"))
				.andExpect(redirectedUrl("?page=posts"));
	}

	/**
	 * Test method for {@link lv.localhost.MyDay.Controllers.PostController#editPost(org.springframework.ui.Model, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpSession)}.
	 * @throws Exception 
	 */
	@Test
	public void testEditPost() throws Exception {
		String id = "41";
		mockMvc.perform(post("/post_edit")
				.param("postAuthID", "1")
				.param("postTitle", "PostController EDIT Test TITLE")
				.param("postBody", "PostController EDIT Test BODY")
				.param("postPostID", id))
				.andExpect(redirectedUrl("?page=post&id=" + Integer.parseInt(id)));
	}

}
