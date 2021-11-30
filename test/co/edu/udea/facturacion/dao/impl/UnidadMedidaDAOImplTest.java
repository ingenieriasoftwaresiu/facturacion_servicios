/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dto.UnidadMedida;
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
public class UnidadMedidaDAOImplTest {
    
    public UnidadMedidaDAOImplTest() {
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
     * Test of obtenerTodas method, of class UnidadMedidaDAOImpl.
     */
    @Test
    public void testObtenerTodas() throws Exception {
        System.out.println("obtenerTodas");
       UnidadMedidaDAO unidad_medidaDAOImpl = new UnidadMedidaDAOImpl();
       List<UnidadMedida> unidades_medida = unidad_medidaDAOImpl.obtenerTodas();
       
       for(UnidadMedida unidad_medida : unidades_medida){
           System.out.println("Código: " + unidad_medida.getCodigo());
           System.out.println("nombre: " + unidad_medida.getNombre());
           System.out.println("");
       }
       
     assertTrue(true);
       
    }

    /**
     * Test of obtenerUna method, of class UnidadMedidaDAOImpl.
     */
    @Test

    public void testObtenerUna() throws Exception {
        System.out.println("obtenerUna");
        String strCodigo = "PAQ";
        UnidadMedidaDAOImpl instance = new UnidadMedidaDAOImpl();      
        UnidadMedida result = instance.obtenerUna(strCodigo);
        
        System.out.println("Nombre: " + result.getNombre());
        
        assertTrue(true);
    }

    /**
     * Test of insertar method, of class Unidad_MedidaDAOImpl.
     */
    
    @Test    
    public void testInsertar() throws Exception {
        System.out.println("insertar");
        UnidadMedida unidad_medida = new UnidadMedida();        
        UnidadMedidaDAOImpl instance = new UnidadMedidaDAOImpl();
        unidad_medida.setCodigo("MIN");
        unidad_medida.setNombre("Minuto(s)");
        instance.insertar(unidad_medida);
        
       assertTrue(true);
    }

    /**
     * Test of actualizar method, of class UnidadMedidaDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        UnidadMedida unidad_medida = new UnidadMedida();        
        UnidadMedidaDAOImpl instance = new UnidadMedidaDAOImpl();
        unidad_medida.setCodigo("MIN");
        unidad_medida.setNombre("Minuto(s)");
        
        instance.actualizar(unidad_medida);
        assertTrue(true);
    }

    /**
     * Test of eliminar method, of class UnidadMedidaDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String strCodigo = "MIN";
        UnidadMedidaDAOImpl instance = new UnidadMedidaDAOImpl();
        instance.eliminar(strCodigo);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }
    
}
