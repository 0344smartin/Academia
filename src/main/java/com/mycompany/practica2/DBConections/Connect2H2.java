/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2.DBConections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect2H2 {

    private final String URI = "jdbc:h2:./db/academia";
    private Connection conn;
    private static Connect2H2 H2Instance;

    public void Connect2H2() {
        try {
            conn = DriverManager.getConnection(URI, "SA", "");
            System.out.println("Connection to the H2 database was successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Connect2H2 getInstance(){
        if (H2Instance == null ){
            H2Instance = new Connect2H2();
        }
        return H2Instance;
    }
       
    public Connection getConnection(){
        return conn;
    }

}
