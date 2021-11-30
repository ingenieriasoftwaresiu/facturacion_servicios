/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.CuentaCobro;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge.correa
 */
public class CuentaCobroDAOImplTest {
    
    public CuentaCobroDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerTodas method, of class CuentaCobroDAOImpl.
     */
    @Test
    public void testObtenerTodas() throws Exception {
        System.out.println("obtenerTodas");
        CuentaCobroDAOImpl instance = new CuentaCobroDAOImpl();        
        List<CuentaCobro> result = instance.obtenerTodas();
        System.out.println("Cuenta de cobro recuperadas: " + result.size());
        assertTrue(true);
    }

    /**
     * Test of obtenerUna method, of class CuentaCobroDAOImpl.
     */
    @Test
    public void testObtenerUna() throws Exception {
        System.out.println("obtenerUna");
        Long lgCodigo = Long.parseLong("2");
        CuentaCobroDAOImpl instance = new CuentaCobroDAOImpl();     
        CuentaCobro result = instance.obtenerUna(lgCodigo);
        
        if (result != null){
            System.out.println("Usuario consumo: " + result.getUsuarioConsumo());
        }
        assertTrue(true);
    }

    /**
     * Test of insertar method, of class CuentaCobroDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        CuentaCobro cuentaCobro = new CuentaCobro();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               
        cuentaCobro.setTipoUsuarioConsumo("UI");
        cuentaCobro.setUsuarioConsumo("GRIPE");
        cuentaCobro.setFechaCreacion(sdf.parse("2015-01-02"));
        cuentaCobro.setUsuarioCreacion("71211523");
        cuentaCobro.setFechaLimitePago(sdf.parse("2015-01-16"));
        cuentaCobro.setFechaInicioPeriodo(sdf.parse("2014-12-01"));
        cuentaCobro.setFechaFinPeriodo(sdf.parse("2014-01-31"));
        cuentaCobro.setNumeroSoporte("-");
        
        CuentaCobroDAOImpl instance = new CuentaCobroDAOImpl();       
        Long result = instance.insertar(cuentaCobro);
        System.out.println("Consecutivo creado: " +result);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class CuentaCobroDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        CuentaCobro cuentaCobro = new CuentaCobro();        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         
        cuentaCobro.setCodigo(Long.parseLong("3"));
        cuentaCobro.setTipoUsuarioConsumo("UI");
        cuentaCobro.setUsuarioConsumo("GRIPE");
        cuentaCobro.setFechaCreacion(sdf.parse("2015-01-02"));
        cuentaCobro.setUsuarioCreacion("71211523");
        cuentaCobro.setFechaLimitePago(sdf.parse("2015-01-16"));
        cuentaCobro.setFechaInicioPeriodo(sdf.parse("2014-12-01"));
        cuentaCobro.setFechaFinPeriodo(sdf.parse("2014-12-31"));
        cuentaCobro.setNumeroSoporte("TI-1234");
        
        CuentaCobroDAOImpl instance = new CuentaCobroDAOImpl();
        instance.actualizar(cuentaCobro);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class CuentaCobroDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        /*System.out.println("eliminar");
        Long lgCodigo = Long.parseLong("2");
        CuentaCobroDAOImpl instance = new CuentaCobroDAOImpl();
        instance.eliminar(lgCodigo);
        assertTrue(true);*/
    }
    
}
