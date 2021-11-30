/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.CuentaCobroDAO;
import co.edu.udea.facturacion.dao.NotificacionMailDAO;
import co.edu.udea.facturacion.dao.impl.CuentaCobroDAOImpl;
import co.edu.udea.facturacion.dao.impl.NotificacionMailDAOImpl;
import co.edu.udea.facturacion.dto.CuentaCobro;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.correa
 */
public class GuardarDatosFacturacion extends HttpServlet {

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
          
            String strAccionGuardar= "", strAccionError= "", strDependenciaB=null, strCentroCostosB=null, strDependenciaP=null, strCentroCostosP=null, strNombreOrdenadorG=null, strCargoOrdenadorG=null;
            String strObservacion = "";
            CuentaCobro cuentaCobro = null;            
            
            Long lgCodigoCuentaCobro = Long.parseLong(request.getParameter("txtIdCuentaCobro"));
            String strAcuerdo = request.getParameter("rdAcuerdo");
            
            CuentaCobroDAO cuentaCobroDAO = new CuentaCobroDAOImpl();
            NotificacionMailDAO notificacion = new NotificacionMailDAOImpl();
            
            try{
                cuentaCobro = cuentaCobroDAO.obtenerUna(lgCodigoCuentaCobro);
            }catch(GIDaoException e){
                new GIDaoException("Se generó un error al recuperar la cuenta de cobro con código " + lgCodigoCuentaCobro, e);
                strAccionError = strAccionError + "<script type='text/javascript'>\n";
                strAccionError = strAccionError + "alert('Se generó un error al recuperar la cuenta de cobro.');\n";
                strAccionError = strAccionError + "location.href='cerrar.jsp';\n";
                strAccionError = strAccionError + "</script>\n";
            }
            
            if (strAcuerdo.equals("S")){
                strAccionGuardar = strAccionGuardar + "<script type='text/javascript'>\n";
                strAccionGuardar = strAccionGuardar + "alert('La información fue registrada correctamente en el sistema!');\n";
                strAccionGuardar = strAccionGuardar + "location.href='cerrar.jsp';\n";
                strAccionGuardar = strAccionGuardar + "</script>\n";
                
                strDependenciaB = request.getParameter("txtDependenciaB");
                strCentroCostosB = request.getParameter("txtCentroCostosB");
                strDependenciaP = request.getParameter("txtDependenciaP");
                strCentroCostosP = request.getParameter("txtCentroCostosP");
                strNombreOrdenadorG = request.getParameter("txtOrdenadorGasto");
                strCargoOrdenadorG = request.getParameter("txtCargoOrdenadorGasto");
                strObservacion = request.getParameter("txtObservacion");
                
                strDependenciaB= new String(strDependenciaB.getBytes("iso-8859-1"),"UTF-8");   
                strCentroCostosB= new String(strCentroCostosB.getBytes("iso-8859-1"),"UTF-8");   
                strDependenciaP= new String(strDependenciaP.getBytes("iso-8859-1"),"UTF-8");   
                strCentroCostosP= new String(strCentroCostosP.getBytes("iso-8859-1"),"UTF-8");   
                strNombreOrdenadorG= new String(strNombreOrdenadorG.getBytes("iso-8859-1"),"UTF-8");   
                strCargoOrdenadorG= new String(strCargoOrdenadorG.getBytes("iso-8859-1"),"UTF-8");   
                
                if (strObservacion.equals("")){
                    strObservacion = "-";
                }else{
                    strObservacion= new String(strObservacion.getBytes("iso-8859-1"),"UTF-8");   
                }
                
            }else{
                strAccionGuardar = strAccionGuardar + "<script type='text/javascript'>\n";
                strAccionGuardar = strAccionGuardar + "alert('La información fue registrada correctamente en el sistema!. Para resolver cualquier inquietud respecto al cobro, por favor póngase el contacto con la Administración de la SIU (Ext: 6402).');\n";
                strAccionGuardar = strAccionGuardar + "location.href='cerrar.jsp';\n";
                strAccionGuardar = strAccionGuardar + "</script>\n";               
                
                strDependenciaB = "-";
                strCentroCostosB = "-";
                strDependenciaP = "-";
                strCentroCostosP = "-";
                strNombreOrdenadorG = "-";
                strCargoOrdenadorG = "-";
                strObservacion = "-";
            }
            
            if (cuentaCobro != null){
                cuentaCobro.setAcuerdoCobro(strAcuerdo);
                cuentaCobro.setDependenciaBeneficiaria(strDependenciaB);
                cuentaCobro.setCentroCostosBeneficiario(strCentroCostosB);
                cuentaCobro.setDependenciaPagadora(strDependenciaP);
                cuentaCobro.setCentroCostosPagador(strCentroCostosP);
                cuentaCobro.setNombreOrdenadorGasto(strNombreOrdenadorG);
                cuentaCobro.setCargoOrdenadorGasto(strCargoOrdenadorG);
                cuentaCobro.setObservacion(strObservacion);
                
                try{
                    cuentaCobroDAO.actualizar(cuentaCobro);
                    out.println(strAccionGuardar);
                    
                    notificacion.notificarRevisionCuentaCobro(lgCodigoCuentaCobro, strAcuerdo);
                    
                 }catch(GIDaoException e){
                    new GIDaoException("Se generó un error al actualizar la cuenta de cobro con código " + lgCodigoCuentaCobro, e);
                    strAccionError = strAccionError + "<script type='text/javascript'>\n";
                    strAccionError = strAccionError + "alert('Se generó un error al actualizar la cuenta de cobro.');\n";
                    strAccionError = strAccionError + "location.href='cerrar.jsp';\n";
                    strAccionError = strAccionError + "</script>\n";
                }
            }
            
            if (!(strAccionError.equals(""))){
                out.println(strAccionError);
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
