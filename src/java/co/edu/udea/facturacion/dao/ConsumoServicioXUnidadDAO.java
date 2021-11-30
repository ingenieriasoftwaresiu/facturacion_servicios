/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dto.ParametroBusquedaRegistro;
import co.edu.udea.facturacion.dto.ServicioXSubservicioXUnidad;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface ConsumoServicioXUnidadDAO {
    public List<ConsumoServicioXUnidad> obtenerTodos() throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerTodosBusqueda(ParametroBusquedaRegistro parametroBusquedaConsumo) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerTodosBusquedaPorPaginas(ParametroBusquedaRegistro parametroBusquedaConsumo, Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerPorRangoFechas(String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerPorServicio(String strServicio) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerPorServicioYRangoFechas(String strServicio, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerPorUsuario(String strTipoUsuarioConsumo, String strUsuario) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerPorUsuarioYRangoFechas(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerConsumosXServicio_Subservicio_Unidad(String strServicio, String strSubservicio, String strUnidad, String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXUnidad> obtenerConsumosPorServicioSubservicioCuentaCobro(String strServicio, String strSubservicio, Long lgCodigoCuentaCobro) throws GIDaoException;
    public List<ServicioXSubservicioXUnidad> obtenerServiciosSubserviciosConsumidos(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public ConsumoServicioXUnidad obtenerUno(Integer intCodigo) throws GIDaoException;
    public Integer validarInsercion(String strIdServicio, String strIdSubservicio, Date dtFechaConsumo, String strTipoUsuarioConsumo, String strIdUsuario, String strIdUnidadMedida) throws GIDaoException;
    public Integer insertar(ConsumoServicioXUnidad consumo) throws GIDaoException;
    public void actualizar(ConsumoServicioXUnidad consumo) throws GIDaoException;
    public void eliminar(Integer intCodigo) throws GIDaoException;
    public List<UsuarioConsumidor> obtenerUsuariosConsumidores(String strFechaInicio, String strFechaFin) throws GIDaoException;
}
