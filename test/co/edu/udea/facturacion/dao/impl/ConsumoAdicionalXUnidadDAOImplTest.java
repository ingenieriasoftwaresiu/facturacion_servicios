/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.ConsumoAdicional;
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
public class ConsumoAdicionalXUnidadDAOImplTest {
    
    public ConsumoAdicionalXUnidadDAOImplTest() {
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
     * Test of obtenerTodos method, of class ConsumoAdicionalXUnidadDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ConsumoAdicionalXUnidadDAOImpl instance = new ConsumoAdicionalXUnidadDAOImpl();
        List<ConsumoAdicional> result = instance.obtenerTodos();
        if (result != null){
             assertTrue(true);
         }else{
             fail("The test case is a prototype.");
         }
    }

    /**
     * Test of obtenerUno method, of class ConsumoAdicionalXUnidadDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigo = 1;
        ConsumoAdicionalXUnidadDAOImpl instance = new ConsumoAdicionalXUnidadDAOImpl();
        ConsumoAdicional result = instance.obtenerUno(intCodigo);
        if (result != null){
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorConsumo method, of class ConsumoAdicionalXUnidadDAOImpl.
     */
    @Test
    public void testObtenerPorConsumo() throws Exception {
        System.out.println("obtenerPorConsumo");
        Integer intCodigoConsumo = 2;
        ConsumoAdicionalXUnidadDAOImpl instance = new ConsumoAdicionalXUnidadDAOImpl();
        List<ConsumoAdicional> result = instance.obtenerPorConsumo(intCodigoConsumo);
        System.out.println("Número de consumos adicionales del consumo #" + intCodigoConsumo + " es: " + result.size());       
    }

    /**
     * Test of insertar method, of class ConsumoAdicionalXUnidadDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaConsumo = "2014-11-21";
        String strFechaRegistra = "2014-12-02";
        String strFechaFacturacion = "2014-12-10";
        ConsumoAdicional consumoAdicional = new ConsumoAdicional();
        consumoAdicional.setConsumo(2);
        consumoAdicional.setItemAdicional("LR");
        consumoAdicional.setFechaConsumo(sdf.parse(strFechaConsumo));
        consumoAdicional.setValorUnidad(Long.parseLong("12500"));
        consumoAdicional.setSeFactura("S");
        consumoAdicional.setUsuarioRegistra("8103401");
        consumoAdicional.setFechaRegistra(sdf.parse(strFechaRegistra));
        consumoAdicional.setFacturado("N");
        consumoAdicional.setFechaFacturacion(sdf.parse(strFechaFacturacion));
        ConsumoAdicionalXUnidadDAOImpl instance = new ConsumoAdicionalXUnidadDAOImpl();
        instance.insertar(consumoAdicional);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class ConsumoAdicionalXUnidadDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaConsumo = "2014-11-21";
        String strFechaRegistra = "2014-12-02";
        String strFechaFacturacion = "2014-12-10";
        ConsumoAdicional consumoAdicional = new ConsumoAdicional();
        consumoAdicional.setConsumo(2);
        consumoAdicional.setItemAdicional("LR");
        consumoAdicional.setFechaConsumo(sdf.parse(strFechaConsumo));
        consumoAdicional.setValorUnidad(Long.parseLong("18000"));
        consumoAdicional.setSeFactura("S");
        consumoAdicional.setUsuarioRegistra("8103401");
        consumoAdicional.setFechaRegistra(sdf.parse(strFechaRegistra));
        consumoAdicional.setFacturado("N");
        consumoAdicional.setFechaFacturacion(null);
        consumoAdicional.setCodigo(3);
        ConsumoAdicionalXUnidadDAOImpl instance = new ConsumoAdicionalXUnidadDAOImpl();
        instance.actualizar(consumoAdicional);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class ConsumoAdicionalXUnidadDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Integer intCodigo = 3;
        ConsumoAdicionalXUnidadDAOImpl instance = new ConsumoAdicionalXUnidadDAOImpl();
        instance.eliminar(intCodigo);
        assertTrue(true);
    }    
}
