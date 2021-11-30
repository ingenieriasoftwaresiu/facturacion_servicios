/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ServicioXInsumo;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface ServicioXInsumoDAO {
    public List<ServicioXInsumo> obtenerTodos() throws GIDaoException;
    public List<ServicioXInsumo> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public ServicioXInsumo obtenerUno(Integer intCodigo) throws GIDaoException;
    public List<ServicioXInsumo> obtenerPorServicioSubservicio(String strServicio, String strSubservicio) throws GIDaoException;
    public ServicioXInsumo obtenerPorServicioSubservicioInsumo(String strServicio, String strSubservicio, String strInsumo) throws GIDaoException;
    public void insertar(ServicioXInsumo servicioXinsumo) throws GIDaoException;
    public void actualizar(ServicioXInsumo servicioXinsumo) throws GIDaoException;
    public void eliminar(Integer intCodigo) throws GIDaoException;    
}
