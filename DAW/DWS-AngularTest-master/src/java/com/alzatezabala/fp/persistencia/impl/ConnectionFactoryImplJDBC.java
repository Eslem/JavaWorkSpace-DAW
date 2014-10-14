/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alzatezabala.fp.persistencia.impl;

import com.alzatezabala.fp.persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eslem
 */
public class ConnectionFactoryImplJDBC implements ConnectionFactory {

    private String bd = "daw";
    private String login = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/";
    Connection connection = null;

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Fallo class driver",ex);
        }
        try {
            connection = DriverManager.getConnection(url + bd, login, password);
        } catch (SQLException ex) {
            throw new RuntimeException("Fallo getConnection",ex);
        }
        return connection;
    }
    /*
     private Connection getConnection(){
     if(connection==null){
     return createConnection();
     }else{
     return connection;
     }
     }*/

    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Fallo al cerrar conexion",ex);
            }
            connection = null;
        }
    }
}
