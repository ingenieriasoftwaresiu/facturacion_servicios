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
public class ServicioXSubservicio {
    private String servicio;
    private String subservicio;
    private String modoIngresoConsumo;

    public String getModoIngresoConsumo() {
        return modoIngresoConsumo;
    }

    public void setModoIngresoConsumo(String modoIngresoConsumo) {
        this.modoIngresoConsumo = modoIngresoConsumo;
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
        
}
