/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

/**
 *
 * @author Jorge.correa
 */
public class RolUsuario {
    private String codigo;
    private String nombre;
    private String seAutentica;

    public String getSeAutentica() {
        return seAutentica;
    }

    public void setSeAutentica(String seAutentica) {
        this.seAutentica = seAutentica;
    }    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
}
