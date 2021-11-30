/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface NotificacionMailDAO {
    public void notificarFacturacionUsuarioSIU(String strTipoUsuarioConsumo, String strUsuarioConsumo, String strFechaInicial, String strFechaFinal, Long lgCodigoCuentaCobro) throws GIDaoException;
    public void notificarFacturacionAuxiliaresProyectos(List<String> usuariosNotificados, String strFechaInicial, String strFechaFinal) throws GIDaoException;
    public void notificarFacturacionResponsablesServicios(List<String> usuariosNotificados, String strFechaInicial, String strFechaFinal) throws GIDaoException;
    public void notificarResponsablesIngresoConsumos(String strFechaInicial, String strFechaFinal) throws GIDaoException;
    public void notificarRevisionCuentaCobro(Long lgCodigoCuentaCobro, String strAcuerdoCobro) throws GIDaoException;
}
