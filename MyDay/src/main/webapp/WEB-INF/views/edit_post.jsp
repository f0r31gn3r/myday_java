<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form method="POST" commandName="edit" action="/MyDay/edited">
   <table>
    <tr>
        <td><form:label path="authorID">AuthorID</form:label></td>
        <td><form:input type="text" path="authorID"/></td>
    </tr>
    <tr>
        <td><form:label path="title">Title</form:label></td>
        <td><form:input type="text" path="title"/></td>
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

</body>
</html>