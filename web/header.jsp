<%-- 
    Document   : header
    Created on : 1/12/2014, 09:30:19 AM
    Author     : Jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.ParametroGeneral"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ParametroGeneralDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Obtener el título y subtitulo de la aplicación.
    String strTituloApp = null, strSubtituloApp = null;
    ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
    ParametroGeneral parametroGeneral = null;
    parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
    
    if (parametroGeneral != null){
        strTituloApp = parametroGeneral.getTituloApp();
        strSubtituloApp =parametroGeneral.getSubtituloApp();
    }else{
        strTituloApp = "Sistema de Facturación Unificada de Servicios";
        strSubtituloApp = "Dirección Científica SIU";
    }
  %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styles/comunes.css" />   
    </head>
    <body>
        <table cellspacing="0" cellpadding="0" border="0" class="TABLAHEADER">
            <tr>
                <td rowspan="2" class="CELDALOGOAPP">
                    <img src="Images/Logo.png" class="IMGLOGOAPP"/>
                </td>
                <td rowspan="2" class="CELDATEXTOTITULO">
                    <%=strTituloApp%>
                </td>               
                <td style="height: 50px;"></td>
            </tr>
            <tr class="CELDATEXTOSUBTITULO">
                <td><%=strSubtituloApp%></td>
            </tr>
        </table>
    </body>
</html>
