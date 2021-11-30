/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.exception.GIDaoException;

/**
 *
 * @author Jorge.correa
 */
public interface ParametroGeneralDAO {
    public ParametroGeneral obtenerParametrosGenerales() throws GIDaoException;
    public void insertarParametrosGenerales(ParametroGeneral parametroGeneral) throws GIDaoException;
    public void actualizarParametrosGenerales(ParametroGeneral parametroGeneral) throws GIDaoException;
}
