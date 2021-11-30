<%-- 
    Document   : busquedaDependencia
    Created on : 6/04/2015, 09:24:26 AM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.Dependencia"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dao.impl.DependenciaDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.DependenciaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    DependenciaDAO dependenciaDAO = new DependenciaDAOImpl();
    List<Dependencia> dependencias = dependenciaDAO.obtenerTodas();     
 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ingresoConsumo.js"></script>
        <title>Búsqueda de dependencia</title>
    </head>
    <body>
        <div align="center">
            <br />
            <form id="frmBusquedaDependencia" name="frmBusquedaDependencia" action="#" method="POST">
                <table cellspacing="0" cellpadding="0" border="0" class="TABLAMAESTRO" width="99%">
                    <tr>
                        <td class="TITULOFORM" colspan="5">BÚSQUEDA DE DEPENDENCIA</td>
                    </tr>
                    <tr>
                        <td class="LABELFORM">* Nombre:</td>
                        <td class="CELDACAMPOFORM">
                            <select id="cbDependencia" name="cbDependencia" class="CAMPOSELECT" style="width: 300px;">
                                <option value="-1">Seleccione una opción</option>
                                <%for(Dependencia dependencia : dependencias){%>
                                        <option value="<%=dependencia.getCodigo()%>"><%=dependencia.getNombre()%></option>
                                <%}%>
                            </select>
                        </td>
                        <td></td>                     
                    </tr>
                    <tr>
                        <td colspan="5" class="CELDABOTONFORM">
                            <input type="button" id="btnSeleccionar" name="btnSeleccionar" value="Seleccionar" class="BOTONFORM" onclick="validarBusquedaDependencia()"/>&nbsp;&nbsp;
                            <input type="reset" id="btnLimpiarBusqueda" name="btnLimpiarBusqueda" value="Limpiar" class="BOTONFORM" />&nbsp;&nbsp;
                            <input type="button" id="btnSalir" name="btnSalir" value="Salir" class="BOTONFORM" onclick="javascript:window.close();" />
                        </td>
                    </tr>
                </table>
            </form>
            <br />
            <div id="dResultado">                
            </div>
        </div>
    </body> 
</html>
