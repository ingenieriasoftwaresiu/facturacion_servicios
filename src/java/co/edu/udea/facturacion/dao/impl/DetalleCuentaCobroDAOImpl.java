/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.DetalleCuentaCobroDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.DetalleCuentaCobro;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge.correa
 */
public class DetalleCuentaCobroDAOImpl extends JDBCConnectionPool implements DetalleCuentaCobroDAO{
    
    private static final String OBTENER_TODOS_POR_CUENTA_COBRO = "SELECT * FROM facturacion_servicios.tbl_detalle_cuentas_cobro WHERE lgCodigoCuentaCobro = ? ORDER BY txtServicio, txtSubservicio";
    private static final String OBTENER_TODOS_POR_SERVICIO_Y_CUENTA_COBRO = "SELECT * FROM facturacion_servicios.tbl_detalle_cuentas_cobro WHERE lgCodigoCuentaCobro = ? and txtServicio = ? ORDER BY txtServicio, txtSubservicio";
    private static final String OBTENER_TOTAL_POR_SERVICIO_Y_CUENTA_COBRO  = "SELECT SUM(intValorAPagar) as TOTAL FROM facturacion_servicios.tbl_detalle_cuentas_cobro WHERE lgCodigoCuentaCobro = ? and txtServicio = ?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_detalle_cuentas_cobro WHERE lgCodigoCuentaCobro = ? AND txtServicio = ? AND txtSubservicio = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_detalle_cuentas_cobro(lgCodigoCuentaCobro,txtServicio,txtSubservicio,intValorAPAgar,dtFechaConsumo,intCodigoConsumo) VALUES(?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_detalle_cuentas_cobro SET intValorAPAgar = ?, dtFechaConsumo=? WHERE lgCodigoCuentaCobro = ? AND txtServicio = ? AND txtSubservicio = ?";
    private static final String ELIMINAR_POR_CUENTA_COBRO = "DELETE FROM facturacion_servicios.tbl_detalle_cuentas_cobro WHERE lgCodigoCuentaCobro = ?";
    private static final String ELIMINAR_UNO = "DELETE FROM facturacion_servicios.tbl_detalle_cuentas_cobro WHERE lgCodigoCuentaCobro = ? AND txtServicio = ? AND txtSubservicio = ?";
    private static final String COLUMNA_CODIGO_CUENTA_COBRO = "lgCodigoCuentaCobro";
    private static final String COLUMNA_SERVICIO = "txtServicio";
    private static final String COLUMNA_SUBSERVICIO = "txtSubservicio";
    private static final String COLUMNA_VALOR_A_PAGAR = "intValorAPagar";
    private static final String COLUMNA_FECHA_CONSUMO = "dtFechaConsumo";
    private static final String COLUMNA_CODIGO_CONSUMO = "intCodigoConsumo";
    private static final String COLUMNA_TOTAL = "TOTAL";

    @Override
    public List<DetalleCuentaCobro> obtenerTodosPorCuentaCobro(Long lgCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DetalleCuentaCobro> detallesCuentaCobro = new ArrayList<DetalleCuentaCobro>();
        DetalleCuentaCobro detalleCuentaCobro = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_CUENTA_COBRO);
            ps.setLong(1, lgCodigo);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    detalleCuentaCobro = new DetalleCuentaCobro();
                    
                    detalleCuentaCobro.setCodigoCuentaCobro(rs.getLong(COLUMNA_CODIGO_CUENTA_COBRO));
                    detalleCuentaCobro.setServicio(rs.getString(COLUMNA_SERVICIO));
                    detalleCuentaCobro.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    detalleCuentaCobro.setTotalAPagar(rs.getBigDecimal(COLUMNA_VALOR_A_PAGAR));
                    detalleCuentaCobro.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    detalleCuentaCobro.setCodigoConsumo(rs.getInt(COLUMNA_CODIGO_CONSUMO));
                    detallesCuentaCobro.add(detalleCuentaCobro);
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
        
