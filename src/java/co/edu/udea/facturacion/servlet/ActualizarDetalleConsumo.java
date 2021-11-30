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
import co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoAdicionalXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ConsumoServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.DescuentoConsumoXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.DescuentoConsumoXUnidadDAOImpl;
import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge.correa
 */
public class ActualizarDetalleConsumo extends HttpServlet {

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
            
            String strAccionCrear="", strMsgAccion=null, strTipoConsumo=null, strIdServicio=null, strIdSubservicio=null, strFechaRegistro=null, strIdUsuarioRegistra=null, strIdTipoUsuarioConsumo=null;
            String strIdUsuarioConsumo=null, strFechaConsumo=null, strIdInsumo=null, strIdUnidadMedida=null, strSeFactura=null, strFacturado=null, strFechaFacturacion=null, strIdTipoUsuario=null;
            String strConcepto=null, strTieneDescuento=null, strTieneConsumoAdicional=null, strConceptoDescuento=null, strSeFacturaDescuento=null, strFacturadoDescuento=null, strFechaAplicacionDescuento=null;
            String strFechaRegistroDescuento=null, strIdItemAdicional=null, strFechaConsumoAdicional=null, strSeFacturaConsumoA=null,strFacturadoConsumoA=null, strAplicaSubcantidad=null, strFechaFacturacionConsumoA=null;
            String strAplicaPorcentajeSancion=null, strAplicaSancion=null;
            Integer intConsecutivo=null, intCantidadUnidad=null, intSubcantidad=null, intCodigoDescuento=null, intCodigoConsumoAdicional=null;
            Long LgValorUnidad=null, lgCuentaCobro=null;
            Float ftValorDescuento=null;
            BigDecimal bdCantidadUnidad=null;
            Boolean actualizar = Boolean.FALSE;
            strAccionCrear = strAccionCrear + "<script type='text/javascript'>\n";
            strAccionCrear = strAccionCrear + "opener.frmRefresh.btnRefresh.click();\n";
            strAccionCrear = strAccionCrear + "location.href='notificacion.jsp';\n";
            strAccionCrear = strAccionCrear + "</script>\n";
            strMsgAccion = "El consumo fue actualizado correctamente en el sistema!.";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            strTipoConsumo = request.getParameter("txtTipoConsumo");
            intConsecutivo = Integer.parseInt(request.getParameter("txtCodigo"));            
            strIdServicio = request.getParameter("txtIdServicio");
            strIdSubservicio = request.getParameter("txtIdSubservicio");
            strFechaRegistro = request.getParameter("txtFechaRegistro");
            strIdUsuarioRegistra = request.getParameter("txtIdUsuarioRegistra");
            strIdTipoUsuarioConsumo = request.getParameter("txtIdTipoUsuarioConsumo");
            strIdUsuarioConsumo = request.getParameter("txtIdUsuarioConsumo");            
            strFechaConsumo = request.getParameter("txtFechaConsumo");                               
            strIdUnidadMedida = request.getParameter("txtIdUnidadMedida");        
            strSeFactura = request.getParameter("rdSeFactura");               
            strFacturado = request.getParameter("rdFacturado");                
            lgCuentaCobro = Long.parseLong(request.getParameter("txtCuentaCobro"));
            strFechaFacturacion = request.getParameter("txtFechaFacturacion");             
            strTieneDescuento = request.getParameter("txtTieneDescuento");       
            strTieneConsumoAdicional = request.getParameter("txtTieneConsumoAdicional");       
                                    
