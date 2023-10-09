<%-- 
    Document   : newjsp
    Created on : Aug 16, 2023, 2:15:14 PM
    Author     : Uexcel
--%>

<%@page import="com.uexcel.model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <c:set var="str" value="All dogs go to heaven."></c:set>
        The length of the string: ${fn:length(str)}

        <c:forEach items="${fn:split(str,' ')}" var="s">
            <br><c:out value="${s}"></c:out>
        </c:forEach>

        <br>

        Index: ${fn:indexOf(str,'h')}

        <br>
        Contains "heaven": ${fn:contains(str,'heaven')}
        <br>
        <c:if test="${fn:contains(str,'heaven')}">
            Haven is there!<br/>
        </c:if>

        <%--
         when ${} fn methods will pop up
        --%>
        <h3>From person class object</h3>
        <%
            Person person = new Person();
            request.setAttribute("person", person);
        %>  

        <c:set var="firstName"  value="Blessing" target="person" scope="request"></c:set>
        <c:set var="lastName"  value="Faith" target="person"></c:set>
        <c:out value="${firstName}"></c:out><br/>
        <c:out value="${lastName}"></c:out>


    </body>
</html>
