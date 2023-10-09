/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.controller;

import com.uexcel.domain.SaveBlog;

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
@WebServlet("/blog")
public class SaveBlogController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        try {
            int id = Integer.parseInt(session.getAttribute("userId").toString());
            String blog = req.getParameter("textArea");
            String title = req.getParameter("title");
            String  author = req.getParameter("author");
            SaveBlog bl = new SaveBlog();
            bl.setBloggerId(id);
            bl.setBlog(blog);
            bl.setTitle(title);
            bl.setAuthor(author);
            String result = bl.inserBlog();
            if (result.equals("success")) {
                 resp.getWriter().append("<h1>The blog has be saved successfully!!!</h1>"+ 
                    "<a href=\"welcome\">Back</a>");      
                return;
            }
             resp.getWriter().append("<h1>Error occurred, unable to fulfill your request!</h1>"+ 
                    "<a href=\"welcome\">Back</a>");      
            
        } catch (NumberFormatException e) {
             resp.getWriter().append("<h1>Error occurred, unable to fulfill your request!</h1>"+ 
                    "<a href=\"welcome\">Back</a>");      
        }
    }
}
