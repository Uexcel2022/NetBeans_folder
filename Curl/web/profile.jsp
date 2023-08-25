<%-- 
    Document   : displayprofile
    Created on : Aug 23, 2023, 12:15:43 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <%--
        c:url can be used to create url of a page held by the variable defined in the expression
         eg <c:url var="display" value="/displayprofile.jsp">
        c:url can be use  used with param to pass a value to other page 
        --%>

        <c:url var="firstName" value="Excllence" scope="request" ></c:url>
        <c:url var="lastName" value="Udoka" scope="request"></c:url>
        
        <c:url var="display" value="displayprofile.jsp">
            <c:param name="firstName" value="${firstName}"></c:param>
            <c:param name="lastName" value="${lastName}"></c:param>
        </c:url>

        <c:redirect url="${display}"></c:redirect>

    </body>
</html>
