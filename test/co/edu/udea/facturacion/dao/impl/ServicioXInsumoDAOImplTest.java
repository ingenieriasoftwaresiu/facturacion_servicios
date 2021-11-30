/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.ServicioXInsumo;
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
public class ServicioXInsumoDAOImplTest {
    
    public ServicioXInsumoDAOImplTest() {
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
     * Test of obtenerTodos method, of class ServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        ServicioXInsumoDAOImpl instance = new ServicioXInsumoDAOImpl();
        List<ServicioXInsumo> result = instance.obtenerTodos();
        System.out.println("Registros obtenidos: " + result.size());        
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class ServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigo = 139;
        ServicioXInsumoDAOImpl instance = new ServicioXInsumoDAOImpl();
        ServicioXInsumo result = instance.obtenerUno(intCodigo);
        if (result != null){
               assertTrue(true);
          }else{
              fail("No se recuperaron registros");
          }
    }

    /**
     * Test of insertar method, of class ServicioXInsumoDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        ServicioXInsumo servicioXinsumo = new ServicioXInsumo();
        servicioXinsumo.setServicio("LDEEMB");
        servicioXinsumo.setSubservicio("LYDB");
        servicioXinsumo.setInsumo("TP");
        servicioXinsumo.setCobroTransversal("N");
        servicioXinsumo.setCantidadCobroTransversal(0);
        servicioXinsumo.setCantidadFija(0);
        servicioXinsumo.setUnidadCantidadFija("PD");
        servicioXinsumo.setUtilizaCostoVariable("S");
        servicioXinsumo.setCostoVariable(Long.parseLong("94"));
        servicioXinsumo.setSeCobraAlUsuario("S");
        ServicioXInsumoDAOImpl instance = new ServicioXInsumoDAOImpl();
        instance.insertar(servicioXinsumo);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class ServicioXInsumoDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        ServicioXInsumo servicioXinsumo = new ServicioXInsumo();
        servicioXinsumo.setServicio("LDEEMB");
        servicioXinsumo.setSubservicio("LYDB");
        servicioXinsumo.setInsumo("TP");
        servicioXinsumo.setCobroTransversal("N");
        servicioXinsumo.setCantidadCobroTransversal(0);
        servicioXinsumo.setCantidadFija(8);
        servicioXinsumo.setUnidadCantidadFija("CM3");
        servicioXinsumo.setUtilizaCostoVariable("N");
        servicioXinsumo.setCostoVariable(Long.parseLong("0"));
        servicioXinsumo.setSeCobraAlUsuario("N");
        servicioXinsumo.setCodigo(139);
        ServicioXInsumoDAOImpl instance = new ServicioXInsumoDAOImpl();
        instance.actualizar(servicioXinsumo);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class ServicioXInsumoDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Integer intCodigo = 139;
        ServicioXInsumoDAOImpl instance = new ServicioXInsumoDAOImpl();
        instance.eliminar(intCodigo);
        assertTrue(true);
    }
    
    @Test
    public void obtenerPorServicioSubservicio() throws Exception {
        System.out.println("obtenerPorServicioSubservicio");
        String strServicio= "MPELNE";
        String strSubservicio= "MDA";
        ServicioXInsumoDAOImpl instance = new ServicioXInsumoDAOImpl();
        List<ServicioXInsumo> result = instance.obtenerPorServicioSubservicio(strServicio, strSubservicio);
        if (result != null){
            System.out.println("Registros recuperados: " + result.size());
            assertTrue(true);
       }else{
           fail("No se recuperaron registros");
       }
    }
    
    @Test
    public void obtenerPorServicioSubservicioInsumo() throws Exception {
        System.out.println("obtenerPorServicioSubservicioInsumo");
        String strServicio= "MPELNE";
        String strSubservicio= "MDA";
        String strInsumo = "HDS";
        ServicioXInsumoDAOImpl instance = new ServicioXInsumoDAOImpl();
        ServicioXInsumo result = instance.obtenerPorServicioSubservicioInsumo(strServicio, strSubservicio, strInsumo);
        if (result != null){
               assertTrue(true);
          }else{
              fail("No se recuperaron registros");
          }
    }
    
}
