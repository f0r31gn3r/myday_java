<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<%@include file="visit.jsp" %>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  Test is ${test}. </P>
<a href="dosomething">do something</a> page<br>
<a href="authorization">authorization</a> page<br>
<a href="visit">visit register</a> page<br>
<br/> 
Include test :
<%@include file="authorization.jsp" %>
</body>
</html>
