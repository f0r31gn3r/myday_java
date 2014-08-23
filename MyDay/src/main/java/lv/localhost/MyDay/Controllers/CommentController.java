package lv.localhost.MyDay.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lv.localhost.MyDay.DAO.AccountDAOImpl;
import lv.localhost.MyDay.DAO.CommentDAOImpl;
import lv.localhost.MyDay.Model.Comment;
import lv.localhost.MyDay.common.DBException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {

	private Comment c;

	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public String showForm(Model model, HttpServletRequest request,
			HttpSession session) throws DBException {

		if (request.getParameter("delete") != null) {
			// TODO : check if user logged in and is owner of the comment
			// provided
			CommentDAOImpl i = new CommentDAOImpl();
			i.removeComment(Integer.parseInt(request.getParameter("delete")));
		}
		return "comment";
	}

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public String createComment(Model model, HttpServletRequest request,
			HttpSession session) throws DBException {

		c = new Comment();
		
		int authorID = new AccountDAOImpl().getIDByLogin( session.getAttribute("user").toString() );
		
		c.setAuthor(authorID);
		c.setPostID(Integer.parseInt(request.getParameter("postID")));
		c.setBody(request.getParameter("body"));

		CommentDAOImpl i = new CommentDAOImpl();
		i.createComment(c.getPostID(), c.getAuthor(), c.getBody());

		return "comment";
	}

}