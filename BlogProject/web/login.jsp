<%-- 
    Document   : login
    Created on : Oct 4, 2023, 5:58:15 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .msg{
                color:red
            }
        </style>
    </head>
    <body>
         <%
            response.setHeader("Cache-Control", "no -cache, no-store, must-revalidate"); //http 1.1
            response.setHeader("Pragma", "no -cache");  // http 1.0
            response.setHeader("Expires", "0");  //Proxies
        %>
        <h1>Login</h1>
        <p class="msg">${param.msg}</p>
        <form action="welcome" method="post">
            <p> Username: <input name="username" autocomplete="off"></p>
        <p> Password: <input type="password" name="password"></p>
        <input type="submit" value="Submit">
        </form>
        <p><a href="home">Home</a></p>
    </body>
</html>
