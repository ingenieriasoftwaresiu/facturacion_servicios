/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.InsumoServicio;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface InsumoServicioDAO {
    public List<InsumoServicio> obtenerTodos() throws GIDaoException;
    public List<InsumoServicio> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public InsumoServicio obtenerUno(String strCodigo) throws GIDaoException;
    public void insertar(InsumoServicio insumoServicio) throws GIDaoException;
    public void actualizar(InsumoServicio insumoServicio) throws GIDaoException;
    public void eliminar(String strCodigo) throws GIDaoException;
}
