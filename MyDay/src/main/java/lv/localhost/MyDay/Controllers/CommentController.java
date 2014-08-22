package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;

import lv.localhost.MyDay.DAO.CommentDAOImpl;
import lv.localhost.MyDay.Model.Comment;
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
public class CommentController {

	private Comment c;

	@RequestMapping(value = "/comment_create", method = RequestMethod.GET)
	public ModelAndView showForm(ModelMap model) throws DBException {

		c = new Comment();

		return new ModelAndView("comment_create", "create", c);
	}

	@RequestMapping(value = "/comment_created", method = RequestMethod.POST)
	public String createComment(@ModelAttribute("comment_create") Comment c,
			ModelMap model) throws DBException {

		model.addAttribute("postID", c.getPostID());
		model.addAttribute("author", c.getAuthor());
		model.addAttribute("body", c.getBody());

		CommentDAOImpl i = new CommentDAOImpl();
		i.createComment(c.getPostID(), c.getAuthor(), c.getBody());

		return "comment_created";
	}

	@RequestMapping(value = "/comment_delete", method = RequestMethod.GET)
	public ModelAndView deleteForm(ModelMap model) throws DBException {

		c = new Comment();

		return new ModelAndView("comment_delete", "delete", c);

	}

	@RequestMapping(value = "/comment_deleted", method = RequestMethod.POST)
	public String deleteComment(@ModelAttribute("comment_delete") Comment c,
			ModelMap model) throws DBException {

		CommentDAOImpl i = new CommentDAOImpl();
		i.removeComment(c.getCommentID());

		return "comment_deleted";
	}

}