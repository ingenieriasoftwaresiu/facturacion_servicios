/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.SubservicioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.Subservicio;
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
public class SubservicioDAOImpl extends JDBCConnectionPool implements SubservicioDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_subservicios ORDER BY txtNombre";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_subservicios ORDER BY txtNombre LIMIT ?,?";
    private static final String OBTENER_POR_SERVICIO = "SELECT * FROM facturacion_servicios.tbl_subservicios WHERE txtServicioPadre = ?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_subservicios WHERE txtCodigo = ?";
    private static final String OBTENER_POR_SERVICIO_SUBSERVICIO= "SELECT * FROM facturacion_servicios.tbl_subservicios WHERE txtServicioPadre = ? and txtCodigo = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_subservicios(txtCodigo,txtNombre,txtTipoFacturacion,txtResponsable,txtServicioPadre,txtInsumosFijos,txtAplicaSubcantidad,txtEtiquetaSubcantidad,txtAplicaPorcentajeSancion) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_subservicios SET txtNombre=?, txtTipoFacturacion=?, txtResponsable=?, txtServicioPadre=?, txtInsumosFijos=?, txtAplicaSubcantidad=?, txtEtiquetaSubcantidad=?, txtAplicaPorcentajeSancion=? WHERE txtCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_subservicios WHERE txtCodigo = ?";
    private static final String COLUMNA_CODIGO = "txtCodigo";
    private static final String COLUMNA_NOMBRE = "txtNombre";
    private static final String COLUMNA_TIPO_FACTURACION = "txtTipoFacturacion";
    private static final String COLUMNA_RESPONSABLE = "txtResponsable";
    private static final String COLUMA_SERVICIO_PADRE = "txtServicioPadre";
    private static final String COLUMNA_INSUMOS_FIJOS = "txtInsumosFijos";
    private static final String COLUMNA_APLICA_SUBCANTIDAD = "txtAplicaSubcantidad";
    private static final String COLUMNA_ETIQUETA_SUBCANTIDAD = "txtEtiquetaSubcantidad";
    private static final String COLUMNA_APLICA_PORCENTAJE_SANCION = "txtAplicaPorcentajeSancion";
    
    @Override
    public List<Subservicio> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Subservicio> subservicios = new ArrayList<Subservicio>();
        Subservicio subservicio = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    subservicio = new Subservicio();
                    
                    subservicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    subservicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    subservicio.setTipoFacturacion(rs.getString(COLUMNA_TIPO_FACTURACION));
                    subservicio.setResponsable(rs.getString(COLUMNA_RESPONSABLE));
                    subservicio.setServicioPadre(rs.getString(COLUMA_SERVICIO_PADRE));
                    subservicio.setInsumosFijos(rs.getString(COLUMNA_INSUMOS_FIJOS));
                    subservicio.setAplicaSubcantidad(rs.getString(COLUMNA_APLICA_SUBCANTIDAD));
                    subservicio.setEtiquetaSubcantidad(rs.getString(COLUMNA_ETIQUETA_SUBCANTIDAD));
                    subservicio.setAplicaPorcentajeSancion(rs.getString(COLUMNA_APLICA_PORCENTAJE_SANCION));
                    subservicios.add(subservicio);
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
        
        return subservicios;
    }

    @Override
    public Subservicio obtenerUno(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Subservicio subservicio = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setString(1, strCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){  
                    subservicio = new Subservicio();
                    
                    subservicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    subservicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    subservicio.setTipoFacturacion(rs.getString(COLUMNA_TIPO_FACTURACION));
                    subservicio.setResponsable(rs.getString(COLUMNA_RESPONSABLE));
                    subservicio.setServicioPadre(rs.getString(COLUMA_SERVICIO_PADRE));
                    subservicio.setInsumosFijos(rs.getString(COLUMNA_INSUMOS_FIJOS));     
                    subservicio.setAplicaSubcantidad(rs.getString(COLUMNA_APLICA_SUBCANTIDAD));
                    subservicio.setEtiquetaSubcantidad(rs.getString(COLUMNA_ETIQUETA_SUBCANTIDAD));
                    subservicio.setAplicaPorcentajeSancion(rs.getString(COLUMNA_APLICA_PORCENTAJE_SANCION));
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
        
        return subservicio;
    }
    
     @Override
    public Subservicio obtenerPorServicioSubservicio(String strServicio, String strSubservicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Subservicio subservicio = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO_SUBSERVICIO);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            
            rs = ps.executeQuery();
            
            if (rs.next()){  
                    subservicio = new Subservicio();
                    
                    subservicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    subservicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    subservicio.setTipoFacturacion(rs.getString(COLUMNA_TIPO_FACTURACION));
                    subservicio.setResponsable(rs.getString(COLUMNA_RESPONSABLE));
                    subservicio.setServicioPadre(rs.getString(COLUMA_SERVICIO_PADRE));
                    subservicio.setInsumosFijos(rs.getString(COLUMNA_INSUMOS_FIJOS));         
                    subservicio.setAplicaSubcantidad(rs.getString(COLUMNA_APLICA_SUBCANTIDAD));
                    subservicio.setEtiquetaSubcantidad(rs.getString(COLUMNA_ETIQUETA_SUBCANTIDAD));
                    subservicio.setAplicaPorcentajeSancion(rs.getString(COLUMNA_APLICA_PORCENTAJE_SANCION));
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
        
        return subservicio;
    }

    @Override
    public void insertar(Subservicio subservicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, subservicio.getCodigo());        
            ps.setString(2, subservicio.getNombre());
            ps.setString(3, subservicio.getTipoFacturacion());
            ps.setString(4, subservicio.getResponsable());
            ps.setString(5, subservicio.getServicioPadre());
            ps.setString(6, subservicio.getInsumosFijos());
            ps.setString(7, subservicio.getAplicaSubcantidad());
            ps.setString(8, subservicio.getEtiquetaSubcantidad());
            ps.setString(9, subservicio.getAplicaPorcentajeSancion());
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
    public void actualizar(Subservicio subservicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);    
            ps.setString(1, subservicio.getNombre());
            ps.setString(2, subservicio.getTipoFacturacion());
            ps.setString(3, subservicio.getResponsable());
            ps.setString(4, subservicio.getServicioPadre());
            ps.setString(5, subservicio.getInsumosFijos());
            ps.setString(6, subservicio.getAplicaSubcantidad());
            ps.setString(7, subservicio.getEtiquetaSubcantidad());
            ps.setString(8, subservicio.getAplicaPorcentajeSancion());
            ps.setString(9, subservicio.getCodigo());                
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
    public List<Subservicio> obtenerPorServicio(String strServicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Subservicio> subservicios = new ArrayList<Subservicio>();
        Subservicio subservicio = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO);
            ps.setString(1, strServicio);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    subservicio = new Subservicio();
                    
                    subservicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    subservicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    subservicio.setTipoFacturacion(rs.getString(COLUMNA_TIPO_FACTURACION));
                    subservicio.setResponsable(rs.getString(COLUMNA_RESPONSABLE));
                    subservicio.setServicioPadre(rs.getString(COLUMA_SERVICIO_PADRE));
                    subservicio.setInsumosFijos(rs.getString(COLUMNA_INSUMOS_FIJOS));
                    subservicio.setAplicaSubcantidad(rs.getString(COLUMNA_APLICA_SUBCANTIDAD));
                    subservicio.setEtiquetaSubcantidad(rs.getString(COLUMNA_ETIQUETA_SUBCANTIDAD));
                    subservicio.setAplicaPorcentajeSancion(rs.getString(COLUMNA_APLICA_PORCENTAJE_SANCION));
                    subservicios.add(subservicio);
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
        
        return subservicios;
    }

    @Override
    public List<Subservicio> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Subservicio> subservicios = new ArrayList<Subservicio>();
        Subservicio subservicio = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    subservicio = new Subservicio();
                    
                    subservicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    subservicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    subservicio.setTipoFacturacion(rs.getString(COLUMNA_TIPO_FACTURACION));
                    subservicio.setResponsable(rs.getString(COLUMNA_RESPONSABLE));
                    subservicio.setServicioPadre(rs.getString(COLUMA_SERVICIO_PADRE));
                    subservicio.setInsumosFijos(rs.getString(COLUMNA_INSUMOS_FIJOS));
                    subservicio.setAplicaSubcantidad(rs.getString(COLUMNA_APLICA_SUBCANTIDAD));
                    subservicio.setEtiquetaSubcantidad(rs.getString(COLUMNA_ETIQUETA_SUBCANTIDAD));
                    subservicio.setAplicaPorcentajeSancion(rs.getString(COLUMNA_APLICA_PORCENTAJE_SANCION));
                    subservicios.add(subservicio);
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
        
        return subservicios;
    }
}
