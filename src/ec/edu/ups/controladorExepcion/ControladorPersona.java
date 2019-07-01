/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladorExepcion;

import ec.edu.ups.modelo.BaseDeDatos;
import ec.edu.ups.modelo.Persona;
import java.awt.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison
 */
public class ControladorPersona {

    private BaseDeDatos miBaseDeDatos;
    SimpleDateFormat formato;

    public ControladorPersona() {
        miBaseDeDatos = new BaseDeDatos();
        formato = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void create(Persona persona) throws SQLException {

        String sql = "INSERT INTO\"DatosPerdona\" VALUES('" + persona.getCedula() 
                + "','" + persona.getNombre() + "','" + persona.getApellido() + "', " 
                + persona.getEdad() + ",'" + formato.format(persona.getFecha()) + "','" 
                + persona.getCelular() + "'," + persona.getSalario() + ")";
        System.out.println(sql);
        miBaseDeDatos.conectar();
        try {
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            sta.execute(sql);
            miBaseDeDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public Persona BuscarCedula(String cedula) {
        Persona p = new Persona();
        try {
            String sql = "SELECT * FROM \"DatosPerdona\" WHERE \"PER_CEDULA\"='" + cedula + "';";
            System.out.println(sql);

            miBaseDeDatos.conectar();
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                p.setCedula(rs.getString("PER_CEDULA"));
                p.setApellido(rs.getString("PER_APELLIDO"));
                p.setNombre(rs.getString("PER_NOMBRE"));
                p.setEdad(rs.getInt("PER_EDAD"));
                p.setFecha(rs.getDate("PER_FECHA"));
                p.setCelular(rs.getString("PER_CELULAR"));
                p.setSalario(rs.getDouble("PER_SALARIO"));
            }

            miBaseDeDatos.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public void modificar(Persona p) throws SQLException {
        String sql = "UPDATE \"DatosPerdona\" SET \"PER_NOMBRE\" = '" 
                + p.getNombre() + "',\"PER_APELLIDO\" = '" + p.getApellido() + "',\"PER_EDAD\" = " 
                + p.getEdad() + ",\"PER_FECHA\" = '" + formato.format(p.getFecha())+"',\"PER_CELULAR\" = '"
                +p.getCelular()+"',\"PER_SALARIO\" = "+p.getSalario()+" WHERE \"PER_CEDULA\" = '"+p.getCedula()+"';";
        miBaseDeDatos.conectar();
        try {
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            sta.execute(sql);
            miBaseDeDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(String cedula) throws SQLException{
        String sql = "DELETE FROM \"DatosPerdona\" WHERE \"PER_CEDULA\" = '"+cedula+"';";
        System.out.println(sql);
        miBaseDeDatos.conectar();
        try {
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            sta.execute(sql);
            miBaseDeDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Set Listar() {

        Set<Persona> lista = new HashSet<>();
        try {
            String sql = "SELECT * FROM \"DatosPerdona\";";
            System.out.println(sql);

            miBaseDeDatos.conectar();
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                Persona p = new Persona();
                p.setCedula(rs.getString("PER_CEDULA"));
                p.setApellido(rs.getString("PER_APELLIDO"));
                p.setNombre(rs.getString("PER_NOMBRE"));
                p.setEdad(rs.getInt("PER_EDAD"));
                p.setFecha(rs.getDate("PER_FECHA"));
                p.setCelular(rs.getString("PER_CELULAR"));
                p.setSalario(rs.getDouble("PER_SALARIO"));
                lista.add(p);
            }

            miBaseDeDatos.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
