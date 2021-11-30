/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.exception.OrgSistemasSecurityException;
import co.edu.udea.facturacion.dao.DependenciaDAO;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import co.edu.udea.facturacion.dto.Dependencia;
import co.edu.udea.facturacion.dto.OrdenadorSAP;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.exception.GIDaoException;
import co.edu.udea.wsClient.OrgSistemasWebServiceClient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public class DependenciaDAOImpl implements DependenciaDAO{
    
    private ParametroGeneral parametroGeneral;
    
    public DependenciaDAOImpl(){
        ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
        
        try{
            this.parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
        }catch(GIDaoException e){
            new GIDaoException("Se generó un error al obtener los parámetros generales desde la clase DependenciaDAOImpl.", e);
        }
    }

    @Override
    public List<Dependencia> obtenerTodas() throws GIDaoException {
        List<Dependencia> dependencias = null;        
        boolean pruebas = true;
        String strToken = this.parametroGeneral.getTokenServiciosWeb().trim();
        
        try{
                //true: Apunta a datos de pruebas, false: Apunta a datos de producción 

                OrgSistemasWebServiceClient wsClient = new OrgSistemasWebServiceClient(pruebas);

                //Se adicionan parametros de acuerdo a los especificados en el documento de servicios web.
                //dependencia: Nombre del parametro, 0101: valor del parámetro
                //En caso de ser opcional se debe mandar un string vacío.  
                wsClient.addParam("dependencia", "");

                //Se obtiene el resultado del llamado al webservice. En este caso se obtiene un listado de objetos de tipo Dependencia, el cual se debe crear localmente tal 
                //cual como se indique en el archivo de especificaciones de los servicios web.
                //1er parámetro: consultardependenciassipe: Nombre del servicio web a invocar como esta en el archivo de especificaciones de los servicios web.
                //2do parámetro: ConstantesEstaticas.TOKEN: Es el valor que desde gesttión informática se le especifique.Se recomienda configurarlo en un archivo de variables constantes.
                //3ro parámetro: Tipo de la clase que se va a recibir en el listado.
                dependencias = wsClient.obtenerBean("consultardependenciassipe",strToken, Dependencia.class);
               
        }catch(OrgSistemasSecurityException e){
           new GIDaoException("Se generó un error al recuperar desde SIPE todas las dependencias UdeA.", e);
        }
        
        return dependencias;
    }

    @Override
    public List<Dependencia> obtenerSubdependencias(String strCodigo)  throws GIDaoException {
        List<Dependencia> dependencias = new ArrayList<Dependencia>();        
        boolean pruebas = true;
        String strToken = this.parametroGeneral.getTokenServiciosWeb().trim();
        
        try{
                //true: Apunta a datos de pruebas, false: Apunta a datos de producción 

                OrgSistemasWebServiceClient wsClient = new OrgSistemasWebServiceClient(pruebas);

                //Se adicionan parametros de acuerdo a los especificados en el documento de servicios web.
                //dependencia: Nombre del parametro, 0101: valor del parámetro
                //En caso de ser opcional se debe mandar un string vacío.  
                wsClient.addParam("dependencia", strCodigo);

                //Se obtiene el resultado del llamado al webservice. En este caso se obtiene un listado de objetos de tipo Dependencia, el cual se debe crear localmente tal 
                //cual como se indique en el archivo de especificaciones de los servicios web.
                //1er parámetro: consultardependenciassipe: Nombre del servicio web a invocar como esta en el archivo de especificaciones de los servicios web.
                //2do parámetro: ConstantesEstaticas.TOKEN: Es el valor que desde gesttión informática se le especifique.Se recomienda configurarlo en un archivo de variables constantes.
                //3ro parámetro: Tipo de la clase que se va a recibir en el listado.
                dependencias = wsClient.obtenerBean("consultardependenciassipe",strToken, Dependencia.class);
               
        }catch(OrgSistemasSecurityException e){
           new GIDaoException("Se generó un error al recuperar desde SIPE la dependencia UdeA con código " + strCodigo + ".", e);
        }
        
        return dependencias;
    }

    @Override
    public List<OrdenadorSAP> obtenerOrdenadorSAP(String strCodigoCentro) throws GIDaoException {
        
        List<OrdenadorSAP> ordenadoresSAP = new ArrayList<OrdenadorSAP>();
        boolean pruebas = true;
        String strToken = this.parametroGeneral.getTokenServiciosWeb().trim();
        
        try{
                //true: Apunta a datos de pruebas, false: Apunta a datos de producción 

                OrgSistemasWebServiceClient wsClient = new OrgSistemasWebServiceClient(pruebas);

                //Se adicionan parametros de acuerdo a los especificados en el documento de servicios web.
                //dependencia: Nombre del parametro, 0101: valor del parámetro
                //En caso de ser opcional se debe mandar un string vacío.  
                wsClient.addParam("centroGestor", strCodigoCentro);
                wsClient.addParam("proyecto", "");

                //Se obtiene el resultado del llamado al webservice. En este caso se obtiene un listado de objetos de tipo Dependencia, el cual se debe crear localmente tal 
                //cual como se indique en el archivo de especificaciones de los servicios web.
                //1er parámetro: consultardependenciassipe: Nombre del servicio web a invocar como esta en el archivo de especificaciones de los servicios web.
                //2do parámetro: ConstantesEstaticas.TOKEN: Es el valor que desde gesttión informática se le especifique.Se recomienda configurarlo en un archivo de variables constantes.
                //3ro parámetro: Tipo de la clase que se va a recibir en el listado.
                ordenadoresSAP = wsClient.obtenerBean("consultarordenadorsap",strToken, OrdenadorSAP.class);
               
        }catch(OrgSistemasSecurityException e){
           new GIDaoException("Se generó un error al recuperar desde SAP el ordenador para la dependencia UdeA con código " + strCodigoCentro + ".", e);
        }
        
        return ordenadoresSAP;
    }

    @Override
    public List<Dependencia> obtenerNombreDependencia(String strCodigo) throws GIDaoException {
        List<Dependencia> dependencias = new ArrayList<Dependencia>();        
        boolean pruebas = true;
        String strToken = this.parametroGeneral.getTokenServiciosWeb().trim();
        
        try{
                //true: Apunta a datos de pruebas, false: Apunta a datos de producción 

                OrgSistemasWebServiceClient wsClient = new OrgSistemasWebServiceClient(pruebas);

                //Se adicionan parametros de acuerdo a los especificados en el documento de servicios web.
                //dependencia: Nombre del parametro, 0101: valor del parámetro
                //En caso de ser opcional se debe mandar un string vacío.  
                wsClient.addParam("dependencia", strCodigo);

                //Se obtiene el resultado del llamado al webservice. En este caso se obtiene un listado de objetos de tipo Dependencia, el cual se debe crear localmente tal 
                //cual como se indique en el archivo de especificaciones de los servicios web.
                //1er parámetro: consultardependenciassipe: Nombre del servicio web a invocar como esta en el archivo de especificaciones de los servicios web.
                //2do parámetro: ConstantesEstaticas.TOKEN: Es el valor que desde gesttión informática se le especifique.Se recomienda configurarlo en un archivo de variables constantes.
                //3ro parámetro: Tipo de la clase que se va a recibir en el listado.
                dependencias = wsClient.obtenerBean("consultarnombredependenciasipe",strToken, Dependencia.class);
               
        }catch(OrgSistemasSecurityException e){
           new GIDaoException("Se generó un error al recuperar desde SIPE el nombre de la dependencia UdeA con código " + strCodigo + ".", e);
        }
        
        return dependencias;
    }
    
}
