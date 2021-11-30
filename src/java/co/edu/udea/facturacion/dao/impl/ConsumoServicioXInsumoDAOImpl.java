/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ConsumoServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dto.ParametroBusquedaRegistro;
import co.edu.udea.facturacion.dto.ServicioXSubservicio;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public class ConsumoServicioXInsumoDAOImpl extends JDBCConnectionPool implements ConsumoServicioXInsumoDAO {
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos ORDER BY intCodigo";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos ORDER BY txtServicio,txtSubservicio,txtInsumo,txtUsuario,dtFechaConsumo LIMIT ?,?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE intCodigo = ?";
    private static final String OBTENER_POR_RANGO_FECHAS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE (dtFechaConsumo BETWEEN ? AND ?)";
    private static final String OBTENER_POR_SERVICIO = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtServicio = ?";
    private static final String OBTENER_POR_SERVICIO_RANGO_FECHAS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtServicio = ? and (dtFechaConsumo BETWEEN ? AND ?)";
    private static final String OBTENER_POR_USUARIO= "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtTipoUsuarioConsumo=? and txtUsuario = ?";
    private static final String OBTENER_POR_USUARIO_RANGO_FECHAS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtTipoUsuarioConsumo=? and txtUsuario = ? and (dtFechaConsumo BETWEEN ? AND ?)";
    private static final String OBTENER_SERVICIOS_SUBSERVICIOS_CONSUMIDOS = "SELECT sv.txtCodigo, s.txtCodigo, sv.txtModoIngresoConsumos FROM facturacion_servicios.tbl_consumos_servicios_x_insumos csi, facturacion_servicios.tbl_subservicios s, users.users_servicios sv WHERE (csi.txtServicio = sv.txtCodigo) and (csi.txtSubservicio = s.txtCodigo) and csi.txtTipoUsuarioConsumo = ? and csi.txtUsuario = ? and (csi.dtFechaConsumo BETWEEN ? and ?) and csi.txtSeFactura=? and csi.txtFacturado=? GROUP BY sv.txtCodigo, s.txtCodigo";
    private static final String OBTENER_CONSUMOS_SERVICIOS= "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtServicio = ? and txtTipoUsuarioConsumo = ? and txtUsuario = ? and (dtFechaConsumo BETWEEN ? AND ?) and txtSeFactura=? and txtFacturado=?";
    private static final String OBTENER_CONSUMOS_SERVICIOS_SUBSERVICIOS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtServicio = ? and txtSubservicio = ? and txtTipoUsuarioConsumo = ? and txtUsuario = ? and (dtFechaConsumo BETWEEN ? AND ?) and txtSeFactura=? and txtFacturado=?";
    private static final String OBTENER_CONSUMOS_SERVICIO_SUBSERVICIO_CUENTACOBRO = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtServicio = ? and txtSubservicio = ? and lgCodigoCuentaCobro = ? ORDER BY txtServicio, txtSubservicio";
    private static final String OBTENER_USUARIOS_CONSUMIDORES = "SELECT txtTipoUsuarioConsumo, txtUsuario FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE (dtFechaConsumo BETWEEN ? AND ?) AND txtSeFactura = ? AND txtFacturado = ? GROUP BY txtTipoUsuarioConsumo, txtUsuario ORDER BY txtTipoUsuarioConsumo, txtUsuario";
    private static final String VALIDAR_INSERCION_GRUPAL = "SELECT intCantidadUnidad FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtServicio = ? AND txtSubservicio = ? AND txtInsumo = ? AND dtFechaConsumo = ? AND txtTipoUsuarioConsumo = ? and txtUsuario = ?";
    private static final String VALIDAR_INSERCION_INDIVIDUAL = "SELECT count(*) as TOTAL FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE txtServicio = ? AND txtSubservicio = ? AND dtFechaConsumo = ? AND txtTipoUsuarioConsumo = ? and txtUsuario = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_consumos_servicios_x_insumos(txtServicio,txtSubservicio,txtInsumo,dtFechaConsumo,txtTipoUsuarioConsumo,txtUsuario,txtUnidadMedida,intCantidadUnidad,txtSeFactura,txtUsuarioRegistra,dtFechaRegistra,txtFacturado,dtFechaFacturacion,lgCodigoCuentaCobro,intSubcantidad) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_consumos_servicios_x_insumos set txtServicio=?,txtSubservicio=?,txtInsumo=?,dtFechaConsumo=?,txtTipoUsuarioConsumo=?,txtUsuario=?,txtUnidadMedida=?,intCantidadUnidad=?,txtSeFactura=?,txtUsuarioRegistra=?,dtFechaRegistra=?,txtFacturado=?,dtFechaFacturacion=?,lgCodigoCuentaCobro=?, intSubcantidad=? WHERE intCodigo=?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_consumos_servicios_x_insumos WHERE intCodigo = ?";
    private static final String COLUMNA_CODIGO = "intCodigo";
    private static final String COLUMNA_SERVICIO = "txtServicio";    
    private static final String COLUMNA_SUBSERVICIO = "txtSubservicio";   
    private static final String COLUMNA_INSUMO = "txtInsumo";   
    private static final String COLUMNA_FECHA_CONSUMO = "dtFechaConsumo";   
    private static final String COLUMNA_TIPO_USUARIO_CONSUMO = "txtTipoUsuarioConsumo";
    private static final String COLUMNA_USUARIO = "txtUsuario"; 
    private static final String COLUMNA_UNIDAD_MEDIDA= "txtUnidadMedida";   
    private static final String COLUMNA_CANTIDAD_UNIDAD = "intCantidadUnidad";   
    private static final String COLUMNA_SEFACTURA = "txtSeFactura";   
    private static final String COLUMNA_USUARIO_REGISTRA = "txtUsuarioRegistra";   
    private static final String COLUMNA_FECHA_REGISTRA = "dtFechaRegistra";   
    private static final String COLUMNA_FACTURADO = "txtFacturado";   
    private static final String COLUMNA_FECHA_FACTURACION = "dtFechaFacturacion";                
    private static final String COLUMNA_CUENTA_COBRO = "lgCodigoCuentaCobro";
    private static final String COLUMNA_SUBCANTIDAD = "intSubcantidad";
    private static final String COLUMNA_TOTAL = "TOTAL";
    
    @Override
    public List<ConsumoServicioXInsumo> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }
    
    @Override
    public List<ConsumoServicioXInsumo> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }
    
    @Override
    public ConsumoServicioXInsumo obtenerUno(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setInt(1, intCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));                
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumo;
    }
    
    @Override
    public void insertar(ConsumoServicioXInsumo consumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaConsumo = null;
        java.sql.Date dtFechaRegistra = null;
        java.sql.Date dtFechaFacturacion = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            
            ps.setString(1,consumo.getServicio());
            ps.setString(2,consumo.getSubservicio());
            ps.setString(3,consumo.getInsumo());
            dtFechaConsumo = new java.sql.Date(consumo.getFechaConsumo().getTime());
            ps.setDate(4,dtFechaConsumo);
            ps.setString(5, consumo.getTipoUsuarioConsumo());
            ps.setString(6,consumo.getUsuario());
            ps.setString(7,consumo.getUnidadMedida());
            ps.setBigDecimal(8,consumo.getCantidadUnidad());                      
            ps.setString(9,consumo.getSeFactura());
            ps.setString(10,consumo.getUsuarioRegistra());         
            dtFechaRegistra = new java.sql.Date(consumo.getFechaRegistra().getTime());
            ps.setDate(11,dtFechaRegistra);
            ps.setString(12,consumo.getFacturado());
            if (consumo.getFechaFacturacion() != null){
                dtFechaFacturacion = new java.sql.Date(consumo.getFechaFacturacion().getTime());
            }else{
                dtFechaFacturacion = null;
            } 
            ps.setDate(13,dtFechaFacturacion);               
            ps.setLong(14, consumo.getCuentaCobro());
            ps.setInt(15, consumo.getSubcantidad());
            
            ps.executeUpdate();                 
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{                
                    
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
    }

    @Override
    public void actualizar(ConsumoServicioXInsumo consumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaConsumo = null;
        java.sql.Date dtFechaRegistra = null;
        java.sql.Date dtFechaFacturacion = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);
            
            ps.setString(1,consumo.getServicio());
            ps.setString(2,consumo.getSubservicio());
            ps.setString(3,consumo.getInsumo());
            dtFechaConsumo = new java.sql.Date(consumo.getFechaConsumo().getTime());
            ps.setDate(4,dtFechaConsumo);
            ps.setString(5, consumo.getTipoUsuarioConsumo());
            ps.setString(6,consumo.getUsuario());
            ps.setString(7,consumo.getUnidadMedida());
            ps.setBigDecimal(8,consumo.getCantidadUnidad());                      
            ps.setString(9,consumo.getSeFactura());
            ps.setString(10,consumo.getUsuarioRegistra());         
            dtFechaRegistra = new java.sql.Date(consumo.getFechaRegistra().getTime());
            ps.setDate(11,dtFechaRegistra);
            ps.setString(12,consumo.getFacturado());
            if (consumo.getFechaFacturacion() != null){
                dtFechaFacturacion = new java.sql.Date(consumo.getFechaFacturacion().getTime());
            }else{
                dtFechaFacturacion = null;
            }
            ps.setDate(13,dtFechaFacturacion);               
            ps.setLong(14, consumo.getCuentaCobro());
            ps.setInt(15, consumo.getSubcantidad());
            ps.setInt(16,consumo.getCodigo());
            
            ps.executeUpdate();                 
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{                
                    
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
    }

    @Override
    public void eliminar(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ELIMINAR);      
            ps.setInt(1,intCodigo);            
            ps.executeUpdate();                 
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{                
                    
                if (ps != null){
                    ps.close();
                }
                 
               if (con != null){
                    con.close();
               }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerPorRangoFechas(String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_RANGO_FECHAS);
            ps.setString(1, strFechaInicio);
            ps.setString(2, strFechaFin);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerPorServicio(String strServicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO);
            ps.setString(1, strServicio);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerPorServicioYRangoFechas(String strServicio, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO_RANGO_FECHAS);
            ps.setString(1, strServicio);
            ps.setString(2, strFechaInicio);
            ps.setString(3, strFechaFin);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerPorUsuario(String strTipoUsuario, String strUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_USUARIO);
            ps.setString(1, strTipoUsuario);
            ps.setString(2, strUsuario);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerPorUsuarioYRangoFechas(String strTipoUsuario, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_USUARIO_RANGO_FECHAS);
            ps.setString(1, strTipoUsuario);
            ps.setString(2, strUsuario);
            ps.setString(3, strFechaInicio);
            ps.setString(4, strFechaFin);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }     

    @Override
    public List<ServicioXSubservicio> obtenerServiciosSubserviciosConsumidos(String strTipoUsuario, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXSubservicio> servicios_subservicios = new ArrayList<ServicioXSubservicio>();
        ServicioXSubservicio servicio_subservicio = null;
        final String SE_FACTURA = "S";
        final String FACTURADO = "N";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_SERVICIOS_SUBSERVICIOS_CONSUMIDOS);
            ps.setString(1, strTipoUsuario);
            ps.setString(2, strUsuario);
            ps.setString(3, strFechaInicio);
            ps.setString(4, strFechaFin);
            ps.setString(5, SE_FACTURA);
            ps.setString(6, FACTURADO);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicio_subservicio = new ServicioXSubservicio();                   
                    servicio_subservicio.setServicio(rs.getString(1));
                    servicio_subservicio.setSubservicio(rs.getString(2));
                    servicio_subservicio.setModoIngresoConsumo(rs.getString(3));
                    servicios_subservicios.add(servicio_subservicio);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return servicios_subservicios;
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerConsumosXServicio(String strServicio, String strTipoUsuario, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        final String SE_FACTURA = "S";
        final String FACTURADO = "N";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_CONSUMOS_SERVICIOS);
            ps.setString(1, strServicio);
            ps.setString(2, strTipoUsuario);
            ps.setString(3, strUsuario);
            ps.setString(4, strFechaInicio);
            ps.setString(5, strFechaFin);
            ps.setString(6, SE_FACTURA);
            ps.setString(7, FACTURADO);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerConsumosXServicio_Subservicio(String strServicio, String strSubservicio, String strTipoUsuario, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        final String SE_FACTURA = "S";
        final String FACTURADO = "N";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_CONSUMOS_SERVICIOS_SUBSERVICIOS);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            ps.setString(3, strTipoUsuario);
            ps.setString(4, strUsuario);
            ps.setString(5, strFechaInicio);
            ps.setString(6, strFechaFin);
            ps.setString(7, SE_FACTURA);
            ps.setString(8, FACTURADO);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }    

    @Override
    public BigDecimal validarInsercionGrupal(String strIdServicio, String strIdSubservicio, String strIdInsumo, Date dtFechaConsumo, String strTipoUsuario, String strIdUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BigDecimal bgCantidadUnidad=null;
                
        try{
            con = getConexion();
            ps = con.prepareCall(VALIDAR_INSERCION_GRUPAL);
            ps.setString(1, strIdServicio);
            ps.setString(2, strIdSubservicio);
            ps.setString(3, strIdInsumo);
            java.sql.Date date = new java.sql.Date(dtFechaConsumo.getTime());
            ps.setDate(4, date);
            ps.setString(5, strTipoUsuario);
            ps.setString(6, strIdUsuario);
            
            rs = ps.executeQuery();
                        
            if (rs.next()){               
                bgCantidadUnidad = new BigDecimal(rs.getString(COLUMNA_CANTIDAD_UNIDAD));
            }else{
                bgCantidadUnidad = new BigDecimal(0);
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return bgCantidadUnidad;
    }

    @Override
    public Integer validarInsercionIndividual(String strIdServicio, String strIdSubservicio, Date dtFechaConsumo, String strTipoUsuario, String strIdUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer intCantidadRegistros=0;
                
        try{
            con = getConexion();
            ps = con.prepareCall(VALIDAR_INSERCION_INDIVIDUAL);
            ps.setString(1, strIdServicio);
            ps.setString(2, strIdSubservicio);      
            java.sql.Date date = new java.sql.Date(dtFechaConsumo.getTime());
            ps.setDate(3, date);
            ps.setString(4, strTipoUsuario);
            ps.setString(5, strIdUsuario);
            
            rs = ps.executeQuery();
                        
            if (rs.next()){               
                intCantidadRegistros = Integer.parseInt(rs.getString(COLUMNA_TOTAL));
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return intCantidadRegistros;
    }

    @Override
    public List<UsuarioConsumidor> obtenerUsuariosConsumidores(String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UsuarioConsumidor> usuariosConsumidores = new ArrayList<UsuarioConsumidor>();
        UsuarioConsumidor usuarioConsumidor = null;
        final String SE_FACTURA = "S";
        final String FACTURADO = "N";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_USUARIOS_CONSUMIDORES);
            ps.setString(1, strFechaInicio);
            ps.setString(2, strFechaFin);
            ps.setString(3, SE_FACTURA);
            ps.setString(4, FACTURADO);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    usuarioConsumidor = new UsuarioConsumidor();                   
                    usuarioConsumidor.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    usuarioConsumidor.setUsuario(rs.getString(COLUMNA_USUARIO));
                    usuariosConsumidores.add(usuarioConsumidor);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return usuariosConsumidores;
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerTodosBusqueda(ParametroBusquedaRegistro parametroBusquedaConsumo) throws GIDaoException {
        
        String OBTENER_TODOS_BUSQUEDA=null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        ConsumoServicioXInsumo consumo = null;
        
        OBTENER_TODOS_BUSQUEDA = construirConsultaBusquedaConsumos(parametroBusquedaConsumo);
                             
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_BUSQUEDA);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }                
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;  
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerTodosBusquedaPorPaginas(ParametroBusquedaRegistro parametroBusquedaConsumo, Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        String OBTENER_TODOS_BUSQUEDA_POR_PAGINAS =null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        ConsumoServicioXInsumo consumo = null;
        
        OBTENER_TODOS_BUSQUEDA_POR_PAGINAS = construirConsultaBusquedaConsumos(parametroBusquedaConsumo);
        OBTENER_TODOS_BUSQUEDA_POR_PAGINAS += " LIMIT ?,?";
                                     
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_BUSQUEDA_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }                
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;  
    }
    
    private String construirConsultaBusquedaConsumos(ParametroBusquedaRegistro parametroBusquedaConsumo){
        
        String strServicioB="-1", strSubservicioB="-1", strTipoUsuarioB="-1", strUsuarioB="-1", strFechaInicioB="", strFechaFinB="", strConsulta = null;        
        strConsulta = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_insumos ";
        
        strServicioB = parametroBusquedaConsumo.getServicio();
        strSubservicioB = parametroBusquedaConsumo.getSubservicio();
        strTipoUsuarioB = parametroBusquedaConsumo.getTipoUsuario();
        strUsuarioB = parametroBusquedaConsumo.getUsuario();
        strFechaInicioB = parametroBusquedaConsumo.getFechaInicio();
        strFechaFinB = parametroBusquedaConsumo.getFechaFin();
        
        if (!(strServicioB.equals("-1")) || !(strSubservicioB.equals("-1")) || !(strTipoUsuarioB.equals("-1")) || !(strUsuarioB.equals("-1")) || !(strFechaInicioB.equals("")) || !(strFechaFinB.equals(""))){
            strConsulta += "where ";
            
            if (!(strServicioB.equals("-1"))){
                strConsulta += COLUMNA_SERVICIO + " = '" + strServicioB +"' AND ";                
            }
            
            if (!(strSubservicioB.equals("-1"))){
                strConsulta += COLUMNA_SUBSERVICIO + " = '" + strSubservicioB + "' AND ";                
            }
            
            if (!(strTipoUsuarioB.equals("-1"))){
                strConsulta += COLUMNA_TIPO_USUARIO_CONSUMO + " = '" + strTipoUsuarioB + "' AND ";                
            }
            
            if (!(strUsuarioB.equals("-1"))){
                strConsulta += COLUMNA_USUARIO + " = '" + strUsuarioB + "' AND ";                
            }
            
           if (!(strFechaInicioB.equals("")) && !(strFechaFinB.equals(""))){
                strConsulta += "(" + COLUMNA_FECHA_CONSUMO + " BETWEEN '" + strFechaInicioB +"' AND '" + strFechaFinB + "') AND ";                         
            }
           
           strConsulta = strConsulta.substring(0, strConsulta.length()-4); 
        }        
        
       strConsulta += "ORDER BY " + COLUMNA_SERVICIO + ", "+ COLUMNA_SUBSERVICIO + ", " + COLUMNA_TIPO_USUARIO_CONSUMO + ", " + COLUMNA_USUARIO + ", " + COLUMNA_FECHA_CONSUMO;
        
        return strConsulta;
    }

    @Override
    public List<ConsumoServicioXInsumo> obtenerConsumosPorServicioSubservicioCuentaCobro(String strServicio, String strSubservicio, Long lgCodigoCuentaCobro) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXInsumo> consumos = new ArrayList<ConsumoServicioXInsumo>();
        ConsumoServicioXInsumo consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_CONSUMOS_SERVICIO_SUBSERVICIO_CUENTACOBRO);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            ps.setLong(3, lgCodigoCuentaCobro);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXInsumo();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getBigDecimal(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumos.add(consumo);
                }
            }
            
        }catch(SQLException e){
            throw new GIDaoException(e);
        }finally{
            try{
                
                if (rs != null){
                    rs.close();
                }
                
                 if (ps != null){
                    ps.close();
                }
                 
                  if (con != null){
                    con.close();
                }
                  
            }catch(SQLException e){
                throw new GIDaoException(e);
            }
        }
        
        return consumos;
    }
    
}
