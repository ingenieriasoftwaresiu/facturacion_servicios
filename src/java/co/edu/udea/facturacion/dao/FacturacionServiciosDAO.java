/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface FacturacionServiciosDAO {
    public BigDecimal facturarPorInsumos(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin, Long lgCuentaCobro) throws GIDaoException;
    public BigDecimal facturarPorTiposUsuario(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin, Long lgCuentaCobro) throws GIDaoException;
    public BigDecimal facturarPorUnidades(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin, Long lgCuentaCobro) throws GIDaoException;
    public Long facturarConsumos(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin, String strUsuarioCreacion) throws GIDaoException;
    public List<UsuarioConsumidor> obtenerUsuariosConsumidores(String strFechaInicio, String strFechaFin) throws GIDaoException;
}
