/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ConsumoAdicionalXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public class ConsumoAdicionalXTipoUsuarioDAOImpl extends JDBCConnectionPool implements ConsumoAdicionalXTipoUsuarioDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_consumos_adicionales_x_tipos_usuarios ORDER BY intCodigo";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_consumos_adicionales_x_tipos_usuarios WHERE intCodigo = ?";
    private static final String OBTENER_POR_CONSUMO = "SELECT * FROM facturacion_servicios.tbl_consumos_adicionales_x_tipos_usuarios WHERE intConsumo = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_consumos_adicionales_x_tipos_usuarios(intConsumo,txtItem,dtFechaConsumo,intValorUnidad,txtSeFactura,txtUsuarioRegistra,dtFechaRegistra,txtFacturado,dtFechaFacturacion) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_consumos_adicionales_x_tipos_usuarios set intConsumo=?,txtItem=?,dtFechaConsumo=?,intValorUnidad=?,txtSeFactura=?,txtUsuarioRegistra=?,dtFechaRegistra=?,txtFacturado=?,dtFechaFacturacion=? WHERE intCodigo=?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_consumos_adicionales_x_tipos_usuarios WHERE intCodigo = ?";
    private static final String COLUMNA_CODIGO = "intCodigo";
    private static final String COLUMNA_CONSUMO = "intConsumo";        
    private static final String COLUMNA_ITEM_ADICIONAL = "txtItem";   
    private static final String COLUMNA_FECHA_CONSUMO = "dtFechaConsumo"; 
    private static final String COLUMNA_VALOR_UNIDAD = "intValorUnidad";             
    private static final String COLUMNA_SEFACTURA = "txtSeFactura";   
    private static final String COLUMNA_USUARIO_REGISTRA = "txtUsuarioRegistra";   
    private static final String COLUMNA_FECHA_REGISTRA = "dtFechaRegistra";   
    private static final String COLUMNA_FACTURADO = "txtFacturado";   
    private static final String COLUMNA_FECHA_FACTURACION = "dtFechaFacturacion"; 
    
    @Override
    public List<ConsumoAdicional> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoAdicional> consumosAdicionales = new ArrayList<ConsumoAdicional>();
        ConsumoAdicional consumoAdicional = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumoAdicional = new ConsumoAdicional();                    
                    
                    consumoAdicional.setCodigo(rs.getInt(COLUMNA_CODIGO));                   
                    consumoAdicional.setConsumo(rs.getInt(COLUMNA_CONSUMO));
                    consumoAdicional.setItemAdicional(rs.getString(COLUMNA_ITEM_ADICIONAL));
                    consumoAdicional.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumoAdicional.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));
                    consumoAdicional.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumoAdicional.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumoAdicional.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumoAdicional.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumoAdicional.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumosAdicionales.add(consumoAdicional);
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
        
        return consumosAdicionales;
    }

    @Override
    public ConsumoAdicional obtenerUno(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConsumoAdicional consumoAdicional = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setInt(1, intCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){              
                    consumoAdicional = new ConsumoAdicional();                    
                    
                    consumoAdicional.setCodigo(rs.getInt(COLUMNA_CODIGO));                   
                    consumoAdicional.setConsumo(rs.getInt(COLUMNA_CONSUMO));
                    consumoAdicional.setItemAdicional(rs.getString(COLUMNA_ITEM_ADICIONAL));
                    consumoAdicional.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    consumoAdicional.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));
                    consumoAdicional.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumoAdicional.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumoAdicional.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumoAdicional.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumoAdicional.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));                  
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
        
        return consumoAdicional;
    }

    @Override
    public List<ConsumoAdicional> obtenerPorConsumo(Integer intCodigoConsumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ConsumoAdicional> consumosAdicionales = new ArrayList<ConsumoAdicional>();
        ConsumoAdicional consumoAdicional = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_CONSUMO);
            ps.setInt(1, intCodigoConsumo);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    consumoAdicional = new ConsumoAdicional();                    
                    
                    consumoAdicional.setCodigo(rs.getInt(COLUMNA_CODIGO));                   
                    consumoAdicional.setConsumo(rs.getInt(COLUMNA_CONSUMO));
                    consumoAdicional.setItemAdicional(rs.getString(COLUMNA_ITEM_ADICIONAL));
                    consumoAdicional.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));        
                    consumoAdicional.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));
                    consumoAdicional.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    consumoAdicional.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    consumoAdicional.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    consumoAdicional.setFacturado(rs.getString(COLUMNA_FACTURADO));
                    consumoAdicional.setFechaFacturacion(rs.getDate(COLUMNA_FECHA_FACTURACION));
                    consumosAdicionales.add(consumoAdicional);
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
        
        return consumosAdicionales;
    }

    @Override
    public void insertar(ConsumoAdicional consumoAdicional) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaConsumo = null;
        java.sql.Date dtFechaRegistra = null;
        java.sql.Date dtFechaFacturacion = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            
            ps.setInt(1, consumoAdicional.getConsumo());
            ps.setString(2, consumoAdicional.getItemAdicional());
            dtFechaConsumo = new java.sql.Date(consumoAdicional.getFechaConsumo().getTime());
            ps.setDate(3,dtFechaConsumo);
            ps.setFloat(4, consumoAdicional.getValorUnidad());
            ps.setString(5,consumoAdicional.getSeFactura());
            ps.setString(6,consumoAdicional.getUsuarioRegistra());         
            dtFechaRegistra = new java.sql.Date(consumoAdicional.getFechaRegistra().getTime());
            ps.setDate(7,dtFechaRegistra);
            ps.setString(8,consumoAdicional.getFacturado());
            if (consumoAdicional.getFechaFacturacion() != null){
                dtFechaFacturacion = new java.sql.Date(consumoAdicional.getFechaFacturacion().getTime());
            }else{
                dtFechaFacturacion = null;
            }
            ps.setDate(9,dtFechaFacturacion);              
            
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
    public void actualizar(ConsumoAdicional consumoAdicional) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaConsumo = null;
        java.sql.Date dtFechaRegistra = null;
        java.sql.Date dtFechaFacturacion = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);
            
            ps.setInt(1, consumoAdicional.getConsumo());
            ps.setString(2, consumoAdicional.getItemAdicional());
            dtFechaConsumo = new java.sql.Date(consumoAdicional.getFechaConsumo().getTime());
            ps.setDate(3,dtFechaConsumo);
            ps.setFloat(4, consumoAdicional.getValorUnidad());
            ps.setString(5,consumoAdicional.getSeFactura());
            ps.setString(6,consumoAdicional.getUsuarioRegistra());         
            dtFechaRegistra = new java.sql.Date(consumoAdicional.getFechaRegistra().getTime());
            ps.setDate(7,dtFechaRegistra);
            ps.setString(8,consumoAdicional.getFacturado());
            if (consumoAdicional.getFechaFacturacion() != null){
                dtFechaFacturacion = new java.sql.Date(consumoAdicional.getFechaFacturacion().getTime());
            }else{
                dtFechaFacturacion = null;
            }
            ps.setDate(9,dtFechaFacturacion);              
            ps.setInt(10, consumoAdicional.getCodigo());
            
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
}
