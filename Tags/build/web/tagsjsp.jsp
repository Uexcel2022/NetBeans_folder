<%-- 
    Document   : tagsjsp
    Created on : Aug 13, 2023, 6:46:53 PM
    Author     : Uexcel
--%>

<%-- 4 SPECIAL TAGS 

1. Directive = for importing... 

-@page like import package, or mention a page to handle exception

      <%@page attribute= "value" attribute= "value" ...% >

 Examples of attributes:
                                language="scripting language"   language here is java
                                extends="className"
                                import="importList"
                                session="true|flase"
                                autoFlush="true/false"
                                contentType="ctinfo"
                                errorPage="error_url"
                                isErrorPage="true|false"
                                info="Information"
                                isELIgnored="true|false"
                                isThreaSafe=true|false"
                                
               
-@include  if you to use other jsp file in the current project.
    
      eg <%@include file="newjsp.jsp" %>

-@taglib is about tags and the libary of tags
     
       eg <% taglib uri="uri" prefix="fx" %>
       usafe example = <fx:navin>

2. Declaration = <%! %> for class or instance variable declaration

3. Scriptlet  = <%%> code enclosed will be part of service method

4. Expression = <%=vlaue %> for printing...

Tags--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="newjsp.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! String fName = "Jide" ;%>
         <%! int num1 = 80; %>
        <%@page import="java.util.*" %>
        <h3>Hello World!</h3>
        <% out.println(3 + 5);%>
        <%= num1 %>
        <%= fName %>
    </body>
</html>
