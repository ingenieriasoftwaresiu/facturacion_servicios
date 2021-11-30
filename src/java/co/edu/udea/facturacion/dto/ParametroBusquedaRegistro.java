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
public class ParametroBusquedaRegistro {
    private String servicio;
    private String subservicio;
    private String tipoUsuario;
    private String usuario;
    private String fechaInicio;
    private String fechaFin;
    private String consecutivoCuentaCobro;
    private String numeroSoporte;
    private String codigo;
    private String nombre;

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

    public String getConsecutivoCuentaCobro() {
        return consecutivoCuentaCobro;
    }

    public void setConsecutivoCuentaCobro(String consecutivoCuentaCobro) {
        this.consecutivoCuentaCobro = consecutivoCuentaCobro;
    }

    public String getNumeroSoporte() {
        return numeroSoporte;
    }

    public void setNumeroSoporte(String numeroSoporte) {
        this.numeroSoporte = numeroSoporte;
    }
            
    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getSubservicio() {
        return subservicio;
    }

    public void setSubservicio(String subservicio) {
        this.subservicio = subservicio;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }    
    
}
