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
  <table>
  	<tr>
  		<td>User Name:</td>
  		<td><input type="text" name="username" value=""></td>
  	</tr>	
   	<tr>
   	  	<td>Password:</td>
  		<td> <input type="password" name="password" value=""></td>
  	</tr> 
  	<tr>
  		<td>-</td>
  		<td>-</td>
  	</tr>  	
    <tr>
   	  	<td>Nickname:</td>
  		<td> <input type="text" name="nickname" value=""></td>
  	</tr>
    <tr>
   	  	<td>First Name:</td>
  		<td><input type="text" name="firstname" value=""></td>
  	</tr> 
    <tr>
   	  	<td>Last Name:</td>
  		<td><input type="text" name="lastname" value=""></td>
  	</tr>
    <tr>
  		<td>-</td>
  		<td>-</td>
  	</tr> 
  </table>	
	<input type="submit" value="Register"> | <a href="/MyDay/">Go Home</a><br>
</form> 


</body>
</html>
