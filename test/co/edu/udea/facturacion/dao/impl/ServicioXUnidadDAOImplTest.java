/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.UnidadMedidaDAO;
import co.edu.udea.facturacion.dto.ServicioXUnidad;
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
public class ServicioXUnidadDAOImplTest {
    
    public ServicioXUnidadDAOImplTest() {
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
     * Test of obtenerTodos method, of class ServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ServicioXUnidadDAOImpl instance = new ServicioXUnidadDAOImpl();
        List<ServicioXUnidad> result = instance.obtenerTodos();
        System.out.println("Registros obtenidos: " + result.size());        
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class ServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigo = 1;
        ServicioXUnidadDAOImpl instance = new ServicioXUnidadDAOImpl();
        ServicioXUnidad result = instance.obtenerUno(intCodigo);
        if (result != null){
               assertTrue(true);
          }else{
              fail("No se recuperaron registros");
          }
    }

    /**
     * Test of obtenerPorServicioSubservicioUnidad method, of class ServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerPorServicioSubservicioUnidad() throws Exception {
        System.out.println("obtenerPorServicioSubservicioUnidad");
        String strServicio = "RTRBD";
        String strSubservicio = "IRB";
        String strUnidad = "KG";
        ServicioXUnidadDAOImpl instance = new ServicioXUnidadDAOImpl();
        ServicioXUnidad result = instance.obtenerPorServicioSubservicioUnidad(strServicio, strSubservicio, strUnidad);
        System.out.println("El valor de la unida es: " + result.getValorUnidad());
        assertTrue(true);
    }

    /**
     * Test of insertar method, of class ServicioXUnidadDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        ServicioXUnidad servicioXunidad = new ServicioXUnidad();
        servicioXunidad.setServicio("RTRBD");
        servicioXunidad.setSubservicio("IRB");
        servicioXunidad.setUnidadMedida("GR");
        servicioXunidad.setValorUnidad(Long.parseLong("16000"));
        ServicioXUnidadDAOImpl instance = new ServicioXUnidadDAOImpl();
        instance.insertar(servicioXunidad);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class ServicioXUnidadDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        ServicioXUnidad servicioXunidad = new ServicioXUnidad();
        servicioXunidad.setServicio("RTRBD");
        servicioXunidad.setSubservicio("IRB");
        servicioXunidad.setUnidadMedida("GR");
        servicioXunidad.setValorUnidad(Long.parseLong("26500"));
        servicioXunidad.setCodigo(3);
        ServicioXUnidadDAOImpl instance = new ServicioXUnidadDAOImpl();
        instance.actualizar(servicioXunidad);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class ServicioXUnidadDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        /*System.out.println("eliminar");
        Integer intCodigo = 3;
        ServicioXUnidadDAOImpl instance = new ServicioXUnidadDAOImpl();
        instance.eliminar(intCodigo);
        assertTrue(true);*/
    }
    
    @Test
    public void obtenerUnidadesPorServicioSubservicio() throws Exception {
        System.out.println("obtenerUnidadesPorServicioSubservicio");
        String strServicio = "RTRBD";
        String strSubservicio = "IRB";
        ServicioXUnidadDAOImpl instance = new ServicioXUnidadDAOImpl();
        List<UnidadMedida> unidadesMedida = instance.obtenerUnidadesPorServicioSubservicio(strServicio, strSubservicio);
        System.out.println("Número de unidades recuperadas: " + unidadesMedida.size());
        assertTrue(true);
    }
    
}
