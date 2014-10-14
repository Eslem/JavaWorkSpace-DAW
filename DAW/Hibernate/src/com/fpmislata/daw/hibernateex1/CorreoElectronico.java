/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw.hibernateex1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author eslem
 */
@Entity
public class CorreoElectronico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="IdCorreo")
    private int id;

    @Column(name = "DireccionCorreo")
    private String direccionCorreo;

    @ManyToOne
    @JoinColumn(name = "IdProfesor")
    private Profesor profesor;

    
    public CorreoElectronico(){       
        
    }
    
    public CorreoElectronico(int id, String direccion,  Profesor profesor){
        this.id=id;
        this.direccionCorreo=direccion;
        this.profesor=profesor;        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;

    }
}
