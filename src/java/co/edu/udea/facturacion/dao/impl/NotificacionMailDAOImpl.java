/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.CuentaCobroDAO;
import co.edu.udea.facturacion.dao.NotificacionMailDAO;
import co.edu.udea.facturacion.dao.ParametrosSIUDAO;
import co.edu.udea.facturacion.dao.RolXUsuarioDAO;
import co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO;
import co.edu.udea.facturacion.dao.UsuarioSIUDAO;
import co.edu.udea.facturacion.dto.CuentaCobro;
import co.edu.udea.facturacion.dto.ParametroMail;
import co.edu.udea.facturacion.dto.RolXUsuario;
import co.edu.udea.facturacion.dto.UsuarioConsumoSIU;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public class NotificacionMailDAOImpl extends EnvioMailDAOimpl implements NotificacionMailDAO{
    
    private ParametroMail parametroMail;
    private String strDestinatario;
    private String strAsunto;
    private String strMensaje;
           
    @Override
    public void notificarFacturacionUsuarioSIU(String strTipoUsuarioConsumo, String strUsuarioConsumo, String strFechaInicial, String strFechaFinal, Long lgCodigoCuentaCobro) throws GIDaoException {
        
        String strCoordinador = null, strEnlaceCuentaCobro=null, strRutaApp=null;
        UsuarioConsumoSIUDAO usuarioConsumoSIUDAO = new UsuarioConsumoSIUDAOImpl();
        UsuarioConsumoSIU usuarioConsumoSIU = null;
        UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
        UsuarioSesionSIU usuarioSIU = null;        
        ParametrosSIUDAO parametrosSIUDAO = new ParametrosSIUDAOImpl();
        
        this.strDestinatario = null;
        this.strAsunto = null;
        this.strMensaje = "";
                                                
        usuarioConsumoSIU = usuarioConsumoSIUDAO.obtenerUno(strUsuarioConsumo);
        
        if (usuarioConsumoSIU != null){
            strCoordinador = usuarioConsumoSIU.getCoordinador();
                                    
            if ((!strCoordinador.equals("")) && (!strCoordinador.equals("-"))){
                
                // Obtener el Coordinador del Grupo.
                usuarioSIU = usuarioSIUDAO.obtenerInfoUsuario(strCoordinador);
                               
                if (usuarioSIU != null){
                    
                    strRutaApp = parametrosSIUDAO.obtenerRutaAplicacion("SISFAUSIU");
                    strEnlaceCuentaCobro = strRutaApp + "consolidadoConsumos.jsp?keyCC=" + lgCodigoCuentaCobro.toString();
                    
                    this.strAsunto = "ALERTA: Generación de facturación de consumos de servicios SIU para el periodo " + strFechaInicial + " a " + strFechaFinal;
                    this.strDestinatario = usuarioSIU.getCorreoElectronicoInstitucional();
                    
                    this.strMensaje += "Cordial saludo Sr(a). " + usuarioSIU.getNombreCompleto() + "\n\n"; 
                    this.strMensaje += "La Administración de la SIU le informa que se ha generado una nueva facturación de los servicios utilizados por su grupo en el periodo " + strFechaInicial + " a " + strFechaFinal + ".\n\n";
                    this.strMensaje += "Para verificar el detalle de los servicios cobrados puede ingresar al siguiente enlace " + strEnlaceCuentaCobro + ".\n\n";
                    this.strMensaje += "Cualquier inquietud al respecto no dude en consultarnos.\n\n";
                    this.strMensaje += "Cordialmente,\n\n";
                    this.strMensaje += "Administración de la SIU";
                                        
                    this.parametroMail = new ParametroMail();
                    this.parametroMail.setDestinatario(this.strDestinatario);
                    this.parametroMail.setAsunto(this.strAsunto);
                    this.parametroMail.setMensaje(this.strMensaje);

                    sendMail(this.parametroMail);
                }
            }
        }                
    }                    

    @Override
    public void notificarFacturacionAuxiliaresProyectos(List<String> usuariosNotificados, String strFechaInicial, String strFechaFinal) throws GIDaoException {
        
        String strUsuariosNotificados="";
        RolXUsuarioDAO rolXusuarioDAO = null;
        List<RolXUsuario> auxiliaresProyectos = null;
        UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
        UsuarioSesionSIU usuarioSIU = null;        
        
        this.strDestinatario = null;
        this.strAsunto = null;
        this.strMensaje = "";
        
        rolXusuarioDAO = new RolXUsuarioDAOImpl();
        
        try{
            auxiliaresProyectos = rolXusuarioDAO.obtenerAuxiliaresProyectos();
        }catch(GIDaoException e){
            new GIDaoException("Se generó un error al obtener los Auxiliares de Proyectos para el envío de la notificación por facturación.", e);
        }

        if (auxiliaresProyectos != null){
            
            for(String usuarioNotificado : usuariosNotificados){
                strUsuariosNotificados += usuarioNotificado + ", ";
            }
            
            strUsuariosNotificados = strUsuariosNotificados.substring(0, strUsuariosNotificados.length()-2); 
            this.strAsunto = "ALERTA: Generación de facturación de consumos de servicios SIU para el periodo " + strFechaInicial + " a " + strFechaFinal;
            
            for (RolXUsuario auxiliarProyecto : auxiliaresProyectos){
                
                // Obtener datos del Auxiliar de Proyectos.
                usuarioSIU = usuarioSIUDAO.obtenerInfoUsuario(auxiliarProyecto.getPersona());
                this.strDestinatario = usuarioSIU.getCorreoElectronicoInstitucional();

                this.strMensaje += "Cordial saludo Sr(a). " + usuarioSIU.getNombreCompleto() + "\n\n"; 
                this.strMensaje += "La Administración de la SIU le informa que se ha generado una nueva facturación de los servicios prestados a los grupos en el periodo " + strFechaInicial + " a " + strFechaFinal + ".\n\n";
                this.strMensaje += "Los grupos notificados para este periodo fueron: " + strUsuariosNotificados + ".\n\n";               
                this.strMensaje += "Cordialmente,\n\n";
                this.strMensaje += "Administración de la SIU";
                
                this.parametroMail = new ParametroMail();
                this.parametroMail.setDestinatario(this.strDestinatario);
                this.parametroMail.setAsunto(this.strAsunto);
                this.parametroMail.setMensaje(this.strMensaje);

                sendMail(this.parametroMail);
                
                usuarioSIU = null;
                this.strDestinatario = null;
                this.strMensaje = "";
                this.parametroMail = null;
                auxiliarProyecto = null;
            }
        }                
    }

    @Override
    public void notificarFacturacionResponsablesServicios(List<String> usuariosNotificados, String strFechaInicial, String strFechaFinal) throws GIDaoException {
        String strUsuariosNotificados="";
        RolXUsuarioDAO rolXusuarioDAO = null;
        List<RolXUsuario> responsablesServicios = null;
        UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
        UsuarioSesionSIU usuarioSIU = null;        
        
        this.strDestinatario = null;
        this.strAsunto = null;
        this.strMensaje = "";
        
        rolXusuarioDAO = new RolXUsuarioDAOImpl();
        
        try{
            responsablesServicios = rolXusuarioDAO.obtenerResponsables();
        }catch(GIDaoException e){
            new GIDaoException("Se generó un error al obtener los Responsables de Servicios para el envío de la notificación por facturación.", e);
        }

        if (responsablesServicios != null){
            
            for(String usuarioNotificado : usuariosNotificados){
                strUsuariosNotificados += usuarioNotificado + ", ";
            }
            
            strUsuariosNotificados = strUsuariosNotificados.substring(0, strUsuariosNotificados.length()-2); 
            this.strAsunto = "ALERTA: Generación de facturación de consumos de servicios SIU para el periodo " + strFechaInicial + " a " + strFechaFinal;
            
            for (RolXUsuario responsableServicio : responsablesServicios){
                
                // Obtener datos del Responsable de Servicio.
                usuarioSIU = usuarioSIUDAO.obtenerInfoUsuario(responsableServicio.getPersona());
                this.strDestinatario = usuarioSIU.getCorreoElectronicoInstitucional();

                this.strMensaje += "Cordial saludo Sr(a). " + usuarioSIU.getNombreCompleto() + "\n\n"; 
                this.strMensaje += "La Administración de la SIU le informa que se ha generado una nueva facturación de los servicios prestados a los grupos en el periodo " + strFechaInicial + " a " + strFechaFinal + ".\n\n";
                this.strMensaje += "Los grupos notificados para este periodo fueron: " + strUsuariosNotificados + ".\n\n";               
                this.strMensaje += "Cordialmente,\n\n";
                this.strMensaje += "Administración de la SIU";
                
                this.parametroMail = new ParametroMail();
                this.parametroMail.setDestinatario(this.strDestinatario);
                this.parametroMail.setAsunto(this.strAsunto);
                this.parametroMail.setMensaje(this.strMensaje);

                sendMail(this.parametroMail);
                
                usuarioSIU = null;
                this.strDestinatario = null;
                this.strMensaje = "";
                this.parametroMail = null;
                responsableServicio = null;
            }
        }
    }

    @Override
    public void notificarResponsablesIngresoConsumos(String strFechaInicial, String strFechaFinal) throws GIDaoException {
        RolXUsuarioDAO rolXusuarioDAO = null;
        List<RolXUsuario> responsablesServicios = null;
        UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
        UsuarioSesionSIU usuarioSIU = null;        
        
        this.strDestinatario = null;
        this.strAsunto = null;
        this.strMensaje = "";
        
        rolXusuarioDAO = new RolXUsuarioDAOImpl();
        
        try{
            responsablesServicios = rolXusuarioDAO.obtenerResponsables();
        }catch(GIDaoException e){
            new GIDaoException("Se generó un error al obtener los Responsables de Servicios para el envío de la notificación de ingresos de consumos.", e);
        }

        if (responsablesServicios != null){
            this.strAsunto = "ALERTA: Ingreso de consumos de servicios SIU para el periodo " + strFechaInicial + " a " + strFechaFinal;
                                    
            for (RolXUsuario responsableServicio : responsablesServicios){
                
                // Obtener datos del Responsable de Servicio.
                usuarioSIU = usuarioSIUDAO.obtenerInfoUsuario(responsableServicio.getPersona());
                this.strDestinatario = usuarioSIU.getCorreoElectronicoInstitucional();
                           
                this.strMensaje += "Cordial saludo Sr(a). " + usuarioSIU.getNombreCompleto() + "\n\n"; 
                this.strMensaje += "La Administración de la SIU le recuerda el ingreso de los consumos de servicios correspondientes al periodo " + strFechaInicial + " a " + strFechaFinal + ".\n\n";
                this.strMensaje += "Recuerde que este proceso es importante para entregar la facturación completa y oportuna a cada uno de los usuarios.\n\n";
                this.strMensaje += "Cordialmente,\n\n";
                this.strMensaje += "Administración de la SIU";
                                          
                this.parametroMail = new ParametroMail();
                this.parametroMail.setDestinatario(this.strDestinatario);
                this.parametroMail.setAsunto(this.strAsunto);
                this.parametroMail.setMensaje(this.strMensaje);

                sendMail(this.parametroMail);
                
                usuarioSIU = null;
                this.strDestinatario = null;
                this.strMensaje = "";
                this.parametroMail = null;
                responsableServicio = null;
            }
        }
    }

    @Override
    public void notificarRevisionCuentaCobro(Long lgCodigoCuentaCobro, String strAcuerdoCobro) throws GIDaoException {
        String strIdUsuario=null, strIdTipoUsuario=null, strNomUsuario=null, strIdAuxiliarResponsable=null, strIdCoordinador=null, strNomCoordinador=null;
        
        CuentaCobroDAO cuentaCobroDAO = new CuentaCobroDAOImpl();
        CuentaCobro cuentaCobro = null;
        
        cuentaCobro = cuentaCobroDAO.obtenerUna(lgCodigoCuentaCobro);
        
        if (cuentaCobro != null){
        
            UsuarioConsumoSIUDAO usuarioConsumoSIUDAO =new UsuarioConsumoSIUDAOImpl();
            UsuarioConsumoSIU usuarioConsumoSIU = null;

            UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
            UsuarioSesionSIU usuarioSesionSIU =null;

            strIdUsuario = cuentaCobro.getUsuarioConsumo();
            strIdTipoUsuario = cuentaCobro.getTipoUsuarioConsumo();

            if (strIdTipoUsuario.equals("UI")){

                usuarioConsumoSIU = usuarioConsumoSIUDAO.obtenerUno(strIdUsuario);

                if (usuarioConsumoSIU != null){
                    strNomUsuario = usuarioConsumoSIU.getNombre();
                    strIdAuxiliarResponsable = usuarioConsumoSIU.getAuxiliarResponsable();
                    strIdCoordinador = usuarioConsumoSIU.getCoordinador();

                    usuarioSesionSIU = usuarioSIUDAO.obtenerInfoUsuario(strIdCoordinador);

                    if (usuarioSesionSIU != null){
                        strNomCoordinador = usuarioSesionSIU.getNombreCompleto();
                        usuarioSesionSIU = null;
                    }

                    usuarioSesionSIU = usuarioSIUDAO.obtenerInfoUsuario(strIdAuxiliarResponsable);

                    if (usuarioSesionSIU != null){
                        
                        this.strDestinatario = null;
                        this.strAsunto = null;
                        this.strMensaje = "";

                        this.strDestinatario = usuarioSesionSIU.getCorreoElectronicoInstitucional();
                        this.strMensaje += "Cordial saludo Sr(a). " + usuarioSesionSIU.getNombreCompleto() + ".\n\n";

                        if (strAcuerdoCobro.equals("S")){
                            this.strAsunto = "ALERTA: Aprobación de cuenta de cobro por parte del usuario " + strNomUsuario;

                            this.strMensaje += "Por medio de este mensaje se informa que el Coordinador del grupo " + strNomUsuario + ", " +strNomCoordinador +", ha aprobado la cuenta de cobro con código " + lgCodigoCuentaCobro + ".\n\n";
                            this.strMensaje += "Por lo tanto, puede proceder con la generación del respectivo documento de cobro.\n\n";
                        }else{
                            this.strAsunto = "ALERTA: Rechazo de cuenta de cobro por parte del usuario " + strNomUsuario;

                            this.strMensaje += "Por medio de este mensaje se informa que el Coordinador del grupo " + strNomUsuario + ", " +strNomCoordinador +", ha rechazado la cuenta de cobro con código " + lgCodigoCuentaCobro + ".\n\n";
                            this.strMensaje += "Por favor póngase en contacto con esta persona para revisar las causales del rechazo.\n\n";
                        }

                        this.strMensaje += "Atentamente,\n\n";
                        this.strMensaje += "Sistema de Facturación Unificada de Servicios\n";
                        this.strMensaje += "Administración de la SIU\n";

                        this.parametroMail = new ParametroMail();
                        this.parametroMail.setDestinatario(this.strDestinatario);
                        this.parametroMail.setAsunto(this.strAsunto);
                        this.parametroMail.setMensaje(this.strMensaje);

                        sendMail(this.parametroMail);
                        
                        this.strDestinatario = null;
                        this.strMensaje = "";
                        this.parametroMail = null;
                        usuarioSesionSIU = null;
                        usuarioConsumoSIU = null;
                        cuentaCobro = null;
                    }
                }               
            }                       
        }                               
    }
}
