package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import co.edu.udea.facturacion.dao.impl.RolXUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.RolXUsuarioDAO;
import co.edu.udea.facturacion.dto.RolXUsuario;
import java.util.List;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import co.edu.udea.facturacion.dao.UsuarioSIUDAO;

public final class principal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "comprobarSesion.jsp", out, false);
      out.write('\n');

    String strPreload = null, strTipoUsuario = null, strEsAdmin = "N", strEsDllo = "N", strEsResp = "N", strEsUsuario = "N", strUsuario = null, strEsAuxProy="N";
    UsuarioSesionSIU usuarioSIU = null;       

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{        
        
        strPreload = (String) session.getAttribute("preload");
        strTipoUsuario = (String) session.getAttribute("tipoUsuario");
        usuarioSIU = (UsuarioSesionSIU) session.getAttribute("Usuario");
        
        Vector arrRoles = new Vector();
        List<RolXUsuario> rolesXusuario = null;
        RolXUsuarioDAO rolXusuario = new RolXUsuarioDAOImpl();
        strUsuario = usuarioSIU.getIdentificacion();
        rolesXusuario = rolesXusuario = rolXusuario.obtenerPorPersona(strUsuario);
        
        if (rolesXusuario != null){
            for(RolXUsuario rolUsuario : rolesXusuario){
                if (rolUsuario.getRol().equals("ADM")){
                    strEsAdmin = "S";            
                    arrRoles.add("ADM");
                }

                if (rolUsuario.getRol().equals("DES")){
                    strEsDllo = "S";
                    arrRoles.add("DES");
                }

                if (rolUsuario.getRol().equals("RESP")){
                    strEsResp = "S";
                    arrRoles.add("RESP");
                }
                
                if (rolUsuario.getRol().equals("AUXPROY")){
                    strEsAuxProy = "S";
                    arrRoles.add("AUXPROY");
                }                
            }
        }else{        
            if ((strEsAdmin.equals("N")) && (strEsDllo.equals("N")) && (strEsResp.equals("N")) && (strEsAuxProy.equals("N"))){
                strEsUsuario = "S";        
                arrRoles.add("USU");
            }     
        }
        
        session.setAttribute("rolesUsuario", arrRoles);
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"SHORTCUT ICON\" href=\"Images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/menuh.css\" />        \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/visualizacion.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/calendar-system.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar-es.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar-setup.js\"></script> \n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/ajax.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/comunes.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/principal.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/visualizacion.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/menu.js\"></script>\n");
      out.write("        <title>Menú principal</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <header>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("       </header>\n");
      out.write("       <nav>\n");
      out.write("            <div id='cssmenu'>\n");
      out.write("                <ul>\n");
      out.write("                   <li class='active has-sub'><a href='#'><span>Consumos de servicios</span></a>\n");
      out.write("                      <ul>\n");
      out.write("                         <li><a href='#' id=\"itVerConsumosInsumos\"><span>Ver consumos por insumos</span></a></li>\n");
      out.write("                         <li><a href='#' id=\"itVerConsumosTiposUsuario\"><span>Ver consumos por tipos de usuario</span></a></li>\n");
      out.write("                         <li><a href='#' id=\"itVerConsumosUnidades\"><span>Ver consumos por unidades</span></a></li>\n");
      out.write("                         ");
if ((strEsAdmin.equals("S")) || (strEsDllo.equals("S")) || (strEsResp.equals("S"))){
      out.write("\n");
      out.write("                            <li><a href='#' id=\"itRegistrarConsumo\"><span>Registrar nuevo consumo</span></a></li>\n");
      out.write("                         ");
}
      out.write("\n");
      out.write("                      </ul>\n");
      out.write("                   </li>\n");
      out.write("                   <li class='active has-sub'><a href='#'><span>Cuentas de cobro</span></a>\n");
      out.write("                       <ul>\n");
      out.write("                         <li><a href='#' id=\"itVerCuentasCobro\"><span>Ver cuentas de cobro</span></a></li>\n");
      out.write("                         ");
if ((strEsAdmin.equals("S")) || (strEsDllo.equals("S")) || (strEsResp.equals("S"))){
      out.write("\n");
      out.write("                            <li><a href='#' id=\"itGenerarCuentaCobro\"><span>Generar nueva cuenta de cobro</span></a></li>     \n");
      out.write("                         ");
}
      out.write("\n");
      out.write("                      </ul>\n");
      out.write("                   </li>\n");
      out.write("                   ");
if ((strEsAdmin.equals("S")) || (strEsDllo.equals("S")) || (strEsResp.equals("S"))){
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href='#' id=\"itMenuInformes\"><span>Informes</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href='#' id=\"itMenuIndicadores\"><span>Indicadores</span></a>\n");
      out.write("                        </li>\n");
      out.write("                   ");
}
      out.write("\n");
      out.write("                   ");
if((strEsAdmin.equals("S")) || (strEsDllo.equals("S"))){
      out.write(" \n");
      out.write("                        <li>\n");
      out.write("                            <a href='#' id=\"itMenuAdministrativo\"><span>Administración</span></a>\n");
      out.write("                        </li>\n");
      out.write("                   ");
}
      out.write(" \n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("       <section>\n");
      out.write("           <article>   \n");
      out.write("               ");
if (usuarioSIU != null){
      out.write("\n");
      out.write("                <div align=\"center\">\n");
      out.write("                    <br />\n");
      out.write("                    <table cellspacing=\"0\" cellpadding=\"0\" width=\"98%\" border=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                             ");
 if(usuarioSIU != null){ 
      out.write("                             \n");
      out.write("                                 <td class=\"USERLOGED\" style=\"text-align: left;\"><b>Bienvenido(a),</b>&nbsp;<span style=\"font-weight: normal;\">");
      out.print(usuarioSIU.getNombreCompleto());
      out.write("</span></td>\n");
      out.write("                             ");
}else{
      out.write("\n");
      out.write("                                 <td class=\"USERLOGED\" style=\"text-align: left;\"><b>Bienvenido(a)!</b></td> \n");
      out.write("                             ");
}
      out.write("\n");
      out.write("                             ");
if (strPreload.equals("N")){
      out.write("     \n");
      out.write("                                 <td class=\"CELDAACCION\" style=\"border-left: 1px solid #116043;width: 120px;text-align: right;vertical-align: middle;\"><input type=\"button\" value=\"Salir\" class=\"BOTONACCION\" onclick=\"location.href='cerrar.jsp';\" /></td>\n");
      out.write("                             ");
}else{
      out.write("\n");
      out.write("                                 <td class=\"CELDAACCION\" style=\"border-left: 1px solid #116043;width: 120px;text-align: right;vertical-align: middle;\"><input type=\"button\" value=\"Salir\" class=\"BOTONACCION\" onclick=\"javascript:window.close();\" /></td>\n");
      out.write("                             ");
}
      out.write("                                            \n");
      out.write("                         </tr>               \n");
      out.write("                    </table>\n");
      out.write("                     <br />\n");
      out.write("                     <table cellspacing=\"0\" cellpadding=\"0\" width=\"98%\" border=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width:990px;text-align: center;vertical-align: top;\">\n");
      out.write("                                <div id=\"dMostrar\">                            \n");
      out.write("                                </div>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            ");
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
