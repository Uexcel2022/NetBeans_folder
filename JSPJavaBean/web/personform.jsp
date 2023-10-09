<%-- 
    Document   : personform
    Created on : Sep 3, 2023, 4:18:44 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person Form</title>
        <style>
            body{
                line-height: 24px;
            }
        </style>
    </head>
    <body>
        <form action="jspusebean.jsp">
            <label>First name</label><br>
            <input name="firstName"><br>
            <label>last name</label><br>
            <input name="lastName"><br>
            
            <br>
            <hr>
            
            <label>First name</label><br>
            <input name="first"><br>
            <label>last name</label><br>
            <input name="last"><br>
            
            <br>
            <hr>
            
            <label>First name</label><br>
            <input name="eFirstName"><br>
            <label>last name</label><br>
            <input name="eLastName"><br>
            <label>Title</label><br>
            <input name="title"><br>
            <label>Salary</label><br>
            <input name="salary"><br>
            
            <button type="submit">Submit</button>
            
        </form>
    </body>
</html>
