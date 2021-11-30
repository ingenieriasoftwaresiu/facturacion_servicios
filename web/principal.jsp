<%-- 
    Document   : principal
    Created on : 16/12/2014, 08:16:31 PM
    Author     : Jorge.correa
--%>

<%@page import="java.util.Vector"%>
<%@page import="co.edu.udea.facturacion.dao.impl.RolXUsuarioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.RolXUsuarioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.RolXUsuario"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page import="co.edu.udea.facturacion.dao.UsuarioSIUDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="comprobarSesion.jsp"></jsp:include>
<%
    String strPreload = null, strTipoUsuario = null, strEsAdmin = "N", strEsDllo = "N", strEsResp = "N", strEsUsuario = "N", strUsuario = null, strEsAuxProy="N";
    UsuarioSesionSIU usuarioSIU = null;       

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{        
        
        strPreload = (String) session.getAttribute("preload");
        strTipoUsuario = (String) session.getAttribute("tipoUsuario");
        usuarioSIU = (UsuarioSesionSIU) session.getAttribute("Usuario");
        
        Vector arrRoles = new Vector();
        List<RolXUsuario> rolesXusuario = null;
        RolXUsuarioDAO rolXusuario = new RolXUsuarioDAOImpl();
        strUsuario = usuarioSIU.getIdentificacion();
        rolesXusuario = rolesXusuario = rolXusuario.obtenerPorPersona(strUsuario);
        
        if (rolesXusuario != null){
            for(RolXUsuario rolUsuario : rolesXusuario){
                if (rolUsuario.getRol().equals("ADM")){
                    strEsAdmin = "S";            
                    arrRoles.add("ADM");
                }

                if (rolUsuario.getRol().equals("DES")){
                    strEsDllo = "S";
                    arrRoles.add("DES");
                }

                if (rolUsuario.getRol().equals("RESP")){
                    strEsResp = "S";
                    arrRoles.add("RESP");
                }
                
                if (rolUsuario.getRol().equals("AUXPROY")){
                    strEsAuxProy = "S";
                    arrRoles.add("AUXPROY");
                }                
            }
        }else{        
            if ((strEsAdmin.equals("N")) && (strEsDllo.equals("N")) && (strEsResp.equals("N")) && (strEsAuxProy.equals("N"))){
                strEsUsuario = "S";        
                arrRoles.add("USU");
            }     
        }
        
        session.setAttribute("rolesUsuario", arrRoles);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/menuh.css" />        
        <link rel="stylesheet" type="text/css" href="Styles/visualizacion.css" />
        <link rel="stylesheet" type="text/css" href="Styles/calendar-system.css" />
        <script type="text/javascript" src="Scripts/JSCalendar.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-es.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-setup.js"></script> 
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/principal.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/visualizacion.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/menu.js"></script>
        <title>Menú principal</title>
    </head>
    <body>
       <header>
           <jsp:include page="header.jsp" />  
       </header>
       <nav>
            <div id='cssmenu'>
                <ul>
                   <li class='active has-sub'><a href='#'><span>Consumos de servicios</span></a>
                      <ul>
                         <li><a href='#' id="itVerConsumosInsumos"><span>Ver consumos por insumos</span></a></li>
                         <li><a href='#' id="itVerConsumosTiposUsuario"><span>Ver consumos por tipos de usuario</span></a></li>
                         <li><a href='#' id="itVerConsumosUnidades"><span>Ver consumos por unidades</span></a></li>
                         <%if ((strEsAdmin.equals("S")) || (strEsDllo.equals("S")) || (strEsResp.equals("S"))){%>
                            <li><a href='#' id="itRegistrarConsumo"><span>Registrar nuevo consumo</span></a></li>
                         <%}%>
                      </ul>
                   </li>
                   <li class='active has-sub'><a href='#'><span>Cuentas de cobro</span></a>
                       <ul>
                         <li><a href='#' id="itVerCuentasCobro"><span>Ver cuentas de cobro</span></a></li>
                         <%if ((strEsAdmin.equals("S")) || (strEsDllo.equals("S")) || (strEsResp.equals("S"))){%>
                            <li><a href='#' id="itGenerarCuentaCobro"><span>Generar nueva cuenta de cobro</span></a></li>     
                         <%}%>
                      </ul>
                   </li>
                   <%if ((strEsAdmin.equals("S")) || (strEsDllo.equals("S")) || (strEsResp.equals("S"))){%>
                        <li>
                            <a href='#' id="itMenuInformes"><span>Informes</span></a>
                        </li>
                        <li>
                            <a href='#' id="itMenuIndicadores"><span>Indicadores</span></a>
                        </li>
                   <%}%>
                   <%if((strEsAdmin.equals("S")) || (strEsDllo.equals("S"))){%> 
                        <li>
                            <a href='#' id="itMenuAdministrativo"><span>Administración</span></a>
                        </li>
                   <%}%> 
                </ul>
            </div>
        </nav>
       <section>
           <article>   
               <%if (usuarioSIU != null){%>
                <div align="center">
                    <br />
                    <table cellspacing="0" cellpadding="0" width="98%" border="0">
                        <tr>
                             <% if(usuarioSIU != null){ %>                             
                                 <td class="USERLOGED" style="text-align: left;"><b>Bienvenido(a),</b>&nbsp;<span style="font-weight: normal;"><%=usuarioSIU.getNombreCompleto()%></span></td>
                             <%}else{%>
                                 <td class="USERLOGED" style="text-align: left;"><b>Bienvenido(a)!</b></td> 
                             <%}%>
                             <%if (strPreload.equals("N")){%>     
                                 <td class="CELDAACCION" style="border-left: 1px solid #116043;width: 120px;text-align: right;vertical-align: middle;"><input type="button" value="Salir" class="BOTONACCION" onclick="location.href='cerrar.jsp';" /></td>
                             <%}else{%>
                                 <td class="CELDAACCION" style="border-left: 1px solid #116043;width: 120px;text-align: right;vertical-align: middle;"><input type="button" value="Salir" class="BOTONACCION" onclick="javascript:window.close();" /></td>
                             <%}%>                                            
                         </tr>               
                    </table>
                     <br />
                     <table cellspacing="0" cellpadding="0" width="98%" border="0">
                        <tr>
                            <td style="width:990px;text-align: center;vertical-align: top;">
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
