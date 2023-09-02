<%-- 
    Document   : form.
    Created on : Sep 1, 2023, 10:03:00 PM
    Author     : Uexcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
        <style>
        label {
            line-height: 32px;
        }

        fieldset {
            width: 100px;
        }

        body {
            display: flex;
            justify-content: center;
        }
    </style>
    </head>
    
    <body>
        
            <form action="controller" method="post">
                <fieldset>
                    <legend>personal info:</legend>

                    <label>First name: </label><br> <input name="fName" ><br>
                    <label>Last name: </label><br> <input name="lName"><br>
                    <label>Email: </label><br> <input type="email" name="email"><br>
                    <label>Password: </label><br> <input type="password"
                                                         name="password"><br>
                    <label> Confirm Password: </label><br> <input type="password"
                                                                  name="confirmPassword"><br> 

                    <input type="radio" name="gender" value="male"><label>male
                    </label> <input type="radio" name="gender" value="female"> <label>female</label><br>

                    <button type="submit">Submit</button>

                </fieldset>
            </form>
       
    </body>
</html>

