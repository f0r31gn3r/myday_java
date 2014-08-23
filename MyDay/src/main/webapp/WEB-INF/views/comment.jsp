<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
   
	<form name="input" action="comment"  method="post">
		<table>
			<tr>		
				<td><input name="postID" type="hidden" value="1"/></td>
				<td><input name="author" type="hidden" value="1"/></td>
			</tr>
			<tr>
				<td><textarea rows="4" cols="50" name="body" maxlength="200">some text</textarea></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<div id='CharCountLabel1'></div>
	[<a href="comment?delete=11">remove comment</a>]
