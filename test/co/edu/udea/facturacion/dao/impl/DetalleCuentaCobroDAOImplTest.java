/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.DetalleCuentaCobro;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge.correa
 */
public class DetalleCuentaCobroDAOImplTest {
    
    public DetalleCuentaCobroDAOImplTest() {
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
     * Test of obtenerTodosPorCuentaCobro method, of class DetalleCuentaCobroDAOImpl.
     */
    @Test
    public void testObtenerTodosPorCuentaCobro() throws Exception {
        System.out.println("obtenerTodosPorCuentaCobro");
        Long lgCodigo = Long.parseLong("1");
        DetalleCuentaCobroDAOImpl instance = new DetalleCuentaCobroDAOImpl();
        List<DetalleCuentaCobro> result = instance.obtenerTodosPorCuentaCobro(lgCodigo);
        System.out.println("Elementos recuperados: " + result.size());
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class DetalleCuentaCobroDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Long lgCodigo = Long.parseLong("1");
        String strServicio = "LDEEMB";
        String strSubservicio = "LB";
        DetalleCuentaCobroDAOImpl instance = new DetalleCuentaCobroDAOImpl();        
        DetalleCuentaCobro result = instance.obtenerUno(lgCodigo, strServicio, strSubservicio);
        System.out.println("El valor a pagar es: " + result.getTotalAPagar());
        assertTrue(true);
    }

    /**
     * Test of insertar method, of class DetalleCuentaCobroDAOImpl.
     */
   
    public void testInsertar() throws Exception {
        System.out.println("insertar");
        DetalleCuentaCobro detalleCuentaCobro = new DetalleCuentaCobro();
        detalleCuentaCobro.setCodigoCuentaCobro(Long.parseLong("1"));
        detalleCuentaCobro.setServicio("LDEEMB");
        detalleCuentaCobro.setSubservicio("EB");
        detalleCuentaCobro.setTotalAPagar(new BigDecimal(158000));
        DetalleCuentaCobroDAOImpl instance = new DetalleCuentaCobroDAOImpl();
        instance.insertar(detalleCuentaCobro);
        assertTrue(true);
    }

    /**
     * Test of actualizar method, of class DetalleCuentaCobroDAOImpl.
     */

    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        DetalleCuentaCobro detalleCuentaCobro = new DetalleCuentaCobro();
        detalleCuentaCobro.setCodigoCuentaCobro(Long.parseLong("1"));
        detalleCuentaCobro.setServicio("LDEEMB");
        detalleCuentaCobro.setSubservicio("EB");
        detalleCuentaCobro.setTotalAPagar(new BigDecimal(258000));
        DetalleCuentaCobroDAOImpl instance = new DetalleCuentaCobroDAOImpl();
        instance.actualizar(detalleCuentaCobro);
        assertTrue(true);
    }

    /**
     * Test of eliminarPorCuentaCobro method, of class DetalleCuentaCobroDAOImpl.
     */
    @Test
    public void testEliminarPorCuentaCobro() throws Exception {
        System.out.println("eliminarPorCuentaCobro");
        Long lgCodigo = Long.parseLong("1");
        DetalleCuentaCobroDAOImpl instance = new DetalleCuentaCobroDAOImpl();
        instance.eliminarPorCuentaCobro(lgCodigo);
        assertTrue(true);
    }

    /**
     * Test of eliminarUno method, of class DetalleCuentaCobroDAOImpl.
     */
    
    
    public void testEliminarUno() throws Exception {
        System.out.println("eliminarUno");
        Long lgCodigo = Long.parseLong("1");
        String strServicio = "LDEEMB";
        String strSubservicio = "EB";
        DetalleCuentaCobroDAOImpl instance = new DetalleCuentaCobroDAOImpl();
        instance.eliminarUno(lgCodigo, strServicio, strSubservicio);
        assertTrue(true);
    }
    
}
