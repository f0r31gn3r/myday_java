package lv.localhost.MyDay.Controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegistrationController {
		

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationGet(Model model, HttpServletRequest request, HttpSession session) {
	return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registrationPost(Model model, HttpServletRequest request, HttpSession session) {
	return "registration";
	}	
	
}
