/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
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
public class DescuentoConsumoXUnidadDAOImpl extends JDBCConnectionPool implements DescuentoConsumoXUnidadDAO{

    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_descuentos_consumos_x_unidades ORDER BY intCodigo";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_descuentos_consumos_x_unidades WHERE intCodigo = ?";
    private static final String OBTENER_POR_CONSUMO = "SELECT * FROM facturacion_servicios.tbl_descuentos_consumos_x_unidades WHERE intConsumo = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_descuentos_consumos_x_unidades(intConsumo,ftValorDescuento,txtSeFactura,txtUsuarioRegistra,dtFechaRegistra,txtAplicado,dtFechaAplicacion,txtConcepto) VALUES(?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_descuentos_consumos_x_unidades set intConsumo=?,ftValorDescuento=?,txtSeFactura=?,txtUsuarioRegistra=?,dtFechaRegistra=?,txtAplicado=?,dtFechaAplicacion=?,txtConcepto=? WHERE intCodigo=?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_descuentos_consumos_x_unidades WHERE intCodigo = ?";
    private static final String COLUMNA_CODIGO = "intCodigo";
    private static final String COLUMNA_CONSUMO = "intConsumo";        
    private static final String COLUMNA_VALOR_DESCUENTO = "ftValorDescuento";   
    private static final String COLUMNA_SEFACTURA = "txtSeFactura";   
    private static final String COLUMNA_USUARIO_REGISTRA = "txtUsuarioRegistra";   
    private static final String COLUMNA_FECHA_REGISTRA = "dtFechaRegistra";   
    private static final String COLUMNA_APLICADO= "txtAplicado";   
    private static final String COLUMNA_FECHA_APLICACION = "dtFechaAplicacion"; 
    private static final String COLUMNA_CONCEPTO = "txtConcepto";   
    
    @Override
    public List<DescuentoConsumo> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DescuentoConsumo> descuentosConsumos = new ArrayList<DescuentoConsumo>();
        DescuentoConsumo descuentoConsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    descuentoConsumo = new DescuentoConsumo();                    
                    
                    descuentoConsumo.setCodigo(rs.getInt(COLUMNA_CODIGO));                   
                    descuentoConsumo.setConsumo(rs.getInt(COLUMNA_CONSUMO));
                    descuentoConsumo.setDescuento(rs.getFloat(COLUMNA_VALOR_DESCUENTO));
                    descuentoConsumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    descuentoConsumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    descuentoConsumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    descuentoConsumo.setAplicado(rs.getString(COLUMNA_APLICADO));
                    descuentoConsumo.setFechaAplicacion(rs.getDate(COLUMNA_FECHA_APLICACION));
                    descuentoConsumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                    descuentosConsumos.add(descuentoConsumo);
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
        
        return descuentosConsumos;
    }

    @Override
    public DescuentoConsumo obtenerUno(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DescuentoConsumo descuentoConsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setInt(1,intCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){   
                    descuentoConsumo = new DescuentoConsumo();                    
                    
                    descuentoConsumo.setCodigo(rs.getInt(COLUMNA_CODIGO));                   
                    descuentoConsumo.setConsumo(rs.getInt(COLUMNA_CONSUMO));
                    descuentoConsumo.setDescuento(rs.getFloat(COLUMNA_VALOR_DESCUENTO));
                    descuentoConsumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    descuentoConsumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    descuentoConsumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    descuentoConsumo.setAplicado(rs.getString(COLUMNA_APLICADO));
                    descuentoConsumo.setFechaAplicacion(rs.getDate(COLUMNA_FECHA_APLICACION));
                    descuentoConsumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                
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
        
        return descuentoConsumo;
    }

    @Override
    public DescuentoConsumo obtenerPorConsumo(Integer intCodigoConsumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DescuentoConsumo descuentoConsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_CONSUMO);
            ps.setInt(1,intCodigoConsumo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){   
                    descuentoConsumo = new DescuentoConsumo();                    
                    
                    descuentoConsumo.setCodigo(rs.getInt(COLUMNA_CODIGO));                   
                    descuentoConsumo.setConsumo(rs.getInt(COLUMNA_CONSUMO));
                    descuentoConsumo.setDescuento(rs.getFloat(COLUMNA_VALOR_DESCUENTO));
                    descuentoConsumo.setSeFactura(rs.getString(COLUMNA_SEFACTURA));
                    descuentoConsumo.setUsuarioRegistra(rs.getString(COLUMNA_USUARIO_REGISTRA));
                    descuentoConsumo.setFechaRegistra(rs.getDate(COLUMNA_FECHA_REGISTRA));
                    descuentoConsumo.setAplicado(rs.getString(COLUMNA_APLICADO));
                    descuentoConsumo.setFechaAplicacion(rs.getDate(COLUMNA_FECHA_APLICACION));
                    descuentoConsumo.setConcepto(rs.getString(COLUMNA_CONCEPTO));
                
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
        
        return descuentoConsumo;
    }

    @Override
    public void insertar(DescuentoConsumo descuentoConsumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaRegistra = null;
        java.sql.Date dtFechaAplicacion = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            
            ps.setInt(1, descuentoConsumo.getConsumo());
            ps.setFloat(2, descuentoConsumo.getDescuento());
            ps.setString(3,descuentoConsumo.getSeFactura());
            ps.setString(4,descuentoConsumo.getUsuarioRegistra());         
            dtFechaRegistra = new java.sql.Date(descuentoConsumo.getFechaRegistra().getTime());
            ps.setDate(5,dtFechaRegistra);
            ps.setString(6,descuentoConsumo.getAplicado());
            if (descuentoConsumo.getFechaAplicacion() != null){
                dtFechaAplicacion = new java.sql.Date(descuentoConsumo.getFechaAplicacion().getTime());
            }else{
                dtFechaAplicacion = null;
            }
            ps.setDate(7,dtFechaAplicacion);             
            ps.setString(8, descuentoConsumo.getConcepto());
            
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
    public void actualizar(DescuentoConsumo descuentoConsumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaRegistra = null;
        java.sql.Date dtFechaAplicacion = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);
            
            ps.setInt(1, descuentoConsumo.getConsumo());
            ps.setFloat(2, descuentoConsumo.getDescuento());
            ps.setString(3,descuentoConsumo.getSeFactura());
            ps.setString(4,descuentoConsumo.getUsuarioRegistra());         
            dtFechaRegistra = new java.sql.Date(descuentoConsumo.getFechaRegistra().getTime());
            ps.setDate(5,dtFechaRegistra);
            ps.setString(6,descuentoConsumo.getAplicado());
            if (descuentoConsumo.getFechaAplicacion() != null){
                dtFechaAplicacion = new java.sql.Date(descuentoConsumo.getFechaAplicacion().getTime());
            }else{
                dtFechaAplicacion = null;
            }
            ps.setDate(7,dtFechaAplicacion);             
            ps.setString(8, descuentoConsumo.getConcepto());
            ps.setInt(9, descuentoConsumo.getCodigo());
            
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
