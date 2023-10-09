/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.controller;

import com.uexcel.domain.CreateBlogObject;
import com.uexcel.domain.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Uexcel
 */
@WebServlet(value = {"/welcome", "/logout", "/loggedin"})
public class LoginLogoutController extends HttpServlet {

    private String inSessionUsername;
    private String inSessionPassword;
    HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            if (inSessionUsername != null && inSessionPassword != null && (req.getRequestURL() + "").equals(
                    "http://localhost:8080/BlogProject/loggedin")) {

                req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
                return;
            }

            String isLogjout = req.getParameter("isLogjout");

            if (isLogjout != null && (req.getRequestURL() + "").equals("http://localhost:8080/BlogProject/logout")) {
                inSessionUsername = null;
                inSessionPassword = null;
                session.invalidate();
                resp.sendRedirect("logout.jsp");
            }

            if (inSessionUsername != null && inSessionPassword != null
                    && (req.getRequestURL() + "").equals("http://localhost:8080/BlogProject/welcome")) {
                doPost(req, resp);
                return;
            }

            resp.sendRedirect("home");

        } catch (Exception e) {
            resp.getWriter().append("<h1>Bad Request!!! Reason: The page can not be refereshed after logout.</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String password;
        String username;
        session = req.getSession();
        if ((inSessionUsername != null || inSessionPassword != null)) {
            username = inSessionUsername;
            password = inSessionPassword;
        } else {
            username = req.getParameter("username");
            password = req.getParameter("password");
        }

        ArrayList<Object> data = Login.login(username, password);

        if (data.isEmpty()) {
            resp.sendRedirect("login.jsp?msg=Invalid login details!!!");
            return;
        }

        ArrayList<CreateBlogObject> object = (ArrayList<CreateBlogObject>) data.get(0);
        String fName = (String) data.get(1);
        int id = (int) data.get(2);
        String lName = (String) data.get(3);
        session.setAttribute("fName", fName);
        session.setAttribute("lName", lName);
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("userId", id);
        session.setAttribute("object", object);
        inSessionUsername = (String) session.getAttribute("username");
        inSessionPassword = (String) session.getAttribute("password");
        resp.sendRedirect("loggedin");
    }

}
