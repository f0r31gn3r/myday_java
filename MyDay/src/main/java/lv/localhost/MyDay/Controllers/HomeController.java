package lv.localhost.MyDay.Controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		AccountDAOImpl a = new AccountDAOImpl();
		String result = "def";
		
		try {
			result = a.getByName("Vasyly");
		} catch (DBException e) {
			System.out.println("Exception during main loop");
			e.printStackTrace();
		}
		
		try {
			if ( a.createAccount(new Account(99,"raz","dva","tri")) ){
				System.out.println("Successfully created new account");
			}
				
		} catch (DBException e) {
			System.out.println("Exception during new account creation");
			e.printStackTrace();
		}
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("test", result );
		
		
		return "home";
	}
	
}