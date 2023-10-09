/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Uexcel
 */
@WebServlet(value = {"/publicView", "/signup", "/createBlog", "/login" ,"/privateView"})
public class RequestRoutingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if ((req.getRequestURL() + "").equals("http://localhost:8080/BlogProject/login")) {
//            resp.sendRedirect("login.jsp");
             req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        if ((req.getRequestURL() + "").equals("http://localhost:8080/BlogProject/signup")) {
//            resp.sendRedirect("signup.jsp");
             req.getRequestDispatcher("signup.jsp").forward(req, resp);
            return;
        }
        
        String blog =  req.getParameter("blog");
        String author = req.getParameter("author");
        String date = req.getParameter("date");
        HttpSession session = req.getSession();
        session.setAttribute("blog", blog);
        session.setAttribute("author", author);
        session.setAttribute("date", date);

        if ((req.getRequestURL() + "").equals("http://localhost:8080/BlogProject/publicView")) {
            req.setAttribute("callOrign", "home");
            req.getRequestDispatcher("showBlog.jsp").forward(req, resp);
            return;
        }
        
         if ((req.getRequestURL() + "").equals("http://localhost:8080/BlogProject/privateView")) {
             req.setAttribute("callOrign", "welcome");
            req.getRequestDispatcher("showBlog.jsp").forward(req, resp);
            return;
        }

        if ((req.getRequestURL() + "").equals("http://localhost:8080/BlogProject/createBlog")) {
            req.getRequestDispatcher("addBlog.jsp").forward(req, resp);
        }

    }
}
