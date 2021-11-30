/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jorge.correa
 */
public class FacturacionServiciosDAOImplTest {
    
    public FacturacionServiciosDAOImplTest() {
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
     * Test of facturarPorInsumos method, of class FacturacionServiciosDAOImpl.
     */
    @Test
    public void testFacturarPorInsumos() throws Exception {
        /*System.out.println("facturarPorInsumos");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "MASO";
        String strFechaInicio = "2014-11-01";
        String strFechaFin = "2014-11-30";
        Long lgCuentaCobro = Long.parseLong("1");
        FacturacionServiciosDAOImpl instance = new FacturacionServiciosDAOImpl();
        BigDecimal result = instance.facturarPorInsumos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin, lgCuentaCobro);
        System.out.println("El valor a facturar por insumos al usuario " + strUsuario + " es: " + result);*/
    }

    /**
     * Test of facturarPorTiposUsuario method, of class FacturacionServiciosDAOImpl.
     */
    @Test
    public void testFacturarPorTiposUsuario() throws Exception {
        /*System.out.println("facturarPorTiposUsuario");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "MASO";
        String strFechaInicio = "2014-11-01";
        String strFechaFin = "2014-11-30";
        Long lgCuentaCobro = Long.parseLong("1");
        FacturacionServiciosDAOImpl instance = new FacturacionServiciosDAOImpl();
        BigDecimal result = instance.facturarPorTiposUsuario(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin, lgCuentaCobro);
        System.out.println("El valor a facturar por tipo de usuario al usuario " + strUsuario + " es: " + result);*/
    }

    /**
     * Test of facturarPorUnidades method, of class FacturacionServiciosDAOImpl.
     */
    @Test
    public void testFacturarPorUnidades() throws Exception {
        /*System.out.println("facturarPorUnidades");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "QUIR";
        String strFechaInicio = "2014-11-01";
        String strFechaFin = "2014-11-30";
        Long lgCuentaCobro = Long.parseLong("1");
        FacturacionServiciosDAOImpl instance = new FacturacionServiciosDAOImpl();
        BigDecimal result = instance.facturarPorUnidades(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin, lgCuentaCobro);
       System.out.println("El valor a facturar por unidades al usuario " + strUsuario + " es: " + result);*/
    }
    
    @Test
    public void facturarConsumos() throws Exception {
        System.out.println("facturarConsumos");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "CIDEMAT";
        String strFechaInicio = "2015-01-01";
        String strFechaFin = "2015-01-30";       
        String strUsuarioCreacion = "8103401";
        FacturacionServiciosDAOImpl instance = new FacturacionServiciosDAOImpl();
        Long codigoCuentaCobro = instance.facturarConsumos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin, strUsuarioCreacion);
        System.out.println("Cuenta de cobro generada con consecutivo " + codigoCuentaCobro);
    }
    
    @Test
    public void obtenerUsuariosConsumidores() throws Exception {
        System.out.println("obtenerUsuariosConsumidores");
        String strFechaInicio = "2015-02-01";
        String strFechaFin = "2015-02-28";        
        FacturacionServiciosDAOImpl instance = new FacturacionServiciosDAOImpl();
        List<UsuarioConsumidor> result = instance.obtenerUsuariosConsumidores(strFechaInicio, strFechaFin);
        
    }
}