            if (strTipoConsumo.equals("consumos_insumos")){
                
                strIdInsumo = request.getParameter("txtIdInsumo");
                bdCantidadUnidad = new BigDecimal(request.getParameter("txtCantidadConsumida"));
                strAplicaSubcantidad = request.getParameter("txtAplicaSubcantidad");
                
                if (strAplicaSubcantidad.equals("S")){  
                    intSubcantidad = Integer.parseInt(request.getParameter("txtSubcantidad"));
                }else{
                    intSubcantidad = 1;
                }
                
                ConsumoServicioXInsumoDAO consumoServicioXinsumoDAO = new ConsumoServicioXInsumoDAOImpl();
                ConsumoServicioXInsumo consumoServicioXinsumo = new ConsumoServicioXInsumo();
                     
                consumoServicioXinsumo.setCodigo(intConsecutivo);
                consumoServicioXinsumo.setServicio(strIdServicio);
                consumoServicioXinsumo.setSubservicio(strIdSubservicio);
                consumoServicioXinsumo.setInsumo(strIdInsumo);
                
                try{
                    consumoServicioXinsumo.setFechaConsumo(sdf.parse(strFechaConsumo));
                }catch(ParseException pe){
                    new GIDaoException("Se generó un error parseando la fecha de consumo al actualizar el consumo por insumo con consecutivo " + intConsecutivo,pe);
                }
                
                consumoServicioXinsumo.setTipoUsuarioConsumo(strIdTipoUsuarioConsumo);
                consumoServicioXinsumo.setUsuario(strIdUsuarioConsumo);
                consumoServicioXinsumo.setUnidadMedida(strIdUnidadMedida);
                consumoServicioXinsumo.setCantidadUnidad(bdCantidadUnidad);
                consumoServicioXinsumo.setSeFactura(strSeFactura);
                consumoServicioXinsumo.setUsuarioRegistra(strIdUsuarioRegistra);                
                
                try{
                    consumoServicioXinsumo.setFechaRegistra(sdf.parse(strFechaRegistro));
                }catch(ParseException pe){
                    new GIDaoException("Se generó un error parseando la fecha de registro al actualizar el consumo por insumo con consecutivo " + intConsecutivo,pe);
                }
                
                consumoServicioXinsumo.setFacturado(strFacturado);                
               
                if ((strFechaFacturacion == null) || (strFechaFacturacion.equals(""))){
                    consumoServicioXinsumo.setFechaFacturacion(null);
                }else{
                    try{
                        consumoServicioXinsumo.setFechaFacturacion(sdf.parse(strFechaFacturacion));
                    }catch(ParseException pe){
                        new GIDaoException("Se generó un error parseando la fecha de facturación al actualizar el consumo por insumo con consecutivo " + intConsecutivo,pe);
                    }
                }
                
                consumoServicioXinsumo.setCuentaCobro(lgCuentaCobro);
                consumoServicioXinsumo.setSubcantidad(intSubcantidad);
                
                try{
                    consumoServicioXinsumoDAO.actualizar(consumoServicioXinsumo);
                    actualizar = Boolean.TRUE;
                }catch(GIDaoException e){
                    actualizar = Boolean.FALSE;
                    new GIDaoException("Se presentó un error actualizando el consumo por insumo con consecutivo " + intConsecutivo,e);
                }
                
            }
            
