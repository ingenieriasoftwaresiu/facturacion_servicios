/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface ConsumoAdicionalXUnidadDAO {
    public List<ConsumoAdicional> obtenerTodos() throws GIDaoException;
    public ConsumoAdicional obtenerUno(Integer intCodigo) throws GIDaoException;
    public List<ConsumoAdicional> obtenerPorConsumo(Integer intCodigoConsumo) throws GIDaoException;
    public void insertar(ConsumoAdicional consumoAdicional) throws GIDaoException;
    public void actualizar(ConsumoAdicional consumoAdicional) throws GIDaoException;
    public void eliminar(Integer intCodigo) throws GIDaoException;
}
