<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ page import="lv.localhost.MyDay.DAO.AccountDAOImpl"%>
<%@ page import="lv.localhost.MyDay.DAO.PostDAOImpl"%>
<%@ page import="lv.localhost.MyDay.Model.Post"%>
<%@ page import="lv.localhost.MyDay.DAO.CommentDAOImpl"%>
<%@ page import="lv.localhost.MyDay.Model.Comment"%>
<%@ page session="true"%>

<%
	PostDAOImpl p = new PostDAOImpl();
	if (request.getParameter("search") == null) {

		List<Post> posts = p.findLatestPosts();

		for (int i = 0; i < posts.size(); i++) {
			String postAuthorName = new AccountDAOImpl()
					.getLoginByID(posts.get(i).getAuthorID());
%>
<div id="news">
	<div id="news_top">
		<p>
			<a href="?page=post&id=<%=posts.get(i).getPostID()%>"> <%=posts.get(i).getTitle()%>
			</a>
		</p>
	</div>
	<hr class="style-two">

	<div id="news_text">
		<%=posts.get(i).getBody()%>
	</div>

	<hr class="style-two">

	<%
		int commentCount = 0;
				CommentDAOImpl c = new CommentDAOImpl();
				List<Comment> comments = c.getCommentList(posts.get(i)
						.getPostID());
				commentCount = comments.size();
	%>

	<div id="news_bottom">
		Date published:
		<%=posts.get(i).getCreated()%>
		by
		<%=postAuthorName%>
		| <a href="?page=post&id=<%=posts.get(i).getPostID()%>">(<%=commentCount%>)
		</a> comments
	</div>

</div>
<%
	}
	} else {
		List<Post> results = p.searchPost(request
				.getParameter("search"));
		for (int i = 0; i < results.size(); i++) {
%>
<div id="news">
	<div id="news_top">
		<p>
			<a href="?page=post&id=<%=results.get(i).getPostID()%>"> <%=results.get(i).getTitle()%>
			</a>
		</p>
	</div>
	<hr class="style-two">



	<div id="news_text" class="news_text">
		<%=results.get(i).getBody()%>
	</div>

</div>
<%
	}
	}
%>