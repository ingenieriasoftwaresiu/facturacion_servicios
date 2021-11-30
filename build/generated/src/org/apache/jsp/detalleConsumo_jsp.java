package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.impl.ItemAdicionalDAOImpl;
import co.edu.udea.facturacion.dao.ItemAdicionalDAO;
import co.edu.udea.facturacion.dto.ItemAdicional;
import co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.ConsumoAdicionalXUnidadDAO;
import co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.ConsumoAdicionalXTipoUsuarioDAO;
import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.dao.impl.DescuentoConsumoXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
import co.edu.udea.facturacion.dao.impl.DescuentoConsumoXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.DescuentoConsumoXTipoUsuarioDAO;
import java.math.RoundingMode;
import co.edu.udea.facturacion.dto.TipoUsuario;
import co.edu.udea.facturacion.dao.impl.TipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.TipoUsuarioDAO;
import java.math.BigDecimal;
import java.util.Date;
import co.edu.udea.facturacion.dto.UsuarioConsumoSIU;
import java.util.List;
import co.edu.udea.facturacion.dao.impl.UsuarioConsumoSIUDAOImpl;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl;
import co.edu.udea.facturacion.dao.UsuarioSIUDAO;
import co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO;
import co.edu.udea.facturacion.exception.GIDaoException;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesConsumosDAOImpl;
import co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO;
import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.ConsumoServicioXUnidadDAO;
import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.ConsumoServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO;

