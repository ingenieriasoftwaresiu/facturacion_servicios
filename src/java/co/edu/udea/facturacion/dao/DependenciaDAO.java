/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.Dependencia;
import co.edu.udea.facturacion.dto.OrdenadorSAP;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface DependenciaDAO {
    public List<Dependencia> obtenerTodas() throws GIDaoException;
    public List<Dependencia> obtenerNombreDependencia(String strCodigo) throws GIDaoException;
    public List<Dependencia> obtenerSubdependencias(String strCodigo) throws GIDaoException;
    public List<OrdenadorSAP> obtenerOrdenadorSAP(String strCodigoCentro) throws GIDaoException;
}
