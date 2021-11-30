/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ConsumoAdicionalXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ConsumoAdicionalXUnidadDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ConsumoServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.CuentaCobroDAO;
import co.edu.udea.facturacion.dao.DescuentoConsumoXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO;
import co.edu.udea.facturacion.dao.DetalleCuentaCobroDAO;
import co.edu.udea.facturacion.dao.FacturacionServiciosDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesDAO;
import co.edu.udea.facturacion.dao.InsumoServicioDAO;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import co.edu.udea.facturacion.dao.ServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.ServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dto.CuentaCobro;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
import co.edu.udea.facturacion.dto.DetalleCuentaCobro;
import co.edu.udea.facturacion.dto.InsumoServicio;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.dto.ServicioXInsumo;
import co.edu.udea.facturacion.dto.ServicioXSubservicio;
import co.edu.udea.facturacion.dto.ServicioXSubservicioXTipoUsuarioXUnidad;
import co.edu.udea.facturacion.dto.ServicioXSubservicioXUnidad;
import co.edu.udea.facturacion.dto.ServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ServicioXUnidad;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jorge.correa
 */
public class FacturacionServiciosDAOImpl extends JDBCConnectionPool implements FacturacionServiciosDAO{
    
    private FuncionesComunesDAO funcionesComunes;
    private final String FACTURADO;
    private Date dtFechaActual;
    private FuncionesComunesConsumosDAOImpl funcionesComunesConsumo;
    private ParametroGeneralDAO parametroGeneralDAO;
    private ConsumoServicioXInsumoDAO consumoServicioInsumoDAO;
    private ConsumoServicioXTipoUsuarioDAO consumoServicioTipoUsuarioDAO;
    private ConsumoServicioXUnidadDAO consumoServicioUnidadDAO;
    private DetalleCuentaCobroDAO detalleCuentaCobroDAO;
    private ParametroGeneral parametroGeneral;
    private BigDecimal bdUnidad;
    private BigDecimal bdPorcMax;
    private SimpleDateFormat formato;
    
