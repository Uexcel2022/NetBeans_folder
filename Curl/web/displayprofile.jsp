<%-- 
    Document   : displayprofile
    Created on : Aug 23, 2023, 12:58:13 PM
    Author     : Uexcel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>profile</title>
    </head>
    <body>
        <p>Profile:</p>
        <p>First name: ${param.firstName}</p>
        <p>Last name: ${param.lastName}</p><br>
        
        <a href="<c:url value="index.jsp"></c:url>">Back</a>
       
    </body>
</html>
