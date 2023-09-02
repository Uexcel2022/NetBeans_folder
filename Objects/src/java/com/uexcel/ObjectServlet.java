/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uexcel;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;

/**
 *
 * @author Uexcel
 */
 @WebServlet(urlPatterns="/servlet", initParams={@WebInitParam(name="e",value="a"),
     @WebInitParam(name="hello", value="key")})
public class ObjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session = request.getSession();
           session.setAttribute("appName", "implicit object");
           request.setAttribute("weather", "cloudy");
           request.getServletContext().setAttribute("scope", "Application");
           request.getRequestDispatcher("objects.jsp").forward(request, response);
    }

}
