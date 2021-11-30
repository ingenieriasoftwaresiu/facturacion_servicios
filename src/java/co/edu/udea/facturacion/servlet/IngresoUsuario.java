/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.RolXUsuarioDAO;
import co.edu.udea.facturacion.dao.UsuarioSIUDAO;
import co.edu.udea.facturacion.dao.impl.RolXUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl;
import co.edu.udea.facturacion.dto.RolXUsuario;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class IngresoUsuario extends HttpServlet {

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
           String strUsuario = request.getParameter("txtUsuario");
           String strPwd = request.getParameter("txtPwd");
           String strTipoUsuario = request.getParameter("txtTipoUsuario");              
           
           RolXUsuarioDAO rolXusuario = new RolXUsuarioDAOImpl();
           RolXUsuario rolUsuario = null;
           
           UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
           UsuarioSesionSIU usuarioSIU = null;
                  
           if(request.getParameter("preload") == null){
               if ((strTipoUsuario.equals("ADM")) || (strTipoUsuario.equals("DES")) || (strTipoUsuario.equals("RESP")) || (strTipoUsuario.equals("AUXPROY")) || (strTipoUsuario.equals("USUSIU"))){                                                        
                   
                   try{
                        usuarioSIU = usuarioSIUDAO.validarCredencialesAcceso(strUsuario, strPwd);
                        
                        if (usuarioSIU == null){
                            out.println("<html>");
                            out.println("<head>");              
                            out.println("</head>");
                            out.println("<body>");
                            out.println("El usuario y/o la contraseña ingresado(s) es(son) incorrecto(s).");
                            out.println("</body>");
                            out.println("</html>");
                        }else{
                            
                            if (usuarioSIU.getEstadoActual().equals("I")){
                                 out.println("<html>");
                                out.println("<head>");              
                                out.println("</head>");
                                out.println("<body>");
                                out.println("Su usuario se encuentra inactivo en el sistema, por lo tanto no podrá ingresar.");
                                out.println("</body>");
                                out.println("</html>");
                            }else{
                                String strId = usuarioSIU.getIdentificacion();           
                                rolUsuario = rolXusuario.obtenerUno(strId, strTipoUsuario);

                                if (rolUsuario == null){
                                   out.println("<html>");
                                   out.println("<head>");              
                                   out.println("</head>");
                                   out.println("<body>");
                                   out.println("No cuenta con el nivel de acceso seleccionado para ingresar al sistema. Por favor contacte al Administrador.");
                                   out.println("</body>");
                                   out.println("</html>");
                                }else{
                                 
                                    HttpSession session = request.getSession(true);                                 
                                    out.println("txtCedula="+strId);                           
                                    session.setAttribute("Usuario", usuarioSIU);                          
                                    session.setAttribute("tipoUsuario",strTipoUsuario);
                                    session.setAttribute("preload", "N");
                                }                            
                            }
                        }
                        
                   }catch(GIDaoException e){                
                       new GIDaoException("La credenciales de acceso no son válidas.",e);
                   }
               }
               
               if (strTipoUsuario.equals("USUUNS")){                   
                   // Implementación para autenticación de usuarios UdeA no SIU.
               }
               
               if (strTipoUsuario.equals("USUEX")){                   
                   // Implementación para autenticación de usuarios Externos.
               }
               
           }else{
               try{
                    usuarioSIU = usuarioSIUDAO.obtenerInfoUsuario(strUsuario);                   
                    HttpSession session = request.getSession(true);                                 
                    out.println("txtCedula="+strUsuario);             
                    session.setAttribute("Usuario", usuarioSIU);         
                    session.setAttribute("tipoUsuario", strTipoUsuario);
                    session.setAttribute("preload", "S");
                }catch(GIDaoException e){                
                    new GIDaoException("No se pudieron recuperar los roles del usuario.",e);
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
