<%-- 
    Document   : login
    Created on : Aug 17, 2023, 9:08:51 AM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

    <c:set var="user" value="${login}"></c:set>

    <c:choose>
        
      
        
        <c:when test="${user==null}">
            
            <form action="login" method="post">
                
                <label>Username:</label>
                <input type="text" name="username" autocomplete="off" required><br><br>
                <label>Password:</label>
                <input type="password" name="password" required=""><br><br>
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                &nbsp;
                <button type="submit">Submit</button>

            </form><br>

            <a href="index.html">Back to home page </a><br>
            <a href="about_us.jsp">About Us</a>
            
        </c:when>

        <c:otherwise>
            <c:url value="welcome.jsp" var="welcome"></c:url>
            <c:redirect url="${welcome}"></c:redirect>
        </c:otherwise>

    </c:choose>

</body>
</html>
