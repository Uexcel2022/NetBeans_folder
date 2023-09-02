/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.controller;

import com.uexcel.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author Uexcel
 */
@WebServlet("/controller")
public class ConrtrollerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          User user = new User();
        String firstName = (String) request.getParameter("fName");
        String lastName = (String) request.getParameter("lName");
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        String confirmPassword = (String) request.getParameter("confirmPassword");
        String gender = (String) request.getParameter("gender");
        LocalDateTime date = LocalDateTime.now();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreatedAt(date);
        String[] array = {firstName, lastName, email, password, gender };
        
        HttpSession session = request.getSession();
        session.setAttribute("newUser", user);
        session.setAttribute("array", array);
        session.setAttribute("confirmPassword", confirmPassword);
        
        response.sendRedirect("controller");
        
    }
    
       
}
