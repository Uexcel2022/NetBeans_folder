<%-- 
    Document   : showBlog
    Created on : Oct 3, 2023, 5:08:08â¯PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
    </head>
    <body>
        ${blog}
        <p><a href="${callOrign}">Back</a></p>
    </body>
</html>
