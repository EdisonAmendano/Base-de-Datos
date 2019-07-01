/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladorExepcion;

import ec.edu.ups.modelo.BaseDeDatos;
import ec.edu.ups.modelo.Direccion;
import ec.edu.ups.modelo.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison
 */

public class ControladorDireccion {
    private int codigo;
    private BaseDeDatos miBaseDeDatos;
    public ControladorDireccion() {
        miBaseDeDatos = new BaseDeDatos();
        codigo = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void create(Direccion d) throws SQLException {

        String sql = "INSERT INTO\"Direccion\" VALUES(" + d.getCodigo() + ",'" + d.getCallepreincipal() + "','" + d.getCalleSecundaria() + "', " + d.getNumero() + ",'" + d.getPersonaCedula()+"')";
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

    public Direccion BuscarCodigo(int codigo) {
        Direccion d = new Direccion();
        try {
            String sql = "SELECT * FROM \"Direccion\" WHERE \"DIR_CODIGO\"=" + codigo + ";";
            System.out.println(sql);

            miBaseDeDatos.conectar();
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                d.setCodigo(codigo);
                d.setCallepreincipal(rs.getString("DIR_CALLE_PRINCIPAL"));
                d.setCalleSecundaria(rs.getString("DIR_CALLE_SECUNDARIA"));
                d.setNumero(rs.getInt("DIR_NUMERO"));
                d.setPersonaCedula(rs.getString("DIR_PERSONA_CEDUAL"));               
            }
            miBaseDeDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;
    }

    public void modificar(Direccion d) throws SQLException {
        String sql = "UPDATE \"Direccion\" SET \"DIR_CALLE_PRINCIPAL\" = '" + d.getCallepreincipal() + "',\"DIR_CALLE_SECUNDARIA\" = '" + d.getCalleSecundaria() + "',\"DIR_NUMERO\" = " + d.getNumero() +",\"DIR_PERSONA_CEDUAL\" = '"+d.getPersonaCedula()+"' WHERE \"DIR_CODIGO\" = "+d.getCodigo()+";";
        miBaseDeDatos.conectar();
        try {
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            sta.execute(sql);
            miBaseDeDatos.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(int codigo) throws SQLException{
        String sql = "DELETE FROM \"Direccion\" WHERE \"DIR_CODIGO\" = "+codigo+";";
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

        Set<Direccion> lista = new HashSet<>();
        try {
            String sql = "SELECT * FROM \"Direccion\";";
            System.out.println(sql);

            miBaseDeDatos.conectar();
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                Direccion d = new Direccion();
                d.setCodigo(rs.getInt("DIR_CODIGO"));
                d.setCallepreincipal(rs.getString("DIR_CALLE_PRINCIPAL"));
                d.setCalleSecundaria(rs.getString("DIR_CALLE_SECUNDARIA"));
                d.setNumero(rs.getInt("DIR_NUMERO"));
                d.setPersonaCedula(rs.getString("DIR_PERSONA_CEDUAL"));   
                lista.add(d);
            }

            miBaseDeDatos.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public int maxcodeigo(){
        int codigo1 = 0;
        try {
            String sql = "SELECT MAX (\"DIR_CODIGO\") FROM \"Direccion\";";          
            miBaseDeDatos.conectar();
            System.out.println(sql);
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sql);   
            while (rs.next()) {
               codigo1=rs.getInt("max");
            }              
          miBaseDeDatos.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return codigo1;
    }
    
    public Set listarDireccion(String cedula){
        Set<Direccion> lista = new HashSet<>();
        try {
            String sql = "SELECT * FROM \"Direccion\" WHERE \"DIR_PERSONA_CEDUAL\"='" + cedula + "';";
            System.out.println(sql);

            miBaseDeDatos.conectar();
            Statement sta = miBaseDeDatos.getConexionBD().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                Direccion d = new Direccion();
                d.setCodigo(rs.getInt("DIR_CODIGO"));
                d.setCallepreincipal(rs.getString("DIR_CALLE_PRINCIPAL"));
                d.setCalleSecundaria(rs.getString("DIR_CALLE_SECUNDARIA"));
                d.setNumero(rs.getInt("DIR_NUMERO"));
                d.setPersonaCedula(rs.getString("DIR_PERSONA_CEDUAL"));   
                lista.add(d);
            }

            miBaseDeDatos.desconectar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public void eliminarDireccionCedula(String cedula) throws SQLException{
        String sql = "DELETE FROM \"Direccion\" WHERE \"DIR_PERSONA_CEDUAL\" = '"+cedula+"';";
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
    
}
