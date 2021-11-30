/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

import java.util.Date;

/**
 *
 * @author jorge.correa
 */
public class ConsumoServicioXTipoUsuario {
    private Integer codigo;
    private String servicio;
    private String subservicio;
    private String tipoUsuario;
    private Date fechaConsumo;
    private String tipoUsuarioConsumo;
    private String usuario;
    private String unidadMedida;
    private Integer cantidadUnidad;
    private Integer subcantidad;
    private String seFactura;
    private String usuarioRegistra;
    private Date fechaRegistra;
    private String facturado;
    private Date fechaFacturacion;
    private String concepto;
    private Long cuentaCobro;
    private String aplicarSancion;

    public String getAplicarSancion() {
        return aplicarSancion;
    }

    public void setAplicarSancion(String aplicarSancion) {
        this.aplicarSancion = aplicarSancion;
    }
    
    public Integer getSubcantidad() {
        return subcantidad;
    }

    public void setSubcantidad(Integer subcantidad) {
        this.subcantidad = subcantidad;
    }
        
    public Long getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(Long cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }
        
    public String getTipoUsuarioConsumo() {
        return tipoUsuarioConsumo;
    }

    public void setTipoUsuarioConsumo(String tipoUsuarioConsumo) {
        this.tipoUsuarioConsumo = tipoUsuarioConsumo;
    }
        
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public Date getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(Date fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getCantidadUnidad() {
        return cantidadUnidad;
    }

    public void setCantidadUnidad(Integer cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
    }
  
    public String getSeFactura() {
        return seFactura;
    }

    public void setSeFactura(String seFactura) {
        this.seFactura = seFactura;
    }

    public String getUsuarioRegistra() {
        return usuarioRegistra;
    }

    public void setUsuarioRegistra(String usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public Date getFechaRegistra() {
        return fechaRegistra;
    }

    public void setFechaRegistra(Date fechaRegistra) {
        this.fechaRegistra = fechaRegistra;
    }

    public String getFacturado() {
        return facturado;
    }

    public void setFacturado(String facturado) {
        this.facturado = facturado;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
        
}
