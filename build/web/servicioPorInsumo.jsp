<%-- 
    Document   : servicioPorInsumo
    Created on : 21/04/2015, 02:17:50 PM
    Author     : jorge.correa
--%>

<%@page import="java.math.RoundingMode"%>
<%@page import="co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.FuncionesComunesDAO"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="co.edu.udea.facturacion.dao.impl.UnidadMedidaDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dto.UnidadMedida"%>
<%@page import="co.edu.udea.facturacion.dao.UnidadMedidaDAO"%>
<%@page import="co.edu.udea.facturacion.dto.InsumoServicio"%>
<%@page import="co.edu.udea.facturacion.dao.impl.InsumoServicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.InsumoServicioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ServicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ServicioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.Subservicio"%>
<%@page import="co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.SubservicioDAO"%>
<%@page import="co.edu.udea.facturacion.dto.ServicioXInsumo"%>
<%@page import="co.edu.udea.facturacion.dao.impl.ServicioXInsumoDAOImpl"%>
<%@page import="co.edu.udea.facturacion.dao.ServicioXInsumoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strAccion = null, strTipoFacturacion=null;
        
    FuncionesComunesDAO funcionesComunesDAO = new FuncionesComunesDAOImpl();
    final RoundingMode roundingMode = RoundingMode.CEILING;
    
    ServicioXInsumoDAO servicioXInsumoDAO = new ServicioXInsumoDAOImpl();
    ServicioXInsumo servicioXInsumo= null;
    
    SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
    Subservicio subservicio = null;
                    
    ServicioDAO servicioDAO = new ServicioDAOImpl();
    List<Servicio> servicios = null;
    
    InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
    List<InsumoServicio> insumosServicio = null;
    
    UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
    List<UnidadMedida> unidadesMedida = null;
    
    if (session.getAttribute("Usuario") == null){
        request.getRequestDispatcher("cerrar.jsp").forward(request, response);    
    }else{          
        strAccion = request.getParameter("txtAccion");   
        strTipoFacturacion = "INSUMOS";
                 
        servicios = servicioDAO.obtenerPorTipoFacturacion(strTipoFacturacion);
        insumosServicio = insumoServicioDAO.obtenerTodos();
        unidadesMedida = unidadMedidaDAO.obtenerTodas();
        
        if (strAccion.equals("V")){
            Integer intCodigo = Integer.parseInt(request.getParameter("keyCC"));
            servicioXInsumo = servicioXInsumoDAO.obtenerUno(intCodigo);
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
        <title>Servicio por insumo</title>
    </head>
    <body onLoad="cargarServicioXInsumo()">
        <header>
           <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <%if(strAccion != null){%>                   
                        <br />
                        <div align="center">
                            <form id="frmServicioXInsumo" name="frmServicioXInsumo" method="POST" action="RegistroAdministrativo" onsubmit="return validarServicioXInsumo()">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmServicioXInsumo" />
                                <input type="hidden" name="txtAccion" id="txtAccion" value="<%=strAccion%>" />
                                 <%if(strAccion.equals("C")){%>
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">NUEVO REGISTRO DE SERVICIO POR INSUMO</td>
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
                                         <td class="LABELFORM">* Nombre del insumo:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbInsumo" name="cbInsumo" class="CAMPOSELECT" style="width: 350px;">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(InsumoServicio insumoServicio : insumosServicio){%>
                                                        <option value="<%=insumoServicio.getCodigo()%>"><%=insumoServicio.getNombre()%></option>
                                                 <%}%>
                                             </select>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgInsumo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                    
                                         <td class="LABELFORM">* ¿Tiene cobro transversal?:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="radio" name="rdCobroTransversal" id="rdCobroTransversalSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdCobroTransversal" id="rdCobroTransversalNo" value="N">No
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCobroTransversal" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>                                        
                                        <tr>
                                            <td class="LABELFORM">* Cantidad cobro transversal:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="text" id="txtCantidadCobroTransversal" name="txtCantidadCobroTransversal" class="CAMPOFORM" />
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgCantidadCobroTransversal" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                            <td class="ESPACIOBLANCO"></td>
                                            <td class="LABELFORM">Cantidad fija:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="text" id="txtCantidadFija" name="txtCantidadFija" class="CAMPOFORM" />
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgCantidadFija" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Unidad cantidad fija:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbUnidadCantidadFija" name="cbUnidadCantidadFija" class="CAMPOSELECT">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(UnidadMedida unidadMedida : unidadesMedida){%>
                                                        <option value="<%=unidadMedida.getCodigo()%>"><%=unidadMedida.getNombre()%></option>
                                                 <%}%>
                                             </select>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgUnidadCantidadFija" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                    
                                         <td class="LABELFORM">* ¿Utiliza costo variable?:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="radio" name="rdCostoVariable" id="rdCostoVariableSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdCostoVariable" id="rdCostoVariableNo" value="N">No
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCostoVariable" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Costo variable:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCostoVariable" name="txtCostoVariable" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCostoV" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                    
                                         <td class="LABELFORM">* ¿Se cobra al usuario?:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="radio" name="rdSeCobraAlUsuario" id="rdSeCobraAlUsuarioSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdSeCobraAlUsuario" id="rdSeCobraAlUsuarioNo" value="N">No
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSeCobraAlUsuario" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
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
                                    <input type="hidden" name="txtCodigo" id="txtCodigo" value="<%=servicioXInsumo.getCodigo().toString()%>" />
                                    <table cellspacing="0" cellpadding="0" border="0" width="99%" class="TABLAMAESTRO">
                                        <tr>
                                            <td colspan="7" class="TITULOFORM">REGISTRO DE SUBSERVICIO</td>
                                        </tr>         
                                        <tr>
                                         <td class="LABELFORM">* Nombre del servicio</td>
                                         <td class="CELDACAMPOFORM">
                                             <%
                                                String strIdServicio = servicioXInsumo.getServicio();
                                                String strServicio = servicioDAO.obtenerUno(strIdServicio).getNombre();
                                             %>
                                             <input type="hidden" id="cbServicio" name="cbServicio" value="<%=strIdServicio%>" class="CAMPOFORM" />
                                             <input type="text" id="txtServicio" name="txtServicio" value="<%=strServicio%>" class="CAMPOFORMREAD" style="width: 350px;" readOnly />                                             
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgServicio" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>
                                         <td class="LABELFORM">* Nombre del subservicio:</td>
                                         <td class="CELDACAMPOFORM">
                                             <%
                                                String strIdSubservicio = servicioXInsumo.getSubservicio();
                                                String strSubservicio = subservicioDAO.obtenerUno(strIdSubservicio).getNombre();
                                             %>
                                             <input type="hidden" id="cbSubservicio" name="cbSubservicio" value="<%=strIdSubservicio%>" class="CAMPOFORM" />
                                             <input type="text" id="txtSubservicio" name="txtSubservicio" value="<%=strSubservicio%>" class="CAMPOFORMREAD" style="width: 350px;" readOnly />                                            
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSubservicio" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Nombre del insumo:</td>
                                         <td class="CELDACAMPOFORM">
                                             <%
                                                String strIdInsumo = servicioXInsumo.getInsumo();
                                                String strInsumo = insumoServicioDAO.obtenerUno(strIdInsumo).getNombre();
                                             %>
                                             <input type="hidden" id="cbInsumo" name="cbInsumo" value="<%=strIdInsumo%>" class="CAMPOFORM" />
                                             <input type="text" id="txtInsumo" name="txtInsumo" value="<%=strInsumo%>" class="CAMPOFORMREAD" style="width: 300px;"  readOnly />                                             
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgInsumo" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                    
                                         <td class="LABELFORM">* ¿Tiene cobro transversal?:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="radio" name="rdCobroTransversal" id="rdCobroTransversalSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdCobroTransversal" id="rdCobroTransversalNo" value="N">No
                                             <script type="text/javascript">
                                                    var strUtilizaCobroTransversal = "<%=servicioXInsumo.getCobroTransversal()%>";                                                    
                                                    if (strUtilizaCobroTransversal == "S"){
                                                        $("#rdCobroTransversalSi").prop("checked", true);
                                                    }else{
                                                        $("#rdCobroTransversalNo").prop("checked", true);
                                                    }
                                              </script>   
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCobroTransversal" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>                                        
                                        <tr>
                                            <td class="LABELFORM">* Cantidad cobro transversal:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="text" id="txtCantidadCobroTransversal" name="txtCantidadCobroTransversal" value="<%=servicioXInsumo.getCantidadCobroTransversal().toString()%>" class="CAMPOFORM" />
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgCantidadCobroTransversal" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                            <td class="ESPACIOBLANCO"></td>
                                            <td class="LABELFORM">Cantidad fija:</td>
                                            <td class="CELDACAMPOFORM">
                                                <%                                                
                                                    BigDecimal bdCantidadFija = servicioXInsumo.getCantidadFija();
                                                    if (funcionesComunesDAO.tieneDecimales(bdCantidadFija)){                                         
                                                        bdCantidadFija.setScale(3, roundingMode);%>
                                                        <input type="text" id="txtCantidadFija" name="txtCantidadFija" value="<%=bdCantidadFija.floatValue()%>" class="CAMPOFORM" />
                                                    <%}else{                                            
                                                        bdCantidadFija.setScale(0, roundingMode);%>
                                                        <input type="text" id="txtCantidadFija" name="txtCantidadFija" value="<%=bdCantidadFija.intValue()%>" class="CAMPOFORM" />
                                                    <%}
                                                %>                                                                                                
                                            </td>
                                            <td class="CELDAIMGERROR">
                                                <img src="Images/error.png" id="imgCantidadFija" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                            </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Unidad cantidad fija:</td>
                                         <td class="CELDACAMPOFORM">
                                             <select id="cbUnidadCantidadFija" name="cbUnidadCantidadFija" class="CAMPOSELECT">
                                                 <option value="-1">Seleccione una opción</option>
                                                 <%for(UnidadMedida unidadMedida : unidadesMedida){%>
                                                        <option value="<%=unidadMedida.getCodigo()%>"><%=unidadMedida.getNombre()%></option>
                                                 <%}%>
                                             </select>
                                             <script type="text/javascript">
                                                 $("#cbUnidadCantidadFija").val("<%=servicioXInsumo.getUnidadCantidadFija()%>");
                                             </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgUnidadCantidadFija" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                    
                                         <td class="LABELFORM">* ¿Utiliza costo variable?:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="radio" name="rdCostoVariable" id="rdCostoVariableSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdCostoVariable" id="rdCostoVariableNo" value="N">No
                                             <script type="text/javascript">
                                                    var strCostoVariable= "<%=servicioXInsumo.getUtilizaCostoVariable()%>";                                                    
                                                    if (strCostoVariable == "S"){
                                                        $("#rdCostoVariableSi").prop("checked", true);
                                                    }else{
                                                        $("#rdCostoVariableNo").prop("checked", true);
                                                    }
                                              </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCostoVariable" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                        </tr>
                                        <tr>
                                         <td class="LABELFORM">* Costo variable:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="text" id="txtCostoVariable" name="txtCostoVariable" value="<%=servicioXInsumo.getCostoVariable().toString()%>" class="CAMPOFORM" />
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgCostoV" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
                                         </td>
                                         <td class="ESPACIOBLANCO"></td>                    
                                         <td class="LABELFORM">* ¿Se cobra al usuario?:</td>
                                         <td class="CELDACAMPOFORM">
                                             <input type="radio" name="rdSeCobraAlUsuario" id="rdSeCobraAlUsuarioSi" value="S">Si&nbsp;                                   
                                             <input type="radio" name="rdSeCobraAlUsuario" id="rdSeCobraAlUsuarioNo" value="N">No
                                             <script type="text/javascript">
                                                    var strSeCobraAlUsuario= "<%=servicioXInsumo.getSeCobraAlUsuario()%>";                                                    
                                                    if (strSeCobraAlUsuario == "S"){
                                                        $("#rdSeCobraAlUsuarioSi").prop("checked", true);
                                                    }else{
                                                        $("#rdSeCobraAlUsuarioNo").prop("checked", true);
                                                    }
                                              </script>
                                         </td>
                                         <td class="CELDAIMGERROR">
                                             <img src="Images/error.png" id="imgSeCobraAlUsuario" alt="Campo obligatorio" class="IMGERROR" style="display: none;">
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
