/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel;

/**
 *
 * @author Uexcel
 */
public class Person {
  private String fName;
  private String lName;
  private String gender;
  private String phone;
  private String email;

    public Person(String fName, String lName, String gender, String phone, String email) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" + "fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", phone=" + phone + ", email=" + email + '}';
    }
  
  
  
  
  
}
