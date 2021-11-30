/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.Servicio;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author George
 */
public class ServicioDAOImplTest {
    
    public ServicioDAOImplTest() {
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
     * Test of obtenerTodos method, of class ServicioDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ServicioDAOImpl instance = new ServicioDAOImpl();
        List<Servicio> result = instance.obtenerTodos();
        for(Servicio servicio : result){
            System.out.println("Codigo: " + servicio.getCodigo());
            System.out.println("Nombre: " + servicio.getNombre());
        }
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class ServicioDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "SAOI";
        ServicioDAOImpl instance = new ServicioDAOImpl();   
        Servicio result = instance.obtenerUno(strCodigo);
        System.out.println("Nombre: " + result.getNombre());
        assertTrue(true);
    }
    
}
