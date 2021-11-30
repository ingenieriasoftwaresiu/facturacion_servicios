/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface SubservicioDAO {
    public List<Subservicio> obtenerTodos() throws GIDaoException;
    public List<Subservicio> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public List<Subservicio> obtenerPorServicio(String strServicio) throws GIDaoException;
    public Subservicio obtenerUno(String strCodigo) throws GIDaoException;
    public Subservicio obtenerPorServicioSubservicio(String strServicio, String strSubservicio) throws GIDaoException;
    public void insertar(Subservicio subservicio) throws GIDaoException;
    public void actualizar(Subservicio subservicio) throws GIDaoException;
    public void eliminar(String strCodigo) throws GIDaoException;    
}
