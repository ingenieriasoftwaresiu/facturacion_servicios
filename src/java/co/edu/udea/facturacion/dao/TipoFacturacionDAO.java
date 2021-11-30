/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.TipoFacturacion;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface TipoFacturacionDAO {
    public List<TipoFacturacion> obtenerTodos() throws GIDaoException;
    public List<TipoFacturacion> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public TipoFacturacion obtenerUno(String strCodigo) throws GIDaoException;
    public void insertar(TipoFacturacion tipoFacturacion) throws GIDaoException;
    public void actualizar(TipoFacturacion tipoFacturacion) throws GIDaoException;
    public void eliminar(String strCodigo) throws GIDaoException;
}
