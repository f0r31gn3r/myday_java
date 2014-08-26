package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.DAO.VisitDAOImpl;
import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.Model.Visit;
import lv.localhost.MyDay.common.DBException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VisitController {

	@RequestMapping(value = "/visit", method = RequestMethod.GET)
	public String visitGet(Model model, HttpServletRequest request,
			HttpSession session) {

		String url = request.getRequestURL().toString();

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
			System.out.println("Exception during visit controller visitGet");
			e.printStackTrace();
		}

		return "visit";
	}

}