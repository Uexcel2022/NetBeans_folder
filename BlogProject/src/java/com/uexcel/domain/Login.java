/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    public static ArrayList<Object> login(String username, String password) {
        Integer id = 0;
        String fName = null;
        String lName= null;
        ArrayList<Object> data = new ArrayList<>();
        
        if(username==null||password==null){
            return data;
        }
        
        String query = "SELECT id, firstname, lastname FROM bloglogin WHERE username = ? AND password = ?";
        try {
            Connection connection = DatabaseConnection.connect();
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                fName = rs.getString("firstname");
                lName = rs.getString("lastname");
            }
            
            if(id > 0 && fName != null && lName != null){
               data.add(BlogProperties.getBlogTitle(id));
               data.add(fName);
               data.add(id);
               data.add(lName);
            }
//           
            return data;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;

    }

}
