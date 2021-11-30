/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.CuentaCobroDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesDAO;
import co.edu.udea.facturacion.dao.InsumoServicioDAO;
import co.edu.udea.facturacion.dao.ItemAdicionalDAO;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import co.edu.udea.facturacion.dao.RolUsuarioDAO;
import co.edu.udea.facturacion.dao.RolXUsuarioDAO;
import co.edu.udea.facturacion.dao.ServicioDAO;
import co.edu.udea.facturacion.dao.ServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.ServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.TipoFacturacionDAO;
import co.edu.udea.facturacion.dao.TipoUsuarioConsumoDAO;
import co.edu.udea.facturacion.dao.TipoUsuarioDAO;
import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dao.UsuarioSIUDAO;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.CuentaCobroDAOImpl;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesConsumosDAOImpl;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl;
import co.edu.udea.facturacion.dao.impl.InsumoServicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ItemAdicionalDAOImpl;
import co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl;
import co.edu.udea.facturacion.dao.impl.RolUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.RolXUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.TipoFacturacionDAOImpl;
import co.edu.udea.facturacion.dao.impl.TipoUsuarioConsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.TipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.UnidadMedidaDAOImpl;
import co.edu.udea.facturacion.dao.impl.UsuarioSIUDAOImpl;
import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dto.CuentaCobro;
import co.edu.udea.facturacion.dto.InsumoServicio;
import co.edu.udea.facturacion.dto.ItemAdicional;
import co.edu.udea.facturacion.dto.ParametroBusquedaRegistro;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.dto.RolUsuario;
import co.edu.udea.facturacion.dto.RolXUsuario;
import co.edu.udea.facturacion.dto.Servicio;
import co.edu.udea.facturacion.dto.ServicioXInsumo;
import co.edu.udea.facturacion.dto.ServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ServicioXUnidad;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dto.TipoFacturacion;
import co.edu.udea.facturacion.dto.TipoUsuario;
import co.edu.udea.facturacion.dto.TipoUsuarioConsumo;
import co.edu.udea.facturacion.dto.UnidadMedida;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jorge.correa
 */
public class Visualizacion extends HttpServlet {

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

            Integer intRegistrosAEmpezar=0, intPaginaActual=0, intRegistrosAMostrar=0 ,intNroRegistros=0, intSubcantidad=0, intConsecutivo=0;
            String strAccion = null, strEvento = null, strTituloTabla=null, strHTMLTabla="", strMgsError=null, strTipoUsuarioConsumo=null, strHTMLRefrescar="";
            BigDecimal bdCantidad = null;
            Vector arrRoles = null;

            // Variables para el filtro.
            String strServicioB="-1", strSubservicioB="-1", strTipoUsuarioB="-1", strUsuarioB="-1", strFechaInicioB="", strFechaFinB="", strConsecutivo="", strNumSoporte="";
            String strCodigoB="", strNombreB="";
            String strHTMLBusqueda="";
            final RoundingMode roundingMode = RoundingMode.CEILING;

            HttpSession session = request.getSession(true);
            strAccion = request.getParameter("txtAccion");
            strEvento = request.getParameter("txtEvento");
            arrRoles = (Vector) session.getAttribute("rolesUsuario");

            ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
            FuncionesComunesDAO funcionesComunesDAO = new FuncionesComunesDAOImpl();
            FuncionesComunesConsumosDAO funcionesComunesConsumosDAO = new FuncionesComunesConsumosDAOImpl();
            ServicioDAO servicioDAO = new ServicioDAOImpl();
            List<Servicio> servicios = null;
            ParametroBusquedaRegistro parametroBusquedaRegistro = null;

            try{
                servicios = servicioDAO.obtenerTodos();
            }catch(GIDaoException e){
                 new GIDaoException("Se generó un error al intentar recuperar todos los servicios para la búsqueda.",e);
            }

            TipoUsuarioConsumoDAO tipoUsuarioConsumoDAO = new TipoUsuarioConsumoDAOImpl();
            List<TipoUsuarioConsumo> tiposUsuarioConsumo = null;

            try{
                tiposUsuarioConsumo = tipoUsuarioConsumoDAO.obtenerTodos();
            }catch(GIDaoException e){
                 new GIDaoException("Se generó un error al intentar recuperar todos los tipos de usuario para la búsqueda.",e);
            }

            try{
                ParametroGeneral parametroGeneral = null;
                parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
                
                if (parametroGeneral != null){
                    intRegistrosAMostrar = parametroGeneral.getNumeroRegistrosXPagina();
                }else{
                    intRegistrosAMostrar = 10;
                }
            }catch(GIDaoException e){
                 new GIDaoException("No se recuperaron los parámetros generales.",e);
            }

            if (request.getParameter("txtPagina") != null){
                intPaginaActual = Integer.parseInt(request.getParameter("txtPagina"));
                intRegistrosAEmpezar = (intPaginaActual - 1) * intRegistrosAMostrar;
            }else{
                intRegistrosAEmpezar = 0;
                intPaginaActual = 1;
            }

            if (strEvento.equals("busqueda")){

                parametroBusquedaRegistro = new ParametroBusquedaRegistro();

                if ((strAccion.equals("consumos_insumos")) || (strAccion.equals("consumos_tipos_usuario")) || (strAccion.equals("consumos_unidades")) || (strAccion.equals("cuentascobro"))){

                    strTipoUsuarioB = request.getParameter("txtTipoUsuario");
                    strUsuarioB = request.getParameter("txtUsuario");
                    strFechaInicioB = request.getParameter("txtFechaInicio");
                    strFechaFinB = request.getParameter("txtFechaFin");

                    parametroBusquedaRegistro.setTipoUsuario(strTipoUsuarioB);
                    parametroBusquedaRegistro.setUsuario(strUsuarioB);
                    parametroBusquedaRegistro.setFechaInicio(strFechaInicioB);
                    parametroBusquedaRegistro.setFechaFin(strFechaFinB);

                    if ((strAccion.equals("consumos_insumos")) || (strAccion.equals("consumos_tipos_usuario")) || (strAccion.equals("consumos_unidades"))){
                        strServicioB = request.getParameter("txtServicio");
                        strSubservicioB = request.getParameter("txtSubservicio");

                        parametroBusquedaRegistro.setServicio(strServicioB);
                        parametroBusquedaRegistro.setSubservicio(strSubservicioB);
                        parametroBusquedaRegistro.setConsecutivoCuentaCobro("");
                        parametroBusquedaRegistro.setNumeroSoporte("");
                    }

                    if(strAccion.equals("cuentascobro")){
                        strConsecutivo = request.getParameter("txtConsecutivo");
                        strNumSoporte = request.getParameter("txtNumSoporte");

                        parametroBusquedaRegistro.setServicio("");
                        parametroBusquedaRegistro.setSubservicio("");
                        parametroBusquedaRegistro.setConsecutivoCuentaCobro(strConsecutivo);
                        parametroBusquedaRegistro.setNumeroSoporte(strNumSoporte);
                    }
                }

                if ((strAccion.equals("unidad_medida")) || (strAccion.equals("tipo_usuario")) || (strAccion.equals("tipo_facturacion"))){
                    strCodigoB = request.getParameter("txtCodigo");
                    strNombreB = request.getParameter("txtNombre");

                    parametroBusquedaRegistro.setCodigo(strCodigoB);
                    parametroBusquedaRegistro.setNombre(strNombreB);
                }
            }

