<%-- 
    Document   : index
    Created on : Sep 6, 2023, 12:23:26 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:set var="user" value="${login}"></c:set>
        <c:choose>
            <c:when test="${user==null}">
                <a href="login.jsp">Login</a><br>
                <a href="login">See videos</a><br>
                <a href="about_us.jsp">About us</a><br>
            </c:when>
            <c:otherwise>
                <a href="login">See videos</a><br>
                <a href="about_us.jsp">About us</a><br>
                <a href="logout">Logout</a><br>
            </c:otherwise>
        </c:choose>


    </body>
</html>
