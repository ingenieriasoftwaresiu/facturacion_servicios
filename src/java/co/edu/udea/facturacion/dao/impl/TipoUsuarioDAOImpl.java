/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.TipoUsuarioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.TipoUsuario;
import co.edu.udea.facturacion.exception.GIDaoException;
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
public class TipoUsuarioDAOImpl extends JDBCConnectionPool implements TipoUsuarioDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_tipos_usuario ORDER BY txtNombre";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_tipos_usuario ORDER BY txtNombre LIMIT ?,?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_tipos_usuario WHERE txtCodigo = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_tipos_usuario(txtCodigo,txtNombre) VALUES(?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_tipos_usuario SET txtNombre = ? WHERE txtCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_tipos_usuario WHERE txtCodigo = ?";
    private static final String COLUMNA_CODIGO = "txtCodigo";
    private static final String COLUMNA_NOMBRE = "txtNombre";
    
    @Override
    public List<TipoUsuario> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TipoUsuario> tiposUsuarios = new ArrayList<TipoUsuario>();
        TipoUsuario tipoUsuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    tipoUsuario = new TipoUsuario();
                    
                    tipoUsuario.setCodigo(rs.getString(COLUMNA_CODIGO));
                    tipoUsuario.setNombre(rs.getString(COLUMNA_NOMBRE));
                    tiposUsuarios.add(tipoUsuario);
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
        
        return tiposUsuarios;
    }

    @Override
    public TipoUsuario obtenerUno(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoUsuario tipoUsuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setString(1, strCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){              
                    tipoUsuario = new TipoUsuario();
                    
                    tipoUsuario.setCodigo(rs.getString(COLUMNA_CODIGO));
                    tipoUsuario.setNombre(rs.getString(COLUMNA_NOMBRE));                          
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
        
        return tipoUsuario;
    }

    @Override
    public void insertar(TipoUsuario tipoUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, tipoUsuario.getCodigo());        
            ps.setString(2, tipoUsuario.getNombre());
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
    public void actualizar(TipoUsuario tipoUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);           
            ps.setString(1, tipoUsuario.getNombre());
            ps.setString(2, tipoUsuario.getCodigo());      
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
    public List<TipoUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TipoUsuario> tiposUsuarios = new ArrayList<TipoUsuario>();
        TipoUsuario tipoUsuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    tipoUsuario = new TipoUsuario();
                    
                    tipoUsuario.setCodigo(rs.getString(COLUMNA_CODIGO));
                    tipoUsuario.setNombre(rs.getString(COLUMNA_NOMBRE));
                    tiposUsuarios.add(tipoUsuario);
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
        
        return tiposUsuarios;
    }
}
