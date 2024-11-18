/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2.factories;

import com.mycompany.practica2.daos.DAOAlumno;
import com.mycompany.practica2.daos.DAOProfesor;
import com.mycompany.practica2.interfaces.IDAO;

/**
 *
 * @author estudiante
 */
public class DaoFactory {
    public enum DaoType{
        ALUMNO,
        PROFESOR,
        ASIGNATURA
        
    }
    public static IDAO getDao (DaoType daoType){
        IDAO dao = null;
        switch (daoType){
            case ALUMNO -> dao=new DAOAlumno();
            case PROFESOR-> dao=new DAOProfesor();
                
        }
        return dao;
    }
}
