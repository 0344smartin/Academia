/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2.daos;

import com.mycompany.practica2.DBConections.Connect2H2;
import com.mycompany.practica2.interfaces.IDAO;
import com.mycompany.practica2.dtos.Alumno;
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
public class DAOAlumno implements IDAO<Alumno, Integer> {

    private final String INSERT = "INSERT INTO alumno (dni, nombre, apellidos, direccion, nacimiento, CP, telefono) VALUES (?,?,?,?,?,?,?);";
    private final String READ = "SELECT * FROM alumno WHERE dni = ?;";
    private final String READ_ALL = "SELECT * FROM alumno;";
    private Connection conn;
    private Alumno alumno;
    private ArrayList<Alumno> alumnos;

    public DAOAlumno() {
        conn = Connect2H2.getInstance().getConnection();
        alumno = new Alumno();
        alumnos = new ArrayList<>();
    }

    @Override
    public int createRecord(Alumno alumno) {
        int res = 0;
        try {
            PreparedStatement pdst = conn.prepareStatement(INSERT);
            
            pdst.setString(1, alumno.getDni());
            pdst.setString(2, alumno.getNombre());
            pdst.setString(3, alumno.getApellidos());
            pdst.setString(4, alumno.getDireccion());
            pdst.setDate(5, new Date(alumno.getNacimiento().getTime()));
            pdst.setString(6, alumno.getCp());
            pdst.setString(7, alumno.getTelefono());

            res = pdst.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public Alumno readRecord(String dni) { 
        try {
            PreparedStatement pdst = conn.prepareStatement(READ);
            ResultSet res = pdst.executeQuery();
            alumno.setDni(res.getNString("dni"));
            alumno.setNombre(res.getNString("nombre"));
            alumno.setApellidos(res.getNString("apellidos"));
            alumno.setDireccion(res.getNString("direccion"));            
            alumno.setNacimiento(new Date(res.getDate("nacimiento").getTime()));
            alumno.setCp(res.getNString("CP"));
            alumno.setTelefono(res.getNString("telefono"));
            return alumno;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    }

    @Override
    public int updateRecord(Alumno model, String dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteRecord(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> readRecords() {
        try {
            alumnos.clear();
            PreparedStatement pdst = conn.prepareStatement(READ_ALL);
            ResultSet res = pdst.executeQuery();
            while (res.next()) {
                alumno.setDni(res.getString("dni"));
                alumno.setNombre(res.getString("nombre"));
                alumno.setApellidos(res.getString("apellidos"));
                alumno.setDireccion(res.getString("direccion"));
                alumno.setCp(res.getString("CP"));
                alumno.setTelefono(res.getString("telefono"));
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

}
