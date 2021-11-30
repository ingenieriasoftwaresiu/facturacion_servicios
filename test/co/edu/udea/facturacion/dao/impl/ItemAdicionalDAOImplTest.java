/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.ItemAdicional;
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
public class ItemAdicionalDAOImplTest {
    
    public ItemAdicionalDAOImplTest() {
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
     * Test of obtenerTodos method, of class ItemAdicionalDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ItemAdicionalDAOImpl instance = new ItemAdicionalDAOImpl();      
        List<ItemAdicional> result = instance.obtenerTodos();
        for(ItemAdicional itemAdicional : result){
           System.out.println("Código: " + itemAdicional.getCodigo());
           System.out.println("nombre: " + itemAdicional.getNombre());
           System.out.println("");
       }
    }

    /**
     * Test of obtenerUno method, of class ItemAdicionalDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "DOM";
        ItemAdicionalDAOImpl instance = new ItemAdicionalDAOImpl();
        ItemAdicional result = instance.obtenerUno(strCodigo);
        System.out.println("Item recuperado: " + result.getNombre());
    }

    /**
     * Test of insertar method, of class ItemAdicionalDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        ItemAdicional itemAdicional = new ItemAdicional();
        itemAdicional.setCodigo("DG");
        itemAdicional.setNombre("Diligencias");
        ItemAdicionalDAOImpl instance = new ItemAdicionalDAOImpl();
        instance.insertar(itemAdicional);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class ItemAdicionalDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        ItemAdicional itemAdicional = new ItemAdicional();
        itemAdicional.setCodigo("DG");
        itemAdicional.setNombre("Diligencia");
        ItemAdicionalDAOImpl instance = new ItemAdicionalDAOImpl();
        instance.actualizar(itemAdicional);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class ItemAdicionalDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String strCodigo = "DG";
        ItemAdicionalDAOImpl instance = new ItemAdicionalDAOImpl();
        instance.eliminar(strCodigo);
        assertTrue(true);
    }
    
}
