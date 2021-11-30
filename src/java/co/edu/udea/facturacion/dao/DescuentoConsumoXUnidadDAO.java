/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.DescuentoConsumo;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface DescuentoConsumoXUnidadDAO {
    public List<DescuentoConsumo> obtenerTodos() throws GIDaoException;
    public DescuentoConsumo obtenerUno(Integer intCodigo) throws GIDaoException;
    public DescuentoConsumo obtenerPorConsumo(Integer intCodigoConsumo) throws GIDaoException;
    public void insertar(DescuentoConsumo descuentoConsumo) throws GIDaoException;
    public void actualizar(DescuentoConsumo descuentoConsumo) throws GIDaoException;
    public void eliminar(Integer intCodigo) throws GIDaoException;
}
