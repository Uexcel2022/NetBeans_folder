<%-- 
    Document   : welcome
    Created on : Aug 17, 2023, 9:06:00 AM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>

        <%

            response.setHeader("Cache-Control", "no -cache, no-store, must-revalidate"); //http 1.1
            response.setHeader("Pragma", "no -cache");  // http 1.0
            response.setHeader("Expires", "0");  //Proxies
            if (session.getAttribute("user") == null) {
                response.sendRedirect("login.jsp");
            } else {
                String user = session.getAttribute("user").toString();
            }

        %>

        <h4>Welcome, ${user}...</h4><br>
        <a href="video.jsp">See videos</a><br>
        <a href="index.html">Back to home page </a><br>
        <a href="about_us.jsp">About us</a><br>
        <a href="logout">Logout</a>

    </body>
</html>
