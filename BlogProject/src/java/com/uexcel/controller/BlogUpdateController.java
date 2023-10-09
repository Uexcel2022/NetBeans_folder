/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.controller;

import com.uexcel.domain.UpdateBlog;
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
@WebServlet("/makeBlog")
public class BlogUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("blog_text", req.getParameter("blog"));
        session.setAttribute("blogTitle", req.getParameter("title"));
        session.setAttribute("blogId", req.getParameter("blogId"));
       req.getRequestDispatcher("editor.jsp").forward(req, resp);
//        resp.sendRedirect("editor.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            HttpSession session = req.getSession();
            int blogId = Integer.parseInt((String) session.getAttribute("blogId"));
            String textArea = req.getParameter("textArea");
            String title = req.getParameter("title");
            String author = req.getParameter("author");
            String msg = UpdateBlog.update(textArea, title, author, blogId);
            if(msg.equals("success")){
            resp.getWriter().append("<h3>The blog has be updated successfully!!!</h3>"+ 
                    "<a href=\"welcome\">Back</a>");  
            return;
            }
            
             resp.getWriter().append("<h3>Error occurred, unable to fulfill your request!</h3>"+ 
                    "<a href=\"welcome\">Back</a>");       
             
        } catch (NumberFormatException e) {
            resp.getWriter().append("<h3>Error occurred, unable to fulfill your request!</h3>"+ 
                    "<a href=\"welcome\">Back</a>");          
        }
    }
}
