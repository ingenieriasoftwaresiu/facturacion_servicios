/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.UsuarioConsumoSIUDAOImpl;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dto.UsuarioConsumoSIU;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George
 */
public class Acciones extends HttpServlet {

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
            String strAccion = request.getParameter("txtAccion");
            
            if (strAccion.equals("SUBSERVICIO")){
                String strIdServicio = request.getParameter("txtIdServicio");
                String strHTML = "";                        
                
                try{
                                  
                    SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                    
                    List<Subservicio> subservicios = subservicioDAO.obtenerPorServicio(strIdServicio);       
                    strHTML += "<select id='cbSubservicio' name='cbSubservicio' class='CAMPOSELECTB'>";
                    strHTML += "<option value='-1'>Seleccione una opción</option>";     
                    for(Subservicio subservicio : subservicios){
                        strHTML += "<option value='" + subservicio.getCodigo() + "'>" + subservicio.getNombre() + "</option>";
                    }
                    strHTML += "</select>";              
                    out.println(strHTML);
                    
                }catch(GIDaoException e){
                    String strMgsError = "No se recuperaron los subservicios del servicio " + strIdServicio;
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }                
            }
            
            if (strAccion.equals("SUBSERVICIO_MAESTRO")){
                String strIdServicio = request.getParameter("txtIdServicio");
                String strHTML = "";                        
                
                try{
                                  
                    SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                    
                    List<Subservicio> subservicios = subservicioDAO.obtenerPorServicio(strIdServicio);       
                    strHTML += "<select id='cbSubservicio' name='cbSubservicio' class='CAMPOSELECT' style='width: 350px;'>";
                    strHTML += "<option value='-1'>Seleccione una opción</option>";     
                    for(Subservicio subservicio : subservicios){
                        strHTML += "<option value='" + subservicio.getCodigo() + "'>" + subservicio.getNombre() + "</option>";
                    }
                    strHTML += "</select>";              
                    out.println(strHTML);
                    
                }catch(GIDaoException e){
                    String strMgsError = "No se recuperaron los subservicios del servicio " + strIdServicio;
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }                
            }
            
            if (strAccion.equals("USUARIO")){
                
                 String strIdTipoUsuario = request.getParameter("txtIdTipoUsuario");
                 UsuarioConsumoSIUDAO usuarioConsumoDAO = null;
                 List<UsuarioConsumoSIU> usuariosConsumos = null;
                 String strHTML = "";
                
                 if (strIdTipoUsuario.equals("UI")){
                    usuarioConsumoDAO = new UsuarioConsumoSIUDAOImpl();
                    
                    try{
                        usuariosConsumos = usuarioConsumoDAO.obtenerTodos();
                        strHTML += "<select id='cbUsuario' name='cbUsuario' class='CAMPOSELECTB' style='width: 80%;'>";
                        strHTML += "<option value='-1'>Seleccione una opción</option>";       
                        for(UsuarioConsumoSIU usuarioConsumo : usuariosConsumos){
                            strHTML += "<option value='" + usuarioConsumo.getCodigo() + "'>" + usuarioConsumo.getNombre() + "</option>";
                        }
                        strHTML += "</select>";              
                    out.println(strHTML);
                    }catch(GIDaoException e){                        
                        String strMgsError = "Se generó un error al obtener los usuarios internos de consumos.";
                        new GIDaoException(strMgsError,e);
                        out.println("<div class='TEXTOFALLO'>");
                        out.println(strMgsError);
                        out.println("</div>");
                    }
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