        return detallesCuentaCobro;
    }
    
        @Override
    public List<DetalleCuentaCobro> obtenerTodosPorServicioYCuentaCobro(Long lgCodigo, String strIdServicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DetalleCuentaCobro> detallesCuentaCobro = new ArrayList<DetalleCuentaCobro>();
        DetalleCuentaCobro detalleCuentaCobro = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_SERVICIO_Y_CUENTA_COBRO);
            ps.setLong(1, lgCodigo);
            ps.setString(2, strIdServicio);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    detalleCuentaCobro = new DetalleCuentaCobro();
                    
                    detalleCuentaCobro.setCodigoCuentaCobro(rs.getLong(COLUMNA_CODIGO_CUENTA_COBRO));
                    detalleCuentaCobro.setServicio(rs.getString(COLUMNA_SERVICIO));
                    detalleCuentaCobro.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    detalleCuentaCobro.setTotalAPagar(rs.getBigDecimal(COLUMNA_VALOR_A_PAGAR));
                    detalleCuentaCobro.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                    detalleCuentaCobro.setCodigoConsumo(rs.getInt(COLUMNA_CODIGO_CONSUMO));
                    detallesCuentaCobro.add(detalleCuentaCobro);
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
        
        return detallesCuentaCobro;
    }

    @Override
    public BigDecimal obtenerTotalPorServicioYCuentaCobro(Long lgCodigo, String strIdServicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BigDecimal bdTotal= new BigDecimal(0);
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TOTAL_POR_SERVICIO_Y_CUENTA_COBRO);
            ps.setLong(1, lgCodigo);
            ps.setString(2, strIdServicio);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                bdTotal = new BigDecimal(rs.getInt(COLUMNA_TOTAL));
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
        
        return bdTotal;
    }

    @Override
    public DetalleCuentaCobro obtenerUno(Long lgCodigo, String strServicio, String strSubservicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        DetalleCuentaCobro detalleCuentaCobro = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setLong(1, lgCodigo);
            ps.setString(2, strServicio);
            ps.setString(3, strSubservicio);
            
            rs = ps.executeQuery();
            
            if (rs.next()){               
                detalleCuentaCobro = new DetalleCuentaCobro();

                detalleCuentaCobro.setCodigoCuentaCobro(rs.getLong(COLUMNA_CODIGO_CUENTA_COBRO));
                detalleCuentaCobro.setServicio(rs.getString(COLUMNA_SERVICIO));
                detalleCuentaCobro.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                detalleCuentaCobro.setTotalAPagar(rs.getBigDecimal(COLUMNA_VALOR_A_PAGAR));                    
                detalleCuentaCobro.setFechaConsumo(rs.getDate(COLUMNA_FECHA_CONSUMO));
                detalleCuentaCobro.setCodigoConsumo(rs.getInt(COLUMNA_CODIGO_CONSUMO));
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
        
        return detalleCuentaCobro;
    }

    @Override
    public void insertar(DetalleCuentaCobro detalleCuentaCobro) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setLong(1, detalleCuentaCobro.getCodigoCuentaCobro());
            ps.setString(2, detalleCuentaCobro.getServicio());        
            ps.setString(3, detalleCuentaCobro.getSubservicio());
            ps.setBigDecimal(4, detalleCuentaCobro.getTotalAPagar());
            java.sql.Date date = new java.sql.Date(detalleCuentaCobro.getFechaConsumo().getTime());
            ps.setDate(5, date);
            ps.setInt(6, detalleCuentaCobro.getCodigoConsumo());
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
    public void actualizar(DetalleCuentaCobro detalleCuentaCobro) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);
            ps.setBigDecimal(1, detalleCuentaCobro.getTotalAPagar());
            java.sql.Date date = new java.sql.Date(detalleCuentaCobro.getFechaConsumo().getTime());
            ps.setDate(2, date);
            ps.setLong(3, detalleCuentaCobro.getCodigoCuentaCobro());
            ps.setString(4, detalleCuentaCobro.getServicio());        
            ps.setString(5, detalleCuentaCobro.getSubservicio());            
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
    public void eliminarPorCuentaCobro(Long lgCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ELIMINAR_POR_CUENTA_COBRO);
            ps.setLong(1, lgCodigo);        
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
    public void eliminarUno(Long lgCodigo, String strServicio, String strSubservicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ELIMINAR_UNO);
            ps.setLong(1, lgCodigo);        
            ps.setString(2, strServicio);        
            ps.setString(3, strSubservicio);            
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
