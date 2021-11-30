/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesDAO;
import co.edu.udea.facturacion.dao.InsumoServicioDAO;
import co.edu.udea.facturacion.dao.ItemAdicionalDAO;
import co.edu.udea.facturacion.dao.ServicioDAO;
import co.edu.udea.facturacion.dao.ServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.ServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.TerceroDAO;
import co.edu.udea.facturacion.dao.TipoUsuarioDAO;
import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesConsumosDAOImpl;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl;
import co.edu.udea.facturacion.dao.impl.InsumoServicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ItemAdicionalDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.TerceroDAOImpl;
import co.edu.udea.facturacion.dao.impl.TipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.UnidadMedidaDAOImpl;
import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dto.InsumoServicio;
import co.edu.udea.facturacion.dto.ItemAdicional;
import co.edu.udea.facturacion.dto.Servicio;
import co.edu.udea.facturacion.dto.ServicioXInsumo;
import co.edu.udea.facturacion.dto.ServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dto.Tercero;
import co.edu.udea.facturacion.dto.TipoUsuario;
import co.edu.udea.facturacion.dto.UnidadMedida;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George
 */
public class IngresoConsumos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           String strAccion = request.getParameter("txtAccion");
           
           if (strAccion.equals("BUSCAREXTERNO")){
                String strNIT= request.getParameter("txtNIT");
                String strRazonSocial = request.getParameter("txtRazonSocial");
                String strClaseProveedor = "NACIONAL";              
                TerceroDAO terceroDAO = new TerceroDAOImpl();
                List<Tercero> terceros = null;

                try{
                    terceros = terceroDAO.obtenerTerceros(strNIT, strRazonSocial, strClaseProveedor);
                }catch(GIDaoException e){
                    new GIDaoException("Se generó un error al obtener los terceros.", e);
                }
                
                out.println("<table cellspacing='0' cellpadding='0' border='0' class='TABLAMAESTRO' width='99%'>");
                out.println("<tr>");
                out.println("<td class='TITULOFORM' colspan='4'>RESULTADO DE LA BÚSQUEDA</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class='SUBTITULOFORM'>NIT</td>");
                out.println("<td class='SUBTITULOFORM'>Razón social</td>");
                out.println("<td class='SUBTITULOFORM'>Tipo de tercero</td>");
                out.println("<td class='SUBTITULOFORM'>¿Seleccionar?</td>");
                out.println("</tr>");
               
                if ((terceros != null) && (terceros.size() > 0)){                                                                     
                    for (Tercero tercero : terceros){
                        
                        strNIT = "";
                        strRazonSocial = "";                        
                        
                        strNIT = tercero.getNit();
                        strRazonSocial = tercero.getRazonSocial();
                        
                        out.println("<tr>");
                        out.println("<td>" + strNIT);
                        out.println("</td>");       
                        out.println("<td>" + strRazonSocial);
                        out.println("</td>");  
                        out.println("<td>" + tercero.getTipoTercero());
                        out.println("</td><img src='Images/seleccion.png' width='15px' height='15px' style='vertical-align: middle;' onclick=\"asignarUsuarioExterno('" + strNIT +"','" + strRazonSocial + "');\" />");  
                        out.println("<td>");
                        out.println("</td>");  
                        out.println("</tr>");
                    }
                }else{
                    out.println("<tr>");
                    out.println("<td class='TEXTOFALLO' colspan='4'>No se recuperó ningún usuario externo con los criterios ingresados.");       
                    out.println("</td>");       
                    out.println("</tr>");
                }
                
                out.println("</table>");
           }
            
            if (strAccion.equals("SUBSERVICIO")){
                String strIdServicio = request.getParameter("txtIdServicio");
                
                ServicioDAO servicioDAO = new ServicioDAOImpl();
                Servicio servicio = null;
                
                try{
                    servicio = servicioDAO.obtenerUno(strIdServicio);      
                    
                    if (servicio.getModoIngresoConsumos().equals("I")){
                
                        SubservicioDAO subservicioDAO = new SubservicioDAOImpl();

                        List<Subservicio> subservicios = subservicioDAO.obtenerPorServicio(strIdServicio);                     
                        out.println("<table cellspacing='0' cellpadding='0' border='0' width='100%'>");
                        out.println("<tr>");
                        out.println("<td class='LABELFORM' style='width: 195px;'>* Nombre del subservicio:</td>");
                        out.println("<td class='CELDACAMPOFORM'>");
                        out.println("<select id='cbSubservicioConsumido' name='cbSubservicioConsumido' class='CAMPOSELECT' style='width: 310px;'>");
                        out.println("<option value='-1'>Seleccione una opción</option>");
                        for(Subservicio subservicio : subservicios){
                            out.println("<option value='" + subservicio.getCodigo() + "'>" + subservicio.getNombre() + "</option>");
                        }
                        out.println("</select>");
                        out.println("</td>");       
                        out.println("<td class='CELDAIMGERROR'>");
                        out.println("<img src='Images/error.png' id='imgSubservicioConsumido' alt='Campo obligatorio' class='IMGERROR' style='display:none;'>");
                        out.println("</td>");  
                        out.println("</tr>");
                        out.println("</table>");                      
                    }else{
                        out.println("<table cellspacing='0' cellpadding='0' border='0' width='100%'>");
                        out.println("<tr>");
                        out.println("<td class='LABELFORM' style='width: 160px;'></td>");
                        out.println("<td class='CELDACAMPOFORM'>");
                        out.println("<input type='hidden' id='cbSubservicioConsumido' name='cbSubservicioConsumido' value='GRUPAL' style='width: 200px;'>");
                        out.println("</td>");       
                        out.println("<td class='CELDAIMGERROR'>");
                        out.println("<img src='Images/error.png' id='imgSubservicioConsumido' alt='Campo obligatorio' class='IMGERROR' style='display:none;'>");
                        out.println("</td>");  
                        out.println("</tr>");
                        out.println("</table>");
                    }
                }catch(GIDaoException e){
                    String strMgsError = "No se recuperaron los subservicios del servicio " + strIdServicio;
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }                
            }
            
            if (strAccion.equals("FECHA_CONSUMO")){
                String strIdServicio = request.getParameter("txtIdServicio");
                
                ServicioDAO servicioDAO = new ServicioDAOImpl();
                Servicio servicio = null;
                
                try{
                    servicio = servicioDAO.obtenerUno(strIdServicio);                          
                                       
                    if (servicio.getModoIngresoConsumos().equals("I")){                        
                        out.println("<script type='text/javascript'>");          
                        out.println("$('#lblFechaFin').hide();");
                        out.println("$('#txtFechaFin').hide();");                        
                        out.println("$('#imgFechaFin').hide();");   
                        out.println("$('#imgFechaFinal').hide();");      
                        out.println("$('#txtFechaFin').val(' ');");                        
                        out.println("</script>");                                                
                    }else{                        
                        out.println("<script type='text/javascript'>");          
                        out.println("$('#lblFechaFin').show();");
                        out.println("$('#txtFechaFin').show();");                        
                        out.println("$('#imgFechaFin').show();");   
                        out.println("$('#imgFechaFinal').hide();");      
                        out.println("$('#txtFechaFin').val('');");                        
                        out.println("</script>");                                              
                    }                                       
                    
                }catch(GIDaoException e){
                    String strMgsError = "No se recuperó la información del servicio " + strIdServicio;
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }     
            }
            
            if (strAccion.equals("CANTIDAD")){
                String strIdServicio = request.getParameter("txtIdServicio");
                String strIdSubservicio = request.getParameter("txtIdSubservicio");
                String strIdTipoUsuario = request.getParameter("txtIdTipoUsuario");
                String strIdUnidad = null, strUnidad = null;
                
                ServicioXTipoUsuarioDAO servicioXtipoUsuarioDAO = new ServicioXTipoUsuarioDAOImpl();  
                List<UnidadMedida> unidadesMedida = null;
                                        
                try{
                    unidadesMedida = servicioXtipoUsuarioDAO.obtenerUnidadesPorServicioSubservicioTipoUsuario(strIdServicio, strIdSubservicio, strIdTipoUsuario);
                    
                    if (unidadesMedida.size() == 1){
                        out.println("* Cantidad <select id='cbUnidadConsumo' name='cbUnidadConsumo' class='CAMPOSELECT' style='width:80px;'>:");                        
                        for(UnidadMedida unidadMedida : unidadesMedida){
                            out.println("<option value='" +unidadMedida.getCodigo() + "' selected>" + unidadMedida.getNombre() + "</option>");
                        }
                        out.println("</select>:");                       
                    }else{
                         if (unidadesMedida.size() > 1){
                            out.println("* Cantidad <select id='cbUnidadConsumo' name='cbUnidadConsumo' class='CAMPOSELECT' style='width:80px;'>:");
                            out.println("<option value='-1'>Seleccione</option>");
                            for(UnidadMedida unidadMedida : unidadesMedida){
                                out.println("<option value='" +unidadMedida.getCodigo() + "'>" + unidadMedida.getNombre() + "</option>");
                            }
                            out.println("</select>:");
                             out.println("<img src='Images/error.png' id='imgUnidadConsumo' alt='Campo obligatorio' class='IMGERROR' style='display:none;'>");
                         }else{
                             out.println("* Cantidad:");
                         }
                    }                    
                    
                }catch(GIDaoException e){
                    out.println("* Cantidad:");
                    new GIDaoException("No se pudo recuperar la unidad del servicio por tipo de usuario",e);                    
                }
                
            }                    
                    
            if (strAccion.equals("INGRESOCONSUMOS")){
                
                String strIdServicio = request.getParameter("txtIdServicio");
                String strIdSubservicio = request.getParameter("txtSubservicio");
                String strFechaIni = request.getParameter("txtFechaIni");
                String strFechaFin = request.getParameter("txtFechaFin");
                String strIdUsuario = request.getParameter("txtUsuario");
                String strIdTipoUsuario = request.getParameter("txtTipoUsuario");
                String strServicio = null;
                String strModoIngresoConsumos = null;
                String strSubservicio = null;
                String strInsumosFijos = null;
                String strIdInsumo = null;
                String strInsumo = null;
                String strIdUnidadInsumo = null;
                String strUnidadInsumo = null;
                String strFechaBase = null;
                String strFechaBaseNueva = null;
                String strIdCampoConsumo = null;
                String strArregloInsumos = "";
                String strCantidadUtilizada = null;
                String strCantidadTransversal = null;
                String strTipoFacturacion = null;
                String strAplicaSubcantidad = null;
                String strAplicaPorcentajeSancion = null;
                String strEtiquetaSubcantidad = null;
                String[] strTemp = null;
                Integer intTotalInsumos = null;
                Integer intContadorInsumos = null;
                Integer intContadorDias = null;
                Integer intCantidadRegistros = null;
                BigDecimal bgCantidadPrevia = null, bdCantidadFija=null;
                Long lgDiasDiff = null;
                Date dtFechaConsumo = null;
                List<ServicioXInsumo> serviciosXinsumos = null;
                final RoundingMode roundingMode = RoundingMode.CEILING;
                                                
                ServicioDAO servicioDAO = new ServicioDAOImpl();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                try{
                    Servicio servicio = servicioDAO.obtenerUno(strIdServicio);
                    strServicio = servicio.getNombre();
                    strModoIngresoConsumos = servicio.getModoIngresoConsumos();                    
                                        
                    SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                    ServicioXInsumoDAO servicioXinsumoDAO = new ServicioXInsumoDAOImpl();
                    InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
                    ConsumoServicioXInsumoDAO consumoServicioDAO = new ConsumoServicioXInsumoDAOImpl();
                    UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
                    UnidadMedida unidadMedida = null;
                    InsumoServicio insumoServicio = null;
                    FuncionesComunesDAO funcionesComunes = new FuncionesComunesDAOImpl();
                    FuncionesComunesConsumosDAO funcionesComunesConsumosDAO = new FuncionesComunesConsumosDAOImpl();
                    Date dtFechaInicio = null;
                    Date dtFechaFin = null;
                                                                                                 
                    if (strModoIngresoConsumos.equals("G")){
                        
                        dtFechaInicio = funcionesComunes.getDateFromString(strFechaIni);
                        dtFechaFin = funcionesComunes.getDateFromString(strFechaFin);
                        lgDiasDiff = funcionesComunes.getDiasDiferenciaFechas(dtFechaInicio, dtFechaFin);  

                        if (lgDiasDiff > 30){
                            out.println("<div align='center' class='TEXTOFALLO'>");
                            out.println("<script type='text/javascript'>");          
                            out.println("setTimeout(function(){$('#dLoader').hide();}, 1500);");
                            out.println("setTimeout(function(){$('#dBotonesInicio').show();}, 1500);");
                            out.println("setTimeout(function(){alert('Para una mejor disposición en pantalla, es recomendable no ingresar más de 31 días al mismo tiempo.');}, 1800)");                                  
                            out.println("</script>");                           
                            out.println("</div");
                            return;
                        }
                        
                        List<Subservicio> subservicios = subservicioDAO.obtenerPorServicio(strIdServicio);                        
                                                
                        if (subservicios.size() <= 0){
                            out.println("<div align='center' class='TEXTOFALLO'>");
                            out.println("<script type='text/javascript'>");          
                            out.println("setTimeout(function(){$('#dLoader').hide();}, 1500)");
                            out.println("setTimeout(function(){$('#dBotonesInicio').show();}, 1500)");
                            out.println("setTimeout(function(){alert('No se tienen subservicios configurados para el servicio seleccionado. Por favor contacte al Administrador del Sistema.');}, 1800)");                                  
                            out.println("</script>");                     
                            out.println("</div");
                            return;
                        }                                    
                                                                        
                        out.println("<div align='center'>");
                        out.println("<p class='TEXTOFALLO'>");
                        out.println("NOTA: Recuerde que los valores con decimales deben ser separados por el signo punto (.). Ejemplo: 3.5 ó 20.1");
                        out.println("</p>");
                        out.println("<table cellspacing='0' cellpadding='0' border='0' width='99%' class='TABLACONSUMO'>");
                        out.println("<tr>");
                        out.println("<td class='SUBTITULOTABLAINGRESO'>SUBSERVICIO</td>");
                        out.println("<td class='SUBTITULOTABLAINGRESO'>INSUMO</td>");
                        out.println("<td class='SUBTITULOTABLAINGRESO'>UNIDAD</td>");
                        
                        strFechaBase = strFechaIni;
                        
                        for(intContadorDias=0;intContadorDias<=lgDiasDiff;intContadorDias++){      
                            
                            strTemp = strFechaBase.split("-");
                            strFechaBaseNueva = strTemp[1] + "-" + strTemp[2];
                                    
                            out.println("<td class='SUBTITULOTABLAINGRESO'>" + strFechaBaseNueva + "</td>");
                            
                            strFechaBase = funcionesComunes.aumentarDiasFecha(strFechaBase, 1);
                        }                        
                        
                        out.println("</tr>");                                                         
                        
                        for (Subservicio subservicio : subservicios){
                            strIdSubservicio = subservicio.getCodigo();      
                            strSubservicio = subservicio.getNombre();
                            serviciosXinsumos = servicioXinsumoDAO.obtenerPorServicioSubservicio(strIdServicio, strIdSubservicio);
                                               
                            intTotalInsumos = serviciosXinsumos.size();                                                            
                            
                            intContadorInsumos = 1;
                            
                            for (ServicioXInsumo servicioXinsumo : serviciosXinsumos){
                                strIdInsumo = servicioXinsumo.getInsumo();                                
                                insumoServicio = insumoServicioDAO.obtenerUno(strIdInsumo);
                                strInsumo = insumoServicio.getNombre();
                                strIdUnidadInsumo = insumoServicio.getUnidadMedida();
                                
                                if (servicioXinsumo.getCobroTransversal().equals("S")){
                                    strCantidadTransversal = servicioXinsumo.getCantidadCobroTransversal().toString();
                                }else{
                                    strCantidadTransversal = "";
                                }
                                
                                unidadMedida = unidadMedidaDAO.obtenerUna(strIdUnidadInsumo);
                                strUnidadInsumo = unidadMedida.getNombre();
                                
                                out.println("<tr class='FILACONSUMO'>");
                                
                                if (intContadorInsumos == 1){                                    
                                    out.println("<td rowspan='" + intTotalInsumos.toString() + "' class='TEXTOCELDATABLACONSUMO'>" + strSubservicio + "</td>");
                                }
                                
                                out.println("<td class='TEXTOCELDATABLACONSUMO' style='height:25px;text-align:justify;'>" + strInsumo + "</td>"); 
                                out.println("<td class='TEXTOCELDATABLACONSUMO' style='height:25px;'>" + strUnidadInsumo + "</td>"); 
                                
                                strFechaBase = strFechaIni;
                                
                                for(intContadorDias=0;intContadorDias<=lgDiasDiff;intContadorDias++){
                                    strIdCampoConsumo = strIdSubservicio + "_" + strIdInsumo + "_" + strFechaBase; 
                                    
                                    if (funcionesComunes.esDiaHabil(strFechaBase)){
                                        dtFechaConsumo = sdf.parse(strFechaBase);
                                        bgCantidadPrevia = consumoServicioDAO.validarInsercionGrupal(strIdServicio,strIdSubservicio,strIdInsumo,dtFechaConsumo,strIdTipoUsuario,strIdUsuario);
                                        
                                        if (bgCantidadPrevia.compareTo(new BigDecimal(0)) == 1){
                                            out.println("<td class='TEXTOCELDATABLACONSUMO'><input type='text' id='" + strIdCampoConsumo + "' name='" + strIdCampoConsumo + "' class='CAMPOCELDACONSUMOLLENA' onblur=\"validarConsumo('" + strIdCampoConsumo + "')\" title='" +bgCantidadPrevia + "' readonly='true' /></td>");                                             
                                        }else{
                                            out.println("<td class='TEXTOCELDATABLACONSUMO'><input type='text' id='" + strIdCampoConsumo + "' name='" + strIdCampoConsumo + "' class='CAMPOCELDACONSUMO' onblur=\"validarConsumo('" + strIdCampoConsumo + "')\" value='" + strCantidadTransversal + "' /></td>"); 
                                        }                                        
                                        
                                    }else{
                                        out.println("<td class='TEXTOCELDATABLACONSUMO'><input type='text' id='" + strIdCampoConsumo + "' name='" + strIdCampoConsumo + "' class='CAMPOCELDACONSUMODISABLED' readonly='true' /></td>"); 
                                    }
                                                                        
                                    strFechaBase = funcionesComunes.aumentarDiasFecha(strFechaBase, 1);
                                    strIdCampoConsumo = null;
                                    dtFechaConsumo = null;
                                    bgCantidadPrevia = null; 
                                }
                                
                                out.println("</tr>");          
                                
                                intContadorInsumos++;
                                
                                strArregloInsumos = strArregloInsumos + strIdSubservicio + "<" + strIdInsumo+">";
                                
                                strIdInsumo = null;
                                strInsumo = null;
                                strIdUnidadInsumo = null;
                                strUnidadInsumo = null;
                                unidadMedida = null;
                            }
                            
                            intTotalInsumos = null;
                            strIdSubservicio = null;
                            strSubservicio = null;
                        }
                                                
                        out.println("<tr><td colspan='" + (lgDiasDiff + 4) + "' style='height: 5px;'></td></tr>");
                        out.println("<tr>");
                        out.println("<td colspan='" + (lgDiasDiff + 4) + "' class='CELDABOTONFORM'>");
                        out.println("<input type='submit' id='btnGuardar' name='btnGuardar' value='Guardar' class='BOTONFORM' />&nbsp;&nbsp;&nbsp;");
                        out.println("<input type='button' id='btnLimpiar' name='btnLimpiar' value='Limpiar' class='BOTONFORM' onclick='limpiarForm()' />&nbsp;&nbsp;&nbsp;");
                        out.println("<input type='button' id='btnSalir' name='btnSalir' value='Salir' class='BOTONFORM' onclick='javascript:window.close();' />&nbsp;&nbsp;&nbsp;");
                        out.println("<img src='Images/loader.gif' id='loaderGuardar' style='vertical-align: middle;width: 30px;height: 30px;' />");
                        out.println("</td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td colspan='" + (lgDiasDiff + 4) + "' class='TEXTOCONVENCIONES'>");
                        out.println("<b>Convenciones:</b>&nbsp;&nbsp;<img src='Images/cuadro_gris.png' class='IMGCONVENCION' />&nbsp;Día no hábil&nbsp;&nbsp;<img src='Images/cuadro_azul.png' class='IMGCONVENCION' />&nbsp;Día con valor ya insertado&nbsp;&nbsp;<img src='Images/cuadro_blanco.png' class='IMGCONVENCION' />&nbsp;Día disponible");
                        out.println("</td>");
                        out.println("</tr>");
                        out.println("</table>");
                        out.println("<input type='hidden' id='txtArregloInsumos' name='txtArregloInsumos' value='" + strArregloInsumos + "' style='width: 99%;' />");                        
                        out.println("<input type='hidden' id='txtTipoValidacion' name='txtTipoValidacion' value='1' />");
                        out.println("</div>");
                        
                        out.println("<script type='text/javascript'>");                            
                        out.println("$('#dLoader').hide();");
                        out.println("$('#loaderGuardar').hide();");
                        out.println("</script>");
                    }else{
                                                                      
                        Subservicio subservicio = subservicioDAO.obtenerUno(strIdSubservicio);
                        strInsumosFijos = subservicio.getInsumosFijos();
                        strSubservicio = subservicio.getNombre();
                        strAplicaSubcantidad = subservicio.getAplicaSubcantidad();
                        strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();
                        
                        if (strInsumosFijos.equals("S")){
                                                                                    
                            dtFechaConsumo = sdf.parse(strFechaIni);
                            
                            // Validar que no existan consumos previamente ingresados.
                            intCantidadRegistros = consumoServicioDAO.validarInsercionIndividual(strIdServicio,strIdSubservicio,dtFechaConsumo,strIdTipoUsuario,strIdUsuario);
                           
                            if (intCantidadRegistros <= 0){
                            
                                out.println("<div align='center'>");
                                out.println("<table cellspacing='0' cellpadding='5' border='0' width='70%' class='TABLACONSUMO'>");
                                out.println("<tr>");
                                out.println("<td class='SUBTITULOTABLAINGRESO'>SUBSERVICIO</td>");
                                out.println("<td class='SUBTITULOTABLAINGRESO'>INSUMO</td>");
                                out.println("<td class='SUBTITULOTABLAINGRESO'>CANTIDAD UTILIZADA</td>");
                                out.println("</tr>");                                

                                serviciosXinsumos = servicioXinsumoDAO.obtenerPorServicioSubservicio(strIdServicio, strIdSubservicio);

                                intContadorInsumos = 1;

                                for (ServicioXInsumo servicioXinsumo : serviciosXinsumos){
                                    strIdInsumo = servicioXinsumo.getInsumo();
                                    insumoServicio = insumoServicioDAO.obtenerUno(strIdInsumo);
                                    strInsumo = insumoServicio.getNombre();
                                    bdCantidadFija = servicioXinsumo.getCantidadFija();
                                    bdCantidadFija = bdCantidadFija.setScale(4, roundingMode);
                                    strCantidadUtilizada = bdCantidadFija.toString() + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(servicioXinsumo.getUnidadCantidadFija());

                                    out.println("<tr class='FILACONSUMO'>");

                                    if (intContadorInsumos == 1){                                    
                                        out.println("<td rowspan='" + serviciosXinsumos.size() + "' class='TEXTOCELDATABLACONSUMO'>" + strSubservicio + "</td>");
                                    }
                                    out.println("<td class='TEXTOCELDATABLACONSUMO' style='text-align: left;'>" + strInsumo + "</td>");
                                    out.println("<td class='TEXTOCELDATABLACONSUMO'>" + strCantidadUtilizada + "</td>");
                                    out.println("</tr>");

                                    intContadorInsumos++;
                                    strIdInsumo = null;
                                    insumoServicio = null;
                                    strInsumo = null;
                                    strCantidadUtilizada = null;
                                }

                                out.println("<tr><td colspan='3' style='height: 5px;></td></tr>");
                                if (strAplicaSubcantidad.equals("S")){
                                    out.println("<tr>");
                                    out.println("<td colspan='3' text-align='left;'><span class='LABELFORM' style='padding-top:0px;'>* " + strEtiquetaSubcantidad + ":</span>&nbsp;&nbsp;<input type='text' id='txtSubcantidad' name='txtSubcantidad' class='CAMPOFORM' style='width:50px;' />&nbsp;&nbsp;<img src='Images/error.png' id='imgSubcantidad' alt='Campo obligatorio' class='IMGERROR' style='display:none;'></td>");
                                    out.println("</tr>");                                    
                                }
                                out.println("<tr>");
                                out.println("<td colspan='3' class='CELDABOTONFORM'>");
                                out.println("<input type='submit' id='btnGuardar' name='btnGuardar' value='Guardar' class='BOTONFORM' />&nbsp;&nbsp;&nbsp;");
                                out.println("<input type='button' id='btnLimpiar' name='btnLimpiar' value='Limpiar' class='BOTONFORM' onclick='limpiarForm()' />&nbsp;&nbsp;&nbsp;");
                                out.println("<input type='button' id='btnSalir' name='btnSalir' value='Salir' class='BOTONFORM' onclick='javascript:window.close();' />");
                                out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr><td colspan='3' style='height: 5px;'></td></tr>");
                                out.println("</table>");
                                out.println("<input type='hidden' id='txtAplicaSubcantidad' name='txtAplicaSubcantidad' value='" + strAplicaSubcantidad + "' />");
                                out.println("<input type='hidden' id='txtTipoValidacion' name='txtTipoValidacion' value='0' />");
                                out.println("<script type='text/javascript'>");                            
                                out.println("$('#dLoader').hide();");
                                out.println("</script>");
                                out.println("</div>");
                            }else{                                
                                out.println("<div align='center' class='TEXTOFALLO'>");
                                out.println("<script type='text/javascript'>");          
                                out.println("setTimeout(function(){$('#dLoader').hide();}, 1500)");
                                out.println("setTimeout(function(){$('#dBotonesInicio').show();}, 1500)");
                                out.println("setTimeout(function(){alert('Ya existe un registro de consumo similar almacenado en el sistema. Por favor seleccione valores diferentes para continuar.');}, 1800)");                                  
                                out.println("</script>");                     
                                out.println("</div");
                                return;
                            }
                            
                        }else{
                                                                                    
                            strTipoFacturacion = subservicio.getTipoFacturacion();
                            strAplicaSubcantidad = subservicio.getAplicaSubcantidad();
                            strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();
                            strAplicaPorcentajeSancion = subservicio.getAplicaPorcentajeSancion();
                            
                            ItemAdicionalDAO itemAdicionalDAO = new ItemAdicionalDAOImpl();
                            List<ItemAdicional> itemsAdicionales = itemAdicionalDAO.obtenerTodos();
                            
                            if (strTipoFacturacion.equals("TIPOUSUARI")){                                                                
                                
                                ServicioXTipoUsuarioDAO servicioXtipoUsuarioDAO = new ServicioXTipoUsuarioDAOImpl();
                                List<TipoUsuario> tiposUsuario = servicioXtipoUsuarioDAO.obtenerTiposUsuarioPorServicioSubservicio(strIdServicio, strIdSubservicio);
                                                                                                
                                out.println("<input type='hidden' name='txtAplicaSubcantidad' id='txtAplicaSubcantidad' value='" + strAplicaSubcantidad + "' />");
                                out.println("<div align='center'>");                       
                                out.println("<table cellspacing='0' cellpadding='0' border='0' width='80%' class='TABLACONSUMO'>");
                                out.println("<tr>");
                                out.println("<td colspan='7' class='TITULOFORM'>DATOS COMPLEMENTARIOS DEL CONSUMO</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<td class='LABELFORM'>* Tipo de usuario:</td>");
                                out.println("<td class='CELDACAMPOFORM'>");
                                out.println("<select id='cbTipoUsuario' name='cbTipoUsuario' class='CAMPOSELECT' onchange='obtenerCantidad()'>");
                                out.println("<option value='-1'>Seleccione una opción</option>");
                                for(TipoUsuario tipoUsuario : tiposUsuario){
                                    out.println("<option value='" + tipoUsuario.getCodigo() + "'>" + tipoUsuario.getNombre() + "</option>");
                                }
                                out.println("</select>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgTipoUsuario' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                out.println("<td class='ESPACIOBLANCO'></td>");
                                out.println("<td class='LABELFORM'><div id='dCantidad'>* Cantidad:</div></td>");
                                out.println("<td class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtCantidad' id='txtCantidad' class='CAMPOFORM'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgCantidad' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                out.println("</tr>");      
                                if (strAplicaSubcantidad.equals("S")){
                                    out.println("<tr>");
                                    out.println("<td class='LABELFORM'>* " + strEtiquetaSubcantidad + ":</td>");
                                    out.println("<td class='CELDACAMPOFORM'>");
                                    out.println("<input type='text' name='txtSubcantidad' id='txtSubcantidad' class='CAMPOFORM'>");
                                    out.println("</td>");
                                    out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgSubcantidad' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                    out.println("<td class='ESPACIOBLANCO'></td>");
                                    out.println("<td class='LABELFORM'></td>");
                                    out.println("<td class='CELDACAMPOFORM'>");
                                    out.println("");
                                    out.println("</td>");
                                    out.println("<td class='CELDAIMGERROR'></td>");
                                    out.println("</tr>");
                                }
                                out.println("<tr>");
                                out.println("<td class='LABELFORM'>Concepto del consumo:</td>");
                                out.println("<td  class='CELDACAMPOFORM' colspan='5'>");
                                out.println("<input type='text' name='txtConceptoConsumo' id='txtConceptoConsumo' class='CAMPOFORM' style='width:93%;'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgConceptoConsumo' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");                                         
                                out.println("</tr>");
                                if (strAplicaPorcentajeSancion.equals("S")){
                                    out.println("<tr>");
                                    out.println("<td class='LABELFORM'>* ¿Aplica sanción?:</td>");
                                    out.println("<td class='CELDARADIOFORM'>");
                                    out.println("<input type='radio' name='rdAplicaSancion' id='rdAplicaSi' value='S'>Si");
                                    out.println("<input type='radio' name='rdAplicaSancion' id='rdAplicaNo' value='N'>No");
                                    out.println("</td>");
                                    out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgAplicaSancion' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                    out.println("<td class='ESPACIOBLANCO'></td>");
                                    out.println("<td class='LABELFORM'></td>");
                                    out.println("<td class='CELDACAMPOFORM'>");
                                    out.println("");
                                    out.println("</td>");
                                    out.println("<td class='CELDAIMGERROR'></td>");
                                    out.println("</tr>");
                                }
                                out.println("<tr><td colspan='7' style='height: 10px;'></td></tr>");
                                out.println("<tr>");
                                out.println("<td colspan='7' class='TITULOFORM'>DATOS DESCUENTO</td>");
                                out.println("</tr>");                                                
                                out.println("<tr>");
                                out.println("<td class='LABELFORM'>% de descuento: (Ejm: 30 ó 20.5)</td>");
                                out.println("<td  class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtDescuento' id='txtDescuento' class='CAMPOFORM' maxlength='4'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgDescuento' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");                                
                                out.println("<td class='ESPACIOBLANCO'></td>");
                                out.println("<td class='LABELFORM'>Concepto del descuento:</td>");
                                out.println("<td  class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtConceptoDescuento' id='txtConceptoDescuento' class='CAMPOFORM'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgConceptoDescuento' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>"); 
                                out.println("</tr>");
                                out.println("<tr><td colspan='7' style='height: 10px;'></td></tr>");
                                out.println("<tr>");
                                out.println("<td colspan='7' class='TITULOFORM'>DATOS CONSUMO ADICIONAL</td>");
                                out.println("</tr>");  
                                out.println("<tr>");
                                out.println("<td class='LABELFORM'>Item adicional:</td>");
                                out.println("<td class='CELDACAMPOFORM'>");
                                out.println("<select id='cbItemAdicional' name='cbItemAdicional' class='CAMPOSELECT'>");
                                out.println("<option value='-1'>Seleccione una opción</option>");
                                for(ItemAdicional itemAdicional : itemsAdicionales){
                                    out.println("<option value='" + itemAdicional.getCodigo() + "'>" + itemAdicional.getNombre() + "</option>");
                                }
                                out.println("</select>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgItemAdicional' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                out.println("<td class='ESPACIOBLANCO'></td>");
                                out.println("<td class='LABELFORM'>Valor ($): (Sin puntos ni comas)</td>");
                                out.println("<td class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtValorAdicional' id='txtValorAdicional' class='CAMPOFORM'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgValorAdicional' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                out.println("</tr>");
                                out.println("<tr><td colspan='7' style='height: 5px;'></td></tr>");
                                out.println("<tr>");
                                out.println("<td colspan='7' class='CELDABOTONFORM'>");
                                out.println("<input type='submit' id='btnGuardar' name='btnGuardar' value='Guardar' class='BOTONFORM' />&nbsp;&nbsp;&nbsp;");
                                out.println("<input type='button' id='btnLimpiar' name='btnLimpiar' value='Limpiar' class='BOTONFORM' onclick='limpiarForm()' />&nbsp;&nbsp;&nbsp;");
                                out.println("<input type='button' id='btnSalir' name='btnSalir' value='Salir' class='BOTONFORM' onclick='javascript:window.close();' />");
                                out.println("</td>");
                                out.println("</tr>");                           
                                out.println("<tr><td colspan='7' style='height: 5px;'></td></tr>");
                                out.println("</table>");                 
                                out.println("<input type='hidden' id='txtAplicaPorcentajeSancion' name='txtAplicaPorcentajeSancion' value='" + strAplicaPorcentajeSancion + "' />");
                                out.println("<input type='hidden' id='txtTipoValidacion' name='txtTipoValidacion' value='2' />");
                                out.println("<script type='text/javascript'>");                            
                                out.println("$('#dLoader').hide();");
                                out.println("</script>");            
                                out.println("<br />");  
                                out.println("</div");                   
                            }
                            
                            if (strTipoFacturacion.equals("UNDS")){
                                
                                ServicioXUnidadDAO servicioXunidadDAO = new ServicioXUnidadDAOImpl();
                                List<UnidadMedida> unidadesMedida =servicioXunidadDAO.obtenerUnidadesPorServicioSubservicio(strIdServicio, strIdSubservicio);
                                
                                out.println("<input type='hidden' name='txtAplicaSubcantidad' id='txtAplicaSubcantidad' value='" + strAplicaSubcantidad + "' />");
                                out.println("<div align='center'>");                       
                                out.println("<table cellspacing='0' cellpadding='0' border='0' width='80%' class='TABLACONSUMO'>");
                                out.println("<tr>");
                                out.println("<td colspan='7' class='TITULOFORM'>DATOS COMPLEMENTARIOS DEL CONSUMO</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                out.println("<td class='LABELFORM'>* Cantidad&nbsp;");
                                if (unidadesMedida.size() == 1){
                                    out.println("<select id='cbUnidadConsumo' name='cbUnidadConsumo' class='CAMPOSELECT' style='width:90px;'>:");                        
                                    for(UnidadMedida unidad : unidadesMedida){
                                        out.println("<option value='" +unidad.getCodigo() + "' selected>" + unidad.getNombre() + "</option>");
                                    }
                                    out.println("</select>:");                       
                                }else{
                                     if (unidadesMedida.size() > 1){
                                        out.println("* <select id='cbUnidadConsumo' name='cbUnidadConsumo' class='CAMPOSELECT' style='width:90px;'>:");
                                        out.println("<option value='-1'>Seleccione</option>");
                                        for(UnidadMedida unidad : unidadesMedida){
                                            out.println("<option value='" +unidad.getCodigo() + "'>" + unidad.getNombre() + "</option>");
                                        }
                                        out.println("</select>:");
                                         out.println("<img src='Images/error.png' id='imgUnidadConsumo' alt='Campo obligatorio' class='IMGERROR' style='display:none;'>");
                                     }else{
                                         out.println("* Cantidad:");
                                     }
                                }
                                out.println("</td>");
                                out.println("<td class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtCantidad' id='txtCantidad' class='CAMPOFORM'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgCantidad' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                out.println("<td class='ESPACIOBLANCO'></td>");            
                                out.println("<td class='LABELFORM'>Concepto del consumo:</td>");
                                out.println("<td  class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtConceptoConsumo' id='txtConceptoConsumo' class='CAMPOFORM'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgConceptoConsumo' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>"); 
                                out.println("</tr>");                                                            
                                out.println("<tr><td colspan='7' style='height: 10px;'></td></tr>");
                                out.println("<tr>");
                                out.println("<td colspan='7' class='TITULOFORM'>DATOS DESCUENTO</td>");
                                out.println("</tr>");
                                 out.println("<tr>");
                                out.println("<td class='LABELFORM'>% de descuento: (Ejm: 30 ó 20.5)</td>");
                                out.println("<td  class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtDescuento' id='txtDescuento' class='CAMPOFORM'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgDescuento' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");                                
                                out.println("<td class='ESPACIOBLANCO'></td>");
                                out.println("<td class='LABELFORM'>Concepto del descuento:</td>");
                                out.println("<td  class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtConceptoDescuento' id='txtConceptoDescuento' class='CAMPOFORM'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgConceptoDescuento' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>"); 
                                out.println("</tr>");
                                out.println("<tr><td colspan='7' style='height: 10px;'></td></tr>");
                                out.println("<tr>");
                                out.println("<td colspan='7' class='TITULOFORM'>DATOS CONSUMO ADICIONAL</td>");
                                out.println("</tr>");  
                                out.println("<tr>");
                                out.println("<td class='LABELFORM'>Item adicional:</td>");
                                out.println("<td class='CELDACAMPOFORM'>");
                                out.println("<select id='cbItemAdicional' name='cbItemAdicional' class='CAMPOSELECT'>");
                                out.println("<option value='-1'>Seleccione una opción</option>");
                                for(ItemAdicional itemAdicional : itemsAdicionales){
                                    out.println("<option value='" + itemAdicional.getCodigo() + "'>" + itemAdicional.getNombre() + "</option>");
                                }
                                out.println("</select>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgItemAdicional' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                out.println("<td class='ESPACIOBLANCO'></td>");
                                out.println("<td class='LABELFORM'>Valor ($): (Sin puntos ni comas)</td>");
                                out.println("<td class='CELDACAMPOFORM'>");
                                out.println("<input type='text' name='txtValorAdicional' id='txtValorAdicional' class='CAMPOFORM'>");
                                out.println("</td>");
                                out.println("<td class='CELDAIMGERROR'><img src='Images/error.png' id='imgValorAdicional' alt='Campo obligatorio' class='IMGERROR' style='display: none;'></td>");
                                out.println("</tr>");
                                out.println("<tr><td colspan='7' style='height: 5px;'></td></tr>");
                                out.println("<tr>");
                                out.println("<td colspan='7' class='CELDABOTONFORM'>");
                                out.println("<input type='submit' id='btnGuardar' name='btnGuardar' value='Guardar' class='BOTONFORM' />&nbsp;&nbsp;&nbsp;");
                                out.println("<input type='button' id='btnLimpiar' name='btnLimpiar' value='Limpiar' class='BOTONFORM' onclick='limpiarForm()' />&nbsp;&nbsp;&nbsp;");
                                out.println("<input type='button' id='btnSalir' name='btnSalir' value='Salir' class='BOTONFORM' onclick='javascript:window.close();' />");
                                out.println("</td>");
                                out.println("</tr>");                           
                                out.println("<tr><td colspan='7' style='height: 5px;'></td></tr>");
                                out.println("</table>");                                           
                                out.println("<input type='hidden' id='txtTipoValidacion' name='txtTipoValidacion' value='3' />");
                                out.println("<script type='text/javascript'>");                            
                                out.println("$('#dLoader').hide();");
                                out.println("</script>");            
                                out.println("<br />");  
                                out.println("</div");
                            }
                        }
                    }                    
                    
                }catch(ParseException pe){
                    String strMgsError = "Se generó un error parseando la fecha de consumo";
                    new GIDaoException(strMgsError,pe); 
                }catch(GIDaoException e){
                    String strMgsError = "No se recuperó la información del servicio " + strIdServicio;
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }                                        
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
