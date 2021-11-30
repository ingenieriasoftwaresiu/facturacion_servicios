<%-- 
    Document   : parametroGeneral
    Created on : 19/04/2015, 10:54:20 AM
    Author     : George
--%>

<%@page import="co.edu.udea.facturacion.dto.ParametroGeneral"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ParametroGeneralDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>        
        <script type="text/javascript" charset="UTF-8" src="Scripts/validacionesAdministrativo.js"></script>
        <title>Parámetros generales</title>
    </head>
    <body onLoad="setFocus('txtTituloApp')">
        <header>
           <jsp:include page="header.jsp" />  
        </header>
        <section>
           <article>
               <%if(strAccion != null){%>
                    <br />
                    <div align="center">
                        <form id="frmGeneral" name="frmGeneral" method="POST" action="RegistroAdministrativo" onsubmit="return validarParametrosGenerales()">
                            <input type="hidden" name="txtForm" id="txtForm" value="frmGeneral" />
                            <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                            <%if(strAccion.equals("C")){%>                        
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE PARÁMETROS GENERALES</td>
                                        </tr>
                                        <tr>
                                            <td colspan="7" class="SUBTITULOFORM">Datos generales de la aplicación</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Título de la aplicación:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtTituloApp" name="txtTituloApp" class="CAMPOFORM" style="width: 250px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgTituloApp" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Subtítulo de la aplicación:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtSubtituloApp" name="txtSubtituloApp" class="CAMPOFORM" style="width: 250px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSubtituloApp" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Token para consumo de servicios web:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtToken" name="txtToken" class="CAMPOFORM" style="width: 250px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgToken" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>      
                                          <td class="LABELFORM">* Nro. de registros a mostrar en vistas:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNroRegistrosMostrar" name="txtNroRegistrosMostrar" class="CAMPOFORM" maxlength="3" style="width: 50px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNroRegistrosMostrar" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr><td colspan="7" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td colspan="7" class="SUBTITULOFORM">Datos para el envío de correos electrónicos</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nombre del servidor SMTP:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNomServidor" name="txtNomServidor" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNomServidor" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nro. del puerto de conexión:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNroPuerto" name="txtNroPuerto" class="CAMPOFORM" maxlength="5" style="width: 50px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNroPuerto" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nombre de usuario:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNomUsuario" name="txtNomUsuario" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNomUsuario" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Contraseña del usuario:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="password" id="txtContrasena" name="txtContrasena" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgContrasena" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr><td colspan="7" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td colspan="7" class="SUBTITULOFORM">Datos para el cálculo de la facturación</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nro. días para cálculo de fecha límite:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNroDiasFechaLimite" name="txtNroDiasFechaLimite" class="CAMPOFORM" maxlength="4" style="width: 50px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNroDiasFechaLimite" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* % de sanción por incumplimiento:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtPorcSancionImpl" name="txtPorcSancionImpl" class="CAMPOFORM" maxlength="4" style="width: 50px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgPorcSancionImpl" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr><td colspan="7" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td colspan="7" class="CELDABOTONFORM">                             
                                                <input type="submit" name="btnGuardar" id="btnGuardar" value="Guardar" class="BOTONFORM" />&nbsp;&nbsp;&nbsp;
                                                <input type="reset" name="btnLimpiar" id="btnLimpiar" value="Limpiar" class="BOTONFORM" onclick="setFocus('txtTituloApp')" />&nbsp;&nbsp;&nbsp;
                                                <input type="button" name="btnSalir" id="btnSalir" value="Salir" class="BOTONFORM" onclick="javascript:window.close();" />                                   
                                           </td>
                                        </tr>                                                         
                                        <tr>
                                            <td colspan="7" class="MSGAVISOOBLG">
                                                Los campos marcados con (*) son obligatorios.
                                            </td>
                                        </tr>
                                    </table>
                              <%}else{%>
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">REGISTRO DE PARÁMETROS GENERALES</td>
                                        </tr>
                                        <tr>
                                            <td colspan="7" class="SUBTITULOFORM">Datos generales de la aplicación</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Título de la aplicación:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtTituloApp" name="txtTituloApp" value="<%=parametroGeneral.getTituloApp()%>" class="CAMPOFORM" style="width: 250px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgTituloApp" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Subtítulo de la aplicación:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtSubtituloApp" name="txtSubtituloApp" value="<%=parametroGeneral.getSubtituloApp()%>" class="CAMPOFORM" style="width: 250px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSubtituloApp" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Token para consumo de servicios web:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtToken" name="txtToken" value="<%=parametroGeneral.getTokenServiciosWeb()%>" class="CAMPOFORM" style="width: 250px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgToken" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>      
                                          <td class="LABELFORM">* Nro. de registros a mostrar en vistas:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNroRegistrosMostrar" name="txtNroRegistrosMostrar" value="<%=parametroGeneral.getNumeroRegistrosXPagina().toString()%>" class="CAMPOFORM" maxlength="3" style="width: 50px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNroRegistrosMostrar" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr><td colspan="7" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td colspan="7" class="SUBTITULOFORM">Datos para el envío de correos electrónicos</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nombre del servidor SMTP:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNomServidor" name="txtNomServidor" value="<%=parametroGeneral.getNombreServidor()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNomServidor" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nro. del puerto de conexión:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNroPuerto" name="txtNroPuerto" value="<%=parametroGeneral.getNumeroPuerto().toString()%>" class="CAMPOFORM" maxlength="5" style="width: 50px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNroPuerto" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nombre de usuario:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNomUsuario" name="txtNomUsuario" value="<%=parametroGeneral.getUsuarioConexion()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNomUsuario" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Contraseña del usuario:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="password" id="txtContrasena" name="txtContrasena" value="<%=parametroGeneral.getClaveConexion()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgContrasena" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr><td colspan="7" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td colspan="7" class="SUBTITULOFORM">Datos para el cálculo de la facturación</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nro. días para cálculo de fecha límite:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNroDiasFechaLimite" name="txtNroDiasFechaLimite" value="<%=parametroGeneral.getNumeroDiasLimitePago().toString()%>" class="CAMPOFORM" maxlength="4" style="width: 50px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNroDiasFechaLimite" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* % de sanción por incumplimiento:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtPorcSancionImpl" name="txtPorcSancionImpl" value="<%=parametroGeneral.getPorcentajeSancion()%>" class="CAMPOFORM" maxlength="4" style="width: 50px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgPorcSancionImpl" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
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
                              <%}%>
                        </form>
                    </div>                                         
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
