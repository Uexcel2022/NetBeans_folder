/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uexcel
 */

public class BlogProperties {

    public static ArrayList<CreateBlogObject> getBlogTitle() {
        CreateBlogObject obj;
        ArrayList<CreateBlogObject> data = new ArrayList<>();
        String query = "SELECT* FROM blogs";
        try {
            Connection connection = DatabaseConnection.connect();
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                obj = new CreateBlogObject();
                obj.setId(rs.getString("id"));
                obj.setTitle(rs.getString("title"));
                obj.setBlog(rs.getString("blog"));
                obj.setBlogAuthor(rs.getString("author"));
                obj.setDate(rs.getDate("date").toString());
                data.add(obj);
            }
            return data;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;

    }
    
    
    public static ArrayList<CreateBlogObject> getBlogTitle(int id) {
        CreateBlogObject obj;
        ArrayList<CreateBlogObject> data = new ArrayList<>();
        String query = "SELECT* FROM blogs WHERE bloggerid=?";
        try {
            Connection connection = DatabaseConnection.connect();
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                obj = new CreateBlogObject();
                obj.setId(rs.getString("id"));
                obj.setTitle(rs.getString("title"));
                obj.setBlog(rs.getString("blog"));
                obj.setBlogAuthor(rs.getString("author"));
                obj.setDate(rs.getString("date"));
                data.add(obj);
            }
            return data;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;

    }

}
