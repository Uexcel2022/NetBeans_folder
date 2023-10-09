<%-- 
    Document   : jspusebean
    Created on : Sep 2, 2023, 9:33:28 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.uexcel.model.Person"
        import="com.uexcel.model.Employee"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Use Bean </title>
        <style>
            body{
                line-height: 20px;
            }
        </style>
    </head>
    <body>
        
        <h2>JSP Use Bean</h2>
        <jsp:useBean id="emp"  class="com.uexcel.model.Employee" type="com.uexcel.model.Person"
                     scope="request"></jsp:useBean>
        First name: <jsp:getProperty name="emp" property="firstName"></jsp:getProperty><br>
        Last name: <jsp:getProperty name="emp" property="lastName"></jsp:getProperty><br>
        Salary: <jsp:getProperty name="emp" property="title"></jsp:getProperty><br>
        Tile: <jsp:getProperty name="emp" property="salary"></jsp:getProperty>

            <h2>Create Bean</h2>

        <jsp:useBean id="emp2"  class="com.uexcel.model.Employee" type="com.uexcel.model.Person" 
                     scope="request"></jsp:useBean>
        <jsp:setProperty name="emp2"  property="firstName" value="Victor"></jsp:setProperty>
        <jsp:setProperty name="emp2"  property="lastName" value="Williams"></jsp:setProperty>
        <jsp:setProperty name="emp2"  property="title" value="Seceretry"></jsp:setProperty>
        <jsp:setProperty name="emp2"  property="salary" value="807.98"></jsp:setProperty>

            First name: <jsp:getProperty name="emp2" property="firstName"></jsp:getProperty><br>
            Last name: <jsp:getProperty name="emp2" property="lastName"></jsp:getProperty><br>
            Tile: <jsp:getProperty name="emp2" property="title"></jsp:getProperty><br>
            Salary: <jsp:getProperty name="emp2" property="salary"></jsp:getProperty>
            
            <h2>Create Bean From Form</h2>
            <%-- First way   --%>
            <jsp:useBean id="person1" class="com.uexcel.model.Person">
                <jsp:setProperty name="person1" property="*"></jsp:setProperty>
            </jsp:useBean>
            
            First Name: <jsp:getProperty name="person1" property="firstName"></jsp:getProperty><br>
            Last Name: <jsp:getProperty name="person1" property="lastName"></jsp:getProperty><br>
          
            <hr>
             <%-- Second way      --%>
            
             <jsp:useBean id="person2" class="com.uexcel.model.Person">
                 <jsp:setProperty name="person2" property="firstName" param="first"></jsp:setProperty>
                 <jsp:setProperty name="person2" property="lastName" param="last"></jsp:setProperty>
             </jsp:useBean>
            
            First Name: <jsp:getProperty name="person2" property="firstName"></jsp:getProperty><br>
            Last Name: <jsp:getProperty name="person2" property="lastName"></jsp:getProperty>
     
            <hr>
           
            <jsp:useBean id="emp3" class="com.uexcel.model.Employee" 
                         type="com.uexcel.model.Person">
                
                <jsp:setProperty name="emp3" property="firstName"  param="eFirstName"></jsp:setProperty>
                <jsp:setProperty name="emp3" property="lastName" param="eLastName" ></jsp:setProperty>
                <jsp:setProperty name="emp3" property="title" param="title"></jsp:setProperty>
                <jsp:setProperty name="emp3" property="salary" param="salary" ></jsp:setProperty>
                
           </jsp:useBean>
            
            First Name: <jsp:getProperty name="emp3" property="firstName"></jsp:getProperty><br>
            Last Name: <jsp:getProperty name="emp3" property="lastName"></jsp:getProperty><br>
            Title: <jsp:getProperty name="emp3" property="title"></jsp:getProperty><br>
            Salary: <jsp:getProperty name="emp3" property="salary"></jsp:getProperty>
            
            
            

    </body>
</html>
