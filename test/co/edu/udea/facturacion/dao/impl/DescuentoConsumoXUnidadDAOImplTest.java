/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.DescuentoConsumoXUnidadDAO;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
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
public class DescuentoConsumoXUnidadDAOImplTest {
    
    public DescuentoConsumoXUnidadDAOImplTest() {
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
     * Test of obtenerTodos method, of class DescuentoConsumoXUnidadDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        DescuentoConsumoXUnidadDAO instance = new DescuentoConsumoXUnidadDAOImpl();
        List<DescuentoConsumo> result = instance.obtenerTodos();
        if (result != null){
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerUno method, of class DescuentoConsumoXUnidadDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigo = 1;
        DescuentoConsumoXUnidadDAO instance = new DescuentoConsumoXUnidadDAOImpl();
        DescuentoConsumo result = instance.obtenerUno(intCodigo);
        if (result != null){
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorConsumo method, of class DescuentoConsumoXUnidadDAOImpl.
     */
    @Test
    public void testObtenerPorConsumo() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigoConsumo = 1;
        DescuentoConsumoXUnidadDAO instance = new DescuentoConsumoXUnidadDAOImpl();
        DescuentoConsumo result = instance.obtenerPorConsumo(intCodigoConsumo);
         System.out.println("El valor del descuento para el consumo #"+intCodigoConsumo + " es: " + result.getDescuento());
    }

    /**
     * Test of insertar method, of class DescuentoConsumoXUnidadDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaRegistra = "2014-12-02";
        String strFechaAplicacion = "2014-12-10";
        DescuentoConsumo descuentoConsumo = new DescuentoConsumo();
        descuentoConsumo.setConsumo(2);
        descuentoConsumo.setDescuento(Float.parseFloat("45"));
        descuentoConsumo.setSeFactura("S");
        descuentoConsumo.setUsuarioRegistra("8103401");
        descuentoConsumo.setFechaRegistra(sdf.parse(strFechaRegistra));
        descuentoConsumo.setAplicado("N");
        descuentoConsumo.setFechaAplicacion(sdf.parse(strFechaAplicacion));
        descuentoConsumo.setConcepto("Descuento por unidad.");
        DescuentoConsumoXUnidadDAO instance = new DescuentoConsumoXUnidadDAOImpl();
        instance.insertar(descuentoConsumo);
         assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class DescuentoConsumoXUnidadDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaRegistra = "2014-12-02";
        String strFechaAplicacion = "2014-12-10";
        DescuentoConsumo descuentoConsumo = new DescuentoConsumo();
        descuentoConsumo.setConsumo(2);
        descuentoConsumo.setDescuento(Float.parseFloat("15.5"));
        descuentoConsumo.setSeFactura("S");
        descuentoConsumo.setUsuarioRegistra("8103401");
        descuentoConsumo.setFechaRegistra(sdf.parse(strFechaRegistra));
        descuentoConsumo.setAplicado("N");
        descuentoConsumo.setFechaAplicacion(null);
        descuentoConsumo.setConcepto("Descuento por volumen");
        descuentoConsumo.setCodigo(3);
        DescuentoConsumoXUnidadDAO instance = new DescuentoConsumoXUnidadDAOImpl();
        instance.actualizar(descuentoConsumo);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class DescuentoConsumoXUnidadDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Integer intCodigo = 3;
        DescuentoConsumoXUnidadDAO instance = new DescuentoConsumoXUnidadDAOImpl();
        instance.eliminar(intCodigo);
         assertTrue(true);
    }
    
}