            if (strTipoConsumo.equals("consumos_tipos_usuario")){
                
                strIdTipoUsuario = request.getParameter("cbTipoUsuario");                
                intCantidadUnidad = Integer.parseInt(request.getParameter("txtCantidadConsumida"));
                intSubcantidad = Integer.parseInt(request.getParameter("txtSubcantidad"));
                strConcepto = request.getParameter("txtConcepto"); 
                strAplicaPorcentajeSancion = request.getParameter("txtAplicaPorcentajeSancion");
                
                if (strAplicaPorcentajeSancion.equals("S")){  
                    strAplicaSancion = request.getParameter("rdAplicaSancion");
                }else{
                    strAplicaSancion = "N";
                }
                                
                ConsumoServicioXTipoUsuarioDAO consumoServicioXtipoUsuarioDAO = new ConsumoServicioXTipoUsuarioDAOImpl();
                ConsumoServicioXTipoUsuario consumoServicioXtipoUsuario = new ConsumoServicioXTipoUsuario();
                
                consumoServicioXtipoUsuario.setCodigo(intConsecutivo);
                consumoServicioXtipoUsuario.setServicio(strIdServicio);
                consumoServicioXtipoUsuario.setSubservicio(strIdSubservicio);
                consumoServicioXtipoUsuario.setTipoUsuario(strIdTipoUsuario);
                
                try{
                    consumoServicioXtipoUsuario.setFechaConsumo(sdf.parse(strFechaConsumo));
                }catch(ParseException pe){
                    new GIDaoException("Se generó un error parseando la fecha de consumo al actualizar el consumo por tipo de usuario con consecutivo " + intConsecutivo,pe);
                }
                
                consumoServicioXtipoUsuario.setTipoUsuarioConsumo(strIdTipoUsuarioConsumo);
                consumoServicioXtipoUsuario.setUsuario(strIdUsuarioConsumo);
                consumoServicioXtipoUsuario.setUnidadMedida(strIdUnidadMedida);
                consumoServicioXtipoUsuario.setCantidadUnidad(intCantidadUnidad);
                consumoServicioXtipoUsuario.setSubcantidad(intSubcantidad);                
                consumoServicioXtipoUsuario.setSeFactura(strSeFactura);
                consumoServicioXtipoUsuario.setUsuarioRegistra(strIdUsuarioRegistra);                
                
                try{
                    consumoServicioXtipoUsuario.setFechaRegistra(sdf.parse(strFechaRegistro));
                }catch(ParseException pe){
                    new GIDaoException("Se generó un error parseando la fecha de registro al actualizar el consumo por tipo de usuario con consecutivo " + intConsecutivo,pe);
                }
                
                consumoServicioXtipoUsuario.setFacturado(strFacturado);                
               
                if ((strFechaFacturacion == null) || (strFechaFacturacion.equals(""))){
                    consumoServicioXtipoUsuario.setFechaFacturacion(null);
                }else{
                    try{
                        consumoServicioXtipoUsuario.setFechaFacturacion(sdf.parse(strFechaFacturacion));
                    }catch(ParseException pe){
                        new GIDaoException("Se generó un error parseando la fecha de facturación al actualizar el consumo por tipo de usuario con consecutivo " + intConsecutivo,pe);
                    }
                }                
                
                if (!(strConcepto.equals(""))){
                    strConcepto= new String(strConcepto.getBytes("iso-8859-1"),"UTF-8");   
                }
                
                consumoServicioXtipoUsuario.setConcepto(strConcepto);
                consumoServicioXtipoUsuario.setCuentaCobro(lgCuentaCobro);
                consumoServicioXtipoUsuario.setAplicarSancion(strAplicaSancion);
                        
                try{
                    consumoServicioXtipoUsuarioDAO.actualizar(consumoServicioXtipoUsuario);
                    actualizar = Boolean.TRUE;
                    
                    if (strTieneDescuento.equals("S")){
                        intCodigoDescuento = Integer.parseInt(request.getParameter("txtCodigoDescuento"));
                        ftValorDescuento = Float.parseFloat(request.getParameter("txtValorDescuento"));
                        strConceptoDescuento = request.getParameter("txtConceptoDescuento");                     
                        strSeFacturaDescuento = request.getParameter("rdSeFacturaDescuento");                                         
                        strFacturadoDescuento = request.getParameter("rdFacturadoDescuento");  
                        strFechaAplicacionDescuento = request.getParameter("txtFechaFacturacionDescuento");  
                        strFechaRegistroDescuento = request.getParameter("txtFechaDescuento");  

                        DescuentoConsumoXTipoUsuarioDAO descuentoConsumoXtipoUsuarioDAO = new DescuentoConsumoXTipoUsuarioDAOImpl();
                        DescuentoConsumo descuentoConsumo = new DescuentoConsumo();
                        
                        descuentoConsumo.setConsumo(intConsecutivo);
                        descuentoConsumo.setDescuento(ftValorDescuento);
                        descuentoConsumo.setSeFactura(strSeFacturaDescuento);
                        descuentoConsumo.setUsuarioRegistra(strIdUsuarioRegistra);                   
                        
                        try{
                            descuentoConsumo.setFechaRegistra(sdf.parse(strFechaRegistroDescuento));
                        }catch(ParseException pe){
                            new GIDaoException("Se generó un error parseando la fecha de registro del descuento al actualizar el consumo por tipo de usuario con consecutivo " + intConsecutivo,pe);
                        }
                        
                        descuentoConsumo.setAplicado(strFacturadoDescuento);
                                                
                        if ((strFechaAplicacionDescuento == null) || (strFechaAplicacionDescuento.equals(""))){
                            descuentoConsumo.setFechaAplicacion(null);
                        }else{
                            try{
                                descuentoConsumo.setFechaAplicacion(sdf.parse(strFechaAplicacionDescuento));
                            }catch(ParseException pe){
                                new GIDaoException("Se generó un error parseando la fecha de facturación del descuento al actualizar el consumo por tipo de usuario con consecutivo " + intConsecutivo,pe);
                            }
                        }    
                        
                        if (!(strConceptoDescuento.equals(""))){
                          strConceptoDescuento= new String(strConceptoDescuento.getBytes("iso-8859-1"),"UTF-8");   
                        }
                        
                        descuentoConsumo.setConcepto(strConceptoDescuento);
                        descuentoConsumo.setCodigo(intCodigoDescuento);

                        try{
                            descuentoConsumoXtipoUsuarioDAO.actualizar(descuentoConsumo);
                        }catch(GIDaoException e){                       
                            new GIDaoException("Se presentó un error actualizando el descuento del consumo por tipo de usuario con consecutivo " + intConsecutivo,e);
                        }
                    }

                    if (strTieneConsumoAdicional.equals("S")){
                        
                        intCodigoConsumoAdicional = Integer.parseInt(request.getParameter("txtCodigoConsumoAdicional"));
                        strIdItemAdicional = request.getParameter("cbItemAdicional");
                        strFechaConsumoAdicional = request.getParameter("txtFechaConsumoA");
                        LgValorUnidad = Long.parseLong(request.getParameter("txtValorConsumoAdicional"));          
                        strSeFacturaConsumoA = request.getParameter("rdSeFacturaConsumoA");
                        strFacturadoConsumoA = request.getParameter("rdFacturadoConsumoA");  
                        strFechaFacturacionConsumoA = request.getParameter("txtFechaFacturacionConsumoA");                                        
                        
                        ConsumoAdicionalXTipoUsuarioDAO consumoAdicionalXtipoUsuarioDAO = new ConsumoAdicionalXTipoUsuarioDAOImpl();
                        ConsumoAdicional consumoAdicional = new ConsumoAdicional();
                        
                        consumoAdicional.setConsumo(intConsecutivo);
                        consumoAdicional.setItemAdicional(strIdItemAdicional);
                                                
                        try{
                            consumoAdicional.setFechaConsumo(sdf.parse(strFechaConsumoAdicional));
                        }catch(ParseException pe){
                            new GIDaoException("Se generó un error parseando la fecha de consumo adicional al actualizar el consumo por tipo de usuario con consecutivo " + intConsecutivo,pe);
                        }
                        
                        consumoAdicional.setValorUnidad(LgValorUnidad);
                        consumoAdicional.setSeFactura(strSeFacturaConsumoA);
                        consumoAdicional.setUsuarioRegistra(strIdUsuarioRegistra);                        
                        
                        try{
                            consumoAdicional.setFechaRegistra(sdf.parse(strFechaRegistro));
                        }catch(ParseException pe){
                            new GIDaoException("Se generó un error parseando la fecha de registro del consumo adicional al actualizar el consumo por tipo de usuario con consecutivo " + intConsecutivo,pe);
                        }
                        
                        consumoAdicional.setFacturado(strFacturadoConsumoA);                        
                        consumoAdicional.setCodigo(intCodigoConsumoAdicional);
                        
                        if ((strFechaFacturacionConsumoA == null) || (strFechaFacturacionConsumoA.equals(""))){
                            consumoAdicional.setFechaFacturacion(null);
                        }else{
                            try{
                                consumoAdicional.setFechaFacturacion(sdf.parse(strFechaFacturacionConsumoA));
                            }catch(ParseException pe){
                                new GIDaoException("Se generó un error parseando la fecha de facturación del consumo adicional al actualizar el consumo por tipo de usuario con consecutivo " + intConsecutivo,pe);
                            }
                        }  
                        
                        try{
                            consumoAdicionalXtipoUsuarioDAO.actualizar(consumoAdicional);
                        }catch(GIDaoException e){                       
                            new GIDaoException("Se generó un error actualizando el consumo adicional del consumo por tipo de usuario con consecutivo " + intConsecutivo,e);
                        }
                                
                    }
                    
                }catch(GIDaoException e){
                    actualizar = Boolean.FALSE;
                    new GIDaoException("Se generó un error actualizando el consumo por tipo de usuario con consecutivo " + intConsecutivo,e);
                }
            }
            
