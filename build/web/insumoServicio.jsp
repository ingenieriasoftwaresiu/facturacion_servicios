<%-- 
    Document   : insumoServicio
    Created on : 14/04/2015, 01:38:17 PM
    Author     : jorge.correa
--%>

<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dto.UnidadMedida"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UnidadMedidaDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.UnidadMedidaDAO"%>
<%@page import="co.edu.udea.facturacion.dto.InsumoServicio"%>
<%@page import="co.edu.udea.facturacion.dao.impl.InsumoServicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.InsumoServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strAccion = null;
    InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
    InsumoServicio insumoServicio = null;

    UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
    List<UnidadMedida> unidadesMedida = null;
    
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        
        unidadesMedida = unidadMedidaDAO.obtenerTodas();
        
        if (strAccion.equals("V")){
            String strCodigo = request.getParameter("keyCC");
            insumoServicio = insumoServicioDAO.obtenerUno(strCodigo);
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
        <title>Insumo de servicio</title>
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
                            <form id="frmInsumoServicio" name="frmInsumoServicio" method="POST" action="RegistroAdministrativo" onsubmit="return validarInsumoServicio()">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmInsumoServicio" />
                                <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                                 <%if(strAccion.equals("C")){%>
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE INSUMO DE SERVICIO</td>
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
                                        <tr>
                                         <td class="LABELFORM">* Unidad de medida:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbUnidadMedida" name="cbUnidadMedida" value="" class="CAMPOSELECT">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(UnidadMedida unidadMedida : unidadesMedida){%>
                                                        <option value="<%=unidadMedida.getCodigo()%>"><%=unidadMedida.getNombre()%></option>
                                                 <%}%>
                                             </select>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgUnidadMedida" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Presentación:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtPresentacion" name="txtPresentacion" value="" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgPresentacion" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">Costo unitario:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCostoUnitario" name="txtCostoUnitario" value="" class="CAMPOFORM" value="" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCostoUnitario" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">Cantidad disponible:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCantidadDisponible" name="txtCantidadDisponible" value="" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCantidadDisponible" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
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
                                            <td colspan="7" class="TITULOFORM">REGISTRO DE INSUMO DE SERVICIO</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Código:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCodigo" name="txtCodigo" value="<%=insumoServicio.getCodigo()%>" class="CAMPOFORMREAD" readOnly />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCodigo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nombre:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNombre" name="txtNombre" value="<%=insumoServicio.getNombre()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNombre" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Unidad de medida:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbUnidadMedida" name="cbUnidadMedida" value="" class="CAMPOSELECT">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(UnidadMedida unidadMedida : unidadesMedida){%>
                                                        <option value="<%=unidadMedida.getCodigo()%>"><%=unidadMedida.getNombre()%></option>
                                                 <%}%>
                                             </select>
                                             <script type="text/javascript">
                                                 $("#cbUnidadMedida").val("<%=insumoServicio.getUnidadMedida()%>");
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgUnidadMedida" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Presentación:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtPresentacion" name="txtPresentacion" value="<%=insumoServicio.getPresentacion()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgPresentacion" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">Costo unitario:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCostoUnitario" name="txtCostoUnitario" value="<%=insumoServicio.getCostoUnitario()%>" class="CAMPOFORM" value="" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCostoUnitario" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">Cantidad disponible:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCantidadDisponible" name="txtCantidadDisponible" value="<%=insumoServicio.getCantidadDisponible()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCantidadDisponible" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
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
