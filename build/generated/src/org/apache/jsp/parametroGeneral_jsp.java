package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;

public final class parametroGeneral_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String strAccion = null;
    ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
    ParametroGeneral parametroGeneral = null;

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        
        if (strAccion.equals("V")){
            parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
        }
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"SHORTCUT ICON\" href=\"Images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/forms.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/ajax.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/comunes.js\"></script>        \n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/validacionesAdministrativo.js\"></script>\n");
      out.write("        <title>Parámetros generales</title>\n");
      out.write("    </head>\n");
      out.write("    <body onLoad=\"setFocus('txtTituloApp')\">\n");
      out.write("        <header>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("        </header>\n");
      out.write("        <section>\n");
      out.write("           <article>\n");
      out.write("               ");
if(strAccion != null){
      out.write("\n");
      out.write("                    <br />\n");
      out.write("                    <div align=\"center\">\n");
      out.write("                        <form id=\"frmGeneral\" name=\"frmGeneral\" method=\"POST\" action=\"RegistroAdministrativo\" onsubmit=\"return validarParametrosGenerales()\">\n");
      out.write("                            <input type=\"hidden\" name=\"txtForm\" id=\"txtForm\" value=\"frmGeneral\" />\n");
      out.write("                            <input type=\"hidden\" name=\"txtAccion\" id=\"txtAccion\" value=\"");
      out.print(strAccion);
      out.write("\" />\n");
      out.write("                            ");
if(strAccion.equals("C")){
      out.write("                        \n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">NUEVO REGISTRO DE PARÁMETROS GENERALES</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"SUBTITULOFORM\">Datos generales de la aplicación</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Título de la aplicación:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtTituloApp\" name=\"txtTituloApp\" class=\"CAMPOFORM\" style=\"width: 250px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgTituloApp\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Subtítulo de la aplicación:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtSubtituloApp\" name=\"txtSubtituloApp\" class=\"CAMPOFORM\" style=\"width: 250px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgSubtituloApp\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Token para consumo de servicios web:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtToken\" name=\"txtToken\" class=\"CAMPOFORM\" style=\"width: 250px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgToken\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>      \n");
      out.write("                                          <td class=\"LABELFORM\">* Nro. de registros a mostrar en vistas:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNroRegistrosMostrar\" name=\"txtNroRegistrosMostrar\" class=\"CAMPOFORM\" maxlength=\"3\" style=\"width: 50px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNroRegistrosMostrar\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"SUBTITULOFORM\">Datos para el envío de correos electrónicos</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre del servidor SMTP:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNomServidor\" name=\"txtNomServidor\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNomServidor\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nro. del puerto de conexión:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNroPuerto\" name=\"txtNroPuerto\" class=\"CAMPOFORM\" maxlength=\"5\" style=\"width: 50px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNroPuerto\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre de usuario:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNomUsuario\" name=\"txtNomUsuario\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNomUsuario\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Contraseña del usuario:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"password\" id=\"txtContrasena\" name=\"txtContrasena\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgContrasena\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"SUBTITULOFORM\">Datos para el cálculo de la facturación</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nro. días para cálculo de fecha límite:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNroDiasFechaLimite\" name=\"txtNroDiasFechaLimite\" class=\"CAMPOFORM\" maxlength=\"4\" style=\"width: 50px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNroDiasFechaLimite\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* % de sanción por incumplimiento:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtPorcSancionImpl\" name=\"txtPorcSancionImpl\" class=\"CAMPOFORM\" maxlength=\"4\" style=\"width: 50px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgPorcSancionImpl\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"CELDABOTONFORM\">                             \n");
      out.write("                                                <input type=\"submit\" name=\"btnGuardar\" id=\"btnGuardar\" value=\"Guardar\" class=\"BOTONFORM\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                                <input type=\"reset\" name=\"btnLimpiar\" id=\"btnLimpiar\" value=\"Limpiar\" class=\"BOTONFORM\" onclick=\"setFocus('txtTituloApp')\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                                <input type=\"button\" name=\"btnSalir\" id=\"btnSalir\" value=\"Salir\" class=\"BOTONFORM\" onclick=\"javascript:window.close();\" />                                   \n");
      out.write("                                           </td>\n");
      out.write("                                        </tr>                                                         \n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"MSGAVISOOBLG\">\n");
      out.write("                                                Los campos marcados con (*) son obligatorios.\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                              ");
}else{
      out.write("\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">REGISTRO DE PARÁMETROS GENERALES</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"SUBTITULOFORM\">Datos generales de la aplicación</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Título de la aplicación:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtTituloApp\" name=\"txtTituloApp\" value=\"");
      out.print(parametroGeneral.getTituloApp());
      out.write("\" class=\"CAMPOFORM\" style=\"width: 250px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgTituloApp\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Subtítulo de la aplicación:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtSubtituloApp\" name=\"txtSubtituloApp\" value=\"");
      out.print(parametroGeneral.getSubtituloApp());
      out.write("\" class=\"CAMPOFORM\" style=\"width: 250px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgSubtituloApp\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Token para consumo de servicios web:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtToken\" name=\"txtToken\" value=\"");
      out.print(parametroGeneral.getTokenServiciosWeb());
      out.write("\" class=\"CAMPOFORM\" style=\"width: 250px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgToken\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>      \n");
      out.write("                                          <td class=\"LABELFORM\">* Nro. de registros a mostrar en vistas:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNroRegistrosMostrar\" name=\"txtNroRegistrosMostrar\" value=\"");
      out.print(parametroGeneral.getNumeroRegistrosXPagina().toString());
      out.write("\" class=\"CAMPOFORM\" maxlength=\"3\" style=\"width: 50px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNroRegistrosMostrar\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"SUBTITULOFORM\">Datos para el envío de correos electrónicos</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre del servidor SMTP:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNomServidor\" name=\"txtNomServidor\" value=\"");
      out.print(parametroGeneral.getNombreServidor());
      out.write("\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNomServidor\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nro. del puerto de conexión:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNroPuerto\" name=\"txtNroPuerto\" value=\"");
      out.print(parametroGeneral.getNumeroPuerto().toString());
      out.write("\" class=\"CAMPOFORM\" maxlength=\"5\" style=\"width: 50px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNroPuerto\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre de usuario:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNomUsuario\" name=\"txtNomUsuario\" value=\"");
      out.print(parametroGeneral.getUsuarioConexion());
      out.write("\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNomUsuario\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Contraseña del usuario:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"password\" id=\"txtContrasena\" name=\"txtContrasena\" value=\"");
      out.print(parametroGeneral.getClaveConexion());
      out.write("\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgContrasena\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"SUBTITULOFORM\">Datos para el cálculo de la facturación</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nro. días para cálculo de fecha límite:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNroDiasFechaLimite\" name=\"txtNroDiasFechaLimite\" value=\"");
      out.print(parametroGeneral.getNumeroDiasLimitePago().toString());
      out.write("\" class=\"CAMPOFORM\" maxlength=\"4\" style=\"width: 50px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNroDiasFechaLimite\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* % de sanción por incumplimiento:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtPorcSancionImpl\" name=\"txtPorcSancionImpl\" value=\"");
      out.print(parametroGeneral.getPorcentajeSancion());
      out.write("\" class=\"CAMPOFORM\" maxlength=\"4\" style=\"width: 50px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgPorcSancionImpl\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
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
      out.write("                              ");
}
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    </div>                                         \n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </article>\n");
      out.write("        </section>\n");
      out.write("        <br />\n");
      out.write("        <footer>\n");
      out.write("            <br />\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("                    \n");
      out.write("        </footer>\n");
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
