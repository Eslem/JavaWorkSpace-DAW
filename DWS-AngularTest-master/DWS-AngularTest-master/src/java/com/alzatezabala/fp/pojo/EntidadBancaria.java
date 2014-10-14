/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alzatezabala.fp.pojo;

import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 *
 * @author eslem
 */
public class EntidadBancaria {

    private int idEntidad;
    private String nombre;
    private String codigoEntidad;
    private Date fechaCreacion;

    public EntidadBancaria(int idEntidad, String name, String cEntidad) {
        this.idEntidad = idEntidad;
        this.nombre = name;
        this.codigoEntidad = cEntidad;
        this.fechaCreacion = new Date();
    }

    public EntidadBancaria() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getCodigoEntidad() {
        return codigoEntidad; //To change body of generated methods, choose Tools | Templates.
    }

}
