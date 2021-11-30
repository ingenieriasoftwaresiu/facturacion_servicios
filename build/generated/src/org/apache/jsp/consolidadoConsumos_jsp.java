package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.edu.udea.facturacion.dao.impl.DescuentoConsumoXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO;
import co.edu.udea.facturacion.dao.ConsumoAdicionalXUnidadDAO;
import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.ConsumoServicioXUnidadDAO;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
import co.edu.udea.facturacion.dao.impl.DescuentoConsumoXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.DescuentoConsumoXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.impl.ItemAdicionalDAOImpl;
import co.edu.udea.facturacion.dto.ItemAdicional;
import co.edu.udea.facturacion.dao.ItemAdicionalDAO;
import co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.dao.ConsumoAdicionalXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dao.ConsumoServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO;
import java.util.Date;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dto.CuentaCobro;
import co.edu.udea.facturacion.dao.impl.CuentaCobroDAOImpl;
import co.edu.udea.facturacion.dao.CuentaCobroDAO;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl;
import co.edu.udea.facturacion.dao.FuncionesComunesDAO;
import java.math.BigDecimal;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesConsumosDAOImpl;
import co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO;
import java.util.List;
import co.edu.udea.facturacion.dao.impl.DetalleCuentaCobroDAOImpl;
import co.edu.udea.facturacion.dto.DetalleCuentaCobro;
import co.edu.udea.facturacion.dao.DetalleCuentaCobroDAO;

