<%-- 
    Document   : ingresoConsumo
    Created on : 29/12/2014, 11:27:06 AM
    Author     : George
--%>

<%@page import="co.edu.udea.facturacion.dto.Dependencia"%>
<%@page import="co.edu.udea.facturacion.dao.impl.DependenciaDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.DependenciaDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ServicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.Servicio"%>
<%@page import="co.edu.udea.facturacion.dao.ServicioDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UsuarioConsumoSIUDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioConsumoSIU"%>
<%@page import="co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO"%>
<%@page import="co.edu.udea.facturacion.dto.TipoUsuarioConsumo"%>
<%@page import="co.edu.udea.facturacion.dao.impl.TipoUsuarioConsumoDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dao.impl.TipoUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.TipoUsuarioConsumoDAO"%>
<%@page import="co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.FuncionesComunesDAO"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="comprobarSesion.jsp"></jsp:include>
<%
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
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <link rel="stylesheet" type="text/css" href="Styles/ingreso-consumos.css" />
        <link rel="stylesheet" type="text/css" href="Styles/calendar-system.css" />
        <script type="text/javascript" src="Scripts/JSCalendar.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-es.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-setup.js"></script> 
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ingresoConsumo.js"></script>
        <title>Ingreso de consumos de servicios</title>
    </head>
    <body>
       <header>
           <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <%if(strAccion != null){%>
                    <%if(strAccion.equals("C")){%>
                         <br />
                         <div align="center">
                             <form id="frmIngresoConsumo" name="frmIngresoConsumo" method="POST" action="RegistroConsumos" onsubmit="return validarConsumos()">
                                 <input type="hidden" id="txtIdUsuarioRegistra" name="txtIdUsuarioRegistra" value="<%=usuarioSIU.getIdentificacion()%>" />
                                 <input type="hidden" id="txtAccion" name="txtAccion" value="<%=strAccion%>" />
                                 <input type="hidden" id="txtCamposDiligenciados" name="txtCamposDiligenciados" />
                                 <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                      <tr>
                                          <td colspan="7" class="TITULOFORM">INGRESO DE CONSUMOS DE SERVICIOS</td>
                                      </tr>                            
                                      <tr>
                                          <td class="LABELFORM">Fecha de registro (aaaa-mm-dd):</td>
                                          <td class="CELDACAMPOFORM"><input type="text" id="txtFechaRegistro" name="txtFechaRegistro" value="<%=funcionesComunesDAO.getFechaActual()%>" class="CAMPOFORMREAD" readonly="true"/></td>
                                          <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgFechaRegistro" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                          <td class="ESPACIOBLANCO"></td>
                                          <td class="LABELFORM">Usuario que registra:</td>
                                          <td class="CELDACAMPOFORM"><input type="text" id="txtUsuarioRegistra" name="txtUsuarioRegistra" value="<%=usuarioSIU.getUsuario()%>" class="CAMPOFORMREAD" readonly="true"/></td>
                                          <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgUsuarioRegistra" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                      </tr>
                                      <tr><td colspan="7" class="BORDEINFERIOR" style="height: 10px;"></td></tr>
                                      <tr>
                                          <td class="LABELFORM">* Tipo de usuario del consumo:</td>
                                          <td class="CELDACAMPOFORM">
                                              <select id="cbTipoUsuarioConsumo" name="cbTipoUsuarioConsumo" class="CAMPOSELECT">
                                                  <option value="-1">Seleccione una opción</option>
                                                  <%
                                                     if (tiposUsuariosConsumo != null){
                                                         for(TipoUsuarioConsumo tipoUsuarioConsumo : tiposUsuariosConsumo){%>
                                                             <option value="<%=tipoUsuarioConsumo.getCodigo()%>"><%=tipoUsuarioConsumo.getNombre()%></option>
                                                  <%     }
                                                     }%>  
                                              </select>
                                          </td>
                                          <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgTipoUsuarioConsumo" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                          <td class="ESPACIOBLANCO"></td>     
                                          <td colspan="3">
                                              <div id="dUsuarioInterno">
                                                  <table cellspacing="0" cellpadding="0" border="0" width="100%">
                                                      <tr>
                                                         <td class="LABELFORM" style="width: 160px;">* Nombre del usuario consumidor:</td>
                                                         <td class="CELDACAMPOFORM">
                                                             <select id="cbUsuarioConsumo" name="cbUsuarioConsumo" class="CAMPOSELECT">
                                                                 <option value="-1">Seleccione una opción</option>
                                                                 <%
                                                                     if (usuariosConsumos != null){
                                                                         for(UsuarioConsumoSIU usuarioConsumo : usuariosConsumos){%>
                                                                             <option value="<%=usuarioConsumo.getCodigo()%>"><%=usuarioConsumo.getNombre()%></option>
                                                                  <%     }
                                                                     }%>
                                                             </select>
                                                         </td>
                                                         <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgUsuarioConsumoI" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                                      </tr>
                                                  </table>
                                              </div>
                                              <div id="dUsuarioUdeANoSIU">                                                  
                                                  <table cellspacing="0" cellpadding="0" border="0" width="100%">
                                                      <tr>
                                                         <td class="LABELFORM" style="width: 160px;">* Nombre del usuario consumidor:</td>
                                                         <td class="CELDACAMPOFORM">
                                                             <input type="hidden" id="txtIdDependencia" name="txtIdDependencia" />
                                                             <input type="text" id="txtNombreDependencia" name="txtNombreDependencia" class="CAMPOFORMREAD" readOnly />&nbsp;
                                                             <input type="button" id="btnBuscarDependencia" name="btnBuscarDependencia" value="Seleccionar" class="BOTONFORM" onClick="buscarDependencia();" />
                                                         </td>
                                                         <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgUsuarioConsumoUNS" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                                      </tr>
                                                  </table>
                                              </div>
                                              <div id="dUsuarioExterno">
                                                  <table cellspacing="0" cellpadding="0" border="0" width="100%">
                                                      <tr>
                                                         <td class="LABELFORM" style="width: 160px;">* Nombre del usuario consumidor:</td>
                                                         <td class="CELDACAMPOFORM">
                                                             <input type="hidden" id="txtIdExterno" name="txtIdExterno" />
                                                             <input type="text" id="txtNombreExterno" name="txtNombreExterno" class="CAMPOFORMREAD" readOnly />&nbsp;
                                                             <input type="button" id="btnBuscarExterno" name="btnBuscarExterno" value="Buscar" class="BOTONFORM" onClick="buscarExterno();" />
                                                         </td>
                                                         <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgUsuarioConsumoE" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                                      </tr>
                                                  </table>
                                              </div>
                                          </td>                                     
                                      </tr>
                                      <tr><td colspan="7" style="height: 5px;"></td></tr>
                                      <tr>
                                          <td class="LABELFORM">* Nombre del servicio consumido:</td>
                                          <td class="CELDACAMPOFORM">
                                              <select id="cbServicioConsumido" name="cbServicioConsumido" class="CAMPOSELECT" style="width: 310px;">
                                                  <option value="-1">Seleccione una opción</option>
                                                  <%
                                                     if (servicios != null){
                                                         for(Servicio servicio : servicios){%>
                                                             <option value="<%=servicio.getCodigo()%>"><%=servicio.getNombre()%></option>
                                                  <%     }
                                                     }%>  
                                              </select>
                                          </td>
                                          <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgServicioConsumido" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                          <td class="ESPACIOBLANCO"></td>
                                          <td colspan="3">
                                              <div id="dSubservicio">                                             
                                              </div>
                                          </td>                                     
                                      </tr>
                                      <tr>
                                          <td class='LABELFORM'>* Fecha de inicio del consumo:<br/>&nbsp;&nbsp;(aaaa-mm-dd)</td>
                                          <td class='CELDACAMPOFORM'>
                                              <input type='text' name='txtFechaIni' id='txtFechaIni' class='CAMPOFORM' readOnly>&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaIni'>
                                          </td>
                                          <td class='CELDAIMGERROR'><img src='Images/error.png' id='imgFechaInicial' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>
                                          <td class='ESPACIOBLANCO'></td>
                                          <td class='LABELFORM'><label id='lblFechaFin'>* Fecha de fin del consumo:<br/>&nbsp;&nbsp;(aaaa-mm-dd)</label></td>
                                          <td class='CELDACAMPOFORM'>
                                              <input type='text' name='txtFechaFin' id='txtFechaFin' class='CAMPOFORM' readOnly>&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaFin'>                                                                                                
                                          </td>
                                          <td class='CELDAIMGERROR'><img src='Images/error.png' id='imgFechaFinal' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>                                                                                    
                                      </tr>                                      
                                      <tr><td colspan="7" style="height: 5px;"></td></tr>
                                      <tr>
                                          <td colspan="7" class="CELDABOTONFORM">
                                              <div id="dBotonesInicio">
                                                 <input type="button" name="btnIngresarConsumos" id="btnIngresarConsumos" value="Ingresar consumos" class="BOTONFORM" style="width: 110px;" />&nbsp;&nbsp;&nbsp;
                                                 <input type="button" name="btnLimpiar" id="btnLimpiar" value="Limpiar" class="BOTONFORM" />&nbsp;&nbsp;&nbsp;
                                                 <input type="button" name="btnSalir" id="btnSalir" value="Salir" class="BOTONFORM" onclick="javascript:window.close();" />
                                              </div>
                                              <div id="dLoader" align="center" class="TEXTOEXITO" style="vertical-align: middle;">
                                                  <img src="Images/loader.gif" style="vertical-align: middle;width: 30px;height: 30px;" />&nbsp;&nbsp;Cargando...
                                              </div>
                                         </td>
                                      </tr>                         
                                      <tr>
                                          <td colspan="7">
                                              <div id="dIngresoConsumos">                                             
                                              </div>
                                          </td>
                                      </tr>
                                      <tr><td colspan="7" style="height: 5px;"></td></tr>
                                      <tr>
                                          <td colspan="7" class="MSGAVISOOBLG">
                                              Los campos marcados con (*) son obligatorios.
                                          </td>
                                      </tr>
                                 </table>
                            </form>
                         </div>
                        <div id="dFechaConsumo">                                             
                        </div>
                     <%}%>
                <%}%>
            </article>
       </section>
        <br />
       <footer>
            <br />
            <jsp:include page="footer.jsp" />                    
       </footer>
    </body>
</html>
