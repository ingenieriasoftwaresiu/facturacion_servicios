<%-- 
    Document   : rolUsuario
    Created on : 14/04/2015, 02:52:18 PM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.RolUsuario"%>
<%@page import="co.edu.udea.facturacion.dao.impl.RolUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.RolUsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strAccion = null;
    RolUsuarioDAO rolUsuarioDAO = new RolUsuarioDAOImpl();
    RolUsuario rolUsuario = null;
    
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
                     
        if (strAccion.equals("V")){
            String strCodigo = request.getParameter("keyCC");
            rolUsuario = rolUsuarioDAO.obtenerUno(strCodigo);
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>        
        <script type="text/javascript" charset="UTF-8" src="Scripts/validacionesAdministrativo.js"></script>
        <title>Rol de usuario</title>
    </head>
    <body onLoad="setFocus('txtCodigo')">
        <header>
           <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <%if(strAccion != null){%>                   
                        <br />
                        <div align="center">
                            <form id="frmRolUsuario" name="frmRolUsuario" method="POST" action="RegistroAdministrativo" onsubmit="return validarRolUsuario()">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmRolUsuario" />
                                <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                                 <%if(strAccion.equals("C")){%>
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE ROL DE USUARIO</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Código:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCodigo" name="txtCodigo" value="" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCodigo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nombre:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNombre" name="txtNombre" value="" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNombre" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>            
                                        <tr>
                                         <td class="LABELFORM">* ¿Se autentica?:</td>
                                         <td class="CELDARADIOFORM">
                                             <input type="radio" name="rdSeAutentica" id="rdSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdSeAutentica" id="rdNo" value="N">No                                        
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSeAutentica" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>                                         
                                        </tr>
                                        <tr><td colspan="7" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td colspan="7" class="CELDABOTONFORM">                             
                                                <input type="submit" name="btnGuardar" id="btnGuardar" value="Guardar" class="BOTONFORM" />&nbsp;&nbsp;&nbsp;
                                                <input type="reset" name="btnLimpiar" id="btnLimpiar" value="Limpiar" class="BOTONFORM" onclick="setFocus('txtCodigo')" />&nbsp;&nbsp;&nbsp;
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
                                            <td colspan="7" class="TITULOFORM">REGISTRO DE ROL DE USUARIO</td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Código:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="text" id="txtCodigo" name="txtCodigo" value="<%=rolUsuario.getCodigo()%>" class="CAMPOFORMREAD" readOnly />
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgCodigo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                            <td class="ESPACIOBLANCO"></td>
                                            <td class="LABELFORM">* Nombre:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="text" id="txtNombre" name="txtNombre" value="<%=rolUsuario.getNombre()%>" class="CAMPOFORM" />
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgNombre" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                        </tr>             
                                        <tr>
                                            <td class="LABELFORM">* ¿Se autentica?:</td>
                                            <td class="CELDARADIOFORM">
                                                <input type="radio" name="rdSeAutentica" id="rdSeAutenticaSi" value="S">Si&nbsp;                                   
                                                <input type="radio" name="rdSeAutentica" id="rdSeAutenticaNo" value="N">No    
                                                <script type="text/javascript">                                                        
                                                    var strSeAutentica = "<%=rolUsuario.getSeAutentica()%>";                                                    
                                                    if (strSeAutentica == "S"){
                                                        $("#rdSeAutenticaSi").prop("checked", true);
                                                    }else{
                                                        $("#rdSeAutenticaNo").prop("checked", true);
                                                    }                                  
                                                </script>
                                            </td>                                            
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgSeAutentica" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
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
