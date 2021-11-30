/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.RolUsuario;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface RolUsuarioDAO {
    public List<RolUsuario> obtenerTodos() throws GIDaoException;
    public List<RolUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public List<RolUsuario> obtenerTodosPorAutenticar(String strSeAutentican) throws GIDaoException;
    public RolUsuario obtenerUno(String strCodigo) throws GIDaoException;
    public void insertar(RolUsuario rolUsuario) throws GIDaoException;
    public void actualizar(RolUsuario rolUsuario) throws GIDaoException;
    public void eliminar(String strCodigo) throws GIDaoException;
}
