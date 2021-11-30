/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.CuentaCobroDAO;
import co.edu.udea.facturacion.dao.impl.CuentaCobroDAOImpl;
import co.edu.udea.facturacion.dto.CuentaCobro;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.correa
 */
public class GuardarDatosSoporte extends HttpServlet {

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
            String strAccionError="", strNumeroSoporte=null, strFechaSoporte=null, strAccionGuardar="", strMsg=null;
            Date dtFechaSoporte=null;
            BigDecimal bdValorSoporte=null;
            CuentaCobro cuentaCobro = null; 
            Long lgCodigoCuentaCobro = Long.parseLong(request.getParameter("txtIdCuentaCobro"));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
            CuentaCobroDAO cuentaCobroDAO = new CuentaCobroDAOImpl();
            
            try{
                cuentaCobro = cuentaCobroDAO.obtenerUna(lgCodigoCuentaCobro);
            }catch(GIDaoException e){
                new GIDaoException("Se generó un error al recuperar la cuenta de cobro con código " + lgCodigoCuentaCobro, e);
                strAccionError = strAccionError + "<script type='text/javascript'>\n";
                strAccionError = strAccionError + "alert('Se generó un error al recuperar la cuenta de cobro.');\n";
                strAccionError = strAccionError + "location.href='cerrar.jsp';\n";
                strAccionError = strAccionError + "</script>\n";
            }
            
            if (cuentaCobro != null){
                      
                strAccionGuardar = strAccionGuardar + "<script type='text/javascript'>\n";
                strAccionGuardar = strAccionGuardar + "opener.frmRefresh.btnRefresh.click();\n";
                strAccionGuardar = strAccionGuardar + "location.href='notificacion.jsp';\n";
                strAccionGuardar = strAccionGuardar + "</script>\n"; 
                strMsg = "La información fue registrada correctamente en el sistema!.";
                
                strNumeroSoporte = request.getParameter("txtNumeroSoporte");
                strFechaSoporte = request.getParameter("txtFechaSoporte");
                bdValorSoporte = new BigDecimal(request.getParameter("txtValorSoporte"));
                
                try{
                    dtFechaSoporte = formato.parse(strFechaSoporte);
                }catch(ParseException pe){
                    new GIDaoException("Se generó un error parseando la fecha del soporte.", pe);
                }
                
                cuentaCobro.setNumeroSoporte(strNumeroSoporte);
                cuentaCobro.setFechaSoporte(dtFechaSoporte);
                cuentaCobro.setValorSoporte(bdValorSoporte);
                
                   try{
                    cuentaCobroDAO.actualizar(cuentaCobro);
                    request.getSession().setAttribute("mensaje", strMsg); 
                    out.println(strAccionGuardar);                                     
                    
                 }catch(GIDaoException e){
                    new GIDaoException("Se generó un error al actualizar la cuenta de cobro con código " + lgCodigoCuentaCobro, e);
                    strAccionError = strAccionError + "<script type='text/javascript'>\n";
                    strAccionError = strAccionError + "alert('Se generó un error al actualizar la cuenta de cobro.');\n";
                    strAccionError = strAccionError + "location.href='cerrar.jsp';\n";
                    strAccionError = strAccionError + "</script>\n";
                }                
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
