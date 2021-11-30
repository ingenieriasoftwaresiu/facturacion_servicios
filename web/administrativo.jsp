<%-- 
    Document   : administrativo
    Created on : 26/03/2015, 08:48:31 AM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.ParametroGeneral"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ParametroGeneralDAO"%>
<%@page import="java.util.Vector"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strTipoUsuario = null, strEsDllo = "N", strUsuario = null;
    UsuarioSesionSIU usuarioSIU = null;      
        
    ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
    ParametroGeneral parametroGeneral = null;

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{        
        strTipoUsuario = (String) session.getAttribute("tipoUsuario");
        usuarioSIU = (UsuarioSesionSIU) session.getAttribute("Usuario");
        
        parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
        
        Vector arrRoles = new Vector();
        arrRoles = (Vector) session.getAttribute("rolesUsuario");
                     
        if (arrRoles.contains("DES")){
            strEsDllo = "S";
        }        
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <link rel="stylesheet" type="text/css" href="Styles/menuh.css" />        
        <link rel="stylesheet" type="text/css" href="Styles/visualizacion.css" />
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/menu.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/administrativo.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/visualizacion.js"></script>
        <title>Menú administrativo</title>
    </head>
    <body>
        <header>
           <jsp:include page="header.jsp" />  
       </header>
       <nav>
            <div id='cssmenu'>
                <ul>
                   <li class='active has-sub'><a href='#'><span>Datos maestros</span></a>
                      <ul>
                        <li><a href='#' id="itUnidadesMedida"><span>Unidades de medida</span></a></li>
                        <li><a href='#' id="itTiposUsuario"><span>Tipos de usuario</span></a></li>
                        <li><a href='#' id="itTiposFacturacion"><span>Tipos de facturación</span></a></li>                         
                        <li><a href='#' id="itItemsAdicionales"><span>Ítem adicionales</span></a></li>                         
                        <li><a href='#' id="itInsumosServicios"><span>Insumos de servicios</span></a></li>                         
                      </ul>
                   </li>
                   <li class='active has-sub'><a href='#'><span>Configuración de servicios</span></a>
                       <ul>
                         <li><a href='#' id="itSubservicios"><span>Subservicios</span></a></li>
                         <li><a href='#' id="itServiciosXInsumos"><span>Servicios por insumos</span></a></li>
                         <li><a href='#' id="itServiciosXTiposUsuario"><span>Servicios por tipos de usuario</span></a></li>
                         <li><a href='#' id="itServiciosXUnidades"><span>Servicios por unidades</span></a></li>
                      </ul>
                   </li>
                   <%if (strEsDllo.equals("S")){%>
                        <li class='active has-sub'><a href='#'><span>Valores generales</span></a>
                            <ul>
                              <li><a href='#' id="itRolesUsuario"><span>Roles de usuario</span></a></li>                 
                              <li><a href='#' id="itRolesXUsuarios"><span>Roles por usuarios</span></a></li>       
                              <%if (parametroGeneral == null){%>
                                <li><a href='#' id="itCrearParametrosGenerales"><span>Crear parámetros generales</span></a></li>                 
                              <%}else{%>
                                <li><a href='#' id="itVerParametrosGenerales"><span>Ver parámetros generales</span></a></li>
                              <%}%>
                            </ul>
                        </li>
                   <%}%>
                </ul>
            </div>
            <br />
            <form id="frmAcciones" method="POST" action="#">                                    
                <table cellspacing="0" cellpadding="0" border="0"style="width: 99%;">
                    <tr>
                        <td colspan="2" class="TEXTOACCION">                                                                                                     
                        </td>
                        <td colspan="2" class="BOTONESACCION">                                      
                            <input type="button" id="btnSalir" name="btnSalir" value="Salir" class="BOTONFORM" onclick="javascript:window.close()" />                                    
                        </td>
                    </tr>
                </table>
          </form>
        </nav>
        <section>
           <article>   
               <%if (usuarioSIU != null){%>
                    <div align="center">
                        <br />       
                         <table cellspacing="0" cellpadding="0" width="98%" border="0">
                            <tr>
                                <td style="width:100%;text-align: center;vertical-align: top;">
                                    <div id="dMostrar">                                                          
                                    </div>
                                </td>
                            </tr>
                        </table>
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
