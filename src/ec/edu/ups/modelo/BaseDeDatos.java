/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Edison
 */

public class BaseDeDatos {
    
    private Connection conexionBD;

    public BaseDeDatos() {
    }
    
    
    public void conectar() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Persona";
        String user = "postgres";
        String password = "edison14";
        try {
            conexionBD = DriverManager.getConnection(url, user, password);
            if (conexionBD.isValid(5000)) {
                System.out.println("Conexion Existosa");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConexionBD() {
        return conexionBD;
    }

    public void desconectar() {
        try {
            // en caso de que no este cerrado
            if (!conexionBD.isClosed()) {
                conexionBD.close();
                System.out.println("conexion cerrada");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
