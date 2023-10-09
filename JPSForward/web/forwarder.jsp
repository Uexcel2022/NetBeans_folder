<%-- 
    Document   : index
    Created on : Sep 2, 2023, 4:18:13 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Forwarded:Welcome!</h1>
        <jsp:forward page="result.jsp">
            <jsp:param name="name" value="uexcel"></jsp:param>
            <jsp:param name="title" value="JSPAction"></jsp:param>
        </jsp:forward>
    </body>
</html>
