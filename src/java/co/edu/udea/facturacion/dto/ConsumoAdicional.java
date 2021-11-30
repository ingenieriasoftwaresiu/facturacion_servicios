/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

import java.util.Date;

/**
 *
 * @author Jorge.correa
 */
public class ConsumoAdicional {
    private Integer codigo;
    private Integer consumo;
    private String itemAdicional;
    private Date fechaConsumo;
    private Long valorUnidad;
    private String seFactura;
    private String usuarioRegistra;
    private Date fechaRegistra;
    private String facturado;
    private Date fechaFacturacion;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public String getItemAdicional() {
        return itemAdicional;
    }

    public void setItemAdicional(String itemAdicional) {
        this.itemAdicional = itemAdicional;
    }

    public Date getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(Date fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }
  
    public Long getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(Long valorUnidad) {
        this.valorUnidad = valorUnidad;
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
