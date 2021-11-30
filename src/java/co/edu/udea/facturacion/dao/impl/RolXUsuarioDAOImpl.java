/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.RolXUsuarioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.RolXUsuario;
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
public class RolXUsuarioDAOImpl extends JDBCConnectionPool implements RolXUsuarioDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_roles_x_usuarios ORDER BY txtPersona, txtRol";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_roles_x_usuarios ORDER BY txtRol LIMIT ?,?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_roles_x_usuarios WHERE txtPersona = ? and txtRol = ?";
    private static final String OBTENER_POR_PERSONA = "SELECT * FROM facturacion_servicios.tbl_roles_x_usuarios WHERE txtPersona = ?";
    private static final String OBTENER_POR_ROL = "SELECT * FROM facturacion_servicios.tbl_roles_x_usuarios WHERE txtRol = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_roles_x_usuarios(txtPersona,txtRol) VALUES(?,?)";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_roles_x_usuarios WHERE txtPersona = ? and txtRol = ?";
    private static final String COLUMNA_PERSONA = "txtPersona";
    private static final String COLUMNA_ROL = "txtRol";
    private static final String ID_ROL_AUXILIAR_PROYECTO = "AUXPROY";
    private static final String ID_ROL_RESPONSABLE = "RESP";
    private static final String ID_ROL_ADMINISTRADOR= "ADM";
    private static final String ID_ROL_DESARROLLADOR = "DES";
    
    @Override
    public List<RolXUsuario> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolXUsuario> rolesXusuarios = new ArrayList<RolXUsuario>();
        RolXUsuario rolXusuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));
                    rolesXusuarios.add(rolXusuario);
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
        
        return rolesXusuarios;
    }

    @Override
    public RolXUsuario obtenerUno(String strPersona, String strRol) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        RolXUsuario rolXusuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setString(1, strPersona);
            ps.setString(2, strRol);
            
            rs = ps.executeQuery();
            
            if (rs.next()){               
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));      
                
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
        
        return rolXusuario;
    }
    
    @Override
    public List<RolXUsuario> obtenerAuxiliaresProyectos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolXUsuario> rolesXusuarios = new ArrayList<RolXUsuario>();
        RolXUsuario rolXusuario = null;
                
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_ROL);
            ps.setString(1, ID_ROL_AUXILIAR_PROYECTO);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));
                    rolesXusuarios.add(rolXusuario);
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
        
        return rolesXusuarios;
    }

    @Override
    public List<RolXUsuario> obtenerResponsables() throws GIDaoException {     
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolXUsuario> rolesXusuarios = new ArrayList<RolXUsuario>();
        RolXUsuario rolXusuario = null;
                
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_ROL);
            ps.setString(1, ID_ROL_RESPONSABLE);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));
                    rolesXusuarios.add(rolXusuario);
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
        
        return rolesXusuarios;
    }

    @Override
    public List<RolXUsuario> obtenerAdministradores() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolXUsuario> rolesXusuarios = new ArrayList<RolXUsuario>();
        RolXUsuario rolXusuario = null;
                
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_ROL);
            ps.setString(1, ID_ROL_ADMINISTRADOR);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));
                    rolesXusuarios.add(rolXusuario);
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
        
        return rolesXusuarios;
    }
    
    @Override
    public List<RolXUsuario> obtenerDesarrolladores() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolXUsuario> rolesXusuarios = new ArrayList<RolXUsuario>();
        RolXUsuario rolXusuario = null;
                
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_ROL);
            ps.setString(1, ID_ROL_DESARROLLADOR);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));
                    rolesXusuarios.add(rolXusuario);
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
        
        return rolesXusuarios;
    }
    
    @Override
    public List<RolXUsuario> obtenerPorRol(String strRol) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolXUsuario> rolesXusuarios = new ArrayList<RolXUsuario>();
        RolXUsuario rolXusuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_ROL);
            ps.setString(1, strRol);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));
                    rolesXusuarios.add(rolXusuario);
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
        
        return rolesXusuarios;
    }
    
    @Override
    public List<RolXUsuario> obtenerPorPersona(String strPersona) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolXUsuario> rolesXusuarios = new ArrayList<RolXUsuario>();
        RolXUsuario rolXusuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_PERSONA);
            ps.setString(1, strPersona);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));
                    rolesXusuarios.add(rolXusuario);
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
        
        return rolesXusuarios;
    }

    @Override
    public void insertar(RolXUsuario rolXpersona) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, rolXpersona.getPersona());        
            ps.setString(2, rolXpersona.getRol());
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
    public void eliminar(String strPersona, String strRol) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ELIMINAR);
            ps.setString(1, strPersona);        
            ps.setString(2, strRol);
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
    public List<RolXUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<RolXUsuario> rolesXusuarios = new ArrayList<RolXUsuario>();
        RolXUsuario rolXusuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    rolXusuario = new RolXUsuario();
                    
                    rolXusuario.setPersona(rs.getString(COLUMNA_PERSONA));
                    rolXusuario.setRol(rs.getString(COLUMNA_ROL));
                    rolesXusuarios.add(rolXusuario);
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
        
        return rolesXusuarios;
    }
}
