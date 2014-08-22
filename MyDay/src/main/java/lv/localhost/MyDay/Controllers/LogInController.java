package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.DAO.LoginDAOImpl;
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
		
		System.out.println("D6");	
		
        if (request.getParameter("logout") != null)
        	if (request.getParameter("logout").equals("true")){
        		System.out.println("D7");
        		session.invalidate();
        	}
        		
        
		return "redirect";
	}
	
	@RequestMapping(value = "/authorization", method = RequestMethod.POST)
	public String authorizationPost(Model model, HttpServletRequest request,
			HttpSession session) {
		/*** logging in ***/
		System.out.println("D1");
		if (session.getAttribute("user") == null) {
			
			boolean loginAttempt;
			loginAttempt = true;
			System.out.println("D2");
			if (loginAttempt) {
				System.out.println("D3");
				session.setAttribute("user", request.getParameter("login"));
				return "redirect"; // We have authorized user and redirect it to previous page 
			} else {
				System.out.println("D4");
				model.addAttribute("authorization_message", "Wrong login or password");
				return "authorization"; // redirect to login page in order to display error message
			}

			
//			try {
//				loginAttempt = new LoginDAOImpl().checkUser(request.getParameter("login"), request.getParameter("password"));
//				if (loginAttempt) {
//					session.setAttribute("user", request.getParameter("login"));
//				} else {
//					model.addAttribute("authorization_message", "Wrong login or password");
//				}
//			} catch (DBException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			};
			

		}

		return "redirect";
	}

}
