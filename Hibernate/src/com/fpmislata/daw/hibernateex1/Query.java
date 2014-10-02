/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.daw.hibernateex1;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 *
 * @author eslem
 */
public class Query {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        
        //org.hibernate.Query query =session.createQuery("SELECT p FROM Profesor p WHERE id=1001");
        
        //--Query with name
        org.hibernate.Query query =session.getNamedQuery("findAllProfesores");
        
        
        //---Query with name
         List<Profesor> profesores = query.list();
        for(Profesor profesor : profesores){
            System.out.println(profesor.toString());
        }  
        
        
        //---One row
        
       /* Profesor profesor = (Profesor) query.uniqueResult();
        System.out.println(profesor.toString());
        
        */
    }
}
