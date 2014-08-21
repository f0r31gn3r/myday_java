package lv.localhost.MyDay.Controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyGetPostController {

	@RequestMapping(value = "/getPostPage", method = RequestMethod.GET)
	public String greetingForm(Model model, HttpServletRequest request,
			HttpSession session) {
		System.out.println("=== Parameters data 1 ===");

		java.util.Enumeration parEnum = request.getParameterNames();
		while (parEnum.hasMoreElements()) {
			String s = (String) parEnum.nextElement();
			System.out.println(s);
			System.out.println("==" + request.getParameter(s));
		}

		if (session.getAttribute("user") == null) {
			// if ( loginAttempt )
			session.setAttribute("user", request.getParameter("login"));
			model.addAttribute("loggedin", request.getParameter("login"));
		}
		return "getPostPage";
	}

	@RequestMapping(value = "/getPostPage", method = RequestMethod.POST)
	public String greetingSubmit(Model model, HttpServletRequest request,
			HttpSession session) {
		System.out.println("=== Parameters data 2===");

		java.util.Enumeration parEnum = request.getParameterNames();
		while (parEnum.hasMoreElements()) {
			String s = (String) parEnum.nextElement();
			System.out.println(s);
			System.out.println("==" + request.getParameter(s));

		}

		System.out.println("*** Session data ***");
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
			System.out.println("**" + session.getAttribute(s));
		}

		/*** logging in ***/

		if (session.getAttribute("user") == null) {
			boolean loginAttempt = true;
			if (loginAttempt) {
				session.setAttribute("user", request.getParameter("login"));
			} else {
				model.addAttribute("badlogin", "<P> <font color=\"red\"> Wrong login or password</font></p>");
			}

		}

		return "getPostPage";
	}

}
