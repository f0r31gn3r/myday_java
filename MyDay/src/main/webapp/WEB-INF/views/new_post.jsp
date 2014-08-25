
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page import="lv.localhost.MyDay.DAO.PostDAOImpl" %>
<%@ page import="lv.localhost.MyDay.Model.Post" %>
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

<%

%>

<form>
<table>
    <tr>
        <td>AuthorID</td>
        <td><input type="text" name="authorID"/></td>
    </tr>
    <tr>
        <td>Title</td>
        <td><input type="text" name="title"></td>
    </tr>
    <tr>
        <td>Text</td>
        <td><textarea rows="10" cols="100" id="body" name="body" ></textarea></td>
       
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form>

 <div id='CharCountLabel1'></div>
</body>
</html>