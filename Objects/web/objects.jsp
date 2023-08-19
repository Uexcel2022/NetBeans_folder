<%-- 
    Document   : objects
    Created on : Aug 14, 2023, 11:19:34 AM
    Author     : Uexcel
--%>
<%--

--%>
<%--
Implicit Objects 
-request (HttpServletRequest)
-response (HttpServletResponse)
-pageCentext (PageContext)
-out (JSWriter) PrintWriter obj
-session (HttpSession)
-Application (ServletContext)
-config ServletConfig)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            request.getParameter("name");
            
            Cookie ck = new Cookie("udoka", "80");
            response.addCookie(ck);
//            response.sendRedirect("j");
   
            request.setAttribute("name", "udoka");
//            request.getRequestDispatcher("J").forward(request, response);
 
            pageContext.setAttribute("name", "Udoka",PageContext.SESSION_SCOPE);
            
            config.getInitParameter("k");
            
            session.getAttribute("K");
            session.setAttribute("name", "udoka");
//            response.sendRedirect("j");
         
        %>
    </body>
</html>
