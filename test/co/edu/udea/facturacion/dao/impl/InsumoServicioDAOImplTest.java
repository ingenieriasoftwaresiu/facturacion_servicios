/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.InsumoServicio;
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
public class InsumoServicioDAOImplTest {
    
    public InsumoServicioDAOImplTest() {
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
     * Test of obtenerTodos method, of class InsumoServicioDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        InsumoServicioDAOImpl instance = new InsumoServicioDAOImpl();      
        List<InsumoServicio> result = instance.obtenerTodos();
        System.out.println("Registros obtenidos: " + result.size());        
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class InsumoServicioDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "TP";
        InsumoServicioDAOImpl instance = new InsumoServicioDAOImpl();  
        InsumoServicio result = instance.obtenerUno(strCodigo);
        if (result != null){
               assertTrue(true);
          }else{
              fail("No se recuperaron registros");
          }
    }

    /**
     * Test of insertar method, of class InsumoServicioDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        InsumoServicio insumoServicio = new InsumoServicio();
        insumoServicio.setCodigo("CR");
        insumoServicio.setNombre("Caja de ratones blancos");
        insumoServicio.setUnidadMedida("PAQ");
        insumoServicio.setPresentacion("1");
        insumoServicio.setCostoUnitario(Long.parseLong("850000"));
        insumoServicio.setCantidadDisponible(20);
        InsumoServicioDAOImpl instance = new InsumoServicioDAOImpl();
        instance.insertar(insumoServicio);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class InsumoServicioDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        InsumoServicio insumoServicio = new InsumoServicio();
        insumoServicio.setCodigo("CR");
        insumoServicio.setNombre("Caja de ratones negros");
        insumoServicio.setUnidadMedida("PAQ");
        insumoServicio.setPresentacion("1");
        insumoServicio.setCostoUnitario(Long.parseLong("950000"));
        insumoServicio.setCantidadDisponible(10);
        InsumoServicioDAOImpl instance = new InsumoServicioDAOImpl();
        instance.actualizar(insumoServicio);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class InsumoServicioDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String strCodigo = "CR";
        InsumoServicioDAOImpl instance = new InsumoServicioDAOImpl();
        instance.eliminar(strCodigo);
        assertTrue(true);
    }
    
}
