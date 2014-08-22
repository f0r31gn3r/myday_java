<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>comment_create</title>

<script type='text/javascript'>
	CharacterCount = function(TextArea, FieldToCount) {
		var myField = document.getElementById(TextArea);
		var myLabel = document.getElementById(FieldToCount);
		if (!myField || !myLabel) {
			return false
		}
		; // catches errors
		var MaxChars = myField.maxLengh;
		if (!MaxChars) {
			MaxChars = myField.getAttribute('maxlength');
		}
		;
		if (!MaxChars) {
			return false
		}
		;
		var remainingChars = MaxChars - myField.value.length
		myLabel.innerHTML = remainingChars
				+ " Characters Remaining of Maximum " + MaxChars
	}
	//SETUP!!
	setInterval(function() {
		CharacterCount('body', 'CharCountLabel1')
	}, 55);
</script>

</head>
<body>
	<form:form method="POST" commandName="create"
		action="/MyDay/comment_created">
		<table>
			<tr>
				<td><form:label path="postID">PostID</form:label></td>
				<td><form:input type="text" path="postID" /></td>
				<td><form:label path="author">AuthorID</form:label></td>
				<td><form:input type="text" path="author" /></td>
			</tr>
			<tr>
				<td><form:label path="body">Body</form:label></td>
				<td><form:textarea rows="4" cols="50" id="body" path="body"
						maxlength="1000" /></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<div id='CharCountLabel1'></div>
</body>
</html>