/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ConsumoAdicionalXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.ConsumoAdicionalXUnidadDAO;
import co.edu.udea.facturacion.dao.DependenciaDAO;
import co.edu.udea.facturacion.dao.DescuentoConsumoXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO;
import co.edu.udea.facturacion.dao.FuncionesComunesConsumosDAO;
import co.edu.udea.facturacion.dao.InsumoServicioDAO;
import co.edu.udea.facturacion.dao.ServicioDAO;
import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.TerceroDAO;
import co.edu.udea.facturacion.dao.TipoUsuarioConsumoDAO;
import co.edu.udea.facturacion.dao.TipoUsuarioDAO;
import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO;
import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.dto.Dependencia;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
import co.edu.udea.facturacion.dto.InsumoServicio;
import co.edu.udea.facturacion.dto.Servicio;
import co.edu.udea.facturacion.dto.Subservicio;
import co.edu.udea.facturacion.dto.Tercero;
import co.edu.udea.facturacion.dto.TipoUsuario;
import co.edu.udea.facturacion.dto.TipoUsuarioConsumo;
import co.edu.udea.facturacion.dto.UnidadMedida;
import co.edu.udea.facturacion.dto.UsuarioConsumoSIU;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public class FuncionesComunesConsumosDAOImpl implements FuncionesComunesConsumosDAO{

    @Override
    public String obtenerServicio(String strIdServicio) {
        String strServicio = "";
        
        ServicioDAO servicioDAO = new ServicioDAOImpl();
        
        try{
            Servicio servicio = servicioDAO.obtenerUno(strIdServicio);
            strServicio = servicio.getNombre();
        }catch(GIDaoException e){
            new GIDaoException("No se pudo recuperar la información del servicio.",e);
        }
        
        return strServicio;
    }

    @Override
    public String obtenerSubservicio(String strIdSubservicio) {
        String strSubservicio = null;
        
        SubservicioDAO subservicioDAO = new SubservicioDAOImpl();
 
        try{
            Subservicio subservicio = subservicioDAO.obtenerUno(strIdSubservicio);
            strSubservicio = subservicio.getNombre();
        }catch(GIDaoException e){
            new GIDaoException("No se pudo recuperar la información del subservicio.",e);
        }
        
        return strSubservicio;
    }

    @Override
    public String obtenerInsumo(String strIdInsumo) {
        String strInsumo = "";
        
        InsumoServicioDAO insumoServicioDAO = new InsumoServicioDAOImpl();
        
        try{
            InsumoServicio insumoServicio = insumoServicioDAO.obtenerUno(strIdInsumo);
            strInsumo = insumoServicio.getNombre();
        }catch(GIDaoException e){
            new GIDaoException("No se pudo recuperar la información del insumo.",e);
        }
        
        return strInsumo;
    }

    @Override
    public String obtenerUnidadMedida(String strIdUnidad) {
        String strUnidad = "";
        
        UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
        
        try{
            
            if (!(strIdUnidad.equals("PD"))){
                UnidadMedida unidadMedida = unidadMedidaDAO.obtenerUna(strIdUnidad);
                strUnidad = unidadMedida.getNombre();
            }else{
                strUnidad = "";
            }
        }catch(GIDaoException e){
            new GIDaoException("No se pudo recuperar la información de la unidad de medida.",e);
        }
        
        return strUnidad;
    }

    @Override
    public String obtenerTipoUsuario(String strIdTipoUsuario) {
        String strTipoUsuario = "";
        
        TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAOImpl();
        
        try{
            TipoUsuario tipoUsuario = tipoUsuarioDAO.obtenerUno(strIdTipoUsuario);
            strTipoUsuario = tipoUsuario.getNombre();
        }catch(GIDaoException e){
            new GIDaoException("No se pudo recuperar la información del tipo de usuario.",e);
        }
        
        return strTipoUsuario;
    }

    @Override
    public String obtenerUsuario(String strId, String strTipoUsuario) {
        String strUsuario = "";
        
        if (strTipoUsuario.equals("UI")){
            UsuarioConsumoSIUDAO usuarioConsumoSIUDAO = new UsuarioConsumoSIUDAOImpl();
            try{
                UsuarioConsumoSIU usuarioConsumoSIU = usuarioConsumoSIUDAO.obtenerUno(strId);
                strUsuario = usuarioConsumoSIU.getNombre();
            }catch(GIDaoException e){
                new GIDaoException("No se pudo recuperar la información del usuario SIU con código" + strId,e);
            }
        }
        
        if (strTipoUsuario.equals("UE")){
            TerceroDAO terceroDAO = new TerceroDAOImpl();
            List<Tercero> terceros = null;
            
            try{
                terceros = terceroDAO.obtenerTerceros(strId, "", "NACIONAL");
                
                if ((terceros != null) && (terceros.size() > 0)){
                    strUsuario = terceros.get(0).getNombrePila();
                }
            }catch(GIDaoException e){
                new GIDaoException("No se pudo recuperar la información del usuario externo con código" + strId,e);
            }
        }
        
        if (strTipoUsuario.equals("UUNS")){
            DependenciaDAO dependenciaDAO = new DependenciaDAOImpl();
            List<Dependencia> dependencias = null;
            
            try{                
                dependencias = dependenciaDAO.obtenerNombreDependencia(strId);
                
                if ((dependencias != null) && (dependencias.size() > 0)){
                    strUsuario = dependencias.get(0).getNombre();
                }
            }catch(GIDaoException e){
                new GIDaoException("No se pudo recuperar la información del usuario UdeA no SIU con código" + strId,e);
            }
        }
        
        return strUsuario;
    }

    @Override
    public String obtenerSiNo(String strId) {
        String strRespuesta = "";
        
        if (strId.equals("S")){
            strRespuesta = "Si";
        }else{
            strRespuesta = "No";
        }
        
        return strRespuesta;
    }

    @Override
    public String obtenerTipoUsuarioConsumo(String strIdTipoUsuarioConsumo) {
        String strTipoUsuarioConsumo = "";
        
        TipoUsuarioConsumoDAO tipoUsuarioConsumoDAO = new TipoUsuarioConsumoDAOImpl();
        
        try{
            TipoUsuarioConsumo tipoUsuario = tipoUsuarioConsumoDAO.obtenerUno(strIdTipoUsuarioConsumo);
            strTipoUsuarioConsumo = tipoUsuario.getNombre();
        }catch(GIDaoException e){
            new GIDaoException("No se pudo recuperar la información del tipo de usuario.",e);
        }
        
        return strTipoUsuarioConsumo;
    }

    @Override
    public DescuentoConsumo obtenerDescuentoConsumo(Integer intCodigoConsumo, String strTipoConsumo) {
        DescuentoConsumo descuentoConsumo = null;
        DescuentoConsumoXTipoUsuarioDAO descuentoConsumoTipoUsuarioDAO = null;
        DescuentoConsumoXUnidadDAO descuentoConsumoUnidadDAO = null;
        
        if (strTipoConsumo.equals("TU")){                    
            descuentoConsumoTipoUsuarioDAO = new DescuentoConsumoXTipoUsuarioDAOImpl();
            
            try{
                descuentoConsumo = descuentoConsumoTipoUsuarioDAO.obtenerPorConsumo(intCodigoConsumo);
            }catch(GIDaoException e){
                new GIDaoException("Se produjo un error al obtener el descuento del consumo por tipo de usuario con código " + intCodigoConsumo, e);
            }
        }
        
        if (strTipoConsumo.equals("UN")){            
            descuentoConsumoUnidadDAO = new DescuentoConsumoXUnidadDAOImpl();
            try{
                descuentoConsumo = descuentoConsumoUnidadDAO.obtenerPorConsumo(intCodigoConsumo);
            }catch(GIDaoException e){
                new GIDaoException("Se produjo un error al obtener el descuento del consumo por unidad con código " + intCodigoConsumo, e);
            }
        }
        
        return descuentoConsumo;
    }

    @Override
    public List<ConsumoAdicional> obtenerConsumosAdicionales(Integer intCodigoConsumo, String strTipoConsumo) {
        List<ConsumoAdicional> consumosAdicionales = null;
        ConsumoAdicionalXTipoUsuarioDAO consumoAdicionalTipoUsuarioDAO = null;
        ConsumoAdicionalXUnidadDAO consumoAdicionalUnidadDAO = null;
                
        if (strTipoConsumo.equals("TU")){
            consumoAdicionalTipoUsuarioDAO = new ConsumoAdicionalXTipoUsuarioDAOImpl();
            try{
                consumosAdicionales = consumoAdicionalTipoUsuarioDAO.obtenerPorConsumo(intCodigoConsumo);
            }catch(GIDaoException e){
                new GIDaoException("Se produjo un error al obtener los consumos adicionales del consumo por tipo de usuario con código " + intCodigoConsumo, e);
            }
        }
        
        if (strTipoConsumo.equals("UN")){
            consumoAdicionalUnidadDAO = new ConsumoAdicionalXUnidadDAOImpl();
            try{
                consumosAdicionales = consumoAdicionalUnidadDAO.obtenerPorConsumo(intCodigoConsumo);
            }catch(GIDaoException e){
                new GIDaoException("Se produjo un error al obtener los consumos adicionales del consumo por unidad con código " + intCodigoConsumo, e);
            }
        }
        
        return consumosAdicionales;
    }

    @Override
    public BigDecimal validarUnidadCantidad(String strUnidadOrigen, String strUnidadConsumo, BigDecimal bdCantidadUnidad) {
        BigDecimal bdCantidadNueva=null; 
        final BigDecimal HORAS_DIA = new BigDecimal(24);
        final BigDecimal MINUTOS_HORA = new BigDecimal(60);
        final BigDecimal SEGUNDOS_MINUTO = new BigDecimal(60);
        final BigDecimal GRAMOS_KILOGRAMO = new BigDecimal(1000);
        final BigDecimal MILILITROS_LITRO = new BigDecimal(1000);
        final RoundingMode roundingMode = RoundingMode.CEILING;
                        
        if (strUnidadOrigen.equals(strUnidadConsumo)){
            bdCantidadNueva = bdCantidadUnidad;
        }else{
                                                
            if (strUnidadConsumo.equals("DIA")){
               if (strUnidadOrigen.equals("HS")){
                   bdCantidadNueva = bdCantidadUnidad.multiply(HORAS_DIA);
               }
               
               if (strUnidadOrigen.equals("MINS")){
                   bdCantidadNueva = bdCantidadUnidad.multiply(HORAS_DIA.multiply(MINUTOS_HORA));
               }
               
               if (strUnidadOrigen.equals("SEGS")){
                   bdCantidadNueva = bdCantidadUnidad.multiply(HORAS_DIA.multiply(MINUTOS_HORA.multiply(SEGUNDOS_MINUTO)));
               }
            }
            
            if (strUnidadConsumo.equals("HS")){
               if (strUnidadOrigen.equals("DIA")){
                   bdCantidadNueva = bdCantidadUnidad.divide(HORAS_DIA,1,roundingMode);
               }
               
               if (strUnidadOrigen.equals("MINS")){
                   bdCantidadNueva = bdCantidadUnidad.multiply(MINUTOS_HORA);
               }
               
               if (strUnidadOrigen.equals("SEGS")){
                   bdCantidadNueva = bdCantidadUnidad.multiply(MINUTOS_HORA.multiply(SEGUNDOS_MINUTO));
               }
            }
            
            if (strUnidadConsumo.equals("MINS")){
               if (strUnidadOrigen.equals("DIA")){
                   bdCantidadNueva = (bdCantidadUnidad.divide(MINUTOS_HORA,1,roundingMode)).divide(HORAS_DIA,1, roundingMode);
               }
               
               if (strUnidadOrigen.equals("HS")){
                   bdCantidadNueva = bdCantidadUnidad.divide(MINUTOS_HORA,1,roundingMode);
               }
               
               if (strUnidadOrigen.equals("SEGS")){
                   bdCantidadNueva = bdCantidadUnidad.multiply(SEGUNDOS_MINUTO);
               }
            }
            
            if (strUnidadConsumo.equals("SEGS")){
               if (strUnidadOrigen.equals("DIA")){
                   bdCantidadNueva = ((bdCantidadUnidad.divide(SEGUNDOS_MINUTO,1,roundingMode)).divide(MINUTOS_HORA,1, roundingMode)).divide(HORAS_DIA, 1, roundingMode);
               }
               
               if (strUnidadOrigen.equals("HS")){
                   bdCantidadNueva = (bdCantidadUnidad.divide(SEGUNDOS_MINUTO,1,roundingMode)).divide(MINUTOS_HORA,1, roundingMode);
               }
               
               if (strUnidadOrigen.equals("MINS")){
                   bdCantidadNueva = bdCantidadUnidad.divide(SEGUNDOS_MINUTO,1, roundingMode);
               }
            }
            
            if (strUnidadConsumo.equals("KG")){
                if (strUnidadOrigen.equals("GR")){
                    bdCantidadNueva = bdCantidadUnidad.multiply(GRAMOS_KILOGRAMO);
                }
            }
            
            if (strUnidadConsumo.equals("GR")){
                if (strUnidadOrigen.equals("KG")){
                    bdCantidadNueva = bdCantidadUnidad.divide(GRAMOS_KILOGRAMO,1, roundingMode);
                }
            }
            
            if (strUnidadConsumo.equals("LT")){
                if (strUnidadOrigen.equals("ML")){
                    bdCantidadNueva = bdCantidadUnidad.multiply(MILILITROS_LITRO);
                }
            }
            
            if (strUnidadConsumo.equals("ML")){
                if (strUnidadOrigen.equals("LT")){
                    bdCantidadNueva = bdCantidadUnidad.divide(MILILITROS_LITRO,1, roundingMode);
                }
            }
        }       
        
        return bdCantidadNueva;
    }

    @Override
    public String validarNulo(Object obj) {
        
        String strSalida = "";
        
        if (obj == null){
            strSalida = "-";
        }
        
        return strSalida;
                
    }
    
}
