/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.exception.OrgSistemasSecurityException;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import co.edu.udea.facturacion.dao.TerceroDAO;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.dto.Tercero;
import co.edu.udea.facturacion.exception.GIDaoException;
import co.edu.udea.wsClient.OrgSistemasWebServiceClient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public class TerceroDAOImpl implements TerceroDAO{
    
    private ParametroGeneral parametroGeneral;
    
    public TerceroDAOImpl(){
        ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
        
        try{
            this.parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
        }catch(GIDaoException e){
            new GIDaoException("Se generó un error al obtener los parámetros generales desde la clase TerceroDAOImpl.", e);
        }
    }

    @Override
    public List<Tercero> obtenerTerceros(String strNIT, String strRazonSocial, String strClaseProveedor) throws GIDaoException {
        List<Tercero> terceros = new ArrayList<Tercero>();
        boolean pruebas = true;
        String strToken = this.parametroGeneral.getTokenServiciosWeb().trim();
        strClaseProveedor = "NACIONAL";
        
        try{            
            OrgSistemasWebServiceClient wsClient = new OrgSistemasWebServiceClient(pruebas);

            wsClient.addParam("nit", strNIT);
            wsClient.addParam("nombre", strRazonSocial);
            wsClient.addParam("claseProveedor", strClaseProveedor);

            terceros = wsClient.obtenerBean("consultartercerossap", strToken, Tercero.class);
                 
        }catch(OrgSistemasSecurityException e){
            e.printStackTrace();
        }
        
        return terceros;
    }
    
}
