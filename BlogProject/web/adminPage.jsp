<%-- 
    Document   : adminPage
    Created on : Oct 5, 2023, 12:54:56 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body >

        <c:if test="${username == null || password == null }">
            <c:redirect url="login"></c:redirect>
        </c:if>

        <%
            response.setHeader("Cache-Control", "no -cache, no-store, must-revalidate"); //http 1.1
            response.setHeader("Pragma", "no -cache");  // http 1.0
            response.setHeader("Expires", "0");  //Proxies
        %>

        <h1>Welcome, ${fName}</h1>
        
        <c:url var="logout" value="logout">
                <c:param name="isLogjout" value="isLogjout"></c:param>
            </c:url>

        <p><a href="${logout}"><button>Logout</button></a>
            &nbsp;<a href="welcome"><button>Refresh</button></a>&nbsp;
            <a href="createBlog"><button>Add blog</button></a></P>

        <c:forEach var="data" items="${object}" varStatus="status" >
            <c:url var="view" value="privateView">
                <c:param name="blog" value="${data.getBlog()} ${data.getBlogAuthor()}, ${data.getDate()}"></c:param>     
                <c:param name="title" value="${data.getTitle()}"></c:param>
                <c:param name="index" value="${status.index}"></c:param>

            </c:url>
            <c:url var="makeBlog" value="makeBlog">
                <c:param name="blog" value="${data.getBlog()}"></c:param>
                <c:param name="title" value="${data.getTitle()}"></c:param>
                <c:param name="blogId" value="${data.getId()}"></c:param>
            </c:url>
            <p><a href="${view}">${data.getTitle()} </a> &nbsp;&nbsp;<a href="${makeBlog}"><button>Edit</button></a</P>
            </c:forEach>

    </body>
</html>
