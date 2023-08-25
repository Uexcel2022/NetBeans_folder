<%-- 
    Document   : newjsp
    Created on : Aug 15, 2023, 2:55:53 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Records</title>
    </head>
    <body>
        <br>
        <c:forEach items ="${Person}" var= "s" varStatus="status" step="1" begin="0">
            <%-- status.count, status.index, --%>
            First name: ${s.fName} <br>
            Last name: ${s.lName} <br>
            Gender: ${s.gender} <br>
            Phone: ${s.phone} <br>
            Email: ${s.email} <br><br>       
    </c:forEach>
        
          <
        
    <
        <%--
        for one object at a time
        First name: <c:out value="${Person.fName}"/><br>
        Last name: <c:out value="${Person.lName}"/><br>
        Gender: <c:out value="${Person.gender}"/><br>
        Phone: <c:out value="${Person.phone}"/><br>
        email: <c:out value="${Person.email}"/>
        --%>
    </body>
</html>
