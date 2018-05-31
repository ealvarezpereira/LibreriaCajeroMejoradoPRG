/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cajero.libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author quique
 */
public class ConexionesBD {

    static Connection conn;

    /**
     * @param url Url de la base de datos.
     */
    public void conexionBase(String url) {
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            System.out.println("Error de conexión. " + ex);
        }
    }

    static ResultSet rs;

    /**
     * @param consulta Consulta que quieres realizar en la base de datos.
     */
    public void resultSet(String consulta) {

        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(consulta);

            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error en el ResultSet de la librería. " + ex);
        }
    }

    static PreparedStatement pst;

    /**
     * @param consulta Consulta que quieres realizar en la base de datos.
     */
    public void preparedStatement(String consulta) {

        try {
            pst = conn.prepareStatement(consulta);
            pst.executeUpdate();
            System.out.println("Realizado.");

            pst.close();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar ticket. " + ex);
        }
    }
}
