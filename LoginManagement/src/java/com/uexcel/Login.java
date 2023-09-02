/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uexcel;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Uexcel
 */
@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        String nuser = (String) session.getAttribute("login");

        if (nuser == null) {
            resp.sendRedirect("login.jsp");

        } else {

            req.getRequestDispatcher("WEB-INF/welcome.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String firstName = LoginDao.loginValidation(username, password);

        if (firstName.equals("error")) {
            throw new IOException();
        } else if (firstName.isEmpty()) {
            response.sendRedirect("login.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("login", firstName);
            response.sendRedirect("login");

        }

    }

}
