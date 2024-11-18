/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2.daos;

import com.mycompany.practica2.DBConections.Connect2H2;
import com.mycompany.practica2.interfaces.IDAO;
import com.mycompany.practica2.dtos.Alumno;
import com.mycompany.practica2.dtos.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*"INSERT INTO jugadores (nombre, posicion, edad) VALUES ( ?, ? , ? )",
        "SELECT * FROM jugadores WHERE id = ?;",
        "UPDATE jugadores SET nombre = ? , posicion = ?, edad = ? WHERE (id = ?);",
        "DELETE FROM jugadores WHERE (id = ?);",
        "SELECT * FROM jugadores;"
 */
public class DAOProfesor implements IDAO<Profesor, Integer> {

    private final String INSERT = "INSERT INTO profesor (dni, nombre, apellidos, direccion, nacimiento, CP, telefono) VALUES (?,?,?,?,?,?,?);";
    private final String READ = "SELECT * FROM profesor WHERE dni = ?;";
    private final String READ_ALL = "SELECT * FROM profesor;";
    private Connection conn;
    private Profesor profesor;
    private ArrayList<Profesor> profesores;

    public DAOProfesor() {
        conn = Connect2H2.getInstance().getConnection();
        profesor = new Profesor();
        profesores = new ArrayList<>();
    }

    @Override
    public int createRecord(Profesor profesor) {
        int res = 0;
        try {
            PreparedStatement pdst = conn.prepareStatement(INSERT);

            pdst.setString(1, profesor.getDni());
            pdst.setString(2, profesor.getNombre());
            pdst.setString(3, profesor.getApellidos());
            pdst.setString(4, profesor.getDireccion());
            pdst.setDate(5, new Date(profesor.getNacimiento().getTime()));
            pdst.setString(6, profesor.getCp());
            pdst.setString(7, profesor.getTelefono());

            res = pdst.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public Profesor readRecord(String dni) {
        try {
            PreparedStatement pdst = conn.prepareStatement(READ);
            ResultSet res = pdst.executeQuery();
            profesor.setDni(res.getNString("dni"));
            profesor.setNombre(res.getNString("nombre"));
            profesor.setApellidos(res.getNString("apellidos"));
            profesor.setDireccion(res.getNString("direccion"));
            profesor.setCp(res.getNString("CP"));
            profesor.setTelefono(res.getNString("telefono"));
            return profesor;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int updateRecord(Profesor model, String dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteRecord(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Profesor> readRecords() {
        try {
            profesores.clear();
            PreparedStatement pdst = conn.prepareStatement(READ_ALL);
            ResultSet res = pdst.executeQuery();
            while (res.next()) {
                profesor.setDni(res.getString("dni"));
                profesor.setNombre(res.getString("nombre"));
                profesor.setApellidos(res.getString("apellidos"));
                profesor.setDireccion(res.getString("direccion"));
                profesor.setCp(res.getString("CP"));
                profesor.setTelefono(res.getString("telefono"));
                profesores.add(profesor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesores;
    }

}