            strHTMLRefrescar = strHTMLRefrescar + "<form id='frmRefresh' name='frmRefresh'>\n";
            strHTMLRefrescar = strHTMLRefrescar + "<table cellspacing='0' cellpadding='0' border='0' width='100%'>\n";
            strHTMLRefrescar = strHTMLRefrescar + "<tr>\n";
            strHTMLRefrescar = strHTMLRefrescar + "<td class='TEXTOREFRESH'>\n";
            strHTMLRefrescar = strHTMLRefrescar + "<img src='Images/Refresh.png' id='btnRefresh' class='ICONOREFRESH' onclick=\"actualizarDatos('" + strAccion + "');\">\n";
            strHTMLRefrescar = strHTMLRefrescar + "<a href='#' onclick=\"actualizarDatos('" + strAccion + "');\">Actualizar datos</a>\n";
            strHTMLRefrescar = strHTMLRefrescar + "</td>\n";
             if (arrRoles != null){
                if ((arrRoles.contains("ADM")) || (arrRoles.contains("DES")) || (arrRoles.contains("RESP"))){
                    strHTMLRefrescar = strHTMLRefrescar + "<td>\n";
                    strHTMLRefrescar = strHTMLRefrescar + "<input type='button' id='btnCrearRegistro' name='btnCrearRegistro' value='Crear registro' class='BOTONACCION' style='width:100px;' onclick=\"crearRegistro('" + strAccion + "')\" />\n";
                    strHTMLRefrescar = strHTMLRefrescar + "</td>\n";
                }
            }
            strHTMLRefrescar = strHTMLRefrescar + "</tr>\n";
            strHTMLRefrescar = strHTMLRefrescar + "</table>\n";
            strHTMLRefrescar = strHTMLRefrescar + "</form>\n";

