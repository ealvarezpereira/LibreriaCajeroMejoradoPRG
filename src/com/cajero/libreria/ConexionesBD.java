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
import javax.swing.JOptionPane;

/**
 *
 * @author quique
 */
public class ConexionesBD {

    static Connection conn;

    /**
     * @param url Url de la base de datos.
     */
    public static void conexionBase(String url) {
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            System.out.println("Error de conexión. " + ex);
        }
    }

    public static ResultSet rs;

    /**
     * @param consulta Consulta que quieres realizar en la base de datos.
     */
    public static void resultSet(String consulta) {

        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(consulta);

        } catch (SQLException ex) {
            System.out.println("Error en el ResultSet de la librería. " + ex);
        }
    }

    public static PreparedStatement pst;

    /**
     * @param consulta Consulta que quieres realizar en la base de datos.
     */
    public static void preparedStatement(String consulta) {

        try {
            pst = conn.prepareStatement(consulta);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Error al ingresar. " + ex);
        }
    }
}
