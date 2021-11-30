/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.UnidadMedida;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface UnidadMedidaDAO {
    
    public List<UnidadMedida> obtenerTodas() throws GIDaoException;
    public List<UnidadMedida> obtenerTodasPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException;
    public UnidadMedida obtenerUna(String strCodigo) throws GIDaoException;
    public void insertar(UnidadMedida unidad_medida) throws GIDaoException;
    public void actualizar(UnidadMedida unidad_medida) throws GIDaoException;
    public void eliminar(String strCodigo) throws GIDaoException;
    
}
