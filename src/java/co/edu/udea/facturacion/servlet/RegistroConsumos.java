/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.ConsumoAdicionalXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ConsumoAdicionalXUnidadDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.DescuentoConsumoXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesDAO;
import co.edu.udea.facturacion.dao.InsumoServicioDAO;
import co.edu.udea.facturacion.dao.ServicioDAO;
import co.edu.udea.facturacion.dao.ServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.DescuentoConsumoXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.DescuentoConsumoXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.FuncionesComunesDAOImpl;
import co.edu.udea.facturacion.dao.impl.InsumoServicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
import co.edu.udea.facturacion.dto.InsumoServicio;
import co.edu.udea.facturacion.dto.Servicio;
import co.edu.udea.facturacion.dto.ServicioXInsumo;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
 * @author Jorge.correa
 */
public class RegistroConsumos extends HttpServlet {

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
            
            String strAccion=null, strFechaRegistro=null, strIdUsuarioRegistra=null, strTipoUsuarioConsumo=null, strUsuarioConsumo=null, strIdServicioConsumido=null, strIdInsumo=null, strUnidadMedida=null;
            String strIdSubservicioConsumido=null, strFechaConsumo=null, strFechaInicioConsumo=null, strFechaFinConsumo=null, strCamposDiligenciados=null, strIdCampoConsumo = null, strAccionCrear="";
            String strMsgAccion=null, strModoIngresoConsumos=null, strInsumosFijos=null, strTipoFacturacion=null, strTipoUsuario=null, strConceptoConsumo=null, strItemAdicional=null, strConceptoDescuento=null;
            String strAplicaPorcentajeSancion=null, strAplicarSancion=null;
            String[] strTemp =null, strDatosConsumo = null;  
            Integer intCantidadConsumo=null, intTotalDuplicados = 0, intSubcantidad=0, intConsecutivo=0, intCantidadRegistros=0;
            Boolean insercionCorrecta = Boolean.FALSE;
            Long lgValorUnidad = null;
            Float ftValorDescuento = null;
            Date dtFechaConsumo=null;
            BigDecimal bdCantidadPrevia=null, bdCantidadConsumo = null, bdCantidadFija = null;
            
            strAccion = request.getParameter("txtAccion");
            strFechaRegistro = request.getParameter("txtFechaRegistro");
            strIdUsuarioRegistra = request.getParameter("txtIdUsuarioRegistra");
            strTipoUsuarioConsumo = request.getParameter("cbTipoUsuarioConsumo");
            strUsuarioConsumo = request.getParameter("cbUsuarioConsumo");
            strIdServicioConsumido = request.getParameter("cbServicioConsumido");
            strIdSubservicioConsumido = request.getParameter("cbSubservicioConsumido");
            strFechaInicioConsumo = request.getParameter("txtFechaIni");
            strFechaFinConsumo = request.getParameter("txtFechaFin");                      
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            FuncionesComunesDAO funcionesComunes = new FuncionesComunesDAOImpl();
            ConsumoServicioXInsumoDAO consumoServicioDAO = new ConsumoServicioXInsumoDAOImpl();
            ConsumoServicioXInsumo consumoServicio = null;
            ServicioDAO servicioDAO = new ServicioDAOImpl();
            Servicio servicio = null;
            
            try{
                servicio = servicioDAO.obtenerUno(strIdServicioConsumido);
            }catch(GIDaoException e){
                new GIDaoException("Se presentó un error consultanto la información  del servicio " + strIdServicioConsumido,e);   
            }
            
            if (servicio != null){
                strModoIngresoConsumos = servicio.getModoIngresoConsumos();
            }else{
                return;
            }
            
            InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
            InsumoServicio insumoServicio = null;                        
            
