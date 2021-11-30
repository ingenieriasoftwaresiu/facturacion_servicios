<%-- 
    Document   : generarCuentaCobro
    Created on : 26/01/2015, 10:51:20 AM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.UsuarioConsumoSIU"%>
<%@page import="co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO"%>
<%@page import="co.edu.udea.facturacion.dao.TipoUsuarioConsumoDAO"%>
<%@page import="co.edu.udea.facturacion.dto.TipoUsuarioConsumo"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UsuarioConsumoSIUDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.impl.TipoUsuarioConsumoDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.FuncionesComunesDAO"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="comprobarSesion.jsp"></jsp:include>
<%
    String strAccion =  null;
    UsuarioSesionSIU usuarioSIU = null;       
    FuncionesComunesDAO funcionesComunesDAO = null;
    List<TipoUsuarioConsumo> tiposUsuariosConsumo = null;
     TipoUsuarioConsumoDAO tipoUsuarioConsumoDAO = null;
     UsuarioConsumoSIUDAO usuarioConsumoDAO = null;
     List<UsuarioConsumoSIU> usuariosConsumos = null;

    if (session.getAttribute("Usuario") == null){
            request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{
        strAccion = request.getParameter("txtAccion");
        usuarioSIU = (UsuarioSesionSIU) session.getAttribute("Usuario");
        funcionesComunesDAO = new FuncionesComunesDAOImpl();
        
        tipoUsuarioConsumoDAO = new TipoUsuarioConsumoDAOImpl();
        tiposUsuariosConsumo = tipoUsuarioConsumoDAO.obtenerTodos();
        
        usuarioConsumoDAO = new UsuarioConsumoSIUDAOImpl();
        usuariosConsumos = usuarioConsumoDAO.obtenerTodos();        
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
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/generarCuentaCobro.js"></script>
        <title>Generación de cuenta de cobro</title>
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
                             <form id="frmCuentaCobro" name="frmCuentaCobro" method="POST" action="RegistroCuentaCobro" onsubmit="return validarCuentaCobro()">         
                                 <input type="hidden" id="txtAccion" name="txtAccion" value="<%=strAccion%>" />
                                 <input type="hidden" id="txtIdUsuarioGenera" name="txtIdUsuarioGenera" value="<%=usuarioSIU.getIdentificacion()%>" />
                                 <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                      <tr>
                                          <td colspan="7" class="TITULOFORM">GENERAR CUENTA DE COBRO</td>
                                      </tr>                                                                 
                                      <tr><td colspan="7" style="height: 5px;"></td></tr>
                                      <tr>
                                          <td class="LABELFORM">Fecha de generación (aaaa-mm-dd):</td>
                                          <td class="CELDACAMPOFORM"><input type="text" id="txtFechaRegistro" name="txtFechaRegistro" value="<%=funcionesComunesDAO.getFechaActual()%>" class="CAMPOFORMREAD" readonly="true"/></td>
                                          <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgFechaRegistro" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                          <td class="ESPACIOBLANCO"></td>
                                          <td class="LABELFORM">Usuario que genera:</td>
                                          <td class="CELDACAMPOFORM"><input type="text" id="txtUsuarioRegistra" name="txtUsuarioRegistra" value="<%=usuarioSIU.getUsuario()%>" class="CAMPOFORMREAD" readonly="true"/></td>
                                          <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgUsuarioRegistra" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                      </tr>
                                      <tr><td colspan="7" style="height: 5px;"></td></tr>
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
                                                             <select id="cbUsuarioConsumo" name="cbUsuarioConsumo" class="CAMPOSELECT">
                                                                 <option value="-1">Seleccione una opción</option>                                                            
                                                             </select>
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
                                                             <select id="cbUsuarioConsumo" name="cbUsuarioConsumo" class="CAMPOSELECT">
                                                                 <option value="-1">Seleccione una opción</option>                                                            
                                                             </select>
                                                         </td>
                                                         <td class="CELDAIMGERROR"><img src="Images/error.png" id="imgUsuarioConsumoE" alt="Campo obligatorio" class="IMGERROR" style="display: none;"></td>
                                                      </tr>
                                                  </table>
                                              </div>
                                          </td>                                     
                                      </tr>
                                      <tr>
                                          <td class='LABELFORM'>* Fecha de inicio del periodo:<br/>&nbsp;&nbsp;(aaaa-mm-dd)</td>
                                          <td class='CELDACAMPOFORM'>
                                              <input type='text' name='txtFechaIni' id='txtFechaIni' class='CAMPOFORM' style="width: 180px;" readOnly>&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaIni'>
                                          </td>
                                          <td class='CELDAIMGERROR'>
                                              <img src='Images/error.png' id='imgFechaInicial' alt='Campo obligatorio' class='IMGERROR' style='display: none;'>
                                          </td>
                                          <td class='ESPACIOBLANCO'></td>
                                          <td class='LABELFORM'><label id='lblFechaFin'>* Fecha de fin del periodo:<br/>&nbsp;&nbsp;(aaaa-mm-dd)</label></td>
                                          <td class='CELDACAMPOFORM'>
                                              <input type='text' name='txtFechaFin' id='txtFechaFin' class='CAMPOFORM' style="width: 180px;" readOnly>&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaFin'>                                                                                                
                                          </td>
                                          <td class='CELDAIMGERROR'>
                                              <img src='Images/error.png' id='imgFechaFinal' alt='Campo obligatorio' class='IMGERROR' style='display: none;'>
                                          </td>                                                                                    
                                      </tr>
                                      <tr>
                                          <td colspan="7" class="CELDABOTONFORM">                                              
                                                 <input type="submit" name="btnIngresarCuentaCobro" id="btnIngresarCuentaCobro" value="Generar" class="BOTONFORM" />&nbsp;&nbsp;&nbsp;
                                                 <input type="button" name="btnLimpiar" id="btnLimpiar" value="Limpiar" class="BOTONFORM" />&nbsp;&nbsp;&nbsp;
                                                 <input type="button" name="btnSalir" id="btnSalir" value="Salir" class="BOTONFORM" onclick="javascript:window.close();" />&nbsp;&nbsp;&nbsp;                                                                                                                            
                                         </td>
                                      </tr>                                               
                                      <tr><td colspan="7" style="height: 5px;"></td></tr>
                                      <tr>
                                          <td colspan="7" class="MSGAVISOOBLG">
                                              Los campos marcados con (*) son obligatorios.
                                          </td>
                                      </tr>
                                 </table>
                                <script type="text/javascript">
                                    cargarCalendarios()
                                </script>    
                            </form>
                         </div>                        
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
