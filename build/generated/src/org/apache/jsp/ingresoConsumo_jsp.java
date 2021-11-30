package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.edu.udea.facturacion.dto.Dependencia;
import co.edu.udea.facturacion.dao.impl.DependenciaDAOImpl;
import co.edu.udea.facturacion.dao.DependenciaDAO;
import co.edu.udea.facturacion.dao.impl.ServicioDAOImpl;
import co.edu.udea.facturacion.dto.Servicio;
import co.edu.udea.facturacion.dao.ServicioDAO;
import co.edu.udea.facturacion.dao.impl.UsuarioConsumoSIUDAOImpl;
import co.edu.udea.facturacion.dto.UsuarioConsumoSIU;
import co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO;
import co.edu.udea.facturacion.dto.TipoUsuarioConsumo;
import co.edu.udea.facturacion.dao.impl.TipoUsuarioConsumoDAOImpl;
import java.util.List;
import co.edu.udea.facturacion.dao.impl.TipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.TipoUsuarioConsumoDAO;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl;
import co.edu.udea.facturacion.dao.FuncionesComunesDAO;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;

public final class ingresoConsumo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "comprobarSesion.jsp", out, false);
      out.write('\n');

     UsuarioSesionSIU usuarioSIU = null;       
     FuncionesComunesDAO funcionesComunesDAO = null;
     List<TipoUsuarioConsumo> tiposUsuariosConsumo = null;
     TipoUsuarioConsumoDAO tipoUsuarioConsumoDAO = null;
     UsuarioConsumoSIUDAO usuarioConsumoDAO = null;
     List<UsuarioConsumoSIU> usuariosConsumos = null;
     ServicioDAO servicioDAO = null;
     List<Servicio> servicios = null;
     String strAccion = null;

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{  
        usuarioSIU = (UsuarioSesionSIU) session.getAttribute("Usuario");
        funcionesComunesDAO = new FuncionesComunesDAOImpl();
        strAccion = request.getParameter("txtAccion");        
        
        tipoUsuarioConsumoDAO = new TipoUsuarioConsumoDAOImpl();
        tiposUsuariosConsumo = tipoUsuarioConsumoDAO.obtenerTodos();
        
        usuarioConsumoDAO = new UsuarioConsumoSIUDAOImpl();
        usuariosConsumos = usuarioConsumoDAO.obtenerTodos();
        
        servicioDAO = new ServicioDAOImpl();
        servicios = servicioDAO.obtenerTodos();
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"SHORTCUT ICON\" href=\"Images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/forms.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/ingreso-consumos.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/calendar-system.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar-es.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar-setup.js\"></script> \n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/ajax.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/comunes.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/ingresoConsumo.js\"></script>\n");
      out.write("        <title>Ingreso de consumos de servicios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <header>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("       </header>\n");
      out.write("       <section>\n");
      out.write("           <article>\n");
      out.write("               ");
if(strAccion != null){
      out.write("\n");
      out.write("                    ");
if(strAccion.equals("C")){
      out.write("\n");
      out.write("                         <br />\n");
      out.write("                         <div align=\"center\">\n");
      out.write("                             <form id=\"frmIngresoConsumo\" name=\"frmIngresoConsumo\" method=\"POST\" action=\"RegistroConsumos\" onsubmit=\"return validarConsumos()\">\n");
      out.write("                                 <input type=\"hidden\" id=\"txtIdUsuarioRegistra\" name=\"txtIdUsuarioRegistra\" value=\"");
      out.print(usuarioSIU.getIdentificacion());
      out.write("\" />\n");
      out.write("                                 <input type=\"hidden\" id=\"txtAccion\" name=\"txtAccion\" value=\"");
      out.print(strAccion);
      out.write("\" />\n");
      out.write("                                 <input type=\"hidden\" id=\"txtCamposDiligenciados\" name=\"txtCamposDiligenciados\" />\n");
      out.write("                                 <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                      <tr>\n");
      out.write("                                          <td colspan=\"7\" class=\"TITULOFORM\">INGRESO DE CONSUMOS DE SERVICIOS</td>\n");
      out.write("                                      </tr>                            \n");
      out.write("                                      <tr>\n");
      out.write("                                          <td class=\"LABELFORM\">Fecha de registro (aaaa-mm-dd):</td>\n");
      out.write("                                          <td class=\"CELDACAMPOFORM\"><input type=\"text\" id=\"txtFechaRegistro\" name=\"txtFechaRegistro\" value=\"");
      out.print(funcionesComunesDAO.getFechaActual());
      out.write("\" class=\"CAMPOFORMREAD\" readonly=\"true\"/></td>\n");
      out.write("                                          <td class=\"CELDAIMGERROR\"><img src=\"Images/error.png\" id=\"imgFechaRegistro\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\"></td>\n");
      out.write("                                          <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                          <td class=\"LABELFORM\">Usuario que registra:</td>\n");
      out.write("                                          <td class=\"CELDACAMPOFORM\"><input type=\"text\" id=\"txtUsuarioRegistra\" name=\"txtUsuarioRegistra\" value=\"");
      out.print(usuarioSIU.getUsuario());
      out.write("\" class=\"CAMPOFORMREAD\" readonly=\"true\"/></td>\n");
      out.write("                                          <td class=\"CELDAIMGERROR\"><img src=\"Images/error.png\" id=\"imgUsuarioRegistra\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\"></td>\n");
      out.write("                                      </tr>\n");
      out.write("                                      <tr><td colspan=\"7\" class=\"BORDEINFERIOR\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                      <tr>\n");
      out.write("                                          <td class=\"LABELFORM\">* Tipo de usuario del consumo:</td>\n");
      out.write("                                          <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                              <select id=\"cbTipoUsuarioConsumo\" name=\"cbTipoUsuarioConsumo\" class=\"CAMPOSELECT\">\n");
      out.write("                                                  <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                  ");

                                                     if (tiposUsuariosConsumo != null){
                                                         for(TipoUsuarioConsumo tipoUsuarioConsumo : tiposUsuariosConsumo){
      out.write("\n");
      out.write("                                                             <option value=\"");
      out.print(tipoUsuarioConsumo.getCodigo());
      out.write('"');
      out.write('>');
      out.print(tipoUsuarioConsumo.getNombre());
      out.write("</option>\n");
      out.write("                                                  ");
     }
                                                     }
      out.write("  \n");
      out.write("                                              </select>\n");
      out.write("                                          </td>\n");
      out.write("                                          <td class=\"CELDAIMGERROR\"><img src=\"Images/error.png\" id=\"imgTipoUsuarioConsumo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\"></td>\n");
      out.write("                                          <td class=\"ESPACIOBLANCO\"></td>     \n");
      out.write("                                          <td colspan=\"3\">\n");
      out.write("                                              <div id=\"dUsuarioInterno\">\n");
      out.write("                                                  <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
      out.write("                                                      <tr>\n");
      out.write("                                                         <td class=\"LABELFORM\" style=\"width: 160px;\">* Nombre del usuario consumidor:</td>\n");
      out.write("                                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                             <select id=\"cbUsuarioConsumo\" name=\"cbUsuarioConsumo\" class=\"CAMPOSELECT\">\n");
      out.write("                                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                                 ");

                                                                     if (usuariosConsumos != null){
                                                                         for(UsuarioConsumoSIU usuarioConsumo : usuariosConsumos){
      out.write("\n");
      out.write("                                                                             <option value=\"");
      out.print(usuarioConsumo.getCodigo());
      out.write('"');
      out.write('>');
      out.print(usuarioConsumo.getNombre());
      out.write("</option>\n");
      out.write("                                                                  ");
     }
                                                                     }
      out.write("\n");
      out.write("                                                             </select>\n");
      out.write("                                                         </td>\n");
      out.write("                                                         <td class=\"CELDAIMGERROR\"><img src=\"Images/error.png\" id=\"imgUsuarioConsumoI\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\"></td>\n");
      out.write("                                                      </tr>\n");
      out.write("                                                  </table>\n");
      out.write("                                              </div>\n");
      out.write("                                              <div id=\"dUsuarioUdeANoSIU\">                                                  \n");
      out.write("                                                  <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
      out.write("                                                      <tr>\n");
      out.write("                                                         <td class=\"LABELFORM\" style=\"width: 160px;\">* Nombre del usuario consumidor:</td>\n");
      out.write("                                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                             <input type=\"hidden\" id=\"txtIdDependencia\" name=\"txtIdDependencia\" />\n");
      out.write("                                                             <input type=\"text\" id=\"txtNombreDependencia\" name=\"txtNombreDependencia\" class=\"CAMPOFORMREAD\" readOnly />&nbsp;\n");
      out.write("                                                             <input type=\"button\" id=\"btnBuscarDependencia\" name=\"btnBuscarDependencia\" value=\"Seleccionar\" class=\"BOTONFORM\" onClick=\"buscarDependencia();\" />\n");
      out.write("                                                         </td>\n");
      out.write("                                                         <td class=\"CELDAIMGERROR\"><img src=\"Images/error.png\" id=\"imgUsuarioConsumoUNS\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\"></td>\n");
      out.write("                                                      </tr>\n");
      out.write("                                                  </table>\n");
      out.write("                                              </div>\n");
      out.write("                                              <div id=\"dUsuarioExterno\">\n");
      out.write("                                                  <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
      out.write("                                                      <tr>\n");
      out.write("                                                         <td class=\"LABELFORM\" style=\"width: 160px;\">* Nombre del usuario consumidor:</td>\n");
      out.write("                                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                             <input type=\"hidden\" id=\"txtIdExterno\" name=\"txtIdExterno\" />\n");
      out.write("                                                             <input type=\"text\" id=\"txtNombreExterno\" name=\"txtNombreExterno\" class=\"CAMPOFORMREAD\" readOnly />&nbsp;\n");
      out.write("                                                             <input type=\"button\" id=\"btnBuscarExterno\" name=\"btnBuscarExterno\" value=\"Buscar\" class=\"BOTONFORM\" onClick=\"buscarExterno();\" />\n");
      out.write("                                                         </td>\n");
      out.write("                                                         <td class=\"CELDAIMGERROR\"><img src=\"Images/error.png\" id=\"imgUsuarioConsumoE\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\"></td>\n");
      out.write("                                                      </tr>\n");
      out.write("                                                  </table>\n");
      out.write("                                              </div>\n");
      out.write("                                          </td>                                     \n");
      out.write("                                      </tr>\n");
      out.write("                                      <tr><td colspan=\"7\" style=\"height: 5px;\"></td></tr>\n");
      out.write("                                      <tr>\n");
      out.write("                                          <td class=\"LABELFORM\">* Nombre del servicio consumido:</td>\n");
      out.write("                                          <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                              <select id=\"cbServicioConsumido\" name=\"cbServicioConsumido\" class=\"CAMPOSELECT\" style=\"width: 310px;\">\n");
      out.write("                                                  <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                  ");

                                                     if (servicios != null){
                                                         for(Servicio servicio : servicios){
      out.write("\n");
      out.write("                                                             <option value=\"");
      out.print(servicio.getCodigo());
      out.write('"');
      out.write('>');
      out.print(servicio.getNombre());
      out.write("</option>\n");
      out.write("                                                  ");
     }
                                                     }
      out.write("  \n");
      out.write("                                              </select>\n");
      out.write("                                          </td>\n");
      out.write("                                          <td class=\"CELDAIMGERROR\"><img src=\"Images/error.png\" id=\"imgServicioConsumido\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\"></td>\n");
      out.write("                                          <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                          <td colspan=\"3\">\n");
      out.write("                                              <div id=\"dSubservicio\">                                             \n");
      out.write("                                              </div>\n");
      out.write("                                          </td>                                     \n");
      out.write("                                      </tr>\n");
      out.write("                                      <tr>\n");
      out.write("                                          <td class='LABELFORM'>* Fecha de inicio del consumo:<br/>&nbsp;&nbsp;(aaaa-mm-dd)</td>\n");
      out.write("                                          <td class='CELDACAMPOFORM'>\n");
      out.write("                                              <input type='text' name='txtFechaIni' id='txtFechaIni' class='CAMPOFORM' readOnly>&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaIni'>\n");
      out.write("                                          </td>\n");
      out.write("                                          <td class='CELDAIMGERROR'><img src='Images/error.png' id='imgFechaInicial' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>\n");
      out.write("                                          <td class='ESPACIOBLANCO'></td>\n");
      out.write("                                          <td class='LABELFORM'><label id='lblFechaFin'>* Fecha de fin del consumo:<br/>&nbsp;&nbsp;(aaaa-mm-dd)</label></td>\n");
      out.write("                                          <td class='CELDACAMPOFORM'>\n");
      out.write("                                              <input type='text' name='txtFechaFin' id='txtFechaFin' class='CAMPOFORM' readOnly>&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaFin'>                                                                                                \n");
      out.write("                                          </td>\n");
      out.write("                                          <td class='CELDAIMGERROR'><img src='Images/error.png' id='imgFechaFinal' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>                                                                                    \n");
      out.write("                                      </tr>                                      \n");
      out.write("                                      <tr><td colspan=\"7\" style=\"height: 5px;\"></td></tr>\n");
      out.write("                                      <tr>\n");
      out.write("                                          <td colspan=\"7\" class=\"CELDABOTONFORM\">\n");
      out.write("                                              <div id=\"dBotonesInicio\">\n");
      out.write("                                                 <input type=\"button\" name=\"btnIngresarConsumos\" id=\"btnIngresarConsumos\" value=\"Ingresar consumos\" class=\"BOTONFORM\" style=\"width: 110px;\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                                 <input type=\"button\" name=\"btnLimpiar\" id=\"btnLimpiar\" value=\"Limpiar\" class=\"BOTONFORM\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                                 <input type=\"button\" name=\"btnSalir\" id=\"btnSalir\" value=\"Salir\" class=\"BOTONFORM\" onclick=\"javascript:window.close();\" />\n");
      out.write("                                              </div>\n");
      out.write("                                              <div id=\"dLoader\" align=\"center\" class=\"TEXTOEXITO\" style=\"vertical-align: middle;\">\n");
      out.write("                                                  <img src=\"Images/loader.gif\" style=\"vertical-align: middle;width: 30px;height: 30px;\" />&nbsp;&nbsp;Cargando...\n");
      out.write("                                              </div>\n");
      out.write("                                         </td>\n");
      out.write("                                      </tr>                         \n");
      out.write("                                      <tr>\n");
      out.write("                                          <td colspan=\"7\">\n");
      out.write("                                              <div id=\"dIngresoConsumos\">                                             \n");
      out.write("                                              </div>\n");
      out.write("                                          </td>\n");
      out.write("                                      </tr>\n");
      out.write("                                      <tr><td colspan=\"7\" style=\"height: 5px;\"></td></tr>\n");
      out.write("                                      <tr>\n");
      out.write("                                          <td colspan=\"7\" class=\"MSGAVISOOBLG\">\n");
      out.write("                                              Los campos marcados con (*) son obligatorios.\n");
      out.write("                                          </td>\n");
      out.write("                                      </tr>\n");
      out.write("                                 </table>\n");
      out.write("                            </form>\n");
      out.write("                         </div>\n");
      out.write("                        <div id=\"dFechaConsumo\">                                             \n");
      out.write("                        </div>\n");
      out.write("                     ");
}
      out.write("\n");
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
