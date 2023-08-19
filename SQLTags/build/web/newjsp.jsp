<%-- 
    Document   : newjsp
    Created on : Aug 15, 2023, 10:54:18 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <sql:setDataSource var="db" driver="org.mariadb.jdbc.Driver"
                           url="jdbc:mariadb://localhost:3306/mydatabase" user="root" password="jvman19"/>
        <sql:query var="rs" dataSource="${db}">SELECT * FROM gadgets</sql:query>
        <c:forEach items="${rs.rows}" var="gadget">
        <br> <c:out value="${gadget.gid}" />:  <c:out value="${gadget.gname}" />: <c:out value="${gadget.price}" />
            
        </c:forEach>
      
    </body>
</html>
