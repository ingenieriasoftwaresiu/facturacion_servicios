/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.Servicio;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public interface ServicioDAO {
    public List<Servicio> obtenerTodos() throws GIDaoException;
    public List<Servicio> obtenerPorTipoFacturacion(String strIdTipoFacturacion) throws GIDaoException;
    public Servicio obtenerUno(String strCodigo) throws GIDaoException; 
}
