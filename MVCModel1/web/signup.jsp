<%-- 
    Document   : form
    Created on : Sep 1, 2023, 8:20:28 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.uexcel.model.User"
        import="java.time.LocalDateTime" import="java.util.*" errorPage="error.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sing up</title>
    </head>
    <body>

        <%
	
        User user = new User();
        String firstName = (String) request.getParameter("fName");
        String lastName = (String) request.getParameter("lName");
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        String gender = (String) request.getParameter("gender");
        LocalDateTime date = LocalDateTime.now();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreatedAt(date);

        pageContext.setAttribute("newUser", user);

        String[] array = {firstName, lastName, email, password, gender };

        pageContext.setAttribute("array", array);
	
        %>

        <c:forEach items="${array}"  var="item">

            <c:if test="${item==null || item.isBlank()}">

                <c:redirect url="form.jsp"></c:redirect>

            </c:if>

        </c:forEach>

        <c:if test="${param.password != param.confirmPassword}">
            <c:redirect url="form.jsp"></c:redirect>
        </c:if>

        <c:set
            value="${fn:substring(newUser.createdAt,0,fn:indexOf(newUser.createdAt,'.'))}"
            var="time"></c:set>
        <H1><%="Signed up... thank you!"%></H1>

        <h3>Your details:</h3>
        <p>First name: ${newUser.firstName}</p>
        <p>Last name: ${newUser.lastName}</p>
        <p>Gender: ${newUser.gender}</p>
        <p>Email: ${newUser.email}</p>
        <%--- for practice purpose --%>
        <p>Password: ${newUser.password}</p>
        <p>Date: ${fn:replace(time, "T", " ")}</p>

    </body>
</html>
