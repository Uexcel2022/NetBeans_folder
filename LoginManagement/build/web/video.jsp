<%-- 
    Document   : video
    Created on : Aug 17, 2023, 9:06:28 AM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resources</title>
    </head>
    <body>
        <br>
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

        <iframe width="560" height="315" src="https://www.youtube.com/embed/BGTx91t8q50" title="YouTube video player" frameborder="0" 
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

        <br>
        <a href="welcome.jsp">Back to welcome  </a><br>
        <a href="index.html">Back to home page </a><br>
        <a href="logout">Logout</a> 


    </body>
</html>
