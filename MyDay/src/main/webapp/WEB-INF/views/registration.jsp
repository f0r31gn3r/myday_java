<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Registration</title>
</head>
<body>
	<h1>Registration</h1>

	<form name="input" action="registration" method="post">
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="login" value=""></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td>-</td>
				<td>-</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value=""></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value=""></td>
			</tr>
			<tr>
				<td>-</td>
				<td>-</td>
			</tr>
		</table>
		<input type="submit" value="Register"> | <a href="/MyDay/">Go
			Home</a><br>
	</form>


</body>
</html>
