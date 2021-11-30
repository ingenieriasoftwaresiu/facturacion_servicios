<%-- 
    Document   : tipoFacturacion
    Created on : 14/04/2015, 10:55:08 AM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.TipoFacturacion"%>
<%@page import="co.edu.udea.facturacion.dao.impl.TipoFacturacionDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.TipoFacturacionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strAccion = null;
    TipoFacturacionDAO tipoFacturacionDAO = new TipoFacturacionDAOImpl();
    TipoFacturacion tipoFacturacion = null;

    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        
        if (strAccion.equals("V")){
            String strCodigo = request.getParameter("keyCC");
            tipoFacturacion = tipoFacturacionDAO.obtenerUno(strCodigo);
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
        <title>Tipo de facturación</title>
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
                            <form id="frmTipoFacturacion" name="frmTipoFacturacion" method="POST" action="RegistroAdministrativo" onsubmit="return validarTipoFacturacion()">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmTipoFacturacion" />
                                <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                                 <%if(strAccion.equals("C")){%>
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE TIPO DE FACTURACIÓN</td>
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
                                             <input type="text" id="txtNombre" name="txtNombre" value="" class="CAMPOFORM" style="width: 100%;" />
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
                                            <td colspan="7" class="TITULOFORM">REGISTRO DE TIPO DE FACTURACIÓN</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Código:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCodigo" name="txtCodigo" value="<%=tipoFacturacion.getCodigo()%>" class="CAMPOFORMREAD" readOnly />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCodigo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nombre:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNombre" name="txtNombre" value="<%=tipoFacturacion.getNombre()%>" class="CAMPOFORM" style="width: 100%;" />
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
