/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author George
 */
public interface UsuarioSIUDAO {
    
    public UsuarioSesionSIU validarCredencialesAcceso(String strUser, String strPassword) throws GIDaoException;
    public UsuarioSesionSIU obtenerInfoUsuario(String strIdentificacion) throws GIDaoException;
    public List<UsuarioSesionSIU> obtenerTodos() throws GIDaoException;
}
