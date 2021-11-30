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
public class CuentaCobro {
    private Long codigo;
    private String tipoUsuarioConsumo;
    private String usuarioConsumo;
    private Date fechaCreacion;
    private String usuarioCreacion;
    private Date fechaLimitePago;
    private Date fechaInicioPeriodo;
    private Date fechaFinPeriodo;
    private String numeroSoporte;
    private Date fechaSoporte;
    private BigDecimal valorSoporte;
    private String acuerdoCobro;
    private String dependenciaBeneficiaria;
    private String centroCostosBeneficiario;
    private String dependenciaPagadora;
    private String centroCostosPagador;
    private String nombreOrdenadorGasto;
    private String cargoOrdenadorGasto;
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public Date getFechaSoporte() {
        return fechaSoporte;
    }

    public void setFechaSoporte(Date fechaSoporte) {
        this.fechaSoporte = fechaSoporte;
    }

    public BigDecimal getValorSoporte() {
        return valorSoporte;
    }

    public void setValorSoporte(BigDecimal valorSoporte) {
        this.valorSoporte = valorSoporte;
    }

    public String getAcuerdoCobro() {
        return acuerdoCobro;
    }

    public void setAcuerdoCobro(String acuerdoCobro) {
        this.acuerdoCobro = acuerdoCobro;
    }

    public String getDependenciaBeneficiaria() {
        return dependenciaBeneficiaria;
    }

    public void setDependenciaBeneficiaria(String dependenciaBeneficiaria) {
        this.dependenciaBeneficiaria = dependenciaBeneficiaria;
    }

    public String getCentroCostosBeneficiario() {
        return centroCostosBeneficiario;
    }

    public void setCentroCostosBeneficiario(String centroCostosBeneficiario) {
        this.centroCostosBeneficiario = centroCostosBeneficiario;
    }

    public String getDependenciaPagadora() {
        return dependenciaPagadora;
    }

    public void setDependenciaPagadora(String dependenciaPagadora) {
        this.dependenciaPagadora = dependenciaPagadora;
    }

    public String getCentroCostosPagador() {
        return centroCostosPagador;
    }

    public void setCentroCostosPagador(String centroCostosPagador) {
        this.centroCostosPagador = centroCostosPagador;
    }

    public String getNombreOrdenadorGasto() {
        return nombreOrdenadorGasto;
    }

    public void setNombreOrdenadorGasto(String nombreOrdenadorGasto) {
        this.nombreOrdenadorGasto = nombreOrdenadorGasto;
    }

    public String getCargoOrdenadorGasto() {
        return cargoOrdenadorGasto;
    }

    public void setCargoOrdenadorGasto(String cargoOrdenadorGasto) {
        this.cargoOrdenadorGasto = cargoOrdenadorGasto;
    }
        
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipoUsuarioConsumo() {
        return tipoUsuarioConsumo;
    }

    public void setTipoUsuarioConsumo(String tipoUsuarioConsumo) {
        this.tipoUsuarioConsumo = tipoUsuarioConsumo;
    }

    public String getUsuarioConsumo() {
        return usuarioConsumo;
    }

    public void setUsuarioConsumo(String usuarioConsumo) {
        this.usuarioConsumo = usuarioConsumo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(Date fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public Date getFechaInicioPeriodo() {
        return fechaInicioPeriodo;
    }

    public void setFechaInicioPeriodo(Date fechaInicioPeriodo) {
        this.fechaInicioPeriodo = fechaInicioPeriodo;
    }

    public Date getFechaFinPeriodo() {
        return fechaFinPeriodo;
    }

    public void setFechaFinPeriodo(Date fechaFinPeriodo) {
        this.fechaFinPeriodo = fechaFinPeriodo;
    }

    public String getNumeroSoporte() {
        return numeroSoporte;
    }

    public void setNumeroSoporte(String numeroSoporte) {
        this.numeroSoporte = numeroSoporte;
    }    
        
}
