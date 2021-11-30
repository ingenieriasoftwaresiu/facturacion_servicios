package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl;
import co.edu.udea.facturacion.dao.UsuarioSIUDAO;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import java.util.List;
import co.edu.udea.facturacion.dao.impl.RolXUsuarioDAOImpl;
import co.edu.udea.facturacion.dto.RolXUsuario;
import co.edu.udea.facturacion.dao.RolXUsuarioDAO;
import co.edu.udea.facturacion.dto.RolUsuario;
import co.edu.udea.facturacion.dao.impl.RolUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.RolUsuarioDAO;

public final class rolPorUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String strAccion = null;
    RolXUsuarioDAO rolXUsuarioDAO = new RolXUsuarioDAOImpl();
    RolXUsuario rolXUsuario = null;
    
    RolUsuarioDAO rolUsuarioDAO = new RolUsuarioDAOImpl();
    List<RolUsuario> rolesUsuario = null;
    
    rolesUsuario = rolUsuarioDAO.obtenerTodos();
    
    UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
    List<UsuarioSesionSIU> usuariosSIU = null;
    
    usuariosSIU = usuarioSIUDAO.obtenerTodos();
        
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
                     
        if (strAccion.equals("V")){
            String strRol = request.getParameter("keyCC");
            String strPersona = request.getParameter("keyCC2");
            rolXUsuario = rolXUsuarioDAO.obtenerUno(strPersona, strRol);
        }
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"SHORTCUT ICON\" href=\"Images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/forms.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/ajax.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/comunes.js\"></script>        \n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/validacionesAdministrativo.js\"></script>\n");
      out.write("        <title>Rol por usuario</title>\n");
      out.write("    </head>\n");
      out.write("    <body onLoad=\"setFocus('txtCodigo')\">\n");
      out.write("        <header>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("       </header>\n");
      out.write("       <section>\n");
      out.write("           <article>\n");
      out.write("               ");
if(strAccion != null){
      out.write("                   \n");
      out.write("                        <br />\n");
      out.write("                        <div align=\"center\">\n");
      out.write("                            <form id=\"frmRolXUsuario\" name=\"frmRolXUsuario\" method=\"POST\" action=\"RegistroAdministrativo\" onsubmit=\"return validarRolXUsuario()\">\n");
      out.write("                                <input type=\"hidden\" name=\"txtForm\" id=\"txtForm\" value=\"frmRolXUsuario\" />\n");
      out.write("                                <input type=\"hidden\" name=\"txtAccion\" id=\"txtAccion\" value=\"");
      out.print(strAccion);
      out.write("\" />\n");
      out.write("                                 ");
if(strAccion.equals("C")){
      out.write("\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">NUEVO REGISTRO DE ROL POR USUARIO</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Código:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbRol\" name=\"cbRol\" class=\"CAMPOSELECT\" style=\"width: 250px;\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(RolUsuario rolUsuario : rolesUsuario){
      out.write("\n");
      out.write("                                                    <option value=\"");
      out.print(rolUsuario.getCodigo());
      out.write('"');
      out.write('>');
      out.print(rolUsuario.getNombre());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>                                             \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgRol\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbUsuario\" name=\"cbUsuario\" class=\"CAMPOSELECT\" style=\"width: 250px;\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(UsuarioSesionSIU usuarioSIU : usuariosSIU){
      out.write("\n");
      out.write("                                                    <option value=\"");
      out.print(usuarioSIU.getIdentificacion());
      out.write('"');
      out.write('>');
      out.print(usuarioSIU.getNombreCompleto());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>                                             \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgUsuario\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>                                                    \n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"CELDABOTONFORM\">                             \n");
      out.write("                                                <input type=\"submit\" name=\"btnGuardar\" id=\"btnGuardar\" value=\"Guardar\" class=\"BOTONFORM\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                                <input type=\"reset\" name=\"btnLimpiar\" id=\"btnLimpiar\" value=\"Limpiar\" class=\"BOTONFORM\" onclick=\"setFocus('txtCodigo')\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                                <input type=\"button\" name=\"btnSalir\" id=\"btnSalir\" value=\"Salir\" class=\"BOTONFORM\" onclick=\"javascript:window.close();\" />                                   \n");
      out.write("                                           </td>\n");
      out.write("                                        </tr>                                                         \n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"MSGAVISOOBLG\">\n");
      out.write("                                                Los campos marcados con (*) son obligatorios.\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                ");
}else{
      out.write("\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">REGISTRO DE ROL DE USUARIO</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"LABELFORM\">* Código:</td>\n");
      out.write("                                            <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                <select id=\"cbRol\" name=\"cbRol\" class=\"CAMPOSELECTDISABLED\" style=\"width: 250px;\" disabled=\"disabled\">\n");
      out.write("                                                    <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                    ");
for(RolUsuario rolUsuario : rolesUsuario){
      out.write("\n");
      out.write("                                                       <option value=\"");
      out.print(rolUsuario.getCodigo());
      out.write('"');
      out.write('>');
      out.print(rolUsuario.getNombre());
      out.write("</option>\n");
      out.write("                                                    ");
}
      out.write("\n");
      out.write("                                                    <script type=\"text/javascript\">\n");
      out.write("                                                        $(\"#cbRol\").val(\"");
      out.print(rolXUsuario.getRol());
      out.write("\");\n");
      out.write("                                                    </script>                                                        \n");
      out.write("                                             </select>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                <img src=\"Images/error.png\" id=\"imgCodigo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                            </td>\n");
      out.write("                                            <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                            <td class=\"LABELFORM\">* Nombre:</td>\n");
      out.write("                                            <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                <select id=\"cbUsuario\" name=\"cbUsuario\" class=\"CAMPOSELECTDISABLED\" style=\"width: 250px;\" disabled=\"disabled\"> \n");
      out.write("                                                    <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                    ");
for(UsuarioSesionSIU usuarioSIU : usuariosSIU){
      out.write("\n");
      out.write("                                                       <option value=\"");
      out.print(usuarioSIU.getIdentificacion());
      out.write('"');
      out.write('>');
      out.print(usuarioSIU.getNombreCompleto());
      out.write("</option>\n");
      out.write("                                                    ");
}
      out.write("\n");
      out.write("                                                    <script type=\"text/javascript\">\n");
      out.write("                                                        $(\"#cbUsuario\").val(\"");
      out.print(rolXUsuario.getPersona());
      out.write("\");\n");
      out.write("                                                    </script>\n");
      out.write("                                             </select>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                <img src=\"Images/error.png\" id=\"imgNombre\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>                                                    \n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"CELDABOTONFORM\">                             \n");
      out.write("                                                <input type=\"button\" name=\"btnSalir\" id=\"btnSalir\" value=\"Salir\" class=\"BOTONFORM\" onclick=\"javascript:window.close();\" />                                   \n");
      out.write("                                           </td>\n");
      out.write("                                        </tr>                                                         \n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"MSGAVISOOBLG\">\n");
      out.write("                                                Los campos marcados con (*) son obligatorios.\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div>                                      \n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </article>\n");
      out.write("       </section>\n");
      out.write("        <br />\n");
      out.write("       <footer>\n");
      out.write("            <br />\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("                    \n");
      out.write("       </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