public final class consolidadoConsumos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String strIdCuentaCobro=null, strIdServicioBase="",strIdServicio="", strIdSubservicio="", strNombreServicio="", strNombreSubservicio="", strConceptoSubservicio="";
    String strFechaInicio="", strFechaFin="", strTipoFacturacion="", strInsumosFijos="", strAplicaSubcantidad="", strEtiquetaSubcantidad="", strConceptoConsumo="", strCantidadConsumo="";
    String strAplicaSancion="N", strPorcentajeSancion="", strNombreItemAdicional=null, strValorItemAdicional=null, strConceptoDescuento=null, strPorcentajeDescuento=null;
    String strIdTipoUsuario=null, strIdUsuario = null, strNombreUsuario="", strAcuerdo="-";
    Long lgIdCuentaCobro = null;
    Date dtFechaConsumo = null, dtFechaGeneracion=null;
    Integer intSubcantidadConsumo=0, intCodigoConsumo=null;
    BigDecimal bdTotalServicio = null, bdTotalSubservicio=null, bdTotalPagar=new BigDecimal(0);
    CuentaCobroDAO cuentaCobroDAO = null;
    CuentaCobro cuentaCobro = null;
    DetalleCuentaCobroDAO detalleCuentaCobroDAO = null;
    FuncionesComunesConsumosDAO funcionesComunesConsumosDAO = null;
    FuncionesComunesDAO funcionesComunesDAO = null;
    List<DetalleCuentaCobro> detallesCuentaCobro = null;
    List<DetalleCuentaCobro> detallesSubservicios = null;
    SubservicioDAO subservicioDAO = null;
    Subservicio subservicio = null;
    ConsumoServicioXInsumoDAO consumoServicioXInsumoDAO = null;
    List<ConsumoServicioXInsumo> consumosServicioXInsumo = null;
    ConsumoServicioXTipoUsuarioDAO consumoServicioXTipoUsuarioDAO = null;
    List<ConsumoServicioXTipoUsuario> consumosServicioXTipoUsuario = null;
    ConsumoServicioXUnidadDAO consumoServicioXUnidadDAO = null;
    List<ConsumoServicioXUnidad> consumosServicioXUnidad = null;
    ParametroGeneralDAO parametroGeneralDAO = null;
    ParametroGeneral parametroGeneral = null;
    ConsumoAdicionalXTipoUsuarioDAO consumoAdicionalXTipoUsuarioDAO = null;   
    ConsumoAdicionalXUnidadDAO consumoAdicionalXUnidadDAO = null;
    List<ConsumoAdicional> consumosAdicionales = null;
    ItemAdicionalDAO itemAdicionalDAO = null;
    DescuentoConsumoXTipoUsuarioDAO descuentoConsumoXTipoUsuarioDAO = null;
    DescuentoConsumoXUnidadDAO descuentoConsumoXUnidadDAO = null;
    DescuentoConsumo descuentoConsumo = null;
    
    strIdCuentaCobro = request.getParameter("keyCC");
    
    if (strIdCuentaCobro != null){
        
        lgIdCuentaCobro = Long.parseLong(strIdCuentaCobro);
        cuentaCobroDAO = new CuentaCobroDAOImpl(); 
        detalleCuentaCobroDAO = new DetalleCuentaCobroDAOImpl();
        funcionesComunesConsumosDAO = new FuncionesComunesConsumosDAOImpl();
        funcionesComunesDAO = new FuncionesComunesDAOImpl();
        subservicioDAO = new SubservicioDAOImpl();
        consumoServicioXInsumoDAO = new ConsumoServicioXInsumoDAOImpl();
        consumoServicioXTipoUsuarioDAO = new ConsumoServicioXTipoUsuarioDAOImpl();
        consumoServicioXUnidadDAO = new ConsumoServicioXUnidadDAOImpl();
        parametroGeneralDAO = new ParametroGeneralDAOImpl();
        consumoAdicionalXTipoUsuarioDAO = new ConsumoAdicionalXTipoUsuarioDAOImpl();
        consumoAdicionalXUnidadDAO = new ConsumoAdicionalXUnidadDAOImpl();
        itemAdicionalDAO = new ItemAdicionalDAOImpl();
        descuentoConsumoXTipoUsuarioDAO = new DescuentoConsumoXTipoUsuarioDAOImpl();
        descuentoConsumoXUnidadDAO = new DescuentoConsumoXUnidadDAOImpl();
        
        detallesCuentaCobro = detalleCuentaCobroDAO.obtenerTodosPorCuentaCobro(lgIdCuentaCobro);
        cuentaCobro = cuentaCobroDAO.obtenerUna(lgIdCuentaCobro);
        
        if (cuentaCobro != null){
            strFechaInicio = cuentaCobro.getFechaInicioPeriodo().toString();
            strFechaFin = cuentaCobro.getFechaFinPeriodo().toString();
            strIdTipoUsuario = cuentaCobro.getTipoUsuarioConsumo();
            strIdUsuario = cuentaCobro.getUsuarioConsumo();
            dtFechaGeneracion = cuentaCobro.getFechaCreacion();
            strAcuerdo = cuentaCobro.getAcuerdoCobro();
            
            strNombreUsuario = funcionesComunesConsumosDAO.obtenerUsuario(strIdUsuario, strIdTipoUsuario);
        }
    }


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"SHORTCUT ICON\" href=\"Images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/forms.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/cuenta-cobro.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/ajax.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/consolidadoConsumos.js\"></script>\n");
      out.write("        <title>Consolidado de consumos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("       </header>\n");
      out.write("       <section>\n");
      out.write("           <article>\n");
      out.write("                ");
if(detallesCuentaCobro != null){
      out.write("                           \n");
      out.write("                    <div align=\"center\">                    \n");
      out.write("                        <br />\n");
      out.write("                        <div id=\"noprint\">                            \n");
      out.write("                            <form id=\"frmAcciones\" method=\"POST\" action=\"#\">\n");
      out.write("                                <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\"style=\"width: 99%;\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td colspan=\"2\" class=\"TEXTOACCION\">                                          \n");
      out.write("                                            <b>Bienvenido!</b>                                   \n");
      out.write("                                        </td>\n");
      out.write("                                        <td colspan=\"2\" class=\"BOTONESACCION\">                                            \n");
      out.write("                                            <input type=\"button\" id=\"btnImprimir\" name=\"btnImprimir\" value=\"Imprimir\" class=\"BOTONFORM\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                            <input type=\"button\" id=\"btnSalir\" name=\"btnSalir\" value=\"Salir\" class=\"BOTONFORM\" />                                    \n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                          </form>                          \n");
      out.write("                       </div>                        \n");
      out.write("                        <br/>\n");
      out.write("                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"TABLAMAESTRO\" style=\"width: 99%;\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"TITULOFORM\" colspan=\"6\" style=\"border-bottom: 1px solid #116043;\">CONSOLIDADO DE CONSUMOS DE LA CUENTA DE COBRO #");
      out.print(strIdCuentaCobro);
      out.write(" PARA EL PERIODO ");
      out.print(strFechaInicio);
      out.write(" A ");
      out.print(strFechaFin);
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"LABELFORM\" style=\"width: 30%;color: #000;\">\n");
      out.write("                                    <label for=\"\"> Fecha de generación: (aaaa-mm-dd)</label>\n");
      out.write("                                </td> \n");
      out.write("                                <td class=\"CELDACAMPOFORM\" style=\"width: 20%;\">\n");
      out.write("                                    <input type=\"text\" id=\"txtFechaGeneracion\" name=\"txtFechaGeneracion\" value=\"");
      out.print(dtFechaGeneracion.toString());
      out.write("\" class=\"CAMPOFORMREAD\" />\n");
      out.write("                                </td>\n");
      out.write("                                <td style=\"width: 5%;\"></td>\n");
      out.write("                                <td class=\"LABELFORM\" style=\"width: 20%;color: #000;\">\n");
      out.write("                                    <label for=\"\" > Usuario asociado:</label>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"CELDACAMPOFORM\" style=\"width: 25%;\">\n");
      out.write("                                    <input type=\"text\" id=\"txtUsuarioAsociado\" name=\"txtUsuarioAsociado\" value=\"");
      out.print(strNombreUsuario);
      out.write("\"  class=\"CAMPOFORMREAD\" style=\"width: 310px;\" />\n");
      out.write("                                </td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr><td colspan=\"6\"  style=\"height: 10px;\"></td></tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"6\">\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"3\" border=\"0\" style=\"width: 100%;\">\n");
      out.write("                                        <tr>                                \n");
      out.write("                                            <td class=\"SUBTITULOFORM\" style=\"border-right: 1px solid #116043;border-bottom: 1px solid #116043;border-top: 1px solid #116043;\">Nombre del Servicio / Subservicio</td>\n");
      out.write("                                            <td class=\"SUBTITULOFORM\" style=\"border-right: 1px solid #116043;border-bottom: 1px solid #116043;border-top: 1px solid #116043;\">Concepto del consumo del Servicio / Subservicio</td>\n");
      out.write("                                            <td class=\"SUBTITULOFORM\" style=\"border-right: 1px solid #116043;border-bottom: 1px solid #116043;border-top: 1px solid #116043;\">Fecha del consumo<br />(aaaa-mm-dd)</td>\n");
      out.write("                                            <td class=\"SUBTITULOFORM\" style=\"border-bottom: 1px solid #116043;border-top: 1px solid #116043;\">Valor consumido ($)</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");
for(DetalleCuentaCobro detalleCuentaCobro: detallesCuentaCobro){
      out.write("                       \n");
      out.write("                                            ");
strIdServicio = detalleCuentaCobro.getServicio();
      out.write("\n");
      out.write("                                            ");
if(!(strIdServicio.equals(strIdServicioBase))){
                                                strNombreServicio = funcionesComunesConsumosDAO.obtenerServicio(strIdServicio);       
                                                bdTotalServicio = detalleCuentaCobroDAO.obtenerTotalPorServicioYCuentaCobro(lgIdCuentaCobro, strIdServicio);                                    
                                            
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td class=\"CATEGORIASERVICIO\" style=\"width: 80%;\" colspan=\"2\">");
      out.print(strNombreServicio);
      out.write("</td>                                        \n");
      out.write("                                                    <td class=\"CATEGORIASERVICIO\" style=\"border-right: 1px solid #116043;width: 10%;\"></td>\n");
      out.write("                                                    <td class=\"CATEGORIASERVICIO\" style=\"text-align: center;width: 10%;\">$");
      out.print(funcionesComunesDAO.marcarMiles(bdTotalServicio.toString()));
      out.write("</td>\n");
      out.write("                                                </tr>        \n");
      out.write("                                                ");

                                                    detallesSubservicios = detalleCuentaCobroDAO.obtenerTodosPorServicioYCuentaCobro(lgIdCuentaCobro, strIdServicio);
                                                    if (detallesSubservicios != null){
                                                        for(DetalleCuentaCobro detalleSubservicios: detallesSubservicios){
                                                           strIdSubservicio = detalleSubservicios.getSubservicio();
                                                           strNombreSubservicio = funcionesComunesConsumosDAO.obtenerSubservicio(strIdSubservicio);                                               
                                                           bdTotalSubservicio = detalleSubservicios.getTotalAPagar();
                                                           subservicio = subservicioDAO.obtenerUno(strIdSubservicio);
                                                           strTipoFacturacion = subservicio.getTipoFacturacion();
                                                           strInsumosFijos = subservicio.getInsumosFijos();
                                                           strAplicaSubcantidad = subservicio.getAplicaSubcantidad();
                                                           dtFechaConsumo = detalleSubservicios.getFechaConsumo();
                                                           intCodigoConsumo = detalleSubservicios.getCodigoConsumo();

                                                           if (strTipoFacturacion.equals("INSUMOS")){
                                                               strConceptoSubservicio = "Consumo del subservicio para el periodo especificado.";

                                                               if (strInsumosFijos.equals("S")){
                                                                   if (strAplicaSubcantidad.equals("S")){
                                                                        strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();
                                                                        strConceptoSubservicio = strEtiquetaSubcantidad;

                                                                        consumosServicioXInsumo = consumoServicioXInsumoDAO.obtenerConsumosPorServicioSubservicioCuentaCobro(strIdServicio, strIdSubservicio, lgIdCuentaCobro);

                                                                        for(ConsumoServicioXInsumo consumoServicioXInsumo : consumosServicioXInsumo){
                                                                            intSubcantidadConsumo = consumoServicioXInsumo.getSubcantidad();
                                                                            break;
                                                                        }

                                                                        strConceptoSubservicio += ": " +  intSubcantidadConsumo.toString();
                                                                   }
                                                               }
                                                           }

                                                           if (strTipoFacturacion.equals("TIPOUSUARI")){
                                                               strConceptoSubservicio = "Consumo del subservicio para el periodo especificado.";

                                                               consumosServicioXTipoUsuario = consumoServicioXTipoUsuarioDAO.obtenerConsumosPorServicioSubservicioCuentaCobroCodigo(strIdServicio, strIdSubservicio, lgIdCuentaCobro, intCodigoConsumo);

                                                               for(ConsumoServicioXTipoUsuario consumoServicioXTipoUsuario : consumosServicioXTipoUsuario){
                                                                   //intCodigoConsumo = consumoServicioXTipoUsuario.getCodigo();
                                                                   strConceptoConsumo = consumoServicioXTipoUsuario.getConcepto();
                                                                   strCantidadConsumo = consumoServicioXTipoUsuario.getCantidadUnidad().toString() + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXTipoUsuario.getUnidadMedida());

                                                                   strConceptoSubservicio = strConceptoConsumo + " " + strCantidadConsumo + ".";

                                                                   if (strAplicaSubcantidad.equals("S")){
                                                                        strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();            
                                                                        intSubcantidadConsumo = consumoServicioXTipoUsuario.getSubcantidad();
                                                                        strConceptoSubservicio += " " + strEtiquetaSubcantidad + ": " + intSubcantidadConsumo.toString() + ".";
                                                                   }

                                                                   strAplicaSancion = consumoServicioXTipoUsuario.getAplicarSancion();

                                                                   if (strAplicaSancion.equals("S")){
                                                                       strConceptoSubservicio += "<br />";
                                                                       parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
                                                                       strPorcentajeSancion = String.valueOf(parametroGeneral.getPorcentajeSancion());

                                                                       strConceptoSubservicio += " <b>Sanción</b>: " + strPorcentajeSancion + "%.";
                                                                   }

                                                                   consumosAdicionales = consumoAdicionalXTipoUsuarioDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                   if ((consumosAdicionales != null) && (consumosAdicionales.size() > 0)){
                                                                       strConceptoSubservicio += "<br />";
                                                                       for (ConsumoAdicional consumoAdicional : consumosAdicionales){
                                                                           strNombreItemAdicional = itemAdicionalDAO.obtenerUno(consumoAdicional.getItemAdicional()).getNombre();
                                                                           strValorItemAdicional = funcionesComunesDAO.marcarMiles(consumoAdicional.getValorUnidad().toString());

                                                                           strConceptoSubservicio += "<b>Consumo adicional</b>: " + strNombreItemAdicional + " $" +strValorItemAdicional + ".";
                                                                       }
                                                                   }

                                                                   descuentoConsumo = descuentoConsumoXTipoUsuarioDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                   if (descuentoConsumo != null){
                                                                       strConceptoSubservicio += "<br />";
                                                                       strConceptoDescuento = descuentoConsumo.getConcepto();
                                                                       strPorcentajeDescuento = String.valueOf(descuentoConsumo.getDescuento());

                                                                       strConceptoSubservicio += "<b>Descuento</b>: " + strConceptoDescuento + " " + strPorcentajeDescuento + "%.";
                                                                   }

                                                                   break;
                                                               }
                                                           }

                                                           if (strTipoFacturacion.equals("UNDS")){
                                                               strConceptoSubservicio = "Consumo del subservicio para el periodo especificado.";

                                                               consumosServicioXUnidad= consumoServicioXUnidadDAO.obtenerConsumosPorServicioSubservicioCuentaCobro(strIdServicio, strIdSubservicio, lgIdCuentaCobro);

                                                               for(ConsumoServicioXUnidad consumoServicioXUnidad : consumosServicioXUnidad){
                                                                   intCodigoConsumo = consumoServicioXUnidad.getCodigo();
                                                                   strConceptoConsumo = consumoServicioXUnidad.getConcepto();
                                                                   strCantidadConsumo = consumoServicioXUnidad.getCantidadUnidad().toString() + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXUnidad.getUnidadMedida());

                                                                   strConceptoSubservicio = strConceptoConsumo + " " + strCantidadConsumo + ".";

                                                                   consumosAdicionales = consumoAdicionalXUnidadDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                   if ((consumosAdicionales != null) && (consumosAdicionales.size() > 0)){
                                                                       strConceptoSubservicio += "<br />";
                                                                       for (ConsumoAdicional consumoAdicional : consumosAdicionales){
                                                                           strNombreItemAdicional = itemAdicionalDAO.obtenerUno(consumoAdicional.getItemAdicional()).getNombre();
                                                                           strValorItemAdicional = funcionesComunesDAO.marcarMiles(consumoAdicional.getValorUnidad().toString());

                                                                           strConceptoSubservicio += "<b>Consumo adicional</b>: " + strNombreItemAdicional + " $" +strValorItemAdicional + ".";
                                                                       }
                                                                   }

                                                                   descuentoConsumo = descuentoConsumoXUnidadDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                   if (descuentoConsumo != null){
                                                                       strConceptoSubservicio += "<br />";
                                                                       strConceptoDescuento = descuentoConsumo.getConcepto();
                                                                       strPorcentajeDescuento = String.valueOf(descuentoConsumo.getDescuento());

                                                                       strConceptoSubservicio += "<b>Descuento</b>: " + strConceptoDescuento + " " + strPorcentajeDescuento + "%.";
                                                                   }

                                                                   break;
                                                               }
                                                           }                                                                                             
                                                        
      out.write("\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td class=\"CATEGORIASUBSERVICIO\" style=\"padding-left: 20px;border-right: 1px solid #116043;\">");
      out.print(strNombreSubservicio);
      out.write("</td>\n");
      out.write("                                                            <td class=\"CATEGORIASUBSERVICIO\" style=\"border-right: 1px solid #116043;\">");
      out.print(strConceptoSubservicio);
      out.write("</td>\n");
      out.write("                                                            <td class=\"CATEGORIASUBSERVICIO\" style=\"border-right: 1px solid #116043;text-align: center;\">");
      out.print(dtFechaConsumo.toString());
      out.write("</td>\n");
      out.write("                                                            <td class=\"CATEGORIASUBSERVICIO\" style=\"text-align: center;\">$");
      out.print(funcionesComunesDAO.marcarMiles(bdTotalSubservicio.toString()));
      out.write("</td>\n");
      out.write("                                                        </tr>  \n");
      out.write("                                                        ");

                                                            strIdSubservicio = null;
                                                            strNombreSubservicio = null;
                                                            strConceptoSubservicio = null;
                                                            bdTotalSubservicio = null;
                                                            detalleSubservicios = null;
                                                            subservicio = null;
                                                            strTipoFacturacion = null;
                                                            dtFechaConsumo = null;
                                                            consumosServicioXInsumo = null;
                                                            intSubcantidadConsumo = null;
                                                            strConceptoConsumo = "";
                                                            strCantidadConsumo = "";
                                                            strPorcentajeSancion = null;
                                                            parametroGeneral = null;
                                                            strAplicaSancion = "N";
                                                            consumosAdicionales = null;
                                                            strNombreItemAdicional = null;
                                                            strValorItemAdicional = null;
                                                            strConceptoDescuento = null;
                                                            strPorcentajeDescuento = null;
                                                            descuentoConsumo = null;
                                                        }
                                                    }
                                                
      out.write("\n");
      out.write("                                            ");

                                                    bdTotalPagar = bdTotalPagar.add(bdTotalServicio);
                                                }

                                                strIdServicioBase = strIdServicio;
                                                strIdServicio = "";
                                                strNombreServicio = null;
                                                bdTotalServicio = null;                    
                                                detalleCuentaCobro = null;
                                            
      out.write("                    \n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"3\" class=\"CATEGORIATOTAL\" style=\"text-align: left;border-right: 1px solid #116043;\">TOTAL POR CONSUMOS DE SERVICIOS / SUBSERVICIOS</td>\n");
      out.write("                                            <td class=\"CATEGORIATOTAL\" style=\"text-align: center;\">$");
      out.print(funcionesComunesDAO.marcarMiles(bdTotalPagar.toString()));
      out.write("</td>\n");
      out.write("                                        </tr>                            \n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"MSGAVISOOBLG\" colspan=\"4\">* Los valores de dinero relacionados en la tabla anterior se especifican en pesos colombianos ($).</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>                            \n");
      out.write("                        </table>                                               \n");
      out.write("                        <div id=\"noprint2\">\n");
      out.write("                            <br />\n");
      out.write("                            <form id=\"frmDatosFacturacion\" name=\"frmDatosFacturacion\" method=\"POST\" action=\"GuardarDatosFacturacion\" onsubmit=\"return validarDatos()\">\n");
      out.write("                                <input type=\"hidden\" id=\"txtIdCuentaCobro\" name=\"txtIdCuentaCobro\" value=\"");
      out.print(strIdCuentaCobro);
      out.write("\" />\n");
      out.write("                                <input type=\"hidden\" id=\"txtAcuerdoCobro\" name=\"txtAcuerdoCobro\" value=\"");
      out.print(strAcuerdo);
      out.write("\" />\n");
      out.write("                                ");
