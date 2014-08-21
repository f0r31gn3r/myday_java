package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.DAO.VisitDAOImpl;
import lv.localhost.MyDay.Model.Visit;
import lv.localhost.MyDay.common.DBException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VisitController {
		

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/visit", method = RequestMethod.GET)
	public String visitGet(Model model, HttpServletRequest request, HttpSession session) {
        
		String url = request.getRequestURL().toString(); // + "?" + request.getQueryString();
		
		if ( request.getQueryString() != null )
			url.concat("?" + request.getQueryString()); 
		String from = request.getHeader("referer"); 
		
		
		// TODO : Add getting AccountID
//		if (session.getAttribute("user") != null) {
//		
//		}
		
		Visit visit = new Visit(url,from);
		
		try {
			new VisitDAOImpl().createVisit(visit);
		} catch (DBException e) {
			System.out.println("Exception during /visit controller visitGet");
			e.printStackTrace();
		}
		
		return "visit";
	}
	
}
