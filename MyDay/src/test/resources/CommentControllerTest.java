import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.Controllers.CommentController;
import lv.localhost.MyDay.DAO.CommentDAOImpl;
import lv.localhost.MyDay.Model.Comment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/root-context.xml" })
public class CommentControllerTest {

	@Mock
	private HttpServletRequest request;

	@Mock
	private Model model;

	@Mock
	private HttpSession session;

	@Mock
	private Comment c;

	@Mock
	private CommentDAOImpl i;

	@InjectMocks
	private CommentController commentController;

	private static MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        commentController = new CommentController();

        mockMvc = MockMvcBuilders.standaloneSetup(commentController)
                                 .setViewResolvers(viewResolver)
                                 .build();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testShowForm() throws Exception {
		  mockMvc.perform(get("/comment")
		  .param("delete", "21"))
		  .andExpect(status().isOk());
	}

/*	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public String showForm(Model model, HttpServletRequest request,
			HttpSession session) throws DBException {

		if (request.getParameter("delete") != null) {
			CommentDAOImpl i = new CommentDAOImpl();
			i.removeComment(Integer.parseInt(request.getParameter("delete")));
		}
		return "comment";
	}*/

	@Test
	public void testCreateComment() throws Exception {
		mockMvc.perform(post("/comment")
				.param("authorID", "1")
				.param("postID", "1")
				.param("body", "CommentController CREATE Test BODY"))
				.andExpect(redirectedUrl("?page=post&id=" + "1"));
	}
	
}
