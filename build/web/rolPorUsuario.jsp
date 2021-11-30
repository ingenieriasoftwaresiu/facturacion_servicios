<%-- 
    Document   : rolPorUsuario
    Created on : 15/04/2015, 10:13:49 AM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.UsuarioSIUDAO"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dao.impl.RolXUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.RolXUsuario"%>
<%@page import="co.edu.udea.facturacion.dao.RolXUsuarioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.RolUsuario"%>
<%@page import="co.edu.udea.facturacion.dao.impl.RolUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.RolUsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strAccion = null;
    RolXUsuarioDAO rolXUsuarioDAO = new RolXUsuarioDAOImpl();
    RolXUsuario rolXUsuario = null;
    
    RolUsuarioDAO rolUsuarioDAO = new RolUsuarioDAOImpl();
    List<RolUsuario> rolesUsuario = null;
    
    rolesUsuario = rolUsuarioDAO.obtenerTodos();
    
    UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
    List<UsuarioSesionSIU> usuariosSIU = null;
    
    usuariosSIU = usuarioSIUDAO.obtenerTodos();
        
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
                     
        if (strAccion.equals("V")){
            String strRol = request.getParameter("keyCC");
            String strPersona = request.getParameter("keyCC2");
            rolXUsuario = rolXUsuarioDAO.obtenerUno(strPersona, strRol);
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
        <title>Rol por usuario</title>
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
                            <form id="frmRolXUsuario" name="frmRolXUsuario" method="POST" action="RegistroAdministrativo" onsubmit="return validarRolXUsuario()">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmRolXUsuario" />
                                <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                                 <%if(strAccion.equals("C")){%>
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE ROL POR USUARIO</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Código:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbRol" name="cbRol" class="CAMPOSELECT" style="width: 250px;">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(RolUsuario rolUsuario : rolesUsuario){%>
                                                    <option value="<%=rolUsuario.getCodigo()%>"><%=rolUsuario.getNombre()%></option>
                                                 <%}%>
                                             </select>                                             
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgRol" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nombre:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbUsuario" name="cbUsuario" class="CAMPOSELECT" style="width: 250px;">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(UsuarioSesionSIU usuarioSIU : usuariosSIU){%>
                                                    <option value="<%=usuarioSIU.getIdentificacion()%>"><%=usuarioSIU.getNombreCompleto()%></option>
                                                 <%}%>
                                             </select>                                             
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgUsuario" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
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
                                                <select id="cbRol" name="cbRol" class="CAMPOSELECTDISABLED" style="width: 250px;" disabled="disabled">
                                                    <option value="-1">Seleccione una opción</option>
                                                    <%for(RolUsuario rolUsuario : rolesUsuario){%>
                                                       <option value="<%=rolUsuario.getCodigo()%>"><%=rolUsuario.getNombre()%></option>
                                                    <%}%>
                                                    <script type="text/javascript">
                                                        $("#cbRol").val("<%=rolXUsuario.getRol()%>");
                                                    </script>                                                        
                                             </select>
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgCodigo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                            <td class="ESPACIOBLANCO"></td>
                                            <td class="LABELFORM">* Nombre:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select id="cbUsuario" name="cbUsuario" class="CAMPOSELECTDISABLED" style="width: 250px;" disabled="disabled"> 
                                                    <option value="-1">Seleccione una opción</option>
                                                    <%for(UsuarioSesionSIU usuarioSIU : usuariosSIU){%>
                                                       <option value="<%=usuarioSIU.getIdentificacion()%>"><%=usuarioSIU.getNombreCompleto()%></option>
                                                    <%}%>
                                                    <script type="text/javascript">
                                                        $("#cbUsuario").val("<%=rolXUsuario.getPersona()%>");
                                                    </script>
                                             </select>
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgNombre" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                        </tr>                                                    
                                        <tr><td colspan="7" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td colspan="7" class="CELDABOTONFORM">                             
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
