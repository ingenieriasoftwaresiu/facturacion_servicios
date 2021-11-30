/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.ServicioXTipoUsuarioDAO;
import co.edu.udea.facturacion.dao.TipoUsuarioDAO;
import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.ServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.TipoUsuario;
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
 * @author jorge.correa
 */
public class ServicioXTipoUsuarioDAOImpl extends JDBCConnectionPool implements ServicioXTipoUsuarioDAO{
    
    private static final String OBTENER_TODOS = "SELECT * FROM facturacion_servicios.tbl_servicios_x_tipos_usuarios ORDER BY intCodigo";
    private static final String OBTENER_TODOS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_servicios_x_tipos_usuarios ORDER BY intCodigo LIMIT ?,?";
    private static final String OBTENER_UNO = "SELECT * FROM facturacion_servicios.tbl_servicios_x_tipos_usuarios WHERE intCodigo = ?";    
    private static final String OBTENER_POR_SERVICIO_SUBSERVICIO_TIPO_USUARIO ="SELECT * FROM facturacion_servicios.tbl_servicios_x_tipos_usuarios WHERE txtServicio=? and txtSubservicio=? and txtTipoUsuario=?";
    private static final String OBTENER_POR_SERVICIO_SUBSERVICIO_TIPO_USUARIO_UNIDAD ="SELECT * FROM facturacion_servicios.tbl_servicios_x_tipos_usuarios WHERE txtServicio=? and txtSubservicio=? and txtTipoUsuario=? and txtUnidadMedida=?";
    private static final String OBTENER_TIPOS_USUARIO_POR_SERVICIO_SUBSERVICIO="SELECT txtTipoUsuario FROM facturacion_servicios.tbl_servicios_x_tipos_usuarios WHERE txtServicio = ? and txtSubservicio = ? GROUP BY txtTipoUsuario ORDER BY txtTipoUsuario";
    private static final String OBTENER_UNIDADES_USUARIO_POR_SERVICIO_SUBSERVICIO="SELECT txtUnidadMedida FROM facturacion_servicios.tbl_servicios_x_tipos_usuarios WHERE txtServicio = ? and txtSubservicio = ? and txtTipoUsuario = ? GROUP BY txtUnidadMedida ORDER BY txtUnidadMedida";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_servicios_x_tipos_usuarios(txtServicio,txtSubservicio,txtTipoUsuario,txtUnidadMedida,intValorUnidad) VALUES(?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_servicios_x_tipos_usuarios SET txtServicio = ?, txtSubservicio=?, txtTipoUsuario=?, txtUnidadMedida=?, intValorUnidad=? WHERE intCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_servicios_x_tipos_usuarios WHERE intCodigo = ?";
    private static final String COLUMNA_CODIGO = "intCodigo";
    private static final String COLUMNA_SERVICIO = "txtServicio";
    private static final String COLUMNA_SUBSERVICIO = "txtSubservicio";
    private static final String COLUMNA_TIPO_USUARIO = "txtTipoUsuario";
    private static final String COLUMNA_UNIDAD_MEDIDA = "txtUnidadMedida";
    private static final String COLUMNA_VALOR_UNIDAD = "intValorUnidad";

    @Override
    public List<ServicioXTipoUsuario> obtenerTodos() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXTipoUsuario> serviciosXtipousuarios= new ArrayList<ServicioXTipoUsuario>();
        ServicioXTipoUsuario servicioXtipousuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicioXtipousuario = new ServicioXTipoUsuario();
                    
                    servicioXtipousuario.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXtipousuario.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXtipousuario.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXtipousuario.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    servicioXtipousuario.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    servicioXtipousuario.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));                
                    serviciosXtipousuarios.add(servicioXtipousuario);
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
        
        return serviciosXtipousuarios;
    }

    @Override
    public ServicioXTipoUsuario obtenerUno(Integer intCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServicioXTipoUsuario servicioXtipousuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNO);
            ps.setInt(1, intCodigo);
            
            rs = ps.executeQuery();
            
            if (rs.next()){               
                servicioXtipousuario = new ServicioXTipoUsuario();

                servicioXtipousuario.setCodigo(rs.getInt(COLUMNA_CODIGO));
                servicioXtipousuario.setServicio(rs.getString(COLUMNA_SERVICIO));
                servicioXtipousuario.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                servicioXtipousuario.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                servicioXtipousuario.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                servicioXtipousuario.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));                
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
        
        return servicioXtipousuario;
    }

    @Override
    public ServicioXTipoUsuario obtenerPorServicioSubservicioTipoUsuario(String strServicio, String strSubservicio, String strTipoUsuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServicioXTipoUsuario servicioXtipousuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO_SUBSERVICIO_TIPO_USUARIO);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            ps.setString(3, strTipoUsuario);
            
            rs = ps.executeQuery();
            
            if (rs.next()){               
                servicioXtipousuario = new ServicioXTipoUsuario();

                servicioXtipousuario.setCodigo(rs.getInt(COLUMNA_CODIGO));
                servicioXtipousuario.setServicio(rs.getString(COLUMNA_SERVICIO));
                servicioXtipousuario.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                servicioXtipousuario.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                servicioXtipousuario.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                servicioXtipousuario.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));                       
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
        
        return servicioXtipousuario;
    }
    
    @Override
    public ServicioXTipoUsuario obtenerPorServicioSubservicioTipoUsuarioUnidad(String strServicio, String strSubservicio, String strTipoUsuario, String strUnidad) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServicioXTipoUsuario servicioXtipousuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_POR_SERVICIO_SUBSERVICIO_TIPO_USUARIO_UNIDAD);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            ps.setString(3, strTipoUsuario);
            ps.setString(4, strUnidad);
            
            rs = ps.executeQuery();
            
            if (rs.next()){               
                servicioXtipousuario = new ServicioXTipoUsuario();

                servicioXtipousuario.setCodigo(rs.getInt(COLUMNA_CODIGO));
                servicioXtipousuario.setServicio(rs.getString(COLUMNA_SERVICIO));
                servicioXtipousuario.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                servicioXtipousuario.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                servicioXtipousuario.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                servicioXtipousuario.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));               
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
        
        return servicioXtipousuario;
    }

    @Override
    public void insertar(ServicioXTipoUsuario servicioXtipousuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(INSERTAR);
            ps.setString(1, servicioXtipousuario.getServicio());
            ps.setString(2, servicioXtipousuario.getSubservicio());
            ps.setString(3, servicioXtipousuario.getTipoUsuario());
            ps.setString(4, servicioXtipousuario.getUnidadMedida());
            ps.setLong(5, servicioXtipousuario.getValorUnidad());   
  
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
    public void actualizar(ServicioXTipoUsuario servicioXtipousuario) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ACTUALIZAR);
            ps.setString(1, servicioXtipousuario.getServicio());
            ps.setString(2, servicioXtipousuario.getSubservicio());
            ps.setString(3, servicioXtipousuario.getTipoUsuario());
            ps.setString(4, servicioXtipousuario.getUnidadMedida());
            ps.setLong(5, servicioXtipousuario.getValorUnidad());  
            ps.setInt(6, servicioXtipousuario.getCodigo());
  
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
    public List<TipoUsuario> obtenerTiposUsuarioPorServicioSubservicio(String strServicio, String strSubservicio) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TipoUsuario> tiposUsuario = new ArrayList<TipoUsuario>();
        TipoUsuario tipoUsuario = null;
        String strIdTipoUsuario = null;
        TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAOImpl();
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TIPOS_USUARIO_POR_SERVICIO_SUBSERVICIO);
            ps.setString(1, strServicio);
            ps.setString(2, strSubservicio);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                   strIdTipoUsuario = rs.getString(COLUMNA_TIPO_USUARIO);
                   tipoUsuario = tipoUsuarioDAO.obtenerUno(strIdTipoUsuario);                   
                   tiposUsuario.add(tipoUsuario);
                   
                   strIdTipoUsuario = null;
                   tipoUsuario = null;
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
        
        return tiposUsuario;
    }

    @Override
    public List<UnidadMedida> obtenerUnidadesPorServicioSubservicioTipoUsuario(String strServicio, String strSubservicio, String strTipoUsuario) throws GIDaoException {
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
            ps.setString(3, strTipoUsuario);
            
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
    public List<ServicioXTipoUsuario> obtenerTodosPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicioXTipoUsuario> serviciosXtipousuarios= new ArrayList<ServicioXTipoUsuario>();
        ServicioXTipoUsuario servicioXtipousuario = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    servicioXtipousuario = new ServicioXTipoUsuario();
                    
                    servicioXtipousuario.setCodigo(rs.getInt(COLUMNA_CODIGO));
                    servicioXtipousuario.setServicio(rs.getString(COLUMNA_SERVICIO));
                    servicioXtipousuario.setSubservicio(rs.getString(COLUMNA_SUBSERVICIO));
                    servicioXtipousuario.setTipoUsuario(rs.getString(COLUMNA_TIPO_USUARIO));
                    servicioXtipousuario.setUnidadMedida(rs.getString(COLUMNA_UNIDAD_MEDIDA));
                    servicioXtipousuario.setValorUnidad(rs.getLong(COLUMNA_VALOR_UNIDAD));                
                    serviciosXtipousuarios.add(servicioXtipousuario);
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
        
        return serviciosXtipousuarios;
    }
}
