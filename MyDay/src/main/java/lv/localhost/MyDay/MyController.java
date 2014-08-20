package lv.localhost.MyDay;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
 
	@SuppressWarnings("rawtypes")
    @RequestMapping("/dosomething")
    public String requestHandlingMethod(Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("Inside of dosomething handler method");
 
        System.out.println("--- Model data ---");
        Map modelMap = model.asMap();
        for (Object modelKey : modelMap.keySet()) {
            Object modelValue = modelMap.get(modelKey);
            System.out.println(modelKey + " -- " + modelValue);
        }
 
        System.out.println("=== Request data ===");
        java.util.Enumeration reqEnum = request.getAttributeNames();
        while (reqEnum.hasMoreElements()) {
            String s = (String) reqEnum.nextElement();
            System.out.println(s);
            System.out.println("==" + request.getAttribute(s));
        }
 
        System.out.println("=== Parameters data ===");
        
        java.util.Enumeration parEnum= request.getParameterNames();
        while (parEnum.hasMoreElements()) {
            String s = (String) parEnum.nextElement();
            System.out.println(s);
            System.out.println("==" + request.getParameter(s));
        }
        
        System.out.println("*** Session data ***");
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()){
          String s = e.nextElement();
          System.out.println(s);
          System.out.println("**" + session.getAttribute(s));
        }

        
        String result = request.getParameter("test");
        model.addAttribute("test", result );
        
        return "nextpage";
    }
 
}
