<%-- 
    Document   : signup
    Created on : Oct 3, 2023, 8:58:49 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
        <style>
            .msg{
                color:red;
            }
        </style>
    </head>
    <body>
        <h1>Sign up</h1>
        <p class="msg">${msg}</p>
        <form action="create" method="post" >
            <p>First name: <input name="firstName" value="${fname}"></p>
            <p>Last name: <input name="lastName" value="${lname}"></p>
            <p>email: <input name="email" value="${mail}"></p>
            <p>Birthday <input name="Birthday" value="${birthday}"></p> 
            <p>Username: <input name="username" value="${user_name}"></p>
            <p>Password <input type="password" name="password"></p>
            <p>Re-enter password</p>
            <input type="password" name="cpassword">
            <input type="submit" value="Submit">
        </form>
        <p><a href="home">Home</a></p>
    </body>
</html>
