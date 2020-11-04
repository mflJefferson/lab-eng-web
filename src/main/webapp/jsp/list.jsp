<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <title> Listagem de Usuários </title>
        <meta charset="utf-8">
    </head>
    <body>
    <h1>Test</h1>
        <%
			List<User> users = (List<User>) request.getAttribute("users");
            for(User user: users){
                out.print("User: " + user.getName() + "<br/>");
            }
        %>
    </body>
</html>