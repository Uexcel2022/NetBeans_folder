/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.controller;

import com.uexcel.domain.CreateBlogObject;
import com.uexcel.domain.BlogProperties;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet( value={"/home"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CreateBlogObject> data = BlogProperties.getBlogTitle();
        HttpSession session = req.getSession();
        session.setAttribute("blog", data);
        if ((req.getRequestURL() + "").equals("http://localhost:8080/BlogProject/admin")) {
            req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
    
}
