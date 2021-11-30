/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.UsuarioConsumoSIU;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author George
 */
public interface UsuarioConsumoSIUDAO {
    public List<UsuarioConsumoSIU> obtenerTodos() throws GIDaoException;
    public UsuarioConsumoSIU obtenerUno(String strCodigo) throws GIDaoException;
}
