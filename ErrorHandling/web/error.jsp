<%-- 
    Document   : error
    Created on : Aug 13, 2023, 4:06:49 PM
    Author     : Uexcel
--%>

<%-- 4 SPECIAL TAGS 

1. Directive = for importing... <%@page name= "value"%>

2. Declaration = <%! %> for class or instance variable declaration

3. Scriptlet  = <%%> code enclosed will be part of service method

4. Expression = <%=vlaue %> for printing...

Tags--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="red">
        <%= exception.getMessage() %>
        <%out.println("error");%>
    </body>
</html>
