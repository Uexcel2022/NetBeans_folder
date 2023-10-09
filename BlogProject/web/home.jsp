<%-- 
    Document   : home
    Created on : Oct 5, 2023, 10:44:48 AM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <c:forEach var="data" items="${blog}">
            <c:url var="view" value="publicView">
                <c:param name="blog" value="${data.getBlog()} ${data.getBlogAuthor()}, ${data.getDate()}"></c:param>
            </c:url>
            <p> <a href="${view}">${data.getTitle()} ${data.getBlogAuthor()}, ${data.getDate()}</a></P
            </c:forEach>

        <p><a href="signup">Sign up</a></p>
        <p><a href="login">Login</a></p>
    </body>
</html>

