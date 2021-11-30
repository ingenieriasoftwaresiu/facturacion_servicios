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
public class Subservicio {
    private String codigo;
    private String nombre;
    private String tipoFacturacion;
    private String responsable;
    private String servicioPadre;
    private String insumosFijos;
    private String aplicaSubcantidad;
    private String etiquetaSubcantidad;
    private String aplicaPorcentajeSancion;

    public String getAplicaPorcentajeSancion() {
        return aplicaPorcentajeSancion;
    }

    public void setAplicaPorcentajeSancion(String aplicaPorcentajeSancion) {
        this.aplicaPorcentajeSancion = aplicaPorcentajeSancion;
    }
        
    public String getEtiquetaSubcantidad() {
        return etiquetaSubcantidad;
    }

    public void setEtiquetaSubcantidad(String etiquetaSubcantidad) {
        this.etiquetaSubcantidad = etiquetaSubcantidad;
    }
    
    public String getAplicaSubcantidad() {
        return aplicaSubcantidad;
    }

    public void setAplicaSubcantidad(String aplicaSubcantidad) {
        this.aplicaSubcantidad = aplicaSubcantidad;
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

    public String getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(String tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getServicioPadre() {
        return servicioPadre;
    }

    public void setServicioPadre(String servicioPadre) {
        this.servicioPadre = servicioPadre;
    }

    public String getInsumosFijos() {
        return insumosFijos;
    }

    public void setInsumosFijos(String insumosFijos) {
        this.insumosFijos = insumosFijos;
    }
        
}
