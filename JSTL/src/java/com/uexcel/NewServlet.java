/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uexcel;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uexcel
 */
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Person> records = new ArrayList<>();
        try {

            String user = "root", password = "jvman19", url = "jdbc:mariadb://localhost:3306/mydatabase";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            String query = "SELECT * FROM login";

            ResultSet rs = st.executeQuery(query);
            boolean found = false;
            while (rs.next()) {
                Person person = new Person(rs.getString("FirstName"), rs.getString("LastName"),
                        rs.getString("Gender"), rs.getString("Phone"), rs.getString("Email"));
                records.add(person);
                
                if (rs.getString("Username").equals(request.getParameter("username"))
                        && rs.getString("Password").equals(request.getParameter("password"))) {
                    found = true;
                }
            }

            if (found) {
                request.setAttribute("Person", records);
                RequestDispatcher rd = request.getRequestDispatcher("newjsp.jsp");
                rd.forward(request, response);
            } else {
                out.print("<html><body>Invalid login credentials; unable to fulfil your"
                        + " resquest</body></html>.");
            }
        } catch (SQLException e) {
            out.print("<html><body>Sorry we encountered error; unable to fulfil your"
                    + " resquest</body></html>.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
