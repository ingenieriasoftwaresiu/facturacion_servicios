/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ParametroMail;
import co.edu.udea.facturacion.exception.GIDaoException;

/**
 *
 * @author jorge.correa
 */
public interface EnvioMailDAO {
    public void sendMail(ParametroMail parametroMail) throws GIDaoException;
}
