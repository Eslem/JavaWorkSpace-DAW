/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alzatezabala.fp.persistencia;

import java.sql.Connection;

/**
 *
 * @author eslem
 */
public interface ConnectionFactory {
    //public Connection createConnection();
    // public void closeConnection();

    public Connection getConnection();
    public void closeConnection();
}
