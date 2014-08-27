import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.Controllers.LogInController;
import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.Model.Account;

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
public class LoginControllerTest {
	
	@Mock
	private HttpServletRequest request;

	@Mock
	private Model model;

	@Mock
	private HttpSession session;

	@Mock
	private Account a;

	@Mock
	private AccountDAOImpl ai;

	@InjectMocks
	private LogInController loginController;

	private static MockMvc mockMvc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link lv.localhost.MyDay.Controllers.LogInController#authorizationPost(org.springframework.ui.Model, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpSession)}.
	 * @throws Exception 
	 */
	@Test
	public void testAuthorizationPost() throws Exception {
		mockMvc.perform(
				post("/authorization")
						.param("login", "Noob")
						.param("password", "123"))
				.andExpect(status().isOk());
		mockMvc.perform(
				post("/authorization")
						.param("login", "Noob")
						.param("password", "1233"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("authorization_message", "Wrong login or password"));
		mockMvc.perform(
				post("/authorization")
						.param("login", "Noob1")
						.param("password", "123"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("authorization_message", "Wrong login or password"));
	}

}
