/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ConsumoServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ParametroBusquedaRegistro;
import co.edu.udea.facturacion.dto.ServicioXSubservicioXTipoUsuarioXUnidad;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public class ConsumoServicioXTipoUsuarioDAOImpl extends JDBCConnectionPool implements ConsumoServicioXTipoUsuarioDAO {
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios ORDER BY intCodigo";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios ORDER BY txtServicio,txtSubservicio,txtTipoUsuario,txtUsuario,dtFechaConsumo  LIMIT ?,?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE intCodigo = ?";
    private static final String OBTENER_POR_RANGO_FECHAS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE (dtFechaConsumo BETWEEN ? AND ?)";
    private static final String OBTENER_POR_SERVICIO = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE txtServicio = ?";
    private static final String OBTENER_POR_SERVICIO_RANGO_FECHAS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE txtServicio = ? and (dtFechaConsumo BETWEEN ? AND ?)";
    private static final String OBTENER_POR_USUARIO= "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE txtTipoUsuarioConsumo=? and txtUsuario = ?";
    private static final String OBTENER_POR_USUARIO_RANGO_FECHAS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE txtTipoUsuarioConsumo=? and txtUsuario = ? and (dtFechaConsumo BETWEEN ? AND ?)";
    private static final String OBTENER_SERVICIOS_SUBSERVICIOS_CONSUMIDOS = "SELECT txtServicio, txtSubservicio, txtTipoUsuario, txtUnidadMedida FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE txtTipoUsuarioConsumo=? and txtUsuario = ? and (dtFechaConsumo BETWEEN ? and ?) and txtSeFactura = ? and txtFacturado = ? GROUP BY txtServicio, txtSubservicio, txtTipoUsuario, txtUnidadMedida";
    private static final String OBTENER_CONSUMOS_SERVICIOS_SUBSERVICIOS = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE txtServicio = ? and txtSubservicio = ? and txtTipoUsuario = ? and txtUnidadMedida = ? and txtTipoUsuarioConsumo=? and txtUsuario = ? and (dtFechaConsumo BETWEEN ? AND ?) and txtSeFactura=? and txtFacturado=?";
    private static final String OBTENER_CONSUMOS_SERVICIO_SUBSERVICIO_CUENTACOBRO = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE txtServicio = ? and txtSubservicio = ? and lgCodigoCuentaCobro = ? and intCodigo = ? ORDER BY txtServicio, txtSubservicio";
    private static final String OBTENER_USUARIOS_CONSUMIDORES = "SELECT txtTipoUsuarioConsumo, txtUsuario FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE (dtFechaConsumo BETWEEN ? AND ?) AND txtSeFactura = ? AND txtFacturado = ? GROUP BY txtTipoUsuarioConsumo, txtUsuario ORDER BY txtTipoUsuarioConsumo, txtUsuario";
    private static final String VALIDAR_INSERCION = "SELECT count(*) as TOTAL FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE txtServicio = ? AND txtSubservicio = ? AND txtTipoUsuario = ? AND dtFechaConsumo = ? AND txtTipoUsuarioConsumo=? and txtUsuario = ? AND txtUnidadMedida = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios(txtServicio,txtSubservicio,txtTipoUsuario,dtFechaConsumo,txtTipoUsuarioConsumo,txtUsuario,txtUnidadMedida,intCantidadUnidad,intSubcantidad,txtSeFactura,txtUsuarioRegistra,dtFechaRegistra,txtFacturado,dtFechaFacturacion,txtConcepto,lgCodigoCuentaCobro,txtAplicarSancion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios set txtServicio=?,txtSubservicio=?,txtTipoUsuario=?,dtFechaConsumo=?,txtTipoUsuarioConsumo=?,txtUsuario=?,txtUnidadMedida=?,intCantidadUnidad=?,intSubcantidad=?,txtSeFactura=?,txtUsuarioRegistra=?,dtFechaRegistra=?,txtFacturado=?,dtFechaFacturacion=?,txtConcepto=?,lgCodigoCuentaCobro=?, txtAplicarSancion=? WHERE intCodigo=?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios WHERE intCodigo = ?";
    private static final String COLUMNA_CODIGO = "intCodigo";
    private static final String COLUMNA_SERVICIO = "txtServicio";    
    private static final String COLUMNA_SUBSERVICIO = "txtSubservicio";    
    private static final String COLUMNA_TIPO_USUARIO = "txtTipoUsuario";   
    private static final String COLUMNA_FECHA_CONSUMO = "dtFechaConsumo";   
    private static final String COLUMNA_TIPO_USUARIO_CONSUMO = "txtTipoUsuarioConsumo";
    private static final String COLUMNA_USUARIO = "txtUsuario"; 
    private static final String COLUMNA_UNIDAD_MEDIDA= "txtUnidadMedida";   
    private static final String COLUMNA_CANTIDAD_UNIDAD = "intCantidadUnidad";   
    private static final String COLUMNA_SUBCANTIDAD = "intSubcantidad";   
    private static final String COLUMNA_SEFACTURA = "txtSeFactura";   
    private static final String COLUMNA_USUARIO_REGISTRA = "txtUsuarioRegistra";   
    private static final String COLUMNA_FECHA_REGISTRA = "dtFechaRegistra";   
    private static final String COLUMNA_FACTURADO = "txtFacturado";   
    private static final String COLUMNA_FECHA_FACTURACION = "dtFechaFacturacion";       
    private static final String COLUMNA_CONCEPTO = "txtConcepto";   
    private static final String COLUMNA_CUENTA_COBRO = "lgCodigoCuentaCobro";
    private static final String COLUMNA_APLICAR_SANCION = "txtAplicarSancion";
    private static final String COLUMNA_TOTAL = "TOTAL";

    @Override
    public List<ConsumoServicioXTipoUsuario> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public List<ConsumoServicioXTipoUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public ConsumoServicioXTipoUsuario obtenerUno(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setInt(1,intCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));               
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public Integer insertar(ConsumoServicioXTipoUsuario consumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaConsumo = null;
        java.sql.Date dtFechaRegistra = null;
        java.sql.Date dtFechaFacturacion = null;
        Integer intNroConsecutivo = null;
        ResultSet rs =null;
        
        try{
            con = getConexion();
            ps = con.prepareStatement(INSERTAR,ps.RETURN_GENERATED_KEYS);
            
            ps.setString(1,consumo.getServicio());
            ps.setString(2,consumo.getSubservicio());
            ps.setString(3,consumo.getTipoUsuario());
            dtFechaConsumo = new java.sql.Date(consumo.getFechaConsumo().getTime());
            ps.setDate(4,dtFechaConsumo);
            ps.setString(5, consumo.getTipoUsuarioConsumo());
            ps.setString(6,consumo.getUsuario());
            ps.setString(7,consumo.getUnidadMedida());
            ps.setInt(8,consumo.getCantidadUnidad());                 
            ps.setInt(9, consumo.getSubcantidad());
            ps.setString(10,consumo.getSeFactura());
            ps.setString(11,consumo.getUsuarioRegistra());         
            dtFechaRegistra = new java.sql.Date(consumo.getFechaRegistra().getTime());
            ps.setDate(12,dtFechaRegistra);
            ps.setString(13,consumo.getFacturado());
            if (consumo.getFechaFacturacion() != null){
                dtFechaFacturacion = new java.sql.Date(consumo.getFechaFacturacion().getTime());
            }else{
                dtFechaFacturacion = null;
            }
            ps.setDate(14,dtFechaFacturacion);             
            ps.setString(15, consumo.getConcepto());
            ps.setLong(16, consumo.getCuentaCobro());
            ps.setString(17, consumo.getAplicarSancion());
            
            ps.executeUpdate();                 
            
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
               intNroConsecutivo = rs.getInt(1);               
            }
            
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
        
        return intNroConsecutivo;
    }

    @Override
    public void actualizar(ConsumoServicioXTipoUsuario consumo) throws GIDaoException {
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
            ps.setString(3,consumo.getTipoUsuario());
            dtFechaConsumo = new java.sql.Date(consumo.getFechaConsumo().getTime());
            ps.setDate(4,dtFechaConsumo);
            ps.setString(5, consumo.getTipoUsuarioConsumo());
            ps.setString(6,consumo.getUsuario());
            ps.setString(7,consumo.getUnidadMedida());
            ps.setInt(8,consumo.getCantidadUnidad());                 
            ps.setInt(9, consumo.getSubcantidad());
            ps.setString(10,consumo.getSeFactura());
            ps.setString(11,consumo.getUsuarioRegistra());         
            dtFechaRegistra = new java.sql.Date(consumo.getFechaRegistra().getTime());
            ps.setDate(12,dtFechaRegistra);
            ps.setString(13,consumo.getFacturado());
            if (consumo.getFechaFacturacion() != null){
                dtFechaFacturacion = new java.sql.Date(consumo.getFechaFacturacion().getTime());
            }else{
                dtFechaFacturacion = null;
            }
            ps.setDate(14,dtFechaFacturacion);             
            ps.setString(15, consumo.getConcepto());
            ps.setLong(16, consumo.getCuentaCobro());
            ps.setString(17, consumo.getAplicarSancion());
            ps.setInt(18, consumo.getCodigo());
            
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
    public List<ConsumoServicioXTipoUsuario> obtenerPorRangoFechas(String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_RANGO_FECHAS);
            ps.setString(1, strFechaInicio);
            ps.setString(2, strFechaFin);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public List<ConsumoServicioXTipoUsuario> obtenerPorServicio(String strServicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO);
            ps.setString(1, strServicio);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public List<ConsumoServicioXTipoUsuario> obtenerPorServicioYRangoFechas(String strServicio, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO_RANGO_FECHAS);
            ps.setString(1, strServicio);
            ps.setString(2, strFechaInicio);
            ps.setString(3, strFechaFin);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public List<ConsumoServicioXTipoUsuario> obtenerPorUsuario(String strTipoUsuarioConsumo, String strUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_USUARIO);
            ps.setString(1, strTipoUsuarioConsumo);
            ps.setString(2, strUsuario);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public List<ConsumoServicioXTipoUsuario> obtenerPorUsuarioYRangoFechas(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_USUARIO_RANGO_FECHAS);
            ps.setString(1, strTipoUsuarioConsumo);
            ps.setString(2, strUsuario);
            ps.setString(3, strFechaInicio);
            ps.setString(4, strFechaFin);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public List<ServicioXSubservicioXTipoUsuarioXUnidad> obtenerServiciosSubserviciosConsumidos(String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXSubservicioXTipoUsuarioXUnidad> servicios_subservicios_tipousuario_unidad = new ArrayList<ServicioXSubservicioXTipoUsuarioXUnidad>();
        ServicioXSubservicioXTipoUsuarioXUnidad servicio_subservicio_tipousuario_unidad = null;
        final String SE_FACTURA = "S";
        final String FACTURADO = "N";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_SERVICIOS_SUBSERVICIOS_CONSUMIDOS);
            ps.setString(1, strTipoUsuarioConsumo);
            ps.setString(2, strUsuario);
            ps.setString(3, strFechaInicio);
            ps.setString(4, strFechaFin);
            ps.setString(5, SE_FACTURA);
            ps.setString(6, FACTURADO);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicio_subservicio_tipousuario_unidad = new ServicioXSubservicioXTipoUsuarioXUnidad();                   
                    servicio_subservicio_tipousuario_unidad.setServicio(rs.getString(1));
                    servicio_subservicio_tipousuario_unidad.setSubservicio(rs.getString(2));
                    servicio_subservicio_tipousuario_unidad.setTipoUsuario(rs.getString(3));
                    servicio_subservicio_tipousuario_unidad.setUnidadMedida(rs.getString(4));
                    servicios_subservicios_tipousuario_unidad.add(servicio_subservicio_tipousuario_unidad);
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
        
        return servicios_subservicios_tipousuario_unidad;
    }

    @Override
    public List<ConsumoServicioXTipoUsuario> obtenerConsumosXServicio_Subservicio_TipoUsuario_Unidad(String strServicio, String strSubservicio, String strTipoUsuario, String strUnidad, String strTipoUsuarioConsumo, String strUsuario, String strFechaInicio, String strFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        final String SE_FACTURA = "S";
        final String FACTURADO = "N";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_CONSUMOS_SERVICIOS_SUBSERVICIOS);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            ps.setString(3, strTipoUsuario);
            ps.setString(4, strUnidad);
            ps.setString(5, strTipoUsuarioConsumo);
            ps.setString(6, strUsuario);
            ps.setString(7, strFechaInicio);
            ps.setString(8, strFechaFin);
            ps.setString(9, SE_FACTURA);
            ps.setString(10, FACTURADO);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public Integer validarInsercion(String strIdServicio, String strIdSubservicio, String strIdTipoUsuario, Date dtFechaConsumo, String strTipoUsuarioConsumo, String strIdUsuario, String strIdUnidadMedida) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer intCantidadRegistros=0;
                
        try{
            con = getConexion();
            ps = con.prepareCall(VALIDAR_INSERCION);
            ps.setString(1, strIdServicio);
            ps.setString(2, strIdSubservicio);                  
            ps.setString(3, strIdTipoUsuario);
            java.sql.Date date = new java.sql.Date(dtFechaConsumo.getTime());
            ps.setDate(4, date);
            ps.setString(5, strTipoUsuarioConsumo);
            ps.setString(6, strIdUsuario);
            ps.setString(7, strIdUnidadMedida);
            
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
    public List<ConsumoServicioXTipoUsuario> obtenerTodosBusqueda(ParametroBusquedaRegistro parametroBusquedaConsumo) throws GIDaoException {
        String OBTENER_TODOS_BUSQUEDA=null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        ConsumoServicioXTipoUsuario consumo = null;
        
        OBTENER_TODOS_BUSQUEDA = construirConsultaBusquedaConsumos(parametroBusquedaConsumo);
                             
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_BUSQUEDA);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
    public List<ConsumoServicioXTipoUsuario> obtenerTodosBusquedaPorPaginas(ParametroBusquedaRegistro parametroBusquedaConsumo, Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        String OBTENER_TODOS_BUSQUEDA_POR_PAGINAS=null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        ConsumoServicioXTipoUsuario consumo = null;
        
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
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
        strConsulta = "SELECT * FROM facturacion_servicios.tbl_consumos_servicios_x_tipos_usuarios ";
        
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
    public List<ConsumoServicioXTipoUsuario> obtenerConsumosPorServicioSubservicioCuentaCobroCodigo(String strServicio, String strSubservicio, Long lgCodigoCuentaCobro, Integer intCodigoConsumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoServicioXTipoUsuario> consumos = new ArrayList<ConsumoServicioXTipoUsuario>();
        ConsumoServicioXTipoUsuario consumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_CONSUMOS_SERVICIO_SUBSERVICIO_CUENTACOBRO);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            ps.setLong(3, lgCodigoCuentaCobro);
            ps.setInt(4, intCodigoConsumo);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumo = new ConsumoServicioXTipoUsuario();                    
                    
                    consumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    consumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    consumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    consumo.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    consumo.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumo.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    consumo.setUsuario(rs.getString(COLUMNA_USUARIO));
                    consumo.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    consumo.setCantidadUnidad(rs.getInt(COLUMNA_CANTIDAD_UNIDAD));
                    consumo.setSubcantidad(rs.getInt(COLUMNA_SUBCANTIDAD));
                    consumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumo.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumo.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    consumo.setCuentaCobro(rs.getLong(COLUMNA_CUENTA_COBRO));
                    consumo.setAplicarSancion(rs.getString(COLUMNA_APLICAR_SANCION));
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
