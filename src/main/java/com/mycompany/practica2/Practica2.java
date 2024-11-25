/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica2;

import com.mycompany.practica2.daos.DAOAlumno;
import com.mycompany.practica2.dtos.Alumno;
import com.mycompany.practica2.factories.DaoFactory;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author estudiante
 */
public class Practica2 {

    public static void main(String[] args) {
        DAOAlumno daoAlumno = (DAOAlumno) DaoFactory.getDao(DaoFactory.DaoType.ALUMNO);
        String dni = "34567890C";
        daoAlumno.createRecord(new Alumno(dni, "Manolo","Perez", "Calle Falsa 123",Date.from(Instant.now()), "80001", "555123456"));
        //System.out.println(daoAlumno.readRecord(dni));
        for (Alumno a : daoAlumno.readRecords()){
            System.out.println(a);
        }
    }
}
