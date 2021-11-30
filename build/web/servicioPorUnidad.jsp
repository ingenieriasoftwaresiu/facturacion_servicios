<%-- 
    Document   : servicioPorUnidad
    Created on : 20/04/2015, 02:07:15 PM
    Author     : jorge.correa
--%>

<%@page import="co.edu.udea.facturacion.dto.ServicioXUnidad"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ServicioXUnidadDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ServicioXUnidadDAO"%>
<%@page import="co.edu.udea.facturacion.dto.UnidadMedida"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UnidadMedidaDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.UnidadMedidaDAO"%>
<%@page import="co.edu.udea.facturacion.dto.Subservicio"%>
<%@page import="co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.SubservicioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.UsuarioSesionSIU"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.UsuarioSIUDAO"%>
<%@page import="co.edu.udea.facturacion.dto.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ServicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strAccion = null, strTipoFacturacion=null;
        
    ServicioXUnidadDAO servicioXUnidadDAO = new ServicioXUnidadDAOImpl();
    ServicioXUnidad servicioXUnidad= null;
    
    SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
    Subservicio subservicio = null;
                    
    ServicioDAO servicioDAO = new ServicioDAOImpl();
    List<Servicio> servicios = null;
    
    UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
    List<UnidadMedida> unidadesMedida = null;
    
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        strTipoFacturacion = "UNDS";
                 
        servicios = servicioDAO.obtenerPorTipoFacturacion(strTipoFacturacion);
        unidadesMedida = unidadMedidaDAO.obtenerTodas();
        
        if (strAccion.equals("V")){
            Integer intCodigo = Integer.parseInt(request.getParameter("keyCC"));
            servicioXUnidad = servicioXUnidadDAO.obtenerUno(intCodigo);
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
        <title>Servicio por unidad</title>
    </head>
    <body onLoad="setFocus('cbServicio');">
        <header>
           <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <%if(strAccion != null){%>                   
                        <br />
                        <div align="center">
                            <form id="frmServicioXUnidad" name="frmServicioXUnidad" method="POST" action="RegistroAdministrativo" onsubmit="return validarServicioXUnidad()">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmServicioXUnidad" />
                                <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                                 <%if(strAccion.equals("C")){%>
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE SERVICIO POR UNIDAD</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nombre del servicio</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbServicio" name="cbServicio" class="CAMPOSELECT" style="width: 350px;">
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
                                         <td class="LABELFORM">* Nombre del subservicio:</td>
                                         <td class="CELDACAMPOFORM">
                                             <div id="dSubservicio">                         
                                                <select id="cbSubservicio" name="cbSubservicio" class="CAMPOSELECT" style="width: 350px;">
                                                    <option value="-1">Seleccione una opción</option>                                                
                                                </select>
                                             </div>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSubservicio" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Unidad de medida:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbUnidadMedida" name="cbUnidadMedida" class="CAMPOSELECT" style="width: 250px;">
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
                                         <td class="LABELFORM">* Valor de la unidad:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtValorUnidad" name="txtValorUnidad" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgValorUnidad" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>                                        
                                        <tr><td colspan="7" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td colspan="7" class="CELDABOTONFORM">                             
                                                <input type="submit" name="btnGuardar" id="btnGuardar" value="Guardar" class="BOTONFORM" />&nbsp;&nbsp;&nbsp;
                                                <input type="reset" name="btnLimpiar" id="btnLimpiar" value="Limpiar" class="BOTONFORM" onclick="setFocus('cbServicio')" />&nbsp;&nbsp;&nbsp;
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
                                    <input type="hidden" name="txtCodigo" id="txtCodigo" value="<%=servicioXUnidad.getCodigo().toString()%>" />
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">REGISTRO DE SUBSERVICIO</td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nombre del servicio</td>
                                         <td class="CELDACAMPOFORM">
                                             <%
                                                     String strIdServicio =servicioXUnidad.getServicio();
                                                     String strServicio = "";
                                                     
                                                     strServicio = servicioDAO.obtenerUno(strIdServicio).getNombre();
                                             %>
                                             <input type="hidden" id="cbServicio" name="cbServicio" value="<%=strIdServicio%>" class="CAMPOFORM" />
                                             <input type="text" id="txtServicio" name="txtServicio" value="<%=strServicio%>" class="CAMPOFORMREAD" style="width: 400px;" />                                                           
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgServicio" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nombre del subservicio:</td>
                                         <td class="CELDACAMPOFORM">                             
                                             <%
                                                     String strIdSubservicio =servicioXUnidad.getSubservicio();
                                                     String strSubservicio = "";
                                                     
                                                     strSubservicio = subservicioDAO.obtenerUno(strIdSubservicio).getNombre();
                                             %>
                                             <input type="hidden" id="cbSubservicio" name="cbSubservicio" value="<%=strIdSubservicio%>" class="CAMPOFORM" />
                                             <input type="text" id="txtSubservicio" name="txtSubservicio" value="<%=strSubservicio%>" class="CAMPOFORMREAD" style="width: 400px;" />                                                                                
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSubservicio" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Unidad de medida:</td>
                                         <td class="CELDACAMPOFORM">
                                             <%
                                                     String strIdUnidadMedida =servicioXUnidad.getUnidadMedida();
                                                     String strUnidadMedida = "";
                                                     
                                                     strUnidadMedida = unidadMedidaDAO.obtenerUna(strIdUnidadMedida).getNombre();
                                             %>
                                             <input type="hidden" id="cbUnidadMedida" name="cbUnidadMedida" value="<%=strIdUnidadMedida%>" class="CAMPOFORM" />
                                             <input type="text" id="txtUnidadMedida" name="txtUnidadMedida" value="<%=strUnidadMedida%>" class="CAMPOFORMREAD" />                                             
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgUnidadMedida" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                    
                                         <td class="LABELFORM">* Valor de la unidad:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtValorUnidad" name="txtValorUnidad" value="<%=servicioXUnidad.getValorUnidad().toString()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgValorUnidad" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
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
