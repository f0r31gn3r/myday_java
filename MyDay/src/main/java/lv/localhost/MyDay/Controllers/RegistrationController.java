package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.Model.Account;
import lv.localhost.MyDay.common.DBException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
	private Account account;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String addStudent(Model model, HttpServletRequest request,
			HttpSession session) {
		account = new Account();
		boolean loginCheck = false;
		boolean error = false;
		try {
			loginCheck = new AccountDAOImpl().accountExists(request
					.getParameter("login"));
		} catch (DBException e) {
			System.out
					.println("Exception while RegistrationController.addStudent.loginCheck()");
		}
		String testL = request.getParameter("login");
		String testP = request.getParameter("password");
		String testPC = request.getParameter("passwordCheck");
		String testFN = request.getParameter("firstName");
		String testLN = request.getParameter("lastName");

		if (testL.isEmpty()) {
			model.addAttribute("emptyL", "Username must not be empty");
			error = true;
		}

		else if (testL.length() < 4 || testL.length() > 20) {
			error = true;
			model.addAttribute("lengthL",
					"Username must be from 4 to 20 symbols length");
		}

		if (loginCheck) {
			model.addAttribute("AccAlreadyExist", "Username is already in use");
			error = true;
		}
		if (!testP.equals(testPC)) {
			model.addAttribute("pswrdMatch", "Passwords does not match");
			error = true;
		}

		if (testP.isEmpty()) {
			model.addAttribute("emptyP", "Password must not be empty");
			error = true;
		}

		else if (testP.length() < 4 || testL.length() > 20) {
			error = true;
			model.addAttribute("lengthP",
					"Password must be minimum 6 symbols length");
		}

		if (testFN.isEmpty()) {
			model.addAttribute("emptyFN", "Please enter your First Name");
			error = true;
		}

		if (testLN.isEmpty()) {
			model.addAttribute("emptyLN", "Please enter your Surname");
			error = true;
		}

		if (!error) {
			account.setLogin(request.getParameter("login"));
			model.addAttribute("login", account.getLogin());
			account.setPassword(request.getParameter("password"));
			model.addAttribute("password", account.getPassword());
			account.setFirstName(request.getParameter("firstName"));
			model.addAttribute("firstName", account.getFirstName());
			account.setLastName(request.getParameter("lastName"));
			model.addAttribute("lastName", account.getLastName());
			AccountDAOImpl newacc = new AccountDAOImpl();
			try {
				newacc.createAccount(account);
			} catch (DBException e) {
				System.out
						.println("Exception while RegistrationController.addStudent.createAccount()");

			}
		} else {
			return "?page=registration";
		}

		return "?page=result";
	}

}
