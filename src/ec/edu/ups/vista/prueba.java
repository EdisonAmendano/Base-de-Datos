/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controladorExepcion.ControladorDireccion;
import ec.edu.ups.controladorExepcion.ControladorPersona;
import ec.edu.ups.modelo.Persona;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison
 */
public class prueba {
    public static void main(String[] args) throws SQLException {
        Set<Persona> lista = new HashSet<>();
        ControladorPersona cp = new ControladorPersona();
        ControladorDireccion cd = new ControladorDireccion();
        Persona p = new Persona("0999999999", "Juan Juan", "Juep Juep", 22,new java.util.Date(), "0983894228", 160.00);
        //cp.create(p);
        
        //System.out.println(cp.BuscarCedula("0302829957"));
        
        System.out.println(cd.maxcodeigo());
    }
}
