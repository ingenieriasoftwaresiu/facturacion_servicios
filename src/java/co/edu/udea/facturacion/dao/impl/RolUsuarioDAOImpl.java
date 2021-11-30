/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.RolUsuarioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.RolUsuario;
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
public class RolUsuarioDAOImpl extends JDBCConnectionPool implements RolUsuarioDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_roles_usuarios ORDER BY txtNombre";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_roles_usuarios ORDER BY txtNombre LIMIT ?,?";
    private static final String OBTENER_TODOS_POR_AUTENTICAR = "SELECT * FROM facturacion_servicios.tbl_roles_usuarios WHERE txtSeAutentica = ? ORDER BY txtNombre";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_roles_usuarios WHERE txtCodigo = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_roles_usuarios(txtCodigo,txtNombre,txtSeAutentica) VALUES(?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_roles_usuarios SET txtNombre = ?, txtSeAutentica = ? WHERE txtCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_roles_usuarios WHERE txtCodigo = ?";
    private static final String COLUMNA_CODIGO = "txtCodigo";
    private static final String COLUMNA_NOMBRE = "txtNombre";
    private static final String COLUMNA_SE_AUTENTICA = "txtSeAutentica";
    
    @Override
    public List<RolUsuario> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolUsuario> rolesUsuarios = new ArrayList<RolUsuario>();
        RolUsuario rolUsuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolUsuario = new RolUsuario();
                    
                    rolUsuario.setCodigo(rs.getString(COLUMNA_CODIGO));
                    rolUsuario.setNombre(rs.getString(COLUMNA_NOMBRE));
                    rolUsuario.setSeAutentica(rs.getString(COLUMNA_SE_AUTENTICA));
                    rolesUsuarios.add(rolUsuario);
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
        
        return rolesUsuarios;
    }

    @Override
    public RolUsuario obtenerUno(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        RolUsuario rolUsuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setString(1, strCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){    
                    rolUsuario = new RolUsuario();
                    
                    rolUsuario.setCodigo(rs.getString(COLUMNA_CODIGO));
                    rolUsuario.setNombre(rs.getString(COLUMNA_NOMBRE));    
                    rolUsuario.setSeAutentica(rs.getString(COLUMNA_SE_AUTENTICA));
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
        
        return rolUsuario;
    }

    @Override
    public void insertar(RolUsuario rolUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, rolUsuario.getCodigo());        
            ps.setString(2, rolUsuario.getNombre());
            ps.setString(3, rolUsuario.getSeAutentica());
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
    public void actualizar(RolUsuario rolUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);
            ps.setString(1, rolUsuario.getNombre());        
            ps.setString(2, rolUsuario.getSeAutentica());
            ps.setString(3, rolUsuario.getCodigo());
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
    public List<RolUsuario> obtenerTodosPorAutenticar(String strSeAutentican) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolUsuario> rolesUsuarios = new ArrayList<RolUsuario>();
        RolUsuario rolUsuario = null;
                
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_AUTENTICAR);
            ps.setString(1, strSeAutentican);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolUsuario = new RolUsuario();
                    
                    rolUsuario.setCodigo(rs.getString(COLUMNA_CODIGO));
                    rolUsuario.setNombre(rs.getString(COLUMNA_NOMBRE));
                    rolUsuario.setSeAutentica(rs.getString(COLUMNA_SE_AUTENTICA));
                    rolesUsuarios.add(rolUsuario);
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
        
        return rolesUsuarios;
    }

    @Override
    public List<RolUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolUsuario> rolesUsuarios = new ArrayList<RolUsuario>();
        RolUsuario rolUsuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolUsuario = new RolUsuario();
                    
                    rolUsuario.setCodigo(rs.getString(COLUMNA_CODIGO));
                    rolUsuario.setNombre(rs.getString(COLUMNA_NOMBRE));
                    rolUsuario.setSeAutentica(rs.getString(COLUMNA_SE_AUTENTICA));
                    rolesUsuarios.add(rolUsuario);
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
        
        return rolesUsuarios;
    }
}
