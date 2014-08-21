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
<div><P> <font color="red">${badlogin}</font></p></div>

<%	if (session.getAttribute("user") == null) {
%>
<form name="input" action="authorization" method="post">
	<input type="text" name="login" value="login" onclick="if(this.value == 'login') {this.value=''}"><br>
	<input type="password" name="password" value="password" onclick="if(this.value == 'password') {this.value=''}"><br>
	<input type="submit" value="Sign In"> | <a href="registration"> Sign Up</a>
</form> 
<%}
else {%>
	<P> Logged as <c:out value="[${user}]" /> </P>
	<a href="authorization?logout=true">Log Out</a>
<% } %>
</body>
</html>