            if (strTipoConsumo.equals("consumos_unidades")){
                
                bdCantidadUnidad= new BigDecimal(request.getParameter("txtCantidadConsumida"));
                strConcepto = request.getParameter("txtConcepto"); 
                
                ConsumoServicioXUnidadDAO consumoServicioXunidadDAO = new ConsumoServicioXUnidadDAOImpl();
                ConsumoServicioXUnidad consumoServicioXunidad = new ConsumoServicioXUnidad();
                
                consumoServicioXunidad.setCodigo(intConsecutivo);
                consumoServicioXunidad.setServicio(strIdServicio);
                consumoServicioXunidad.setSubservicio(strIdSubservicio);
                    
                try{
                    consumoServicioXunidad.setFechaConsumo(sdf.parse(strFechaConsumo));
                }catch(ParseException pe){
                    new GIDaoException("Se generó un error parseando la fecha de consumo al actualizar el consumo por unidad con consecutivo " + intConsecutivo,pe);
                }
                
                consumoServicioXunidad.setTipoUsuarioConsumo(strIdTipoUsuarioConsumo);
                consumoServicioXunidad.setUsuario(strIdUsuarioConsumo);
                consumoServicioXunidad.setUnidadMedida(strIdUnidadMedida);
                consumoServicioXunidad.setCantidadUnidad(bdCantidadUnidad);           
                consumoServicioXunidad.setSeFactura(strSeFactura);
                consumoServicioXunidad.setUsuarioRegistra(strIdUsuarioRegistra);                
                
                try{
                    consumoServicioXunidad.setFechaRegistra(sdf.parse(strFechaRegistro));
                }catch(ParseException pe){
                    new GIDaoException("Se generó un error parseando la fecha de registro al actualizar el consumo por unidad con consecutivo " + intConsecutivo,pe);
                }
                
                consumoServicioXunidad.setFacturado(strFacturado);                
               
                if ((strFechaFacturacion == null) || (strFechaFacturacion.equals(""))){
                    consumoServicioXunidad.setFechaFacturacion(null);
                }else{
                    try{
                        consumoServicioXunidad.setFechaFacturacion(sdf.parse(strFechaFacturacion));
                    }catch(ParseException pe){
                        new GIDaoException("Se generó un error parseando la fecha de facturación al actualizar el consumo por unidad con consecutivo " + intConsecutivo,pe);
                    }
                }                
                
                if (!(strConcepto.equals(""))){
                    strConcepto= new String(strConcepto.getBytes("iso-8859-1"),"UTF-8");   
                }
                
                consumoServicioXunidad.setConcepto(strConcepto);
                consumoServicioXunidad.setCuentaCobro(lgCuentaCobro);
                
                try{
                    consumoServicioXunidadDAO.actualizar(consumoServicioXunidad);
                    actualizar = Boolean.TRUE;    
                    
                    if (strTieneDescuento.equals("S")){
                        intCodigoDescuento = Integer.parseInt(request.getParameter("txtCodigoDescuento"));
                        ftValorDescuento = Float.parseFloat(request.getParameter("txtValorDescuento"));
                        strConceptoDescuento = request.getParameter("txtConceptoDescuento");                     
                        strSeFacturaDescuento = request.getParameter("rdSeFacturaDescuento");                                         
                        strFacturadoDescuento = request.getParameter("rdFacturadoDescuento");  
                        strFechaAplicacionDescuento = request.getParameter("txtFechaFacturacionDescuento");  
                        strFechaRegistroDescuento = request.getParameter("txtFechaDescuento");  

                        DescuentoConsumoXUnidadDAO descuentoConsumoXunidadDAO = new DescuentoConsumoXUnidadDAOImpl();
                        DescuentoConsumo descuentoConsumo = new DescuentoConsumo();
                        
                        descuentoConsumo.setConsumo(intConsecutivo);
                        descuentoConsumo.setDescuento(ftValorDescuento);
                        descuentoConsumo.setSeFactura(strSeFacturaDescuento);
                        descuentoConsumo.setUsuarioRegistra(strIdUsuarioRegistra);                   
                        
                        try{
                            descuentoConsumo.setFechaRegistra(sdf.parse(strFechaRegistroDescuento));
                        }catch(ParseException pe){
                            new GIDaoException("Se generó un error parseando la fecha de registro del descuento al actualizar el consumo por unidad con consecutivo " + intConsecutivo,pe);
                        }
                        
                        descuentoConsumo.setAplicado(strFacturadoDescuento);
                                                
                        if ((strFechaAplicacionDescuento == null) || (strFechaAplicacionDescuento.equals(""))){
                            descuentoConsumo.setFechaAplicacion(null);
                        }else{
                            try{
                                descuentoConsumo.setFechaAplicacion(sdf.parse(strFechaAplicacionDescuento));
                            }catch(ParseException pe){
                                new GIDaoException("Se generó un error parseando la fecha de facturación del descuento al actualizar el consumo por unidad con consecutivo " + intConsecutivo,pe);
                            }
                        }    
                        
                        if (!(strConceptoDescuento.equals(""))){
                          strConceptoDescuento= new String(strConceptoDescuento.getBytes("iso-8859-1"),"UTF-8");   
                        }
                        
                        descuentoConsumo.setConcepto(strConceptoDescuento);
                        descuentoConsumo.setCodigo(intCodigoDescuento);

                        try{
                            descuentoConsumoXunidadDAO.actualizar(descuentoConsumo);
                        }catch(GIDaoException e){                       
                            new GIDaoException("Se generó un error actualizando el descuento del consumo por unidad con consecutivo " + intConsecutivo,e);
                        }
                    }
                    
                    if (strTieneConsumoAdicional.equals("S")){
                        
                        intCodigoConsumoAdicional = Integer.parseInt(request.getParameter("txtCodigoConsumoAdicional"));
                        strIdItemAdicional = request.getParameter("cbItemAdicional");
                        strFechaConsumoAdicional = request.getParameter("txtFechaConsumoA");
                        LgValorUnidad = Long.parseLong(request.getParameter("txtValorConsumoAdicional"));          
                        strSeFacturaConsumoA = request.getParameter("rdSeFacturaConsumoA");
                        strFacturadoConsumoA = request.getParameter("rdFacturadoConsumoA");  
                        strFechaFacturacionConsumoA = request.getParameter("txtFechaFacturacionConsumoA");                                        
                        
                        ConsumoAdicionalXUnidadDAO consumoAdicionalXunidadDAO = new ConsumoAdicionalXUnidadDAOImpl();
                        ConsumoAdicional consumoAdicional = new ConsumoAdicional();
                        
                        consumoAdicional.setConsumo(intConsecutivo);
                        consumoAdicional.setItemAdicional(strIdItemAdicional);
                                                
                        try{
                            consumoAdicional.setFechaConsumo(sdf.parse(strFechaConsumoAdicional));
                        }catch(ParseException pe){
                            new GIDaoException("Se generó un error parseando la fecha del consumo adicional al actualizar el consumo por unidad con consecutivo " + intConsecutivo,pe);
                        }
                        
                        consumoAdicional.setValorUnidad(LgValorUnidad);
                        consumoAdicional.setSeFactura(strSeFacturaConsumoA);
                        consumoAdicional.setUsuarioRegistra(strIdUsuarioRegistra);                        
                        
                        try{
                            consumoAdicional.setFechaRegistra(sdf.parse(strFechaRegistro));
                        }catch(ParseException pe){
                            new GIDaoException("Se generó un error parseando la fecha de registro del consumo adicional al actualizar el consumo por unidad con consecutivo " + intConsecutivo,pe);
                        }
                        
                        consumoAdicional.setFacturado(strFacturadoConsumoA);                        
                        consumoAdicional.setCodigo(intCodigoConsumoAdicional);
                        
                        if ((strFechaFacturacionConsumoA == null) || (strFechaFacturacionConsumoA.equals(""))){
                            consumoAdicional.setFechaFacturacion(null);
                        }else{
                            try{
                                consumoAdicional.setFechaFacturacion(sdf.parse(strFechaFacturacionConsumoA));
                            }catch(ParseException pe){
                                new GIDaoException("Se generó un error parseando la fecha de facturación del consumo adicional al actualizar el consumo por unidad con consecutivo " + intConsecutivo,pe);
                            }
                        }  
                        
                        try{
                            consumoAdicionalXunidadDAO.actualizar(consumoAdicional);
                        }catch(GIDaoException e){                       
                            new GIDaoException("Se generó un error actualizando el consumo adicional del consumo por unidad con consecutivo " + intConsecutivo,e);
                        }
                                
                    }
                    
                }catch(GIDaoException e){
                    actualizar = Boolean.FALSE;
                    new GIDaoException("Se presentó un error actualizando el consumo por unidad con consecutivo " + intConsecutivo,e);
                }
            }
            
            if (actualizar){                                                
                request.getSession().setAttribute("mensaje", strMsgAccion);      
                out.println(strAccionCrear);
            }else{
                out.println("<script type='text/javascript'>\n");
                out.println("alert('Se produjo un error al actualizar la información del consumo en el sistema. Por favor intente de nuevo en un momento o contacte al Administrador del Sistema');");
                out.println("history.back();");
                out.println("</script>\n");
                return;
            }
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
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
