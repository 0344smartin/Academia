/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2.DBConections;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect2H2 {

    private static final String URI = "jdbc:h2:./db/academia";
    private Connection conn;
    private static Connect2H2 instance;

    public void Connect2H2() {

    }

    public static Connect2H2 getInstance() {
        if (instance == null) {
            try {
                instance = new Connect2H2();
                instance.conn = getConnection(URI, "SA", "");
            } catch (SQLException ex) {
                Logger.getLogger(Connect2H2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }

}
