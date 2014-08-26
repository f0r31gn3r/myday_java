package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.DAO.PostDAOImpl;
import lv.localhost.MyDay.Model.Post;
import lv.localhost.MyDay.common.DBException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {

	private Post p;

	@RequestMapping(value="/new_post", method = RequestMethod.POST)
	public String createPost(Model model, HttpServletRequest request, HttpSession session) throws DBException{
	
		p = new Post();
		p.setAuthorID( Integer.parseInt( request.getParameter("authorID") ));
		p.setTitle(request.getParameter("title"));
		p.setBody( request.getParameter("body") );
		
		PostDAOImpl i = new PostDAOImpl();
		i.createPost(p);
		
		return "redirect:?page=posts";
		
	}
	
	
	@RequestMapping(value="/post_edit", method = RequestMethod.POST)
	public String editPost(Model model, HttpServletRequest request, HttpSession session) throws DBException{
		
		System.out.println("\n" + request.getParameter("postPostID"));
			PostDAOImpl pi = new PostDAOImpl();
			p = new Post();
			p.setAuthorID(Integer.parseInt(request.getParameter("postAuthID")));
			p.setTitle(request.getParameter("postTitle"));
			p.setBody(request.getParameter("postBody"));
			p.setPostID(Integer.parseInt(request.getParameter("postPostID")));
			
			pi = new PostDAOImpl();
			pi.updatePost(p);
			
		
		return "redirect:?page=post&id=" + p.getPostID();
		
	}
}
