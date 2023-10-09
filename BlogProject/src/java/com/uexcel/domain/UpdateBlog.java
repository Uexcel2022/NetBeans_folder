/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateBlog {
    
    public static String update(String blog, String title, String author, int blogId) {
  
        try {
            String query = "UPDATE blogs SET blog = ?, title = ?, author = ? WHERE id = ?";
            Connection connection = DatabaseConnection.connect();
            if (connection != null) {
                PreparedStatement st = connection.prepareStatement(query);
                st.setString(1, blog);
                st.setString(2, title);
                st.setString(3, author);
                st.setInt(4, blogId);
                st.executeQuery();
                return "success";
            } else {
                return "";
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    
}
