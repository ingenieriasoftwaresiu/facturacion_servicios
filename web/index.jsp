<%-- 
    Document   : index
    Created on : 8/08/2014, 02:10:01 PM
    Author     : jorge.correa
--%>

<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dto.RolUsuario"%>
<%@page import="co.edu.udea.facturacion.dao.impl.RolUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.RolUsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String strUsuario = null, strPreload = null;
    strUsuario = request.getParameter("txtCedula");    
    strPreload = request.getParameter("preload");        
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/login.js"></script>
        <title>Inicio de sesión del sistema</title>
    </head>
    <body>        
        <header>
            <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <div style="padding-top: 50px;"></div>
                <%if (strUsuario == null){%>
                        <div align="center">      
                            <br>
                            <form id="frmLogin" name="frmLogin" method="POST" action="IngresoUsuario">
                                    <table cellspacing="0" cellpadding="0" class="TABLAMAESTRO" border="0" style="width:320px;">                        
                                        <tr>
                                            <td colspan="3" style="text-align: center;" class="TITULOFORM">INICIO DE SESIÓN</td>				
                                        </tr>                   
                                        <tr>
                                           <%
                                                    RolUsuarioDAO rolUsuarioDAO = new RolUsuarioDAOImpl();
                                                    List<RolUsuario> rolesUsuarios = rolUsuarioDAO.obtenerTodosPorAutenticar("S");
                                            %>
                                            <td class="LABELFORM" style="width: 90px;padding-left: 10px;">* Tipo de usuario:</td>
                                            <td class="CELDARADIOFORM" style="vertical-align: middle;text-align: center;">
                                                <select name="txtTipoUsuario" id="txtTipoUsuario" class="CAMPOSELECT" style="width:145px;">
                                                    <option value="-1">Seleccione una opción</option>
                                                    <%
                                                        if (rolesUsuarios != null){
                                                            for(RolUsuario rolUsuario : rolesUsuarios){%>
                                                        <option value="<%=rolUsuario.getCodigo()%>"><%=rolUsuario.getNombre()%></option>
                                                    <%  }
                                                        }%>                                                                                     
                                                </select>                                    
                                            </td>
                                            <td>
                                                <img src="Images/error.png" id="imgTipoUsuario" alt="Campo obligatorio" class="IMGERROR">
                                            </td>
                                        </tr>
                                        <tr>
                                                <td class="LABELFORM" style="width: 90px;padding-left: 10px;">* Usuario:</td>
                                                <td class="CELDACAMPOFORM" style="width: 150px;text-align: center;">
                                                    <input type="text" name="txtUsuario" id="txtUsuario" class="CAMPOFORM" style="width: 142px;">
                                                </td>
                                                <td style="width: 30px;text-align: left;"><img src="Images/error.png" id="imgUsuario" alt="Campo obligatorio" class="IMGERROR"></td>
                                        </tr>
                                        <tr>
                                                <td class="LABELFORM" style="width: 90px;padding-left: 10px;">* Contraseña:</td>
                                                <td class="CELDACAMPOFORM" style="width: 150px;text-align: center;">
                                                    <input type="password" name="txtPwd" id="txtPwd" class="CAMPOFORM" style="width: 142px;">
                                                </td>
                                                <td style="width: 30px;text-align: left;"><img src="Images/error.png" id="imgPwd" alt="Campo obligatorio" class="IMGERROR"></td>
                                        </tr>
                                        <tr>
                                                <td colspan="3" class="CELDABOTONFORM">
                                                    <input type="button" value="Ingresar" id="btnIngresar" class="BOTONFORM">&nbsp;&nbsp;
                                                    <input type="button" value="Limpiar" id="btnLimpiar" class="BOTONFORM">                                                
                                                </td>		
                                        </tr>
                                        <tr>
                                            <td class="MSGAVISOOBLG" colspan="3" style="padding-left: 3px;padding-bottom: 3px;">(*) Campo obligatorio.</td>
                                        </tr>
                                    </table>				
                            </form>
                            <br>
                            <div id="dMensaje" class="TEXTOFALLO">                
                            </div>
                        </div>  
                  <%}else{%>
                        <script type="text/javascript">
                            var dataString = "txtUsuario="+ <%=strUsuario%> + "&preload=" + <%=strPreload%>;                             
                            setTimeout(function(){AJAX_REDIRECT("POST","IngresoUsuario",dataString,"dMensaje","principal.jsp");},3000);
                        </script>
                        <div align="center">              
                            <div style="padding-top: 80px;"></div>            
                            <table cellspacing="0" cellpadding="0" width="600px"  border="0">                        
                                <tr>
                                        <td class="TEXTOHOMEBIG">BIENVENIDO!</td>                                
                                </tr>
                                <tr><td height="10px"></td></tr>
                                <tr>
                                        <td class="TEXTOHOMESMALL">Un momento por favor, la aplicación se está cargando para su acceso.</td>                                
                                </tr>
                                <tr><td height="15px"></td></tr>
                                <tr>
                                    <td style="text-align: center;"><img src="Images/loader.gif" width="40" height="40"></td>		
                                </tr>
                            </table>      
                        </div>
                  <%}%>
                  <br><br>
                <div align="center" class="MSGBROWSER">
                    <<< Para una mejor visualización, se recomienda utilizar el navegador web <b>Mozilla Firefox</b> ó <b>Google Chrome</b> en una resolución de pantalla superior 1024 x 768. >>>
                </div>
                <div style="padding-top: 10px;"></div>
           </article>
       </section>
       <footer>
           <div id="dFooter" class="FOOTER">
                <jsp:include page="footer.jsp" />          
            </div>
       </footer>
    </body>
</html>
