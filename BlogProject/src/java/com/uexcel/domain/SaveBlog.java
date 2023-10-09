/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveBlog {

    private int bloggerId;
    private String blog;
    private String title;
    private String author;

    public void setBloggerId(int bloggerId) {
        this.bloggerId = bloggerId;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String inserBlog() {
        if (bloggerId == 0 || blog.isEmpty() || title.isEmpty() || author.isEmpty()) {
            return "";
        }

        try {
            String query = "Insert into blogs (bloggerid, blog, title, author, date) values(?,?,?,?,?)";
            Connection connection = DatabaseConnection.connect();
            if (connection != null) {
                PreparedStatement st = connection.prepareStatement(query);
                st.setInt(1, bloggerId);
                st.setString(2, blog);
                st.setString(3, title);
                st.setString(4, author);
                st.setString(5, LocalDate.now().toString());
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
