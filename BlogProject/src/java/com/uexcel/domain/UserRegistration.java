/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.domain;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRegistration {

    private String firstName;
    private String lastName;
    private String email;
    private String birthday;
    private String username;
    private String password;
    private String password2;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    

    public String inserUser() {
        
        if(firstName.isEmpty() || lastName.isEmpty() ||email.isEmpty()|| birthday.isEmpty()||password.isEmpty()|| password2.isEmpty()){
            return " All the fields are required!!!";
        }
        
          if(!password.equals(password2)){
            return "Password not match!!!";
        }
        
        try {
            String query = "Insert into bloglogin (firstname, lastname, email, birthday, username, password) values(?,?,?,?,?,?)";
//            String query =String.format("Insert into bloglogin (firstname, lastname, email, birthday) values('%s','%s','%s','%s')",
//                    firstName,lastName,email, birthday);
            
            Connection connection = DatabaseConnection.connect();
            if(connection!=null){
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1,firstName);
            st.setString(2,lastName);
            st.setString(3,email);
            st.setString(4,birthday);
            st.setString(5, username);
            st.setString(6, password);
            st.executeQuery();
            return "success";
            
            } else return "We encounterd error , unable to fulfill your request!!!";

        } catch (SQLException ex) {
            Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "We encounterd error , unable to fulfill your request!!!";
    }

}
