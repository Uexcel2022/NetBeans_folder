<%-- 
    Document   : index
    Created on : Oct 3, 2023, 4:56:03 PM
    Author     : Uexcel
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Make Blog</title>
        <style>
            body{
                background-color: #728C69;
                text-align:center;
            }
            .outer{
                display:flex;
                justify-content: center;
                align-items: center;
                min-width:800px;

            }
            .txt{
                min-width:800px;
            }

            .area{
                display:flex;
                flex-grow:1;
                background-color: #DCD7A0;
            }
        </style>
    </head>
    <body>

        <c:if test="${username == null || password == null }">
            <c:redirect url="login"></c:redirect>
        </c:if>

        <%
            response.setHeader("Cache-Control", "no -cache, no-store, must-revalidate"); //http 1.1
            response.setHeader("Pragma", "no -cache");  // http 1.0
            response.setHeader("Expires", "0");  //Proxies
        %>

        <h1>Welcome, ${fName}</h1>
        <p><a href="welcome">Back</a></p>
        <c:set var= "ft" value="${blog_text}"></c:set>
        <p id="test"><c:out value="${ft}"></c:out></p>
            <div class= "outer">
                <div class="txt">
                    <form action="makeBlog" method="post">
                        <input type="submit" value="Submit">
                        <p><input name="title" size="50" value="${blogTitle}" placeholder="Write blog title here" required="on"></P>
                    <p><input name="author" size="50" value="Published by ${fName} ${lName}" placeholder="Write blog title here" required="on"></P>
                    <textarea name="textArea" placeholder="Write your blog here"  rows="40" cols="100" class="area" id="string" ></textarea>
                </form> 
                <script>
                    let blogtxt = document.getElementById("test").innerHTML;
                    document.getElementById("string").innerHTML = blogtxt;
                    document.getElementById("test").innerHTML = "";
                </script>
            </div>
        </div>
    </body>
</html>