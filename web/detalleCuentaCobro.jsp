<%-- 
    Document   : detalleCuentaCobro
    Created on : 27/01/2015, 11:57:53 AM
    Author     : Jorge.correa
--%>

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
<jsp:include page="comprobarSesion.jsp"></jsp:include>
<%
    String strIdCuentaCobro=null, strIdServicioBase="",strIdServicio="", strIdSubservicio="", strNombreServicio="", strNombreSubservicio="", strConceptoSubservicio="";
    String strFechaInicio="", strFechaFin="", strTipoFacturacion="", strInsumosFijos="", strAplicaSubcantidad="", strEtiquetaSubcantidad="", strConceptoConsumo="", strCantidadConsumo="";
    String strAplicaSancion="N", strPorcentajeSancion="", strNombreItemAdicional=null, strValorItemAdicional=null, strConceptoDescuento=null, strPorcentajeDescuento=null;
    String strIdTipoUsuario=null, strIdUsuario = null, strNombreUsuario="", strAcuerdo="-", strEsAuxProy="N";
    String strDependenciaB="-", strCentroCostosB="-", strDependenciaP="-", strCentroCostosP="-", strNombreOrdenadorG="-", strCargoOrdenadorG="-", strObservacion="-";
    String strNumeroSoporte="-", strFechaSoporte="-", strValorSoporte="-";
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
    Boolean haySesion = Boolean.TRUE;
    Vector arrRoles = null;
    
    if (session.getAttribute("Usuario") == null){
        haySesion = Boolean.FALSE;
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{ 
        
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
                strIdTipoUsuario = cuentaCobro.getTipoUsuarioConsumo();
                strIdUsuario = cuentaCobro.getUsuarioConsumo();
                dtFechaGeneracion = cuentaCobro.getFechaCreacion();
                strAcuerdo = cuentaCobro.getAcuerdoCobro();                
                strDependenciaB = cuentaCobro.getDependenciaBeneficiaria();
                strCentroCostosB = cuentaCobro.getCentroCostosBeneficiario();
                strDependenciaP = cuentaCobro.getDependenciaPagadora();
                strCentroCostosP = cuentaCobro.getCentroCostosPagador();
                strNombreOrdenadorG = cuentaCobro.getNombreOrdenadorGasto();
                strCargoOrdenadorG = cuentaCobro.getCargoOrdenadorGasto();
                strObservacion = cuentaCobro.getObservacion();
                                
                if (cuentaCobro.getNumeroSoporte() != null){
                    strNumeroSoporte = cuentaCobro.getNumeroSoporte();
                }
                
                if (cuentaCobro.getFechaSoporte() != null){
                    strFechaSoporte = cuentaCobro.getFechaSoporte().toString();
                }
                
                if (cuentaCobro.getValorSoporte() != null){
                    strValorSoporte = cuentaCobro.getValorSoporte().toString();
                }
                
                strNombreUsuario = funcionesComunesConsumosDAO.obtenerUsuario(strIdUsuario, strIdTipoUsuario);
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
        <link rel="stylesheet" type="text/css" href="Styles/cuenta-cobro.css" />
        <link rel="stylesheet" type="text/css" href="Styles/calendar-system.css" />
        <script type="text/javascript" src="Scripts/JSCalendar.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-es.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-setup.js"></script> 
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/detalleCuentaCobro.js"></script>
        <title>Detalle de cuenta de cobro</title>
    </head>
    <body>
        <header>
           <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
                <%if(haySesion){%>
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
                                                <input type="button" id="btnVerDetallado" name="btnVerDetallado" value="Ver Detallado" class="BOTONFORM" onclick="verDetalladoConsumos('<%=strIdCuentaCobro%>')" />&nbsp;&nbsp;&nbsp;
                                                <input type="button" id="btnImprimir" name="btnImprimir" value="Imprimir" class="BOTONFORM" />&nbsp;&nbsp;&nbsp;
                                                <input type="button" id="btnSalir" name="btnSalir" value="Salir" class="BOTONFORM" onclick="javascript:window.close()" />                                    
                                            </td>
                                        </tr>
                                    </table>
                              </form>                          
                           </div>                                                    
                            <table cellspacing="0" cellpadding="0" border="0" class="TABLAMAESTRO" style="width: 99%;">
                                <tr>
                                    <td class="TITULOFORM" colspan="6" style="border-bottom: 1px solid #116043;">CONSOLIDADO DE CONSUMOS DE LA CUENTA DE COBRO #<%=strIdCuentaCobro%> PARA EL PERIODO <%=strFechaInicio%> A <%=strFechaFin%></td>
                                </tr>
                                <tr>
                                    <td class="LABELFORM" style="width: 30%;color: #000;">
                                        <label for=""> Fecha de generación: (aaaa-mm-dd)</label>
                                    </td> 
                                    <td class="CELDACAMPOFORM" style="width: 20%;">
                                        <input type="text" id="txtFechaGeneracion" name="txtFechaGeneracion" value="<%=dtFechaGeneracion.toString()%>" class="CAMPOFORMREAD" />
                                    </td>
                                    <td style="width: 5%;"></td>
                                    <td class="LABELFORM" style="width: 20%;color: #000;">
                                        <label for="" > Usuario asociado:</label>
                                    </td>
                                    <td class="CELDACAMPOFORM" style="width: 25%;">
                                        <input type="text" id="txtUsuarioAsociado" name="txtUsuarioAsociado" value="<%=strNombreUsuario%>"  class="CAMPOFORMREAD" style="width: 310px;" />
                                    </td>
                                    <td></td>
                                </tr>
                                <tr><td colspan="6"  style="height: 10px;"></td></tr>
                                <tr>
                                    <td colspan="6">
                                        <table cellspacing="0" cellpadding="3" border="0" style="width: 100%;">
                                            <tr>                                
                                                <td class="SUBTITULOFORM" style="border-right: 1px solid #116043;border-bottom: 1px solid #116043;border-top: 1px solid #116043;">Nombre del Servicio / Subservicio</td>
                                                <td class="SUBTITULOFORM" style="border-right: 1px solid #116043;border-bottom: 1px solid #116043;border-top: 1px solid #116043;">Concepto del consumo del Servicio / Subservicio</td>
                                                <td class="SUBTITULOFORM" style="border-right: 1px solid #116043;border-bottom: 1px solid #116043;border-top: 1px solid #116043;">Fecha del consumo<br />(aaaa-mm-dd)</td>
                                                <td class="SUBTITULOFORM" style="border-bottom: 1px solid #116043;border-top: 1px solid #116043;">Valor consumido ($)</td>
                                            </tr>
                                            <%for(DetalleCuentaCobro detalleCuentaCobro: detallesCuentaCobro){%>                       
                                                <%strIdServicio = detalleCuentaCobro.getServicio();%>
                                                <%if(!(strIdServicio.equals(strIdServicioBase))){
                                                    strNombreServicio = funcionesComunesConsumosDAO.obtenerServicio(strIdServicio);       
                                                    bdTotalServicio = detalleCuentaCobroDAO.obtenerTotalPorServicioYCuentaCobro(lgIdCuentaCobro, strIdServicio);                                    
                                                %>
                                                    <tr>
                                                        <td class="CATEGORIASERVICIO" style="width: 80%;border-right: 1px solid #116043;" colspan="3"><%=strNombreServicio%></td>
                                                        <!--<td class="CATEGORIASERVICIO" style="border-bottom: 1px solid #116043;border-right: 1px solid #116043;width: 10%;"></td>-->
                                                        <td class="CATEGORIASERVICIO" style="text-align: center;width: 10%;">$<%=funcionesComunesDAO.marcarMiles(bdTotalServicio.toString())%></td>
                                                    </tr>        
                                                    <%
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
                                                            %>
                                                            <tr>
                                                                <td class="CATEGORIASUBSERVICIO" style="padding-left: 20px;border-right: 1px solid #116043;"><%=strNombreSubservicio%></td>
                                                                <td class="CATEGORIASUBSERVICIO" style="border-right: 1px solid #116043;"><%=strConceptoSubservicio%></td>
                                                                <td class="CATEGORIASUBSERVICIO" style="border-right: 1px solid #116043;text-align: center;"><%=dtFechaConsumo.toString()%></td>
                                                                <td class="CATEGORIASUBSERVICIO" style="text-align: center;">$<%=funcionesComunesDAO.marcarMiles(bdTotalSubservicio.toString())%></td>
                                                            </tr>  
                                                            <%
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
                                                <td colspan="3" class="CATEGORIATOTAL" style="text-align: left;border-right: 1px solid #116043;">TOTAL POR CONSUMOS DE SERVICIOS / SUBSERVICIOS</td>
                                                <td class="CATEGORIATOTAL" style="text-align: center;">$<%=funcionesComunesDAO.marcarMiles(bdTotalPagar.toString())%></td>
                                            </tr>                            
                                            <tr>
                                                <td class="MSGAVISOOBLG" colspan="4">* Los valores de dinero relacionados en la tabla anterior se especifican en pesos colombianos ($).</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>                            
                            </table>                                               
                            <div id="noprint2">
                                <br />
                                <form id="frmDatosFacturacion" name="frmDatosFacturacion" method="POST" action="GuardarDatosFacturacion" onsubmit="return validarDatos()">
                                    <input type="hidden" id="txtIdCuentaCobro" name="txtIdCuentaCobro" value="<%=strIdCuentaCobro%>" />
                                    <input type="hidden" id="txtAcuerdoCobro" name="txtAcuerdoCobro" value="<%=strAcuerdo%>" />                                                                      
                                    <table cellspacing="0" cellpadding="0" border="0" style="width: 93%;" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM" style="border-bottom: 1px solid #116043">DATOS PARA FACTURACIÓN</td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM" style="width: 30%;">¿El usuario está de acuerdo con el cobro?:</td>
                                              <td class="CELDARADIOFORM" colspan="6">                                                  
                                                    <%if(strAcuerdo.equals("S")){%>
                                                        <input type="text" value="Si" class="CAMPOFORMREAD" readonly/>                                        
                                                    <%}else{%>
                                                        <%if(strAcuerdo.equals("N")){%>
                                                            <input type="text" value="No" class="CAMPOFORMREAD" readonly/>
                                                        <%}else{%>
                                                            <input type="text" value="Por definir" class="CAMPOFORMREAD" readonly/>
                                                        <%}%>
                                                    <%}%>
                                              </td>                     
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM" style="width: 30%;">Dependencia beneficiaria del pago:</td>
                                              <td class="CELDACAMPOFORM" colspan="3">
                                                  <input type="text" id="txtDependenciaB" name="txtDependenciaB" value="<%=strDependenciaB%>" class="CAMPOFORMREAD" readonly/>
                                              </td>                              
                                              <td class="LABELFORM" style="width: 30%;">Centro de costos:</td>
                                              <td class="CELDACAMPOFORM" colspan="2">
                                                  <input type="text" id="txtCentroCostosB" name="txtCentroCostosB" value="<%=strCentroCostosB%>" class="CAMPOFORMREAD" readonly />
                                              </td>                                       
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">Dependencia que realiza el pago:</td>
                                              <td class="CELDACAMPOFORM" colspan="3">
                                                  <input type="text" id="txtDependenciaP" name="txtDependenciaP" value="<%=strDependenciaP%>" class="CAMPOFORMREAD" readonly />
                                              </td>                                
                                              <td class="LABELFORM">Centro de costos:</td>
                                              <td class="CELDACAMPOFORM" colspan="2">
                                                  <input type="text" id="txtCentroCostosP" name="txtCentroCostosP" value="<%=strCentroCostosP%>" class="CAMPOFORMREAD" readonly />
                                              </td>                   
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">Nombre del Ordenador del Gasto:</td>
                                              <td class="CELDACAMPOFORM" colspan="3">
                                                  <input type="text" id="txtOrdenadorGasto" name="txtOrdenadorGasto" value="<%=strNombreOrdenadorG%>" class="CAMPOFORMREAD" readonly />
                                              </td>                    
                                              <td class="LABELFORM">Cargo del Ordenador del Gasto:</td>
                                              <td class="CELDACAMPOFORM" colspan="2">
                                                  <input type="text" id="txtCargoOrdenadorGasto" name="txtCargoOrdenadorGasto" value="<%=strCargoOrdenadorG%>" class="CAMPOFORMREAD" readonly />
                                              </td>                               
                                        </tr>                   
                                        <tr>
                                            <td class="LABELFORM">Observación:</td>
                                            <td class="CELDACAMPOFORM" colspan="4">
                                                  <input type="text" id="txtObservacion" name="txtObservacion" value="<%=strObservacion%>" class="CAMPOFORMREAD" style="width: 100%;" />
                                              </td>
                                        </tr>
                                        <tr>
                                            <td colspan="7" style="height: 10px;">                                       
                                            </td>
                                        </tr>                             
                                    </table>                      
                                </form>
                            </div>                      
                            <%if(strEsAuxProy.equals("S")){%>
                                <%if(strAcuerdo.equals("S")){%>
                                    <%if(strNumeroSoporte.equals("-")){%>
                                        <div id="dDatosSoporte">
                                            <form id="frmDatosSoporte" name="frmDatosSoporte" action="GuardarDatosSoporte" method="POST" onsubmit="return validarDatosSoporte()">                 
                                                <input type="hidden" id="txtIdCuentaCobro" name="txtIdCuentaCobro" value="<%=strIdCuentaCobro%>" />
                                                <table cellspacing="0" cellpadding="0" border="0" style="width: 93%;" class="TABLAMAESTRO">
                                                    <tr>
                                                        <td colspan="7" class="TITULOFORM" style="border-bottom: 1px solid #116043">PARA USO EXCLUSIVO DE ADMINISTRACIÓN DE PROYECTOS</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="LABELFORM">* Número de factura o transferencia:</td>
                                                          <td class="CELDACAMPOFORM">
                                                              <input type="text" id="txtNumeroSoporte" name="txtNumeroSoporte" class="CAMPOFORM" />
                                                          </td>
                                                          <td class="CELDAIMGERROR">
                                                              <img src="Images/error.png" id="imgNumeroSoporte" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                                          </td>
                                                          <td class="ESPACIOBLANCO"></td>
                                                          <td class="LABELFORM">* Fecha: (aaaa-mm-dd)</td>
                                                          <td class="CELDACAMPOFORM">
                                                              <input type="text" id="txtFechaSoporte" name="txtFechaSoporte" class="CAMPOFORM" readOnly />&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaSoporte'>
                                                          </td>
                                                          <td class="CELDAIMGERROR">
                                                              <img src="Images/error.png" id="imgFechaSoporteV" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                                          </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="LABELFORM">* Valor: ($)</td>
                                                          <td class="CELDACAMPOFORM">
                                                              <input type="text" id="txtValorSoporte" name="txtValorSoporte" class="CAMPOFORM" />
                                                          </td>
                                                          <td class="CELDAIMGERROR">
                                                              <img src="Images/error.png" id="imgValorSoporte" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                                          </td>
                                                          <td class="ESPACIOBLANCO" colspan="4"></td>                                                      
                                                    </tr>
                                                    <tr>
                                                      <td colspan="7" class="CELDABOTONFORM">
                                                          <input type="submit" id="btnGuardarDatosSoporte" name="btnGuardarDatosSoporte" value="Guardar" class="BOTONFORM" />&nbsp;&nbsp;
                                                          <input type="reset" id="btnLimpiar" name="btnLimpiar" value="Limpiar" class="BOTONFORM" />
                                                      </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="7" class="MSGAVISOOBLG">
                                                            Los campos marcados con (*) son obligatorios.
                                                        </td>
                                                    </tr>
                                                </table>
                                                <script type="text/javascript">
                                                    cargarCalendarios();
                                                </script>
                                             </form>
                                        </div>
                                    <%}else{%>
                                        <div id="dDatosSoporte">
                                            <form id="frmDatosSoporte" name="frmDatosSoporte" action="GuardarDatosSoporte" method="POST" onsubmit="return validarDatosSoporte()">                 
                                                <input type="hidden" id="txtIdCuentaCobro" name="txtIdCuentaCobro" value="<%=strIdCuentaCobro%>" />
                                                <table cellspacing="0" cellpadding="0" border="0" style="width: 93%;" class="TABLAMAESTRO">
                                                    <tr>
                                                        <td colspan="7" class="TITULOFORM" style="border-bottom: 1px solid #116043">PARA USO EXCLUSIVO DE ADMINISTRACIÓN DE PROYECTOS</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="LABELFORM" style="width: 30%;">Número de factura o transferencia:</td>
                                                          <td class="CELDACAMPOFORM" colspan="3">
                                                              <input type="text" id="txtNumeroSoporte" name="txtNumeroSoporte" value="<%=strNumeroSoporte%>" class="CAMPOFORMREAD" readOnly />
                                                          </td>                                                 
                                                          <td class="LABELFORM" style="width: 30%;">Fecha: (aaaa-mm-dd)</td>
                                                          <td class="CELDACAMPOFORM" colspan="2">
                                                              <input type="text" id="txtFechaSoporte" name="txtFechaSoporte" value="<%=strFechaSoporte%>" class="CAMPOFORMREAD" readOnly />
                                                          </td>                                        
                                                    </tr>
                                                    <tr>
                                                        <td class="LABELFORM">Valor: ($)</td>
                                                          <td class="CELDACAMPOFORM" colspan="3">
                                                              <input type="text" id="txtValorSoporte" name="txtValorSoporte" value="<%=funcionesComunesDAO.marcarMiles(strValorSoporte)%>" class="CAMPOFORMREAD" readOnly />
                                                          </td>                                                                                                                                              
                                                    </tr>
                                                    <tr>
                                                        <td colspan="7" style="height: 10px;">                                       
                                                        </td>
                                                    </tr>                                                    
                                                </table>
                                                <script type="text/javascript">
                                                    cargarCalendarios();
                                                </script>
                                             </form>
                                        </div>
                                    <%}%>
                                <%}%>
                            <%}%>
                        </div>                
                    <%}else{%>
                        <br /><br /><br /><br />
                        <div class="TEXTOFALLO" style="font-size: 18px;">
                            No se pudo obtener el consolidado de consumos para la cuenta de cobro especificada.<br />Si requiere mayor información, póngase en contacto con Ingeniería de Software SIU.<br /><br />
                            <input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close()" />
                        </div>
                        <br /><br />
                    <%}%>
                <%}%>
           </article>
       </section>
       <footer>
            <br />
            <jsp:include page="footer.jsp" />                    
       </footer>
    </body>
</html>
