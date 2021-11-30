/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.servlet;

import co.edu.udea.facturacion.dao.InsumoServicioDAO;
import co.edu.udea.facturacion.dao.ItemAdicionalDAO;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import co.edu.udea.facturacion.dao.RolUsuarioDAO;
import co.edu.udea.facturacion.dao.RolXUsuarioDAO;
import co.edu.udea.facturacion.dao.ServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.ServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.TipoFacturacionDAO;
import co.edu.udea.facturacion.dao.TipoUsuarioDAO;
import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dao.impl.InsumoServicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ItemAdicionalDAOImpl;
import co.edu.udea.facturacion.dao.impl.ParametroGeneralDAOImpl;
import co.edu.udea.facturacion.dao.impl.RolUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.RolXUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXInsumoDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXTipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.ServicioXUnidadDAOImpl;
import co.edu.udea.facturacion.dao.impl.SubservicioDAOImpl;
import co.edu.udea.facturacion.dao.impl.TipoFacturacionDAOImpl;
import co.edu.udea.facturacion.dao.impl.TipoUsuarioDAOImpl;
import co.edu.udea.facturacion.dao.impl.UnidadMedidaDAOImpl;
import co.edu.udea.facturacion.dto.InsumoServicio;
import co.edu.udea.facturacion.dto.ItemAdicional;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.dto.RolUsuario;
import co.edu.udea.facturacion.dto.RolXUsuario;
import co.edu.udea.facturacion.dto.ServicioXInsumo;
import co.edu.udea.facturacion.dto.ServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ServicioXUnidad;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dto.TipoFacturacion;
import co.edu.udea.facturacion.dto.TipoUsuario;
import co.edu.udea.facturacion.dto.UnidadMedida;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George
 */
public class RegistroAdministrativo extends HttpServlet {

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
           
            String strAccion = null, strForm = null, strRedireccion = "", strMsgRedireccion = null;
            
            strAccion = request.getParameter("txtAccion");
            strForm = request.getParameter("txtForm");
            
            strRedireccion = strRedireccion + "<script type='text/javascript'>\n";
            strRedireccion = strRedireccion + "opener.frmRefresh.btnRefresh.click();\n";
            strRedireccion = strRedireccion + "location.href='notificacion.jsp';\n";
            strRedireccion = strRedireccion + "</script>\n";
            
