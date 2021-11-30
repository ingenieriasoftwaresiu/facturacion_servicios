<%-- 
    Document   : unidadMedida
    Created on : 26/03/2015, 08:29:57 AM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.UnidadMedida"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UnidadMedidaDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.UnidadMedidaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strAccion = null;
    UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
    UnidadMedida unidadMedida = null;

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        
        if (strAccion.equals("V")){
            String strCodigo = request.getParameter("keyCC");
            unidadMedida = unidadMedidaDAO.obtenerUna(strCodigo);
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
        <title>Unidad de medida</title>
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
                            <form id="frmUnidadMedida" name="frmUnidadMedida" method="POST" action="RegistroAdministrativo" onsubmit="return validarUnidadMedida()">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmUnidadMedida" />
                                <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                                <%if(strAccion.equals("C")){%>                        
                                        <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                            <tr>
                                                <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE UNIDAD DE MEDIDA</td>
                                            </tr>
                                            <tr>
                                             <td class="LABELFORM">* Código:</td>
                                             <td class="CELDACAMPOFORM">
                                                 <input type="text" id="txtCodigo" name="txtCodigo" value="" class="CAMPOFORM" value="" />
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
                                                <td colspan="7" class="TITULOFORM">REGISTRO DE UNIDAD DE MEDIDA</td>
                                            </tr>
                                            <tr>
                                             <td class="LABELFORM">* Código:</td>
                                             <td class="CELDACAMPOFORM">
                                                 <input type="text" id="txtCodigo" name="txtCodigo" value="<%=unidadMedida.getCodigo()%>" class="CAMPOFORMREAD" readOnly />
                                             </td>
                                             <td class="CELDAIMGERROR">
                                                 <img src="Images/error.png" id="imgCodigo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                             </td>
                                             <td class="ESPACIOBLANCO"></td>
                                             <td class="LABELFORM">* Nombre:</td>
                                             <td class="CELDACAMPOFORM">
                                                 <input type="text" id="txtNombre" name="txtNombre" value="<%=unidadMedida.getNombre()%>" class="CAMPOFORM" />
                                             </td>
                                             <td class="CELDAIMGERROR">
                                                 <img src="Images/error.png" id="imgNombre" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
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
