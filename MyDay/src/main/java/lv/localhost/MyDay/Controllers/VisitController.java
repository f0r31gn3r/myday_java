package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VisitController {
		

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/visit", method = RequestMethod.GET)
	public String visitGet(Model model, HttpServletRequest request, HttpSession session) {
        
		System.out.println("=== Request data ===");
        java.util.Enumeration reqEnum = request.getAttributeNames();
        while (reqEnum.hasMoreElements()) {
            String s = (String) reqEnum.nextElement();
            System.out.println(s);
            System.out.println("==" + request.getAttribute(s));
        }
 
        
		return "visit";
	}
	
}
