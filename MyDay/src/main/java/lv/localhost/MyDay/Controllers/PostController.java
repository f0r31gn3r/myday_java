package lv.localhost.MyDay.Controllers;

import lv.localhost.MyDay.DAO.PostDAOImpl;
import lv.localhost.MyDay.Model.Post;
import lv.localhost.MyDay.common.DBException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

	private Post p;
	
	@RequestMapping(value="/new_post", method = RequestMethod.GET)
	public ModelAndView showForm(ModelMap model) throws DBException{
		
		p = new Post();
		
		return new ModelAndView("new_post", "create", p);
		
	}
	
	@RequestMapping(value="/created", method = RequestMethod.POST)
	public String createPost(@ModelAttribute ("new_post") Post p, ModelMap model) throws DBException{
		
		model.addAttribute("title", p.getTitle()); 
		model.addAttribute("id", p.getAuthorID());
		model.addAttribute("body", p.getBody());
		
		PostDAOImpl i = new PostDAOImpl();
		i.createPost(p);
		
		return "index";
		
	}
	
	@RequestMapping(value="/delete_post/{postID}", method = RequestMethod.GET)
	public String deletePost(@PathVariable ("postID") int postID, ModelMap model) throws DBException{
		
		PostDAOImpl i = new PostDAOImpl();
		i.removePost(postID);
		
		return "index";
		
	}
	
	@RequestMapping(value="posts/{postID}", method=RequestMethod.GET)
	public String showPost(@PathVariable ("postID") int postID, Model model) throws DBException{
		
		p = new Post();
		PostDAOImpl i = new PostDAOImpl();
		p = i.findPost(postID);
		
		model.addAttribute("authorID", p.getAuthorID());
		model.addAttribute("title", p.getTitle());
		model.addAttribute("body", p.getBody());
		model.addAttribute("createdDate", p.getCreated());
		
		return "post";
	}
	
	@RequestMapping(value="/post/{postID}", method = RequestMethod.GET)
	public String editForm(@PathVariable ("postID") int postID, Model model) throws DBException{
		
		p = new Post();
		PostDAOImpl i = new PostDAOImpl();
		p = i.findPost(postID);
		i.updatePost(p);
		
		model.addAttribute("authorID", p.getAuthorID());
		
		return "index";
		
	}
	
	@RequestMapping(value="/edited", method = RequestMethod.POST)
	public String editPost(@ModelAttribute ("edit_post") Post p, ModelMap model) throws DBException{
		
		PostDAOImpl i = new PostDAOImpl();
		p.setPostID(this.p.getPostID());
		i.updatePost(p);
		
		model.addAttribute("posttitle", p.getTitle());
		model.addAttribute("postid", p.getPostID()); 
		
		return "edited";
		
	}
}
