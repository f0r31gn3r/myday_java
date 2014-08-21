<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	 Authorization:
</h1>
	${badlogin}

<%	if (session.getAttribute("user") == null) {
%>
<form name="input" action="getPostPage" method="post">
	Login:    <input type="text" name="login"><br>
	Password: <input type="password" name="password"><br>
	<input type="submit" value="Sign In">
</form> 
<%}
else {%>
	<P> Logged as <c:out value="${user}" /> </P>
<% } %>
</body>
</html>
