    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ page import="lv.localhost.MyDay.DAO.PostDAOImpl" %>
<%@ page import="lv.localhost.MyDay.Model.Post" %>
<%@ page import="java.util.Enumeration" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<%

PostDAOImpl pi = new PostDAOImpl();

System.out.println("\n" + request.getParameter("id"));

%>

<form>
<table>
<tr>
        <td>PostID</td>
        <td><input type="text" name="postPostID" value="<%=  %>"/></td>
    </tr>
    <tr>
        <td>AuthorID</td>
        <td><input type="text" name="postAuthID" value="<%=  %>"/></td>
    </tr>
    <tr>
        <td>Title</td>
        <td><input type="text" name="postTitle" value="<%=  %>"/></td>
    </tr>
    <tr>
        <td>Text</td>
        <td><textarea rows="10" name="postBody" cols="100" id="body"><%=  %></textarea></td>
       
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" name="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form>
        	
        
</body>
</html>