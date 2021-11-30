/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ParametroBusquedaRegistro;
import co.edu.udea.facturacion.dto.ServicioXSubservicioXTipoUsuarioXUnidad;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface ConsumoServicioXTipoUsuarioDAO {
    public List<ConsumoServicioXTipoUsuario> obtenerTodos() throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerTodosBusqueda(ParametroBusquedaRegistro parametroBusquedaConsumo) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerTodosBusquedaPorPaginas(ParametroBusquedaRegistro parametroBusquedaConsumo, Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerPorRangoFechas(String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerPorServicio(String strServicio) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerPorServicioYRangoFechas(String strServicio, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerPorUsuario(String strTipoUsuarioConsumo, String strUsuario) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerPorUsuarioYRangoFechas(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerConsumosXServicio_Subservicio_TipoUsuario_Unidad(String strServicio, String strSubservicio, String strTipoUsuario, String strUnidad, String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXTipoUsuario> obtenerConsumosPorServicioSubservicioCuentaCobroCodigo(String strServicio, String strSubservicio, Long lgCodigoCuentaCobro, Integer intCodigoConsumo) throws GIDaoException;
    public List<ServicioXSubservicioXTipoUsuarioXUnidad> obtenerServiciosSubserviciosConsumidos(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;    
    public ConsumoServicioXTipoUsuario obtenerUno(Integer intCodigo) throws GIDaoException;
    public Integer validarInsercion(String strIdServicio, String strIdSubservicio, String strIdTipoUsuario, Date dtFechaConsumo, String strTipoUsuarioConsumo, String strIdUsuario, String strIdUnidadMedida) throws GIDaoException;
    public Integer insertar(ConsumoServicioXTipoUsuario consumo) throws GIDaoException;
    public void actualizar(ConsumoServicioXTipoUsuario consumo) throws GIDaoException;
    public void eliminar(Integer intCodigo) throws GIDaoException;
    public List<UsuarioConsumidor> obtenerUsuariosConsumidores(String strFechaInicio, String strFechaFin) throws GIDaoException;
}
