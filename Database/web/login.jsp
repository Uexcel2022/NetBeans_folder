<%-- 
    Document   : jdbcjsp
    Created on : Aug 14, 2023, 3:34:39 PM
    Author     : Uexcel
--%
<%--
JDBC STEPS
1. Import sql package
2. Load the driver
3. Create statement
4. Create query
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%! 
           
          String firstName = "";
          String lastName = "";
          String phone = "";
          String gender = "";
          String email = "";
          String password = "";
          String username = "";
          Connection conn;
          
        %>
        <%
            username = request.getParameter("username");
            password= request.getParameter("password");
            String user = "root";
            String pwd = "jvman19";
            String url ="jdbc:mariadb://localhost:3306/mydatabase";
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            Statement statment = conn.createStatement();
            String query = String.format("Select * from login where Username = '%s' and Password='%s'",username,password);
            ResultSet rs = statment.executeQuery(query);
          
            if(rs.next()){
               firstName = rs.getString("FirstName");
               lastName =rs.getString("LastName");
               gender =rs.getString("Gender");
               phone =rs.getString("Phone");
               email = rs.getString("Email");
            }  

            if(firstName.isEmpty()){
            out.println("Invalid login credentials!");
            return;
            }
            
        %>
        
        First name: <%=firstName%><br>
        Last name <%=lastName%> <br>
        Gender: <%=gender%> <br>
        Phone: <%=phone%> <br>
        Email <%=email%> <br>
        
        <%
             firstName = "";
             lastName = "";
             gender = "";
             phone = "";
             email = "";
             username= "";
             password = "";
             conn.close();
        %>
        
    </body>
</html>
