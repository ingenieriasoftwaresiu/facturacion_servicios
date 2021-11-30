/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jorge.correa
 */
public class ParametroGeneralDAOImpl extends JDBCConnectionPool implements ParametroGeneralDAO{
    
    private static final String OBTENER_PARAMETROS_GENERALES = "SELECT * FROM facturacion_servicios.tbl_parametros_generales WHERE txtCodigo = ?";
    private static final String INSERTAR_PARAMETROS_GENERALES = "INSERT INTO facturacion_servicios.tbl_parametros_generales(txtCodigo,txtTituloApp,txtSubtituloApp,txtNumRegPag,txtNombreServidor,intNumeroPuerto,txtUsuario,txtPassword,intNumeroDiasLimitePago,ftPorcentajeSancion,txtTokenServiciosWeb) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR_PARAMETROS_GENERALES = "UPDATE facturacion_servicios.tbl_parametros_generales SET txtTituloApp = ?,txtSubtituloApp = ?,txtNumRegPag = ?,txtNombreServidor = ?,intNumeroPuerto = ?,txtUsuario = ?,txtPassword = ?,intNumeroDiasLimitePago = ?,ftPorcentajeSancion = ?,txtTokenServiciosWeb = ? WHERE txtCodigo = ?";
    private static final String CODIGO_FORM = "frmGeneral";
    private static final String COLUMNA_CODIGO = "txtCodigo";
    private static final String COLUMNA_TITULO_APP = "txtTituloApp";
    private static final String COLUMNA_SUBTITULO_APP = "txtSubtituloApp";
    private static final String COLUMNA_NRO_REGISTROS_PAGINA = "txtNumRegPag";
    private static final String COLUMNA_NOMBRE_SERVIDOR = "txtNombreServidor";
    private static final String COLUMNA_NUMERO_PUERTO = "intNumeroPuerto";
    private static final String COLUMNA_USUARIO_CONEXION = "txtUsuario";
    private static final String COLUMNA_CLAVE_CONEXION = "txtPassword";
    private static final String COLUMNA_NUMERO_DIAS_LIMITE_PAGO = "intNumeroDiasLimitePago";
    private static final String COLUMNA_PORCENTAJE_SANCION = "ftPorcentajeSancion";
    private static final String COLUMNA_TOKEN_SERVICIOS_WEB = "txtTokenServiciosWeb";
    
    @Override
    public ParametroGeneral obtenerParametrosGenerales() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ParametroGeneral parametroGeneral = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_PARAMETROS_GENERALES);
            ps.setString(1, CODIGO_FORM);
            
            rs = ps.executeQuery();
            
            if (rs.next()){                
                    parametroGeneral = new ParametroGeneral();                    
                    
                    parametroGeneral.setCodigo(rs.getString(COLUMNA_CODIGO));
                    parametroGeneral.setTituloApp(rs.getString(COLUMNA_TITULO_APP));
                    parametroGeneral.setSubtituloApp(rs.getString(COLUMNA_SUBTITULO_APP));
                    parametroGeneral.setNumeroRegistrosXPagina(rs.getInt(COLUMNA_NRO_REGISTROS_PAGINA));                    
                    parametroGeneral.setNombreServidor(rs.getString(COLUMNA_NOMBRE_SERVIDOR));
                    parametroGeneral.setNumeroPuerto(rs.getInt(COLUMNA_NUMERO_PUERTO));
                    parametroGeneral.setUsuarioConexion(rs.getString(COLUMNA_USUARIO_CONEXION));
                    parametroGeneral.setClaveConexion(rs.getString(COLUMNA_CLAVE_CONEXION));
                    parametroGeneral.setNumeroDiasLimitePago(rs.getInt(COLUMNA_NUMERO_DIAS_LIMITE_PAGO));
                    parametroGeneral.setPorcentajeSancion(rs.getFloat(COLUMNA_PORCENTAJE_SANCION));
                    parametroGeneral.setTokenServiciosWeb(rs.getString(COLUMNA_TOKEN_SERVICIOS_WEB));
                    
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
        
        return parametroGeneral;
    }

    @Override
    public void insertarParametrosGenerales(ParametroGeneral parametroGeneral) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR_PARAMETROS_GENERALES);
            ps.setString(1, parametroGeneral.getCodigo());
            ps.setString(2, parametroGeneral.getTituloApp());
            ps.setString(3, parametroGeneral.getSubtituloApp());
            ps.setInt(4, parametroGeneral.getNumeroRegistrosXPagina());
            ps.setString(5, parametroGeneral.getNombreServidor());
            ps.setInt(6, parametroGeneral.getNumeroPuerto());
            ps.setString(7, parametroGeneral.getUsuarioConexion());
            ps.setString(8, parametroGeneral.getClaveConexion());
            ps.setInt(9, parametroGeneral.getNumeroDiasLimitePago());
            ps.setFloat(10, parametroGeneral.getPorcentajeSancion());
            ps.setString(11, parametroGeneral.getTokenServiciosWeb());
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
    public void actualizarParametrosGenerales(ParametroGeneral parametroGeneral) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR_PARAMETROS_GENERALES);            
            ps.setString(1, parametroGeneral.getTituloApp());
            ps.setString(2, parametroGeneral.getSubtituloApp());
            ps.setInt(3, parametroGeneral.getNumeroRegistrosXPagina());
            ps.setString(4, parametroGeneral.getNombreServidor());
            ps.setInt(5, parametroGeneral.getNumeroPuerto());
            ps.setString(6, parametroGeneral.getUsuarioConexion());
            ps.setString(7, parametroGeneral.getClaveConexion());
            ps.setInt(8, parametroGeneral.getNumeroDiasLimitePago());
            ps.setFloat(9, parametroGeneral.getPorcentajeSancion());
            ps.setString(10, parametroGeneral.getTokenServiciosWeb());
            ps.setString(11, parametroGeneral.getCodigo());
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
