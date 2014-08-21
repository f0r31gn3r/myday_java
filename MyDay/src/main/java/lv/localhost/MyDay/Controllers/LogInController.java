package lv.localhost.MyDay.Controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogInController {

	@RequestMapping(value = "/authorization", method = RequestMethod.GET)
	public String authorizationGet(Model model, HttpServletRequest request,
			HttpSession session) {
		
		java.util.Enumeration parEnum= request.getParameterNames();
        while (parEnum.hasMoreElements()) {
            String s = (String) parEnum.nextElement();
            System.out.println(s);
            System.out.println("==" + request.getParameter(s));
        }
        
        if (request.getParameter("logout") != null)
        	if (request.getParameter("logout").equals("true"))
        		session.invalidate();
        
		return "authorization";
	}
	
	@RequestMapping(value = "/authorization", method = RequestMethod.POST)
	public String authorizationPost(Model model, HttpServletRequest request,
			HttpSession session) {
		/*** logging in ***/

		if (session.getAttribute("user") == null) {
			boolean loginAttempt = true;
			if (loginAttempt) {
				session.setAttribute("user", request.getParameter("login"));
			} else {
				model.addAttribute("authorization_message", "Wrong login or password");
			}

		}

		return "authorization";
	}

}
