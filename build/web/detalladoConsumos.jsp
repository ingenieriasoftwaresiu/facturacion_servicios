<%-- 
    Document   : detalladoConsumos
    Created on : 16/03/2015, 02:08:37 PM
    Author     : jorge.correa
--%>

<%@page import="java.math.RoundingMode"%>
<%@page import="java.util.Vector"%>
<%@page import="co.edu.udea.facturacion.dao.impl.DescuentoConsumoXUnidadDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXUnidadDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoAdicionalXUnidadDAO"%>
<%@page import="co.edu.udea.facturacion.dto.ConsumoServicioXUnidad"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoServicioXUnidadDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoServicioXUnidadDAO"%>
<%@page import="co.edu.udea.facturacion.dto.DescuentoConsumo"%>
<%@page import="co.edu.udea.facturacion.dao.impl.DescuentoConsumoXTipoUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.DescuentoConsumoXTipoUsuarioDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ItemAdicionalDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.ItemAdicional"%>
<%@page import="co.edu.udea.facturacion.dao.ItemAdicionalDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXTipoUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.ConsumoAdicional"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoAdicionalXTipoUsuarioDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.ParametroGeneral"%>
<%@page import="co.edu.udea.facturacion.dao.ParametroGeneralDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoServicioXTipoUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoServicioXTipoUsuarioDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ConsumoServicioXInsumoDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.ConsumoServicioXInsumo"%>
<%@page import="co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO"%>
<%@page import="java.util.Date"%>
<%@page import="co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.Subservicio"%>
<%@page import="co.edu.udea.facturacion.dao.SubservicioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.CuentaCobro"%>
<%@page import="co.edu.udea.facturacion.dao.impl.CuentaCobroDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.CuentaCobroDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.FuncionesComunesDAO"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="co.edu.udea.facturacion.dao.impl.FuncionesComunesConsumosDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dao.impl.DetalleCuentaCobroDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.DetalleCuentaCobro"%>
<%@page import="co.edu.udea.facturacion.dao.DetalleCuentaCobroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <link rel="stylesheet" type="text/css" href="Styles/cuenta-cobro.css" />
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/detalleCuentaCobro.js"></script>
        <title>Detallado de consumos</title>
    </head>
    <body>
         <header>
           <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <%if(detallesCuentaCobro != null){%>                           
                        <div align="center">                    
                            <br />
                            <div id="noprint">                            
                                <form id="frmAcciones" method="POST" action="#">
                                    <input type="hidden" id="txtEsAuxProy" name="txtEsAuxProy" value="<%=strEsAuxProy%>" />                                    
                                    <table cellspacing="0" cellpadding="0" border="0"style="width: 99%;">
                                        <tr>
                                            <td colspan="2" class="TEXTOACCION">                                                                                                     
                                            </td>
                                            <td colspan="2" class="BOTONESACCION">                                                                            
                                                <input type="button" id="btnImprimirDetalle" name="btnImprimirDetalle" value="Imprimir" class="BOTONFORM" onclick="imprimirDetalle()" />&nbsp;&nbsp;&nbsp;
                                                <input type="button" id="btnSalir" name="btnSalir" value="Salir" class="BOTONFORM" onclick="javascript:window.close()" />                                    
                                            </td>
                                        </tr>
                                    </table>
                              </form>                          
                           </div>                     
                            <br />
                            <table cellspacing="0" cellpadding="0" border="0" class="TABLAMAESTRO" style="width: 99%;">
                                <tr>
                                    <td class="TITULOFORM" colspan="6" style="border-bottom: 1px solid #116043;">DETALLADO DE CONSUMOS DE LA CUENTA DE COBRO #<%=strIdCuentaCobro%> PARA EL PERIODO <%=strFechaInicio%> A <%=strFechaFin%></td>
                                </tr>                           
                                <tr>
                                    <td colspan="6">
                                        <table cellspacing="0" cellpadding="3" border="0" style="width: 100%;">                                            
                                            <%for(DetalleCuentaCobro detalleCuentaCobro: detallesCuentaCobro){%>                       
                                                <%strIdServicio = detalleCuentaCobro.getServicio();%>
                                                <%if(!(strIdServicio.equals(strIdServicioBase))){
                                                    strNombreServicio = funcionesComunesConsumosDAO.obtenerServicio(strIdServicio);       
                                                    bdTotalServicio = detalleCuentaCobroDAO.obtenerTotalPorServicioYCuentaCobro(lgIdCuentaCobro, strIdServicio);                                    
                                                %>
                                                    <tr>
                                                        <td class="CATEGORIASERVICIO" style="width: 80%;border-right: 1px solid #116043;border-top: 1px solid #116043;" colspan="3"><%=strNombreServicio%></td>
                                                        <!--<td class="CATEGORIASERVICIO" style="border-bottom: 1px solid #116043;border-right: 1px solid #116043;width: 10%;"></td>-->
                                                        <td class="CATEGORIASERVICIO" style="text-align: center;width: 10%;border-top: 1px solid #116043;">$<%=funcionesComunesDAO.marcarMiles(bdTotalServicio.toString())%></td>
                                                    </tr>        
                                                    <%
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
                                                               strAplicaSubcantidad = subservicio.getAplicaSubcantidad();%>                        
                                                               
                                                               <tr>
                                                                    <td colspan="3" class="SUBCATEGORIASUBSERVICIO" style="padding-left: 10px;border-right: 1px solid #116043;border-top: 1px solid #116043;"><%=strNombreSubservicio%></td>
                                                                    <td class="SUBCATEGORIASUBSERVICIO" style="text-align: center;border-top: 1px solid #116043;">$<%=funcionesComunesDAO.marcarMiles(bdTotalSubservicio.toString())%></td>
                                                                </tr>
                                                                
                                                               <%if (strTipoFacturacion.equals("INSUMOS")){                                                      
                                                                    consumosServicioXInsumo = consumoServicioXInsumoDAO.obtenerConsumosPorServicioSubservicioCuentaCobro(strIdServicio, strIdSubservicio, lgIdCuentaCobro);%>                                                                   
                                                                    <tr>
                                                                        <td colspan="4">
                                                                            <br />
                                                                            <div align="center">
                                                                                <table cellspacing="0" cellpadding="2" border="0" class="TABLACONSUMOS">                   
                                                                                    <tr>
                                                                                        <td colspan="3" class="TITULOFORM">DETALLE DE CONSUMOS</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td class="SUBTITULOFORM">Nombre del insumo</td>
                                                                                        <td class="SUBTITULOFORM">Cantidad consumida</td>
                                                                                        <td class="SUBTITULOFORM">Fecha del consumo&nbsp;(aaaa-mm-dd)</td>                                                      
                                                                                    </tr>
                                                                                        <%for(ConsumoServicioXInsumo consumoServicioXInsumo : consumosServicioXInsumo){
                                                                                                intSubcantidadConsumo = consumoServicioXInsumo.getSubcantidad();
                                                                                                bdCantidadConsumo = consumoServicioXInsumo.getCantidadUnidad();%>
                                                                                                <tr>
                                                                                                    <td class="TEXTOCONSUMO" style="border-right: 1px solid #116043;"><%=funcionesComunesConsumosDAO.obtenerInsumo(consumoServicioXInsumo.getInsumo())%></td>
                                                                                                    <%if (funcionesComunesDAO.tieneDecimales(bdCantidadConsumo)){%>
                                                                                                        <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=bdCantidadConsumo.setScale(2, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXInsumo.getUnidadMedida())%></td>
                                                                                                     <%}else{%>
                                                                                                        <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=bdCantidadConsumo.setScale(0, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXInsumo.getUnidadMedida())%></td>
                                                                                                     <%}%>
                                                                                                    <td class="TEXTOCONSUMO" style="text-align: center;"><%=consumoServicioXInsumo.getFechaConsumo().toString()%></td>                                                      
                                                                                                </tr>
                                                                                        <%
                                                                                                bdCantidadConsumo = null;                                                                                                
                                                                                            }
                                                                                        
                                                                                            if (strAplicaSubcantidad.equals("S")){
                                                                                                 strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();%>
                                                                                                 <tr>
                                                                                                     <td colspan="3" class="TEXTONOTAS">* <%=strEtiquetaSubcantidad%>:&nbsp;<%=intSubcantidadConsumo.toString()%>.</td>
                                                                                                 </tr>
                                                                                            <%} 
                                                                                        %>
                                                                                </table>
                                                                            </div>
                                                                            <br />
                                                                        </td>                                                                       
                                                                    </tr>
                                                               <%}
                                                                                                                               
                                                              if (strTipoFacturacion.equals("TIPOUSUARI")){                            
                                                                   consumosServicioXTipoUsuario = consumoServicioXTipoUsuarioDAO.obtenerConsumosPorServicioSubservicioCuentaCobroCodigo(strIdServicio, strIdSubservicio, lgIdCuentaCobro, intCodigoConsumo);%>
                                                                   <tr>
                                                                        <td colspan="4">
                                                                            <br />
                                                                            <div align="center">
                                                                                <table cellspacing="0" cellpadding="2" border="0" class="TABLACONSUMOS">                   
                                                                                    <tr>
                                                                                        <td colspan="4" class="TITULOFORM">DETALLE DE CONSUMOS</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td class="SUBTITULOFORM">Tipo de usuario</td>
                                                                                        <td class="SUBTITULOFORM">Cantidad consumida</td>
                                                                                        <td class="SUBTITULOFORM">Fecha del consumo&nbsp;(aaaa-mm-dd)</td>                                                      
                                                                                        <td class="SUBTITULOFORM">Concepto</td>
                                                                                    </tr>                                                                   
                                                                                        <%for(ConsumoServicioXTipoUsuario consumoServicioXTipoUsuario : consumosServicioXTipoUsuario){                                                                                           
                                                                                            strConceptoConsumo = consumoServicioXTipoUsuario.getConcepto();
                                                                                            strCantidadConsumo = consumoServicioXTipoUsuario.getCantidadUnidad().toString() + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXTipoUsuario.getUnidadMedida());%>
                                                                                            
                                                                                            <tr>
                                                                                                <td class="TEXTOCONSUMO" style="border-right: 1px solid #116043;"><%=funcionesComunesConsumosDAO.obtenerTipoUsuario(consumoServicioXTipoUsuario.getTipoUsuario())%></td>
                                                                                                <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=strCantidadConsumo%></td>
                                                                                                <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=consumoServicioXTipoUsuario.getFechaConsumo().toString()%></td>                                                      
                                                                                                <%if(strConceptoConsumo.equals("")){%>
                                                                                                    <td class="TEXTOCONSUMO" style="text-align: center;">-</td>
                                                                                                <%}else{%>
                                                                                                    <td class="TEXTOCONSUMO" style="text-align: center;"><%=strConceptoConsumo%></td>
                                                                                                <%}%>                                                                                                
                                                                                            </tr>
                                                                                           
                                                                                            <%if (strAplicaSubcantidad.equals("S")){
                                                                                                 strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();            
                                                                                                 intSubcantidadConsumo = consumoServicioXTipoUsuario.getSubcantidad();%>
                                                                                                 <tr>
                                                                                                     <td colspan="4" class="TEXTONOTAS">* <%=strEtiquetaSubcantidad%>:&nbsp;<%=intSubcantidadConsumo.toString()%>.</td>
                                                                                                 </tr>
                                                                                            <%}

                                                                                            strAplicaSancion = consumoServicioXTipoUsuario.getAplicarSancion();

                                                                                            if (strAplicaSancion.equals("S")){                                                                                               
                                                                                                parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
                                                                                                strPorcentajeSancion = String.valueOf(parametroGeneral.getPorcentajeSancion());%>
                                                                                                <tr>
                                                                                                     <td colspan="4" class="TEXTONOTAS">* A este consumo le aplica una sanción del <%=strPorcentajeSancion%>%.</td>
                                                                                                </tr>                                                                                                
                                                                                      <%}%>
                                                                                            
                                                                                </table>
                                                                                <br/>
                                                                                        <%consumosAdicionales = consumoAdicionalXTipoUsuarioDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                                            if ((consumosAdicionales != null) && (consumosAdicionales.size() > 0)){%>                                                                                    
                                                                                                <table cellspacing="0" cellpadding="2" border="0" class="TABLACONSUMOS">                   
                                                                                                    <tr>
                                                                                                        <td colspan="3" class="TITULOFORM">DETALLE CONSUMO ADICIONAL</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="SUBTITULOFORM">Ítem adicional</td>
                                                                                                        <td class="SUBTITULOFORM">Valor ($)</td>
                                                                                                        <td class="SUBTITULOFORM">Fecha &nbsp;(aaaa-mm-dd)</td>                                                                                                                             
                                                                                                    </tr>
                                                                                                <%for (ConsumoAdicional consumoAdicional : consumosAdicionales){
                                                                                                    strNombreItemAdicional = itemAdicionalDAO.obtenerUno(consumoAdicional.getItemAdicional()).getNombre();
                                                                                                    strValorItemAdicional = funcionesComunesDAO.marcarMiles(consumoAdicional.getValorUnidad().toString());%>
                                                                                                    <tr>
                                                                                                        <td class="TEXTOCONSUMO" style="border-right: 1px solid #116043;"><%=strNombreItemAdicional%></td>
                                                                                                        <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=strValorItemAdicional%></td>
                                                                                                        <td class="TEXTOCONSUMO" style="text-align: center;"><%=consumoAdicional.getFechaConsumo()%></td>                                                      
                                                                                                    </tr>
                                                                                                <%}%>
                                                                                                </table>
                                                                                                <br/>
                                                                                            <%}

                                                                                            descuentoConsumo = descuentoConsumoXTipoUsuarioDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                                            if (descuentoConsumo != null){%>                                                                                
                                                                                                <table cellspacing="0" cellpadding="2" border="0" class="TABLACONSUMOS">                   
                                                                                                    <tr>
                                                                                                        <td colspan="3" class="TITULOFORM">DETALLE DESCUENTO</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="SUBTITULOFORM">Valor del descuento</td>                                                                                                  
                                                                                                        <td class="SUBTITULOFORM">Fecha &nbsp;(aaaa-mm-dd)</td>               
                                                                                                        <td class="SUBTITULOFORM">Concepto</td>
                                                                                                    </tr>
                                                                                               <%strConceptoDescuento = descuentoConsumo.getConcepto();
                                                                                                strPorcentajeDescuento = String.valueOf(descuentoConsumo.getDescuento());
                                                                                                bdValorDescuento = new BigDecimal(strPorcentajeDescuento);%>
                                                                                                
                                                                                                    <tr>
                                                                                                        <%if(funcionesComunesDAO.tieneDecimales(bdValorDescuento)){%>
                                                                                                            <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=bdValorDescuento.setScale(2,roundingMode)%>%</td>
                                                                                                        <%}else{%>
                                                                                                            <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=bdValorDescuento.setScale(0,roundingMode)%>%</td>
                                                                                                        <%}%>                                                                                                        
                                                                                                        <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=descuentoConsumo.getFechaRegistra()%></td>
                                                                                                        <%if(strConceptoDescuento.equals("")){%>
                                                                                                            <td class="TEXTOCONSUMO" style="text-align: center;">-</td>
                                                                                                        <%}else{%>
                                                                                                            <td class="TEXTOCONSUMO" style="text-align: center;"><%=strConceptoDescuento%></td>
                                                                                                        <%}%>                                                                                                                                                              
                                                                                                    </tr>
                                                                                                </table>
                                                                                                <br/>
                                                                                            <%}           
                                                                                            bdValorDescuento = null;
                                                                                        }%>
                                                                            </div>                 
                                                                        </td>                                                                       
                                                                    </tr>
                                                               <%}

                                                               if (strTipoFacturacion.equals("UNDS")){
                                                                   consumosServicioXUnidad= consumoServicioXUnidadDAO.obtenerConsumosPorServicioSubservicioCuentaCobro(strIdServicio, strIdSubservicio, lgIdCuentaCobro);%>
                                                                   <tr>
                                                                        <td colspan="4">
                                                                            <br />
                                                                            <div align="center">
                                                                                <table cellspacing="0" cellpadding="2" border="0" class="TABLACONSUMOS">                   
                                                                                    <tr>
                                                                                        <td colspan="3" class="TITULOFORM">DETALLE DE CONSUMOS</td>
                                                                                    </tr>
                                                                                    <tr>                                                        
                                                                                        <td class="SUBTITULOFORM">Cantidad consumida</td>
                                                                                        <td class="SUBTITULOFORM">Fecha del consumo&nbsp;(aaaa-mm-dd)</td>                                                      
                                                                                        <td class="SUBTITULOFORM">Concepto</td>
                                                                                    </tr>
                                                                                    <%for(ConsumoServicioXUnidad consumoServicioXUnidad : consumosServicioXUnidad){
                                                                                           intCodigoConsumo = consumoServicioXUnidad.getCodigo();
                                                                                           strConceptoConsumo = consumoServicioXUnidad.getConcepto();                                                                                           
                                                                                           bdCantidadConsumo = consumoServicioXUnidad.getCantidadUnidad();%>
                                                                                            <tr>                                    
                                                                                                <%if (funcionesComunesDAO.tieneDecimales(bdCantidadConsumo)){%>
                                                                                                    <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=bdCantidadConsumo.setScale(2, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXUnidad.getUnidadMedida())%></td>
                                                                                                <%}else{%>
                                                                                                    <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=bdCantidadConsumo.setScale(0, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicioXUnidad.getUnidadMedida())%></td>
                                                                                                <%}%>
                                                                                                <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=consumoServicioXUnidad.getFechaConsumo().toString()%></td>                                                      
                                                                                                <%if(consumoServicioXUnidad.getConcepto().equals("")){%>
                                                                                                    <td class="TEXTOCONSUMO" style="text-align: center;">-</td>
                                                                                                <%}else{%>
                                                                                                    <td class="TEXTOCONSUMO" style="text-align: center;"><%=consumoServicioXUnidad.getConcepto()%></td>
                                                                                                <%}%>                                                                                                 
                                                                                            </tr>
                                                                                </table>
                                                                                <br/>

                                                                                    <%consumosAdicionales = consumoAdicionalXUnidadDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                                           if ((consumosAdicionales != null) && (consumosAdicionales.size() > 0)){%>
                                                                                                 <table cellspacing="0" cellpadding="2" border="0" class="TABLACONSUMOS">                   
                                                                                                    <tr>
                                                                                                        <td colspan="3" class="TITULOFORM">DETALLE CONSUMO ADICIONAL</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="SUBTITULOFORM">Ítem adicional</td>
                                                                                                        <td class="SUBTITULOFORM">Valor ($)</td>
                                                                                                        <td class="SUBTITULOFORM">Fecha &nbsp;(aaaa-mm-dd)</td>                                                                                                                             
                                                                                                    </tr>
                                                                                              <%for (ConsumoAdicional consumoAdicional : consumosAdicionales){
                                                                                                   strNombreItemAdicional = itemAdicionalDAO.obtenerUno(consumoAdicional.getItemAdicional()).getNombre();
                                                                                                   strValorItemAdicional = funcionesComunesDAO.marcarMiles(consumoAdicional.getValorUnidad().toString());%>
                                                                                                    <tr>
                                                                                                        <td class="TEXTOCONSUMO" style="border-right: 1px solid #116043;"><%=strNombreItemAdicional%></td>
                                                                                                        <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=strValorItemAdicional%></td>
                                                                                                        <td class="TEXTOCONSUMO" style="text-align: center;"><%=consumoAdicional.getFechaConsumo()%></td>                                                      
                                                                                                    </tr>
                                                                                                <%}%>
                                                                                                </table>
                                                                                                <br/>
                                                                                           <%}

                                                                                           descuentoConsumo = descuentoConsumoXUnidadDAO.obtenerPorConsumo(intCodigoConsumo);

                                                                                           if (descuentoConsumo != null){%>                                                                                
                                                                                                <table cellspacing="0" cellpadding="2" border="0" class="TABLACONSUMOS">                   
                                                                                                    <tr>
                                                                                                        <td colspan="3" class="TITULOFORM">DETALLE DESCUENTO</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="SUBTITULOFORM">Valor del descuento</td>                                                                                                  
                                                                                                        <td class="SUBTITULOFORM">Fecha &nbsp;(aaaa-mm-dd)</td>               
                                                                                                        <td class="SUBTITULOFORM">Concepto</td>
                                                                                                    </tr>
                                                                                               <%strConceptoDescuento = descuentoConsumo.getConcepto();
                                                                                                strPorcentajeDescuento = String.valueOf(descuentoConsumo.getDescuento());
                                                                                                bdValorDescuento = new BigDecimal(strPorcentajeDescuento);%>
                                                                                                    <tr>
                                                                                                        <%if(funcionesComunesDAO.tieneDecimales(bdValorDescuento)){%>
                                                                                                            <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=bdValorDescuento.setScale(2,roundingMode)%>%</td>
                                                                                                        <%}else{%>
                                                                                                            <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=bdValorDescuento.setScale(0,roundingMode)%>%</td>
                                                                                                        <%}%>                                                                                                        
                                                                                                        <td class="TEXTOCONSUMO" style="text-align: center;border-right: 1px solid #116043;"><%=descuentoConsumo.getFechaRegistra()%></td>
                                                                                                        <%if(strConceptoDescuento.equals("")){%>
                                                                                                            <td class="TEXTOCONSUMO" style="text-align: center;">-</td>
                                                                                                        <%}else{%>
                                                                                                            <td class="TEXTOCONSUMO" style="text-align: center;"><%=strConceptoDescuento%></td>
                                                                                                        <%}%>     
                                                                                                    </tr>
                                                                                                </table>
                                                                                                <br/>
                                                                                    <%}                   
                                                                                           bdCantidadConsumo =  null;
                                                                                           bdValorDescuento = null;
                                                                                        }%>
                                                                            </div>                 
                                                                        </td>                                                                       
                                                                    </tr>
                                                            <%}                                                                                             
                                                                                                        
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
                                                    %>
                                                <%
                                                        bdTotalPagar = bdTotalPagar.add(bdTotalServicio);
                                                    }

                                                    strIdServicioBase = strIdServicio;
                                                    strIdServicio = "";
                                                    strNombreServicio = null;
                                                    bdTotalServicio = null;                    
                                                    detalleCuentaCobro = null;
                                                %>                    
                                            <%}%>
                                            <tr>
                                                <td colspan="3" class="CATEGORIATOTAL" style="text-align: left;border-right: 1px solid #116043;border-top: 1px solid #116043;">TOTAL POR CONSUMOS DE SERVICIOS / SUBSERVICIOS</td>
                                                <td class="CATEGORIATOTAL" style="text-align: center;border-top: 1px solid #116043;">$<%=funcionesComunesDAO.marcarMiles(bdTotalPagar.toString())%></td>
                                            </tr>                            
                                            <tr>
                                                <td class="MSGAVISOOBLG" colspan="4">* Los valores de dinero relacionados en la tabla anterior se especifican en pesos colombianos ($).</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>                            
                            </table>                              
                        </div>                
                    <%}else{%>
                        <br /><br /><br /><br />
                        <div class="TEXTOFALLO" style="font-size: 18px;">
                            No se pudo obtener el detalladp de consumos para la cuenta de cobro especificada.<br />Si requiere mayor información, póngase en contacto con Ingeniería de Software SIU.<br /><br />
                            <input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close()" />
                        </div>
                        <br /><br />
                    <%}%>
            </article>
       </section>
       <footer>
            <br />
            <jsp:include page="footer.jsp" />                    
       </footer>
    </body>
</html>
