<%-- 
    Document   : subservicio
    Created on : 19/04/2015, 02:16:36 PM
    Author     : George
--%>

<%@page import="co.edu.udea.facturacion.dto.Servicio"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ServicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ServicioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.UsuarioSIUDAO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dto.TipoFacturacion"%>
<%@page import="co.edu.udea.facturacion.dao.impl.TipoFacturacionDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.TipoFacturacionDAO"%>
<%@page import="co.edu.udea.facturacion.dto.Subservicio"%>
<%@page import="co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.SubservicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strAccion = null;
    SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
    Subservicio subservicio = null;
    
    TipoFacturacionDAO tipoFacturacionDAO = new TipoFacturacionDAOImpl();
    List<TipoFacturacion> tiposFacturacion = null;
    
    UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
    List<UsuarioSesionSIU> usuariosSIU = null;
    
    ServicioDAO servicioDAO = new ServicioDAOImpl();
    List<Servicio> servicios = null;
    
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        
        tiposFacturacion = tipoFacturacionDAO.obtenerTodos();
        usuariosSIU = usuarioSIUDAO.obtenerTodos();
        servicios = servicioDAO.obtenerTodos();
        
        if (strAccion.equals("V")){
            String strCodigo = request.getParameter("keyCC");
            subservicio = subservicioDAO.obtenerUno(strCodigo);
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
        <title>Subservicio</title>
    </head>
    <body onLoad="cargarSubservicio()">
        <header>
           <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <%if(strAccion != null){%>                   
                        <br />
                        <div align="center">
                            <form id="frmSubservicio" name="frmSubservicio" method="POST" action="RegistroAdministrativo" onsubmit="return validarSubservicio()">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmSubservicio" />
                                <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                                 <%if(strAccion.equals("C")){%>
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE SUBSERVICIO</td>
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
                                             <input type="text" id="txtNombre" name="txtNombre" value="" class="CAMPOFORM" style="width: 350px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNombre" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Tipo de facturación:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbTipoFacturacion" name="cbTipoFacturacion" value="" class="CAMPOSELECT">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(TipoFacturacion tipoFacturacion : tiposFacturacion){%>
                                                        <option value="<%=tipoFacturacion.getCodigo()%>"><%=tipoFacturacion.getNombre()%></option>
                                                 <%}%>
                                             </select>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgTipoFacturacion" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Responsable:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbResponsable" name="cbResponsable" value="" class="CAMPOSELECT" style="width: 250px;">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(UsuarioSesionSIU usuarioSIU : usuariosSIU){%>
                                                        <option value="<%=usuarioSIU.getIdentificacion()%>"><%=usuarioSIU.getNombreCompleto()%></option>
                                                 <%}%>
                                             </select>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgResponsable" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Servicio padre:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbServicio" name="cbServicio" value="" class="CAMPOSELECT" style="width: 350px;">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(Servicio servicio : servicios){%>
                                                        <option value="<%=servicio.getCodigo()%>"><%=servicio.getNombre()%></option>
                                                 <%}%>
                                             </select>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgServicio" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* ¿Tiene insumos fijos?:</td>
                                         <td class="CELDARADIOFORM">
                                             <input type="radio" name="rdInsumosFijos" id="rdInsumosSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdInsumosFijos" id="rdInsumosNo" value="N">No                                                       
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgInsumosFijos" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* ¿Aplica subcantidad?:</td>
                                         <td class="CELDARADIOFORM">
                                             <input type="radio" name="rdAplicaSubcantidad" id="rdSubcantidadSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdAplicaSubcantidad" id="rdSubcantidadNo" value="N">No                                        
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgAplicaSubcantidad" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>    
                                         <td class="LABELFORM">* Etiqueta subcantidad:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtEtiquetaSubcantidad" name="txtEtiquetaSubcantidad" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgEtiquetaSubcantidad" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* ¿Aplica porcentaje sanción?:</td>
                                         <td class="CELDARADIOFORM">
                                             <input type="radio" name="rdPorcSancion" id="rdSancionSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdPorcSancion" id="rdSancionNo" value="N">No                                        
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgPorcSancion" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO" colspan="3"></td>                                            
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
                                            <td colspan="7" class="TITULOFORM">REGISTRO DE SUBSERVICIO</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Código:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCodigo" name="txtCodigo" value="<%=subservicio.getCodigo()%>" class="CAMPOFORMREAD" readonly />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCodigo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nombre:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtNombre" name="txtNombre" value="<%=subservicio.getNombre()%>" class="CAMPOFORM" style="width: 350px;" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgNombre" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Tipo de facturación:</td>
                                         <td class="CELDACAMPOFORM">
                                             <%
                                                String strIdTipoFacturacion = subservicio.getTipoFacturacion();
                                                String strTipoFacturacion = "";
                                                
                                                strTipoFacturacion = tipoFacturacionDAO.obtenerUno(strIdTipoFacturacion).getNombre();
                                             %>
                                            <input type="hidden" id="cbTipoFacturacion" name="cbTipoFacturacion" value="<%=strIdTipoFacturacion%>" class="CAMPOFORM"/>
                                            <input type="text" id="txtTipoFacturacion" name="txtTipoFacturacion" value="<%=strTipoFacturacion%>" class="CAMPOFORMREAD" readOnly />                                       
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgTipoFacturacion" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Responsable:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbResponsable" name="cbResponsable" value="" class="CAMPOSELECT" style="width: 250px;">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(UsuarioSesionSIU usuarioSIU : usuariosSIU){%>
                                                        <option value="<%=usuarioSIU.getIdentificacion()%>"><%=usuarioSIU.getNombreCompleto()%></option>
                                                 <%}%>
                                             </select>
                                             <script type="text/javascript">
                                                 $("#cbResponsable").val("<%=subservicio.getResponsable()%>");
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgResponsable" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Servicio padre:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbServicio" name="cbServicio" value="" class="CAMPOSELECT" style="width: 350px;">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(Servicio servicio : servicios){%>
                                                        <option value="<%=servicio.getCodigo()%>"><%=servicio.getNombre()%></option>
                                                 <%}%>
                                             </select>
                                             <script type="text/javascript">
                                                 $("#cbServicio").val("<%=subservicio.getServicioPadre()%>");
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgServicio" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* ¿Tiene insumos fijos?:</td>
                                         <td class="CELDARADIOFORM">
                                             <input type="radio" name="rdInsumosFijos" id="rdInsumosSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdInsumosFijos" id="rdInsumosNo" value="N">No        
                                             <script type="text/javascript">                                                        
                                                var strInsumosFijos = "<%=subservicio.getInsumosFijos()%>";                                                    
                                                if (strInsumosFijos == "S"){
                                                    $("#rdInsumosSi").prop("checked", true);
                                                }else{
                                                    $("#rdInsumosNo").prop("checked", true);
                                                }                                  
                                            </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgInsumosFijos" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* ¿Aplica subcantidad?:</td>
                                         <td class="CELDARADIOFORM">
                                             <input type="radio" name="rdAplicaSubcantidad" id="rdSubcantidadSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdAplicaSubcantidad" id="rdSubcantidadNo" value="N">No              
                                             <script type="text/javascript">                                                        
                                                var strAplicaSubcantidad = "<%=subservicio.getAplicaSubcantidad()%>";                                                    
                                                if (strAplicaSubcantidad == "S"){
                                                    $("#rdSubcantidadSi").prop("checked", true);
                                                }else{
                                                    $("#rdSubcantidadNo").prop("checked", true);
                                                }                                  
                                            </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgAplicaSubcantidad" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>    
                                         <td class="LABELFORM">* Etiqueta subcantidad:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtEtiquetaSubcantidad" name="txtEtiquetaSubcantidad" value="<%=subservicio.getEtiquetaSubcantidad()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgEtiquetaSubcantidad" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* ¿Aplica porcentaje sanción?:</td>
                                         <td class="CELDARADIOFORM">
                                             <input type="radio" name="rdPorcSancion" id="rdSancionSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdPorcSancion" id="rdSancionNo" value="N">No                 
                                             <script type="text/javascript">                                                        
                                                var strPorcSancion = "<%=subservicio.getAplicaPorcentajeSancion()%>";                                                    
                                                if (strPorcSancion == "S"){
                                                    $("#rdSancionSi").prop("checked", true);
                                                }else{
                                                    $("#rdSancionNo").prop("checked", true);
                                                }                                  
                                            </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgPorcSancion" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO" colspan="3"></td>                                            
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
