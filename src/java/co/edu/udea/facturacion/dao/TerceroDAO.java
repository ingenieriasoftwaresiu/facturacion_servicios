/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.Tercero;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface TerceroDAO {
    public List<Tercero> obtenerTerceros(String strNIT, String strRazonSocial, String strClaseProveedor) throws GIDaoException;
}
