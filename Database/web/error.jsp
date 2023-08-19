<%-- 
    Document   : error
    Created on : Aug 14, 2023, 5:42:20 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body bgcolor="red">
        <h3>We encountered error!</h3>
        Description: <%=exception%>
    </body>
</html>
