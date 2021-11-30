/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ItemAdicional;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface ItemAdicionalDAO {
    public List<ItemAdicional> obtenerTodos() throws GIDaoException;
    public List<ItemAdicional> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public ItemAdicional obtenerUno(String strCodigo) throws GIDaoException;
    public void insertar(ItemAdicional itemAdicional) throws GIDaoException;
    public void actualizar(ItemAdicional itemAdicional) throws GIDaoException;
    public void eliminar(String strCodigo) throws GIDaoException;
}
