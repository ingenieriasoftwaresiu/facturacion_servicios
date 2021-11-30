package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.math.RoundingMode;
import java.util.Vector;
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

public final class detalladoConsumos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    String strIdCuentaCobro=null, strIdServicioBase="",strIdServicio="", strIdSubservicio="", strNombreServicio="", strNombreSubservicio="", strConceptoConsumo="";
    String strFechaInicio="", strFechaFin="", strTipoFacturacion="", strAplicaSubcantidad="", strEtiquetaSubcantidad="", strCantidadConsumo;
    String strAplicaSancion="N", strPorcentajeSancion="", strNombreItemAdicional=null, strValorItemAdicional=null, strConceptoDescuento=null, strPorcentajeDescuento=null;
    String strEsAuxProy="N";
    Long lgIdCuentaCobro = null;
    Date dtFechaConsumo= null;
    Integer intSubcantidadConsumo=0, intCodigoConsumo=null;
    BigDecimal bdTotalServicio = null, bdTotalSubservicio=null, bdTotalPagar=new BigDecimal(0), bdCantidadConsumo=null, bdValorDescuento=null;
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
    Vector arrRoles = null;
    final RoundingMode roundingMode = RoundingMode.CEILING;
            
    strIdCuentaCobro = request.getParameter("keyCC");
    arrRoles = (Vector) session.getAttribute("rolesUsuario");

    if (arrRoles != null){
        if (arrRoles.contains("AUXPROY")){
            strEsAuxProy="S";
        }             
    }       

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
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/comunes.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/detalleCuentaCobro.js\"></script>\n");
      out.write("        <title>Detallado de consumos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <header>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("       </header>\n");
      out.write("       <section>\n");
      out.write("           <article>\n");
      out.write("               ");
if(detallesCuentaCobro != null){
      out.write("                           \n");
      out.write("                        <div align=\"center\">                    \n");
      out.write("                            <br />\n");
      out.write("                            <div id=\"noprint\">                            \n");
      out.write("                                <form id=\"frmAcciones\" method=\"POST\" action=\"#\">\n");
      out.write("                                    <input type=\"hidden\" id=\"txtEsAuxProy\" name=\"txtEsAuxProy\" value=\"");
      out.print(strEsAuxProy);
      out.write("\" />                                    \n");
      out.write("                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\"style=\"width: 99%;\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td colspan=\"2\" class=\"TEXTOACCION\">                                                                                                     \n");
      out.write("                                            </td>\n");
      out.write("                                            <td colspan=\"2\" class=\"BOTONESACCION\">                                                                            \n");
      out.write("                                                <input type=\"button\" id=\"btnImprimirDetalle\" name=\"btnImprimirDetalle\" value=\"Imprimir\" class=\"BOTONFORM\" onclick=\"imprimirDetalle()\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                                <input type=\"button\" id=\"btnSalir\" name=\"btnSalir\" value=\"Salir\" class=\"BOTONFORM\" onclick=\"javascript:window.close()\" />                                    \n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                              </form>                          \n");
      out.write("                           </div>                     \n");
      out.write("                            <br />\n");
      out.write("                            <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"TABLAMAESTRO\" style=\"width: 99%;\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td class=\"TITULOFORM\" colspan=\"6\" style=\"border-bottom: 1px solid #116043;\">DETALLADO DE CONSUMOS DE LA CUENTA DE COBRO #");
      out.print(strIdCuentaCobro);
      out.write(" PARA EL PERIODO ");
      out.print(strFechaInicio);
      out.write(" A ");
      out.print(strFechaFin);
      out.write("</td>\n");
      out.write("                                </tr>                           \n");
      out.write("                                <tr>\n");
      out.write("                                    <td colspan=\"6\">\n");
      out.write("                                        <table cellspacing=\"0\" cellpadding=\"3\" border=\"0\" style=\"width: 100%;\">                                            \n");
      out.write("                                            ");
for(DetalleCuentaCobro detalleCuentaCobro: detallesCuentaCobro){
      out.write("                       \n");
      out.write("                                                ");
strIdServicio = detalleCuentaCobro.getServicio();
      out.write("\n");
      out.write("                                                ");
if(!(strIdServicio.equals(strIdServicioBase))){
                                                    strNombreServicio = funcionesComunesConsumosDAO.obtenerServicio(strIdServicio);       
                                                    bdTotalServicio = detalleCuentaCobroDAO.obtenerTotalPorServicioYCuentaCobro(lgIdCuentaCobro, strIdServicio);                                    
                                                
      out.write("\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td class=\"CATEGORIASERVICIO\" style=\"width: 80%;border-right: 1px solid #116043;border-top: 1px solid #116043;\" colspan=\"3\">");
      out.print(strNombreServicio);
      out.write("</td>\n");
      out.write("                                                        <!--<td class=\"CATEGORIASERVICIO\" style=\"border-bottom: 1px solid #116043;border-right: 1px solid #116043;width: 10%;\"></td>-->\n");
      out.write("                                                        <td class=\"CATEGORIASERVICIO\" style=\"text-align: center;width: 10%;border-top: 1px solid #116043;\">$");
      out.print(funcionesComunesDAO.marcarMiles(bdTotalServicio.toString()));
      out.write("</td>\n");
      out.write("                                                    </tr>        \n");
      out.write("                                                    ");

                                                        detallesSubservicios = detalleCuentaCobroDAO.obtenerTodosPorServicioYCuentaCobro(lgIdCuentaCobro, strIdServicio);
                                                        if (detallesSubservicios != null){
                                                            for(DetalleCuentaCobro detalleSubservicios: detallesSubservicios){
                                                               strIdSubservicio = detalleSubservicios.getSubservicio();                                                                                                   
                                                               bdTotalSubservicio = detalleSubservicios.getTotalAPagar();
                                                               dtFechaConsumo = detalleSubservicios.getFechaConsumo();
                                                               intCodigoConsumo = detalleSubservicios.getCodigoConsumo();
                                                               subservicio = subservicioDAO.obtenerUno(strIdSubservicio);
                                                               strNombreSubservicio = subservicio.getNombre();
                                                               strTipoFacturacion = subservicio.getTipoFacturacion();                                             
                                                               strAplicaSubcantidad = subservicio.getAplicaSubcantidad();
      out.write("                        \n");
      out.write("                                                               \n");
      out.write("                                                               <tr>\n");
      out.write("                                                                    <td colspan=\"3\" class=\"SUBCATEGORIASUBSERVICIO\" style=\"padding-left: 10px;border-right: 1px solid #116043;border-top: 1px solid #116043;\">");
      out.print(strNombreSubservicio);
      out.write("</td>\n");
      out.write("                                                                    <td class=\"SUBCATEGORIASUBSERVICIO\" style=\"text-align: center;border-top: 1px solid #116043;\">$");
      out.print(funcionesComunesDAO.marcarMiles(bdTotalSubservicio.toString()));
      out.write("</td>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                \n");
      out.write("                                                               ");
if (strTipoFacturacion.equals("INSUMOS")){                                                      
                                                                    consumosServicioXInsumo = consumoServicioXInsumoDAO.obtenerConsumosPorServicioSubservicioCuentaCobro(strIdServicio, strIdSubservicio, lgIdCuentaCobro);
      out.write("                                                                   \n");
      out.write("                                                                    <tr>\n");
      out.write("                                                                        <td colspan=\"4\">\n");
      out.write("                                                                            <br />\n");
      out.write("                                                                            <div align=\"center\">\n");
      out.write("                                                                                <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"TABLACONSUMOS\">                   \n");
      out.write("                                                                                    <tr>\n");
      out.write("                                                                                        <td colspan=\"3\" class=\"TITULOFORM\">DETALLE DE CONSUMOS</td>\n");
      out.write("                                                                                    </tr>\n");
      out.write("                                                                                    <tr>\n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Nombre del insumo</td>\n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Cantidad consumida</td>\n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Fecha del consumo&nbsp;(aaaa-mm-dd)</td>                                                      \n");
      out.write("                                                                                    </tr>\n");
      out.write("                                                                                        ");
for(ConsumoServicioXInsumo consumoServicioXInsumo : consumosServicioXInsumo){
                                                                                                intSubcantidadConsumo = consumoServicioXInsumo.getSubcantidad();
                                                                                                bdCantidadConsumo = consumoServicioXInsumo.getCantidadUnidad();
      out.write("\n");
      out.write("                                                                                                <tr>\n");
      out.write("                                                                                                    <td class=\"TEXTOCONSUMO\" style=\"border-right: 1px solid #116043;\">");
      out.print(funcionesComunesConsumosDAO.obtenerInsumo(consumoServicioXInsumo.getInsumo()));
      out.write("</td>\n");
      out.write("                                                                                                    ");
if (funcionesComunesDAO.tieneDecimales(bdCantidadConsumo)){
      out.write("\n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(bdCantidadConsumo.setScale(2, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXInsumo.getUnidadMedida()));
      out.write("</td>\n");
      out.write("                                                                                                     ");
}else{
      out.write("\n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(bdCantidadConsumo.setScale(0, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXInsumo.getUnidadMedida()));
      out.write("</td>\n");
      out.write("                                                                                                     ");
}
      out.write("\n");
      out.write("                                                                                                    <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">");
      out.print(consumoServicioXInsumo.getFechaConsumo().toString());
      out.write("</td>                                                      \n");
      out.write("                                                                                                </tr>\n");
      out.write("                                                                                        ");

                                                                                                bdCantidadConsumo = null;                                                                                                
                                                                                            }
                                                                                        
                                                                                            if (strAplicaSubcantidad.equals("S")){
                                                                                                 strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();
      out.write("\n");
      out.write("                                                                                                 <tr>\n");
      out.write("                                                                                                     <td colspan=\"3\" class=\"TEXTONOTAS\">* ");
      out.print(strEtiquetaSubcantidad);
      out.write(":&nbsp;");
      out.print(intSubcantidadConsumo.toString());
      out.write(".</td>\n");
      out.write("                                                                                                 </tr>\n");
      out.write("                                                                                            ");
} 
                                                                                        
      out.write("\n");
      out.write("                                                                                </table>\n");
      out.write("                                                                            </div>\n");
      out.write("                                                                            <br />\n");
      out.write("                                                                        </td>                                                                       \n");
      out.write("                                                                    </tr>\n");
      out.write("                                                               ");
}
                                                                                                                               
                                                              if (strTipoFacturacion.equals("TIPOUSUARI")){                            
                                                                   consumosServicioXTipoUsuario = consumoServicioXTipoUsuarioDAO.obtenerConsumosPorServicioSubservicioCuentaCobroCodigo(strIdServicio, strIdSubservicio, lgIdCuentaCobro, intCodigoConsumo);
      out.write("\n");
      out.write("                                                                   <tr>\n");
      out.write("                                                                        <td colspan=\"4\">\n");
      out.write("                                                                            <br />\n");
      out.write("                                                                            <div align=\"center\">\n");
      out.write("                                                                                <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"TABLACONSUMOS\">                   \n");
      out.write("                                                                                    <tr>\n");
      out.write("                                                                                        <td colspan=\"4\" class=\"TITULOFORM\">DETALLE DE CONSUMOS</td>\n");
      out.write("                                                                                    </tr>\n");
      out.write("                                                                                    <tr>\n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Tipo de usuario</td>\n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Cantidad consumida</td>\n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Fecha del consumo&nbsp;(aaaa-mm-dd)</td>                                                      \n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Concepto</td>\n");
      out.write("                                                                                    </tr>                                                                   \n");
      out.write("                                                                                        ");
for(ConsumoServicioXTipoUsuario consumoServicioXTipoUsuario : consumosServicioXTipoUsuario){                                                                                           
                                                                                            strConceptoConsumo = consumoServicioXTipoUsuario.getConcepto();
                                                                                            strCantidadConsumo = consumoServicioXTipoUsuario.getCantidadUnidad().toString() + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXTipoUsuario.getUnidadMedida());
      out.write("\n");
      out.write("                                                                                            \n");
      out.write("                                                                                            <tr>\n");
      out.write("                                                                                                <td class=\"TEXTOCONSUMO\" style=\"border-right: 1px solid #116043;\">");
      out.print(funcionesComunesConsumosDAO.obtenerTipoUsuario(consumoServicioXTipoUsuario.getTipoUsuario()));
      out.write("</td>\n");
      out.write("                                                                                                <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(strCantidadConsumo);
      out.write("</td>\n");
      out.write("                                                                                                <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(consumoServicioXTipoUsuario.getFechaConsumo().toString());
      out.write("</td>                                                      \n");
      out.write("                                                                                                ");
if(strConceptoConsumo.equals("")){
      out.write("\n");
      out.write("                                                                                                    <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">-</td>\n");
      out.write("                                                                                                ");
}else{
      out.write("\n");
      out.write("                                                                                                    <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">");
      out.print(strConceptoConsumo);
      out.write("</td>\n");
      out.write("                                                                                                ");
}
      out.write("                                                                                                \n");
      out.write("                                                                                            </tr>\n");
      out.write("                                                                                           \n");
      out.write("                                                                                            ");
if (strAplicaSubcantidad.equals("S")){
                                                                                                 strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();            
                                                                                                 intSubcantidadConsumo = consumoServicioXTipoUsuario.getSubcantidad();
      out.write("\n");
      out.write("                                                                                                 <tr>\n");
      out.write("                                                                                                     <td colspan=\"4\" class=\"TEXTONOTAS\">* ");
      out.print(strEtiquetaSubcantidad);
      out.write(":&nbsp;");
      out.print(intSubcantidadConsumo.toString());
      out.write(".</td>\n");
      out.write("                                                                                                 </tr>\n");
      out.write("                                                                                            ");
}

                                                                                            strAplicaSancion = consumoServicioXTipoUsuario.getAplicarSancion();

                                                                                            if (strAplicaSancion.equals("S")){                                                                                               
                                                                                                parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
                                                                                                strPorcentajeSancion = String.valueOf(parametroGeneral.getPorcentajeSancion());
      out.write("\n");
      out.write("                                                                                                <tr>\n");
      out.write("                                                                                                     <td colspan=\"4\" class=\"TEXTONOTAS\">* A este consumo le aplica una sanción del ");
      out.print(strPorcentajeSancion);
      out.write("%.</td>\n");
      out.write("                                                                                                </tr>                                                                                                \n");
      out.write("                                                                                      ");
}
      out.write("\n");
      out.write("                                                                                            \n");
      out.write("                                                                                </table>\n");
      out.write("                                                                                <br/>\n");
      out.write("                                                                                        ");
consumosAdicionales = consumoAdicionalXTipoUsuarioDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                                            if ((consumosAdicionales != null) && (consumosAdicionales.size() > 0)){
      out.write("                                                                                    \n");
      out.write("                                                                                                <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"TABLACONSUMOS\">                   \n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td colspan=\"3\" class=\"TITULOFORM\">DETALLE CONSUMO ADICIONAL</td>\n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Ítem adicional</td>\n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Valor ($)</td>\n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Fecha &nbsp;(aaaa-mm-dd)</td>                                                                                                                             \n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                ");
for (ConsumoAdicional consumoAdicional : consumosAdicionales){
                                                                                                    strNombreItemAdicional = itemAdicionalDAO.obtenerUno(consumoAdicional.getItemAdicional()).getNombre();
                                                                                                    strValorItemAdicional = funcionesComunesDAO.marcarMiles(consumoAdicional.getValorUnidad().toString());
      out.write("\n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"border-right: 1px solid #116043;\">");
      out.print(strNombreItemAdicional);
      out.write("</td>\n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(strValorItemAdicional);
      out.write("</td>\n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">");
      out.print(consumoAdicional.getFechaConsumo());
      out.write("</td>                                                      \n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                ");
}
      out.write("\n");
      out.write("                                                                                                </table>\n");
      out.write("                                                                                                <br/>\n");
      out.write("                                                                                            ");
}

                                                                                            descuentoConsumo = descuentoConsumoXTipoUsuarioDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                                            if (descuentoConsumo != null){
      out.write("                                                                                \n");
      out.write("                                                                                                <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"TABLACONSUMOS\">                   \n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td colspan=\"3\" class=\"TITULOFORM\">DETALLE DESCUENTO</td>\n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Valor del descuento</td>                                                                                                  \n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Fecha &nbsp;(aaaa-mm-dd)</td>               \n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Concepto</td>\n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                               ");
strConceptoDescuento = descuentoConsumo.getConcepto();
                                                                                                strPorcentajeDescuento = String.valueOf(descuentoConsumo.getDescuento());
                                                                                                bdValorDescuento = new BigDecimal(strPorcentajeDescuento);
      out.write("\n");
      out.write("                                                                                                \n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        ");
if(funcionesComunesDAO.tieneDecimales(bdValorDescuento)){
      out.write("\n");
      out.write("                                                                                                            <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(bdValorDescuento.setScale(2,roundingMode));
      out.write("%</td>\n");
      out.write("                                                                                                        ");
}else{
      out.write("\n");
      out.write("                                                                                                            <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(bdValorDescuento.setScale(0,roundingMode));
      out.write("%</td>\n");
      out.write("                                                                                                        ");
}
      out.write("                                                                                                        \n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(descuentoConsumo.getFechaRegistra());
      out.write("</td>\n");
      out.write("                                                                                                        ");
if(strConceptoDescuento.equals("")){
      out.write("\n");
      out.write("                                                                                                            <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">-</td>\n");
      out.write("                                                                                                        ");
}else{
      out.write("\n");
      out.write("                                                                                                            <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">");
      out.print(strConceptoDescuento);
      out.write("</td>\n");
      out.write("                                                                                                        ");
}
      out.write("                                                                                                                                                              \n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                </table>\n");
      out.write("                                                                                                <br/>\n");
      out.write("                                                                                            ");
}           
                                                                                            bdValorDescuento = null;
                                                                                        }
      out.write("\n");
      out.write("                                                                            </div>                 \n");
      out.write("                                                                        </td>                                                                       \n");
      out.write("                                                                    </tr>\n");
      out.write("                                                               ");
}

                                                               if (strTipoFacturacion.equals("UNDS")){
                                                                   consumosServicioXUnidad= consumoServicioXUnidadDAO.obtenerConsumosPorServicioSubservicioCuentaCobro(strIdServicio, strIdSubservicio, lgIdCuentaCobro);
      out.write("\n");
      out.write("                                                                   <tr>\n");
      out.write("                                                                        <td colspan=\"4\">\n");
      out.write("                                                                            <br />\n");
      out.write("                                                                            <div align=\"center\">\n");
      out.write("                                                                                <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"TABLACONSUMOS\">                   \n");
      out.write("                                                                                    <tr>\n");
      out.write("                                                                                        <td colspan=\"3\" class=\"TITULOFORM\">DETALLE DE CONSUMOS</td>\n");
      out.write("                                                                                    </tr>\n");
      out.write("                                                                                    <tr>                                                        \n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Cantidad consumida</td>\n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Fecha del consumo&nbsp;(aaaa-mm-dd)</td>                                                      \n");
      out.write("                                                                                        <td class=\"SUBTITULOFORM\">Concepto</td>\n");
      out.write("                                                                                    </tr>\n");
      out.write("                                                                                    ");
for(ConsumoServicioXUnidad consumoServicioXUnidad : consumosServicioXUnidad){
                                                                                           intCodigoConsumo = consumoServicioXUnidad.getCodigo();
                                                                                           strConceptoConsumo = consumoServicioXUnidad.getConcepto();                                                                                           
                                                                                           bdCantidadConsumo = consumoServicioXUnidad.getCantidadUnidad();
      out.write("\n");
      out.write("                                                                                            <tr>                                    \n");
      out.write("                                                                                                ");
if (funcionesComunesDAO.tieneDecimales(bdCantidadConsumo)){
      out.write("\n");
      out.write("                                                                                                    <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(bdCantidadConsumo.setScale(2, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXUnidad.getUnidadMedida()));
      out.write("</td>\n");
      out.write("                                                                                                ");
}else{
      out.write("\n");
      out.write("                                                                                                    <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(bdCantidadConsumo.setScale(0, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXUnidad.getUnidadMedida()));
      out.write("</td>\n");
      out.write("                                                                                                ");
}
      out.write("\n");
      out.write("                                                                                                <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(consumoServicioXUnidad.getFechaConsumo().toString());
      out.write("</td>                                                      \n");
      out.write("                                                                                                ");
if(consumoServicioXUnidad.getConcepto().equals("")){
      out.write("\n");
      out.write("                                                                                                    <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">-</td>\n");
      out.write("                                                                                                ");
}else{
      out.write("\n");
      out.write("                                                                                                    <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">");
      out.print(consumoServicioXUnidad.getConcepto());
      out.write("</td>\n");
      out.write("                                                                                                ");
}
      out.write("                                                                                                 \n");
      out.write("                                                                                            </tr>\n");
      out.write("                                                                                </table>\n");
      out.write("                                                                                <br/>\n");
      out.write("\n");
      out.write("                                                                                    ");
consumosAdicionales = consumoAdicionalXUnidadDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                                           if ((consumosAdicionales != null) && (consumosAdicionales.size() > 0)){
      out.write("\n");
      out.write("                                                                                                 <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"TABLACONSUMOS\">                   \n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td colspan=\"3\" class=\"TITULOFORM\">DETALLE CONSUMO ADICIONAL</td>\n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Ítem adicional</td>\n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Valor ($)</td>\n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Fecha &nbsp;(aaaa-mm-dd)</td>                                                                                                                             \n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                              ");
for (ConsumoAdicional consumoAdicional : consumosAdicionales){
                                                                                                   strNombreItemAdicional = itemAdicionalDAO.obtenerUno(consumoAdicional.getItemAdicional()).getNombre();
                                                                                                   strValorItemAdicional = funcionesComunesDAO.marcarMiles(consumoAdicional.getValorUnidad().toString());
      out.write("\n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"border-right: 1px solid #116043;\">");
      out.print(strNombreItemAdicional);
      out.write("</td>\n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(strValorItemAdicional);
      out.write("</td>\n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">");
      out.print(consumoAdicional.getFechaConsumo());
      out.write("</td>                                                      \n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                ");
}
      out.write("\n");
      out.write("                                                                                                </table>\n");
      out.write("                                                                                                <br/>\n");
      out.write("                                                                                           ");
}

                                                                                           descuentoConsumo = descuentoConsumoXUnidadDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                                           if (descuentoConsumo != null){
      out.write("                                                                                \n");
      out.write("                                                                                                <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"TABLACONSUMOS\">                   \n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td colspan=\"3\" class=\"TITULOFORM\">DETALLE DESCUENTO</td>\n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Valor del descuento</td>                                                                                                  \n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Fecha &nbsp;(aaaa-mm-dd)</td>               \n");
      out.write("                                                                                                        <td class=\"SUBTITULOFORM\">Concepto</td>\n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                               ");
strConceptoDescuento = descuentoConsumo.getConcepto();
                                                                                                strPorcentajeDescuento = String.valueOf(descuentoConsumo.getDescuento());
                                                                                                bdValorDescuento = new BigDecimal(strPorcentajeDescuento);
      out.write("\n");
      out.write("                                                                                                    <tr>\n");
      out.write("                                                                                                        ");
if(funcionesComunesDAO.tieneDecimales(bdValorDescuento)){
      out.write("\n");
      out.write("                                                                                                            <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(bdValorDescuento.setScale(2,roundingMode));
      out.write("%</td>\n");
      out.write("                                                                                                        ");
}else{
      out.write("\n");
      out.write("                                                                                                            <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(bdValorDescuento.setScale(0,roundingMode));
      out.write("%</td>\n");
      out.write("                                                                                                        ");
}
      out.write("                                                                                                        \n");
      out.write("                                                                                                        <td class=\"TEXTOCONSUMO\" style=\"text-align: center;border-right: 1px solid #116043;\">");
      out.print(descuentoConsumo.getFechaRegistra());
      out.write("</td>\n");
      out.write("                                                                                                        ");
if(strConceptoDescuento.equals("")){
      out.write("\n");
      out.write("                                                                                                            <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">-</td>\n");
      out.write("                                                                                                        ");
}else{
      out.write("\n");
      out.write("                                                                                                            <td class=\"TEXTOCONSUMO\" style=\"text-align: center;\">");
      out.print(strConceptoDescuento);
      out.write("</td>\n");
      out.write("                                                                                                        ");
}
      out.write("     \n");
      out.write("                                                                                                    </tr>\n");
      out.write("                                                                                                </table>\n");
      out.write("                                                                                                <br/>\n");
      out.write("                                                                                    ");
}                   
                                                                                           bdCantidadConsumo =  null;
                                                                                           bdValorDescuento = null;
                                                                                        }
      out.write("\n");
      out.write("                                                                            </div>                 \n");
      out.write("                                                                        </td>                                                                       \n");
      out.write("                                                                    </tr>\n");
      out.write("                                                            ");
}                                                                                             
                                                                                                        
                                                                strIdSubservicio = null;
                                                                strNombreSubservicio = null;                                         
                                                                bdTotalSubservicio = null;
                                                                detalleSubservicios = null;
                                                                subservicio = null;
                                                                strTipoFacturacion = null;
                                                                dtFechaConsumo = null;
                                                                consumosServicioXInsumo = null;
                                                                intSubcantidadConsumo = null;                         
                                                                strPorcentajeSancion = null;
                                                                parametroGeneral = null;
                                                                strAplicaSancion = "N";
                                                                consumosAdicionales = null;
                                                                strNombreItemAdicional = null;
                                                                strValorItemAdicional = null;                               
                                                                strPorcentajeDescuento = null;
                                                                descuentoConsumo = null;
                                                            }
                                                        }
                                                    
      out.write("\n");
      out.write("                                                ");

                                                        bdTotalPagar = bdTotalPagar.add(bdTotalServicio);
                                                    }

                                                    strIdServicioBase = strIdServicio;
                                                    strIdServicio = "";
                                                    strNombreServicio = null;
                                                    bdTotalServicio = null;                    
                                                    detalleCuentaCobro = null;
                                                
      out.write("                    \n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td colspan=\"3\" class=\"CATEGORIATOTAL\" style=\"text-align: left;border-right: 1px solid #116043;border-top: 1px solid #116043;\">TOTAL POR CONSUMOS DE SERVICIOS / SUBSERVICIOS</td>\n");
      out.write("                                                <td class=\"CATEGORIATOTAL\" style=\"text-align: center;border-top: 1px solid #116043;\">$");
      out.print(funcionesComunesDAO.marcarMiles(bdTotalPagar.toString()));
      out.write("</td>\n");
      out.write("                                            </tr>                            \n");
      out.write("                                            <tr>\n");
      out.write("                                                <td class=\"MSGAVISOOBLG\" colspan=\"4\">* Los valores de dinero relacionados en la tabla anterior se especifican en pesos colombianos ($).</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </table>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>                            \n");
      out.write("                            </table>                              \n");
      out.write("                        </div>                \n");
      out.write("                    ");
}else{
      out.write("\n");
      out.write("                        <br /><br /><br /><br />\n");
      out.write("                        <div class=\"TEXTOFALLO\" style=\"font-size: 18px;\">\n");
      out.write("                            No se pudo obtener el detalladp de consumos para la cuenta de cobro especificada.<br />Si requiere mayor información, póngase en contacto con Ingeniería de Software SIU.<br /><br />\n");
      out.write("                            <input type=\"button\" value=\"Salir\" class=\"BOTONFORM\" onclick=\"javascript:window.close()\" />\n");
      out.write("                        </div>\n");
      out.write("                        <br /><br />\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("            </article>\n");
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
