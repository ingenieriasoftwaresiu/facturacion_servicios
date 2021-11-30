/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.UsuarioConsumoSIUDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.UsuarioConsumoSIU;
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
public class UsuarioConsumoSIUDAOImpl extends JDBCConnectionPool implements UsuarioConsumoSIUDAO{
    
    private final static String OBTENER_TODOS = "SELECT * FROM users.users_grupos_siu ORDER BY txtNombre";
    private final static String OBTENER_UNO = "SELECT * FROM users.users_grupos_siu WHERE txtCodigo = ?";
    private final static String COLUMNA_CODIGO = "txtCodigo";
    private final static String COLUMNA_NOMBRE = "txtNombre";
    private final static String COLUMNA_COORDINADOR = "txtCoordinador";
    private final static String COLUMNA_AUXILIAR_ENCARGADO = "txtAuxiliarEncargado";
        
    @Override
    public List<UsuarioConsumoSIU> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UsuarioConsumoSIU> usuariosConsumosSIU = new ArrayList<UsuarioConsumoSIU>();
        UsuarioConsumoSIU usuarioConsumoSIU = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);        
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    usuarioConsumoSIU = new UsuarioConsumoSIU();
                    
                    usuarioConsumoSIU.setCodigo(rs.getString(COLUMNA_CODIGO));
                    usuarioConsumoSIU.setNombre(rs.getString(COLUMNA_NOMBRE));
                    usuarioConsumoSIU.setCoordinador(rs.getString(COLUMNA_COORDINADOR));
                    usuarioConsumoSIU.setAuxiliarResponsable(rs.getString(COLUMNA_AUXILIAR_ENCARGADO));
                    usuariosConsumosSIU.add(usuarioConsumoSIU);
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
        
        return usuariosConsumosSIU;
    }

    @Override
    public UsuarioConsumoSIU obtenerUno(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsuarioConsumoSIU usuarioConsumoSIU = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);        
            ps.setString(1, strCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){               
                    usuarioConsumoSIU = new UsuarioConsumoSIU();                    
                    usuarioConsumoSIU.setCodigo(rs.getString(COLUMNA_CODIGO));
                    usuarioConsumoSIU.setNombre(rs.getString(COLUMNA_NOMBRE));               
                    usuarioConsumoSIU.setCoordinador(rs.getString(COLUMNA_COORDINADOR));
                    usuarioConsumoSIU.setAuxiliarResponsable(rs.getString(COLUMNA_AUXILIAR_ENCARGADO));
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
        
        return usuarioConsumoSIU;
    }
    
}
