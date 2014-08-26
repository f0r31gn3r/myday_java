package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.common.DBException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogInController {

	@RequestMapping(value = "/authorization", method = RequestMethod.GET)
	public String authorizationGet(Model model, HttpServletRequest request,
			HttpSession session) {

		if (request.getParameter("logout") != null)
			if (request.getParameter("logout").equals("true")) {
				session.invalidate();
			}
		return "index";
	}

	@RequestMapping(value = "/authorization", method = RequestMethod.POST)
	public String authorizationPost(Model model, HttpServletRequest request,
			HttpSession session) {
		/*** logging in ***/
		if (session.getAttribute("user") == null) {

			boolean loginAttempt = false;
			try {
				loginAttempt = new AccountDAOImpl().accountExists(
						request.getParameter("login"),
						request.getParameter("password"));
			} catch (DBException e) {
				e.printStackTrace();
			}

			if (loginAttempt) {
				session.setAttribute("user", request.getParameter("login"));
				return "index";
			} else {
				model.addAttribute("authorization_message",
						"Wrong login or password");
				return "index";
			}
		}
		return "index";
	}

}