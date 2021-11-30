<%-- 
    Document   : busquedaExterno
    Created on : 13/03/2015, 02:06:23 PM
    Author     : jorge.correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/forms.css" />
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ajax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/comunes.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/ingresoConsumo.js"></script>
        <title>Búsqueda de usuario externo</title>
    </head>
    <body>
        <div align="center">
            <br />
            <form id="frmBusquedaExterno" name="frmBusquedaExterno" action="#" method="POST">
                <table cellspacing="0" cellpadding="0" border="0" class="TABLAMAESTRO" width="99%">
                    <tr>
                        <td class="TITULOFORM" colspan="5">BÚSQUEDA DE USUARIO EXTERNO</td>
                    </tr>
                    <tr>
                        <td class="LABELFORM"> NIT:</td>
                        <td class="CELDACAMPOFORM">
                            <input type="text" id="txtNIT" name="txtNIT" class="CAMPOFORM" />
                        </td>
                        <td></td>
                        <td class="LABELFORM"> Razón social:</td>
                        <td class="CELDACAMPOFORM">
                            <input type="text" id="txtRazonSocial" name="txtRazonSocial" class="CAMPOFORM" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="CELDABOTONFORM">
                            <input type="button" id="btnBuscar" name="btnBuscar" value="Buscar" class="BOTONFORM" onclick="validarBusquedaTercero()"/>&nbsp;&nbsp;
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
