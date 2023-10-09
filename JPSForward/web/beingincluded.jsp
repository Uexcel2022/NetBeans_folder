<%-- 
    Document   : included
    Created on : Sep 2, 2023, 5:32:00 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Being included</title>
    </head>
    <body>
        <h1>This page is included!</h1>
        <p>Result 4 + 2 = ${4+3}</p>
        <p>Name: ${param["name"]}</p>
    </body>
</html>
