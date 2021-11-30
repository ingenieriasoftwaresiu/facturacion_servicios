/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

/**
 *
 * @author jorge.correa
 */
public class Dependencia {
    private String codigo;
    private String nombre;
    private String centroCosto;
    private String nombreCentroCosto;
    private boolean manejaProyecto;

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

    public String getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
    }

    public String getNombreCentroCosto() {
        return nombreCentroCosto;
    }

    public void setNombreCentroCosto(String nombreCentroCosto) {
        this.nombreCentroCosto = nombreCentroCosto;
    }
    
    public boolean isManejaProyecto() {
        return manejaProyecto;
    }

    public void setManejaProyecto(boolean manejaProyecto) {
        this.manejaProyecto = manejaProyecto;
    }
            
}
