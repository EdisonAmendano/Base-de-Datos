/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Edison
 */
public class Direccion {
    private int codigo;
    private String callePreincipal;
    private String calleSecundaria;
    private int numero;
    private String personaCedula;

    public Direccion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCallepreincipal() {
        return callePreincipal;
    }

    public void setCallepreincipal(String callepreincipal) {
        this.callePreincipal = callepreincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPersonaCedula() {
        return personaCedula;
    }

    public void setPersonaCedula(String personaCedula) {
        this.personaCedula = personaCedula;
    }

    @Override
    public String toString() {
        return "Direccion{" + "codigo=" + codigo + ", callepreincipal=" + callePreincipal + ", calleSecundaria=" + calleSecundaria + ", numero=" + numero + ", personaCedula=" + personaCedula + '}';
    }
    
    
}
