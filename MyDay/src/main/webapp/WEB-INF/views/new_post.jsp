<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="lv.localhost.MyDay.DAO.AccountDAOImpl" %>
<%@ page session="true" %>  


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


<h1 align=center>Create new post</h1><br/>

<% 
 	int authorID = new AccountDAOImpl().getIDByLogin( session.getAttribute("user").toString() );
%>
<form method="POST" action="/MyDay/new_post">
   <table>
    <tr>
        <td><label>Title</label></td>
        <td>
        	<input type="text" name="title" />
        	<input type="hidden" name="authorID" value="<%=authorID %>">
        </td>
        
    </tr>
    <tr>
        <td></td>
        <td>
        	<textarea rows="4" cols="50" id="body" name="body" maxlength="1000"></textarea>
        </td>
       
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form>
 <div id='CharCountLabel1'></div>
