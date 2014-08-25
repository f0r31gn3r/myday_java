<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	<style>
	.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
#login-box {
	width: auto;
	padding: 20px;
	margin: 10px auto;
}
</style>
</head>
<body>
<div><P> <font color="red">${badlogin}</font></p></div>
<div id="login-box">
<%	if (session.getAttribute("user") == null) {
%>
<form name="input" action="authorization" method="post">
<c:if test="${not empty authorization_message}">
			<div class="error">${authorization_message}</div>
		</c:if>

	<input type="text" name="login" value="login" onclick="if(this.value == 'login') {this.value=''}"><br>
	<input type="password" name="password" value="password" onclick="if(this.value == 'password') {this.value=''}"><br>
	<input type="submit" value="Sign In"> | <a href="registration"> Sign Up</a>
</form> 
<%}
else {%>
	<P> Logged as <c:out value="[${user}]" /> </P>
	<a href="authorization?logout=true">Log Out</a>
<% } %>
</div>
</body>
</html>
