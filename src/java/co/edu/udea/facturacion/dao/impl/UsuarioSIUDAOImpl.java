/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.UsuarioSIUDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.UsuarioSesionSIU;
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
public class UsuarioSIUDAOImpl extends JDBCConnectionPool implements UsuarioSIUDAO {
    
    private static final String OBTENER_TODOS = "SELECT txtIdentificacion, txtNombreCompleto, txtUsuario, txtGrupoPertenece, txtEstadoActual, txtEmail, txtEmailC FROM users.users_personas ORDER BY txtNombreCompleto";
    private static final String VALIDAR_USUARIO = "SELECT txtIdentificacion, txtNombreCompleto, txtUsuario, txtGrupoPertenece, txtEstadoActual, txtEmail, txtEmailC FROM users.users_personas WHERE txtUsuario = ? and txtPassword = ?";
    private static final String OBTENER_INFO_USUARIO = "SELECT txtIdentificacion, txtNombreCompleto, txtUsuario, txtGrupoPertenece, txtEstadoActual, txtEmail, txtEmailC FROM users.users_personas WHERE txtIdentificacion = ?";
    private static final String COLUMNA_ID = "txtIdentificacion";
    private static final String COLUMNA_NOMBRE = "txtNombreCompleto";
    private static final String COLUMNA_USUARIO = "txtUsuario";
    private static final String COLUMNA_GRUPO = "txtGrupoPertenece";
    private static final String COLUMNA_ESTADO_ACTUAL = "txtEstadoActual";
    private static final String COLUMNA_CORREO_ELECTRONICO_PERSONAL= "txtEmail";
    private static final String COLUMNA_CORREO_ELECTRONICO_INSTITUCIONAL = "txtEmailC";    

    @Override
    public UsuarioSesionSIU validarCredencialesAcceso(String strUser, String strPassword) throws GIDaoException {
        
        UsuarioSesionSIU usuarioSIU = null;
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = con.prepareStatement(VALIDAR_USUARIO);
            ps.setString(1, strUser);
            ps.setString(2, strPassword);
            rs = ps.executeQuery();
            
            if(rs.next()){
                usuarioSIU = new UsuarioSesionSIU();
                usuarioSIU.setIdentificacion(rs.getString(COLUMNA_ID));
                usuarioSIU.setNombreCompleto(rs.getString(COLUMNA_NOMBRE));
                usuarioSIU.setUsuario(rs.getString(COLUMNA_USUARIO));
                usuarioSIU.setGrupo(rs.getString(COLUMNA_GRUPO));
                usuarioSIU.setEstadoActual(rs.getString(COLUMNA_ESTADO_ACTUAL));                
            }                
            
        }catch(SQLException se){
            throw new GIDaoException("Se produjo un error al consultar la información del usuario " + strUser + ".",se);
        }finally{
            try{
                if (ps != null){
                    ps.close();
                }
                
                if (rs != null){
                    rs.close();
                }
                
                if (con != null){
                    con.close();
                }
            }catch(SQLException se){
                throw new GIDaoException("Se produjo un error cerrando los objetos de la base de datos." + strUser,se);
            }
        }               
        
        return usuarioSIU;
    }    

    @Override
    public UsuarioSesionSIU obtenerInfoUsuario(String strIdentificacion) throws GIDaoException {
        UsuarioSesionSIU usuarioSIU = null;
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = con.prepareStatement(OBTENER_INFO_USUARIO);
            ps.setString(1, strIdentificacion);
            rs = ps.executeQuery();
            
            if(rs.next()){
                usuarioSIU = new UsuarioSesionSIU();
                usuarioSIU.setIdentificacion(rs.getString(COLUMNA_ID));
                usuarioSIU.setNombreCompleto(rs.getString(COLUMNA_NOMBRE));
                usuarioSIU.setUsuario(rs.getString(COLUMNA_USUARIO));
                usuarioSIU.setGrupo(rs.getString(COLUMNA_GRUPO));
                usuarioSIU.setEstadoActual(rs.getString(COLUMNA_ESTADO_ACTUAL));    
                usuarioSIU.setCorreoElectronicoPersonal(rs.getString(COLUMNA_CORREO_ELECTRONICO_PERSONAL));
                usuarioSIU.setCorreoElectronicoInstitucional(rs.getString(COLUMNA_CORREO_ELECTRONICO_INSTITUCIONAL));
            }                
            
        }catch(SQLException se){
            throw new GIDaoException("Se produjo un error al consultar la información del usuario " + strIdentificacion + ".",se);
        }finally{
            try{
                if (ps != null){
                    ps.close();
                }
                
                if (rs != null){
                    rs.close();
                }
                
                if (con != null){
                    con.close();
                }
            }catch(SQLException se){
                throw new GIDaoException("Se produjo un error cerrando los objetos de la base de datos." + strIdentificacion,se);
            }
        }               
        
        return usuarioSIU;
    }

    @Override
    public List<UsuarioSesionSIU> obtenerTodos() throws GIDaoException {
        UsuarioSesionSIU usuarioSIU = null;
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UsuarioSesionSIU> usuariosSIU = new ArrayList<UsuarioSesionSIU>();
        
        try{
            ps = con.prepareStatement(OBTENER_TODOS);      
            rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    usuarioSIU = new UsuarioSesionSIU();
                    usuarioSIU.setIdentificacion(rs.getString(COLUMNA_ID));
                    usuarioSIU.setNombreCompleto(rs.getString(COLUMNA_NOMBRE));
                    usuarioSIU.setUsuario(rs.getString(COLUMNA_USUARIO));
                    usuarioSIU.setGrupo(rs.getString(COLUMNA_GRUPO));
                    usuarioSIU.setEstadoActual(rs.getString(COLUMNA_ESTADO_ACTUAL));    
                    usuarioSIU.setCorreoElectronicoPersonal(rs.getString(COLUMNA_CORREO_ELECTRONICO_PERSONAL));
                    usuarioSIU.setCorreoElectronicoInstitucional(rs.getString(COLUMNA_CORREO_ELECTRONICO_INSTITUCIONAL));
                    usuariosSIU.add(usuarioSIU);
                }
            }                
            
        }catch(SQLException se){
            throw new GIDaoException("Se produjo un error al consultar todos los usuarios.",se);
        }finally{
            try{
                if (ps != null){
                    ps.close();
                }
                
                if (rs != null){
                    rs.close();
                }
                
                if (con != null){
                    con.close();
                }
            }catch(SQLException se){
                throw new GIDaoException("Se produjo un error cerrando los objetos de la base de datos.",se);
            }
        }               
        
        return usuariosSIU;
    }
}
