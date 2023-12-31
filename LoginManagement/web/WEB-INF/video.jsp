<%-- 
    Document   : video
    Created on : Aug 17, 2023, 9:06:28 AM
    Author     : Uexcel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resources</title>
    </head>
    <body>

        <c:set var="user" value="${login}"></c:set>
        <c:choose>
            <c:when test="${user==null}">
                <c:redirect url="login.jsp"></c:redirect>
            </c:when>

            <c:otherwise>
                <%
                    response.setHeader("Cache-Control", "no -cache, no-store, must-revalidate"); //http 1.1
                    response.setHeader("Pragma", "no -cache");  // http 1.0
                    response.setHeader("Expires", "0");  //Proxies
                %>
                
                <h4>Welcome, ${user}...</h4>
                
                <iframe width="560" height="315" src="https://www.youtube.com/embed/BGTx91t8q50" title="YouTube video player" frameborder="0" 
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

                <br>
                <a href="index.jsp">Back to home page </a><br>
                <a href="logout">Logout</a> 
            </c:otherwise>

        </c:choose>

        <% //
            //            response.setHeader("Cache-Control", "no -cache, no-store, must-revalidate"); //http 1.1
            //            response.setHeader("Pragma", "no -cache");  // http 1.0
            //            response.setHeader("Expires", "0");  //Proxies
            //
            //            if (session.getAttribute("user") == null) {
            //                response.sendRedirect("login.jsp");
            //            } else {
            //                String user = session.getAttribute("user").toString();
            //            }
//        %>


    </body>
</html>
