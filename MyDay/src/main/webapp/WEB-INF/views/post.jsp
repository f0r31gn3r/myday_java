<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="lv.localhost.MyDay.DAO.PostDAOImpl" %>
<%@ page import="lv.localhost.MyDay.Model.Post" %>
<%@ page import="lv.localhost.MyDay.DAO.AccountDAOImpl" %>
<%@ page session="true" %>

<style type="text/css">
#news{
	border:1px solid #cecece;
		border-radius:10px;
		box-shadow: 3px 3px 3px #888888;
		padding: 10px 10 10px 10;
		margin: 20px auto 20px auto;
	}
p{
	text-align:center;
	}
#news_text{
	margin:10px 10px 10px 10px;
	font-size:14px;
	}
	#news_bottom{
	width:350px;
	margin-left:auto;
	font-size: 12px;
	}
</style>



<%


Post p = new PostDAOImpl().findPost( Integer.parseInt( request.getParameter("id") )  );

String queryString = request.getQueryString();

String action = request.getParameter("action");
if ( action == null)
	action ="display";


if ( action.equals("display") ){
%>
 	<div id="news">
		<div id="news_top"><p> <%=p.getTitle() %></p></div>
		<% 
			if ( session.getAttribute("user") != null)
			{
		    	int authorID = new AccountDAOImpl().getIDByLogin( session.getAttribute("user").toString() );
				if ( p.getAuthorID() == authorID  ) {%>
					<a href="?<%=queryString  %>&action=edit">Edit post</a> | <a href="?<%=queryString  %>&action=delete">Delete post</a>
		     <% }
			}%>
				
			<hr class="style-two">
		<div id="news_text">
		<%=p.getBody() %>
		</div>
		
		<hr class="style-two">
		
		<div id="news_bottom">Date published: <%=p.getCreated() %> | Comment ($_COM)</div>
	
	</div>
	
	<%@include file="comment.jsp" %>
<%
}else if (action.equals("edit")) {
%>

<form method="post" action="/MyDay/post_edit">
<input type="hidden" name="postAuthID" value="<%= p.getAuthorID() %>"/>
<input type="hidden" name="postPostID" value="<%= p.getPostID() %>"/>
<table>
    <tr>
        <td>Title</td>
        <td><input type="text" name="postTitle" value="<%= p.getTitle() %>"/></td>
    </tr>
    <tr>
        <td>Text</td>
        <td><textarea rows="10" name="postBody" cols="100" id="body"><%= p.getBody() %></textarea></td>
       
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" name="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form>

<%
}else if (action.equals("delete")) {
	PostDAOImpl i = new PostDAOImpl();
	i.removePost(p.getPostID());
	
	%>
	<script>
		window.location="?page=posts";
	</script> 
	<%
} %>
    


