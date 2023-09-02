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
        <title>Implicit Objects</title>
    </head>
    <body>
        <%

//            Cookie ck = new Cookie("udoka", "80");
//            response.addCookie(ck);
//            response.sendRedirect("j");
//            request.setAttribute("name", "udoka");
//            request.getRequestDispatcher("J").forward(request, response
//            config.getInitParameter("k");
              pageContext.setAttribute("name", "uexcel", PageContext.SESSION_SCOPE);
              pageContext.setAttribute("name", "uexcel");
//            String servletCongfig = config.getServletContext().getInitParameter("quality");
//            String weather = (String) request.getAttribute("weather");
//            String appName = (String) session.getAttribute("appName");
//            String name =(String) session.getAttribute("name");

//            session.setAttribute("name", "uexcel");
//            response.sendRedirect("j");

        %>
        
         <h2>Expression Language Implicit Objects</h2>
       
        
        <%--Fetching the value using only the key --%>

        <p>Session scope: ${appName}</p>
        <p>Request scope: ${weather}</p>
        <p>Servlet  context: ${initParam.quality}</p>
        <p>Page context session scope:  ${name}</p>
        
      
        <br>
        
        <%-- using implicit object and the key to fetching the value --%>
        
        <p>Session scope: ${sessionScope.appName}</p>
        <p>Request scope: ${requestScope.weather}</p>
        <p>Servlet context: ${initParam.quality}</p>
        <p>Page scope session:  ${sessionScope.name}</p>
        <p>Page scope:  ${pageScope.name}</p>
        <p>Application scope:  ${applicationScope.scope}</p>
        

    </body>
</html>
