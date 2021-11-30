/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ServicioXUnidadDAO;
import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.ServicioXUnidad;
import co.edu.udea.facturacion.dto.UnidadMedida;
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
public class ServicioXUnidadDAOImpl extends JDBCConnectionPool implements ServicioXUnidadDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_servicios_x_unidades ORDER BY intCodigo";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_servicios_x_unidades ORDER BY intCodigo LIMIT ?,?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_servicios_x_unidades WHERE intCodigo = ?";    
    private static final String OBTENER_POR_SERVICIO_SUBSERVICIO_UNIDAD ="SELECT * FROM facturacion_servicios.tbl_servicios_x_unidades WHERE txtServicio=? and txtSubservicio=? and txtUnidadMedida=?";
    private static final String OBTENER_UNIDADES_USUARIO_POR_SERVICIO_SUBSERVICIO="SELECT txtUnidadMedida FROM facturacion_servicios.tbl_servicios_x_unidades WHERE txtServicio = ? AND txtSubservicio = ? GROUP BY txtUnidadMedida ORDER BY txtUnidadMedida";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_servicios_x_unidades(txtServicio,txtSubservicio,txtUnidadMedida,intValorUnidad) VALUES(?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_servicios_x_unidades SET txtServicio = ?, txtSubservicio=?, txtUnidadMedida=?, intValorUnidad=? WHERE intCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_servicios_x_unidades WHERE intCodigo = ?";
    private static final String COLUMNA_CODIGO = "intCodigo";
    private static final String COLUMNA_SERVICIO = "txtServicio";
    private static final String COLUMNA_SUBSERVICIO = "txtSubservicio";
    private static final String COLUMNA_UNIDAD_MEDIDA = "txtUnidadMedida";
    private static final String COLUMNA_VALOR_UNIDAD = "intValorUnidad";

    @Override
    public List<ServicioXUnidad> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXUnidad> serviciosXunidades = new ArrayList<ServicioXUnidad>();
        ServicioXUnidad servicioXunidad = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicioXunidad = new ServicioXUnidad();
                    
                    servicioXunidad.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXunidad.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXunidad.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXunidad.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    servicioXunidad.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));                
                    serviciosXunidades.add(servicioXunidad);
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
        
        return serviciosXunidades;
    }

    @Override
    public ServicioXUnidad obtenerUno(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServicioXUnidad servicioXunidad = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setInt(1, intCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){     
                    servicioXunidad = new ServicioXUnidad();                    
                    servicioXunidad.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXunidad.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXunidad.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXunidad.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    servicioXunidad.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));                                         
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
        
        return servicioXunidad;
    }

    @Override
    public ServicioXUnidad obtenerPorServicioSubservicioUnidad(String strServicio, String strSubservicio, String strUnidad) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServicioXUnidad servicioXunidad = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO_SUBSERVICIO_UNIDAD);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            ps.setString(3, strUnidad);
            
            rs = ps.executeQuery();
            
            if (rs.next()){     
                    servicioXunidad = new ServicioXUnidad();                    
                    servicioXunidad.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXunidad.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXunidad.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXunidad.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    servicioXunidad.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));                                         
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
        
        return servicioXunidad;
    }

    @Override
    public void insertar(ServicioXUnidad servicioXunidad) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, servicioXunidad.getServicio());
            ps.setString(2, servicioXunidad.getSubservicio());
            ps.setString(3, servicioXunidad.getUnidadMedida());
            ps.setLong(4, servicioXunidad.getValorUnidad());   
  
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
    public void actualizar(ServicioXUnidad servicioXunidad) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);
            ps.setString(1, servicioXunidad.getServicio());
            ps.setString(2, servicioXunidad.getSubservicio());
            ps.setString(3, servicioXunidad.getUnidadMedida());
            ps.setLong(4, servicioXunidad.getValorUnidad());   
            ps.setInt(5, servicioXunidad.getCodigo());
  
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
    public void eliminar(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ELIMINAR);
            ps.setInt(1, intCodigo);        
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
    public List<UnidadMedida> obtenerUnidadesPorServicioSubservicio(String strServicio, String strSubservicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UnidadMedida> unidadesMedida = new ArrayList<UnidadMedida>();
        UnidadMedida unidadMedida = null;
        String strIdUnidadMedida = null;
        UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAOImpl();
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNIDADES_USUARIO_POR_SERVICIO_SUBSERVICIO);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);          
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                   strIdUnidadMedida = rs.getString(COLUMNA_UNIDAD_MEDIDA);
                   unidadMedida = unidadMedidaDAO.obtenerUna(strIdUnidadMedida);                   
                   unidadesMedida.add(unidadMedida);
                   
                   strIdUnidadMedida = null;
                   unidadMedida = null;
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
        
        return unidadesMedida;
    }

    @Override
    public List<ServicioXUnidad> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXUnidad> serviciosXunidades = new ArrayList<ServicioXUnidad>();
        ServicioXUnidad servicioXunidad = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicioXunidad = new ServicioXUnidad();
                    
                    servicioXunidad.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXunidad.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXunidad.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXunidad.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    servicioXunidad.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));                
                    serviciosXunidades.add(servicioXunidad);
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
        
        return serviciosXunidades;
    }
}
