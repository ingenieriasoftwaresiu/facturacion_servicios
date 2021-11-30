<%-- 
    Document   : indicadores
    Created on : 15/04/2015, 09:55:33 AM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strTipoUsuario = null;
    UsuarioSesionSIU usuarioSIU = null;       

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{        
        strTipoUsuario = (String) session.getAttribute("tipoUsuario");
        usuarioSIU = (UsuarioSesionSIU) session.getAttribute("Usuario");
              
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
        <script type="text/javascript" charset="UTF-8" src="Scripts/informes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/visualizacion.js"></script>
        <title>Menú de indicadores</title>
    </head>
    <body>
         <header>
            <jsp:include page="header.jsp" />  
        </header>
        <nav>            
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
          <div align="center">
              <img src="Images/construccion.jpg" style="width: 30%;height: 30%;" alt="Sitio en construcción..."/>
          </div>          
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