    public FacturacionServiciosDAOImpl(){
        this.funcionesComunes = new FuncionesComunesDAOImpl();
        this.FACTURADO = "S";
        this.dtFechaActual = this.funcionesComunes.getFechaActualDate();
        this.funcionesComunesConsumo = new FuncionesComunesConsumosDAOImpl();
        this.parametroGeneralDAO = new ParametroGeneralDAOImpl();
        this.consumoServicioInsumoDAO = new ConsumoServicioXInsumoDAOImpl();
        this.consumoServicioTipoUsuarioDAO = new ConsumoServicioXTipoUsuarioDAOImpl();
        this.consumoServicioUnidadDAO = new ConsumoServicioXUnidadDAOImpl();
        this.detalleCuentaCobroDAO = new DetalleCuentaCobroDAOImpl();
        this.bdUnidad = new BigDecimal(1);
        this.bdPorcMax = new BigDecimal(100);
        this.formato = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            this.parametroGeneral = this.parametroGeneralDAO.obtenerParametrosGenerales();
        }catch(GIDaoException e){
            new GIDaoException("Se produjo un error al obtener los parámetros generales al facturar los consumos de los servicios.", e);
        }
    }

    @Override
    public BigDecimal facturarPorInsumos(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin, Long lgCuentaCobro) throws GIDaoException {
        
        String strServicio=null, strSubservicio=null, strInsumosFijos=null, strInsumo=null, strUnidadConsumo=null, strUnidadInsumo=null, strUtilizaCostoVariable=null, strAplicaSubcantidad=null;
        BigDecimal bdSubcantidad= null;
        BigDecimal bdValor = new BigDecimal(0);
        BigDecimal bdCostoConsumo = new BigDecimal(0);
        BigDecimal bdCantidadConsumo = null;
        BigDecimal bdCostoUnitario = null;
        BigDecimal bdPresentacion = null;
        BigDecimal bdTotalSubservicio = new BigDecimal(0);
        Date dtFechaConsumo=null;
        final RoundingMode roundingMode = RoundingMode.CEILING;
                       
        List<ServicioXSubservicio> servicios_subservicios = this.consumoServicioInsumoDAO.obtenerServiciosSubserviciosConsumidos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
        List<ConsumoServicioXInsumo> consumos = null;
        ServicioXInsumoDAO servicioXInsumoDAO = new ServicioXInsumoDAOImpl();
        ServicioXInsumo servicioXInsumo = null;
        SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
        Subservicio subservicio=null;
        
       
        InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
        InsumoServicio insumoServicio = null;
        
        DetalleCuentaCobro detalleCuentaCobro = null;
        
        for(ServicioXSubservicio servicio_subservicio : servicios_subservicios){
             strServicio = servicio_subservicio.getServicio();
             strSubservicio = servicio_subservicio.getSubservicio();                                                               
               
            consumos = this.consumoServicioInsumoDAO.obtenerConsumosXServicio_Subservicio(strServicio, strSubservicio, strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
               
            for(ConsumoServicioXInsumo consumoServicio : consumos){
                subservicio = subservicioDAO.obtenerUno(strSubservicio);
                strInsumosFijos = subservicio.getInsumosFijos();             
                strInsumo = consumoServicio.getInsumo();
                strAplicaSubcantidad = subservicio.getAplicaSubcantidad();

                insumoServicio = insumoServicioDAO.obtenerUno(strInsumo);
                bdCostoUnitario = new BigDecimal(insumoServicio.getCostoUnitario());
                bdCantidadConsumo = consumoServicio.getCantidadUnidad();             
                strUnidadConsumo = consumoServicio.getUnidadMedida();
                strUnidadInsumo = insumoServicio.getUnidadMedida();
                bdCantidadConsumo = this.funcionesComunesConsumo.validarUnidadCantidad(strUnidadInsumo,strUnidadConsumo,bdCantidadConsumo);

                if (strInsumosFijos.equals("S")){                                                  
                    bdPresentacion = new BigDecimal(insumoServicio.getPresentacion());                       
                    bdCostoConsumo = bdCostoConsumo.add((bdCantidadConsumo.multiply(bdCostoUnitario)).divide(bdPresentacion, 0, roundingMode));
                    
                    if (strAplicaSubcantidad.equals("S")){
                        bdSubcantidad = new BigDecimal(consumoServicio.getSubcantidad());
                        bdCostoConsumo = bdCostoConsumo.multiply(bdSubcantidad);
                    }

                }else{                      

                    servicioXInsumo = servicioXInsumoDAO.obtenerPorServicioSubservicioInsumo(strServicio, strSubservicio, strInsumo);
                    strUtilizaCostoVariable = servicioXInsumo.getUtilizaCostoVariable();

                    if (strUtilizaCostoVariable.equals("S")){
                        bdCostoUnitario = new BigDecimal(servicioXInsumo.getCostoVariable());
                    }
                    
                    bdCostoConsumo = bdCantidadConsumo.multiply(bdCostoUnitario);                    
                }
                
                bdTotalSubservicio = bdTotalSubservicio.add(bdCostoConsumo);

                // Establecer los valores de facturación  del consumo.                   
                consumoServicio.setFacturado(this.FACTURADO);
                consumoServicio.setFechaFacturacion(this.dtFechaActual);
                consumoServicio.setCuentaCobro(lgCuentaCobro);

                try{
                    this.consumoServicioInsumoDAO.actualizar(consumoServicio);
                }catch(GIDaoException e){
                    new GIDaoException("Se generó un error actualizando los datos de facturación del consumo por insumo con código " + consumoServicio.getCodigo(),e);
                }

                subservicio = null;
                strInsumosFijos = null;
                strInsumo = null;
                insumoServicio = null;     
                bdCantidadConsumo = null;
                bdCostoUnitario = null;
                bdPresentacion = null;                  
                strUnidadConsumo = null;
                servicioXInsumo = null;
                strUtilizaCostoVariable = null;
                consumoServicio = null;
                strUnidadInsumo = null;
                strAplicaSubcantidad = null;
                bdSubcantidad = null;
                bdCostoConsumo = new BigDecimal(0);
            }              
            
            // Ingresar detalle en tabla Detalle Cuenta Cobro.
            
            detalleCuentaCobro = new DetalleCuentaCobro();
            detalleCuentaCobro.setCodigoCuentaCobro(lgCuentaCobro);
            detalleCuentaCobro.setServicio(strServicio);
            detalleCuentaCobro.setSubservicio(strSubservicio);
            detalleCuentaCobro.setTotalAPagar(bdTotalSubservicio);
            
            try{
                dtFechaConsumo = this.formato.parse(strFechaFin);
            }catch(ParseException pe){
                new GIDaoException("Se generó un error parseando la fecha del consumo de los insumos.", pe);
            }
            
            detalleCuentaCobro.setFechaConsumo(dtFechaConsumo);
            detalleCuentaCobro.setCodigoConsumo(0);
                        
            this.detalleCuentaCobroDAO.insertar(detalleCuentaCobro);
                                           
            bdValor = bdValor.add(bdTotalSubservicio);
            
            bdTotalSubservicio = new BigDecimal(0);
            strServicio = null;
            strSubservicio = null;
            consumos = null;
            detalleCuentaCobro = null;
        }
        
        bdValor = bdValor.setScale(0, roundingMode);
        
        return bdValor;
    }
    
    @Override
    public BigDecimal facturarPorTiposUsuario(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin, Long lgCuentaCobro) throws GIDaoException {
        String strServicio = null, strSubservicio = null, strTipoUsuarioC=null, strUnidadConsumo=null, strTipoUsuario=null, strUnidad=null;
        String strAplicaSancion = null;
        Integer intCantidadUnidad=null, intSubcantidad=null, intCodigoConsumo=null;
        Long lgValorUnidad;
        BigDecimal bdValor = new BigDecimal(0);
        BigDecimal bdCostoConsumo = new BigDecimal(0);
        BigDecimal bdCantidadConsumo = null;
        BigDecimal bdValorUnidad=null;
        BigDecimal bdSubcantidad= null;
        BigDecimal bdTotalSubservicio = new BigDecimal(0);
        BigDecimal bdPorcentajeSancion = null;
        Date dtFechaConsumo = null;
        final String strIdFacturacion = "TU";
        final RoundingMode roundingMode = RoundingMode.CEILING;
                
        List<ServicioXSubservicioXTipoUsuarioXUnidad> servicios_subservicios = this.consumoServicioTipoUsuarioDAO.obtenerServiciosSubserviciosConsumidos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
        
        ServicioXTipoUsuarioDAO servicioXtipousuarioDAO = new ServicioXTipoUsuarioDAOImpl();
        ServicioXTipoUsuario servicioXtipousuario = null;
        
        DetalleCuentaCobro detalleCuentaCobro = null;
        bdPorcentajeSancion = new BigDecimal(this.parametroGeneral.getPorcentajeSancion());
                   
        for(ServicioXSubservicioXTipoUsuarioXUnidad servicioXsubservicio : servicios_subservicios){
            strServicio = servicioXsubservicio.getServicio();
            strSubservicio = servicioXsubservicio.getSubservicio();
            strTipoUsuario = servicioXsubservicio.getTipoUsuario();
            strUnidad = servicioXsubservicio.getUnidadMedida();
                       
            List<ConsumoServicioXTipoUsuario> consumos = this.consumoServicioTipoUsuarioDAO.obtenerConsumosXServicio_Subservicio_TipoUsuario_Unidad(strServicio, strSubservicio, strTipoUsuario, strUnidad, strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
            
            for(ConsumoServicioXTipoUsuario consumoServicio : consumos){
                strTipoUsuarioC = consumoServicio.getTipoUsuario();
                strUnidadConsumo = consumoServicio.getUnidadMedida();
                strAplicaSancion = consumoServicio.getAplicarSancion();
                dtFechaConsumo = consumoServicio.getFechaConsumo();
                
                servicioXtipousuario = servicioXtipousuarioDAO.obtenerPorServicioSubservicioTipoUsuarioUnidad(strServicio, strSubservicio, strTipoUsuarioC, strUnidadConsumo);
                                                                                      
                intCantidadUnidad = consumoServicio.getCantidadUnidad();
                intSubcantidad = consumoServicio.getSubcantidad();
                lgValorUnidad = servicioXtipousuario.getValorUnidad();
                bdValorUnidad = new BigDecimal(lgValorUnidad);                                                                  
                bdCantidadConsumo = new BigDecimal(intCantidadUnidad);
                
                if (intSubcantidad > 0){ 
                    bdSubcantidad = new BigDecimal(intSubcantidad);        
                    bdCantidadConsumo = bdCantidadConsumo.multiply(bdSubcantidad);
                }
                
                bdCostoConsumo = bdCantidadConsumo.multiply(bdValorUnidad);
                
                if (strAplicaSancion.equals("S")){                    
                    bdCostoConsumo = (this.bdUnidad.add(bdPorcentajeSancion.divide(this.bdPorcMax, 1,roundingMode))).multiply(bdCostoConsumo);
                }
                
                // Establecer los valores de facturación  del consumo.                   
                consumoServicio.setFacturado(this.FACTURADO);
                consumoServicio.setFechaFacturacion(this.dtFechaActual);
                consumoServicio.setCuentaCobro(lgCuentaCobro);
                
                intCodigoConsumo = consumoServicio.getCodigo();                
                
                try{
                    this.consumoServicioTipoUsuarioDAO.actualizar(consumoServicio);
                }catch(GIDaoException e){
                    new GIDaoException("Se generó un error actualizando los datos de facturación del consumo por tipo de usuario con código " + intCodigoConsumo,e);
                }
                                                
                // Buscar el descuento y aplicarlo si es necesario.                                
                bdCostoConsumo = verificarDescuento(strIdFacturacion,intCodigoConsumo,bdCostoConsumo);
                
                // Buscar los consumos adicionales y sumarlos al valor actual.                
                bdCostoConsumo = verificarConsumosAdicionales(strIdFacturacion,intCodigoConsumo,bdCostoConsumo);
                               
                bdTotalSubservicio = bdTotalSubservicio.add(bdCostoConsumo);                                
                                                                        
                strTipoUsuarioC= null;
                servicioXtipousuario = null;
                strUnidadConsumo = null;
                intCantidadUnidad = null;
                bdCantidadConsumo = null;
                bdValorUnidad = null;
                lgValorUnidad = null;
                intSubcantidad = 0;
                bdSubcantidad = null;
                bdCostoConsumo = new BigDecimal(0);               
                strAplicaSancion = null;
                consumoServicio = null;
            }
            
            // Ingresar detalle en tabla Detalle Cuenta Cobro.
            
            detalleCuentaCobro = new DetalleCuentaCobro();
            detalleCuentaCobro.setCodigoCuentaCobro(lgCuentaCobro);
            detalleCuentaCobro.setServicio(strServicio);
            detalleCuentaCobro.setSubservicio(strSubservicio);
            detalleCuentaCobro.setTotalAPagar(bdTotalSubservicio);            
            detalleCuentaCobro.setFechaConsumo(dtFechaConsumo);
            detalleCuentaCobro.setCodigoConsumo(intCodigoConsumo);
                        
            this.detalleCuentaCobroDAO.insertar(detalleCuentaCobro);
            
            bdValor = bdValor.add(bdTotalSubservicio);

            bdTotalSubservicio = new BigDecimal(0);
            strServicio = null;
            strSubservicio = null;
            consumos = null;
            detalleCuentaCobro = null;
            dtFechaConsumo = null;
             intCodigoConsumo = null;
        }
        
        bdValor = bdValor.setScale(0, roundingMode);
                
        return bdValor;
    }

    @Override
    public BigDecimal facturarPorUnidades(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin, Long lgCuentaCobro) throws GIDaoException {
        String strServicio = null, strSubservicio = null, strUnidadMedida=null, strUnidadConsumo=null;
        Integer intCodigoConsumo=null;
        Long lgValorUnidad=null;
        BigDecimal bdValor = new BigDecimal(0);
        BigDecimal bdCostoConsumo = new BigDecimal(0);
        BigDecimal bdCantidadConsumo = null;
        BigDecimal bdValorUnidad = null;
        BigDecimal bdTotalSubservicio = new BigDecimal(0);
        Date dtFechaConsumo = null;
        final String strIdFacturacion = "UN";
        final RoundingMode roundingMode = RoundingMode.CEILING;
                
        List<ServicioXSubservicioXUnidad> servicios_subservicios = this.consumoServicioUnidadDAO.obtenerServiciosSubserviciosConsumidos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
        
        ServicioXUnidadDAO servicioXunidadDAO = new ServicioXUnidadDAOImpl();
        ServicioXUnidad servicioXunidad = null;
        
        DetalleCuentaCobro detalleCuentaCobro = null;
        
        for(ServicioXSubservicioXUnidad servicioXsubservicio : servicios_subservicios){
            strServicio = servicioXsubservicio.getServicio();
            strSubservicio = servicioXsubservicio.getSubservicio();
            strUnidadMedida = servicioXsubservicio.getUnidadMedida();
            
            List<ConsumoServicioXUnidad> consumos = this.consumoServicioUnidadDAO.obtenerConsumosXServicio_Subservicio_Unidad(strServicio, strSubservicio, strUnidadMedida, strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
            
            for(ConsumoServicioXUnidad consumoServicio : consumos){
                strUnidadConsumo = consumoServicio.getUnidadMedida();
                bdCantidadConsumo = consumoServicio.getCantidadUnidad();
                dtFechaConsumo = consumoServicio.getFechaConsumo();
                
                servicioXunidad = servicioXunidadDAO.obtenerPorServicioSubservicioUnidad(strServicio, strSubservicio, strUnidadConsumo);
                lgValorUnidad = servicioXunidad.getValorUnidad();
                bdValorUnidad = new BigDecimal(lgValorUnidad);
                
                bdCostoConsumo = bdCantidadConsumo.multiply(bdValorUnidad);
                
                // Establecer los valores de facturación  del consumo.                   
                consumoServicio.setFacturado(this.FACTURADO);
                consumoServicio.setFechaFacturacion(this.dtFechaActual);
                consumoServicio.setCuentaCobro(lgCuentaCobro);
                
                intCodigoConsumo = consumoServicio.getCodigo();
                
                try{
                    this.consumoServicioUnidadDAO.actualizar(consumoServicio);
                }catch(GIDaoException e){
                    new GIDaoException("Se generó un error actualizando los datos de facturación del consumo por unidad con código " + intCodigoConsumo,e);
                }
                                                
                // Buscar el descuento y aplicarlo si es necesario.                                
                bdCostoConsumo = verificarDescuento(strIdFacturacion,intCodigoConsumo,bdCostoConsumo);
                
                // Buscar los consumos adicionales y sumarlos al valor actual.                
                bdCostoConsumo = verificarConsumosAdicionales(strIdFacturacion,intCodigoConsumo,bdCostoConsumo);
                
                bdTotalSubservicio = bdTotalSubservicio.add(bdCostoConsumo);
                     
                strUnidadConsumo = null;
                servicioXunidad = null;
                lgValorUnidad = null;
                bdCantidadConsumo = null;
                bdValorUnidad = null;
                bdCostoConsumo = new BigDecimal(0);                
                consumoServicio = null;
            }
            
            // Ingresar detalle en tabla Detalle Cuenta Cobro.
            
            detalleCuentaCobro = new DetalleCuentaCobro();
            detalleCuentaCobro.setCodigoCuentaCobro(lgCuentaCobro);
            detalleCuentaCobro.setServicio(strServicio);
            detalleCuentaCobro.setSubservicio(strSubservicio);
            detalleCuentaCobro.setTotalAPagar(bdTotalSubservicio);                                  
            detalleCuentaCobro.setFechaConsumo(dtFechaConsumo);
            detalleCuentaCobro.setCodigoConsumo(intCodigoConsumo);
                        
            this.detalleCuentaCobroDAO.insertar(detalleCuentaCobro);
            
            bdValor = bdValor.add(bdTotalSubservicio);
            
            bdTotalSubservicio = null;
            strServicio = null;
            strSubservicio = null;
            strUnidadMedida = null;
            detalleCuentaCobro = null;
            dtFechaConsumo = null;            
            intCodigoConsumo = null;
        }
        
        bdValor = bdValor.setScale(0, roundingMode);
        
        return bdValor;
    }
    
    private BigDecimal verificarConsumosAdicionales(String strAccion, Integer intCodigoConsumo, BigDecimal bdValorActualConsumo) throws GIDaoException{
        BigDecimal bdNuevoValor = null;
        BigDecimal bdValorAdicional = null;
        List<ConsumoAdicional> consumosAdicionales = null;
        ConsumoAdicionalXTipoUsuarioDAO consumoAdicionalTipoUsuarioDAO = null;
        ConsumoAdicionalXUnidadDAO consumoAdicionalUnidadDAO = null;
        
        consumosAdicionales = this.funcionesComunesConsumo.obtenerConsumosAdicionales(intCodigoConsumo,strAccion);
        
         bdNuevoValor = bdValorActualConsumo;
        
        if (consumosAdicionales != null){
            if (consumosAdicionales.size()>0){
                
                consumoAdicionalTipoUsuarioDAO = new ConsumoAdicionalXTipoUsuarioDAOImpl();
                consumoAdicionalUnidadDAO = new ConsumoAdicionalXUnidadDAOImpl();
                
                for(ConsumoAdicional consumoAdicional: consumosAdicionales){
                    bdValorAdicional = new BigDecimal(consumoAdicional.getValorUnidad());                
                    bdNuevoValor = bdNuevoValor.add(bdValorAdicional);
                    
                    consumoAdicional.setFacturado(this.FACTURADO);
                    consumoAdicional.setFechaFacturacion(this.dtFechaActual);
                    
                    try{
                        if (strAccion.equals("TU")){
                            consumoAdicionalTipoUsuarioDAO.actualizar(consumoAdicional);
                        }

                        if (strAccion.equals("UN")){            
                            consumoAdicionalUnidadDAO.actualizar(consumoAdicional);
                        }
                    }catch(GIDaoException e){
                        if (strAccion.equals("TU")){
                            new GIDaoException("Se generó un error actualizando los datos de facturación del consumo adicional con código " + consumoAdicional.getCodigo() + " para el consumo por tipo de usuario con código " + intCodigoConsumo,e);
                        }

                        if (strAccion.equals("UN")){
                            new GIDaoException("Se generó un error actualizando los datos de facturación del consumo adicional con código " + consumoAdicional.getCodigo() + " para el consumo por unidad con código " + intCodigoConsumo,e);
                        }
                    }

                    bdValorAdicional = null;
                }            
            }
        }
        
        return bdNuevoValor;
    }
    
    private BigDecimal verificarDescuento(String strAccion, Integer intCodigoConsumo, BigDecimal bdValorActualConsumo) throws GIDaoException{
        BigDecimal bdNuevoValor = null;
        BigDecimal bdValorDescuento = null;        
        final RoundingMode roundingMode = RoundingMode.CEILING;       
        DescuentoConsumo descuentoConsumo = null;
        DescuentoConsumoXTipoUsuarioDAO descuentoConsumoTipoUsuarioDAO = null;
        DescuentoConsumoXUnidadDAO descuentoConsumoUnidadDAO = null;        
               
        descuentoConsumo = this.funcionesComunesConsumo.obtenerDescuentoConsumo(intCodigoConsumo, strAccion);
                
        if (descuentoConsumo != null){
            bdValorDescuento = new BigDecimal(descuentoConsumo.getDescuento());
            bdNuevoValor = (this.bdUnidad.subtract(bdValorDescuento.divide(this.bdPorcMax, 1,roundingMode))).multiply(bdValorActualConsumo);
                                   
            descuentoConsumo.setAplicado(this.FACTURADO);
            descuentoConsumo.setFechaAplicacion(this.dtFechaActual);
            
            try{
                if (strAccion.equals("TU")){
                    descuentoConsumoTipoUsuarioDAO = new DescuentoConsumoXTipoUsuarioDAOImpl();
                    descuentoConsumoTipoUsuarioDAO.actualizar(descuentoConsumo);
                }
                
                if (strAccion.equals("UN")){            
                    descuentoConsumoUnidadDAO = new DescuentoConsumoXUnidadDAOImpl();
                    descuentoConsumoUnidadDAO.actualizar(descuentoConsumo);
                }
            }catch(GIDaoException e){
                if (strAccion.equals("TU")){
                    new GIDaoException("Se generó un error actualizando los datos de aplicación del descuento con código " + descuentoConsumo.getCodigo() + " para el consumo por tipo de usuario con código " + intCodigoConsumo,e);
                }
                
                if (strAccion.equals("UN")){
                    new GIDaoException("Se generó un error actualizando los datos de aplicación del descuento con código " + descuentoConsumo.getCodigo() + " para el consumo por unidad con código " + intCodigoConsumo,e);
                }
            }
            
        }else{           
            bdNuevoValor = bdValorActualConsumo;
        }
        
        return bdNuevoValor;
    }

    @Override
    public Long facturarConsumos(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin, String strUsuarioCreacion) throws GIDaoException {
                
        Long lgCodigoCuentaCobro = null;
        String strNumeroSoporte = null;
        CuentaCobro cuentaCobro = null;
        CuentaCobroDAO cuentaCobroDAO = new CuentaCobroDAOImpl();        
        Integer intNumeroDiasLimite = null;
        Date dtFechaLimitePago = null;
        Calendar fechaActual = null;
        BigDecimal bgTotalInsumos = null, bgTotalTipoUsuario = null, bgTotalUnidades = null, bgTotalAPagar = null;              
        final RoundingMode roundingMode = RoundingMode.CEILING;       
                
        if (this.parametroGeneral != null){
            intNumeroDiasLimite = this.parametroGeneral.getNumeroDiasLimitePago();
        }else{
            intNumeroDiasLimite = 0;
        }
                
        fechaActual = Calendar.getInstance();
        fechaActual.setTime(this.dtFechaActual);
        dtFechaLimitePago = this.funcionesComunes.incrementarDiasHabiles(fechaActual, intNumeroDiasLimite).getTime();
        
        strNumeroSoporte = "-";
        cuentaCobro = new CuentaCobro();                    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        cuentaCobro.setTipoUsuarioConsumo(strTipoUsuarioConsumo);
        cuentaCobro.setUsuarioConsumo(strUsuario);
        cuentaCobro.setFechaCreacion(this.dtFechaActual);
        cuentaCobro.setUsuarioCreacion(strUsuarioCreacion);
        cuentaCobro.setFechaLimitePago(dtFechaLimitePago);
        
        try{
            cuentaCobro.setFechaInicioPeriodo(sdf.parse(strFechaInicio));            
        }catch(ParseException pe){
            new GIDaoException("Se generó un error parseando la fecha de inicio del periodo de la cuenta de cobro.", pe);
        }

        try{
            cuentaCobro.setFechaFinPeriodo(sdf.parse(strFechaFin));                    
        }catch(ParseException pe){
            new GIDaoException("Se generó un error parseando la fecha de inicio del periodo de la cuenta de cobro.", pe);
        }
                
        cuentaCobro.setNumeroSoporte(strNumeroSoporte);
        cuentaCobro.setFechaSoporte(null);
        cuentaCobro.setValorSoporte(null);
        cuentaCobro.setAcuerdoCobro("-");
        cuentaCobro.setDependenciaBeneficiaria("-");
        cuentaCobro.setCentroCostosBeneficiario("-");
        cuentaCobro.setDependenciaPagadora("-");
        cuentaCobro.setCentroCostosPagador("-");
        cuentaCobro.setNombreOrdenadorGasto("-");
        cuentaCobro.setCargoOrdenadorGasto("-");
        cuentaCobro.setObservacion("-");
        
        try{
            lgCodigoCuentaCobro = cuentaCobroDAO.insertar(cuentaCobro);                                   
        }catch(GIDaoException e){
            lgCodigoCuentaCobro = null;
            new GIDaoException("Se generó un error al insertar la nueva cuenta de cobro.", e);
        }            
        
        if (lgCodigoCuentaCobro != null){
            
                bgTotalAPagar = new BigDecimal(0);
            
                bgTotalInsumos = facturarPorInsumos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin, lgCodigoCuentaCobro);
                bgTotalTipoUsuario = facturarPorTiposUsuario(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin, lgCodigoCuentaCobro);
                bgTotalUnidades = facturarPorUnidades(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin, lgCodigoCuentaCobro);
                bgTotalAPagar = ((bgTotalAPagar.add(bgTotalInsumos)).add(bgTotalTipoUsuario)).add(bgTotalUnidades);
                bgTotalAPagar = bgTotalAPagar.setScale(0, roundingMode);
                
                if (bgTotalAPagar.compareTo(new BigDecimal(0)) == 0){                    
                    cuentaCobroDAO.eliminar(lgCodigoCuentaCobro);
                    lgCodigoCuentaCobro = null;
                }
                
        }else{
            new GIDaoException("No se pudo obtener el consecutivo de la cuenta de cobro generada.");
        }
        
        return lgCodigoCuentaCobro;        
    }        

    @Override
    public List<UsuarioConsumidor> obtenerUsuariosConsumidores(String strFechaInicio, String strFechaFin) throws GIDaoException {

        List<UsuarioConsumidor> usuariosConsumidoresInsumos;
        List<UsuarioConsumidor> usuariosConsumidoresTiposUsuario;
        List<UsuarioConsumidor> usuariosConsumidoresUnidades;
        List<UsuarioConsumidor> listaCombinada = new ArrayList<UsuarioConsumidor>();
        List<UsuarioConsumidor> usuariosConsumidores = new ArrayList<UsuarioConsumidor>();
                      
        usuariosConsumidoresInsumos = this.consumoServicioInsumoDAO.obtenerUsuariosConsumidores(strFechaInicio, strFechaFin);
        usuariosConsumidoresTiposUsuario = this.consumoServicioTipoUsuarioDAO.obtenerUsuariosConsumidores(strFechaInicio, strFechaFin);
        usuariosConsumidoresUnidades = this.consumoServicioUnidadDAO.obtenerUsuariosConsumidores(strFechaInicio, strFechaFin);
        
        if (usuariosConsumidoresInsumos.size() > 0){
            listaCombinada.addAll(usuariosConsumidoresInsumos);
        }
        
        if (usuariosConsumidoresTiposUsuario.size() > 0){
            listaCombinada.addAll(usuariosConsumidoresTiposUsuario);
        }
        
        if (usuariosConsumidoresUnidades.size() > 0){
            listaCombinada.addAll(usuariosConsumidoresUnidades);            
        }                                    
        
        if (listaCombinada.size() > 0){            
            Set<UsuarioConsumidor> listaUnicaOrdenada = new HashSet<UsuarioConsumidor>(listaCombinada);
            usuariosConsumidores.addAll(listaUnicaOrdenada);            
        }
        
        return usuariosConsumidores;        
    }    
}
