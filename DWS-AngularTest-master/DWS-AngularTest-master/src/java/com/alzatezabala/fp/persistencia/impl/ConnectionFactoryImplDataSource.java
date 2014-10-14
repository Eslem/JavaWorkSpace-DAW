/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alzatezabala.fp.persistencia.impl;

import com.alzatezabala.fp.persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author eslem
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    //DataSource dataSource = null;
    Connection connection = null;

    /*public DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            dataSource = (DataSource) context.lookup("jdbc/datasource");
        }
        return dataSource;
    }*/

    @Override
    public Connection getConnection() {
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            DataSource dataSource = (DataSource) context.lookup("jdbc/datasource");
            connection = dataSource.getConnection();
        } catch (SQLException | NamingException ex) {
            throw new RuntimeException(ex.toString());
        }
        return connection;
    }

    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex.toString());
            }
        }
    }

}
