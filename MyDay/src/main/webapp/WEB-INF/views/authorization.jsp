<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<style type="text/css">
		<%@include file="/WEB-INF/views/css/authorization.css" %>
</style>

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
	<input type="submit" value="Sign In"> | <a href="?page=registration"> Sign Up</a>
</form> 
<%}
else {%>
	<P> Logged as <c:out value="[${user}]" /> </P>
	<a href="authorization?logout=true">Log Out</a>
<% } %>
</div>