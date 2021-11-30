package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.edu.udea.facturacion.dto.Servicio;
import co.edu.udea.facturacion.dao.impl.ServicioDAOImpl;
import co.edu.udea.facturacion.dao.ServicioDAO;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl;
import co.edu.udea.facturacion.dao.UsuarioSIUDAO;
import java.util.List;
import co.edu.udea.facturacion.dto.TipoFacturacion;
import co.edu.udea.facturacion.dao.impl.TipoFacturacionDAOImpl;
import co.edu.udea.facturacion.dao.TipoFacturacionDAO;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dao.SubservicioDAO;

public final class subservicio_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String strAccion = null;
    SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
    Subservicio subservicio = null;
    
    TipoFacturacionDAO tipoFacturacionDAO = new TipoFacturacionDAOImpl();
    List<TipoFacturacion> tiposFacturacion = null;
    
    UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
    List<UsuarioSesionSIU> usuariosSIU = null;
    
    ServicioDAO servicioDAO = new ServicioDAOImpl();
    List<Servicio> servicios = null;
    
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        
        tiposFacturacion = tipoFacturacionDAO.obtenerTodos();
        usuariosSIU = usuarioSIUDAO.obtenerTodos();
        servicios = servicioDAO.obtenerTodos();
        
        if (strAccion.equals("V")){
            String strCodigo = request.getParameter("keyCC");
            subservicio = subservicioDAO.obtenerUno(strCodigo);
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
      out.write("        <title>Subservicio</title>\n");
      out.write("    </head>\n");
      out.write("    <body onLoad=\"cargarSubservicio()\">\n");
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
      out.write("                            <form id=\"frmSubservicio\" name=\"frmSubservicio\" method=\"POST\" action=\"RegistroAdministrativo\" onsubmit=\"return validarSubservicio()\">\n");
      out.write("                                <input type=\"hidden\" name=\"txtForm\" id=\"txtForm\" value=\"frmSubservicio\" />\n");
      out.write("                                <input type=\"hidden\" name=\"txtAccion\" id=\"txtAccion\" value=\"");
      out.print(strAccion);
      out.write("\" />\n");
      out.write("                                 ");
if(strAccion.equals("C")){
      out.write("\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">NUEVO REGISTRO DE SUBSERVICIO</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Código:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtCodigo\" name=\"txtCodigo\" value=\"\" class=\"CAMPOFORM\" value=\"\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgCodigo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNombre\" name=\"txtNombre\" value=\"\" class=\"CAMPOFORM\" style=\"width: 350px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNombre\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Tipo de facturación:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbTipoFacturacion\" name=\"cbTipoFacturacion\" value=\"\" class=\"CAMPOSELECT\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(TipoFacturacion tipoFacturacion : tiposFacturacion){
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(tipoFacturacion.getCodigo());
      out.write('"');
      out.write('>');
      out.print(tipoFacturacion.getNombre());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgTipoFacturacion\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Responsable:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbResponsable\" name=\"cbResponsable\" value=\"\" class=\"CAMPOSELECT\" style=\"width: 250px;\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(UsuarioSesionSIU usuarioSIU : usuariosSIU){
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(usuarioSIU.getIdentificacion());
      out.write('"');
      out.write('>');
      out.print(usuarioSIU.getNombreCompleto());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgResponsable\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Servicio padre:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbServicio\" name=\"cbServicio\" value=\"\" class=\"CAMPOSELECT\" style=\"width: 350px;\">\n");
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
      out.write("                                         <td class=\"LABELFORM\">* ¿Tiene insumos fijos?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\">\n");
      out.write("                                             <input type=\"radio\" name=\"rdInsumosFijos\" id=\"rdInsumosSi\" value=\"S\">Si&nbsp;                                   \n");
      out.write("                                             <input type=\"radio\" name=\"rdInsumosFijos\" id=\"rdInsumosNo\" value=\"N\">No                                                       \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgInsumosFijos\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Aplica subcantidad?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\">\n");
      out.write("                                             <input type=\"radio\" name=\"rdAplicaSubcantidad\" id=\"rdSubcantidadSi\" value=\"S\">Si&nbsp;                                   \n");
      out.write("                                             <input type=\"radio\" name=\"rdAplicaSubcantidad\" id=\"rdSubcantidadNo\" value=\"N\">No                                        \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgAplicaSubcantidad\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>    \n");
      out.write("                                         <td class=\"LABELFORM\">* Etiqueta subcantidad:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtEtiquetaSubcantidad\" name=\"txtEtiquetaSubcantidad\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgEtiquetaSubcantidad\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Aplica porcentaje sanción?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\">\n");
      out.write("                                             <input type=\"radio\" name=\"rdPorcSancion\" id=\"rdSancionSi\" value=\"S\">Si&nbsp;                                   \n");
      out.write("                                             <input type=\"radio\" name=\"rdPorcSancion\" id=\"rdSancionNo\" value=\"N\">No                                        \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgPorcSancion\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\" colspan=\"3\"></td>                                            \n");
      out.write("                                        </tr>\n");
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
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">REGISTRO DE SUBSERVICIO</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Código:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtCodigo\" name=\"txtCodigo\" value=\"");
      out.print(subservicio.getCodigo());
      out.write("\" class=\"CAMPOFORMREAD\" readonly />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgCodigo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Nombre:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtNombre\" name=\"txtNombre\" value=\"");
      out.print(subservicio.getNombre());
      out.write("\" class=\"CAMPOFORM\" style=\"width: 350px;\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgNombre\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Tipo de facturación:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             ");

                                                String strIdTipoFacturacion = subservicio.getTipoFacturacion();
                                                String strTipoFacturacion = "";
                                                
                                                strTipoFacturacion = tipoFacturacionDAO.obtenerUno(strIdTipoFacturacion).getNombre();
                                             
      out.write("\n");
      out.write("                                            <input type=\"hidden\" id=\"cbTipoFacturacion\" name=\"cbTipoFacturacion\" value=\"");
      out.print(strIdTipoFacturacion);
      out.write("\" class=\"CAMPOFORM\"/>\n");
      out.write("                                            <input type=\"text\" id=\"txtTipoFacturacion\" name=\"txtTipoFacturacion\" value=\"");
      out.print(strTipoFacturacion);
      out.write("\" class=\"CAMPOFORMREAD\" readOnly />                                       \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgTipoFacturacion\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Responsable:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbResponsable\" name=\"cbResponsable\" value=\"\" class=\"CAMPOSELECT\" style=\"width: 250px;\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(UsuarioSesionSIU usuarioSIU : usuariosSIU){
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(usuarioSIU.getIdentificacion());
      out.write('"');
      out.write('>');
      out.print(usuarioSIU.getNombreCompleto());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>\n");
      out.write("                                             <script type=\"text/javascript\">\n");
      out.write("                                                 $(\"#cbResponsable\").val(\"");
      out.print(subservicio.getResponsable());
      out.write("\");\n");
      out.write("                                             </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgResponsable\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Servicio padre:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <select id=\"cbServicio\" name=\"cbServicio\" value=\"\" class=\"CAMPOSELECT\" style=\"width: 350px;\">\n");
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
      out.write("                                             <script type=\"text/javascript\">\n");
      out.write("                                                 $(\"#cbServicio\").val(\"");
      out.print(subservicio.getServicioPadre());
      out.write("\");\n");
      out.write("                                             </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgServicio\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Tiene insumos fijos?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\">\n");
      out.write("                                             <input type=\"radio\" name=\"rdInsumosFijos\" id=\"rdInsumosSi\" value=\"S\">Si&nbsp;                                   \n");
      out.write("                                             <input type=\"radio\" name=\"rdInsumosFijos\" id=\"rdInsumosNo\" value=\"N\">No        \n");
      out.write("                                             <script type=\"text/javascript\">                                                        \n");
      out.write("                                                var strInsumosFijos = \"");
      out.print(subservicio.getInsumosFijos());
      out.write("\";                                                    \n");
      out.write("                                                if (strInsumosFijos == \"S\"){\n");
      out.write("                                                    $(\"#rdInsumosSi\").prop(\"checked\", true);\n");
      out.write("                                                }else{\n");
      out.write("                                                    $(\"#rdInsumosNo\").prop(\"checked\", true);\n");
      out.write("                                                }                                  \n");
      out.write("                                            </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgInsumosFijos\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Aplica subcantidad?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\">\n");
      out.write("                                             <input type=\"radio\" name=\"rdAplicaSubcantidad\" id=\"rdSubcantidadSi\" value=\"S\">Si&nbsp;                                   \n");
      out.write("                                             <input type=\"radio\" name=\"rdAplicaSubcantidad\" id=\"rdSubcantidadNo\" value=\"N\">No              \n");
      out.write("                                             <script type=\"text/javascript\">                                                        \n");
      out.write("                                                var strAplicaSubcantidad = \"");
      out.print(subservicio.getAplicaSubcantidad());
      out.write("\";                                                    \n");
      out.write("                                                if (strAplicaSubcantidad == \"S\"){\n");
      out.write("                                                    $(\"#rdSubcantidadSi\").prop(\"checked\", true);\n");
      out.write("                                                }else{\n");
      out.write("                                                    $(\"#rdSubcantidadNo\").prop(\"checked\", true);\n");
      out.write("                                                }                                  \n");
      out.write("                                            </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgAplicaSubcantidad\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>    \n");
      out.write("                                         <td class=\"LABELFORM\">* Etiqueta subcantidad:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtEtiquetaSubcantidad\" name=\"txtEtiquetaSubcantidad\" value=\"");
      out.print(subservicio.getEtiquetaSubcantidad());
      out.write("\" class=\"CAMPOFORM\" />\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgEtiquetaSubcantidad\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Aplica porcentaje sanción?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\">\n");
      out.write("                                             <input type=\"radio\" name=\"rdPorcSancion\" id=\"rdSancionSi\" value=\"S\">Si&nbsp;                                   \n");
      out.write("                                             <input type=\"radio\" name=\"rdPorcSancion\" id=\"rdSancionNo\" value=\"N\">No                 \n");
      out.write("                                             <script type=\"text/javascript\">                                                        \n");
      out.write("                                                var strPorcSancion = \"");
      out.print(subservicio.getAplicaPorcentajeSancion());
      out.write("\";                                                    \n");
      out.write("                                                if (strPorcSancion == \"S\"){\n");
      out.write("                                                    $(\"#rdSancionSi\").prop(\"checked\", true);\n");
      out.write("                                                }else{\n");
      out.write("                                                    $(\"#rdSancionNo\").prop(\"checked\", true);\n");
      out.write("                                                }                                  \n");
      out.write("                                            </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgPorcSancion\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\" colspan=\"3\"></td>                                            \n");
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
