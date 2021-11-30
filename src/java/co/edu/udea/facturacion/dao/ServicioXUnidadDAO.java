/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ServicioXUnidad;
import co.edu.udea.facturacion.dto.UnidadMedida;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface ServicioXUnidadDAO {
    public List<ServicioXUnidad> obtenerTodos() throws GIDaoException;
    public List<ServicioXUnidad> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public ServicioXUnidad obtenerUno(Integer intCodigo) throws GIDaoException;
    public ServicioXUnidad obtenerPorServicioSubservicioUnidad(String strServicio, String strSubservicio, String strUnidad) throws GIDaoException;  
    public List<UnidadMedida> obtenerUnidadesPorServicioSubservicio(String strServicio, String strSubservicio) throws GIDaoException;  
    public void insertar(ServicioXUnidad servicioXunidad) throws GIDaoException;
    public void actualizar(ServicioXUnidad servicioXunidad) throws GIDaoException;
    public void eliminar(Integer intCodigo) throws GIDaoException;    
}
