package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import java.util.Vector;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;

public final class administrativo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String strTipoUsuario = null, strEsDllo = "N", strUsuario = null;
    UsuarioSesionSIU usuarioSIU = null;      
        
    ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
    ParametroGeneral parametroGeneral = null;

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{        
        strTipoUsuario = (String) session.getAttribute("tipoUsuario");
        usuarioSIU = (UsuarioSesionSIU) session.getAttribute("Usuario");
        
        parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
        
        Vector arrRoles = new Vector();
        arrRoles = (Vector) session.getAttribute("rolesUsuario");
                     
        if (arrRoles.contains("DES")){
            strEsDllo = "S";
        }        
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"SHORTCUT ICON\" href=\"Images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/forms.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/menuh.css\" />        \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/visualizacion.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/ajax.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/comunes.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/menu.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/administrativo.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/visualizacion.js\"></script>\n");
      out.write("        <title>Menú administrativo</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("       </header>\n");
      out.write("       <nav>\n");
      out.write("            <div id='cssmenu'>\n");
      out.write("                <ul>\n");
      out.write("                   <li class='active has-sub'><a href='#'><span>Datos maestros</span></a>\n");
      out.write("                      <ul>\n");
      out.write("                        <li><a href='#' id=\"itUnidadesMedida\"><span>Unidades de medida</span></a></li>\n");
      out.write("                        <li><a href='#' id=\"itTiposUsuario\"><span>Tipos de usuario</span></a></li>\n");
      out.write("                        <li><a href='#' id=\"itTiposFacturacion\"><span>Tipos de facturación</span></a></li>                         \n");
      out.write("                        <li><a href='#' id=\"itItemsAdicionales\"><span>Ítem adicionales</span></a></li>                         \n");
      out.write("                        <li><a href='#' id=\"itInsumosServicios\"><span>Insumos de servicios</span></a></li>                         \n");
      out.write("                      </ul>\n");
      out.write("                   </li>\n");
      out.write("                   <li class='active has-sub'><a href='#'><span>Configuración de servicios</span></a>\n");
      out.write("                       <ul>\n");
      out.write("                         <li><a href='#' id=\"itSubservicios\"><span>Subservicios</span></a></li>\n");
      out.write("                         <li><a href='#' id=\"itServiciosXInsumos\"><span>Servicios por insumos</span></a></li>\n");
      out.write("                         <li><a href='#' id=\"itServiciosXTiposUsuario\"><span>Servicios por tipos de usuario</span></a></li>\n");
      out.write("                         <li><a href='#' id=\"itServiciosXUnidades\"><span>Servicios por unidades</span></a></li>\n");
      out.write("                      </ul>\n");
      out.write("                   </li>\n");
      out.write("                   ");
if (strEsDllo.equals("S")){
      out.write("\n");
      out.write("                        <li class='active has-sub'><a href='#'><span>Valores generales</span></a>\n");
      out.write("                            <ul>\n");
      out.write("                              <li><a href='#' id=\"itRolesUsuario\"><span>Roles de usuario</span></a></li>                 \n");
      out.write("                              <li><a href='#' id=\"itRolesXUsuarios\"><span>Roles por usuarios</span></a></li>       \n");
      out.write("                              ");
if (parametroGeneral == null){
      out.write("\n");
      out.write("                                <li><a href='#' id=\"itCrearParametrosGenerales\"><span>Crear parámetros generales</span></a></li>                 \n");
      out.write("                              ");
}else{
      out.write("\n");
      out.write("                                <li><a href='#' id=\"itVerParametrosGenerales\"><span>Ver parámetros generales</span></a></li>\n");
      out.write("                              ");
}
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                   ");
}
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <br />\n");
      out.write("            <form id=\"frmAcciones\" method=\"POST\" action=\"#\">                                    \n");
      out.write("                <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\"style=\"width: 99%;\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\" class=\"TEXTOACCION\">                                                                                                     \n");
      out.write("                        </td>\n");
      out.write("                        <td colspan=\"2\" class=\"BOTONESACCION\">                                      \n");
      out.write("                            <input type=\"button\" id=\"btnSalir\" name=\"btnSalir\" value=\"Salir\" class=\"BOTONFORM\" onclick=\"javascript:window.close()\" />                                    \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("          </form>\n");
      out.write("        </nav>\n");
      out.write("        <section>\n");
      out.write("           <article>   \n");
      out.write("               ");
if (usuarioSIU != null){
      out.write("\n");
      out.write("                    <div align=\"center\">\n");
      out.write("                        <br />       \n");
      out.write("                         <table cellspacing=\"0\" cellpadding=\"0\" width=\"98%\" border=\"0\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td style=\"width:100%;text-align: center;vertical-align: top;\">\n");
      out.write("                                    <div id=\"dMostrar\">                                                          \n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("           </article>\n");
      out.write("       </section>\n");
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
