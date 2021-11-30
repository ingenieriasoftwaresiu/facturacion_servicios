/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Jorge.correa
 */
public class ConsumoServicioXInsumo {
    
    private Integer codigo;
    private String servicio;
    private String subservicio;
    private String insumo;    
    private Date fechaConsumo;
    private String tipoUsuarioConsumo;
    private String usuario;
    private String unidadMedida;
    private BigDecimal cantidadUnidad;
    private String seFactura;
    private String usuarioRegistra;
    private Date fechaRegistra;
    private String facturado;
    private Date fechaFacturacion;
    private Long cuentaCobro;
    private Integer subcantidad;

    public Integer getSubcantidad() {
        return subcantidad;
    }

    public void setSubcantidad(Integer subcantidad) {
        this.subcantidad = subcantidad;
    }
    
    public BigDecimal getCantidadUnidad() {
        return cantidadUnidad;
    }

    public void setCantidadUnidad(BigDecimal cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
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

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
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
          
}
