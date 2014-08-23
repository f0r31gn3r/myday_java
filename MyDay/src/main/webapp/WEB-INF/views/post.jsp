<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*" %>
<%@ page import="lv.localhost.MyDay.DAO.PostDAOImpl" %>
<%@ page import="lv.localhost.MyDay.Model.Post" %>
<%@ page session="true" %>

<html>
<head>
<title>Home</title>
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
</head>
<body>
<%
PostDAOImpl p = new PostDAOImpl();
List <Post> posts = p.findLatestPosts();

for (int i = 0; i < posts.size(); i++){
%>
	<div id="news">
   <div id="news_top"><p> <%=posts.get(i).getTitle() %> </p></div>
   <hr class="style-two">

<div id="news_text">
<%=posts.get(i).getBody() %>
</div>

<hr class="style-two">

<div id="news_bottom">Date published: <%=posts.get(i).getCreated() %> | Comment ($_COM)</div>
</div>
<% } %>

</body>
</html>