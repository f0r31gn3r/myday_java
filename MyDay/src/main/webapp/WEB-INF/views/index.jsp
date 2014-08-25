<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	
	
	
<style type="text/css">
		<%@include file="/WEB-INF/views/css/index.css" %>
</style>
	
</head>
<body>

<!-- Site code start -->
<div id="site">

<!-- Header start -->
<div id="header">

<!-- Title start -->
<div id="title">
<h1>
	MyDay Java Bootcamp Project  
</h1>

<%
Date date = new Date();
String s = date.toString();
%>

<P>  The time on the server is <%= s %>. </P>
</div>
<!-- Title end -->

<!-- Login form start -->
<div id="login">
<%@include file="authorization.jsp" %>
</div>
<!-- Login form end -->

</div>
<!-- Header end -->



<!-- Main menu start -->
<div id="menu">
<a href="/MyDay">Main page</a><% if (session.getAttribute("user") != null) {%> | <a href="?page=create">New post</a><% } %>
</div>
<!-- Main menu end -->


<hr class="style-six"/>

<!-- Main body start -->
<div id="body">

<!-- Search start -->
<div id="search">

<script>

</script>

<input type="text" id="textSearch" value="Search"> 
<button onclick="window.location='?page=posts&search='+document.getElementById('textSearch').value; ">Search</button>

</div>
<!-- Search end -->

<!-- News start -->
<%

String central_page = request.getParameter("page");
if ( central_page == null)
	central_page ="posts";

	if ( central_page.equals("posts") ){
%>
<%@include file="posts.jsp" %>

<%
	}else if ( central_page.equals("registration") || (central_page.equals("registration.jsp")) ) {
%>
<%@include file="registration.jsp" %>

<%
	}else if ( (central_page.equals("result.jsp")) ) {
%>
<%@include file="result.jsp" %>

<%
	}else if (central_page.equals("post")) {
%>
<%@include file="post.jsp" %>
<%
	}else if (central_page.equals("post")) {
%>
<%@include file="post.jsp" %>
<%
	}else if (central_page.equals("create")) {
%>
<%@include file="new_post.jsp" %>


<%
	}else {
		System.out.println("debug :" + central_page);
%>
<%@include file="home.jsp" %>

<%
	}
%>
<!-- News end -->

<!-- Page counter start -->
<div id="page_counter">
<p>[1][2][3]</p>
</div>
<!-- Page counter end -->

</div>
<!-- Main body end -->

<hr class="style-six"/>

<!-- Footer start -->
<div id="footer">
<p>All rights reserved (c) 2014 Riga, LV</p>
</div>
<!-- Footer end -->

</div>
<!-- Site code end -->
   
</body>
</html>
