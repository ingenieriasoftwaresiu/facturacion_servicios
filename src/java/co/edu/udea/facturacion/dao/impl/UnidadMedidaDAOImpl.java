/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.UnidadMedida;
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
public class UnidadMedidaDAOImpl extends JDBCConnectionPool implements UnidadMedidaDAO {
           
    private static final String OBTENER_TODAS = "SELECT * FROM facturacion_servicios.tbl_unidades_medida ORDER BY txtNombre";
    private static final String OBTENER_TODAS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_unidades_medida ORDER BY txtNombre LIMIT ?,?";
    private static final String OBTENER_UNA = "SELECT * FROM facturacion_servicios.tbl_unidades_medida WHERE txtCodigo = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_unidades_medida(txtCodigo,txtNombre) VALUES(?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_unidades_medida SET txtNombre = ? WHERE txtCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_unidades_medida WHERE txtCodigo = ?";
    private static final String COLUMNA_CODIGO = "txtCodigo";
    private static final String COLUMNA_NOMBRE = "txtNombre";

    @Override
    public List<UnidadMedida> obtenerTodas() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UnidadMedida> unidades_medida = new ArrayList<UnidadMedida>();
        UnidadMedida unidad_medida = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODAS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    unidad_medida = new UnidadMedida();
                    
                    unidad_medida.setCodigo(rs.getString(COLUMNA_CODIGO));
                    unidad_medida.setNombre(rs.getString(COLUMNA_NOMBRE));
                    unidades_medida.add(unidad_medida);
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
        
        return unidades_medida;
    }

    @Override
    public UnidadMedida obtenerUna(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UnidadMedida unidad_medida = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNA);
            ps.setString(1, strCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){                
                    unidad_medida = new UnidadMedida();                    
                    unidad_medida.setCodigo(rs.getString(COLUMNA_CODIGO));
                    unidad_medida.setNombre(rs.getString(COLUMNA_NOMBRE));                
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
        
        return unidad_medida;
    }

    @Override
    public void insertar(UnidadMedida unidad_medida) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, unidad_medida.getCodigo());        
            ps.setString(2, unidad_medida.getNombre());
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
    public void actualizar(UnidadMedida unidad_medida) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);
            ps.setString(1, unidad_medida.getNombre());        
            ps.setString(2, unidad_medida.getCodigo());
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
    public void eliminar(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ELIMINAR);
            ps.setString(1, strCodigo);        
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
    public List<UnidadMedida> obtenerTodasPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UnidadMedida> unidades_medida = new ArrayList<UnidadMedida>();
        UnidadMedida unidad_medida = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODAS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    unidad_medida = new UnidadMedida();
                    
                    unidad_medida.setCodigo(rs.getString(COLUMNA_CODIGO));
                    unidad_medida.setNombre(rs.getString(COLUMNA_NOMBRE));
                    unidades_medida.add(unidad_medida);
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
        
        return unidades_medida;
    }
}
