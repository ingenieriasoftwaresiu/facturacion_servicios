/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ParametrosSIUDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jorge.correa
 */
public class ParametrosSIUDAOImpl extends JDBCConnectionPool implements ParametrosSIUDAO{
    
    private static final String OBTENER_RUTA_APLICACION = "SELECT txtUrlAcceso FROM users.users_apps WHERE txtCodigo = ?";
    private static final String COLUMNA_URL_ACCESO = "txtUrlAcceso";
    
    @Override
    public String obtenerRutaAplicacion(String strIdApp) {       
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String strRutaApp = "";        
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_RUTA_APLICACION);
            ps.setString(1, strIdApp);
            
            rs = ps.executeQuery();
            
            if (rs.next()){                
                    strRutaApp = rs.getString(COLUMNA_URL_ACCESO);
            }
            
        }catch(SQLException e){
            new GIDaoException("Se generó un error al intentar establecer la conexión con la base de datos en el método obtenerRutaAplicacion" + strIdApp, e);
        }catch(GIDaoException e){
            new GIDaoException("Se generó un error al intentar recuperar la URL de la aplicación " + strIdApp, e);
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
                new GIDaoException("Se generó un error cerrando los objetos de conexión del método obtenerRutaAplicacion", e);
            }
        }
        
        return strRutaApp;
    }
    
}
