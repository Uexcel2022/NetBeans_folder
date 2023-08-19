<%-- 
    Document   : registration
    Created on : Aug 15, 2023, 9:04:17 AM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <%! 
        String fName, lName, gender, phone, email, username ,password1, password2;
        %>
        <% 
            fName = request.getParameter("firsName");
            lName = request.getParameter("lastName");
            gender = request.getParameter("gender");
            phone = request.getParameter("phone");
            email = request.getParameter("email");
            username = request.getParameter("username");
            password1 = request.getParameter("password1");
            password2 = request.getParameter("password2");
            
           if(!password1.equals(password2)){
              out.print("Passwor mismatched!");
              return;
            }
            
           String[] credentials ={fName, lName, gender, phone, email, username ,password1, password2};
           for(String n: credentials){
              if(n==null){
              out.println("One or more fields are empty!  Please fill the form properly.");
              return;
            }
          }
          
         Class.forName("org.mariadb.jdbc.Driver");
         String user = "root", password="jvman19", url="jdbc:mariadb://localhost:3306/mydatabase";
         Connection con = DriverManager.getConnection(url,user,password);
          
         String query = String.format("INSERT INTO login VALUES('%s','%s','%s','%s','%s','%s','%s')", 
                 fName,lName,gender,phone,email,username,password1);
        
         Statement st = con.createStatement();
         st.executeQuery(query);
         out.println("Data sumitted successfully!");

        %>
        
        <%--
        First name: <%= fName %><br>
        Last name: <%= lName %><br>
        Gender: <%= gender %><br>
        Phone: <%= phone %><br>
        Email: <%= email %><br>
        Username: <%= username %><br>
        Password: <%= password1 %>
        --%>
       
        
    </body>
</html>