            if (strAccion.equals("C")){
                
                strAccionCrear = strAccionCrear + "<script type='text/javascript'>\n";
                strAccionCrear = strAccionCrear + "opener.frmRefresh.btnRefresh.click();\n";
                strAccionCrear = strAccionCrear + "location.href='notificacion.jsp';\n";
                strAccionCrear = strAccionCrear + "</script>\n";
                                
                final String SE_FACTURA="S", FACTURADO="N";
                Date dtFechaFacturacion = null;
                
                if (strModoIngresoConsumos.equals("G")){                 
                    
                    strCamposDiligenciados = request.getParameter("txtCamposDiligenciados"); 
                    strTemp = strCamposDiligenciados.split(">");
                    strMsgAccion = "Los consumos fueron registrados correctamente en el sistema!.";
                             
                    for (int i=0;i<strTemp.length;i++){
                                                                        
                        strIdCampoConsumo = strTemp[i];                
                        strDatosConsumo = strIdCampoConsumo.split("_");
                        strIdSubservicioConsumido = strDatosConsumo[0];
                        strIdInsumo = strDatosConsumo[1];
                        strFechaConsumo = strDatosConsumo[2];                        
                                                                                                
                        try{
                            
                            dtFechaConsumo = sdf.parse(strFechaConsumo);
                            
                            // Validar que no existan consumos previamente ingresados.
                            
                            bdCantidadPrevia = consumoServicioDAO.validarInsercionGrupal(strIdServicioConsumido,strIdSubservicioConsumido,strIdInsumo,dtFechaConsumo,strTipoUsuarioConsumo,strUsuarioConsumo);
                            
                            if (bdCantidadPrevia.compareTo(new BigDecimal(1)) == -1){
                                                                                    
                                bdCantidadConsumo = new BigDecimal(request.getParameter(strIdCampoConsumo));
                                insumoServicio = insumoServicioDAO.obtenerUno(strIdInsumo);
                                strUnidadMedida = insumoServicio.getUnidadMedida();
                                intSubcantidad = 1;

                                consumoServicio = new ConsumoServicioXInsumo();

                                consumoServicio.setServicio(strIdServicioConsumido);
                                consumoServicio.setSubservicio(strIdSubservicioConsumido);
                                consumoServicio.setInsumo(strIdInsumo);
                                consumoServicio.setFechaConsumo(dtFechaConsumo);
                                consumoServicio.setTipoUsuarioConsumo(strTipoUsuarioConsumo);
                                consumoServicio.setUsuario(strUsuarioConsumo);
                                consumoServicio.setUnidadMedida(strUnidadMedida);
                                consumoServicio.setCantidadUnidad(bdCantidadConsumo);
                                consumoServicio.setSeFactura(SE_FACTURA);
                                consumoServicio.setUsuarioRegistra(strIdUsuarioRegistra);
                                consumoServicio.setFechaRegistra(sdf.parse(strFechaRegistro));
                                consumoServicio.setFacturado(FACTURADO);
                                consumoServicio.setFechaFacturacion(dtFechaFacturacion);                         
                                consumoServicio.setCuentaCobro(Long.parseLong("0"));
                                consumoServicio.setSubcantidad(intSubcantidad);
                                                                                                                
                                consumoServicioDAO.insertar(consumoServicio);                                         
                                insercionCorrecta = Boolean.TRUE;                         
                            }else{
                                intTotalDuplicados++;
                            }                                                           
                            
                         }catch(ParseException pe){
                             new GIDaoException("Se presentó un error parseando las fechas del consumo ingresado.",pe);
                             insercionCorrecta = Boolean.FALSE;
                         }catch(GIDaoException e){
                             new GIDaoException("Se presentó un error insertando el nuevo consumo.",e);
                             insercionCorrecta = Boolean.FALSE;
                         }
                         
                         strIdCampoConsumo = null;
                         consumoServicio = null;
                         strDatosConsumo = null;
                         strIdSubservicioConsumido = null;
                         strIdInsumo = null;
                         strFechaConsumo = null;
                         bdCantidadConsumo = null;
                         insumoServicio = null;
                         strUnidadMedida = null;
                         bdCantidadPrevia = null;                
                         dtFechaConsumo = null;
                    }    
                    
                    if (insercionCorrecta){                        
                        if (intTotalDuplicados > 0){
                            out.println("<script type='text/javascript'>\n");
                            out.println("alert('Se encontraron algunos consumos duplicados que no fueron ingresados al sistema .');");
                            out.println("</script>\n");
                        }
                        
                        request.getSession().setAttribute("mensaje", strMsgAccion);      
                        out.println(strAccionCrear);
                    }else{
                        out.println("<script type='text/javascript'>\n");
                        out.println("alert('Se produjo un error al insertar los consumos en el sistema.');");
                        out.println("</script>\n");
                    }
                }else{
                        SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                        Subservicio subservicio =null;
                                                
                        try{
                            subservicio = subservicioDAO.obtenerUno(strIdSubservicioConsumido);
                        }catch(GIDaoException e){
                            new GIDaoException("Se presentó un error consultanto la información  del servicio " + strIdServicioConsumido,e);   
                        }
                                                
                        strInsumosFijos = subservicio.getInsumosFijos();         
                                                
                        if (strInsumosFijos.equals("S")){
                           ServicioXInsumoDAO servicioXinsumoDAO = new ServicioXInsumoDAOImpl();
                           List<ServicioXInsumo> serviciosXinsumos = null;
                           strMsgAccion = "Los consumos fueron registrados correctamente en el sistema!.";
                           
                           try{
                                dtFechaConsumo = sdf.parse(strFechaInicioConsumo); 
                           }catch(ParseException pe){
                                new GIDaoException("Se presentó un error parseando la fecha del consumo ingresado.",pe);                               
                            }
                            
                           try{
                                
                                if (request.getParameter("txtAplicaSubcantidad").toString().equals("S")){                                    
                                    intSubcantidad = Integer.parseInt(request.getParameter("txtSubcantidad")); 
                                }else{                                    
                                    intSubcantidad = 1;
                                }
                                
                                serviciosXinsumos = servicioXinsumoDAO.obtenerPorServicioSubservicio(strIdServicioConsumido, strIdSubservicioConsumido);                                      
                                                                                                                                 
                                for (ServicioXInsumo servicioXinsumo : serviciosXinsumos){

                                    bdCantidadFija = servicioXinsumo.getCantidadFija();                                    
                                    strUnidadMedida = servicioXinsumo.getUnidadCantidadFija();  
                                    strIdInsumo = servicioXinsumo.getInsumo();                                    
                                                                       
                                    consumoServicio = new ConsumoServicioXInsumo();

                                    consumoServicio.setServicio(strIdServicioConsumido);
                                    consumoServicio.setSubservicio(strIdSubservicioConsumido);
                                    consumoServicio.setInsumo(strIdInsumo);
                                    consumoServicio.setFechaConsumo(dtFechaConsumo);
                                    consumoServicio.setTipoUsuarioConsumo(strTipoUsuarioConsumo);
                                    consumoServicio.setUsuario(strUsuarioConsumo);
                                    consumoServicio.setUnidadMedida(strUnidadMedida);
                                    consumoServicio.setCantidadUnidad(bdCantidadFija);
                                    consumoServicio.setSeFactura(SE_FACTURA);
                                    consumoServicio.setUsuarioRegistra(strIdUsuarioRegistra);
                                    consumoServicio.setFechaRegistra(sdf.parse(strFechaRegistro));
                                    consumoServicio.setFacturado(FACTURADO);
                                    consumoServicio.setFechaFacturacion(dtFechaFacturacion);             
                                    consumoServicio.setCuentaCobro(Long.parseLong("0"));
                                    consumoServicio.setSubcantidad(intSubcantidad);
                                                                        
                                    consumoServicioDAO.insertar(consumoServicio);                                              
                                    insercionCorrecta = Boolean.TRUE;                                                                                                                                                                                        

                                    bdCantidadFija = null;
                                    strUnidadMedida = null;
                                    strIdInsumo = null;
                                    consumoServicio = null;                                                          
                                }
                                                             
                            }catch(ParseException pe){
                                new GIDaoException("Se presentó un error parseando las fechas del consumo ingresado.",pe);
                                insercionCorrecta = Boolean.FALSE;
                            }catch(GIDaoException e){
                                new GIDaoException("Se presentó un error insertando el nuevo consumo.",e);
                                insercionCorrecta = Boolean.FALSE;
                            }
                            
                            if (insercionCorrecta){                                                                                      
                                request.getSession().setAttribute("mensaje", strMsgAccion);      
                                out.println(strAccionCrear);
                            }else{
                                out.println("<script type='text/javascript'>\n");
                                out.println("alert('Se produjo un error al insertar los consumos en el sistema. Por favor intente de nuevo en un momento o contacte al Administrador del Sistema');");
                                out.println("history.back();");
                                out.println("</script>\n");
                                return;
                            }
                            
                        }else{
                            strTipoFacturacion = subservicio.getTipoFacturacion();
                            
                            if (strTipoFacturacion.equals("TIPOUSUARI")){
                                
                                strTipoUsuario = request.getParameter("cbTipoUsuario");
                                strUnidadMedida = request.getParameter("cbUnidadConsumo");
                                intCantidadConsumo = Integer.parseInt(request.getParameter("txtCantidad"));
                                
                                if (request.getParameter("txtSubcantidad") != null){
                                    intSubcantidad = Integer.parseInt(request.getParameter("txtSubcantidad")); 
                                }else{
                                    intSubcantidad = 0;
                                }
                                
                                strAplicaPorcentajeSancion = request.getParameter("txtAplicaPorcentajeSancion");
                                
                                if (strAplicaPorcentajeSancion.equals("S")){
                                    strAplicarSancion = request.getParameter("rdAplicaSancion");
                                }else{
                                    strAplicarSancion = "N";
                                }
                                
                                strConceptoConsumo = request.getParameter("txtConceptoConsumo");
                                strMsgAccion = "El consumo fue registrado correctamente en el sistema!.";
                                
                                if (!(strConceptoConsumo.equals(""))){
                                    strConceptoConsumo= new String(strConceptoConsumo.getBytes("iso-8859-1"),"UTF-8");   
                                }
                                
                               try{
                                    dtFechaConsumo = sdf.parse(strFechaInicioConsumo); 
                               }catch(ParseException pe){
                                    new GIDaoException("Se presentó un error parseando la fecha del consumo ingresado.",pe);                               
                               }
                               
                               ConsumoServicioXTipoUsuarioDAO consumoServicioXtipoUsuarioDAO = new ConsumoServicioXTipoUsuarioDAOImpl();
                               ConsumoServicioXTipoUsuario consumoServicioXtipoUsuario = new ConsumoServicioXTipoUsuario();
                               
                               // Valida que no existe un registro ya creado.
                               
                                try{
                                    intCantidadRegistros =  consumoServicioXtipoUsuarioDAO.validarInsercion(strIdServicioConsumido, strIdSubservicioConsumido, strTipoUsuario, dtFechaConsumo, strTipoUsuarioConsumo, strUsuarioConsumo, strUnidadMedida);
                                }catch(GIDaoException e){
                                    new GIDaoException("Se generó un error validando la inserción del consumo.",e);
                                }
                               
                                if (intCantidadRegistros <=0){
                                    consumoServicioXtipoUsuario.setServicio(strIdServicioConsumido);
                                    consumoServicioXtipoUsuario.setSubservicio(strIdSubservicioConsumido);
                                    consumoServicioXtipoUsuario.setTipoUsuario(strTipoUsuario);
                                    consumoServicioXtipoUsuario.setFechaConsumo(dtFechaConsumo);
                                    consumoServicioXtipoUsuario.setTipoUsuarioConsumo(strTipoUsuarioConsumo);
                                    consumoServicioXtipoUsuario.setUsuario(strUsuarioConsumo);
                                    consumoServicioXtipoUsuario.setUnidadMedida(strUnidadMedida);
                                    consumoServicioXtipoUsuario.setCantidadUnidad(intCantidadConsumo);
                                    consumoServicioXtipoUsuario.setSubcantidad(intSubcantidad);
                                    consumoServicioXtipoUsuario.setSeFactura(SE_FACTURA);
                                    consumoServicioXtipoUsuario.setUsuarioRegistra(strIdUsuarioRegistra);
                                    try{
                                        consumoServicioXtipoUsuario.setFechaRegistra(sdf.parse(strFechaRegistro));
                                    }catch(ParseException pe){                                    
                                        new GIDaoException("Se presentó un error parseando la fecha de registro.",pe);                               
                                    }
                                    consumoServicioXtipoUsuario.setFacturado(FACTURADO);
                                    consumoServicioXtipoUsuario.setFechaFacturacion(dtFechaFacturacion);
                                    consumoServicioXtipoUsuario.setConcepto(strConceptoConsumo);
                                    consumoServicioXtipoUsuario.setCuentaCobro(Long.parseLong("0"));
                                    consumoServicioXtipoUsuario.setAplicarSancion(strAplicarSancion);

                                    try{
                                        intConsecutivo = consumoServicioXtipoUsuarioDAO.insertar(consumoServicioXtipoUsuario);
                                    }catch(GIDaoException e){
                                        new GIDaoException("Se generó un error insertando el registro de consumo por tipo de usuario.",e);
                                    }

                                    if (intConsecutivo > 0){

                                        // Ingreso de descuento del consumo.
                                         
                                        if ((request.getParameter("txtDescuento") != "") && (request.getParameter("txtDescuento") != null)){
                                            ftValorDescuento = Float.parseFloat(request.getParameter("txtDescuento"));
                                            
                                            if ((request.getParameter("txtConceptoDescuento") != "") &&(request.getParameter("txtConceptoDescuento") != null)){
                                                strConceptoDescuento = request.getParameter("txtConceptoDescuento");                                              
                                                strConceptoDescuento= new String(strConceptoDescuento.getBytes("iso-8859-1"),"UTF-8");                                   
                                            }else{
                                                strConceptoDescuento = "";
                                            }
                                            
                                            DescuentoConsumoXTipoUsuarioDAO descuentoConsumoXtipoUsuarioDAO = new DescuentoConsumoXTipoUsuarioDAOImpl();
                                            DescuentoConsumo descuentoConsumo = new DescuentoConsumo();
                                            
                                            descuentoConsumo.setConsumo(intConsecutivo);
                                            descuentoConsumo.setDescuento(ftValorDescuento);
                                            descuentoConsumo.setSeFactura(SE_FACTURA);
                                            descuentoConsumo.setUsuarioRegistra(strIdUsuarioRegistra);
                                            try{
                                                descuentoConsumo.setFechaRegistra(sdf.parse(strFechaRegistro));
                                            }catch(ParseException pe){                                    
                                                new GIDaoException("Se presentó un error parseando la fecha de registro del descuento.",pe);                               
                                            }
                                            descuentoConsumo.setAplicado(FACTURADO);
                                            descuentoConsumo.setFechaAplicacion(dtFechaFacturacion);
                                            descuentoConsumo.setConcepto(strConceptoDescuento);
                                            
                                            try{
                                                descuentoConsumoXtipoUsuarioDAO.insertar(descuentoConsumo);
                                            }catch(GIDaoException e){
                                                new GIDaoException("Se presentó un error insertando el descuento del consumo " + intConsecutivo,e);                 
                                            }
                                        }

                                        // Ingreso del consumo adicional del consumo.
                                        
                                        if ((request.getParameter("cbItemAdicional") != null) && !(request.getParameter("cbItemAdicional").toString().equals("-1"))){
                                                                                        
                                            strItemAdicional = request.getParameter("cbItemAdicional");
                                            lgValorUnidad = Long.parseLong(request.getParameter("txtValorAdicional"));
                                            
                                            ConsumoAdicionalXTipoUsuarioDAO  consumoAdicionalXtipoUsuarioDAO = new ConsumoAdicionalXTipoUsuarioDAOImpl();
                                            ConsumoAdicional consumoAdicional = new ConsumoAdicional();

                                            consumoAdicional.setConsumo(intConsecutivo);
                                            consumoAdicional.setItemAdicional(strItemAdicional);
                                            consumoAdicional.setFechaConsumo(dtFechaConsumo);
                                            consumoAdicional.setValorUnidad(lgValorUnidad);
                                            consumoAdicional.setSeFactura(SE_FACTURA);
                                            consumoAdicional.setUsuarioRegistra(strIdUsuarioRegistra);
                                            try{
                                                consumoAdicional.setFechaRegistra(sdf.parse(strFechaRegistro));
                                            }catch(ParseException pe){                                    
                                                new GIDaoException("Se presentó un error parseando la fecha de registro del consumo adicional.",pe);                               
                                            }
                                            consumoAdicional.setFacturado(FACTURADO);
                                            consumoAdicional.setFechaFacturacion(dtFechaFacturacion);
                                            
                                            try{
                                                consumoAdicionalXtipoUsuarioDAO.insertar(consumoAdicional);
                                            }catch(GIDaoException e){
                                                new GIDaoException("Se presentó un error insertando el consumo adicional del consumo " + intConsecutivo,e);                 
                                            }
                                        }

                                        request.getSession().setAttribute("mensaje", strMsgAccion);      
                                        out.println(strAccionCrear);
                                    }else{
                                        out.println("<script type='text/javascript'>\n");
                                        out.println("alert('Se produjo un error al insertar el consumo en el sistema. Por favor intente de nuevo en un momento o contacte al Administrador del Sistema');\n");
                                        out.println("history.back();\n");
                                        out.println("</script>\n");
                                        return;
                                    }                                
                                }else{
                                    out.println("<script type='text/javascript'>\n");
                                    out.println("alert('Ya existe un registro con datos similares en el sistema. Por favor intente ingresando valores diferentes para continuar.');\n");
                                    out.println("history.back();\n");
                                    out.println("</script>\n");
                                    return;
                                }                                
                            }
                            
                            if (strTipoFacturacion.equals("UNDS")){
                                strUnidadMedida = request.getParameter("cbUnidadConsumo");
                                bdCantidadConsumo = new BigDecimal(request.getParameter("txtCantidad"));                                
                                strConceptoConsumo = request.getParameter("txtConceptoConsumo");
                                strMsgAccion = "El consumo fue registrado correctamente en el sistema!.";
                                
                                if (strConceptoConsumo != ""){
                                    strConceptoConsumo= new String(strConceptoConsumo.getBytes("iso-8859-1"),"UTF-8");   
                                }
                                
                               try{
                                    dtFechaConsumo = sdf.parse(strFechaInicioConsumo); 
                               }catch(ParseException pe){
                                    new GIDaoException("Se presentó un error parseando la fecha del consumo ingresado.",pe);                               
                               }
                               
                                ConsumoServicioXUnidadDAO consumoServicioXunidadDAO = new ConsumoServicioXUnidadDAOImpl();
                                ConsumoServicioXUnidad consumoServicioXunidad = new ConsumoServicioXUnidad();
                               
                               // Valida que no existe un registro ya creado.
                               
                                try{
                                    intCantidadRegistros =  consumoServicioXunidadDAO.validarInsercion(strIdServicioConsumido, strIdSubservicioConsumido, dtFechaConsumo, strTipoUsuarioConsumo, strUsuarioConsumo, strUnidadMedida);
                                }catch(GIDaoException e){
                                    new GIDaoException("Se generó un error validando la inserción del consumo.",e);
                                }
                               
                                if (intCantidadRegistros <=0){
                                    
                                    consumoServicioXunidad.setServicio(strIdServicioConsumido);
                                    consumoServicioXunidad.setSubservicio(strIdSubservicioConsumido);                              
                                    consumoServicioXunidad.setFechaConsumo(dtFechaConsumo);
                                    consumoServicioXunidad.setTipoUsuarioConsumo(strTipoUsuarioConsumo);
                                    consumoServicioXunidad.setUsuario(strUsuarioConsumo);
                                    consumoServicioXunidad.setUnidadMedida(strUnidadMedida);
                                    consumoServicioXunidad.setCantidadUnidad(bdCantidadConsumo);                                    
                                    consumoServicioXunidad.setSeFactura(SE_FACTURA);
                                    consumoServicioXunidad.setUsuarioRegistra(strIdUsuarioRegistra);
                                    
                                    try{
                                            consumoServicioXunidad.setFechaRegistra(sdf.parse(strFechaRegistro));
                                        }catch(ParseException pe){                                    
                                            new GIDaoException("Se presentó un error parseando la fecha de registro.",pe);                               
                                        }
                                        consumoServicioXunidad.setFacturado(FACTURADO);
                                        consumoServicioXunidad.setFechaFacturacion(dtFechaFacturacion);
                                        consumoServicioXunidad.setConcepto(strConceptoConsumo);
                                        consumoServicioXunidad.setCuentaCobro(Long.parseLong("0"));

                                        try{
                                            intConsecutivo = consumoServicioXunidadDAO.insertar(consumoServicioXunidad);
                                        }catch(GIDaoException e){
                                            new GIDaoException("Se generó un error insertando el registro de consumo por unidad.",e);
                                        }

                                        if (intConsecutivo > 0){

                                            // Ingreso de descuento del consumo.

                                            if ((request.getParameter("txtDescuento") != "") && (request.getParameter("txtDescuento") != null)){
                                                ftValorDescuento = Float.parseFloat(request.getParameter("txtDescuento"));

                                                if ((request.getParameter("txtConceptoDescuento") != "") &&(request.getParameter("txtConceptoDescuento") != null)){
                                                    strConceptoDescuento = request.getParameter("txtConceptoDescuento");                                              
                                                    strConceptoDescuento= new String(strConceptoDescuento.getBytes("iso-8859-1"),"UTF-8");                                   
                                                }else{
                                                    strConceptoDescuento = "";
                                                }

                                                DescuentoConsumoXUnidadDAO descuentoConsumoXunidadDAO = new DescuentoConsumoXUnidadDAOImpl();
                                                DescuentoConsumo descuentoConsumo = new DescuentoConsumo();

                                                descuentoConsumo.setConsumo(intConsecutivo);
                                                descuentoConsumo.setDescuento(ftValorDescuento);
                                                descuentoConsumo.setSeFactura(SE_FACTURA);
                                                descuentoConsumo.setUsuarioRegistra(strIdUsuarioRegistra);
                                                try{
                                                    descuentoConsumo.setFechaRegistra(sdf.parse(strFechaRegistro));
                                                }catch(ParseException pe){                                    
                                                    new GIDaoException("Se presentó un error parseando la fecha de registro del descuento.",pe);                               
                                                }
                                                descuentoConsumo.setAplicado(FACTURADO);
                                                descuentoConsumo.setFechaAplicacion(dtFechaFacturacion);
                                                descuentoConsumo.setConcepto(strConceptoDescuento);

                                                try{
                                                    descuentoConsumoXunidadDAO.insertar(descuentoConsumo);
                                                }catch(GIDaoException e){
                                                    new GIDaoException("Se presentó un error insertando el descuento del consumo " + intConsecutivo,e);                 
                                                }
                                            }

                                            // Ingreso del consumo adicional del consumo.
                                            
                                            if ((request.getParameter("cbItemAdicional") != null) && !(request.getParameter("cbItemAdicional").toString().equals("-1"))){                                            
                                                strItemAdicional = request.getParameter("cbItemAdicional");
                                                lgValorUnidad = Long.parseLong(request.getParameter("txtValorAdicional"));

                                                ConsumoAdicionalXUnidadDAO consumoAdicionalXunidadDAO = new ConsumoAdicionalXUnidadDAOImpl();
                                                ConsumoAdicional consumoAdicional = new ConsumoAdicional();

                                                consumoAdicional.setConsumo(intConsecutivo);
                                                consumoAdicional.setItemAdicional(strItemAdicional);
                                                consumoAdicional.setFechaConsumo(dtFechaConsumo);
                                                consumoAdicional.setValorUnidad(lgValorUnidad);
                                                consumoAdicional.setSeFactura(SE_FACTURA);
                                                consumoAdicional.setUsuarioRegistra(strIdUsuarioRegistra);
                                                try{
                                                    consumoAdicional.setFechaRegistra(sdf.parse(strFechaRegistro));
                                                }catch(ParseException pe){                                    
                                                    new GIDaoException("Se presentó un error parseando la fecha de registro del consumo adicional.",pe);                               
                                                }
                                                consumoAdicional.setFacturado(FACTURADO);
                                                consumoAdicional.setFechaFacturacion(dtFechaFacturacion);

                                                try{
                                                    consumoAdicionalXunidadDAO.insertar(consumoAdicional);
                                                }catch(GIDaoException e){
                                                    new GIDaoException("Se presentó un error insertando el consumo adicional del consumo " + intConsecutivo,e);                 
                                                }
                                            }

                                            request.getSession().setAttribute("mensaje", strMsgAccion);      
                                            out.println(strAccionCrear);
                                        }else{
                                            out.println("<script type='text/javascript'>\n");
                                            out.println("alert('Se produjo un error al insertar el consumo en el sistema. Por favor intente de nuevo en un momento o contacte al Administrador del Sistema');\n");
                                            out.println("history.back();\n");
                                            out.println("</script>\n");
                                            return;
                                        }                                
                                }else{
                                    out.println("<script type='text/javascript'>\n");
                                    out.println("alert('Ya existe un registro con datos similares en el sistema. Por favor intente ingresando valores diferentes para continuar.');\n");
                                    out.println("history.back();\n");
                                    out.println("</script>\n");
                                    return;
                                }                                                               
                            }                            
                        }
                }                                        
                               
            }else{
                out.println("Consultando");
            }            
            
        }finally {
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
