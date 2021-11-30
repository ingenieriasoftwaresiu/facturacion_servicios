/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.TipoFacturacion;
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
public class TipoFacturacionDAOImplTest {
    
    public TipoFacturacionDAOImplTest() {
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
     * Test of obtenerTodos method, of class TipoFacturacionDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        TipoFacturacionDAOImpl instance = new TipoFacturacionDAOImpl();
        List<TipoFacturacion> result = instance.obtenerTodos();
        for(TipoFacturacion tipoFacturacion : result){
           System.out.println("Código: " + tipoFacturacion.getCodigo());
           System.out.println("nombre: " + tipoFacturacion.getNombre());
           System.out.println("");
       }
    }

    /**
     * Test of obtenerUno method, of class TipoFacturacionDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "UNDS";
        TipoFacturacionDAOImpl instance = new TipoFacturacionDAOImpl();  
        TipoFacturacion result = instance.obtenerUno(strCodigo);
        System.out.println("Tipo de facturacion recuperado: " + result.getNombre());
    }

    /**
     * Test of insertar method, of class TipoFacturacionDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        TipoFacturacion tipoFacturacion = new TipoFacturacion();
        tipoFacturacion.setCodigo("SUBT");
        tipoFacturacion.setNombre("Por Subtipos");
        TipoFacturacionDAOImpl instance = new TipoFacturacionDAOImpl();
        instance.insertar(tipoFacturacion);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class TipoFacturacionDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        TipoFacturacion tipoFacturacion = new TipoFacturacion();
        tipoFacturacion.setCodigo("SUBT");
        tipoFacturacion.setNombre("Por Subtipo");
        TipoFacturacionDAOImpl instance = new TipoFacturacionDAOImpl();
        instance.actualizar(tipoFacturacion);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class TipoFacturacionDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String strCodigo = "SUBT";
        TipoFacturacionDAOImpl instance = new TipoFacturacionDAOImpl();
        instance.eliminar(strCodigo);
        assertTrue(true);
    }
    
}