if((strAcuerdo.equals("-")) || (strAcuerdo.equals("N"))){
      out.write("\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"width: 93%;\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\">INGRESO DE DATOS PARA FACTURACIÓN</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"LABELFORM\" style=\"width: 245px;\">* ¿Está de acuerdo con el cobro anterior?:</td>\n");
      out.write("                                              <td class=\"CELDARADIOFORM\" style=\"width: 367px;\">\n");
      out.write("                                                  <input type=\"radio\" name=\"rdAcuerdo\" id=\"rdSi\" value=\"S\" />Si&nbsp;\n");
      out.write("                                                  <input type=\"radio\" name=\"rdAcuerdo\" id=\"rdNo\" value=\"N\" />No\n");
      out.write("                                                  <script type=\"text/javascript\">\n");
      out.write("                                                    var strAcuerdoCobro = '");
      out.print(strAcuerdo);
      out.write("';\n");
      out.write("                                                    \n");
      out.write("                                                    if (strAcuerdoCobro == \"N\"){\n");
      out.write("                                                        $(\"[name=rdAcuerdo]\").filter(\"[value='N']\").prop(\"checked\",true);                \n");
      out.write("                                                    }\n");
      out.write("                                                </script>\n");
      out.write("                                              </td>\n");
      out.write("                                              <td class=\"CELDAIMGERROR\" style=\"width: 60px;\">\n");
      out.write("                                                  <img src=\"Images/error.png\" id=\"imgAcuerdo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                              </td>\n");
      out.write("                                              <td class=\"ESPACIOBLANCO\" colspan=\"4\"></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\">\n");
      out.write("                                                <div id=\"dDatosFacturacion\" style=\"display: none;\">\n");
      out.write("                                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"width: 100%;\">\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td class=\"LABELFORM\">Dependencia beneficiaria del pago:</td>\n");
      out.write("                                                              <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                                  <input type=\"text\" id=\"txtDependenciaB\" name=\"txtDependenciaB\" class=\"CAMPOFORM\" />\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                                  <img src=\"Images/error.png\" id=\"imgDependenciaB\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                                              <td class=\"LABELFORM\">Centro de costos:</td>\n");
      out.write("                                                              <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                                  <input type=\"text\" id=\"txtCentroCostosB\" name=\"txtCentroCostosB\" class=\"CAMPOFORM\" />\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                                  <img src=\"Images/error.png\" id=\"imgCentroCostosB\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                                              </td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td class=\"LABELFORM\">* Dependencia que realiza el pago:</td>\n");
      out.write("                                                              <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                                  <input type=\"text\" id=\"txtDependenciaP\" name=\"txtDependenciaP\" class=\"CAMPOFORM\" />\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                                  <img src=\"Images/error.png\" id=\"imgDependenciaP\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                                              <td class=\"LABELFORM\">* Centro de costos:</td>\n");
      out.write("                                                              <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                                  <input type=\"text\" id=\"txtCentroCostosP\" name=\"txtCentroCostosP\" class=\"CAMPOFORM\" />\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                                  <img src=\"Images/error.png\" id=\"imgCentroCostosP\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                                              </td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td class=\"LABELFORM\">* Nombre del Ordenador del Gasto:</td>\n");
      out.write("                                                              <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                                  <input type=\"text\" id=\"txtOrdenadorGasto\" name=\"txtOrdenadorGasto\" class=\"CAMPOFORM\" />\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                                  <img src=\"Images/error.png\" id=\"imgOrdenadorGasto\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                                              <td class=\"LABELFORM\">* Cargo del Ordenador del Gasto:</td>\n");
      out.write("                                                              <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                                                  <input type=\"text\" id=\"txtCargoOrdenadorGasto\" name=\"txtCargoOrdenadorGasto\" class=\"CAMPOFORM\" />\n");
      out.write("                                                              </td>\n");
      out.write("                                                              <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                                  <img src=\"Images/error.png\" id=\"imgCargoOrdenadorGasto\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                                              </td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td class=\"LABELFORM\">Observación:</td>\n");
      out.write("                                                            <td class=\"CELDACAMPOFORM\" colspan=\"3\">\n");
      out.write("                                                                  <input type=\"text\" id=\"txtObservacion\" name=\"txtObservacion\" class=\"CAMPOFORM\" style=\"width: 100%;\" />\n");
      out.write("                                                              </td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                    </table>\n");
      out.write("                                                 </div>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>                                    \n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"CELDABOTONFORM\">\n");
      out.write("                                                <input type=\"submit\" id=\"btnGuardar\" name=\"btnGuardar\" value=\"Guardar\" class=\"BOTONFORM\" />&nbsp;&nbsp;\n");
      out.write("                                                <input type=\"reset\" id=\"btnLimpiar\" name=\"btnLimpiar\" value=\"Limpiar\" class=\"BOTONFORM\" />\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"MSGAVISOOBLG\">\n");
      out.write("                                                Los campos marcados con (*) son obligatorios.\n");
      out.write("                                            </td>\n");
      out.write("                                          </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                ");
}else{
      out.write("\n");
      out.write("                                    ");

                                        String strDependenciaB="", strCentroCostosB="", strDependenciaP="", strCentroCostosP="", strNombreOrdenadorG="", strCargoOrdenadorG="", strObservacion="";
                                        strDependenciaB = cuentaCobro.getDependenciaBeneficiaria();
                                        strCentroCostosB = cuentaCobro.getCentroCostosBeneficiario();
                                        strDependenciaP = cuentaCobro.getDependenciaPagadora();
                                        strCentroCostosP = cuentaCobro.getCentroCostosPagador();
                                        strNombreOrdenadorG = cuentaCobro.getNombreOrdenadorGasto();
                                        strCargoOrdenadorG = cuentaCobro.getCargoOrdenadorGasto();
                                        strObservacion = cuentaCobro.getObservacion();
                                    
      out.write("\n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"width: 93%;\" class=\"TABLAMAESTRO\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"7\" class=\"TITULOFORM\" style=\"border-bottom: 1px solid #116043\">DATOS PARA FACTURACIÓN</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"LABELFORM\" style=\"width: 30%;\">¿Está de acuerdo con el cobro anterior?:</td>\n");
      out.write("                                              <td class=\"CELDARADIOFORM\" colspan=\"6\">                                                  \n");
      out.write("                                                    ");
if(strAcuerdo.equals("S")){
      out.write("\n");
      out.write("                                                        <input type=\"text\" value=\"Si\" class=\"CAMPOFORMREAD\" readonly/>                                        \n");
      out.write("                                                    ");
}else{
      out.write("\n");
      out.write("                                                        <input type=\"text\" value=\"No\" class=\"CAMPOFORMREAD\" readonly/>\n");
      out.write("                                                    ");
}
      out.write("\n");
      out.write("                                              </td>                     \n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"LABELFORM\" style=\"width: 30%;\">Dependencia beneficiaria del pago:</td>\n");
      out.write("                                              <td class=\"CELDACAMPOFORM\" colspan=\"3\">\n");
      out.write("                                                  <input type=\"text\" id=\"txtDependenciaB\" name=\"txtDependenciaB\" value=\"");
      out.print(strDependenciaB);
      out.write("\" class=\"CAMPOFORMREAD\" readonly/>\n");
      out.write("                                              </td>                              \n");
      out.write("                                              <td class=\"LABELFORM\" style=\"width: 30%;\">Centro de costos:</td>\n");
      out.write("                                              <td class=\"CELDACAMPOFORM\" colspan=\"2\">\n");
      out.write("                                                  <input type=\"text\" id=\"txtCentroCostosB\" name=\"txtCentroCostosB\" value=\"");
      out.print(strCentroCostosB);
      out.write("\" class=\"CAMPOFORMREAD\" readonly />\n");
      out.write("                                              </td>                                       \n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"LABELFORM\">Dependencia que realiza el pago:</td>\n");
      out.write("                                              <td class=\"CELDACAMPOFORM\" colspan=\"3\">\n");
      out.write("                                                  <input type=\"text\" id=\"txtDependenciaP\" name=\"txtDependenciaP\" value=\"");
      out.print(strDependenciaP);
      out.write("\" class=\"CAMPOFORMREAD\" readonly />\n");
      out.write("                                              </td>                                \n");
      out.write("                                              <td class=\"LABELFORM\">Centro de costos:</td>\n");
      out.write("                                              <td class=\"CELDACAMPOFORM\" colspan=\"2\">\n");
      out.write("                                                  <input type=\"text\" id=\"txtCentroCostosP\" name=\"txtCentroCostosP\" value=\"");
      out.print(strCentroCostosP);
      out.write("\" class=\"CAMPOFORMREAD\" readonly />\n");
      out.write("                                              </td>                   \n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"LABELFORM\">Nombre del Ordenador del Gasto:</td>\n");
      out.write("                                              <td class=\"CELDACAMPOFORM\" colspan=\"3\">\n");
      out.write("                                                  <input type=\"text\" id=\"txtOrdenadorGasto\" name=\"txtOrdenadorGasto\" value=\"");
      out.print(strNombreOrdenadorG);
      out.write("\" class=\"CAMPOFORMREAD\" readonly />\n");
      out.write("                                              </td>                    \n");
      out.write("                                              <td class=\"LABELFORM\">Cargo del Ordenador del Gasto:</td>\n");
      out.write("                                              <td class=\"CELDACAMPOFORM\" colspan=\"2\">\n");
      out.write("                                                  <input type=\"text\" id=\"txtCargoOrdenadorGasto\" name=\"txtCargoOrdenadorGasto\" value=\"");
      out.print(strCargoOrdenadorG);
      out.write("\" class=\"CAMPOFORMREAD\" readonly />\n");
      out.write("                                              </td>                               \n");
      out.write("                                        </tr>                   \n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"LABELFORM\">Observación:</td>\n");
      out.write("                                            <td class=\"CELDACAMPOFORM\" colspan=\"4\">\n");
      out.write("                                                  <input type=\"text\" id=\"txtObservacion\" name=\"txtObservacion\" value=\"");
      out.print(strObservacion);
      out.write("\" class=\"CAMPOFORMREAD\" style=\"width: 100%;\" />\n");
      out.write("                                              </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                              <td colspan=\"7\" class=\"CELDABOTONFORM\">                                       \n");
      out.write("                                              </td>\n");
      out.write("                                          </tr>                             \n");
      out.write("                                    </table>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div>                                        \n");
      out.write("                    </div>                \n");
      out.write("                ");
}else{
      out.write("\n");
      out.write("                    <br /><br /><br /><br />\n");
      out.write("                    <div class=\"TEXTOFALLO\" style=\"font-size: 18px;\">\n");
      out.write("                        No se pudo obtener el consolidado de consumos para la cuenta de cobro especificada. Si requiere mayor información, póngase en contacto con Ingeniería de Software SIU.\n");
      out.write("                        <br/>Para cerrar esta ventana, utiliza el botón \"X\" ubicado en la esquina superior derecha de tu navegador.\n");
      out.write("                    </div>\n");
      out.write("                    <br /><br />\n");
      out.write("                ");
}
      out.write("\n");
      out.write("           </article>\n");
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
