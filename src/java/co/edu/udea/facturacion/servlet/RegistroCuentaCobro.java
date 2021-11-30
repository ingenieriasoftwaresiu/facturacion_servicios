/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.CuentaCobroDAO;
import co.edu.udea.facturacion.dao.FacturacionServiciosDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO;
import co.edu.udea.facturacion.dao.NotificacionMailDAO;
import co.edu.udea.facturacion.dao.impl.CuentaCobroDAOImpl;
import co.edu.udea.facturacion.dao.impl.FacturacionServiciosDAOImpl;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesConsumosDAOImpl;
import co.edu.udea.facturacion.dao.impl.NotificacionMailDAOImpl;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.correa
 */
public class RegistroCuentaCobro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String strAccionCrear = "", strMsgAccion=null;
            String strIdTipoUsuarioConsumo = request.getParameter("cbTipoUsuarioConsumo");
            String strIdUsuarioConsumo = request.getParameter("cbUsuarioConsumo");            
            String strIdUsuarioGenera = request.getParameter("txtIdUsuarioGenera");
            String strFechaIni = request.getParameter("txtFechaIni");
            String strFechaFin = request.getParameter("txtFechaFin");
            Long lgCodigoCuentaCobro = null;            
            Date dtFechaInicioPeriodo = null;
            Date dtFechaFinPeriodo = null;
            Integer intNroRegistros = null;
            List<String> UsuariosNotificados = new ArrayList<String>();
                                               
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            CuentaCobroDAO cuentaCobroDAO = new CuentaCobroDAOImpl();
            FacturacionServiciosDAO facturacionServiciosDAO = new FacturacionServiciosDAOImpl();
            NotificacionMailDAO notificacionMailDAO = null;
            notificacionMailDAO = new NotificacionMailDAOImpl();
            FuncionesComunesConsumosDAO funcionesComunesConsumosDAO = null;
            funcionesComunesConsumosDAO = new FuncionesComunesConsumosDAOImpl();
            
            strAccionCrear = strAccionCrear + "<script type='text/javascript'>\n";
            strAccionCrear = strAccionCrear + "opener.frmRefresh.btnRefresh.click();\n";
            strAccionCrear = strAccionCrear + "location.href='notificacion.jsp';\n";
            strAccionCrear = strAccionCrear + "</script>\n";
            
            try{
                dtFechaInicioPeriodo = sdf.parse(strFechaIni);
            }catch(ParseException pe){
                new GIDaoException("Se generó un error parseando la fecha de inicio del periodo de la cuenta de cobro.", pe);
            }
            
            try{
                dtFechaFinPeriodo = sdf.parse(strFechaFin);
            }catch(ParseException pe){
                new GIDaoException("Se generó un error parseando la fecha de inicio del periodo de la cuenta de cobro.", pe);
            }
                                    
            // Validar la existencia de la cuenta de cobro para el periodo seleccionado.
            
            try{
                intNroRegistros = cuentaCobroDAO.validacionInsercion(strIdTipoUsuarioConsumo, strIdUsuarioConsumo, dtFechaInicioPeriodo, dtFechaFinPeriodo);
            }catch(GIDaoException e){
                new GIDaoException("Se generó un error validando la existencia de la cuenta de cobro.", e);
            }

            if (intNroRegistros <= 0){
                try{
                    lgCodigoCuentaCobro = facturacionServiciosDAO.facturarConsumos(strIdTipoUsuarioConsumo, strIdUsuarioConsumo, strFechaIni, strFechaFin, strIdUsuarioGenera);
                                        
                    if (lgCodigoCuentaCobro == null){
                        out.println("<script type='text/javascript'>\n");
                        out.println("alert('La cuenta de cobro no será generada ya que el usuario no posee consumos para el periodo seleccionado.');");
                        out.println("history.back();");
                        out.println("</script>\n");
                        return;
                    }else{
                        
                        if ((lgCodigoCuentaCobro != null) && (lgCodigoCuentaCobro > 0)){                    
                                        
                            // Enviar notificación al usuario con enlace para revisión de consumos.

                            if (strIdTipoUsuarioConsumo.equals("UI")){

                                UsuariosNotificados.add(funcionesComunesConsumosDAO.obtenerUsuario(strIdUsuarioConsumo, strIdTipoUsuarioConsumo));

                               try{                            
                                    notificacionMailDAO.notificarFacturacionUsuarioSIU(strIdTipoUsuarioConsumo, strIdUsuarioConsumo, strFechaIni, strFechaFin, lgCodigoCuentaCobro);
                                }catch(GIDaoException e){
                                    new GIDaoException("Se generó un error al enviar la notificaciónde facturación al usuario " + strIdUsuarioConsumo, e);
                                }
                               
                               if (UsuariosNotificados.size() > 0){                                 
                                    // Notificar a los auxiliares de proyectos.

                                   try{
                                        notificacionMailDAO.notificarFacturacionAuxiliaresProyectos(UsuariosNotificados, strFechaIni, strFechaFin);
                                   }catch(GIDaoException e){
                                        new GIDaoException("Se generó un error enviando la notificación de facturación a los Auxiliares de Proyectos.", e);
                                   }

                                   // Notificar a los responsables de servicios.

                                   try{
                                        notificacionMailDAO.notificarFacturacionResponsablesServicios(UsuariosNotificados, strFechaIni, strFechaFin);
                                   }catch(GIDaoException e){
                                        new GIDaoException("Se generó un error enviando la notificación de facturación a los Responsables de Servicios.", e);
                                   }               
                                }                               
                            }                    
                            strMsgAccion = "La cuenta de cobro se generó correctamente con el consecutivo " + lgCodigoCuentaCobro + ".";
                        }else{
                            strMsgAccion = "La cuenta de cobro no se generó correctamente!.";
                        }                                                       
                    }
                                        
                    request.getSession().setAttribute("mensaje", strMsgAccion);      
                    out.println(strAccionCrear);
                    
                }catch(GIDaoException e){
                    new GIDaoException("Se generó un error facturando los consumos del usuario " + strIdUsuarioConsumo + " en el periodo " + strFechaIni + " a " + strFechaFin, e);
                }
            }else{
                out.println("<script type='text/javascript'>\n");
                out.println("alert('Ya existe una cuenta de cobro generada para el periodo seleccionado. Por favor seleccione un periodo diferente para continuar.');");
                out.println("history.back();");
                out.println("</script>\n");
                return;
            }
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
