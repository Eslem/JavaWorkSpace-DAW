/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alzatezabala.fp.persistencia.impl;

import com.alzatezabala.fp.pojo.EntidadBancaria;
import com.alzatezabala.fp.persistencia.ConnectionFactory;
import com.alzatezabala.fp.persistencia.EntidadBancariaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author eslem
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    ConnectionFactory connectionFactory = new ConnectionFactoryImplJDBC();

    @Override
    public EntidadBancaria get(int id) {
        PreparedStatement preparedStatement;
        EntidadBancaria entidadBancaria;
        ResultSet resultSet;
        Connection connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM entidadbancaria WHERE idEntidadBancaria = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entidadBancaria = new EntidadBancaria();
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setIdEntidad(resultSet.getInt("idEntidadBancaria"));

                if (resultSet.next()) {
                    throw new RuntimeException("Devuelve mas de una fila");
                }

            } else {
                entidadBancaria = null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        connectionFactory.closeConnection();
        return entidadBancaria;
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidad) {
        PreparedStatement preparedStatement;
        Connection connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO entidadbancaria(nombre, fechaCreacion, codigoEntidad) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidad.getNombre());
            preparedStatement.setString(3, entidad.getCodigoEntidad());
            preparedStatement.setDate(2, new java.sql.Date(new Date().getTime()));

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    entidad.setIdEntidad(resultSet.getInt(1));
                }
            } else {
                throw new RuntimeException("Fallo insertando datos");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        connectionFactory.closeConnection();

        return entidad;
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidad) {
        PreparedStatement preparedStatement;
        Connection connection = connectionFactory.getConnection();

        try {
            preparedStatement = connection.prepareStatement("UPDATE entidadbancaria set nombre=?, codigoEntidad=? WHERE idEntidadBancaria=?");
            preparedStatement.setString(1, entidad.getNombre());
            preparedStatement.setString(2, entidad.getCodigoEntidad());
            preparedStatement.setInt(3, entidad.getIdEntidad());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        connectionFactory.closeConnection();
        return entidad;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement preparedStatement;
        Connection connection = connectionFactory.getConnection();

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM entidadbancaria WHERE idEntidadBancaria=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            int rows = preparedStatement.getUpdateCount();
            connectionFactory.closeConnection();
            if (rows == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public List<EntidadBancaria> findAll() {
        PreparedStatement preparedStatement;
        Connection connection = connectionFactory.getConnection();
        List<EntidadBancaria> listaEntidadBancaria = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM entidadbancaria");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria();
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setIdEntidad(resultSet.getInt("id"));
                listaEntidadBancaria.add(entidadBancaria);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        connectionFactory.closeConnection();
        return listaEntidadBancaria;
    }
}
