package lv.localhost.MyDay.Controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.DAO.VisitDAOImpl;
import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.Model.Visit;
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

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request,
			HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		
		/**
		 * Registering visit
		 */
		String url = request.getRequestURL().toString(); // + "?" +
		// request.getQueryString();

		if (request.getQueryString() != null)
			url.concat("?" + request.getQueryString());
		String from = request.getHeader("referer");

		int accountID = 0;
		if (session.getAttribute("user") != null) {
			Account a = new Account();
			a.setAccountID(0);

			try {
				AccountDAOImpl accImpl = new AccountDAOImpl();
				if (accImpl.accountExists(session.getAttribute("user")
						.toString())) {
					a = new AccountDAOImpl().initAccount(session.getAttribute(
							"user").toString());
				}
			} catch (DBException e) {
				System.out
						.println("Exception in VisitController.visitGet during account initialization by name");
				e.printStackTrace();
			}

			accountID = a.getAccountID();
		}

		Visit visit = new Visit(url, from, accountID);

		try {
			new VisitDAOImpl().createVisit(visit);
		} catch (DBException e) {
			System.out.println("Exception during /visit controller visitGet");
			e.printStackTrace();
		}
		
		/**
		 *  End Of Registering visit
		 */
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		AccountDAOImpl a = new AccountDAOImpl();
		int result = 0;

		try {
			result = a.getIDByLogin("Noob");
		} catch (DBException e) {
			System.out.println("Exception during main loop");
			e.printStackTrace();
		}

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("test", result);

		return "index";
	}

}
