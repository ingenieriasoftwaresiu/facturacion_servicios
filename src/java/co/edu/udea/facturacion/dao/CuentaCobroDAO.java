/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.CuentaCobro;
import co.edu.udea.facturacion.dto.ParametroBusquedaRegistro;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface CuentaCobroDAO {
    public List<CuentaCobro> obtenerTodas() throws GIDaoException;
    public List<CuentaCobro> obtenerTodasPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public List<CuentaCobro> obtenerTodosBusqueda(ParametroBusquedaRegistro parametroBusquedaConsumo) throws GIDaoException;
    public List<CuentaCobro> obtenerTodosBusquedaPorPaginas(ParametroBusquedaRegistro parametroBusquedaConsumo, Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public CuentaCobro obtenerUna(Long lgCodigo) throws GIDaoException;
    public Integer validacionInsercion(String strIdTipoConsumo, String strIdUsuario, Date dtFechaInicio, Date dtFechaFin) throws GIDaoException;
    public Long insertar(CuentaCobro cuentaCobro) throws GIDaoException;
    public void actualizar(CuentaCobro cuentaCobro) throws GIDaoException;
    public void eliminar(Long lgCodigo) throws GIDaoException;
}
