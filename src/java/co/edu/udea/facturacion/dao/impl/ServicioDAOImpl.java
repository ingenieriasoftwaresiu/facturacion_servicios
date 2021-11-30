/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ServicioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.Servicio;
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
public class ServicioDAOImpl extends JDBCConnectionPool implements ServicioDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM users.users_servicios WHERE txtFacturable = ? ORDER BY txtNombre";
    private static final String OBTENER_POR_TIPO_FACTURACION = "SELECT u.txtCodigo AS txtCodigo, u.txtNombre AS txtNombre FROM users.users_servicios u, facturacion_servicios.tbl_subservicios s WHERE (u.txtCodigo = s.txtServicioPadre) and u.txtFacturable = ? and s.txtTipoFacturacion = ? GROUP BY u.txtCodigo ORDER BY u.txtNombre";
    private static final String OBTENER_UNO = "SELECT * FROM users.users_servicios WHERE txtFacturable = ? and txtCodigo = ?";
    private static final String COLUMNA_CODIGO = "txtCodigo";
    private static final String COLUMNA_NOMBRE = "txtNombre";
    private static final String COLUMNA_PROCESO = "txtProceso";
    private static final String COLUMNA_FACTURABLE = "txtFacturable";
    private static final String COLUMNA_MODO_INGRESO_CONSUMOS = "txtModoIngresoConsumos";

    @Override
    public List<Servicio> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Servicio> servicios = new ArrayList<Servicio>();
        Servicio servicio = null;
        final String FACTURABLE = "S";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            ps.setString(1, FACTURABLE);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicio = new Servicio();
                    
                    servicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    servicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    servicio.setProceso(rs.getString(COLUMNA_PROCESO));
                    servicio.setFacturable(rs.getString(COLUMNA_FACTURABLE));
                    servicio.setModoIngresoConsumos(rs.getString(COLUMNA_MODO_INGRESO_CONSUMOS));
                    servicios.add(servicio);
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
        
        return servicios;
    }

    @Override
    public Servicio obtenerUno(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Servicio servicio = null;
        final String FACTURABLE = "S";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setString(1, FACTURABLE);
            ps.setString(2, strCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){       
                servicio = new Servicio();

                servicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                servicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                servicio.setProceso(rs.getString(COLUMNA_PROCESO));
                servicio.setFacturable(rs.getString(COLUMNA_FACTURABLE));
                servicio.setModoIngresoConsumos(rs.getString(COLUMNA_MODO_INGRESO_CONSUMOS));                     
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
        
        return servicio;
    }

    @Override
    public List<Servicio> obtenerPorTipoFacturacion(String strIdTipoFacturacion) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Servicio> servicios = new ArrayList<Servicio>();
        Servicio servicio = null;
        final String FACTURABLE = "S";
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_TIPO_FACTURACION);
            ps.setString(1, FACTURABLE);
            ps.setString(2, strIdTipoFacturacion);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicio = new Servicio();
                    
                    servicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    servicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    servicios.add(servicio);
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
        
        return servicios;
    }
    
}
