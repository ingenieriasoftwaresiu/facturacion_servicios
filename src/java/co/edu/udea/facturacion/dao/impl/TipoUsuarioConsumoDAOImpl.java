/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.TipoUsuarioConsumoDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.TipoUsuarioConsumo;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George
 */
public class TipoUsuarioConsumoDAOImpl extends JDBCConnectionPool implements TipoUsuarioConsumoDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM users.users_tipos_usuario ORDER BY txtNombre";
    private static final String OBTENER_UNO = "SELECT * FROM users.users_tipos_usuario WHERE txtCodigo = ?";
    private static final String INSERTAR = "INSERT INTO users.users_tipos_usuario(txtCodigo,txtNombre) VALUES(?,?)";
    private static final String ACTUALIZAR = "UPDATE users.users_tipos_usuario SET txtNombre = ? WHERE txtCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM users.users_tipos_usuario WHERE txtCodigo = ?";
    private static final String COLUMNA_CODIGO = "txtCodigo";
    private static final String COLUMNA_NOMBRE = "txtNombre";
    
    @Override
    public List<TipoUsuarioConsumo> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TipoUsuarioConsumo> tiposUsuariosConsumos = new ArrayList<TipoUsuarioConsumo>();
        TipoUsuarioConsumo tipoUsuarioConsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    tipoUsuarioConsumo = new TipoUsuarioConsumo();
                    
                    tipoUsuarioConsumo.setCodigo(rs.getString(COLUMNA_CODIGO));
                    tipoUsuarioConsumo.setNombre(rs.getString(COLUMNA_NOMBRE));
                    tiposUsuariosConsumos.add(tipoUsuarioConsumo);
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
        
        return tiposUsuariosConsumos;
    }

    @Override
    public TipoUsuarioConsumo obtenerUno(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoUsuarioConsumo tipoUsuarioConsumo = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setString(1, strCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){              
                    tipoUsuarioConsumo = new TipoUsuarioConsumo();
                    
                    tipoUsuarioConsumo.setCodigo(rs.getString(COLUMNA_CODIGO));
                    tipoUsuarioConsumo.setNombre(rs.getString(COLUMNA_NOMBRE));                          
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
        
        return tipoUsuarioConsumo;
    }

    @Override
    public void insertar(TipoUsuarioConsumo tipoUsuario) throws GIDaoException {
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
    public void actualizar(TipoUsuarioConsumo tipoUsuario) throws GIDaoException {
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
}