public final class detalleConsumo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "comprobarSesion.jsp", out, false);
      out.write('\n');

    String strTipoConsumo = null, strFechaRegistro=null, strIdUsuarioRegistra=null, strUsuarioRegistra=null, strIdServicio=null, strServicio=null, strIdSubservicio=null, strSubservicio=null, strIdTipoUsuarioConsumo=null;
    String strTipoUsuarioConsumo=null, strIdUsuarioConsumo=null, strUsuarioConsumo=null, strIdInsumo=null, strInsumo=null, strIdUnidadMedida=null, strUnidadMedida=null, strIdTipoUsuario=null, strConcepto=null;
    String strSeFactura=null, strFacturado=null, strTieneDescuento="N", strTieneConsumoAdicional="N", strIdItemAdicional=null, strSeFacturaConsumoAdicional=null, strFacturadoConsumoAdicional=null;
    String strSeFacturaDescuento=null, strFacturadoDescuento=null, strAplicaSubcantidad=null, strEtiquetaSubcantidad=null, strAplicaPorcentajeSancion=null, strAplicaSancion=null;
    Integer intConsecutivo = null, intSubcantidad=0, intCodigoDescuento=null, intCodigoConsumoAdicional=null;
    Date dtFechaConsumo = null, dtFechaFacturacion=null, dtFechaConsumoAdicional=null, dtFechaFacturacionConsumoA=null, dtFechaDescuento=null, dtFechaAplicacion=null;
    BigDecimal bgCantidadConsumida = null;
    List<TipoUsuario> tiposUsuario = null;
    final RoundingMode roundingMode = RoundingMode.CEILING;
    DescuentoConsumo descuentoConsumo = null;
    List<ConsumoAdicional> consumosAdicionales = null;
    List<ItemAdicional> itemsAdicionales = null;
    Long lgValorUnidad = null, lgCuentaCobro = null;
    Boolean haySesion = Boolean.TRUE;
    
    if (session.getAttribute("Usuario") == null){
        haySesion = Boolean.FALSE;
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{  
         
         FuncionesComunesConsumosDAO funcionesComunesConsumosDAO = new FuncionesComunesConsumosDAOImpl();
         UsuarioSIUDAO usuarioSUIDAO = new UsuarioSIUDAOImpl();
         UsuarioSesionSIU usuarioSesionSIU =null;
         TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAOImpl();
         DescuentoConsumoXTipoUsuarioDAO descuentoConsumoXtipoUsuarioDAO = new DescuentoConsumoXTipoUsuarioDAOImpl();
         DescuentoConsumoXUnidadDAO descuentoConsumoXunidadDAO = new DescuentoConsumoXUnidadDAOImpl();         
         ConsumoAdicionalXTipoUsuarioDAO consumoAdicionalXtipoUsuarioDAO = new ConsumoAdicionalXTipoUsuarioDAOImpl();
         ConsumoAdicionalXUnidadDAO consumoAdicionalXunidadDAO = new ConsumoAdicionalXUnidadDAOImpl();
         ItemAdicionalDAO itemAdicionalDAO = new ItemAdicionalDAOImpl();
         SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
         Subservicio subservicio = null;
         
         intConsecutivo = Integer.parseInt(request.getParameter("txtConsecutivo"));
         strTipoConsumo = request.getParameter("txtTipoConsumo");
         
         if (strTipoConsumo.equals("consumos_insumos")){
             ConsumoServicioXInsumoDAO consumoServicioXinsumoDAO = new ConsumoServicioXInsumoDAOImpl();
             ConsumoServicioXInsumo consumoServicioXInsumo = null;
             
             try{
                 consumoServicioXInsumo = consumoServicioXinsumoDAO.obtenerUno(intConsecutivo);
                 
                 strFechaRegistro = consumoServicioXInsumo.getFechaRegistra().toString();
                 strIdUsuarioRegistra = consumoServicioXInsumo.getUsuarioRegistra();                 
                 strIdServicio = consumoServicioXInsumo.getServicio();
                 strIdSubservicio = consumoServicioXInsumo.getSubservicio();
                 strIdTipoUsuarioConsumo = consumoServicioXInsumo.getTipoUsuarioConsumo();
                 strIdUsuarioConsumo = consumoServicioXInsumo.getUsuario();
                 dtFechaConsumo = consumoServicioXInsumo.getFechaConsumo();
                 strIdInsumo = consumoServicioXInsumo.getInsumo();
                 strInsumo = funcionesComunesConsumosDAO.obtenerInsumo(strIdInsumo);
                 strIdUnidadMedida = consumoServicioXInsumo.getUnidadMedida();
                 bgCantidadConsumida = consumoServicioXInsumo.getCantidadUnidad();
                 strSeFactura = consumoServicioXInsumo.getSeFactura();
                 strFacturado = consumoServicioXInsumo.getFacturado();
                 dtFechaFacturacion = consumoServicioXInsumo.getFechaFacturacion();
                 lgCuentaCobro = consumoServicioXInsumo.getCuentaCobro();
                 intSubcantidad = consumoServicioXInsumo.getSubcantidad();
                 
                 subservicio = subservicioDAO.obtenerPorServicioSubservicio(strIdServicio, strIdSubservicio);
                 strAplicaSubcantidad = subservicio.getAplicaSubcantidad();
                 
                 if (strAplicaSubcantidad.equals("S")){
                     strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();
                 }
                 
             }catch(GIDaoException e){
                 new GIDaoException("Se generó un error al recuperar el consumo por insumo con consecutivo " + intConsecutivo,e);
             }
         }
         
         if (strTipoConsumo.equals("consumos_tipos_usuario")){
             ConsumoServicioXTipoUsuarioDAO consumoServicioXtipoUsuarioDAO = new ConsumoServicioXTipoUsuarioDAOImpl();
             ConsumoServicioXTipoUsuario consumoServicioXtipoUsuario = null;
             
             try{
                 consumoServicioXtipoUsuario = consumoServicioXtipoUsuarioDAO.obtenerUno(intConsecutivo);
                 
                 strFechaRegistro = consumoServicioXtipoUsuario.getFechaRegistra().toString();
                 strIdUsuarioRegistra = consumoServicioXtipoUsuario.getUsuarioRegistra();                 
                 strIdServicio = consumoServicioXtipoUsuario.getServicio();
                 strIdSubservicio = consumoServicioXtipoUsuario.getSubservicio();
                 strIdTipoUsuarioConsumo = consumoServicioXtipoUsuario.getTipoUsuarioConsumo();
                 strIdUsuarioConsumo = consumoServicioXtipoUsuario.getUsuario();
                 dtFechaConsumo = consumoServicioXtipoUsuario.getFechaConsumo();
                 strIdUnidadMedida = consumoServicioXtipoUsuario.getUnidadMedida();
                 bgCantidadConsumida = new BigDecimal(consumoServicioXtipoUsuario.getCantidadUnidad());
                 strIdTipoUsuario = consumoServicioXtipoUsuario.getTipoUsuario();
                 intSubcantidad = consumoServicioXtipoUsuario.getSubcantidad();
                 strConcepto = consumoServicioXtipoUsuario.getConcepto();
                 strSeFactura = consumoServicioXtipoUsuario.getSeFactura();
                 strFacturado = consumoServicioXtipoUsuario.getFacturado();
                 dtFechaFacturacion = consumoServicioXtipoUsuario.getFechaFacturacion();
                 lgCuentaCobro = consumoServicioXtipoUsuario.getCuentaCobro();
                                  
                 tiposUsuario = tipoUsuarioDAO.obtenerTodos();
                 subservicio = subservicioDAO.obtenerPorServicioSubservicio(strIdServicio, strIdSubservicio);
                 strAplicaSubcantidad = subservicio.getAplicaSubcantidad();
                 
                 if (strAplicaSubcantidad.equals("S")){
                     strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();
                 }
                 
                 strAplicaPorcentajeSancion = subservicio.getAplicaPorcentajeSancion();
                 
                  if (strAplicaPorcentajeSancion.equals("S")){
                     strAplicaSancion = consumoServicioXtipoUsuario.getAplicarSancion();
                 }else{
                      strAplicaSancion = "N";
                  }
                                       
                 descuentoConsumo = descuentoConsumoXtipoUsuarioDAO.obtenerPorConsumo(intConsecutivo);                                                 
                 consumosAdicionales = consumoAdicionalXtipoUsuarioDAO.obtenerPorConsumo(intConsecutivo);
                                                  
             }catch(GIDaoException e){
                 new GIDaoException("Se generó un error al recuperar el consumo por tipo de usuario con consecutivo " + intConsecutivo,e);
             }
         }
         
         if (strTipoConsumo.equals("consumos_unidades")){
             ConsumoServicioXUnidadDAO consumoServicioXunidadDAO = new ConsumoServicioXUnidadDAOImpl();
             ConsumoServicioXUnidad consumoServicioXunidad = null;
             
             try{
                 consumoServicioXunidad = consumoServicioXunidadDAO.obtenerUno(intConsecutivo);
                 
                 strFechaRegistro = consumoServicioXunidad.getFechaRegistra().toString();
                 strIdUsuarioRegistra = consumoServicioXunidad.getUsuarioRegistra();                 
                 strIdServicio = consumoServicioXunidad.getServicio();
                 strIdSubservicio = consumoServicioXunidad.getSubservicio();
                 strIdTipoUsuarioConsumo = consumoServicioXunidad.getTipoUsuarioConsumo();
                 strIdUsuarioConsumo = consumoServicioXunidad.getUsuario();
                 dtFechaConsumo = consumoServicioXunidad.getFechaConsumo();
                 strIdUnidadMedida = consumoServicioXunidad.getUnidadMedida();
                 bgCantidadConsumida = consumoServicioXunidad.getCantidadUnidad();
                 bgCantidadConsumida = bgCantidadConsumida.setScale(1, roundingMode);
                 strConcepto = consumoServicioXunidad.getConcepto();
                 strSeFactura = consumoServicioXunidad.getSeFactura();
                 strFacturado = consumoServicioXunidad.getFacturado();                 
                 dtFechaFacturacion = consumoServicioXunidad.getFechaFacturacion();
                 lgCuentaCobro = consumoServicioXunidad.getCuentaCobro();
                 
                 descuentoConsumo = descuentoConsumoXunidadDAO.obtenerPorConsumo(intConsecutivo);
                 consumosAdicionales = consumoAdicionalXunidadDAO.obtenerPorConsumo(intConsecutivo);               
                 
             }catch(GIDaoException e){
                 new GIDaoException("Se generó un error al recuperar el consumo por unidad con consecutivo " + intConsecutivo,e);
             }
         }
         
        usuarioSesionSIU = usuarioSUIDAO.obtenerInfoUsuario(strIdUsuarioRegistra);
        strUsuarioRegistra = usuarioSesionSIU.getUsuario();
        strServicio = funcionesComunesConsumosDAO.obtenerServicio(strIdServicio);
        strSubservicio = funcionesComunesConsumosDAO.obtenerSubservicio(strIdSubservicio);
        strTipoUsuarioConsumo = funcionesComunesConsumosDAO.obtenerTipoUsuarioConsumo(strIdTipoUsuarioConsumo);
        strUsuarioConsumo = funcionesComunesConsumosDAO.obtenerUsuario(strIdUsuarioConsumo, strIdTipoUsuarioConsumo);
        strUnidadMedida = funcionesComunesConsumosDAO.obtenerUnidadMedida(strIdUnidadMedida);
        
        if (descuentoConsumo != null){
           strTieneDescuento = "S";
           
           intCodigoDescuento = descuentoConsumo.getCodigo();
           strSeFacturaDescuento = descuentoConsumo.getSeFactura();
           strFacturadoDescuento = descuentoConsumo.getAplicado();
           dtFechaDescuento = descuentoConsumo.getFechaRegistra();
           dtFechaAplicacion = descuentoConsumo.getFechaAplicacion();
         }
        
        if (consumosAdicionales != null){
            if (consumosAdicionales.size() > 0){
                strTieneConsumoAdicional = "S";                     
                itemsAdicionales = itemAdicionalDAO.obtenerTodos();

                for (ConsumoAdicional consumoAdicional : consumosAdicionales){
                    intCodigoConsumoAdicional = consumoAdicional.getCodigo();
                    strIdItemAdicional = consumoAdicional.getItemAdicional();
                    lgValorUnidad = consumoAdicional.getValorUnidad();
                    dtFechaConsumoAdicional = consumoAdicional.getFechaConsumo();
                    strSeFacturaConsumoAdicional = consumoAdicional.getSeFactura();
                    strFacturadoConsumoAdicional = consumoAdicional.getFacturado();
                    dtFechaFacturacionConsumoA = consumoAdicional.getFechaFacturacion();
                }
            }
        }
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"SHORTCUT ICON\" href=\"Images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/forms.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/calendar-system.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar-es.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/JSCalendar-setup.js\"></script> \n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/ajax.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/comunes.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"UTF-8\" src=\"Scripts/detalleConsumo.js\"></script>\n");
      out.write("        <title>Detalle de consumo de servicio</title>        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("       </header>\n");
      out.write("       <section>\n");
      out.write("           <article>\n");
      out.write("               ");
if(haySesion){
      out.write("\n");
      out.write("                    <br />\n");
      out.write("                     <div align=\"center\">\n");
      out.write("                         <form id=\"frmIngresoConsumo\" name=\"frmIngresoConsumo\" method=\"POST\" action=\"ActualizarDetalleConsumo\" onsubmit=\"return validarActualizarConsumo()\">\n");
      out.write("                             <input type=\"hidden\" id=\"txtCodigo\" name=\"txtCodigo\" value=\"");
      out.print(intConsecutivo);
      out.write("\" />\n");
      out.write("                             <input type=\"hidden\" id=\"txtTipoConsumo\" name=\"txtTipoConsumo\" value=\"");
      out.print(strTipoConsumo);
      out.write("\" />\n");
      out.write("                             <input type=\"hidden\" id=\"txtTieneDescuento\" name=\"txtTieneDescuento\" value=\"");
      out.print(strTieneDescuento);
      out.write("\" />\n");
      out.write("                             <input type=\"hidden\" id=\"txtTieneConsumoAdicional\" name=\"txtTieneConsumoAdicional\" value=\"");
      out.print(strTieneConsumoAdicional);
      out.write("\" />\n");
      out.write("                             <input type=\"hidden\" id=\"txtIdUsuarioRegistra\" name=\"txtIdUsuarioRegistra\" value=\"");
      out.print(strIdUsuarioRegistra);
      out.write("\" />\n");
      out.write("                             <input type=\"hidden\" id=\"txtIdServicio\" name=\"txtIdServicio\" value=\"");
      out.print(strIdServicio);
      out.write("\" />\n");
      out.write("                             <input type=\"hidden\" id=\"txtIdSubservicio\" name=\"txtIdSubservicio\" value=\"");
      out.print(strIdSubservicio);
      out.write("\" />\n");
      out.write("                             <input type=\"hidden\" id=\"txtIdTipoUsuarioConsumo\" name=\"txtIdTipoUsuarioConsumo\" value=\"");
      out.print(strIdTipoUsuarioConsumo);
      out.write("\" />               \n");
      out.write("                             <input type=\"hidden\" id=\"txtIdUsuarioConsumo\" name=\"txtIdUsuarioConsumo\" value=\"");
      out.print(strIdUsuarioConsumo);
      out.write("\" />                            \n");
      out.write("                             <input type=\"hidden\" id=\"txtIdInsumo\" name=\"txtIdInsumo\" value=\"");
      out.print(strIdInsumo);
      out.write("\" />                       \n");
      out.write("                             <input type=\"hidden\" id=\"txtIdUnidadMedida\" name=\"txtIdUnidadMedida\" value=\"");
      out.print(strIdUnidadMedida);
      out.write("\" />           \n");
      out.write("                             <input type=\"hidden\" id=\"txtAplicaSubcantidad\" name=\"txtAplicaSubcantidad\" value=\"");
      out.print(strAplicaSubcantidad);
      out.write("\" />                             \n");
      out.write("                             <input type=\"hidden\" id=\"txtFacturado\" name=\"txtFacturado\" value=\"");
      out.print(strFacturado);
      out.write("\" />\n");
      out.write("                             <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"99%\" class=\"TABLAMAESTRO\">\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td colspan=\"7\" class=\"TITULOFORM\">DETALLE DE CONSUMO DE SERVICIO</td>\n");
      out.write("                                 </tr>                     \n");
      out.write("                                 <tr>\n");
      out.write("                                     <td colspan=\"7\" class=\"SUBTITULOFORM\">DATOS GENERALES DEL CONSUMO</td>\n");
      out.write("                                 </tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td class=\"LABELFORM\">Fecha de registro:<br />(aaaa-mm-dd)</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                         <input type=\"text\" id=\"txtFechaRegistro\" name=\"txtFechaRegistro\" value=\"");
      out.print(strFechaRegistro);
      out.write("\" class=\"CAMPOFORMREAD\" value=\"\" readonly=\"true\"/>\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgFechaRegistro\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                     <td class=\"LABELFORM\">Usuario que registra:</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                         <input type=\"text\" id=\"txtUsuarioRegistra\" name=\"txtUsuarioRegistra\" value=\"");
      out.print(strUsuarioRegistra);
      out.write("\" class=\"CAMPOFORMREAD\" readonly=\"true\"/>\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgUsuarioRegistra\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                 </tr>                            \n");
      out.write("                                 <tr>\n");
      out.write("                                     <td class=\"LABELFORM\">Nombre del servicio:</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\" colspan=\"2\"  style=\"width: 350px;\" >\n");
      out.write("                                         <input type=\"text\" id=\"txtServicio\" name=\"txtServicio\" value=\"");
      out.print(strServicio);
      out.write("\" class=\"CAMPOFORMREAD\" readonly=\"true\" style=\"width: 100%;\" />\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                     <td class=\"LABELFORM\">Nombre del subservicio:</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                         <input type=\"text\" id=\"txtSubservicio\" name=\"txtSubservicio\" value=\"");
      out.print(strSubservicio);
      out.write("\" class=\"CAMPOFORMREAD\" readonly=\"true\" style=\"width: 100%;\" />\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgSubservicio\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                 </tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td class=\"LABELFORM\">Tipo de usuario del consumo:</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                         <input type=\"text\" id=\"txtTipoUsuarioConsumo\" name=\"txtTipoUsuarioConsumo\" value=\"");
      out.print(strTipoUsuarioConsumo);
      out.write("\" class=\"CAMPOFORMREAD\" readonly=\"true\">                                        \n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgTipoUsuarioConsumo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                     <td class=\"LABELFORM\">Nombre del usuario:</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\" style=\"width: 350px;\">\n");
      out.write("                                         <input type=\"text\" id=\"txtUsuarioConsumo\" name=\"txtUsuarioConsumo\" value=\"");
      out.print(strUsuarioConsumo);
      out.write("\" class=\"CAMPOFORMREAD\" style=\"width: 100%;\" readonly=\"true\">\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgUsuarioConsumo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                 </tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td class=\"LABELFORM\">* Fecha del consumo:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                         <input type=\"text\" id=\"txtFechaConsumo\" name=\"txtFechaConsumo\" value=\"");
      out.print(dtFechaConsumo.toString());
      out.write("\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                         <img src=\"Images/Calendario.JPG\" id=\"imgFechaConsumo\" class='IMGCALENDAR'>\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgVFechaConsumo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"ESPACIOBLANCO\" colspan=\"3\"></td>                                \n");
      out.write("                                 </tr>\n");
      out.write("                                 <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td colspan=\"7\" class=\"SUBTITULOFORM\">DATOS ESPECÍFICOS DEL CONSUMO</td>\n");
      out.write("                                 </tr>                            \n");
      out.write("                                 ");
if (strTipoConsumo.equals("consumos_insumos")){
      out.write("\n");
      out.write("                                     <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">Insumo consumido:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                             <input type=\"text\" id=\"txtInsumo\" name=\"txtInsumo\" value=\"");
      out.print(strInsumo);
      out.write("\" class=\"CAMPOFORMREAD\" readonly=\"true\">                                        \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgInsumo\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Cantidad consumida:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\" style=\"width: 350px;\">\n");
      out.write("                                             <input type=\"text\" id=\"txtCantidadConsumida\" name=\"txtCantidadConsumida\" value=\"");
      out.print(bgCantidadConsumida);
      out.write("\" class=\"CAMPOFORM\" style=\"width: 30px;\">&nbsp;&nbsp;[");
      out.print(strUnidadMedida);
      out.write("]\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgCantidadConsumida\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>\n");
      out.write("                                     ");
if(strAplicaSubcantidad.equals("S")){
      out.write("\n");
      out.write("                                         <tr>\n");
      out.write("                                             <td class=\"LABELFORM\">");
      out.print(strEtiquetaSubcantidad);
      out.write(":</td>\n");
      out.write("                                             <td class=\"CELDACAMPOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                                 <input type=\"text\" id=\"txtSubcantidad\" name=\"txtSubcantidad\" value=\"");
      out.print(intSubcantidad);
      out.write("\" class=\"CAMPOFORM\" style=\"width: 30px;\">                                        \n");
      out.write("                                             </td>\n");
      out.write("                                             <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                 <img src=\"Images/error.png\" id=\"imgSubcantidad\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                             </td>\n");
      out.write("                                             <td class=\"ESPACIOBLANCO\" colspan=\"3\"></td>                                   \n");
      out.write("                                         </tr>\n");
      out.write("                                     ");
}
      out.write("\n");
      out.write("                                 ");
}
      out.write("\n");
      out.write("                                 ");
if (strTipoConsumo.equals("consumos_tipos_usuario")){
      out.write("\n");
      out.write("                                    <input type=\"hidden\" id=\"txtAplicaPorcentajeSancion\" name=\"txtAplicaPorcentajeSancion\" value=\"");
      out.print(strAplicaPorcentajeSancion);
      out.write("\" />\n");
      out.write("                                     <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">Tipo de usuario:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                             <select id=\"cbTipoUsuario\" name=\"cbTipoUsuario\" class=\"CAMPOSELECT\" style=\"width: 100%;\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(TipoUsuario tipoUsuario : tiposUsuario){
      out.write("\n");
      out.write("                                                     <option value=\"");
      out.print(tipoUsuario.getCodigo());
      out.write('"');
      out.write('>');
      out.print(tipoUsuario.getNombre());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>                       \n");
      out.write("                                             <script type=\"text/javascript\">\n");
      out.write("                                                 $(\"#cbTipoUsuario\").val(\"");
      out.print(strIdTipoUsuario);
      out.write("\");\n");
      out.write("                                             </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgTipoUsuario\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Cantidad consumida:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\" style=\"width: 350px;\">\n");
      out.write("                                             <input type=\"text\" id=\"txtCantidadConsumida\" name=\"txtCantidadConsumida\" value=\"");
      out.print(bgCantidadConsumida);
      out.write("\" class=\"CAMPOFORM\" style=\"width: 30px;\">&nbsp;&nbsp;[");
      out.print(strUnidadMedida);
      out.write("]\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgCantidadConsumida\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>\n");
      out.write("                                     <tr>\n");
      out.write("                                         ");
if(intSubcantidad<=0){
      out.write("\n");
      out.write("                                             <td class=\"LABELFORM\">Subcantidad:</td>\n");
      out.write("                                             <td class=\"CELDACAMPOFORM\"  style=\"width: 350px;\" >                                        \n");
      out.write("                                                     <input type=\"text\" id=\"txtSubcantidad\" name=\"txtSubcantidad\" value=\"");
      out.print(intSubcantidad);
      out.write("\" class=\"CAMPOFORMREAD\" readonly=\"true\" style=\"width: 30px;\">  \n");
      out.write("                                                     <input type=\"hidden\" id=\"txtEtiquetaSubcantidad\" name=\"txtEtiquetaSubcantidad\" value=\"");
      out.print(strEtiquetaSubcantidad);
      out.write("\" />\n");
      out.write("                                             </td>\n");
      out.write("                                         ");
}else{
      out.write("\n");
      out.write("                                             <td class=\"LABELFORM\">* ");
      out.print(strEtiquetaSubcantidad);
      out.write(":</td>\n");
      out.write("                                             <td class=\"CELDACAMPOFORM\"  style=\"width: 350px;\" >                                                                           \n");
      out.write("                                                     <input type=\"text\" id=\"txtSubcantidad\" name=\"txtSubcantidad\" value=\"");
      out.print(intSubcantidad);
      out.write("\" class=\"CAMPOFORM\" style=\"width: 30px;\">                                                \n");
      out.write("                                             </td>\n");
      out.write("                                          ");
}
      out.write("\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgSubcantidad\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">Concepto del consumo:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\" style=\"width: 350px;\">\n");
      out.write("                                             <input type=\"text\" id=\"txtConcepto\" name=\"txtConcepto\" value=\"");
      out.print(strConcepto);
      out.write("\" class=\"CAMPOFORM\" style=\"width: 100%;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgConcepto\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>\n");
      out.write("                                     ");
if(strAplicaPorcentajeSancion.equals("S")){
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"LABELFORM\">* ¿Aplicar sanción?:</td>\n");
      out.write("                                            <td class=\"CELDARADIOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                                 <input type=\"radio\" name=\"rdAplicaSancion\" id=\"rdAplicaSi\" value=\"S\">Si\n");
      out.write("                                                 <input type=\"radio\" name=\"rdAplicaSancion\" id=\"rdAplicaNo\" value=\"N\">No\n");
      out.write("                                                <script type=\"text/javascript\">\n");
      out.write("                                                   $(\"[name=rdAplicaSancion]\").filter(\"[value='");
      out.print(strAplicaSancion);
      out.write("']\").prop(\"checked\",true);\n");
      out.write("                                                </script>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                <img src=\"Images/error.png\" id=\"imgAplicaSancion\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                            </td>\n");
      out.write("                                            <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                     ");
}
      out.write("\n");
      out.write("                                 ");
}
      out.write("\n");
      out.write("                                 ");
if (strTipoConsumo.equals("consumos_unidades")){
      out.write("\n");
      out.write("                                     <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Cantidad consumida:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\" style=\"width: 350px;\">\n");
      out.write("                                             <input type=\"text\" id=\"txtCantidadConsumida\" name=\"txtCantidadConsumida\" value=\"");
      out.print(bgCantidadConsumida);
      out.write("\" class=\"CAMPOFORM\" style=\"width: 30px;\">&nbsp;&nbsp;[");
      out.print(strUnidadMedida);
      out.write("]\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgCantidadConsumida\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">Concepto del consumo:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\" style=\"width: 350px;\">\n");
      out.write("                                             <input type=\"text\" id=\"txtConcepto\" name=\"txtConcepto\" value=\"");
      out.print(strConcepto);
      out.write("\" class=\"CAMPOFORM\" style=\"width: 100%;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgConcepto\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>\n");
      out.write("                                 ");
}
      out.write("\n");
      out.write("                                 <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td colspan=\"7\" class=\"SUBTITULOFORM\">DATOS DE FACTURACIÓN DEL CONSUMO</td>\n");
      out.write("                                 </tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td class=\"LABELFORM\">* ¿Se factura?:</td>\n");
      out.write("                                     <td class=\"CELDARADIOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                         <input type=\"radio\" name=\"rdSeFactura\" id=\"rdSeFacturaS\" value=\"S\" />Si                                        \n");
      out.write("                                         <input type=\"radio\" name=\"rdSeFactura\" id=\"rdSeFacturaN\" value=\"N\" />No\n");
      out.write("                                         <script type=\"text/javascript\">\n");
      out.write("                                             $(\"[name=rdSeFactura]\").filter(\"[value='");
      out.print(strSeFactura);
      out.write("']\").prop(\"checked\",true);\n");
      out.write("                                         </script>\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgSeFactura\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                     <td class=\"LABELFORM\">* ¿Facturado?:</td>\n");
      out.write("                                     <td class=\"CELDARADIOFORM\" style=\"width: 350px;\">\n");
      out.write("                                         <input type=\"radio\" name=\"rdFacturado\" id=\"rdFacturadoS\" value=\"S\" />Si                                        \n");
      out.write("                                         <input type=\"radio\" name=\"rdFacturado\" id=\"rdFacturadoN\" value=\"N\" />No        \n");
      out.write("                                         <script type=\"text/javascript\">\n");
      out.write("                                             $(\"[name=rdFacturado]\").filter(\"[value='");
      out.print(strFacturado);
      out.write("']\").prop(\"checked\",true);\n");
      out.write("                                         </script>\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgFacturado\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                 </tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td class=\"LABELFORM\">Fecha de facturación:<br />(aaaa-mm-dd)</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                         ");
if(dtFechaFacturacion == null){
      out.write("\n");
      out.write("                                             <input type=\"text\" id=\"txtFechaFacturacion\" name=\"txtFechaFacturacion\" value=\"\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                             <img src=\"Images/Calendario.JPG\" id=\"imgFechaFacturacion\" class='IMGCALENDAR'>\n");
      out.write("                                         ");
}else{
      out.write("\n");
      out.write("                                             <input type=\"text\" id=\"txtFechaFacturacion\" name=\"txtFechaFacturacion\" value=\"");
      out.print(dtFechaFacturacion.toString());
      out.write("\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                             <img src=\"Images/Calendario.JPG\" id=\"imgFechaFacturacion\" class='IMGCALENDAR'>\n");
      out.write("                                         ");
}
      out.write("                                    \n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgVFechaFacturacion\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"ESPACIOBLANCO\"></td>                  \n");
      out.write("                                     <td class=\"LABELFORM\">Número de cuenta de cobro:</td>\n");
      out.write("                                     <td class=\"CELDACAMPOFORM\">                             \n");
      out.write("                                             <input type=\"text\" id=\"txtCuentaCobro\" name=\"txtCuentaCobro\" value=\"");
      out.print(lgCuentaCobro);
      out.write("\" class=\"CAMPOFORM\">                                                                   \n");
      out.write("                                     </td>\n");
      out.write("                                     <td class=\"CELDAIMGERROR\">\n");
      out.write("                                         <img src=\"Images/error.png\" id=\"imgCuentaCobro\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                     </td>\n");
      out.write("                                 </tr>\n");
      out.write("                                 ");
if (strTieneDescuento.equals("S")){
      out.write("                          \n");
      out.write("                                     <input type=\"hidden\" id=\"txtCodigoDescuento\" name=\"txtCodigoDescuento\" value=\"");
      out.print(intCodigoDescuento);
      out.write("\" />\n");
      out.write("                                     <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                     <tr>\n");
      out.write("                                         <td colspan=\"7\" class=\"SUBTITULOFORM\">DESCUENTO APLICADO AL CONSUMO</td>\n");
      out.write("                                     </tr>\n");
      out.write("                                     <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* % de descuento:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                             <input type=\"text\" id=\"txtValorDescuento\" name=\"txtValorDescuento\" value=\"");
      out.print(descuentoConsumo.getDescuento());
      out.write("\" class=\"CAMPOFORM\" style=\"width: 30px;\" maxlength=\"4\">&nbsp;&nbsp;(Ejm: 30 ó 20.5)                                        \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgValorDescuento\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">Concepto del descuento:</td>\n");
      out.write("                                             <td class=\"CELDACAMPOFORM\" style=\"width: 350px;\">\n");
      out.write("                                                 <input type=\"text\" id=\"txtConceptoDescuento\" name=\"txtConceptoDescuento\" value=\"");
      out.print(descuentoConsumo.getConcepto());
      out.write("\" class=\"CAMPOFORM\" style=\"width: 100%;\">\n");
      out.write("                                             </td>\n");
      out.write("                                             <td class=\"CELDAIMGERROR\">\n");
      out.write("                                                 <img src=\"Images/error.png\" id=\"imgConceptoDescuento\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                             </td>\n");
      out.write("                                     </tr>\n");
      out.write("                                     <tr>                  \n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Se factura?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                             <input type=\"radio\" name=\"rdSeFacturaDescuento\" id=\"rdSeFacturaDescuentoS\" value=\"S\" />Si                                        \n");
      out.write("                                             <input type=\"radio\" name=\"rdSeFacturaDescuento\" id=\"rdSeFacturaDescuentoN\" value=\"N\" />No\n");
      out.write("                                             <script type=\"text/javascript\">\n");
      out.write("                                                 $(\"[name=rdSeFacturaDescuento]\").filter(\"[value='");
      out.print(strSeFacturaDescuento);
      out.write("']\").prop(\"checked\",true);\n");
      out.write("                                             </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgSeFacturaDescuento\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Facturado?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\" style=\"width: 350px;\">\n");
      out.write("                                             <input type=\"radio\" name=\"rdFacturadoDescuento\" id=\"rdFacturadoDescuentoS\" value=\"S\" />Si                                        \n");
      out.write("                                             <input type=\"radio\" name=\"rdFacturadoDescuento\" id=\"rdFacturadoDescuentoN\" value=\"N\" />No        \n");
      out.write("                                             <script type=\"text/javascript\">\n");
      out.write("                                                 $(\"[name=rdFacturadoDescuento]\").filter(\"[value='");
      out.print(strFacturadoDescuento);
      out.write("']\").prop(\"checked\",true);\n");
      out.write("                                             </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgFacturadoDescuento\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>\n");
      out.write("                                     <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Fecha de registro:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtFechaDescuento\" name=\"txtFechaDescuento\" value=\"");
      out.print(dtFechaDescuento.toString());
      out.write("\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                             <img src=\"Images/Calendario.JPG\" id=\"imgFechaDescuento\" class='IMGCALENDAR'>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgVFechaDescuento\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>                  \n");
      out.write("                                         <td class=\"LABELFORM\">Fecha de facturación:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             ");
if(dtFechaAplicacion == null){
      out.write("\n");
      out.write("                                                 <input type=\"text\" id=\"txtFechaFacturacionDescuento\" name=\"txtFechaFacturacionDescuento\" value=\"\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                                 <img src=\"Images/Calendario.JPG\" id=\"imgFechaFacturacionDescuento\" class='IMGCALENDAR'>\n");
      out.write("                                             ");
}else{
      out.write("\n");
      out.write("                                                 <input type=\"text\" id=\"txtFechaFacturacionDescuento\" name=\"txtFechaFacturacionDescuento\" value=\"");
      out.print(dtFechaAplicacion.toString());
      out.write("\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                                 <img src=\"Images/Calendario.JPG\" id=\"imgFechaFacturacionDescuento\" class='IMGCALENDAR'>\n");
      out.write("                                             ");
}
      out.write("                                    \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgVFechaFacturacionDescuento\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>                  \n");
      out.write("                                     <script type=\"text/javascript\">\n");
      out.write("                                         setCalendario(\"txtFechaDescuento\",\"imgFechaDescuento\");\n");
      out.write("                                         setCalendario(\"txtFechaFacturacionDescuento\",\"imgFechaFacturacionDescuento\");\n");
      out.write("                                     </script>\n");
      out.write("                                 ");
}
      out.write("\n");
      out.write("                                 ");
if(strTieneConsumoAdicional.equals("S")){
      out.write("\n");
      out.write("                                     <input type=\"hidden\" id=\"txtCodigoConsumoAdicional\" name=\"txtCodigoConsumoAdicional\" value=\"");
      out.print(intCodigoConsumoAdicional);
      out.write("\" />\n");
      out.write("                                     <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                     <tr>\n");
      out.write("                                         <td colspan=\"7\" class=\"SUBTITULOFORM\">CONSUMO ADICIONAL ASOCIADO</td>\n");
      out.write("                                     </tr>                                 \n");
      out.write("                                     <tr>              \n");
      out.write("                                         <td class=\"LABELFORM\">* Item adicional:</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                             <select id=\"cbItemAdicional\" name=\"cbItemAdicional\" class=\"CAMPOSELECT\">\n");
      out.write("                                                 <option value=\"-1\">Seleccione una opción</option>\n");
      out.write("                                                 ");
for(ItemAdicional itemAdicional : itemsAdicionales){
      out.write("\n");
      out.write("                                                     <option value=\"");
      out.print(itemAdicional.getCodigo());
      out.write('"');
      out.write('>');
      out.print(itemAdicional.getNombre());
      out.write("</option>\n");
      out.write("                                                 ");
}
      out.write("\n");
      out.write("                                             </select>                       \n");
      out.write("                                             <script type=\"text/javascript\">\n");
      out.write("                                                 $(\"#cbItemAdicional\").val(\"");
      out.print(strIdItemAdicional);
      out.write("\");\n");
      out.write("                                             </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgItemAdicional\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* Valor ($):</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\" style=\"width: 350px;\">\n");
      out.write("                                             <input type=\"text\" id=\"txtValorConsumoAdicional\" name=\"txtValorConsumoAdicional\" value=\"");
      out.print(lgValorUnidad);
      out.write("\" class=\"CAMPOFORM\" style=\"width: 80px;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgValorConsumoAdicional\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>\n");
      out.write("                                     <tr>                  \n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Se factura?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\"  style=\"width: 350px;\" >\n");
      out.write("                                             <input type=\"radio\" name=\"rdSeFacturaConsumoA\" id=\"rdSeFacturaConsumoAS\" value=\"S\" />Si                                        \n");
      out.write("                                             <input type=\"radio\" name=\"rdSeFacturaConsumoA\" id=\"rdSeFacturaConsumoAN\" value=\"N\" />No\n");
      out.write("                                             <script type=\"text/javascript\">\n");
      out.write("                                                 $(\"[name=rdSeFacturaConsumoA]\").filter(\"[value='");
      out.print(strSeFacturaConsumoAdicional);
      out.write("']\").prop(\"checked\",true);\n");
      out.write("                                             </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgSeFacturaConsumoA\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>\n");
      out.write("                                         <td class=\"LABELFORM\">* ¿Facturado?:</td>\n");
      out.write("                                         <td class=\"CELDARADIOFORM\" style=\"width: 350px;\">\n");
      out.write("                                             <input type=\"radio\" name=\"rdFacturadoConsumoA\" id=\"rdFacturadoConsumoAS\" value=\"S\" />Si                                        \n");
      out.write("                                             <input type=\"radio\" name=\"rdFacturadoConsumoA\" id=\"rdFacturadoConsumoAN\" value=\"N\" />No        \n");
      out.write("                                             <script type=\"text/javascript\">\n");
      out.write("                                                 $(\"[name=rdFacturadoConsumoA]\").filter(\"[value='");
      out.print(strFacturadoConsumoAdicional);
      out.write("']\").prop(\"checked\",true);\n");
      out.write("                                             </script>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgFacturadoConsumoA\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>\n");
      out.write("                                     <tr>\n");
      out.write("                                         <td class=\"LABELFORM\">* Fecha del consumo adicional:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             <input type=\"text\" id=\"txtFechaConsumoA\" name=\"txtFechaConsumoA\" value=\"");
      out.print(dtFechaConsumoAdicional.toString());
      out.write("\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                             <img src=\"Images/Calendario.JPG\" id=\"imgFechaConsumoA\" class='IMGCALENDAR'>\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgVFechaConsumoA\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"ESPACIOBLANCO\"></td>                  \n");
      out.write("                                         <td class=\"LABELFORM\">Fecha de facturación:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>\n");
      out.write("                                         <td class=\"CELDACAMPOFORM\">\n");
      out.write("                                             ");
if(dtFechaFacturacionConsumoA == null){
      out.write("\n");
      out.write("                                                 <input type=\"text\" id=\"txtFechaFacturacionConsumoA\" name=\"txtFechaFacturacionConsumoA\" value=\"\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                                 <img src=\"Images/Calendario.JPG\" id=\"imgFechaFacturacionConsumoA\" class='IMGCALENDAR'>\n");
      out.write("                                             ");
}else{
      out.write("\n");
      out.write("                                                 <input type=\"text\" id=\"txtFechaFacturacionConsumoA\" name=\"txtFechaFacturacionConsumoA\" value=\"");
      out.print(dtFechaFacturacionConsumoA.toString());
      out.write("\" class=\"CAMPOFORM\" readonly=\"true\">&nbsp;                          \n");
      out.write("                                                 <img src=\"Images/Calendario.JPG\" id=\"imgFechaFacturacionConsumoA\" class='IMGCALENDAR'>\n");
      out.write("                                             ");
}
      out.write("                                    \n");
      out.write("                                         </td>\n");
      out.write("                                         <td class=\"CELDAIMGERROR\">\n");
      out.write("                                             <img src=\"Images/error.png\" id=\"imgVFechaFacturacionConsumoA\" alt=\"Campo obligatorio\" class=\"IMGERROR\" style=\"display: none;\">\n");
      out.write("                                         </td>\n");
      out.write("                                     </tr>                  \n");
      out.write("                                     <script type=\"text/javascript\">\n");
      out.write("                                         setCalendario(\"txtFechaConsumoA\",\"imgFechaConsumoA\");\n");
      out.write("                                         setCalendario(\"txtFechaFacturacionConsumoA\",\"imgFechaFacturacionConsumoA\");\n");
      out.write("                                     </script>\n");
      out.write("                                 ");
}
      out.write("\n");
      out.write("                                 <tr><td colspan=\"7\" style=\"height: 10px;\"></td></tr>\n");
      out.write("                                 <tr>\n");
      out.write("                                     <td colspan=\"7\" class=\"CELDABOTONFORM\">                             \n");
      out.write("                                            <input type=\"submit\" name=\"btnActualizar\" id=\"btnActualizar\" value=\"Actualizar\" class=\"BOTONFORM\" />&nbsp;&nbsp;&nbsp;\n");
      out.write("                                            <input type=\"button\" name=\"btnSalir\" id=\"btnSalir\" value=\"Salir\" class=\"BOTONFORM\" onclick=\"javascript:window.close();\" />                                   \n");
      out.write("                                    </td>\n");
      out.write("                                 </tr>                                                         \n");
      out.write("                                 <tr>\n");
      out.write("                                     <td colspan=\"7\" class=\"MSGAVISOOBLG\">\n");
      out.write("                                         Los campos marcados con (*) son obligatorios.\n");
      out.write("                                     </td>\n");
      out.write("                                 </tr>\n");
      out.write("                             </table>\n");
      out.write("                         </form>\n");
      out.write("                         <br />                   \n");
      out.write("                     </div>   \n");
      out.write("                ");
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
