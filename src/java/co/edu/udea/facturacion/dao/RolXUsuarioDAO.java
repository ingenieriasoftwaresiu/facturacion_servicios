/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.RolXUsuario;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface RolXUsuarioDAO {
    public List<RolXUsuario> obtenerTodos() throws GIDaoException;
    public List<RolXUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public RolXUsuario obtenerUno(String strPersona, String strRol) throws GIDaoException;
    public List<RolXUsuario> obtenerPorPersona(String strPersona) throws GIDaoException;
    public List<RolXUsuario> obtenerPorRol(String strRol) throws GIDaoException;
    public List<RolXUsuario> obtenerAuxiliaresProyectos() throws GIDaoException;
    public List<RolXUsuario> obtenerResponsables() throws GIDaoException;
    public List<RolXUsuario> obtenerAdministradores() throws GIDaoException;
    public List<RolXUsuario> obtenerDesarrolladores() throws GIDaoException;
    public void insertar(RolXUsuario rolXpersona) throws GIDaoException;
    public void eliminar(String strPersona, String strRol) throws GIDaoException;
}
