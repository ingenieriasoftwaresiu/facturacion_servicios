/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.TipoUsuario;
import co.edu.udea.facturacion.dto.UnidadMedida;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface ServicioXTipoUsuarioDAO {
    public List<ServicioXTipoUsuario> obtenerTodos() throws GIDaoException;
    public List<ServicioXTipoUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public ServicioXTipoUsuario obtenerUno(Integer intCodigo) throws GIDaoException;
    public ServicioXTipoUsuario obtenerPorServicioSubservicioTipoUsuario(String strServicio, String strSubservicio, String strTipoUsuario) throws GIDaoException;
    public List<UnidadMedida> obtenerUnidadesPorServicioSubservicioTipoUsuario(String strServicio, String strSubservicio, String strTipoUsuario) throws GIDaoException;
    public ServicioXTipoUsuario obtenerPorServicioSubservicioTipoUsuarioUnidad(String strServicio, String strSubservicio, String strTipoUsuario, String strUnidad) throws GIDaoException;
    public List<TipoUsuario> obtenerTiposUsuarioPorServicioSubservicio(String strServicio, String strSubservicio) throws GIDaoException;    
    public void insertar(ServicioXTipoUsuario servicioXtipousuario) throws GIDaoException;
    public void actualizar(ServicioXTipoUsuario servicioXtipousuario) throws GIDaoException;
    public void eliminar(Integer intCodigo) throws GIDaoException;    
}
