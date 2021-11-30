/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dto.ParametroBusquedaRegistro;
import co.edu.udea.facturacion.dto.ServicioXSubservicio;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface ConsumoServicioXInsumoDAO {
    
    public List<ConsumoServicioXInsumo> obtenerTodos() throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerTodosBusqueda(ParametroBusquedaRegistro parametroBusquedaConsumo) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerTodosBusquedaPorPaginas(ParametroBusquedaRegistro parametroBusquedaConsumo, Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public ConsumoServicioXInsumo obtenerUno(Integer intCodigo) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerPorRangoFechas(String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerPorServicio(String strServicio) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerPorServicioYRangoFechas(String strServicio, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerPorUsuario(String strTipoUsuario, String strUsuario) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerPorUsuarioYRangoFechas(String strTipoUsuario, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerConsumosXServicio(String strServicio, String strTipoUsuario, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerConsumosXServicio_Subservicio(String strServicio, String strSubservicio, String strTipoUsuario, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;
    public List<ConsumoServicioXInsumo> obtenerConsumosPorServicioSubservicioCuentaCobro(String strServicio, String strSubservicio, Long lgCodigoCuentaCobro) throws GIDaoException;
    public List<ServicioXSubservicio> obtenerServiciosSubserviciosConsumidos(String strTipoUsuario, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException;    
    public BigDecimal validarInsercionGrupal(String strIdServicio, String strIdSubservicio, String strIdInsumo, Date dtFechaConsumo, String strTipoUsuario, String strIdUsuario) throws GIDaoException;
    public Integer validarInsercionIndividual(String strIdServicio, String strIdSubservicio, Date dtFechaConsumo, String strTipoUsuario, String strIdUsuario) throws GIDaoException;
    public void insertar(ConsumoServicioXInsumo consumo) throws GIDaoException;
    public void actualizar(ConsumoServicioXInsumo consumo) throws GIDaoException;
    public void eliminar(Integer intCodigo) throws GIDaoException;
    public List<UsuarioConsumidor> obtenerUsuariosConsumidores(String strFechaInicio, String strFechaFin) throws GIDaoException;
}
