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
public class Servicio {
    private String codigo;
    private String nombre;
    private String proceso;
    private String facturable;
    private String modoIngresoConsumos;

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

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getFacturable() {
        return facturable;
    }

    public void setFacturable(String facturable) {
        this.facturable = facturable;
    }

    public String getModoIngresoConsumos() {
        return modoIngresoConsumos;
    }

    public void setModoIngresoConsumos(String modoIngresoConsumos) {
        this.modoIngresoConsumos = modoIngresoConsumos;
    }    
    
}
