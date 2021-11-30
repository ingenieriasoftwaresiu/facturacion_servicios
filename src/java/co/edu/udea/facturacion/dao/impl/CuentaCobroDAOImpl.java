/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.CuentaCobroDAO;
import co.edu.udea.facturacion.dao.cnf.JDBCConnectionPool;
import co.edu.udea.facturacion.dto.CuentaCobro;
import co.edu.udea.facturacion.dto.ParametroBusquedaRegistro;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public class CuentaCobroDAOImpl extends JDBCConnectionPool implements CuentaCobroDAO{

    private static final String OBTENER_TODAS = "SELECT * FROM facturacion_servicios.tbl_cuentas_cobro ORDER BY lgCodigo";
    private static final String OBTENER_TODAS_POR_PAGINAS = "SELECT * FROM facturacion_servicios.tbl_cuentas_cobro ORDER BY lgCodigo LIMIT ?,?";
    private static final String OBTENER_UNA = "SELECT * FROM facturacion_servicios.tbl_cuentas_cobro WHERE lgCodigo = ?";
    private static final String VALIDAR_INSERCION = "SELECT count(*) as TOTAL from facturacion_servicios.tbl_cuentas_cobro WHERE txtTipoUsuarioConsumo = ? and txtUsuarioConsumo = ? and dtFechaInicioPeriodo = ? and dtFechaFinPeriodo = ?";
    private static final String INSERTAR = "INSERT INTO facturacion_servicios.tbl_cuentas_cobro(txtTipoUsuarioConsumo,txtUsuarioConsumo,dtFechaCreacion,txtUsuarioCreacion,dtFechaLimitePago,dtFechaInicioPeriodo,dtFechaFinPeriodo,txtNumeroSoporte,dtFechaSoporte,bdValorSoporte,txtAcuerdoCobro,txtDependenciaB,txtCentroCostosB,txtDependenciaP,txtCentroCostosP,txtNombreOrdenadorGasto,txtCargoOrdenadorGasto,txtObservacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE facturacion_servicios.tbl_cuentas_cobro SET txtTipoUsuarioConsumo=?,txtUsuarioConsumo=?,dtFechaCreacion=?,txtUsuarioCreacion=?,dtFechaLimitePago=?,dtFechaInicioPeriodo=?,dtFechaFinPeriodo=?,txtNumeroSoporte=?,dtFechaSoporte=?,bdValorSoporte=?,txtAcuerdoCobro=?,txtDependenciaB=?,txtCentroCostosB=?,txtDependenciaP=?,txtCentroCostosP=?,txtNombreOrdenadorGasto=?,txtCargoOrdenadorGasto=?, txtObservacion=? WHERE lgCodigo = ?";
    private static final String ELIMINAR = "DELETE FROM facturacion_servicios.tbl_cuentas_cobro WHERE lgCodigo = ?";
    private static final String COLUMNA_CODIGO = "lgCodigo";
    private static final String COLUMNA_TIPO_USUARIO_CONSUMO = "txtTipoUsuarioConsumo";
    private static final String COLUMNA_USUARIO_CONSUMO = "txtUsuarioConsumo";
    private static final String COLUMNA_FECHA_CREACION = "dtFechaCreacion";
    private static final String COLUMNA_USUARIO_CREACION = "txtUsuarioCreacion";
    private static final String COLUMNA_FECHA_LIMITE_PAGO = "dtFechaLimitePago";
    private static final String COLUMNA_FECHA_INICIO_PERIODO = "dtFechaInicioPeriodo";
    private static final String COLUMNA_FECHA_FIN_PERIODO = "dtFechaFinPeriodo";
    private static final String COLUMNA_NUMERO_SOPORTE = "txtNumeroSoporte";   
    private static final String COLUMNA_FECHA_SOPORTE = "dtFechaSoporte"; 
    private static final String COLUMNA_VALOR_SOPORTE = "bdValorSoporte"; 
    private static final String COLUMNA_ACUERDO_COBRO = "txtAcuerdoCobro"; 
    private static final String COLUMNA_DEPENDENCIA_BENEFICIARIA = "txtDependenciaB"; 
    private static final String COLUMNA_CENTRO_COSTOS_BENEFICIARIO = "txtCentroCostosB"; 
    private static final String COLUMNA_DEPENDENCIA_PAGADORA  = "txtDependenciaP"; 
    private static final String COLUMNA_CENTRO_COSTOS_PAGADOR = "txtCentroCostosP"; 
    private static final String COLUMNA_NOMBRE_ORDENADOR_GASTO = "txtNombreOrdenadorGasto"; 
    private static final String COLUMNA_CARGO_ORDENADOR_GASTO = "txtCargoOrdenadorGasto"; 
    private static final String COLUMNA_OBSERVACION = "txtObservacion"; 
    private static final String COLUMNA_TOTAL = "TOTAL";  
    
    @Override
    public List<CuentaCobro> obtenerTodas() throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CuentaCobro> cuentasCobro = new ArrayList<CuentaCobro>();
        CuentaCobro cuentaCobro = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODAS);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    cuentaCobro = new CuentaCobro();
                    
                    cuentaCobro.setCodigo(rs.getLong(COLUMNA_CODIGO));
                    cuentaCobro.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    cuentaCobro.setUsuarioConsumo(rs.getString(COLUMNA_USUARIO_CONSUMO));
                    cuentaCobro.setFechaCreacion(rs.getDate(COLUMNA_FECHA_CREACION));
                    cuentaCobro.setUsuarioCreacion(rs.getString(COLUMNA_USUARIO_CREACION));
                    cuentaCobro.setFechaLimitePago(rs.getDate(COLUMNA_FECHA_LIMITE_PAGO));
                    cuentaCobro.setFechaInicioPeriodo(rs.getDate(COLUMNA_FECHA_INICIO_PERIODO));
                    cuentaCobro.setFechaFinPeriodo(rs.getDate(COLUMNA_FECHA_FIN_PERIODO));
                    cuentaCobro.setNumeroSoporte(rs.getString(COLUMNA_NUMERO_SOPORTE));
                    cuentaCobro.setFechaSoporte(rs.getDate(COLUMNA_FECHA_SOPORTE));
                    cuentaCobro.setValorSoporte(rs.getBigDecimal(COLUMNA_VALOR_SOPORTE));
                    cuentaCobro.setAcuerdoCobro(rs.getString(COLUMNA_ACUERDO_COBRO));
                    cuentaCobro.setDependenciaBeneficiaria(rs.getString(COLUMNA_DEPENDENCIA_BENEFICIARIA));
                    cuentaCobro.setCentroCostosBeneficiario(rs.getString(COLUMNA_CENTRO_COSTOS_BENEFICIARIO));
                    cuentaCobro.setDependenciaPagadora(rs.getString(COLUMNA_DEPENDENCIA_PAGADORA));
                    cuentaCobro.setCentroCostosPagador(rs.getString(COLUMNA_CENTRO_COSTOS_PAGADOR));
                    cuentaCobro.setNombreOrdenadorGasto(rs.getString(COLUMNA_NOMBRE_ORDENADOR_GASTO));
                    cuentaCobro.setCargoOrdenadorGasto(rs.getString(COLUMNA_CARGO_ORDENADOR_GASTO));
                    cuentaCobro.setObservacion(rs.getString(COLUMNA_OBSERVACION));
                    cuentasCobro.add(cuentaCobro);
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
        
        return cuentasCobro;
    }

    @Override
    public CuentaCobro obtenerUna(Long lgCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        CuentaCobro cuentaCobro = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_UNA);
            ps.setLong(1, lgCodigo);
            
            rs = ps.executeQuery();            
            
            if (rs.next()){                
                    cuentaCobro = new CuentaCobro();
                    
                    cuentaCobro.setCodigo(rs.getLong(COLUMNA_CODIGO));
                    cuentaCobro.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    cuentaCobro.setUsuarioConsumo(rs.getString(COLUMNA_USUARIO_CONSUMO));
                    cuentaCobro.setFechaCreacion(rs.getDate(COLUMNA_FECHA_CREACION));
                    cuentaCobro.setUsuarioCreacion(rs.getString(COLUMNA_USUARIO_CREACION));
                    cuentaCobro.setFechaLimitePago(rs.getDate(COLUMNA_FECHA_LIMITE_PAGO));
                    cuentaCobro.setFechaInicioPeriodo(rs.getDate(COLUMNA_FECHA_INICIO_PERIODO));
                    cuentaCobro.setFechaFinPeriodo(rs.getDate(COLUMNA_FECHA_FIN_PERIODO));
                    cuentaCobro.setNumeroSoporte(rs.getString(COLUMNA_NUMERO_SOPORTE));               
                    cuentaCobro.setFechaSoporte(rs.getDate(COLUMNA_FECHA_SOPORTE));
                    cuentaCobro.setValorSoporte(rs.getBigDecimal(COLUMNA_VALOR_SOPORTE));
                    cuentaCobro.setAcuerdoCobro(rs.getString(COLUMNA_ACUERDO_COBRO));
                    cuentaCobro.setDependenciaBeneficiaria(rs.getString(COLUMNA_DEPENDENCIA_BENEFICIARIA));
                    cuentaCobro.setCentroCostosBeneficiario(rs.getString(COLUMNA_CENTRO_COSTOS_BENEFICIARIO));
                    cuentaCobro.setDependenciaPagadora(rs.getString(COLUMNA_DEPENDENCIA_PAGADORA));
                    cuentaCobro.setCentroCostosPagador(rs.getString(COLUMNA_CENTRO_COSTOS_PAGADOR));
                    cuentaCobro.setNombreOrdenadorGasto(rs.getString(COLUMNA_NOMBRE_ORDENADOR_GASTO));
                    cuentaCobro.setCargoOrdenadorGasto(rs.getString(COLUMNA_CARGO_ORDENADOR_GASTO));
                    cuentaCobro.setObservacion(rs.getString(COLUMNA_OBSERVACION));
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
        
        return cuentaCobro;
    }

    @Override
    public Long insertar(CuentaCobro cuentaCobro) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaCreacion = null;
        java.sql.Date dtFechaLimitePago = null;
        java.sql.Date dtFechaInicioPeriodo = null;
        java.sql.Date dtFechaFinPeriodo = null;
        java.sql.Date dtFechaSoporte = null;
        Long lgNroConsecutivo = null;
        ResultSet rs =null;
        
        try{
            con = getConexion();
            ps = con.prepareStatement(INSERTAR,ps.RETURN_GENERATED_KEYS);
            
            ps.setString(1, cuentaCobro.getTipoUsuarioConsumo());                    
            ps.setString(2, cuentaCobro.getUsuarioConsumo()); 
            dtFechaCreacion = new java.sql.Date(cuentaCobro.getFechaCreacion().getTime());
            ps.setDate(3, dtFechaCreacion); 
            ps.setString(4, cuentaCobro.getUsuarioCreacion()); 
            dtFechaLimitePago = new java.sql.Date(cuentaCobro.getFechaLimitePago().getTime());
            ps.setDate(5, dtFechaLimitePago); 
            dtFechaInicioPeriodo = new java.sql.Date(cuentaCobro.getFechaInicioPeriodo().getTime());
            ps.setDate(6, dtFechaInicioPeriodo); 
            dtFechaFinPeriodo = new java.sql.Date(cuentaCobro.getFechaFinPeriodo().getTime());
            ps.setDate(7, dtFechaFinPeriodo); 
            ps.setString(8, cuentaCobro.getNumeroSoporte()); 
            if (cuentaCobro.getFechaSoporte() == null){
                dtFechaSoporte = null;
            }else{
                dtFechaSoporte = new java.sql.Date(cuentaCobro.getFechaSoporte().getTime());
            }            
            ps.setDate(9, dtFechaSoporte); 
            ps.setBigDecimal(10, cuentaCobro.getValorSoporte());
            ps.setString(11, cuentaCobro.getAcuerdoCobro());
            ps.setString(12, cuentaCobro.getDependenciaBeneficiaria());
            ps.setString(13, cuentaCobro.getCentroCostosBeneficiario());
            ps.setString(14, cuentaCobro.getDependenciaPagadora());
            ps.setString(15, cuentaCobro.getCentroCostosPagador());
            ps.setString(16, cuentaCobro.getNombreOrdenadorGasto());
            ps.setString(17, cuentaCobro.getCargoOrdenadorGasto());
            ps.setString(18, cuentaCobro.getObservacion());
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
               lgNroConsecutivo = rs.getLong(1);               
            }
            
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
        
        return lgNroConsecutivo;
    }

    @Override
    public void actualizar(CuentaCobro cuentaCobro) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        java.sql.Date dtFechaCreacion = null;
        java.sql.Date dtFechaLimitePago = null;
        java.sql.Date dtFechaInicioPeriodo = null;
        java.sql.Date dtFechaFinPeriodo = null;        
        java.sql.Date dtFechaSoporte = null;
        
        try{
            con = getConexion();
            ps = con.prepareStatement(ACTUALIZAR);
            
            ps.setString(1, cuentaCobro.getTipoUsuarioConsumo());                    
            ps.setString(2, cuentaCobro.getUsuarioConsumo()); 
            dtFechaCreacion = new java.sql.Date(cuentaCobro.getFechaCreacion().getTime());
            ps.setDate(3, dtFechaCreacion); 
            ps.setString(4, cuentaCobro.getUsuarioCreacion()); 
            dtFechaLimitePago = new java.sql.Date(cuentaCobro.getFechaLimitePago().getTime());
            ps.setDate(5, dtFechaLimitePago); 
            dtFechaInicioPeriodo = new java.sql.Date(cuentaCobro.getFechaInicioPeriodo().getTime());
            ps.setDate(6, dtFechaInicioPeriodo); 
            dtFechaFinPeriodo = new java.sql.Date(cuentaCobro.getFechaFinPeriodo().getTime());
            ps.setDate(7, dtFechaFinPeriodo); 
            ps.setString(8, cuentaCobro.getNumeroSoporte()); 
            if (cuentaCobro.getFechaSoporte() == null){
                dtFechaSoporte = null;
            }else{
                dtFechaSoporte = new java.sql.Date(cuentaCobro.getFechaSoporte().getTime());
            }            
            ps.setDate(9, dtFechaSoporte); 
            ps.setBigDecimal(10, cuentaCobro.getValorSoporte());
            ps.setString(11, cuentaCobro.getAcuerdoCobro());
            ps.setString(12, cuentaCobro.getDependenciaBeneficiaria());
            ps.setString(13, cuentaCobro.getCentroCostosBeneficiario());
            ps.setString(14, cuentaCobro.getDependenciaPagadora());
            ps.setString(15, cuentaCobro.getCentroCostosPagador());
            ps.setString(16, cuentaCobro.getNombreOrdenadorGasto());
            ps.setString(17, cuentaCobro.getCargoOrdenadorGasto());
            ps.setString(18, cuentaCobro.getObservacion());
            ps.setLong(19, cuentaCobro.getCodigo());
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
    public void eliminar(Long lgCodigo) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(ELIMINAR);
            ps.setLong(1, lgCodigo);        
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
    public List<CuentaCobro> obtenerTodasPorPaginas(Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CuentaCobro> cuentasCobro = new ArrayList<CuentaCobro>();
        CuentaCobro cuentaCobro = null;
        
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODAS_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    cuentaCobro = new CuentaCobro();                    
                    
                    cuentaCobro.setCodigo(rs.getLong(COLUMNA_CODIGO));
                    cuentaCobro.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    cuentaCobro.setUsuarioConsumo(rs.getString(COLUMNA_USUARIO_CONSUMO));
                    cuentaCobro.setFechaCreacion(rs.getDate(COLUMNA_FECHA_CREACION));
                    cuentaCobro.setUsuarioCreacion(rs.getString(COLUMNA_USUARIO_CREACION));
                    cuentaCobro.setFechaLimitePago(rs.getDate(COLUMNA_FECHA_LIMITE_PAGO));
                    cuentaCobro.setFechaInicioPeriodo(rs.getDate(COLUMNA_FECHA_INICIO_PERIODO));
                    cuentaCobro.setFechaFinPeriodo(rs.getDate(COLUMNA_FECHA_FIN_PERIODO));
                    cuentaCobro.setNumeroSoporte(rs.getString(COLUMNA_NUMERO_SOPORTE));
                    cuentaCobro.setFechaSoporte(rs.getDate(COLUMNA_FECHA_SOPORTE));
                    cuentaCobro.setValorSoporte(rs.getBigDecimal(COLUMNA_VALOR_SOPORTE));
                    cuentaCobro.setAcuerdoCobro(rs.getString(COLUMNA_ACUERDO_COBRO));
                    cuentaCobro.setDependenciaBeneficiaria(rs.getString(COLUMNA_DEPENDENCIA_BENEFICIARIA));
                    cuentaCobro.setCentroCostosBeneficiario(rs.getString(COLUMNA_CENTRO_COSTOS_BENEFICIARIO));
                    cuentaCobro.setDependenciaPagadora(rs.getString(COLUMNA_DEPENDENCIA_PAGADORA));
                    cuentaCobro.setCentroCostosPagador(rs.getString(COLUMNA_CENTRO_COSTOS_PAGADOR));
                    cuentaCobro.setNombreOrdenadorGasto(rs.getString(COLUMNA_NOMBRE_ORDENADOR_GASTO));
                    cuentaCobro.setCargoOrdenadorGasto(rs.getString(COLUMNA_CARGO_ORDENADOR_GASTO));
                    cuentaCobro.setObservacion(rs.getString(COLUMNA_OBSERVACION));
                    cuentasCobro.add(cuentaCobro);
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
        
        return cuentasCobro;
    }

    @Override
    public Integer validacionInsercion(String strIdTipoConsumo, String strIdUsuario,  Date dtFechaInicio, Date dtFechaFin) throws GIDaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer intCantidadRegistros=0;
                
        try{
            con = getConexion();
            ps = con.prepareCall(VALIDAR_INSERCION);
            ps.setString(1, strIdTipoConsumo);
            ps.setString(2, strIdUsuario);      
            java.sql.Date dateInicio = new java.sql.Date(dtFechaInicio.getTime());      
            ps.setDate(3, dateInicio);
            java.sql.Date dateFin = new java.sql.Date(dtFechaFin.getTime());   
            ps.setDate(4, dateFin);
                        
            rs = ps.executeQuery();
                        
            if (rs.next()){               
                intCantidadRegistros = Integer.parseInt(rs.getString(COLUMNA_TOTAL));
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
        
        return intCantidadRegistros;
    }

    @Override
    public List<CuentaCobro> obtenerTodosBusqueda(ParametroBusquedaRegistro parametroBusquedaConsumo) throws GIDaoException {
        String OBTENER_TODOS_BUSQUEDA=null;
        List<CuentaCobro> cuentasCobro = new ArrayList<CuentaCobro>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        CuentaCobro cuentaCobro = null;
        
        OBTENER_TODOS_BUSQUEDA = construirConsultaBusquedaCuentasCobro(parametroBusquedaConsumo);
                                     
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_BUSQUEDA);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    cuentaCobro = new CuentaCobro();                    
                    
                    cuentaCobro.setCodigo(rs.getLong(COLUMNA_CODIGO));
                    cuentaCobro.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    cuentaCobro.setUsuarioConsumo(rs.getString(COLUMNA_USUARIO_CONSUMO));
                    cuentaCobro.setFechaCreacion(rs.getDate(COLUMNA_FECHA_CREACION));
                    cuentaCobro.setUsuarioCreacion(rs.getString(COLUMNA_USUARIO_CREACION));
                    cuentaCobro.setFechaLimitePago(rs.getDate(COLUMNA_FECHA_LIMITE_PAGO));
                    cuentaCobro.setFechaInicioPeriodo(rs.getDate(COLUMNA_FECHA_INICIO_PERIODO));
                    cuentaCobro.setFechaFinPeriodo(rs.getDate(COLUMNA_FECHA_FIN_PERIODO));
                    cuentaCobro.setNumeroSoporte(rs.getString(COLUMNA_NUMERO_SOPORTE));
                    cuentaCobro.setFechaSoporte(rs.getDate(COLUMNA_FECHA_SOPORTE));
                    cuentaCobro.setValorSoporte(rs.getBigDecimal(COLUMNA_VALOR_SOPORTE));
                    cuentaCobro.setAcuerdoCobro(rs.getString(COLUMNA_ACUERDO_COBRO));
                    cuentaCobro.setDependenciaBeneficiaria(rs.getString(COLUMNA_DEPENDENCIA_BENEFICIARIA));
                    cuentaCobro.setCentroCostosBeneficiario(rs.getString(COLUMNA_CENTRO_COSTOS_BENEFICIARIO));
                    cuentaCobro.setDependenciaPagadora(rs.getString(COLUMNA_DEPENDENCIA_PAGADORA));
                    cuentaCobro.setCentroCostosPagador(rs.getString(COLUMNA_CENTRO_COSTOS_PAGADOR));
                    cuentaCobro.setNombreOrdenadorGasto(rs.getString(COLUMNA_NOMBRE_ORDENADOR_GASTO));
                    cuentaCobro.setCargoOrdenadorGasto(rs.getString(COLUMNA_CARGO_ORDENADOR_GASTO));
                    cuentaCobro.setObservacion(rs.getString(COLUMNA_OBSERVACION));
                    cuentasCobro.add(cuentaCobro);
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
        
        return cuentasCobro;  
    }

    @Override
    public List<CuentaCobro> obtenerTodosBusquedaPorPaginas(ParametroBusquedaRegistro parametroBusquedaConsumo, Integer intRegistrosAEmpezar, Integer intRegistrosAMostrar) throws GIDaoException {
        String OBTENER_TODOS_BUSQUEDA_POR_PAGINAS=null;
        List<CuentaCobro> cuentasCobro = new ArrayList<CuentaCobro>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;        
        CuentaCobro cuentaCobro = null;
        
        OBTENER_TODOS_BUSQUEDA_POR_PAGINAS = construirConsultaBusquedaCuentasCobro(parametroBusquedaConsumo);
        OBTENER_TODOS_BUSQUEDA_POR_PAGINAS += " LIMIT ?,?";
                                             
        try{
            con = getConexion();
            ps = con.prepareCall(OBTENER_TODOS_BUSQUEDA_POR_PAGINAS);
            ps.setInt(1, intRegistrosAEmpezar);
            ps.setInt(2, intRegistrosAMostrar);
            
            rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    cuentaCobro = new CuentaCobro();                    
                    
                    cuentaCobro.setCodigo(rs.getLong(COLUMNA_CODIGO));
                    cuentaCobro.setTipoUsuarioConsumo(rs.getString(COLUMNA_TIPO_USUARIO_CONSUMO));
                    cuentaCobro.setUsuarioConsumo(rs.getString(COLUMNA_USUARIO_CONSUMO));
                    cuentaCobro.setFechaCreacion(rs.getDate(COLUMNA_FECHA_CREACION));
                    cuentaCobro.setUsuarioCreacion(rs.getString(COLUMNA_USUARIO_CREACION));
                    cuentaCobro.setFechaLimitePago(rs.getDate(COLUMNA_FECHA_LIMITE_PAGO));
                    cuentaCobro.setFechaInicioPeriodo(rs.getDate(COLUMNA_FECHA_INICIO_PERIODO));
                    cuentaCobro.setFechaFinPeriodo(rs.getDate(COLUMNA_FECHA_FIN_PERIODO));
                    cuentaCobro.setNumeroSoporte(rs.getString(COLUMNA_NUMERO_SOPORTE));
                    cuentaCobro.setFechaSoporte(rs.getDate(COLUMNA_FECHA_SOPORTE));
                    cuentaCobro.setValorSoporte(rs.getBigDecimal(COLUMNA_VALOR_SOPORTE));
                    cuentaCobro.setAcuerdoCobro(rs.getString(COLUMNA_ACUERDO_COBRO));
                    cuentaCobro.setDependenciaBeneficiaria(rs.getString(COLUMNA_DEPENDENCIA_BENEFICIARIA));
                    cuentaCobro.setCentroCostosBeneficiario(rs.getString(COLUMNA_CENTRO_COSTOS_BENEFICIARIO));
                    cuentaCobro.setDependenciaPagadora(rs.getString(COLUMNA_DEPENDENCIA_PAGADORA));
                    cuentaCobro.setCentroCostosPagador(rs.getString(COLUMNA_CENTRO_COSTOS_PAGADOR));
                    cuentaCobro.setNombreOrdenadorGasto(rs.getString(COLUMNA_NOMBRE_ORDENADOR_GASTO));
                    cuentaCobro.setCargoOrdenadorGasto(rs.getString(COLUMNA_CARGO_ORDENADOR_GASTO));
                    cuentaCobro.setObservacion(rs.getString(COLUMNA_OBSERVACION));
                    cuentasCobro.add(cuentaCobro);
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
        
        return cuentasCobro;
    }
    
    private String construirConsultaBusquedaCuentasCobro(ParametroBusquedaRegistro parametroBusquedaConsumo){
        
        String strConsecutivo="", strNumSoporte="", strTipoUsuarioB="-1", strUsuarioB="-1", strFechaInicioB="", strFechaFinB="", strConsulta = null;        
        strConsulta = "SELECT * FROM facturacion_servicios.tbl_cuentas_cobro ";
        
        strConsecutivo = parametroBusquedaConsumo.getConsecutivoCuentaCobro();
        strNumSoporte = parametroBusquedaConsumo.getNumeroSoporte();
        strTipoUsuarioB = parametroBusquedaConsumo.getTipoUsuario();
        strUsuarioB = parametroBusquedaConsumo.getUsuario();
        strFechaInicioB = parametroBusquedaConsumo.getFechaInicio();
        strFechaFinB = parametroBusquedaConsumo.getFechaFin();
        
        if (!(strConsecutivo.equals("")) || !(strNumSoporte.equals("")) || !(strTipoUsuarioB.equals("-1")) || !(strUsuarioB.equals("-1")) || !(strFechaInicioB.equals("")) || !(strFechaFinB.equals(""))){
            strConsulta += "where ";
            
            if (!(strConsecutivo.equals(""))){
                strConsulta += COLUMNA_CODIGO + " = '" + strConsecutivo +"' AND ";                
            }
            
            if (!(strNumSoporte.equals(""))){
                strConsulta += COLUMNA_NUMERO_SOPORTE + " like '%" + strNumSoporte + "%' AND ";                
            }
            
            if (!(strTipoUsuarioB.equals("-1"))){
                strConsulta += COLUMNA_TIPO_USUARIO_CONSUMO + " = '" + strTipoUsuarioB + "' AND ";                
            }
            
            if (!(strUsuarioB.equals("-1"))){
                strConsulta += COLUMNA_USUARIO_CONSUMO + " = '" + strUsuarioB + "' AND ";                
            }
            
           if (!(strFechaInicioB.equals("")) && !(strFechaFinB.equals(""))){
                strConsulta += "(" + COLUMNA_FECHA_CREACION + " BETWEEN '" + strFechaInicioB +"' AND '" + strFechaFinB + "') AND ";                         
            }
           
           strConsulta = strConsulta.substring(0, strConsulta.length()-4); 
        }        
        
       strConsulta += "ORDER BY " + COLUMNA_CODIGO;
        
        return strConsulta;
    }
    
}
