<%-- 
    Document   : detalleConsumo
    Created on : 9/01/2015, 10:35:15 AM
    Author     : Jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.Subservicio"%>
<%@page import="co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.SubservicioDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ItemAdicionalDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ItemAdicionalDAO"%>
<%@page import="co.edu.udea.facturacion.dto.ItemAdicional"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXUnidadDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoAdicionalXUnidadDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXTipoUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoAdicionalXTipoUsuarioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.ConsumoAdicional"%>
<%@page import="co.edu.udea.facturacion.dao.impl.DescuentoConsumoXUnidadDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO"%>
<%@page import="co.edu.udea.facturacion.dto.DescuentoConsumo"%>
<%@page import="co.edu.udea.facturacion.dao.impl.DescuentoConsumoXTipoUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.DescuentoConsumoXTipoUsuarioDAO"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="co.edu.udea.facturacion.dto.TipoUsuario"%>
<%@page import="co.edu.udea.facturacion.dao.impl.TipoUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.TipoUsuarioDAO"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Date"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioConsumoSIU"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UsuarioConsumoSIUDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.UsuarioSIUDAO"%>
<%@page import="co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO"%>
<%@page import="co.edu.udea.facturacion.exception.GIDaoException"%>
<%@page import="co.edu.udea.facturacion.dao.impl.FuncionesComunesConsumosDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO"%>
<%@page import="co.edu.udea.facturacion.dto.ConsumoServicioXUnidad"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoServicioXUnidadDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoServicioXUnidadDAO"%>
<%@page import="co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoServicioXTipoUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoServicioXTipoUsuarioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.ConsumoServicioXInsumo"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoServicioXInsumoDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="comprobarSesion.jsp"></jsp:include>
<%
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
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <link rel="stylesheet" type="text/css" href="Styles/calendar-system.css" />
        <script type="text/javascript" src="Scripts/JSCalendar.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-es.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-setup.js"></script> 
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/detalleConsumo.js"></script>
        <title>Detalle de consumo de servicio</title>        
    </head>
    <body>
        <header>
           <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <%if(haySesion){%>
                    <br />
                     <div align="center">
                         <form id="frmIngresoConsumo" name="frmIngresoConsumo" method="POST" action="ActualizarDetalleConsumo" onsubmit="return validarActualizarConsumo()">
                             <input type="hidden" id="txtCodigo" name="txtCodigo" value="<%=intConsecutivo%>" />
                             <input type="hidden" id="txtTipoConsumo" name="txtTipoConsumo" value="<%=strTipoConsumo%>" />
                             <input type="hidden" id="txtTieneDescuento" name="txtTieneDescuento" value="<%=strTieneDescuento%>" />
                             <input type="hidden" id="txtTieneConsumoAdicional" name="txtTieneConsumoAdicional" value="<%=strTieneConsumoAdicional%>" />
                             <input type="hidden" id="txtIdUsuarioRegistra" name="txtIdUsuarioRegistra" value="<%=strIdUsuarioRegistra%>" />
                             <input type="hidden" id="txtIdServicio" name="txtIdServicio" value="<%=strIdServicio%>" />
                             <input type="hidden" id="txtIdSubservicio" name="txtIdSubservicio" value="<%=strIdSubservicio%>" />
                             <input type="hidden" id="txtIdTipoUsuarioConsumo" name="txtIdTipoUsuarioConsumo" value="<%=strIdTipoUsuarioConsumo%>" />               
                             <input type="hidden" id="txtIdUsuarioConsumo" name="txtIdUsuarioConsumo" value="<%=strIdUsuarioConsumo%>" />                            
                             <input type="hidden" id="txtIdInsumo" name="txtIdInsumo" value="<%=strIdInsumo%>" />                       
                             <input type="hidden" id="txtIdUnidadMedida" name="txtIdUnidadMedida" value="<%=strIdUnidadMedida%>" />           
                             <input type="hidden" id="txtAplicaSubcantidad" name="txtAplicaSubcantidad" value="<%=strAplicaSubcantidad%>" />                             
                             <input type="hidden" id="txtFacturado" name="txtFacturado" value="<%=strFacturado%>" />
                             <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                 <tr>
                                     <td colspan="7" class="TITULOFORM">DETALLE DE CONSUMO DE SERVICIO</td>
                                 </tr>                     
                                 <tr>
                                     <td colspan="7" class="SUBTITULOFORM">DATOS GENERALES DEL CONSUMO</td>
                                 </tr>
                                 <tr>
                                     <td class="LABELFORM">Fecha de registro:<br />(aaaa-mm-dd)</td>
                                     <td class="CELDACAMPOFORM">
                                         <input type="text" id="txtFechaRegistro" name="txtFechaRegistro" value="<%=strFechaRegistro%>" class="CAMPOFORMREAD" value="" readonly="true"/>
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgFechaRegistro" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                     <td class="ESPACIOBLANCO"></td>
                                     <td class="LABELFORM">Usuario que registra:</td>
                                     <td class="CELDACAMPOFORM">
                                         <input type="text" id="txtUsuarioRegistra" name="txtUsuarioRegistra" value="<%=strUsuarioRegistra%>" class="CAMPOFORMREAD" readonly="true"/>
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgUsuarioRegistra" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                 </tr>                            
                                 <tr>
                                     <td class="LABELFORM">Nombre del servicio:</td>
                                     <td class="CELDACAMPOFORM" colspan="2"  style="width: 350px;" >
                                         <input type="text" id="txtServicio" name="txtServicio" value="<%=strServicio%>" class="CAMPOFORMREAD" readonly="true" style="width: 100%;" />
                                     </td>
                                     <td class="ESPACIOBLANCO"></td>
                                     <td class="LABELFORM">Nombre del subservicio:</td>
                                     <td class="CELDACAMPOFORM">
                                         <input type="text" id="txtSubservicio" name="txtSubservicio" value="<%=strSubservicio%>" class="CAMPOFORMREAD" readonly="true" style="width: 100%;" />
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgSubservicio" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                 </tr>
                                 <tr>
                                     <td class="LABELFORM">Tipo de usuario del consumo:</td>
                                     <td class="CELDACAMPOFORM"  style="width: 350px;" >
                                         <input type="text" id="txtTipoUsuarioConsumo" name="txtTipoUsuarioConsumo" value="<%=strTipoUsuarioConsumo%>" class="CAMPOFORMREAD" readonly="true">                                        
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgTipoUsuarioConsumo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                     <td class="ESPACIOBLANCO"></td>
                                     <td class="LABELFORM">Nombre del usuario:</td>
                                     <td class="CELDACAMPOFORM" style="width: 350px;">
                                         <input type="text" id="txtUsuarioConsumo" name="txtUsuarioConsumo" value="<%=strUsuarioConsumo%>" class="CAMPOFORMREAD" style="width: 100%;" readonly="true">
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgUsuarioConsumo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                 </tr>
                                 <tr>
                                     <td class="LABELFORM">* Fecha del consumo:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>
                                     <td class="CELDACAMPOFORM">
                                         <input type="text" id="txtFechaConsumo" name="txtFechaConsumo" value="<%=dtFechaConsumo.toString()%>" class="CAMPOFORM" readonly="true">&nbsp;                          
                                         <img src="Images/Calendario.JPG" id="imgFechaConsumo" class='IMGCALENDAR'>
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgVFechaConsumo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                     <td class="ESPACIOBLANCO" colspan="3"></td>                                
                                 </tr>
                                 <tr><td colspan="7" style="height: 10px;"></td></tr>
                                 <tr>
                                     <td colspan="7" class="SUBTITULOFORM">DATOS ESPECÍFICOS DEL CONSUMO</td>
                                 </tr>                            
                                 <%if (strTipoConsumo.equals("consumos_insumos")){%>
                                     <tr>
                                         <td class="LABELFORM">Insumo consumido:</td>
                                         <td class="CELDACAMPOFORM"  style="width: 350px;" >
                                             <input type="text" id="txtInsumo" name="txtInsumo" value="<%=strInsumo%>" class="CAMPOFORMREAD" readonly="true">                                        
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgInsumo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Cantidad consumida:</td>
                                         <td class="CELDACAMPOFORM" style="width: 350px;">
                                             <input type="text" id="txtCantidadConsumida" name="txtCantidadConsumida" value="<%=bgCantidadConsumida%>" class="CAMPOFORM" style="width: 30px;">&nbsp;&nbsp;[<%=strUnidadMedida%>]
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCantidadConsumida" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>
                                     <%if(strAplicaSubcantidad.equals("S")){%>
                                         <tr>
                                             <td class="LABELFORM"><%=strEtiquetaSubcantidad%>:</td>
                                             <td class="CELDACAMPOFORM"  style="width: 350px;" >
                                                 <input type="text" id="txtSubcantidad" name="txtSubcantidad" value="<%=intSubcantidad%>" class="CAMPOFORM" style="width: 30px;">                                        
                                             </td>
                                             <td class="CELDAIMGERROR">
                                                 <img src="Images/error.png" id="imgSubcantidad" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                             </td>
                                             <td class="ESPACIOBLANCO" colspan="3"></td>                                   
                                         </tr>
                                     <%}%>
                                 <%}%>
                                 <%if (strTipoConsumo.equals("consumos_tipos_usuario")){%>
                                    <input type="hidden" id="txtAplicaPorcentajeSancion" name="txtAplicaPorcentajeSancion" value="<%=strAplicaPorcentajeSancion%>" />
                                     <tr>
                                         <td class="LABELFORM">Tipo de usuario:</td>
                                         <td class="CELDACAMPOFORM"  style="width: 350px;" >
                                             <select id="cbTipoUsuario" name="cbTipoUsuario" class="CAMPOSELECT" style="width: 100%;">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(TipoUsuario tipoUsuario : tiposUsuario){%>
                                                     <option value="<%=tipoUsuario.getCodigo()%>"><%=tipoUsuario.getNombre()%></option>
                                                 <%}%>
                                             </select>                       
                                             <script type="text/javascript">
                                                 $("#cbTipoUsuario").val("<%=strIdTipoUsuario%>");
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgTipoUsuario" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Cantidad consumida:</td>
                                         <td class="CELDACAMPOFORM" style="width: 350px;">
                                             <input type="text" id="txtCantidadConsumida" name="txtCantidadConsumida" value="<%=bgCantidadConsumida%>" class="CAMPOFORM" style="width: 30px;">&nbsp;&nbsp;[<%=strUnidadMedida%>]
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCantidadConsumida" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>
                                     <tr>
                                         <%if(intSubcantidad<=0){%>
                                             <td class="LABELFORM">Subcantidad:</td>
                                             <td class="CELDACAMPOFORM"  style="width: 350px;" >                                        
                                                     <input type="text" id="txtSubcantidad" name="txtSubcantidad" value="<%=intSubcantidad%>" class="CAMPOFORMREAD" readonly="true" style="width: 30px;">  
                                                     <input type="hidden" id="txtEtiquetaSubcantidad" name="txtEtiquetaSubcantidad" value="<%=strEtiquetaSubcantidad%>" />
                                             </td>
                                         <%}else{%>
                                             <td class="LABELFORM">* <%=strEtiquetaSubcantidad%>:</td>
                                             <td class="CELDACAMPOFORM"  style="width: 350px;" >                                                                           
                                                     <input type="text" id="txtSubcantidad" name="txtSubcantidad" value="<%=intSubcantidad%>" class="CAMPOFORM" style="width: 30px;">                                                
                                             </td>
                                          <%}%>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSubcantidad" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">Concepto del consumo:</td>
                                         <td class="CELDACAMPOFORM" style="width: 350px;">
                                             <input type="text" id="txtConcepto" name="txtConcepto" value="<%=strConcepto%>" class="CAMPOFORM" style="width: 100%;">
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgConcepto" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>
                                     <%if(strAplicaPorcentajeSancion.equals("S")){%>
                                        <tr>
                                            <td class="LABELFORM">* ¿Aplicar sanción?:</td>
                                            <td class="CELDARADIOFORM"  style="width: 350px;" >
                                                 <input type="radio" name="rdAplicaSancion" id="rdAplicaSi" value="S">Si
                                                 <input type="radio" name="rdAplicaSancion" id="rdAplicaNo" value="N">No
                                                <script type="text/javascript">
                                                   $("[name=rdAplicaSancion]").filter("[value='<%=strAplicaSancion%>']").prop("checked",true);
                                                </script>
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgAplicaSancion" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                            <td class="ESPACIOBLANCO"></td>
                                        </tr>
                                     <%}%>
                                 <%}%>
                                 <%if (strTipoConsumo.equals("consumos_unidades")){%>
                                     <tr>
                                         <td class="LABELFORM">* Cantidad consumida:</td>
                                         <td class="CELDACAMPOFORM" style="width: 350px;">
                                             <input type="text" id="txtCantidadConsumida" name="txtCantidadConsumida" value="<%=bgCantidadConsumida%>" class="CAMPOFORM" style="width: 30px;">&nbsp;&nbsp;[<%=strUnidadMedida%>]
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCantidadConsumida" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">Concepto del consumo:</td>
                                         <td class="CELDACAMPOFORM" style="width: 350px;">
                                             <input type="text" id="txtConcepto" name="txtConcepto" value="<%=strConcepto%>" class="CAMPOFORM" style="width: 100%;">
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgConcepto" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>
                                 <%}%>
                                 <tr><td colspan="7" style="height: 10px;"></td></tr>
                                 <tr>
                                     <td colspan="7" class="SUBTITULOFORM">DATOS DE FACTURACIÓN DEL CONSUMO</td>
                                 </tr>
                                 <tr>
                                     <td class="LABELFORM">* ¿Se factura?:</td>
                                     <td class="CELDARADIOFORM"  style="width: 350px;" >
                                         <input type="radio" name="rdSeFactura" id="rdSeFacturaS" value="S" />Si                                        
                                         <input type="radio" name="rdSeFactura" id="rdSeFacturaN" value="N" />No
                                         <script type="text/javascript">
                                             $("[name=rdSeFactura]").filter("[value='<%=strSeFactura%>']").prop("checked",true);
                                         </script>
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgSeFactura" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                     <td class="ESPACIOBLANCO"></td>
                                     <td class="LABELFORM">* ¿Facturado?:</td>
                                     <td class="CELDARADIOFORM" style="width: 350px;">
                                         <input type="radio" name="rdFacturado" id="rdFacturadoS" value="S" />Si                                        
                                         <input type="radio" name="rdFacturado" id="rdFacturadoN" value="N" />No        
                                         <script type="text/javascript">
                                             $("[name=rdFacturado]").filter("[value='<%=strFacturado%>']").prop("checked",true);
                                         </script>
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgFacturado" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                 </tr>
                                 <tr>
                                     <td class="LABELFORM">Fecha de facturación:<br />(aaaa-mm-dd)</td>
                                     <td class="CELDACAMPOFORM">
                                         <%if(dtFechaFacturacion == null){%>
                                             <input type="text" id="txtFechaFacturacion" name="txtFechaFacturacion" value="" class="CAMPOFORM" readonly="true">&nbsp;                          
                                             <img src="Images/Calendario.JPG" id="imgFechaFacturacion" class='IMGCALENDAR'>
                                         <%}else{%>
                                             <input type="text" id="txtFechaFacturacion" name="txtFechaFacturacion" value="<%=dtFechaFacturacion.toString()%>" class="CAMPOFORM" readonly="true">&nbsp;                          
                                             <img src="Images/Calendario.JPG" id="imgFechaFacturacion" class='IMGCALENDAR'>
                                         <%}%>                                    
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgVFechaFacturacion" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                     <td class="ESPACIOBLANCO"></td>                  
                                     <td class="LABELFORM">Número de cuenta de cobro:</td>
                                     <td class="CELDACAMPOFORM">                             
                                             <input type="text" id="txtCuentaCobro" name="txtCuentaCobro" value="<%=lgCuentaCobro%>" class="CAMPOFORM">                                                                   
                                     </td>
                                     <td class="CELDAIMGERROR">
                                         <img src="Images/error.png" id="imgCuentaCobro" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                     </td>
                                 </tr>
                                 <%if (strTieneDescuento.equals("S")){%>                          
                                     <input type="hidden" id="txtCodigoDescuento" name="txtCodigoDescuento" value="<%=intCodigoDescuento%>" />
                                     <tr><td colspan="7" style="height: 10px;"></td></tr>
                                     <tr>
                                         <td colspan="7" class="SUBTITULOFORM">DESCUENTO APLICADO AL CONSUMO</td>
                                     </tr>
                                     <tr>
                                         <td class="LABELFORM">* % de descuento:</td>
                                         <td class="CELDACAMPOFORM"  style="width: 350px;" >
                                             <input type="text" id="txtValorDescuento" name="txtValorDescuento" value="<%=descuentoConsumo.getDescuento()%>" class="CAMPOFORM" style="width: 30px;" maxlength="4">&nbsp;&nbsp;(Ejm: 30 ó 20.5)                                        
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgValorDescuento" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">Concepto del descuento:</td>
                                             <td class="CELDACAMPOFORM" style="width: 350px;">
                                                 <input type="text" id="txtConceptoDescuento" name="txtConceptoDescuento" value="<%=descuentoConsumo.getConcepto()%>" class="CAMPOFORM" style="width: 100%;">
                                             </td>
                                             <td class="CELDAIMGERROR">
                                                 <img src="Images/error.png" id="imgConceptoDescuento" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                             </td>
                                     </tr>
                                     <tr>                  
                                         <td class="LABELFORM">* ¿Se factura?:</td>
                                         <td class="CELDARADIOFORM"  style="width: 350px;" >
                                             <input type="radio" name="rdSeFacturaDescuento" id="rdSeFacturaDescuentoS" value="S" />Si                                        
                                             <input type="radio" name="rdSeFacturaDescuento" id="rdSeFacturaDescuentoN" value="N" />No
                                             <script type="text/javascript">
                                                 $("[name=rdSeFacturaDescuento]").filter("[value='<%=strSeFacturaDescuento%>']").prop("checked",true);
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSeFacturaDescuento" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* ¿Facturado?:</td>
                                         <td class="CELDARADIOFORM" style="width: 350px;">
                                             <input type="radio" name="rdFacturadoDescuento" id="rdFacturadoDescuentoS" value="S" />Si                                        
                                             <input type="radio" name="rdFacturadoDescuento" id="rdFacturadoDescuentoN" value="N" />No        
                                             <script type="text/javascript">
                                                 $("[name=rdFacturadoDescuento]").filter("[value='<%=strFacturadoDescuento%>']").prop("checked",true);
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgFacturadoDescuento" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>
                                     <tr>
                                         <td class="LABELFORM">* Fecha de registro:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtFechaDescuento" name="txtFechaDescuento" value="<%=dtFechaDescuento.toString()%>" class="CAMPOFORM" readonly="true">&nbsp;                          
                                             <img src="Images/Calendario.JPG" id="imgFechaDescuento" class='IMGCALENDAR'>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgVFechaDescuento" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                  
                                         <td class="LABELFORM">Fecha de facturación:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>
                                         <td class="CELDACAMPOFORM">
                                             <%if(dtFechaAplicacion == null){%>
                                                 <input type="text" id="txtFechaFacturacionDescuento" name="txtFechaFacturacionDescuento" value="" class="CAMPOFORM" readonly="true">&nbsp;                          
                                                 <img src="Images/Calendario.JPG" id="imgFechaFacturacionDescuento" class='IMGCALENDAR'>
                                             <%}else{%>
                                                 <input type="text" id="txtFechaFacturacionDescuento" name="txtFechaFacturacionDescuento" value="<%=dtFechaAplicacion.toString()%>" class="CAMPOFORM" readonly="true">&nbsp;                          
                                                 <img src="Images/Calendario.JPG" id="imgFechaFacturacionDescuento" class='IMGCALENDAR'>
                                             <%}%>                                    
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgVFechaFacturacionDescuento" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>                  
                                     <script type="text/javascript">
                                         setCalendario("txtFechaDescuento","imgFechaDescuento");
                                         setCalendario("txtFechaFacturacionDescuento","imgFechaFacturacionDescuento");
                                     </script>
                                 <%}%>
                                 <%if(strTieneConsumoAdicional.equals("S")){%>
                                     <input type="hidden" id="txtCodigoConsumoAdicional" name="txtCodigoConsumoAdicional" value="<%=intCodigoConsumoAdicional%>" />
                                     <tr><td colspan="7" style="height: 10px;"></td></tr>
                                     <tr>
                                         <td colspan="7" class="SUBTITULOFORM">CONSUMO ADICIONAL ASOCIADO</td>
                                     </tr>                                 
                                     <tr>              
                                         <td class="LABELFORM">* Item adicional:</td>
                                         <td class="CELDACAMPOFORM"  style="width: 350px;" >
                                             <select id="cbItemAdicional" name="cbItemAdicional" class="CAMPOSELECT">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(ItemAdicional itemAdicional : itemsAdicionales){%>
                                                     <option value="<%=itemAdicional.getCodigo()%>"><%=itemAdicional.getNombre()%></option>
                                                 <%}%>
                                             </select>                       
                                             <script type="text/javascript">
                                                 $("#cbItemAdicional").val("<%=strIdItemAdicional%>");
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgItemAdicional" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Valor ($):</td>
                                         <td class="CELDACAMPOFORM" style="width: 350px;">
                                             <input type="text" id="txtValorConsumoAdicional" name="txtValorConsumoAdicional" value="<%=lgValorUnidad%>" class="CAMPOFORM" style="width: 80px;">
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgValorConsumoAdicional" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>
                                     <tr>                  
                                         <td class="LABELFORM">* ¿Se factura?:</td>
                                         <td class="CELDARADIOFORM"  style="width: 350px;" >
                                             <input type="radio" name="rdSeFacturaConsumoA" id="rdSeFacturaConsumoAS" value="S" />Si                                        
                                             <input type="radio" name="rdSeFacturaConsumoA" id="rdSeFacturaConsumoAN" value="N" />No
                                             <script type="text/javascript">
                                                 $("[name=rdSeFacturaConsumoA]").filter("[value='<%=strSeFacturaConsumoAdicional%>']").prop("checked",true);
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSeFacturaConsumoA" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* ¿Facturado?:</td>
                                         <td class="CELDARADIOFORM" style="width: 350px;">
                                             <input type="radio" name="rdFacturadoConsumoA" id="rdFacturadoConsumoAS" value="S" />Si                                        
                                             <input type="radio" name="rdFacturadoConsumoA" id="rdFacturadoConsumoAN" value="N" />No        
                                             <script type="text/javascript">
                                                 $("[name=rdFacturadoConsumoA]").filter("[value='<%=strFacturadoConsumoAdicional%>']").prop("checked",true);
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgFacturadoConsumoA" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>
                                     <tr>
                                         <td class="LABELFORM">* Fecha del consumo adicional:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtFechaConsumoA" name="txtFechaConsumoA" value="<%=dtFechaConsumoAdicional.toString()%>" class="CAMPOFORM" readonly="true">&nbsp;                          
                                             <img src="Images/Calendario.JPG" id="imgFechaConsumoA" class='IMGCALENDAR'>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgVFechaConsumoA" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                  
                                         <td class="LABELFORM">Fecha de facturación:<br />&nbsp;&nbsp;&nbsp;(aaaa-mm-dd)</td>
                                         <td class="CELDACAMPOFORM">
                                             <%if(dtFechaFacturacionConsumoA == null){%>
                                                 <input type="text" id="txtFechaFacturacionConsumoA" name="txtFechaFacturacionConsumoA" value="" class="CAMPOFORM" readonly="true">&nbsp;                          
                                                 <img src="Images/Calendario.JPG" id="imgFechaFacturacionConsumoA" class='IMGCALENDAR'>
                                             <%}else{%>
                                                 <input type="text" id="txtFechaFacturacionConsumoA" name="txtFechaFacturacionConsumoA" value="<%=dtFechaFacturacionConsumoA.toString()%>" class="CAMPOFORM" readonly="true">&nbsp;                          
                                                 <img src="Images/Calendario.JPG" id="imgFechaFacturacionConsumoA" class='IMGCALENDAR'>
                                             <%}%>                                    
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgVFechaFacturacionConsumoA" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                     </tr>                  
                                     <script type="text/javascript">
                                         setCalendario("txtFechaConsumoA","imgFechaConsumoA");
                                         setCalendario("txtFechaFacturacionConsumoA","imgFechaFacturacionConsumoA");
                                     </script>
                                 <%}%>
                                 <tr><td colspan="7" style="height: 10px;"></td></tr>
                                 <tr>
                                     <td colspan="7" class="CELDABOTONFORM">                             
                                            <input type="submit" name="btnActualizar" id="btnActualizar" value="Actualizar" class="BOTONFORM" />&nbsp;&nbsp;&nbsp;
                                            <input type="button" name="btnSalir" id="btnSalir" value="Salir" class="BOTONFORM" onclick="javascript:window.close();" />                                   
                                    </td>
                                 </tr>                                                         
                                 <tr>
                                     <td colspan="7" class="MSGAVISOOBLG">
                                         Los campos marcados con (*) son obligatorios.
                                     </td>
                                 </tr>
                             </table>
                         </form>
                         <br />                   
                     </div>   
                <%}%>
            </article>
       </section>
       <footer>
            <br />
            <jsp:include page="footer.jsp" />                    
       </footer>
    </body>
</html>
