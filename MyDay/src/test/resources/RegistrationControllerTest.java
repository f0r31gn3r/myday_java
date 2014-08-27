import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.Controllers.RegistrationController;
import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.Model.Account;

import org.apache.commons.lang.RandomStringUtils;
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
public class RegistrationControllerTest {

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
	private RegistrationController regController;

	private static MockMvc mockMvc;
	private static String username;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(regController).build();
		username = RandomStringUtils.randomAlphabetic(10);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link lv.localhost.MyDay.Controllers.RegistrationController#addStudent(org.springframework.ui.Model, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpSession)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddStudent() throws Exception {
		
		mockMvc.perform(
				post("/registration")
						.param("login", username)
						.param("password", "qwerty")
						.param("passwordCheck", "qwerty")
						.param("firstName", "John")
						.param("lastName", "Smith"))
				.andExpect(status().isOk());
		mockMvc.perform(
				post("/registration")
						.param("login", username)
						.param("password", "qwerty")
						.param("passwordCheck", "qwerty123")
						.param("firstName", "John")
						.param("lastName", "Smith"))
				.andExpect(status().isOk())
		.andExpect(model().attribute("pswrdMatch", "Passwords does not match"));
		mockMvc.perform(
				post("/registration")
						.param("login", "Noob")
						.param("password", "qwerty")
						.param("passwordCheck", "qwerty")
						.param("firstName", "John")
						.param("lastName", "Smith"))
				.andExpect(status().isOk())
		.andExpect(model().attribute("AccAlreadyExist", "Username is already in use"));
		mockMvc.perform(
				post("/registration")
						.param("login", "ttt")
						.param("password", "")
						.param("passwordCheck", "")
						.param("firstName", "")
						.param("lastName", ""))
				.andExpect(status().isOk())
		.andExpect(model().attribute("emptyFN", "Please enter your First Name"))
		.andExpect(model().attribute("emptyLN", "Please enter your Surname"))
		.andExpect(model().attribute("lengthL", "Username must be from 4 to 20 symbols length"))
		.andExpect(model().attribute("emptyP", "Password must not be empty"));
		
	}

}
