package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.edu.udea.facturacion.dto.ServicioXUnidad;
import co.edu.udea.facturacion.dao.impl.ServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.ServicioXUnidadDAO;
import co.edu.udea.facturacion.dto.UnidadMedida;
import co.edu.udea.facturacion.dao.impl.UnidadMedidaDAOImpl;
import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl;
import co.edu.udea.facturacion.dao.UsuarioSIUDAO;
import co.edu.udea.facturacion.dto.Servicio;
import java.util.List;
import co.edu.udea.facturacion.dao.impl.ServicioDAOImpl;
import co.edu.udea.facturacion.dao.ServicioDAO;

public final class servicioPorUnidad_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String strAccion = null, strTipoFacturacion=null;
        
    ServicioXUnidadDAO servicioXUnidadDAO = new ServicioXUnidadDAOImpl();
    ServicioXUnidad servicioXUnidad= null;
    
    SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
    Subservicio subservicio = null;
                    
    ServicioDAO servicioDAO = new ServicioDAOImpl();
    List<Servicio> servicios = null;
    
    UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
    List<UnidadMedida> unidadesMedida = null;
    
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        strTipoFacturacion = "UNDS";
                 
        servicios = servicioDAO.obtenerPorTipoFacturacion(strTipoFacturacion);
        unidadesMedida = unidadMedidaDAO.obtenerTodas();
        
        if (strAccion.equals("V")){
            Integer intCodigo = Integer.parseInt(request.getParameter("keyCC"));
            servicioXUnidad = servicioXUnidadDAO.obtenerUno(intCodigo);
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
      out.write("        <title>Servicio por unidad</title>\n");
      out.write("    </head>\n");
      out.write("    <body onLoad=\"setFocus('cbServicio');\">\n");
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
      out.write("                            <form id=\"frmServicioXUnidad\" name=\"frmServicioXUnidad\" method=\"POST\" action=\"RegistroAdministrativo\" onsubmit=\"return validarServicioXUnidad()\">\n");
      out.write("                                <input type=\"hidden\" name=\"txtForm\" id=\"txtForm\" value=\"frmServicioXUnidad\" />\n");
      out.write("                                <input type=\"hidden\" name=\"txtAccion\" id=\"txtAccion\" value=\"");
      out.print(strAccion);
      out.write("\" />\n");
      out.write("                                 ");
if(strAccion.equals("C")){
      out.write("\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">NUEVO REGISTRO DE SERVICIO POR UNIDAD</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre del servicio</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbServicio\" name=\"cbServicio\" class=\"CAMPOSELECT\" style=\"width: 350px;\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(Servicio servicio : servicios){
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(servicio.getCodigo());
      out.write('"');
      out.write('>');
      out.print(servicio.getNombre());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgServicio\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre del subservicio:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <div id=\"dSubservicio\">                         \n");
      out.write("                                                <select id=\"cbSubservicio\" name=\"cbSubservicio\" class=\"CAMPOSELECT\" style=\"width: 350px;\">\n");
      out.write("                                                    <option value=\"-1\">Seleccione una opción</option>                                                \n");
      out.write("                                                </select>\n");
      out.write("                                             </div>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgSubservicio\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Unidad de medida:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbUnidadMedida\" name=\"cbUnidadMedida\" class=\"CAMPOSELECT\" style=\"width: 250px;\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(UnidadMedida unidadMedida : unidadesMedida){
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(unidadMedida.getCodigo());
      out.write('"');
      out.write('>');
      out.print(unidadMedida.getNombre());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgUnidadMedida\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>                    \n");
      out.write("                                         <td class=\"LABELFORM\">* Valor de la unidad:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtValorUnidad\" name=\"txtValorUnidad\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgValorUnidad\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>                                        \n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"CELDABOTONFORM\">                             \n");
      out.write("                                                <input type=\"submit\" name=\"btnGuardar\" id=\"btnGuardar\" value=\"Guardar\" class=\"BOTONFORM\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                                <input type=\"reset\" name=\"btnLimpiar\" id=\"btnLimpiar\" value=\"Limpiar\" class=\"BOTONFORM\" onclick=\"setFocus('cbServicio')\" />&nbsp;&nbsp;&nbsp;\n");
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
      out.write("                                    <input type=\"hidden\" name=\"txtCodigo\" id=\"txtCodigo\" value=\"");
      out.print(servicioXUnidad.getCodigo().toString());
      out.write("\" />\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">REGISTRO DE SUBSERVICIO</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre del servicio</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             ");

                                                     String strIdServicio =servicioXUnidad.getServicio();
                                                     String strServicio = "";
                                                     
                                                     strServicio = servicioDAO.obtenerUno(strIdServicio).getNombre();
                                             
      out.write("\n");
      out.write("                                             <input type=\"hidden\" id=\"cbServicio\" name=\"cbServicio\" value=\"");
      out.print(strIdServicio);
      out.write("\" class=\"CAMPOFORM\" />\n");
      out.write("                                             <input type=\"text\" id=\"txtServicio\" name=\"txtServicio\" value=\"");
      out.print(strServicio);
      out.write("\" class=\"CAMPOFORMREAD\" style=\"width: 400px;\" />                                                           \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgServicio\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre del subservicio:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">                             \n");
      out.write("                                             ");

                                                     String strIdSubservicio =servicioXUnidad.getSubservicio();
                                                     String strSubservicio = "";
                                                     
                                                     strSubservicio = subservicioDAO.obtenerUno(strIdSubservicio).getNombre();
                                             
      out.write("\n");
      out.write("                                             <input type=\"hidden\" id=\"cbSubservicio\" name=\"cbSubservicio\" value=\"");
      out.print(strIdSubservicio);
      out.write("\" class=\"CAMPOFORM\" />\n");
      out.write("                                             <input type=\"text\" id=\"txtSubservicio\" name=\"txtSubservicio\" value=\"");
      out.print(strSubservicio);
      out.write("\" class=\"CAMPOFORMREAD\" style=\"width: 400px;\" />                                                                                \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgSubservicio\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Unidad de medida:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             ");

                                                     String strIdUnidadMedida =servicioXUnidad.getUnidadMedida();
                                                     String strUnidadMedida = "";
                                                     
                                                     strUnidadMedida = unidadMedidaDAO.obtenerUna(strIdUnidadMedida).getNombre();
                                             
      out.write("\n");
      out.write("                                             <input type=\"hidden\" id=\"cbUnidadMedida\" name=\"cbUnidadMedida\" value=\"");
      out.print(strIdUnidadMedida);
      out.write("\" class=\"CAMPOFORM\" />\n");
      out.write("                                             <input type=\"text\" id=\"txtUnidadMedida\" name=\"txtUnidadMedida\" value=\"");
      out.print(strUnidadMedida);
      out.write("\" class=\"CAMPOFORMREAD\" />                                             \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgUnidadMedida\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>                    \n");
      out.write("                                         <td class=\"LABELFORM\">* Valor de la unidad:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtValorUnidad\" name=\"txtValorUnidad\" value=\"");
      out.print(servicioXUnidad.getValorUnidad().toString());
      out.write("\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgValorUnidad\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"CELDABOTONFORM\">                             \n");
      out.write("                                                <input type=\"submit\" name=\"btnActualizar\" id=\"btnActualizar\" value=\"Actualizar\" class=\"BOTONFORM\" />&nbsp;&nbsp;&nbsp;                                               \n");
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
