<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>comment_delete</title>
</head>
<body>
	<form:form method="POST" commandName="delete"
		action="/MyDay/comment_deleted">
		<table>
			<tr>
				<td><form:label path="commentID">CommentID</form:label></td>
				<td><form:input type="text" path="commentID" /></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>