/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2.daos;

import com.mycompany.practica2.interfaces.IDAO;
import com.mycompany.practica2.dto.Alumno;
import java.util.ArrayList;
import java.util.List;

/*"INSERT INTO jugadores (nombre, posicion, edad) VALUES ( ?, ? , ? )",
        "SELECT * FROM jugadores WHERE id = ?;",
        "UPDATE jugadores SET nombre = ? , posicion = ?, edad = ? WHERE (id = ?);",
        "DELETE FROM jugadores WHERE (id = ?);",
        "SELECT * FROM jugadores;"
*/
public class DAOAlumno implements IDAO<Alumno, Integer>{

    private final String INSERT = "INSERT INTO alumno (dni, nombre, apellidos, direccion, nacimiento, CP, telefono) VALUES (?,?,?,?,?,?,?);";
    private final String READ = "SELECT * FROM alumno WHERE dni = ?;";
    private final String READ_ALL = "SELECT * FROM alumno;";
    
    
    @Override
    public boolean createRecord(Alumno model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno readRecord(Integer idModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateRecord(Alumno model, Integer idModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteRecord(Integer idModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> readRecords() {
        List<Alumno> alumnos = new ArrayList<>();
        
        return alumnos;
    }
    
}
