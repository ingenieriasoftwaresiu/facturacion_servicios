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
 * @author jorge.correa
 */
public class DetalleCuentaCobro {
    private Long codigoCuentaCobro;
    private String servicio;
    private String subservicio;
    private BigDecimal totalAPagar;
    private Date fechaConsumo;
    private Integer codigoConsumo;

    public Integer getCodigoConsumo() {
        return codigoConsumo;
    }

    public void setCodigoConsumo(Integer codigoConsumo) {
        this.codigoConsumo = codigoConsumo;
    }
    
    public Date getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(Date fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }
        
    public Long getCodigoCuentaCobro() {
        return codigoCuentaCobro;
    }

    public void setCodigoCuentaCobro(Long codigoCuentaCobro) {
        this.codigoCuentaCobro = codigoCuentaCobro;
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

    public BigDecimal getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(BigDecimal totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
        
}
