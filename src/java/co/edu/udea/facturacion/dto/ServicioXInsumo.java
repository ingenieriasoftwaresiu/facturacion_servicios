/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

import java.math.BigDecimal;

/**
 *
 * @author Jorge.correa
 */
public class ServicioXInsumo {
    private Integer codigo;
    private String servicio;
    private String subservicio;
    private String insumo;
    private String cobroTransversal;
    private Integer cantidadCobroTransversal;
    private BigDecimal cantidadFija;
    private String unidadCantidadFija;
    private String utilizaCostoVariable;
    private Long costoVariable;
    private String seCobraAlUsuario;

    public BigDecimal getCantidadFija() {
        return cantidadFija;
    }

    public void setCantidadFija(BigDecimal cantidadFija) {
        this.cantidadFija = cantidadFija;
    }    

    public String getSeCobraAlUsuario() {
        return seCobraAlUsuario;
    }

    public void setSeCobraAlUsuario(String seCobraAlUsuario) {
        this.seCobraAlUsuario = seCobraAlUsuario;
    }    
    
    public String getUtilizaCostoVariable() {
        return utilizaCostoVariable;
    }

    public void setUtilizaCostoVariable(String utilizaCostoVariable) {
        this.utilizaCostoVariable = utilizaCostoVariable;
    }

    public Long getCostoVariable() {
        return costoVariable;
    }

    public void setCostoVariable(Long costoVariable) {
        this.costoVariable = costoVariable;
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

    public String getCobroTransversal() {
        return cobroTransversal;
    }

    public void setCobroTransversal(String cobroTransversal) {
        this.cobroTransversal = cobroTransversal;
    }

    public Integer getCantidadCobroTransversal() {
        return cantidadCobroTransversal;
    }

    public void setCantidadCobroTransversal(Integer cantidadCobroTransversal) {
        this.cantidadCobroTransversal = cantidadCobroTransversal;
    }

    public String getUnidadCantidadFija() {
        return unidadCantidadFija;
    }

    public void setUnidadCantidadFija(String unidadCantidadFija) {
        this.unidadCantidadFija = unidadCantidadFija;
    }    
    
}