            if (strAccion.equals("consumos_insumos")){

                ConsumoServicioXInsumoDAO consumoServicioXInsumoDAO = new ConsumoServicioXInsumoDAOImpl();
                List <ConsumoServicioXInsumo> consumosServiciosXInsumos = null;

                // Formulario de filtro de consumos.

                strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                strHTMLBusqueda += "<td>\n";
                strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del servicio:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<select id='cbServicio' name='cbServicio' class='CAMPOSELECTB' onchange='cargarSubservicio();'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                if (servicios != null){
                    for(Servicio servicio : servicios){
                        strHTMLBusqueda += "<option value='" + servicio.getCodigo() + "'>" + servicio.getNombre() + "</option>\n";
                    }
                }
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del subservicio:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<div id='dSubservicio'>";
                strHTMLBusqueda += "<select id='cbSubservicio' name='cbSubservicio' class='CAMPOSELECTB'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</div>";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Tipo de usuario:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<select id='cbTipoUsuario' name='cbTipoUsuario' class='CAMPOSELECTB' style='width: 80%;' onchange='cargarUsuario();'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                if (tiposUsuarioConsumo != null){
                    for(TipoUsuarioConsumo tipoUsuario : tiposUsuarioConsumo){
                        strHTMLBusqueda += "<option value='" + tipoUsuario.getCodigo() + "'>" + tipoUsuario.getNombre() + "</option>\n";
                    }
                }
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del usuario:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<div id='dUsuario'>";
                strHTMLBusqueda += "<select id='cbUsuario' name='cbUsuario' class='CAMPOSELECTB' style='width: 80%;'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</div>";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Fecha inicio periodo:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<input type='text' name='txtFechaInicio' id='txtFechaInicio' class='CAMPOFORM' readonly />&nbsp;&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaInicio'>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Fecha fin periodo:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<input type='text' name='txtFechaFin' id='txtFechaFin' class='CAMPOFORM' readonly />&nbsp;&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaFin'>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                strHTMLBusqueda += "</table>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "</table>\n";
                strHTMLBusqueda += "</form>\n";
                strHTMLBusqueda += "<script type='text/javascript'>\n";
                strHTMLBusqueda += "cargarCalendariosBusqueda();";
                strHTMLBusqueda += "</script>\n";

                try{
                    strTituloTabla = "CONSUMOS DE SERVICIOS POR INSUMOS";

                    if (strEvento.equals("busqueda")){
                        consumosServiciosXInsumos = consumoServicioXInsumoDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = consumoServicioXInsumoDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();

                    }else{
                        consumosServiciosXInsumos =consumoServicioXInsumoDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = consumoServicioXInsumoDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println(strHTMLRefrescar);

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='8' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del servicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del subservicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del insumo</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Cantidad consumida</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Usuario del consumo</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Fecha del consumo<br />(aaaa-mm-dd)</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Facturado?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (ConsumoServicioXInsumo consumoServicio : consumosServiciosXInsumos){
                            strTipoUsuarioConsumo = consumoServicio.getTipoUsuarioConsumo();
                            intConsecutivo = consumoServicio.getCodigo();
                            bdCantidad = consumoServicio.getCantidadUnidad();

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerServicio(consumoServicio.getServicio()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerSubservicio(consumoServicio.getSubservicio()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerInsumo(consumoServicio.getInsumo()) + "</a></td>");
                            if (funcionesComunesDAO.tieneDecimales(bdCantidad)){
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + bdCantidad.setScale(2, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicio.getUnidadMedida()) + "</a></td>");
                            }else{
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + bdCantidad.setScale(0, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicio.getUnidadMedida()) + "</a></td>");
                            }
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerUsuario(consumoServicio.getUsuario(),strTipoUsuarioConsumo) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + consumoServicio.getFechaConsumo().toString() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(consumoServicio.getFacturado()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");
                            strTipoUsuarioConsumo = null;
                            bdCantidad = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='8' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los consumos de servicios por insumos.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }

            }

            if (strAccion.equals("consumos_tipos_usuario")){
                ConsumoServicioXTipoUsuarioDAO consumoServicioXTipoUsuarioDAO = new ConsumoServicioXTipoUsuarioDAOImpl();
                List <ConsumoServicioXTipoUsuario> consumosServiciosXTipoUsuario = null;

                // Formulario de filtro de consumos.

                strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                strHTMLBusqueda += "<td>\n";
                strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del servicio:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<select id='cbServicio' name='cbServicio' class='CAMPOSELECTB' onchange='cargarSubservicio();'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                if (servicios != null){
                    for(Servicio servicio : servicios){
                        strHTMLBusqueda += "<option value='" + servicio.getCodigo() + "'>" + servicio.getNombre() + "</option>\n";
                    }
                }
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del subservicio:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<div id='dSubservicio'>";
                strHTMLBusqueda += "<select id='cbSubservicio' name='cbSubservicio' class='CAMPOSELECTB'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</div>";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Tipo de usuario:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<select id='cbTipoUsuario' name='cbTipoUsuario' class='CAMPOSELECTB' style='width: 80%;' onchange='cargarUsuario();'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                if (tiposUsuarioConsumo != null){
                    for(TipoUsuarioConsumo tipoUsuario : tiposUsuarioConsumo){
                        strHTMLBusqueda += "<option value='" + tipoUsuario.getCodigo() + "'>" + tipoUsuario.getNombre() + "</option>\n";
                    }
                }
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del usuario:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<div id='dUsuario'>";
                strHTMLBusqueda += "<select id='cbUsuario' name='cbUsuario' class='CAMPOSELECTB' style='width: 80%;'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</div>";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Fecha inicio periodo:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<input type='text' name='txtFechaInicio' id='txtFechaInicio' class='CAMPOFORM' readonly />&nbsp;&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaInicio'>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Fecha fin periodo:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<input type='text' name='txtFechaFin' id='txtFechaFin' class='CAMPOFORM' readonly />&nbsp;&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaFin'>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                strHTMLBusqueda += "</table>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "</table>\n";
                strHTMLBusqueda += "</form>\n";
                strHTMLBusqueda += "<script type='text/javascript'>\n";
                strHTMLBusqueda += "cargarCalendariosBusqueda();";
                strHTMLBusqueda += "</script>\n";

                try{
                    strTituloTabla = "CONSUMOS DE SERVICIOS POR TIPOS DE USUARIO";

                    if (strEvento.equals("busqueda")){
                        consumosServiciosXTipoUsuario = consumoServicioXTipoUsuarioDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = consumoServicioXTipoUsuarioDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();
                    }else{
                        consumosServiciosXTipoUsuario =consumoServicioXTipoUsuarioDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = consumoServicioXTipoUsuarioDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println(strHTMLRefrescar);

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='9' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del servicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del subservicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Tipo de usuario</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Cantidad consumida</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Subcantidad</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Usuario del consumo</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Fecha del consumo<br />(aaaa-mm-dd)</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Facturado?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (ConsumoServicioXTipoUsuario consumoServicio : consumosServiciosXTipoUsuario){
                            strTipoUsuarioConsumo = consumoServicio.getTipoUsuarioConsumo();
                            intSubcantidad = consumoServicio.getSubcantidad();
                            intConsecutivo = consumoServicio.getCodigo();

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerServicio(consumoServicio.getServicio()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerSubservicio(consumoServicio.getSubservicio()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerTipoUsuario(consumoServicio.getTipoUsuario()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + consumoServicio.getCantidadUnidad() + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicio.getUnidadMedida()) + "</a></td>");
                            if (intSubcantidad > 0){
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + intSubcantidad + "</a></td>");
                            }else{
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">N/A</a></td>");
                            }
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerUsuario(consumoServicio.getUsuario(),strTipoUsuarioConsumo) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + consumoServicio.getFechaConsumo().toString() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(consumoServicio.getFacturado()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");
                            strTipoUsuarioConsumo = null;
                            intSubcantidad = 0;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='9' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los consumos de servicios por insumos.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }

            }

            if (strAccion.equals("consumos_unidades")){
                ConsumoServicioXUnidadDAO consumoServicioXUnidadDAO = new ConsumoServicioXUnidadDAOImpl();
                List <ConsumoServicioXUnidad> consumosServiciosXUnidad = null;

                // Formulario de filtro de consumos.

                strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                strHTMLBusqueda += "<td>\n";
                strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del servicio:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<select id='cbServicio' name='cbServicio' class='CAMPOSELECTB' onchange='cargarSubservicio();'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                if (servicios != null){
                    for(Servicio servicio : servicios){
                        strHTMLBusqueda += "<option value='" + servicio.getCodigo() + "'>" + servicio.getNombre() + "</option>\n";
                    }
                }
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del subservicio:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<div id='dSubservicio'>";
                strHTMLBusqueda += "<select id='cbSubservicio' name='cbSubservicio' class='CAMPOSELECTB'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</div>";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Tipo de usuario:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<select id='cbTipoUsuario' name='cbTipoUsuario' class='CAMPOSELECTB' style='width: 80%;' onchange='cargarUsuario();'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                if (tiposUsuarioConsumo != null){
                    for(TipoUsuarioConsumo tipoUsuario : tiposUsuarioConsumo){
                        strHTMLBusqueda += "<option value='" + tipoUsuario.getCodigo() + "'>" + tipoUsuario.getNombre() + "</option>\n";
                    }
                }
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del usuario:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<div id='dUsuario'>";
                strHTMLBusqueda += "<select id='cbUsuario' name='cbUsuario' class='CAMPOSELECTB' style='width: 80%;'>\n";
                strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                strHTMLBusqueda += "</select>\n";
                strHTMLBusqueda += "</div>";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Fecha inicio periodo:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<input type='text' name='txtFechaInicio' id='txtFechaInicio' class='CAMPOFORM' readonly />&nbsp;&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaInicio'>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Fecha fin periodo:</td>\n";
                strHTMLBusqueda += "<td style='width: 400px;'>\n";
                strHTMLBusqueda += "<input type='text' name='txtFechaFin' id='txtFechaFin' class='CAMPOFORM' readonly />&nbsp;&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaFin'>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "<tr>\n";
                strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                strHTMLBusqueda += "</table>\n";
                strHTMLBusqueda += "</td>\n";
                strHTMLBusqueda += "</tr>\n";
                strHTMLBusqueda += "</table>\n";
                strHTMLBusqueda += "</form>\n";
                strHTMLBusqueda += "<script type='text/javascript'>\n";
                strHTMLBusqueda += "cargarCalendariosBusqueda();";
                strHTMLBusqueda += "</script>\n";

                try{
                    strTituloTabla = "CONSUMOS DE SERVICIOS POR UNIDADES";

                    if (strEvento.equals("busqueda")){
                        consumosServiciosXUnidad = consumoServicioXUnidadDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = consumoServicioXUnidadDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();
                    }else{
                        consumosServiciosXUnidad =consumoServicioXUnidadDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = consumoServicioXUnidadDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println(strHTMLRefrescar);

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='7' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del servicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del subservicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Cantidad consumida</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Usuario del consumo</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Fecha del consumo<br />(aaaa-mm-dd)</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Facturado?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (ConsumoServicioXUnidad consumoServicio : consumosServiciosXUnidad){
                            strTipoUsuarioConsumo = consumoServicio.getTipoUsuarioConsumo();
                            intConsecutivo = consumoServicio.getCodigo();
                            bdCantidad = consumoServicio.getCantidadUnidad();

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerServicio(consumoServicio.getServicio()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerSubservicio(consumoServicio.getSubservicio()) + "</a></td>");

                            if (funcionesComunesDAO.tieneDecimales(bdCantidad)){
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + bdCantidad.setScale(2, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicio.getUnidadMedida()) + "</a></td>");
                            }else{
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + bdCantidad.setScale(0, roundingMode) + " " + funcionesComunesConsumosDAO.obtenerUnidadMedida(consumoServicio.getUnidadMedida()) + "</a></td>");
                            }

                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerUsuario(consumoServicio.getUsuario(),strTipoUsuarioConsumo) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + consumoServicio.getFechaConsumo().toString() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleConsumo('" + intConsecutivo + "','" + strAccion + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(consumoServicio.getFacturado()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");
                            strTipoUsuarioConsumo = null;
                            bdCantidad = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='7' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los consumos de servicios por insumos.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }

            if (strAccion.equals("cuentascobro")){
                CuentaCobroDAO cuentaCobroDAO = new CuentaCobroDAOImpl();
                List <CuentaCobro> cuentasCobro = null;
                Long lgCodigoCuentaCobro = null;

                try{

                    // Formulario de filtro de consumos.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Número de consecutivo:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtConsecutivo' name='txtConsecutivo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Número del soporte:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNumSoporte' name='txtNumSoporte' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Tipo de usuario:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<select id='cbTipoUsuario' name='cbTipoUsuario' class='CAMPOSELECTB' style='width: 80%;' onchange='cargarUsuario();'>\n";
                    strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                    if (tiposUsuarioConsumo != null){
                        for(TipoUsuarioConsumo tipoUsuario : tiposUsuarioConsumo){
                            strHTMLBusqueda += "<option value='" + tipoUsuario.getCodigo() + "'>" + tipoUsuario.getNombre() + "</option>\n";
                        }
                    }
                    strHTMLBusqueda += "</select>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del usuario:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<div id='dUsuario'>";
                    strHTMLBusqueda += "<select id='cbUsuario' name='cbUsuario' class='CAMPOSELECTB' style='width: 80%;'>\n";
                    strHTMLBusqueda += "<option value='-1'>Seleccione una opción</option>\n";
                    strHTMLBusqueda += "</select>\n";
                    strHTMLBusqueda += "</div>";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Fecha inicio periodo:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' name='txtFechaInicio' id='txtFechaInicio' class='CAMPOFORM' readonly />&nbsp;&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaInicio'>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Fecha fin periodo:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' name='txtFechaFin' id='txtFechaFin' class='CAMPOFORM' readonly />&nbsp;&nbsp;<img src='Images/Calendario.JPG' class='IMGCALENDAR' id='imgFechaFin'>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";
                    strHTMLBusqueda += "<script type='text/javascript'>\n";
                    strHTMLBusqueda += "cargarCalendariosBusqueda();";
                    strHTMLBusqueda += "</script>\n";

                    strTituloTabla = "CUENTAS DE COBRO";

                    if (strEvento.equals("busqueda")){
                        cuentasCobro = cuentaCobroDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = cuentaCobroDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();

                    }else{
                        cuentasCobro =cuentaCobroDAO.obtenerTodasPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = cuentaCobroDAO.obtenerTodas().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println(strHTMLRefrescar);

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='9' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Número de consecutivo</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del usuario</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Fecha de creación<br />(aaaa-mm-dd)</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Fecha inicio periodo<br />(aaaa-mm-dd)</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Fecha fin periodo<br />(aaaa-mm-dd)</td></td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Número de soporte</td></td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Fecha del soporte<br />(aaaa-mm-dd)</td></td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Valor del soporte ($)</td></td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (CuentaCobro cuentaCobro : cuentasCobro){
                            strTipoUsuarioConsumo = cuentaCobro.getTipoUsuarioConsumo();
                            lgCodigoCuentaCobro = cuentaCobro.getCodigo();

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">" + lgCodigoCuentaCobro+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">" + funcionesComunesConsumosDAO.obtenerUsuario(cuentaCobro.getUsuarioConsumo(),strTipoUsuarioConsumo) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">" + cuentaCobro.getFechaCreacion().toString() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">" + cuentaCobro.getFechaInicioPeriodo().toString() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">" + cuentaCobro.getFechaFinPeriodo().toString() + "</a></td>");

                            if (cuentaCobro.getNumeroSoporte() == null){
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">-</a></td>");
                            }else{
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">" + cuentaCobro.getNumeroSoporte() + "</a></td>");
                            }

                            if (cuentaCobro.getFechaSoporte() == null){
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">-</a></td>");
                            }else{
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">" + cuentaCobro.getFechaSoporte() + "</a></td>");
                            }

                            if (cuentaCobro.getValorSoporte() == null){
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">-</a></td>");
                            }else{
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirDetalleCuentaCobro('" + lgCodigoCuentaCobro + "')\">" + funcionesComunesDAO.marcarMiles(cuentaCobro.getValorSoporte().toString()) + "</a></td>");
                            }

                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strTipoUsuarioConsumo = null;
                            lgCodigoCuentaCobro = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='8' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron las cuentas de cobro.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }

            if (strAccion.equals("unidad_medida")){
                UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
                List <UnidadMedida> unidadesMedida = null;
                String strCodigo=null, strNombre=null;

                try{

                    // Formulario de filtro de unidades de medida.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "UNIDADES DE MEDIDA";

                    if (strEvento.equals("busqueda")){
                        /*cuentasCobro = unidadMedidaDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = unidadMedidaDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        unidadesMedida = unidadMedidaDAO.obtenerTodasPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = unidadMedidaDAO.obtenerTodas().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='3' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (UnidadMedida unidadMedida : unidadesMedida){
                            strCodigo = unidadMedida.getCodigo();
                            strNombre = unidadMedida.getNombre();

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirUnidadMedida('" + strCodigo + "')\">" + strCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirUnidadMedida('" + strCodigo + "')\">" + strNombre + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strCodigo = null;
                            strNombre = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron las unidades de medida.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }

            if (strAccion.equals("tipo_usuario")){
                TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAOImpl();
                List <TipoUsuario> tiposUsuario = null;
                String strCodigo=null, strNombre=null;

                try{

                    // Formulario de filtro de tipos de usuario.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "TIPOS DE USUARIO";

                    if (strEvento.equals("busqueda")){
                        /*cuentasCobro = unidadMedidaDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = unidadMedidaDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        tiposUsuario = tipoUsuarioDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = tipoUsuarioDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='3' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (TipoUsuario tipoUsuario : tiposUsuario){
                            strCodigo = tipoUsuario.getCodigo();
                            strNombre = tipoUsuario.getNombre();

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirTipoUsuario('" + strCodigo + "')\">" + strCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirTipoUsuario('" + strCodigo + "')\">" + strNombre + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strCodigo = null;
                            strNombre = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los tipos de usuario.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }

            if (strAccion.equals("tipo_facturacion")){
                TipoFacturacionDAO tipoFacturacionDAO = new TipoFacturacionDAOImpl();
                List <TipoFacturacion> tiposFacturacion = null;
                String strCodigo=null, strNombre=null;

                try{

                    // Formulario de filtro de tipos de facturación.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "TIPOS DE FACTURACIÓN";

                    if (strEvento.equals("busqueda")){
                        /*cuentasCobro = unidadMedidaDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = unidadMedidaDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        tiposFacturacion = tipoFacturacionDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = tipoFacturacionDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='3' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (TipoFacturacion tipoFacturacion : tiposFacturacion){
                            strCodigo = tipoFacturacion.getCodigo();
                            strNombre = tipoFacturacion.getNombre();

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirTipoFacturacion('" + strCodigo + "')\">" + strCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirTipoFacturacion('" + strCodigo + "')\">" + strNombre + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strCodigo = null;
                            strNombre = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los tipos de facturación.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }

            if (strAccion.equals("item_adicional")){
                ItemAdicionalDAO itemAdicionalDAO = new ItemAdicionalDAOImpl();
                List <ItemAdicional> itemsAdicionales = null;
                String strCodigo=null, strNombre=null;

                try{

                    // Formulario de filtro de ítems adicionales.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "ÍTEMS ADICIONALES";

                    if (strEvento.equals("busqueda")){
                        /*cuentasCobro = unidadMedidaDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = unidadMedidaDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        itemsAdicionales = itemAdicionalDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = itemAdicionalDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='3' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (ItemAdicional itemAdicional : itemsAdicionales){
                            strCodigo = itemAdicional.getCodigo();
                            strNombre = itemAdicional.getNombre();

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirItemAdicional('" + strCodigo + "')\">" + strCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirItemAdicional('" + strCodigo + "')\">" + strNombre + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strCodigo = null;
                            strNombre = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los ítems adicionales.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }

            if (strAccion.equals("insumo_servicio")){
                InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
                List <InsumoServicio> insumosServicios = null;
                String strCodigo=null, strNombre=null, strUnidadMedida=null, strPresentacion=null;
                Integer intCantidadDisponible=null;
                BigDecimal bdCostoUnitario=null;
                
                UnidadMedidaDAO UnidadMedidaDAO = new UnidadMedidaDAOImpl();
                UnidadMedida unidadMedida = null;

                try{

                    // Formulario de filtro de insumos de servicios.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "INSUMOS DE SERVICIOS";

                    if (strEvento.equals("busqueda")){
                        /*insumosServicios = insumoServicioDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = insumoServicioDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        insumosServicios = insumoServicioDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = insumoServicioDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='7' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Unidad de medida</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Presentación</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Costo unitario</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Cantidad disponible</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (InsumoServicio insumoServicio : insumosServicios){
                            strCodigo = insumoServicio.getCodigo();
                            strNombre = insumoServicio.getNombre();
                            strUnidadMedida = insumoServicio.getUnidadMedida();
                            strPresentacion = insumoServicio.getPresentacion();
                            bdCostoUnitario = new BigDecimal(insumoServicio.getCostoUnitario());
                            intCantidadDisponible = insumoServicio.getCantidadDisponible();
                            
                            unidadMedida = UnidadMedidaDAO.obtenerUna(strUnidadMedida);

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirInsumoServicio('" + strCodigo + "')\">" + strCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirInsumoServicio('" + strCodigo + "')\">" + strNombre + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirInsumoServicio('" + strCodigo + "')\">" + unidadMedida.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirInsumoServicio('" + strCodigo + "')\">" + strPresentacion + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirInsumoServicio('" + strCodigo + "')\">$" + funcionesComunesDAO.marcarMiles(bdCostoUnitario.toString()) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirInsumoServicio('" + strCodigo + "')\">" + intCantidadDisponible.toString() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strCodigo = null;
                            strNombre = null;
                            strUnidadMedida = null;
                            strPresentacion = null;
                            bdCostoUnitario = null;
                            intCantidadDisponible = null;
                            unidadMedida = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los insumos de servicios.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }
            
            if (strAccion.equals("rol_usuario")){
                RolUsuarioDAO rolUsuarioDAO = new RolUsuarioDAOImpl();
                List <RolUsuario> rolesUsuario = null;
                String strCodigo=null, strNombre=null, strSeAutentica=null;

                try{

                    // Formulario de filtro de roles de usuario.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "ROLES DE USUARIO";

                    if (strEvento.equals("busqueda")){
                        /*rolesUsuario = rolUsuarioDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = rolUsuarioDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        rolesUsuario = rolUsuarioDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = rolUsuarioDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='4' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Se autentica?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (RolUsuario rolUsuario : rolesUsuario){
                            strCodigo = rolUsuario.getCodigo();
                            strNombre = rolUsuario.getNombre();
                            strSeAutentica = rolUsuario.getSeAutentica();                            
                            
                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirRolUsuario('" + strCodigo + "')\">" + strCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirRolUsuario('" + strCodigo + "')\">" + strNombre + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirRolUsuario('" + strCodigo + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(strSeAutentica) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strCodigo = null;
                            strNombre = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los roles de usuario.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }
            
            if (strAccion.equals("rol_por_usuario")){
                RolXUsuarioDAO rolXUsuarioDAO = new RolXUsuarioDAOImpl();
                List <RolXUsuario> rolesXUsuario = null;
                String strRol=null, strUsuario=null;
                
                RolUsuarioDAO rolUsuarioDAO = new RolUsuarioDAOImpl();
                RolUsuario rolUsuario = null;
                
                UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
                UsuarioSesionSIU usuarioSesionSIU = null;

                try{

                    // Formulario de filtro de roles por usuario.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del rol:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre del usuario:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "ROLES POR USUARIO";

                    if (strEvento.equals("busqueda")){
                        /*rolesXUsuario = rolXUsuarioDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = rolXUsuarioDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        rolesXUsuario = rolXUsuarioDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = rolXUsuarioDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='3' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del rol</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del usuario</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (RolXUsuario rolXUsuario : rolesXUsuario){
                            strRol = rolXUsuario.getRol();
                            strUsuario = rolXUsuario.getPersona();
                            rolUsuario = rolUsuarioDAO.obtenerUno(strRol);
                            usuarioSesionSIU = usuarioSIUDAO.obtenerInfoUsuario(strUsuario);
                                                
                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirRolXUsuario('" + strRol + "','" + strUsuario + "')\">" + rolUsuario.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirRolXUsuario('" + strRol + "','" + strUsuario + "')\">" + usuarioSesionSIU.getNombreCompleto() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strRol = null;
                            strUsuario = null;
                            rolUsuario = null;
                            usuarioSesionSIU = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los roles por usuario.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }
            
            if (strAccion.equals("subservicio")){
                SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                List<Subservicio> subservicios = null;
                
                String strCodigo=null, strNombre=null, strResponsable=null, strServicioPadre=null;
                String strInsumosFijos=null, strAplicaSubcantidad=null, strEtiquetaSubcantidad=null, strAplicaPorcentajeSancion=null;
                                                
                UsuarioSIUDAO usuarioSIUDAO = new UsuarioSIUDAOImpl();
                UsuarioSesionSIU usuarioSIU = null;
                
                Servicio servicio = null;                

                try{

                    // Formulario de filtro de subservicios.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "SUBSERVICIOS";

                    if (strEvento.equals("busqueda")){
                        /*subservicios = subservicioDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = subservicioDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        subservicios = subservicioDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = subservicioDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='9' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre</td>\n";                    
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Responsable</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Servicio padre</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Tiene insumos fijos?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Aplica subcantidad?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Etiqueta subcantidad</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Aplica % de sanción?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (Subservicio subservicio : subservicios){
                            strCodigo = subservicio.getCodigo();
                            strNombre = subservicio.getNombre();                            
                            strResponsable = subservicio.getResponsable();
                            strServicioPadre = subservicio.getServicioPadre();
                            strInsumosFijos = subservicio.getInsumosFijos();
                            strAplicaSubcantidad = subservicio.getAplicaSubcantidad();
                            strEtiquetaSubcantidad = subservicio.getEtiquetaSubcantidad();
                            strAplicaPorcentajeSancion = subservicio.getAplicaPorcentajeSancion();                                                    
                           
                            usuarioSIU = usuarioSIUDAO.obtenerInfoUsuario(strResponsable);                           
                            servicio = servicioDAO.obtenerUno(strServicioPadre);    

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirSubservicio('" + strCodigo + "')\">" + strCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirSubservicio('" + strCodigo + "')\">" + strNombre + "</a></td>");                            
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirSubservicio('" + strCodigo + "')\">" + usuarioSIU.getNombreCompleto() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirSubservicio('" + strCodigo + "')\">" + servicio.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirSubservicio('" + strCodigo + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(strInsumosFijos) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirSubservicio('" + strCodigo + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(strAplicaSubcantidad) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirSubservicio('" + strCodigo + "')\">" + strEtiquetaSubcantidad + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirSubservicio('" + strCodigo + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(strAplicaPorcentajeSancion) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            strCodigo = null;
                            strNombre = null;                            
                            strResponsable = null;
                            strServicioPadre = null;
                            strInsumosFijos = null;
                            strAplicaSubcantidad = null;
                            strEtiquetaSubcantidad = null;
                            strAplicaPorcentajeSancion = null;
                            
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los subservicios.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }
            
            if (strAccion.equals("servicios_por_unidades")){
                ServicioXUnidadDAO servicioXUnidadDAO = new ServicioXUnidadDAOImpl();               
                List<ServicioXUnidad> serviciosXUnidad = null;
                
                String strServicio=null, strSubservicio=null, strUnidadMedida=null;
                Integer intCodigo=null;
                Long lgValorUnidad=null;
                                                
                SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                Subservicio subservicio = null;
                
                UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
                UnidadMedida unidadMedida = null;
                
                Servicio servicio = null;                

                try{

                    // Formulario de filtro de servicios por unidad.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "SERVICIOS POR UNIDADES";

                    if (strEvento.equals("busqueda")){
                        /*serviciosXUnidad = servicioXUnidadDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = servicioXUnidadDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        serviciosXUnidad = servicioXUnidadDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = servicioXUnidadDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='6' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del servicio</td>\n";                    
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del subservicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Unidad de medida</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Valor de la unidad</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (ServicioXUnidad servicioXUnidad : serviciosXUnidad){
                            intCodigo = servicioXUnidad.getCodigo();
                            strServicio = servicioXUnidad.getServicio();                            
                            strSubservicio = servicioXUnidad.getSubservicio();
                            strUnidadMedida = servicioXUnidad.getUnidadMedida();
                            lgValorUnidad = servicioXUnidad.getValorUnidad();
                                                                                                       
                            servicio = servicioDAO.obtenerUno(strServicio);    
                            subservicio = subservicioDAO.obtenerUno(strSubservicio);
                            unidadMedida = unidadMedidaDAO.obtenerUna(strUnidadMedida);

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXUnidad('" + intCodigo + "')\">" + intCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXUnidad('" + intCodigo + "')\">" + servicio.getNombre() + "</a></td>");                            
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXUnidad('" + intCodigo + "')\">" + subservicio.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXUnidad('" + intCodigo + "')\">" + unidadMedida.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXUnidad('" + intCodigo + "')\">$" + funcionesComunesDAO.marcarMiles(lgValorUnidad.toString()) + "</a></td>");                            
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            intCodigo = null;
                            strServicio = null;                            
                            strSubservicio = null;
                            strUnidadMedida = null;
                            lgValorUnidad = null;
                            servicio = null;                      
                            subservicio = null;
                            unidadMedida = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los servicios por unidad.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }
            
            if (strAccion.equals("servicios_por_tipos_usuario")){
                ServicioXTipoUsuarioDAO servicioXTipoUsuarioDAO = new ServicioXTipoUsuarioDAOImpl();
                List<ServicioXTipoUsuario> serviciosXTipoUsuario = null;     
                                
                String strServicio=null, strSubservicio=null, strTipoUsuario=null, strUnidadMedida=null;
                Integer intCodigo=null;
                Long lgValorUnidad=null;
                                                
                SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                Subservicio subservicio = null;
                
                TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAOImpl();
                TipoUsuario tipoUsuario = null;
                
                UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
                UnidadMedida unidadMedida = null;
                
                Servicio servicio = null;                

                try{

                    // Formulario de filtro de servicios por tipo de usuario.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "SERVICIOS POR TIPOS DE USUARIO";

                    if (strEvento.equals("busqueda")){
                        /*serviciosXTipoUsuario = servicioXTipoUsuarioDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = servicioXTipoUsuarioDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        serviciosXTipoUsuario = servicioXTipoUsuarioDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = servicioXTipoUsuarioDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='7' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Código</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del servicio</td>\n";                    
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del subservicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Tipo de usuario</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Unidad de medida</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Valor de la unidad</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (ServicioXTipoUsuario servicioXTipoUsuario : serviciosXTipoUsuario){
                            intCodigo = servicioXTipoUsuario.getCodigo();
                            strServicio = servicioXTipoUsuario.getServicio();                            
                            strSubservicio = servicioXTipoUsuario.getSubservicio();
                            strTipoUsuario = servicioXTipoUsuario.getTipoUsuario();
                            strUnidadMedida = servicioXTipoUsuario.getUnidadMedida();
                            lgValorUnidad = servicioXTipoUsuario.getValorUnidad();
                                                                                                       
                            servicio = servicioDAO.obtenerUno(strServicio);    
                            subservicio = subservicioDAO.obtenerUno(strSubservicio);
                            unidadMedida = unidadMedidaDAO.obtenerUna(strUnidadMedida);
                            tipoUsuario =  tipoUsuarioDAO.obtenerUno(strTipoUsuario);

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXTipoUsuario('" + intCodigo + "')\">" + intCodigo+ "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXTipoUsuario('" + intCodigo + "')\">" + servicio.getNombre() + "</a></td>");                            
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXTipoUsuario('" + intCodigo + "')\">" + subservicio.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXTipoUsuario('" + intCodigo + "')\">" + tipoUsuario.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXTipoUsuario('" + intCodigo + "')\">" + unidadMedida.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXTipoUsuario('" + intCodigo + "')\">$" + funcionesComunesDAO.marcarMiles(lgValorUnidad.toString()) + "</a></td>");                            
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            intCodigo = null;
                            strServicio = null;                            
                            strSubservicio = null;
                            strTipoUsuario = null;
                            strUnidadMedida = null;
                            lgValorUnidad = null;
                            servicio = null;                      
                            subservicio = null;
                            unidadMedida = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los servicios por tipo de usuario.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }                        
            
            if (strAccion.equals("servicios_por_insumos")){
                ServicioXInsumoDAO servicioXInsumoDAO = new ServicioXInsumoDAOImpl();
                List<ServicioXInsumo> serviciosXInsumo = null;                         
                                
                String strServicio=null, strSubservicio=null, strInsumo=null, strCobroTransversal=null, strUnidadCantidadFija=null, strUtilizaCostoVariable=null, strSeCobraAlUsuario=null;
                String strCantidadFija=null;
                Integer intCodigo=null, intCantidadCobroTransversal=null;
                Long lgCostoVariable=null;
                BigDecimal bdCantidadFija=null;
                                                
                SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                Subservicio subservicio = null;
                
                InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
                InsumoServicio insumoServicio = null;
                
                UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
                UnidadMedida unidadMedida = null;
                
                Servicio servicio = null;                

                try{

                    // Formulario de filtro de servicios por tipo de insumo.

                    strHTMLBusqueda += "<form id='frmBusqueda' name='frmBusqueda'>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='0' border='0' class='TABLABUSQUEDA' width='100%'>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='background: #EAEAEB;'>Filtros</td>\n";
                    strHTMLBusqueda += "<td>\n";
                    strHTMLBusqueda += "<table cellspacing='0' cellpadding='3' border='0' width='100%'>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Código:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtCodigo' name='txtCodigo' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "<td class='LABELFORM' style='width: 200px;'>Nombre:</td>\n";
                    strHTMLBusqueda += "<td style='width: 400px;'>\n";
                    strHTMLBusqueda += "<input type='text' id='txtNombre' name='txtNombre' class='CAMPOFORM' />\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "<tr>\n";
                    strHTMLBusqueda += "<td colspan='4' style='text-align: center;'><input type='button' id='btnFiltrar' name='btnFiltrar' value='Filtrar' class='BOTONACCION' onclick=\"filtrarRegistros('" +strAccion + "');\" />&nbsp;&nbsp;&nbsp;<input type='reset' id='btnLimpiar' name='btnLimpiar' value='limpiar' class='BOTONACCION' /></td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "<tr><td style='height: 5px;'></td></tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</td>\n";
                    strHTMLBusqueda += "</tr>\n";
                    strHTMLBusqueda += "</table>\n";
                    strHTMLBusqueda += "</form>\n";

                    strTituloTabla = "SERVICIOS POR INSUMOS";

                    if (strEvento.equals("busqueda")){
                        /*serviciosXInsumo = servicioXInsumoDAO.obtenerTodosBusquedaPorPaginas(parametroBusquedaRegistro, intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = servicioXInsumoDAO.obtenerTodosBusqueda(parametroBusquedaRegistro).size();*/

                    }else{
                        serviciosXInsumo = servicioXInsumoDAO.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
                        intNroRegistros = servicioXInsumoDAO.obtenerTodos().size();
                    }

                    out.println(strHTMLBusqueda);
                    out.println("<br />");
                    out.println(strHTMLRefrescar);
                    out.println("<br />");

                    strHTMLTabla = strHTMLTabla + "<table cellspacing='0' cellpadding='5' border='0' width='100%' class='TABLARESULT'>";
                    strHTMLTabla = strHTMLTabla + "<tr>";
                    strHTMLTabla = strHTMLTabla + "<td colspan='11' class='TITULOTABLA'>" + strTituloTabla + "</td>";
                    strHTMLTabla = strHTMLTabla + "</tr>";
                    strHTMLTabla = strHTMLTabla + "<tr>";                    
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del servicio</td>\n";                    
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del subservicio</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Nombre del insumo</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Cobro transversal?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Cantidad cobro transversal</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Cantidad fija</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Unidad cantidad fija</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Utiliza costo variable?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>Costo variable</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Se cobra al usuario?</td>\n";
                    strHTMLTabla = strHTMLTabla + "<td class='SUBTITULOTABLA'>¿Eliminar?</td>\n";
                    strHTMLTabla = strHTMLTabla + "</tr>";

                    out.println(strHTMLTabla);

                    if (intNroRegistros > 0){
                        for (ServicioXInsumo servicioXInsumo : serviciosXInsumo){
                            intCodigo = servicioXInsumo.getCodigo();
                            strServicio = servicioXInsumo.getServicio();                            
                            strSubservicio = servicioXInsumo.getSubservicio();
                            strInsumo = servicioXInsumo.getInsumo();
                            strCobroTransversal = servicioXInsumo.getCobroTransversal();
                            intCantidadCobroTransversal = servicioXInsumo.getCantidadCobroTransversal();
                            bdCantidadFija = servicioXInsumo.getCantidadFija();
                            strUnidadCantidadFija = servicioXInsumo.getUnidadCantidadFija();
                            strUtilizaCostoVariable = servicioXInsumo.getUtilizaCostoVariable();
                            lgCostoVariable = servicioXInsumo.getCostoVariable();
                            strSeCobraAlUsuario = servicioXInsumo.getSeCobraAlUsuario();
                                                                                                       
                            servicio = servicioDAO.obtenerUno(strServicio);    
                            subservicio = subservicioDAO.obtenerUno(strSubservicio);
                            unidadMedida = unidadMedidaDAO.obtenerUna(strUnidadCantidadFija);
                            insumoServicio = insumoServicioDAO.obtenerUno(strInsumo);

                            out.println("<tr class='FILARESULT'>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + servicio.getNombre() + "</a></td>");                            
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + subservicio.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + insumoServicio.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(strCobroTransversal) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + funcionesComunesDAO.marcarMiles(intCantidadCobroTransversal.toString())  + "</a></td>");
                            if (funcionesComunesDAO.tieneDecimales(bdCantidadFija)){
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + bdCantidadFija.setScale(3, roundingMode)+ "</a></td>");
                            }else{
                                out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + bdCantidadFija.setScale(0, roundingMode)+ "</a></td>");
                            }                                                        
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + unidadMedida.getNombre() + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(strUtilizaCostoVariable) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">$" + funcionesComunesDAO.marcarMiles(lgCostoVariable.toString()) + "</a></td>");   
                            out.println("<td class='TEXTORESULT'><a href='#' onclick=\"abrirServicioXInsumo('" + intCodigo + "')\">" + funcionesComunesConsumosDAO.obtenerSiNo(strSeCobraAlUsuario) + "</a></td>");
                            out.println("<td class='TEXTORESULT'><img src='Images/Delete.png' width='11px' height='11px' /></td>");
                            out.println("</tr>");

                            intCodigo = null;
                            strServicio = null;                            
                            strSubservicio = null;
                            strInsumo = null;
                            strCobroTransversal = null;
                            intCantidadCobroTransversal = null;
                            bdCantidadFija = null;
                            strUnidadCantidadFija = null;
                            strUtilizaCostoVariable = null;
                            lgCostoVariable = null;
                            strSeCobraAlUsuario = null;
                            servicio = null;                      
                            subservicio = null;
                            insumoServicio = null;
                            unidadMedida = null;
                        }
                    }else{
                        intNroRegistros = 1;
                        out.println("<tr>");
                        out.println("<td colspan='3' class='TEXTOFALLO' style='padding-top: 0px;border-bottom: 1px solid #116043;'>No se encontraron registros almacenados para visualizar</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                }catch(GIDaoException e){
                    strMgsError = "No se recuperaron los servicios por tipo de usuario.";
                    new GIDaoException(strMgsError,e);
                    out.println("<div class='TEXTOFALLO'>");
                    out.println(strMgsError);
                    out.println("</div>");
                }
            }                        
                       
            //Paginación.

            out.println("<br />");
            out.println("<table cellpadding='5' cellspacing='0' border='0' width='100%'>");
            out.println("<tr>");
            out.println("<td style='text-align:center;'>");

            Integer  intPagAnt=0, intPagSig=0, intPagUlt=0;
            Float ftRes;

            intPagAnt = intPaginaActual - 1;
            intPagSig = intPaginaActual + 1;
            intPagUlt = (intNroRegistros/intRegistrosAMostrar);

            ftRes = Float.valueOf(intNroRegistros % intRegistrosAMostrar);

            if (ftRes>0){
                intPagUlt = ((int)intPagUlt) + 1;
            }

            if (strEvento.equals("busqueda")){
                if ((strAccion.equals("consumos_insumos")) || (strAccion.equals("consumos_tipos_usuario")) || (strAccion.equals("consumos_unidades"))){
                     out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=busqueda&txtServicio="+strServicioB+"&txtSubservicio="+strSubservicioB+"&txtTipoUsuario="+strTipoUsuarioB+"&txtUsuario="+strUsuarioB+"&txtFechaInicio="+strFechaInicioB+"&txtFechaFin="+strFechaFinB + "&txtPagina=1','dMostrar');\" class=\"TEXTOPAGINACION\">Primera</a>");
                    if (intPaginaActual > 1){
                        out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=busqueda&txtServicio="+strServicioB+"&txtSubservicio="+strSubservicioB+"&txtTipoUsuario="+strTipoUsuarioB+"&txtUsuario="+strUsuarioB+"&txtFechaInicio="+strFechaInicioB+"&txtFechaFin="+strFechaFinB + "&txtPagina=" + intPagAnt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Anterior</a>");
                    }
                    out.println("<span class='TEXTOPAGINACION' style='font-weight: bold;'>Página " + intPaginaActual + "/" + intPagUlt + "</span>");
                    if (intPaginaActual < intPagUlt){
                        out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=busqueda&txtServicio="+strServicioB+"&txtSubservicio="+strSubservicioB+"&txtTipoUsuario="+strTipoUsuarioB+"&txtUsuario="+strUsuarioB+"&txtFechaInicio="+strFechaInicioB+"&txtFechaFin="+strFechaFinB + "&txtPagina=" + intPagSig + "','dMostrar');\" class=\"TEXTOPAGINACION\">Siguiente</a>");
                    }
                    out.println("<a href=\"#\"  onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=busqueda&txtServicio="+strServicioB+"&txtSubservicio="+strSubservicioB+"&txtTipoUsuario="+strTipoUsuarioB+"&txtUsuario="+strUsuarioB+"&txtFechaInicio="+strFechaInicioB+"&txtFechaFin="+strFechaFinB + "&txtPagina=" + intPagUlt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Última</a>");
                }

                 if(strAccion.equals("cuentascobro")){
                     out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=busqueda&txtConsecutivo="+strConsecutivo+"&txtNumSoporte="+strNumSoporte+"&txtTipoUsuario="+strTipoUsuarioB+"&txtUsuario="+strUsuarioB+"&txtFechaInicio="+strFechaInicioB+"&txtFechaFin="+strFechaFinB + "&txtPagina=1','dMostrar');\" class=\"TEXTOPAGINACION\">Primera</a>");
                    if (intPaginaActual > 1){
                        out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=busqueda&txtConsecutivo="+strConsecutivo+"&txtNumSoporte="+strNumSoporte+"&txtTipoUsuario="+strTipoUsuarioB+"&txtUsuario="+strUsuarioB+"&txtFechaInicio="+strFechaInicioB+"&txtFechaFin="+strFechaFinB + "&txtPagina=" + intPagAnt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Anterior</a>");
                    }
                    out.println("<span class='TEXTOPAGINACION' style='font-weight: bold;'>Página " + intPaginaActual + "/" + intPagUlt + "</span>");
                    if (intPaginaActual < intPagUlt){
                        out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=busqueda&txtConsecutivo="+strConsecutivo+"&txtNumSoporte="+strNumSoporte+"&txtTipoUsuario="+strTipoUsuarioB+"&txtUsuario="+strUsuarioB+"&txtFechaInicio="+strFechaInicioB+"&txtFechaFin="+strFechaFinB + "&txtPagina=" + intPagSig + "','dMostrar');\" class=\"TEXTOPAGINACION\">Siguiente</a>");
                    }
                    out.println("<a href=\"#\"  onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=busqueda&txtConsecutivo="+strConsecutivo+"&txtNumSoporte="+strNumSoporte+"&txtTipoUsuario="+strTipoUsuarioB+"&txtUsuario="+strUsuarioB+"&txtFechaInicio="+strFechaInicioB+"&txtFechaFin="+strFechaFinB + "&txtPagina=" + intPagUlt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Última</a>");
                 }
            }else{
                out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=&txtPagina=1','dMostrar');\" class=\"TEXTOPAGINACION\">Primera</a>");
                if (intPaginaActual > 1){
                    out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=&txtPagina=" + intPagAnt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Anterior</a>");
                }
                out.println("<span class='TEXTOPAGINACION' style='font-weight: bold;'>Página " + intPaginaActual + "/" + intPagUlt + "</span>");
                if (intPaginaActual < intPagUlt){
                    out.println("<a href=\"#\" onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=&txtPagina=" + intPagSig + "','dMostrar');\" class=\"TEXTOPAGINACION\">Siguiente</a>");
                }
                out.println("<a href=\"#\"  onclick=\"AJAXC('POST','Visualizacion','txtAccion=" + strAccion + "&txtEvento=&txtPagina=" + intPagUlt + "','dMostrar');\" class=\"TEXTOPAGINACION\">Última</a>");
            }

            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

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
