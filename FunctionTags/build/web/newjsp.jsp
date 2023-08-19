<%-- 
    Document   : newjsp
    Created on : Aug 16, 2023, 2:15:14 PM
    Author     : Uexcel
--%>

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
            <br> ${s}
        </c:forEach>

        <br>

        Index: ${fn:indexOf(str,'h')}

        <br>

        Contains "heaven": ${fn:contains(str,'heaven')}
        <br>
        <c:if test="${fn:contains(str,'heaven')}">
            Haven is there!
        </c:if>
        
            <%--
             when ${} fn methods will pop up
            --%>
    </body>
</html>
