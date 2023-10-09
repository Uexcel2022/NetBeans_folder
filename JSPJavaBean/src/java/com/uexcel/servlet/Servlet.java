/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.servlet;

import com.uexcel.model.Employee;
import com.uexcel.model.Person;
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
@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee emp = new Employee();
        emp.setFirstName("Uexel");
        emp.setLastName("Johnson");
        emp.setSalary(400.89);
        emp.setTitle("Manager");
        req.setAttribute("emp", emp);
        req.getRequestDispatcher("jspusebean.jsp").forward(req, resp);
    }
}
