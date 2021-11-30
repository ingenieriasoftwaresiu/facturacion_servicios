/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.jobs;

import co.edu.udea.facturacion.dao.FuncionesComunesDAO;
import co.edu.udea.facturacion.dao.NotificacionMailDAO;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl;
import co.edu.udea.facturacion.dao.impl.NotificacionMailDAOImpl;
import co.edu.udea.facturacion.exception.GIDaoException;

/**
 *
 * @author jorge.correa
 */
public class PruebaNotificarResponsablesIngresoConsumos {
    
     public static void main(String[] args){
         
        String strFechaActual=null, strFechaFinal=null, strFechaInicial=null, strAnio=null, strMes=null;
        String[] strTemp = null;
        NotificacionMailDAO notificacionMailDAO = null;
        FuncionesComunesDAO funcionesComunesDAO = null;

        notificacionMailDAO = new NotificacionMailDAOImpl();
        funcionesComunesDAO = new FuncionesComunesDAOImpl();
        strFechaActual = funcionesComunesDAO.getFechaActual();     
         
        strTemp = strFechaActual.split("-");
        strAnio = strTemp[0];
        strMes = strTemp[1];
                
        strFechaInicial = strAnio + "-" + strMes + "-" + "01";             
        strFechaFinal = funcionesComunesDAO.getUltimaDiaFecha(strAnio, strMes);
        
        try{
            notificacionMailDAO.notificarResponsablesIngresoConsumos(strFechaInicial, strFechaFinal);
        }catch(GIDaoException e){
            new GIDaoException("Se generó un error al enviar la notificación de ingresos de consumos a los Responsables de Servicios para el periodo " + strFechaInicial + " a " + strFechaFinal, e);
        }
     }
}
