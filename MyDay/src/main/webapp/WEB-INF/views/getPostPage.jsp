<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Checking get/post request methods 
</h1>

<form name="input" action="getPostPage" method="post">
	First name: <input type="text" name="firstname"><br>
	Last name: <input type="text" name="lastname">
	<input type="submit" value="Submit">
</form> 

</body>
</html>
