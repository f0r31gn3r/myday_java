<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="lv.localhost.MyDay.DAO.PostDAOImpl"%>
<%@ page import="lv.localhost.MyDay.Model.Post"%>
<%@ page import="lv.localhost.MyDay.DAO.AccountDAOImpl"%>
<%@ page import="lv.localhost.MyDay.DAO.CommentDAOImpl"%>
<%@ page import="lv.localhost.MyDay.Model.Comment"%>
<%@ page session="true"%>
<%

Post p = new PostDAOImpl().findPost( Integer.parseInt( request.getParameter("id") )  );

String postAuthorName = new AccountDAOImpl().getLoginByID( p.getAuthorID() );

String queryString = request.getQueryString();

String action = request.getParameter("action");
if ( action == null)
	action ="display";


if ( action.equals("display") ){
%>
<div id="news">
	<div>
		<p  id="post_a">
			<%=p.getTitle() %></p>
	</div>
	<% 
			if ( session.getAttribute("user") != null)
			{
		    	int authorID = new AccountDAOImpl().getIDByLogin( session.getAttribute("user").toString() );
				if ( p.getAuthorID() == authorID  ) {%>
	
	<a href="?<%=queryString  %>&action=edit">Edit post</a> | <a
		 href="?<%=queryString  %>&action=delete">Delete post</a>
	<% }
			}%>

	<hr class="style-two">
	<div id="news_text">
		<%=p.getBody() %>
	</div>

	<hr class="style-two">

	<%
		
				
int commentCount = 0;
CommentDAOImpl com = new CommentDAOImpl();
List <Comment> commentss = com.getCommentList(p.getPostID());
commentCount = commentss.size();
%>

	<div id="news_bottom">
		Date published:
		<%=p.getCreated() %>
		by
		<%=postAuthorName %>
		| Comments (<%=commentCount %>)
	</div>

</div>
<%@include file="comment.jsp"%>

<%
}else if (action.equals("edit")) {
%>

<form method="post" action="/MyDay/post_edit">
	<input type="hidden" name="postAuthID" value="<%= p.getAuthorID() %>" />
	<input type="hidden" name="postPostID" value="<%= p.getPostID() %>" />
	<table>
		<tr>
			<td>Title</td>
			<td><input type="text" name="postTitle"
				value="<%= p.getTitle() %>" /></td>
		</tr>
		<tr>
			<td>Text</td>
			<td><textarea rows="10" name="postBody" cols="100" id="body"><%= p.getBody() %></textarea></td>

		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="submit"
				value="Submit" /></td>
		</tr>
	</table>
</form>

<%
}else if (action.equals("delete")) {
	PostDAOImpl i = new PostDAOImpl();
	i.removePost(p.getPostID());
	CommentDAOImpl c = new CommentDAOImpl();
	List <Comment> comments = c.getCommentList(p.getPostID());
	for (int j = 0; j < comments.size(); j++){
		c.removeComment(comments.get(j).getCommentID());
	}
	%>
<script>
		window.location="?page=posts";
	</script>
<%
} %>



