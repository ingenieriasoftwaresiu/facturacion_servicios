/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.DetalleCuentaCobro;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface DetalleCuentaCobroDAO {
    public List<DetalleCuentaCobro> obtenerTodosPorCuentaCobro(Long lgCodigo) throws GIDaoException;
    public List<DetalleCuentaCobro> obtenerTodosPorServicioYCuentaCobro(Long lgCodigo, String strIdServicio) throws GIDaoException;
    public BigDecimal obtenerTotalPorServicioYCuentaCobro(Long lgCodigo, String strIdServicio) throws GIDaoException;
    public DetalleCuentaCobro obtenerUno(Long lgCodigo, String strServicio, String strSubservicio) throws GIDaoException;
    public void insertar(DetalleCuentaCobro detalleCuentaCobro) throws GIDaoException;
    public void actualizar(DetalleCuentaCobro detalleCuentaCobro) throws GIDaoException;
    public void eliminarPorCuentaCobro(Long lgCodigo) throws GIDaoException;
    public void eliminarUno(Long lgCodigo, String strServicio, String strSubservicio) throws GIDaoException;
}
