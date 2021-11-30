/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

/**
 *
 * @author George
 */
public class UsuarioConsumoSIU {
    private String codigo;
    private String nombre;
    private String coordinador;
    private String auxiliarResponsable;

    public String getAuxiliarResponsable() {
        return auxiliarResponsable;
    }

    public void setAuxiliarResponsable(String auxiliarResponsable) {
        this.auxiliarResponsable = auxiliarResponsable;
    }
    
    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
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
