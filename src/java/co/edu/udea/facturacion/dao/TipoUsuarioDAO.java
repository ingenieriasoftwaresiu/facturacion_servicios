/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.TipoUsuario;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface TipoUsuarioDAO {
    public List<TipoUsuario> obtenerTodos() throws GIDaoException;
    public List<TipoUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public TipoUsuario obtenerUno(String strCodigo) throws GIDaoException;
    public void insertar(TipoUsuario tipoUsuario) throws GIDaoException;
    public void actualizar(TipoUsuario tipoUsuario) throws GIDaoException;
    public void eliminar(String strCodigo) throws GIDaoException;
}
