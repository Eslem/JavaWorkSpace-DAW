/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alzatezabala.fp.persistencia;

import java.util.List;

/**
 *
 * @author eslem
 */
public interface GenericDAO <T>{
    public T get(int id);
    
    public T insert(T entidad);
    
    public T update(T entidad);
    
    public boolean delete(int id);
    
    public List<T> findAll();
    
}
