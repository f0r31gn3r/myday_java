<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new post</title>

<script type='text/javascript'>
CharacterCount = function(TextArea,FieldToCount){
	var myField = document.getElementById(TextArea);
	var myLabel = document.getElementById(FieldToCount); 
	if(!myField || !myLabel){return false}; // catches errors
	var MaxChars =  myField.maxLengh;
	if(!MaxChars){MaxChars =  myField.getAttribute('maxlength') ; }; 	if(!MaxChars){return false};
	var remainingChars =   MaxChars - myField.value.length
	myLabel.innerHTML = remainingChars+" Characters Remaining of Maximum "+MaxChars
}

//SETUP!!
setInterval(function(){CharacterCount('body','CharCountLabel1')},55);
</script>
</head>
<body>


<h1>Create new post</h1><br/>

<form:form method="POST" commandName="create" action="/MyDay/created">
   <table>
    <tr>
        <td><form:label path="authorID">AuthorID</form:label></td>
        <td><form:input type="text" path="authorID" /></td>
    </tr>
    <tr>
        <td><form:label path="title">Title</form:label></td>
        <td><form:input type="text" path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="body">ID</form:label></td>
        <td><form:textarea rows="4" cols="50" id="body" path="body" maxlength="1000"/></td>
       
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
 <div id='CharCountLabel1'></div>
</body>
</html>