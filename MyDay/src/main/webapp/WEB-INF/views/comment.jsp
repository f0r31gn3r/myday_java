<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="lv.localhost.MyDay.DAO.AccountDAOImpl" %>
<%@ page import="lv.localhost.MyDay.DAO.CommentDAOImpl" %>
<%@ page import="lv.localhost.MyDay.Model.Comment" %>
<%@ page import="java.util.*" %>

<script type='text/javascript'>
	CharacterCount = function(TextArea, FieldToCount) {
		var myField = document.getElementById(TextArea);
		var myLabel = document.getElementById(FieldToCount);
		if (!myField || !myLabel) {
			return false
		}
		; // catches errors
		var MaxChars = myField.maxLengh;
		if (!MaxChars) {
			MaxChars = myField.getAttribute('maxlength');
		}
		;
		if (!MaxChars) {
			return false
		}
		;
		var remainingChars = MaxChars - myField.value.length
		myLabel.innerHTML = remainingChars
				+ " Characters Remaining of Maximum " + MaxChars
	}
	//SETUP!!
	setInterval(function() {
		CharacterCount('comment_body', 'CharCountLabel1')
	}, 55);
</script>
<%



CommentDAOImpl c = new CommentDAOImpl();

String commentAction = request.getParameter("comment_action");
if ( commentAction == null)
	commentAction ="display";

int postID = 0;
if (request.getParameter("id") != null)
{
	 postID = Integer.parseInt( request.getParameter("id") );
}

if ( commentAction.equals("delete") ){
	c.removeComment(  Integer.parseInt( request.getParameter("comment") ) );
	
	%>
	<script>
		window.location="?page=post&id=<%=postID%>";
	</script> 
	<%
}




int authorID=0;
if ( session.getAttribute("user") != null ){
	authorID = new AccountDAOImpl().getIDByLogin( session.getAttribute("user").toString() );
}


List <Comment> comments = c.getCommentList(postID);

for (int i = 0; i < comments.size(); i++){
	String authorName = new AccountDAOImpl().getLoginByID( comments.get(i).getAuthor() );
%>

<div id="news">

		<hr class="style-two">
		<div id="news_text">
		<%=comments.get(i).getBody() %>
		</div>
		
		<hr class="style-two">
		
		<div id="news_bottom">Date published: <%=comments.get(i).getCreated() %> | by <%=authorName %> <% 
			if ( session.getAttribute("user") != null)
			{
		    	
				if ( comments.get(i).getAuthor() == authorID  ) {
					
					String commentQueryString = request.getQueryString();
					String urlTodo ="?"+commentQueryString+"&comment=" + comments.get(i).getCommentID()+"&comment_action=delete";
				%>
					<a href="<%=urlTodo%>">[x]</a>
		     <% }
			}%>
		</div>
	
	</div>
<% 
} 
%>	

<% if (session.getAttribute("user") != null) {
	  authorID = new AccountDAOImpl().getIDByLogin(session.getAttribute("user").toString());

	%>   
	<form name="input" action="comment"  method="post">
		<input name="authorID" type="hidden" value="<%=authorID%>"/>
        <input name="postID" type="hidden" value="<%=postID%>"/>
		<textarea rows="4" cols="50" id="comment_body" name="body" maxlength="200">some text</textarea>
		<input type="submit" value="Add Comment" />
	</form>
	<div id='CharCountLabel1'></div>
	
<%
}
%>
