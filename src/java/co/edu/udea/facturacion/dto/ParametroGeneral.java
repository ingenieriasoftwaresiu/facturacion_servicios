/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

/**
 *
 * @author Jorge.correa
 */
public class ParametroGeneral {
    private String codigo;
    private String tituloApp;
    private String subtituloApp;
    private Integer numeroRegistrosXPagina;
    private String nombreServidor;
    private Integer numeroPuerto;
    private String usuarioConexion;
    private String claveConexion;
    private Integer numeroDiasLimitePago;
    private float porcentajeSancion;
    private String tokenServiciosWeb;

    public String getTokenServiciosWeb() {
        return tokenServiciosWeb;
    }

    public void setTokenServiciosWeb(String tokenServiciosWeb) {
        this.tokenServiciosWeb = tokenServiciosWeb;
    }
    
    public float getPorcentajeSancion() {
        return porcentajeSancion;
    }

    public void setPorcentajeSancion(float porcentajeSancion) {
        this.porcentajeSancion = porcentajeSancion;
    }
        
    public String getNombreServidor() {
        return nombreServidor;
    }

    public void setNombreServidor(String nombreServidor) {
        this.nombreServidor = nombreServidor;
    }

    public Integer getNumeroPuerto() {
        return numeroPuerto;
    }

    public void setNumeroPuerto(Integer numeroPuerto) {
        this.numeroPuerto = numeroPuerto;
    }

    public String getUsuarioConexion() {
        return usuarioConexion;
    }

    public void setUsuarioConexion(String usuarioConexion) {
        this.usuarioConexion = usuarioConexion;
    }

    public String getClaveConexion() {
        return claveConexion;
    }

    public void setClaveConexion(String claveConexion) {
        this.claveConexion = claveConexion;
    }

    public Integer getNumeroDiasLimitePago() {
        return numeroDiasLimitePago;
    }

    public void setNumeroDiasLimitePago(Integer numeroDiasLimitePago) {
        this.numeroDiasLimitePago = numeroDiasLimitePago;
    }
        
    public String getSubtituloApp() {
        return subtituloApp;
    }

    public void setSubtituloApp(String subtituloApp) {
        this.subtituloApp = subtituloApp;
    }

    public Integer getNumeroRegistrosXPagina() {
        return numeroRegistrosXPagina;
    }

    public void setNumeroRegistrosXPagina(Integer numeroRegistrosXPagina) {
        this.numeroRegistrosXPagina = numeroRegistrosXPagina;
    }    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTituloApp() {
        return tituloApp;
    }

    public void setTituloApp(String tituloApp) {
        this.tituloApp = tituloApp;
    }
      
}
