/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Uexcel
 */
public class MapModel {
    
    public static Map<String,String> creaeMap( String blog, String title){
       Map<String, String> blogProperties = new HashMap<>();
       blogProperties.put( title+"S", blog);
       blogProperties.put(title, title);
       return blogProperties;
    }
}
