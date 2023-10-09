<%-- 
    Document   : include
    Created on : Sep 2, 2023, 5:34:53 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <p>I'm learning JSP include action</p>
        <p>Before included the page</p>

        <%--
                Setting "flush" attribute to "true",  forward orl cookie or other headers and
                other lines of code after the forward  will be ignored when the line gets executed.
        --%>

        <jsp:include page="beingincluded.jsp" flush="true">
            <jsp:param name="name" value="excel"></jsp:param>
        </jsp:include>

        <jsp:forward page="result.jsp">
            <jsp:param name="name" value="uexcel"></jsp:param>
            <jsp:param name="title" value="JSPAction"></jsp:param>
        </jsp:forward>

        <p>After the included page</p>

    </body>
</html>
