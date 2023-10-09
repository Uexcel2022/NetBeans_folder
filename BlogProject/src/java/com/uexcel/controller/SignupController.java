/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.controller;


import com.uexcel.domain.UserRegistration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * @author Uexcel
 */
@WebServlet(value = {"/create"})
public class SignupController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        UserRegistration reg = new UserRegistration();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String birthday = req.getParameter("Birthday");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password2 = req.getParameter("cpassword");
        reg.setFirstName(firstName);
        reg.setLastName(lastName);
        reg.setEmail(email);
        reg.setBirthday(birthday);
        reg.setUsername(username);
        reg.setPassword(password);
        reg.setPassword2(password2);
        String insertConfirmation = reg.inserUser();
        if (!insertConfirmation.equals("success")) {
            req.setAttribute("fname", firstName);
            req.setAttribute("lname", lastName);
            req.setAttribute("mail", email);
            req.setAttribute("birthday", birthday);
            req.setAttribute("user_name", username);
            req.setAttribute("msg", insertConfirmation);
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        } else if (insertConfirmation.equals("success")) {
            resp.getWriter().append(
                    "<h3>You have signed up successfully.</h3><a href=\"create\">Back</a>");
        }
    }
}
