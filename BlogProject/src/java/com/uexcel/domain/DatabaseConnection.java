/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
public class DatabaseConnection {

    public static Connection connect() {
        Connection connnection= null;
        String user = "root", pass = "jvman19", url = "jdbc:mariadb://localhost:3306/mydatabase";
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            connnection = DriverManager.getConnection(url, user, pass);
            return connnection;

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connnection;
    }
}
