package com.fpmislata.daw.hibernateex1;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

        /*
         Session session=sessionFactory.openSession();
         Direccion direccion=(Direccion) session.get(Direccion.class, 1002);
         Profesor profesor=direccion.getProfesor();
         System.out.println(profesor.getNombre());
         session.close();*/
        /*
         Profesor profesor = new Profesor(7, "Sara", "Barrera", "Salas");
         Set<CorreoElectronico> correosElectronicos = new HashSet<>();
         correosElectronicos.add(new CorreoElectronico(1, "sara@gmail.com", profesor));
         correosElectronicos.add(new CorreoElectronico(2, "sara@yahoo.com", profesor));
         correosElectronicos.add(new CorreoElectronico(3, "sara@hotmail.com", profesor));
        
         profesor.setCorreosElectronicos(correosElectronicos);
        
         Session session = sessionFactory.openSession();
         session.beginTransaction();
         session.save(profesor);
        
         session.getTransaction().commit();
         session.close();*/
        Profesor profesor1 = new Profesor(11, "Isabel", "Fuertes", "Gascón");
        Profesor profesor2 = new Profesor(12, "Jose", "Valenciano", "Gimeno");

        Modulo modulo1 = new Modulo(1, "Sistemas Operativos en Red");
        Modulo modulo2 = new Modulo(2, "Entornos de desarrollo");
        Modulo modulo3 = new Modulo(3, "Sistemas Informáticos");

        profesor1.getModulos().add(modulo1);
        profesor1.getModulos().add(modulo2);
        profesor2.getModulos().add(modulo3);

        modulo1.getProfesores().add(profesor1);
        modulo2.getProfesores().add(profesor1);
        modulo3.getProfesores().add(profesor2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(profesor1);
        session.save(profesor2);

        session.getTransaction().commit();
        session.close();

    }

}
