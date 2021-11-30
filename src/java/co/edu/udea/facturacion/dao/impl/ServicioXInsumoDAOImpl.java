/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ServicioXInsumoDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.ServicioXInsumo;
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
public class ServicioXInsumoDAOImpl extends JDBCConnectionPool implements ServicioXInsumoDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_servicios_x_insumos ORDER BY intCodigo";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_servicios_x_insumos ORDER BY intCodigo LIMIT ?,?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_servicios_x_insumos WHERE intCodigo = ?";
    private static final String OBTENER_POR_SERVICIO_SUBSERVICIO ="SELECT * FROM facturacion_servicios.tbl_servicios_x_insumos WHERE txtServicio=? and txtSubservicio=?";
    private static final String OBTENER_POR_SERVICIO_SUBSERVICIO_INSUMO ="SELECT * FROM facturacion_servicios.tbl_servicios_x_insumos WHERE txtServicio=? and txtSubservicio=? and txtInsumo=?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_servicios_x_insumos(txtServicio,txtSubservicio,txtInsumo,txtCobroTransversal,intCantidadCobroTransversal,intCantidadFija,txtUnidadCantidadFija,txtUtilizaCostoVariable,lgCostoVariable,txtSeCobraAlUsuario) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_servicios_x_insumos SET txtServicio = ?, txtSubservicio=?, txtInsumo=?, txtCobroTransversal=?, intCantidadCobroTransversal=?, intCantidadFija=?, txtUnidadCantidadFija=?, txtUtilizaCostoVariable=?, lgCostoVariable=?, txtSeCobraAlUsuario=? WHERE intCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_servicios_x_insumos WHERE intCodigo = ?";
    private static final String COLUMNA_CODIGO = "intCodigo";
    private static final String COLUMNA_SERVICIO= "txtServicio";
    private static final String COLUMNA_SUBSERVICIO = "txtSubservicio";
    private static final String COLUMNA_INSUMO = "txtInsumo";
    private static final String COLUMA_COBRO_TRANSVERSAL= "txtCobroTransversal";
    private static final String COLUMNA_CANTIDAD_COBRO_TRANSVERSAL = "intCantidadCobroTransversal";
    private static final String COLUMNA_CANTIDAD_FIJA = "intCantidadFija";
    private static final String COLUMNA_UNIDAD_CANTIDAD_FIJA = "txtUnidadCantidadFija";
    private static final String COLUMNA_UTILIZA_COSTO_VARIABLE = "txtUtilizaCostoVariable";
    private static final String COLUMNA_COSTO_VARIABLE = "lgCostoVariable";
    private static final String COLUMNA_SE_COBRA_AL_USUARIO = "txtSeCobraAlUsuario";
    
    @Override
    public List<ServicioXInsumo> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXInsumo> serviciosXinsumos= new ArrayList<ServicioXInsumo>();
        ServicioXInsumo servicioXinsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicioXinsumo = new ServicioXInsumo();
                    
                    servicioXinsumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXinsumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXinsumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXinsumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    servicioXinsumo.setCobroTransversal(rs.getString(COLUMA_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadCobroTransversal(rs.getInt(COLUMNA_CANTIDAD_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadFija(rs.getBigDecimal(COLUMNA_CANTIDAD_FIJA));
                    servicioXinsumo.setUnidadCantidadFija(rs.getString(COLUMNA_UNIDAD_CANTIDAD_FIJA));
                    servicioXinsumo.setUtilizaCostoVariable(rs.getString(COLUMNA_UTILIZA_COSTO_VARIABLE));
                    servicioXinsumo.setCostoVariable(rs.getLong(COLUMNA_COSTO_VARIABLE));
                    servicioXinsumo.setSeCobraAlUsuario(rs.getString(COLUMNA_SE_COBRA_AL_USUARIO));                    
                    serviciosXinsumos.add(servicioXinsumo);
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
        
        return serviciosXinsumos;
    }

    @Override
    public ServicioXInsumo obtenerUno(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServicioXInsumo servicioXinsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setInt(1, intCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){               
                    servicioXinsumo = new ServicioXInsumo();
                    
                    servicioXinsumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXinsumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXinsumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXinsumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    servicioXinsumo.setCobroTransversal(rs.getString(COLUMA_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadCobroTransversal(rs.getInt(COLUMNA_CANTIDAD_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadFija(rs.getBigDecimal(COLUMNA_CANTIDAD_FIJA));
                    servicioXinsumo.setUnidadCantidadFija(rs.getString(COLUMNA_UNIDAD_CANTIDAD_FIJA));                
                    servicioXinsumo.setUtilizaCostoVariable(rs.getString(COLUMNA_UTILIZA_COSTO_VARIABLE));                    
                    servicioXinsumo.setCostoVariable(rs.getLong(COLUMNA_COSTO_VARIABLE));
                    servicioXinsumo.setSeCobraAlUsuario(rs.getString(COLUMNA_SE_COBRA_AL_USUARIO));
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
        
        return servicioXinsumo;
    }
    
     @Override
    public List<ServicioXInsumo> obtenerPorServicioSubservicio(String strServicio, String strSubservicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXInsumo> serviciosXinsumos = new ArrayList<ServicioXInsumo>();
        ServicioXInsumo servicioXinsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO_SUBSERVICIO);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicioXinsumo = new ServicioXInsumo();
                    
                    servicioXinsumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXinsumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXinsumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXinsumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    servicioXinsumo.setCobroTransversal(rs.getString(COLUMA_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadCobroTransversal(rs.getInt(COLUMNA_CANTIDAD_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadFija(rs.getBigDecimal(COLUMNA_CANTIDAD_FIJA));
                    servicioXinsumo.setUnidadCantidadFija(rs.getString(COLUMNA_UNIDAD_CANTIDAD_FIJA));
                    servicioXinsumo.setUtilizaCostoVariable(rs.getString(COLUMNA_UTILIZA_COSTO_VARIABLE));
                    servicioXinsumo.setCostoVariable(rs.getLong(COLUMNA_COSTO_VARIABLE));
                    servicioXinsumo.setSeCobraAlUsuario(rs.getString(COLUMNA_SE_COBRA_AL_USUARIO));
                    serviciosXinsumos.add(servicioXinsumo);
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
        
        return serviciosXinsumos;
    }
    
     @Override
    public ServicioXInsumo obtenerPorServicioSubservicioInsumo(String strServicio, String strSubservicio, String strInsumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServicioXInsumo servicioXinsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO_SUBSERVICIO_INSUMO);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            ps.setString(3, strInsumo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){               
                    servicioXinsumo = new ServicioXInsumo();
                    
                    servicioXinsumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXinsumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXinsumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXinsumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    servicioXinsumo.setCobroTransversal(rs.getString(COLUMA_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadCobroTransversal(rs.getInt(COLUMNA_CANTIDAD_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadFija(rs.getBigDecimal(COLUMNA_CANTIDAD_FIJA));
                    servicioXinsumo.setUnidadCantidadFija(rs.getString(COLUMNA_UNIDAD_CANTIDAD_FIJA));            
                    servicioXinsumo.setUtilizaCostoVariable(rs.getString(COLUMNA_UTILIZA_COSTO_VARIABLE));                    
                    servicioXinsumo.setCostoVariable(rs.getLong(COLUMNA_COSTO_VARIABLE));
                    servicioXinsumo.setSeCobraAlUsuario(rs.getString(COLUMNA_SE_COBRA_AL_USUARIO));
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
        
        return servicioXinsumo;
    }

    @Override
    public void insertar(ServicioXInsumo servicioXinsumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, servicioXinsumo.getServicio());
            ps.setString(2, servicioXinsumo.getSubservicio());
            ps.setString(3, servicioXinsumo.getInsumo());
            ps.setString(4, servicioXinsumo.getCobroTransversal());
            ps.setInt(5, servicioXinsumo.getCantidadCobroTransversal());
            ps.setBigDecimal(6, servicioXinsumo.getCantidadFija());
            ps.setString(7, servicioXinsumo.getUnidadCantidadFija());
            ps.setString(8, servicioXinsumo.getUtilizaCostoVariable());
            ps.setLong(9, servicioXinsumo.getCostoVariable());
            ps.setString(10, servicioXinsumo.getSeCobraAlUsuario());

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
    public void actualizar(ServicioXInsumo servicioXinsumo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);  
            ps.setString(1, servicioXinsumo.getServicio());
            ps.setString(2, servicioXinsumo.getSubservicio());
            ps.setString(3, servicioXinsumo.getInsumo());
            ps.setString(4, servicioXinsumo.getCobroTransversal());
            ps.setInt(5, servicioXinsumo.getCantidadCobroTransversal());
            ps.setBigDecimal(6, servicioXinsumo.getCantidadFija());
            ps.setString(7, servicioXinsumo.getUnidadCantidadFija());
            ps.setString(8, servicioXinsumo.getUtilizaCostoVariable());
            ps.setLong(9, servicioXinsumo.getCostoVariable());
            ps.setString(10, servicioXinsumo.getSeCobraAlUsuario());
            ps.setInt(11, servicioXinsumo.getCodigo());      

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
            ps.setInt(1, intCodigo);        
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
    public List<ServicioXInsumo> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXInsumo> serviciosXinsumos= new ArrayList<ServicioXInsumo>();
        ServicioXInsumo servicioXinsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicioXinsumo = new ServicioXInsumo();
                    
                    servicioXinsumo.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXinsumo.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXinsumo.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXinsumo.setInsumo(rs.getString(COLUMNA_INSUMO));
                    servicioXinsumo.setCobroTransversal(rs.getString(COLUMA_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadCobroTransversal(rs.getInt(COLUMNA_CANTIDAD_COBRO_TRANSVERSAL));
                    servicioXinsumo.setCantidadFija(rs.getBigDecimal(COLUMNA_CANTIDAD_FIJA));
                    servicioXinsumo.setUnidadCantidadFija(rs.getString(COLUMNA_UNIDAD_CANTIDAD_FIJA));
                    servicioXinsumo.setUtilizaCostoVariable(rs.getString(COLUMNA_UTILIZA_COSTO_VARIABLE));
                    servicioXinsumo.setCostoVariable(rs.getLong(COLUMNA_COSTO_VARIABLE));
                    servicioXinsumo.setSeCobraAlUsuario(rs.getString(COLUMNA_SE_COBRA_AL_USUARIO));                    
                    serviciosXinsumos.add(servicioXinsumo);
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
        
        return serviciosXinsumos;
    }
}
