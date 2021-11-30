/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.jobs;

import co.edu.udea.facturacion.dao.FacturacionServiciosDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesDAO;
import co.edu.udea.facturacion.dao.NotificacionMailDAO;
import co.edu.udea.facturacion.dao.impl.FacturacionServiciosDAOImpl;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesConsumosDAOImpl;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl;
import co.edu.udea.facturacion.dao.impl.NotificacionMailDAOImpl;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.ArrayList;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author jorge.correa
 */
public class FacturarConsumos implements Job{

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {       
        
        String strFechaFinal=null, strMes=null, strAnio=null, strFechaInicial=null, strTipoUsuarioConsumo=null, strUsuarioConsumo=null, strUsuarioCreacion=null;    
        String[] strTemp=null;          
        Long lgCodigoCuentaCobro = null;
        FuncionesComunesDAO funcionesComunesDAO = null;
        FuncionesComunesConsumosDAO funcionesComunesConsumosDAO = null;     
        FacturacionServiciosDAO facturacionServiciosDAO = null;
        NotificacionMailDAO notificacionMailDAO = null;
        List<UsuarioConsumidor> usuariosConsumidores = null;
        List<String> UsuariosNotificados = new ArrayList<String>();
                
        facturacionServiciosDAO = new FacturacionServiciosDAOImpl();        
        funcionesComunesConsumosDAO = new FuncionesComunesConsumosDAOImpl();
        notificacionMailDAO = new NotificacionMailDAOImpl();
        funcionesComunesDAO = new FuncionesComunesDAOImpl();
        strFechaFinal = funcionesComunesDAO.getFechaActual();        
        strUsuarioCreacion = "SISTEMA";        
                   
        strTemp = strFechaFinal.split("-");
        strAnio = strTemp[0];
        strMes = strTemp[1];
                
        strFechaInicial = strAnio + "-" + strMes + "-" + "01";             
                                       
        // Buscar los usuarios con consumos para el periodo.
        
        try{
            usuariosConsumidores = facturacionServiciosDAO.obtenerUsuariosConsumidores(strFechaInicial, strFechaFinal);
        }catch(GIDaoException e){
            new GIDaoException("Se generó un error recuperando los usuarios consumidores para el periodo " + strFechaInicial + " a " + strFechaFinal, e);
        }
        
        if (usuariosConsumidores.size() > 0){                       
            for (UsuarioConsumidor usuarioConsumidor : usuariosConsumidores){
                strTipoUsuarioConsumo = usuarioConsumidor.getTipoUsuario();
                strUsuarioConsumo = usuarioConsumidor.getUsuario();                               
                                                
               try{
                    lgCodigoCuentaCobro = facturacionServiciosDAO.facturarConsumos(strTipoUsuarioConsumo, strUsuarioConsumo, strFechaInicial, strFechaFinal, strUsuarioCreacion);
                }catch(GIDaoException e){
                    new GIDaoException("Se generó un error facturando los consumos del usuario " + strUsuarioConsumo + " para el periodo " + strFechaInicial + " a " + strFechaFinal, e);
                }     
                
                if ((lgCodigoCuentaCobro != null) && (lgCodigoCuentaCobro > 0)){                    
                                        
                    // Enviar notificación al usuario con enlace para revisión de consumos.
                    
                    if (strTipoUsuarioConsumo.equals("UI")){
                                                
                        UsuariosNotificados.add(funcionesComunesConsumosDAO.obtenerUsuario(strUsuarioConsumo, strTipoUsuarioConsumo));
                        
                       try{                            
                            notificacionMailDAO.notificarFacturacionUsuarioSIU(strTipoUsuarioConsumo, strUsuarioConsumo, strFechaInicial, strFechaFinal, lgCodigoCuentaCobro);
                        }catch(GIDaoException e){
                            new GIDaoException("Se generó un error al enviar la notificaciónde facturación al usuario " + strUsuarioConsumo, e);
                        }
                    }                    
                }
                
                strTipoUsuarioConsumo = null;
                strUsuarioConsumo = null;
                lgCodigoCuentaCobro = null;
            }
            
            if (UsuariosNotificados.size() > 0){
                                 
                // Notificar a los auxiliares de proyectos.
                
               try{
                    notificacionMailDAO.notificarFacturacionAuxiliaresProyectos(UsuariosNotificados, strFechaInicial, strFechaFinal);
               }catch(GIDaoException e){
                    new GIDaoException("Se generó un error enviando la notificación de facturación a los Auxiliares de Proyectos.", e);
               }
               
               // Notificar a los responsables de servicios.
               
               try{
                    notificacionMailDAO.notificarFacturacionResponsablesServicios(UsuariosNotificados, strFechaInicial, strFechaFinal);
               }catch(GIDaoException e){
                    new GIDaoException("Se generó un error enviando la notificación de facturación a los Responsables de Servicios.", e);
               }               
            }
        }
    }    
}
