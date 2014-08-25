<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Registration</title>
</head>
<body>
	<h1>Registration</h1>

	<form:form method="POST" action="addAccount" commandName="account">
		<table>
			<tr>

				<td><FONT color="red"><form:errors
							path="login" /></FONT></td>

			</tr>
			<tr>
				<td>User Name:</td>
				<td><form:input path="login" /></td>
			</tr>
			<tr>

				<td><FONT color="red"><form:errors
							path="password" /></FONT></td>

			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>-</td>
				<td>-</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>-</td>
				<td>-</td>
			</tr>
		</table>
		<input type="submit" value="Register"> | <a href="/MyDay/">Go
			Home</a>
		<br>
	</form:form>


</body>
</html>
