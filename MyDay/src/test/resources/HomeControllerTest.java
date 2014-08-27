import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.Controllers.HomeController;
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
public class HomeControllerTest {
	
	@Mock 
	private HttpServletRequest request;
	
	@Mock
	private Model model;
	
	@Mock
	private HttpSession session;
	
	@Mock
	private Account p;
	
	@Mock
	private AccountDAOImpl ai;
 
    @InjectMocks
    private HomeController homeController;
 
    private static MockMvc mockMvc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link lv.localhost.MyDay.Controllers.HomeController#home(java.util.Locale, org.springframework.ui.Model, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpSession)}.
	 * @throws Exception 
	 */
	@Test
	public void testHome() throws Exception {
		mockMvc.perform(get("/")
				.sessionAttr("user", "Noob"))
				.andExpect(request().sessionAttribute("locale", nullValue()))
				.andExpect(request().sessionAttribute("user", "Noob"));
	}

}
