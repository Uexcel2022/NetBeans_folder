<%-- 
    Document   : cookieimplicitobj
    Created on : Aug 29, 2023, 11:04:35 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookie implicit El Object</title>
    </head>
    <body>
         <h2>Expression Language Implicit Objects</h2>
         
        <p>Cookie: ${cookie.cook.value}</p>
        
        <p>Param: ${param.username}</p>
        <p>Param: ${param.id}</p>
        
    </body>
</html>
