/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2.interfaces;

import java.util.List;

public interface IDAO<T, V> {
    
    public int createRecord(T model);

    public T readRecord(String dni);

    public int updateRecord(T model, String dni);

    public int deleteRecord(String dni);

    public List<T> readRecords();
}