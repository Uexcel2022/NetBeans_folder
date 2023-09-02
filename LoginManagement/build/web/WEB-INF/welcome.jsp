<%-- 
    Document   : welcome
    Created on : Aug 17, 2023, 9:06:00 AM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
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
                    request.getRequestDispatcher("video.jsp").forward(request,response);
                %>
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
