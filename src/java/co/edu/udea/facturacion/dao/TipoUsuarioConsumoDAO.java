/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.TipoUsuarioConsumo;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author George
 */
public interface TipoUsuarioConsumoDAO {
    public List<TipoUsuarioConsumo> obtenerTodos() throws GIDaoException;
    public TipoUsuarioConsumo obtenerUno(String strCodigo) throws GIDaoException;
    public void insertar(TipoUsuarioConsumo tipoUsuario) throws GIDaoException;
    public void actualizar(TipoUsuarioConsumo tipoUsuario) throws GIDaoException;
    public void eliminar(String strCodigo) throws GIDaoException;
}
