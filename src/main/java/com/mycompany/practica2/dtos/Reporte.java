/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2.dtos;

public class Reporte {
    private int codAsignatura; // Foreign key to Asignatura
    private String dniAlumno; // Foreign key to Alumno
    private int codIncidencia; // Foreign key to Incidencia

    // Getters and Setters
    public int getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public int getCodIncidencia() {
        return codIncidencia;
    }

    public void setCodIncidencia(int codIncidencia) {
        this.codIncidencia = codIncidencia;
    }
}
