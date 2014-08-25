    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ page import="lv.localhost.MyDay.DAO.PostDAOImpl" %>
<%@ page import="lv.localhost.MyDay.Model.Post" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<%
PostDAOImpl pi = new PostDAOImpl();
Post p2 = new Post();

p2 = pi.findPost(5);
int authorID = p2.getAuthorID();
String title = p2.getTitle();
String body = p2.getBody();
int postID = p2.getPostID();

%>

<form>
<table>
<tr>
        <td>PostID</td>
        <td><input type="text" value="<%= postID %>"/></td>
    </tr>
    <tr>
        <td>AuthorID</td>
        <td><input type="text" value="<%= authorID %>"/></td>
    </tr>
    <tr>
        <td>Title</td>
        <td><input type="text" value="<%= title %>"/></td>
    </tr>
    <tr>
        <td>Text</td>
        <td><textarea rows="10" cols="100" id="body"><%= body %></textarea></td>
       
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form>
        	
        
</body>
</html>