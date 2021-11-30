/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.InsumoServicioDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.InsumoServicio;
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
public class InsumoServicioDAOImpl extends JDBCConnectionPool implements InsumoServicioDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_insumos_servicios ORDER BY txtNombre";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_insumos_servicios ORDER BY txtNombre LIMIT ?,?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_insumos_servicios WHERE txtCodigo = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_insumos_servicios(txtCodigo,txtNombre,txtUnidadMedida,txtPresentacion,intCostoUnitario,intCantidadDisponible) VALUES(?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_insumos_servicios SET txtNombre = ?, txtUnidadMedida=?, txtPresentacion=?, intCostoUnitario=?, intCantidadDisponible=? WHERE txtCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_insumos_servicios WHERE txtCodigo = ?";
    private static final String COLUMNA_CODIGO = "txtCodigo";
    private static final String COLUMNA_NOMBRE = "txtNombre";
    private static final String COLUMNA_UNIDAD_MEDIDA= "txtUnidadMedida";
    private static final String COLUMNA_PRESENTACION = "txtPresentacion";
    private static final String COLUMA_COSTO_UNITARIO = "intCostoUnitario";
    private static final String COLUMNA_CANTIDAD_DISPONIBLE = "intCantidadDisponible";

    @Override
    public List<InsumoServicio> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<InsumoServicio> insumosServicios = new ArrayList<InsumoServicio>();
        InsumoServicio insumoServicio = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    insumoServicio = new InsumoServicio();
                    
                    insumoServicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    insumoServicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    insumoServicio.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    insumoServicio.setPresentacion(rs.getString(COLUMNA_PRESENTACION));
                    insumoServicio.setCostoUnitario(rs.getLong(COLUMA_COSTO_UNITARIO));
                    insumoServicio.setCantidadDisponible(rs.getInt(COLUMNA_CANTIDAD_DISPONIBLE));
                    insumosServicios.add(insumoServicio);
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
        
        return insumosServicios;
    }

    @Override
    public InsumoServicio obtenerUno(String strCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InsumoServicio insumoServicio = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setString(1, strCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){              
                    insumoServicio = new InsumoServicio();
                    
                    insumoServicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    insumoServicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    insumoServicio.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    insumoServicio.setPresentacion(rs.getString(COLUMNA_PRESENTACION));
                    insumoServicio.setCostoUnitario(rs.getLong(COLUMA_COSTO_UNITARIO));
                    insumoServicio.setCantidadDisponible(rs.getInt(COLUMNA_CANTIDAD_DISPONIBLE));                
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
        
        return insumoServicio;
    }

    @Override
    public void insertar(InsumoServicio insumoServicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, insumoServicio.getCodigo());        
            ps.setString(2, insumoServicio.getNombre());
            ps.setString(3, insumoServicio.getUnidadMedida());
            ps.setString(4, insumoServicio.getPresentacion());
            ps.setLong(5, insumoServicio.getCostoUnitario());
            ps.setInt(6, insumoServicio.getCantidadDisponible());
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
    public void actualizar(InsumoServicio insumoServicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);                
            ps.setString(1, insumoServicio.getNombre());
            ps.setString(2, insumoServicio.getUnidadMedida());
            ps.setString(3, insumoServicio.getPresentacion());
            ps.setLong(4, insumoServicio.getCostoUnitario());
            ps.setInt(5, insumoServicio.getCantidadDisponible());
            ps.setString(6, insumoServicio.getCodigo());    
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
    public List<InsumoServicio> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<InsumoServicio> insumosServicios = new ArrayList<InsumoServicio>();
        InsumoServicio insumoServicio = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    insumoServicio = new InsumoServicio();
                    
                    insumoServicio.setCodigo(rs.getString(COLUMNA_CODIGO));
                    insumoServicio.setNombre(rs.getString(COLUMNA_NOMBRE));
                    insumoServicio.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    insumoServicio.setPresentacion(rs.getString(COLUMNA_PRESENTACION));
                    insumoServicio.setCostoUnitario(rs.getLong(COLUMA_COSTO_UNITARIO));
                    insumoServicio.setCantidadDisponible(rs.getInt(COLUMNA_CANTIDAD_DISPONIBLE));
                    insumosServicios.add(insumoServicio);
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
        
        return insumosServicios;
    }
}