            if (strForm.equals("frmUnidadMedida")){
                String strCodigo = request.getParameter("txtCodigo");
                String strNombre = request.getParameter("txtNombre");
                
                strNombre= new String(strNombre.getBytes("iso-8859-1"),"UTF-8");  
                
                UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
                UnidadMedida unidadMedida = new UnidadMedida();
                unidadMedida.setCodigo(strCodigo);
                unidadMedida.setNombre(strNombre);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        unidadMedidaDAO.insertar(unidadMedida);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando la unidad de medida con código " + strCodigo, e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        unidadMedidaDAO.actualizar(unidadMedida);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando la unidad de medida con código " + strCodigo, e);
                    }
                }                        
            }
            
            if (strForm.equals("frmTipoUsuario")){
                String strCodigo = request.getParameter("txtCodigo");
                String strNombre = request.getParameter("txtNombre");
                
                strNombre= new String(strNombre.getBytes("iso-8859-1"),"UTF-8");
                
                TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAOImpl();
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setCodigo(strCodigo);
                tipoUsuario.setNombre(strNombre);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        tipoUsuarioDAO.insertar(tipoUsuario);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el tipo de usuario con código " + strCodigo, e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        tipoUsuarioDAO.actualizar(tipoUsuario);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el tipo de usuario con código " + strCodigo, e);
                    }
                }                        
            }
            
            if (strForm.equals("frmTipoFacturacion")){
                String strCodigo = request.getParameter("txtCodigo");
                String strNombre = request.getParameter("txtNombre");
                
                strNombre= new String(strNombre.getBytes("iso-8859-1"),"UTF-8");
                
                TipoFacturacionDAO tipoFacturacionDAO = new TipoFacturacionDAOImpl();
                TipoFacturacion tipoFacturacion = new TipoFacturacion();
                tipoFacturacion.setCodigo(strCodigo);
                tipoFacturacion.setNombre(strNombre);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        tipoFacturacionDAO.insertar(tipoFacturacion);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el tipo de facturación con código " + strCodigo, e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        tipoFacturacionDAO.actualizar(tipoFacturacion);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el tipo de facturación con código " + strCodigo, e);
                    }
                }   
            }
            
            if (strForm.equals("frmItemAdicional")){
                String strCodigo = request.getParameter("txtCodigo");
                String strNombre = request.getParameter("txtNombre");
                
                strNombre = new String(strNombre.getBytes("iso-8859-1"),"UTF-8");
                
                ItemAdicionalDAO itemAdicionalDAO = new ItemAdicionalDAOImpl();
                ItemAdicional itemAdicional = new ItemAdicional();
                itemAdicional.setCodigo(strCodigo);
                itemAdicional.setNombre(strNombre);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        itemAdicionalDAO.insertar(itemAdicional);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el ítem adicional con código " + strCodigo, e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        itemAdicionalDAO.actualizar(itemAdicional);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el ítem adicional con código " + strCodigo, e);
                    }
                }   
            }
            
            if (strForm.equals("frmInsumoServicio")){
                String strCodigo = request.getParameter("txtCodigo");
                String strNombre = request.getParameter("txtNombre");
                String strUnidadMedida = request.getParameter("cbUnidadMedida");
                String strPresentacion = request.getParameter("txtPresentacion");
                BigDecimal bdCostoUnitario = new BigDecimal(request.getParameter("txtCostoUnitario"));
                Integer intCantidadDisponible = Integer.parseInt(request.getParameter("txtCantidadDisponible"));
                
                strNombre = new String(strNombre.getBytes("iso-8859-1"),"UTF-8");
                
                if (bdCostoUnitario == null){
                    bdCostoUnitario = new BigDecimal(0);
                }
                
                if (intCantidadDisponible == null){
                    intCantidadDisponible = 0;
                }
                
                InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
                InsumoServicio insumoServicio = new InsumoServicio();  
                insumoServicio.setCodigo(strCodigo);
                insumoServicio.setNombre(strNombre);
                insumoServicio.setUnidadMedida(strUnidadMedida);
                insumoServicio.setPresentacion(strPresentacion);
                insumoServicio.setCostoUnitario(bdCostoUnitario.longValue());
                insumoServicio.setCantidadDisponible(intCantidadDisponible);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        insumoServicioDAO.insertar(insumoServicio);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el insumo de servicio con código " + strCodigo, e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        insumoServicioDAO.actualizar(insumoServicio);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el insumo de servicio con código " + strCodigo, e);
                    }
                }   
            }
            
            if (strForm.equals("frmRolUsuario")){
                String strCodigo = request.getParameter("txtCodigo");
                String strNombre = request.getParameter("txtNombre");
                String strSeAutentica = request.getParameter("rdSeAutentica");
                
                strNombre= new String(strNombre.getBytes("iso-8859-1"),"UTF-8");
                
                RolUsuarioDAO rolUsuarioDAO = new RolUsuarioDAOImpl();
                RolUsuario rolUsuario = new RolUsuario();
                rolUsuario.setCodigo(strCodigo);
                rolUsuario.setNombre(strNombre);
                rolUsuario.setSeAutentica(strSeAutentica);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        rolUsuarioDAO.insertar(rolUsuario);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el rol de usuario con código " + strCodigo, e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        rolUsuarioDAO.actualizar(rolUsuario);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el rol de usuario con código " + strCodigo, e);
                    }
                }   
            }
            
            if (strForm.equals("frmRolXUsuario")){
                String strRol= request.getParameter("cbRol");
                String strUsuario = request.getParameter("cbUsuario");
                
                strRol = new String(strRol.getBytes("iso-8859-1"),"UTF-8");
                strUsuario = new String(strUsuario.getBytes("iso-8859-1"),"UTF-8");
                
                RolXUsuarioDAO rolXUsuarioDAO = new RolXUsuarioDAOImpl();
                RolXUsuario rolXUsuario = new RolXUsuario();
                rolXUsuario.setRol(strRol);
                rolXUsuario.setPersona(strUsuario);
   
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        rolXUsuarioDAO.insertar(rolXUsuario);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el rol por usuario con código " + strRol + " - " + strUsuario, e);
                    }
                }                                
            }
            
            if (strForm.equals("frmGeneral")){
                String strCodigo = request.getParameter("txtForm");
                String strTituloApp = request.getParameter("txtTituloApp");
                String strSubtituloApp = request.getParameter("txtSubtituloApp");
                String strToken = request.getParameter("txtToken");
                Integer intNroRegistrosMostrar = Integer.parseInt(request.getParameter("txtNroRegistrosMostrar"));
                String strNomServidor = request.getParameter("txtNomServidor");
                Integer intNroPuerto = Integer.parseInt(request.getParameter("txtNroPuerto"));
                String strNomUsuario = request.getParameter("txtNomUsuario");
                String strContrasena = request.getParameter("txtContrasena");
                Integer intNroDiasFechaLimite = Integer.parseInt(request.getParameter("txtNroDiasFechaLimite"));
                Float ftPorcSancionImpl = Float.parseFloat(request.getParameter("txtPorcSancionImpl"));
                
                strTituloApp = new String(strTituloApp.getBytes("iso-8859-1"),"UTF-8");
                strSubtituloApp = new String(strSubtituloApp.getBytes("iso-8859-1"),"UTF-8");
                
                ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
                ParametroGeneral parametroGeneral = new ParametroGeneral();
                parametroGeneral.setCodigo(strCodigo);
                parametroGeneral.setTituloApp(strTituloApp);
                parametroGeneral.setSubtituloApp(strSubtituloApp);
                parametroGeneral.setTokenServiciosWeb(strToken);
                parametroGeneral.setNumeroRegistrosXPagina(intNroRegistrosMostrar);
                parametroGeneral.setNombreServidor(strNomServidor);
                parametroGeneral.setNumeroPuerto(intNroPuerto);
                parametroGeneral.setUsuarioConexion(strNomUsuario);
                parametroGeneral.setClaveConexion(strContrasena);
                parametroGeneral.setNumeroDiasLimitePago(intNroDiasFechaLimite);
                parametroGeneral.setPorcentajeSancion(ftPorcSancionImpl);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        parametroGeneralDAO.insertarParametrosGenerales(parametroGeneral);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando los parámetros generales", e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        parametroGeneralDAO.actualizarParametrosGenerales(parametroGeneral);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando los parámetros generales", e);
                    }
                }
            }
            
            if (strForm.equals("frmSubservicio")){
                String strCodigo = request.getParameter("txtCodigo");
                String strNombre = request.getParameter("txtNombre");
                String strTipoFacturacion = request.getParameter("cbTipoFacturacion");
                String strResponsable = request.getParameter("cbResponsable");
                String strServicio = request.getParameter("cbServicio");
                String strInsumosFijos= request.getParameter("rdInsumosFijos");
                String strAplicaSubcantidad = request.getParameter("rdAplicaSubcantidad");
                String strEtiquetaSubcantidad = request.getParameter("txtEtiquetaSubcantidad");
                String strPorcSancion = request.getParameter("rdPorcSancion");
                
                strNombre = new String(strNombre.getBytes("iso-8859-1"),"UTF-8");
                
                if ((strEtiquetaSubcantidad == null) || (strEtiquetaSubcantidad.equals(""))){
                    strEtiquetaSubcantidad = "-";
                }else{
                    strEtiquetaSubcantidad = new String(strEtiquetaSubcantidad.getBytes("iso-8859-1"),"UTF-8");
                }                
                                
                SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
                Subservicio subservicio = new Subservicio();
                
                subservicio.setCodigo(strCodigo);
                subservicio.setNombre(strNombre);
                subservicio.setTipoFacturacion(strTipoFacturacion);
                subservicio.setResponsable(strResponsable);
                subservicio.setServicioPadre(strServicio);
                subservicio.setInsumosFijos(strInsumosFijos);
                subservicio.setAplicaSubcantidad(strAplicaSubcantidad);
                subservicio.setEtiquetaSubcantidad(strEtiquetaSubcantidad);
                subservicio.setAplicaPorcentajeSancion(strPorcSancion);
                                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        subservicioDAO.insertar(subservicio);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el subservicio con código " + strCodigo, e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        subservicioDAO.actualizar(subservicio);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el subservicio con código " + strCodigo, e);
                    }
                }   
            }
            
            if (strForm.equals("frmServicioXUnidad")){
                String strServicio = request.getParameter("cbServicio");
                String strSubservicio = request.getParameter("cbSubservicio");
                String strUnidadMedida = request.getParameter("cbUnidadMedida");
                Long lgValorUnidad = Long.parseLong(request.getParameter("txtValorUnidad"));                              
                                
                ServicioXUnidadDAO servicioXUnidadDAO = new ServicioXUnidadDAOImpl();
                ServicioXUnidad servicioXUnidad = new ServicioXUnidad();
                servicioXUnidad.setServicio(strServicio);
                servicioXUnidad.setSubservicio(strSubservicio);
                servicioXUnidad.setUnidadMedida(strUnidadMedida);
                servicioXUnidad.setValorUnidad(lgValorUnidad);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        servicioXUnidadDAO.insertar(servicioXUnidad);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el servicio por unidad", e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    Integer intCodigo = Integer.parseInt(request.getParameter("txtCodigo"));
                    servicioXUnidad.setCodigo(intCodigo);
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        servicioXUnidadDAO.actualizar(servicioXUnidad);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el servicio por unidad", e);
                    }
                }   
            }
            
            if (strForm.equals("frmServicioXTipoUsuario")){
                String strServicio = request.getParameter("cbServicio");
                String strSubservicio = request.getParameter("cbSubservicio");
                String strTipoUsuario  = request.getParameter("cbTipoUsuario");
                String strUnidadMedida = request.getParameter("cbUnidadMedida");
                Long lgValorUnidad = Long.parseLong(request.getParameter("txtValorUnidad"));                              
                                
                ServicioXTipoUsuarioDAO servicioXTipoUsuarioDAO = new ServicioXTipoUsuarioDAOImpl();
                ServicioXTipoUsuario servicioXTipoUsuario = new ServicioXTipoUsuario();
                servicioXTipoUsuario.setServicio(strServicio);
                servicioXTipoUsuario.setSubservicio(strSubservicio);
                servicioXTipoUsuario.setTipoUsuario(strTipoUsuario);
                servicioXTipoUsuario.setUnidadMedida(strUnidadMedida);
                servicioXTipoUsuario.setValorUnidad(lgValorUnidad);
                
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        servicioXTipoUsuarioDAO.insertar(servicioXTipoUsuario);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el servicio por tipo de usuario", e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    Integer intCodigo = Integer.parseInt(request.getParameter("txtCodigo"));
                    servicioXTipoUsuario.setCodigo(intCodigo);
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        servicioXTipoUsuarioDAO.actualizar(servicioXTipoUsuario);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el servicio por tipo de usuario", e);
                    }
                }   
            }
            
            if (strForm.equals("frmServicioXInsumo")){
                String strServicio = request.getParameter("cbServicio");
                String strSubservicio = request.getParameter("cbSubservicio");
                String strInsumo = request.getParameter("cbInsumo");
                String strCobroTransversal = request.getParameter("rdCobroTransversal");
                Integer intCantidadCobroTransversal=null;
                BigDecimal bdCantidadFija=null;
                String strUnidadCantidadFija=null;
                Long lgCostoVariable=null;
                
                if (strCobroTransversal.equals("S")){
                    intCantidadCobroTransversal= Integer.parseInt(request.getParameter("txtCantidadCobroTransversal"));
                }else{
                    intCantidadCobroTransversal= 0;
                }
                
                String strCantidadFija = request.getParameter("txtCantidadFija");
                
                if ((!(strCantidadFija.equals(""))) && (strCantidadFija.equals("0"))){
                    bdCantidadFija = new BigDecimal(strCantidadFija);
                    strUnidadCantidadFija = request.getParameter("cbUnidadCantidadFija");
                }else{
                    bdCantidadFija = new BigDecimal(0);
                    strUnidadCantidadFija = "PD";
                }
                
                String strUtilizaCostoVariable = request.getParameter("rdCostoVariable");
                
                if (strUtilizaCostoVariable.equals("S")){
                    lgCostoVariable= Long.parseLong(request.getParameter("txtCostoVariable"));
                }else{
                    lgCostoVariable = Long.parseLong("0");
                }
                
                String strSeCobraAlUsuario = request.getParameter("rdSeCobraAlUsuario");
                                                    
                ServicioXInsumoDAO servicioXInsumoDAO = new ServicioXInsumoDAOImpl();
                ServicioXInsumo servicioXInsumo = new ServicioXInsumo();
                servicioXInsumo.setServicio(strServicio);
                servicioXInsumo.setSubservicio(strSubservicio);
                servicioXInsumo.setInsumo(strInsumo);
                servicioXInsumo.setCobroTransversal(strCobroTransversal);
                servicioXInsumo.setCantidadCobroTransversal(intCantidadCobroTransversal);
                servicioXInsumo.setCantidadFija(bdCantidadFija);
                servicioXInsumo.setUnidadCantidadFija(strUnidadCantidadFija);
                servicioXInsumo.setUtilizaCostoVariable(strUtilizaCostoVariable);
                servicioXInsumo.setCostoVariable(lgCostoVariable);
                servicioXInsumo.setSeCobraAlUsuario(strSeCobraAlUsuario);
                       
                if (strAccion.equals("C")){
                    
                    strMsgRedireccion = "El nuevo registro se ingresó correctamente!.";
                    
                    try{
                        servicioXInsumoDAO.insertar(servicioXInsumo);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error insertando el servicio por insumo", e);
                    }
                }
                
                if (strAccion.equals("V")){
                    
                    Integer intCodigo = Integer.parseInt(request.getParameter("txtCodigo"));
                    servicioXInsumo.setCodigo(intCodigo);
                    
                    strMsgRedireccion = "El registro se actualizó correctamente!.";
                    
                    try{
                        servicioXInsumoDAO.actualizar(servicioXInsumo);
                        
                        request.getSession().setAttribute("mensaje", strMsgRedireccion);      
                        out.println(strRedireccion);
                    }catch(GIDaoException e){
                        new GIDaoException("Se generó un error actualizando el servicio por insumo", e);
                    }
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
