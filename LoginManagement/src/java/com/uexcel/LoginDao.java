/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel;

import java.sql.*;

/**
 *
 * @author Uexcel
 */
public class LoginDao {

    public static String loginValidation(String username, String password) {
        try {

            String query = "SELECT FirstName FROM login WHERE Username =? AND Password =?";
            String user = "root", pass = "jvman19", url = "jdbc:mariadb://localhost:3306/mydatabase";

            Class.forName("org.mariadb.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return rs.getString("FirstName");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            return "error";
//            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
