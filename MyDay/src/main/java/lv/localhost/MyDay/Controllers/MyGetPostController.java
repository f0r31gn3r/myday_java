package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyGetPostController {

	@RequestMapping(value="/getPostPage", method=RequestMethod.GET)
    public String greetingForm(Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("=== Parameters data 1 ===");
        
        java.util.Enumeration parEnum= request.getParameterNames();
        while (parEnum.hasMoreElements()) {
            String s = (String) parEnum.nextElement();
            System.out.println(s);
            System.out.println("==" + request.getParameter(s));
        }
        return "getPostPage";
    }
	@RequestMapping(value="/getPostPage", method=RequestMethod.POST)
    public String greetingSubmit(Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("=== Parameters data 2===");
        
        java.util.Enumeration parEnum= request.getParameterNames();
        while (parEnum.hasMoreElements()) {
            String s = (String) parEnum.nextElement();
            System.out.println(s);
            System.out.println("==" + request.getParameter(s));
            
            
        }
        
        model.addAttribute("firstname", request.getParameter("firstname"));
        model.addAttribute("lastname", request.getParameter("lastname"));
        
        return "result";
    }

	

}
