<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Registration</title>
</head>
<body>
<h1>
	Registration
</h1>

<form name="input" action="registration" method="post">
	Username : <input type="text" name="username" ><br>
	Password : <input type="password" name="password"><br>
	<input type="submit" value="Register">
</form> 
<a href="home">Go Home</a> page<br>

</body>
</html>
