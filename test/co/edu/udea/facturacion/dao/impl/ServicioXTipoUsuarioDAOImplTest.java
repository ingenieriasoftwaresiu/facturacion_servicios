/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.ServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.TipoUsuario;
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
 * @author jorge.correa
 */
public class ServicioXTipoUsuarioDAOImplTest {
    
    public ServicioXTipoUsuarioDAOImplTest() {
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
     * Test of obtenerTodos method, of class ServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        List<ServicioXTipoUsuario> result = instance.obtenerTodos();
        System.out.println("Registros obtenidos: " + result.size());        
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class ServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigo = 7;
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        ServicioXTipoUsuario result = instance.obtenerUno(intCodigo);
        if (result != null){
               assertTrue(true);
          }else{
              fail("No se recuperaron registros");
          }
    }

    /**
     * Test of obtenerPorServicioSubservicioTipoUsuario method, of class ServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerPorServicioSubservicioTipoUsuario() throws Exception {
        System.out.println("obtenerPorServicioSubservicioTipoUsuario");
        String strServicio = "CMP";
        String strSubservicio = "CMMO";
        String strTipoUsuario = "UI";
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        ServicioXTipoUsuario result = instance.obtenerPorServicioSubservicioTipoUsuario(strServicio, strSubservicio, strTipoUsuario);
        assertTrue(true);
    }
    
    @Test
    public void obtenerPorServicioSubservicioTipoUsuarioUnidad() throws Exception {
        System.out.println("obtenerPorServicioSubservicioTipoUsuarioUnidad");
        String strServicio = "CMP";
        String strSubservicio = "CMMU";
        String strTipoUsuario = "UI";
        String strUnidad = "ME20UL";
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        ServicioXTipoUsuario result = instance.obtenerPorServicioSubservicioTipoUsuarioUnidad(strServicio, strSubservicio, strTipoUsuario, strUnidad);
        System.out.println("Valor: " + result.getValorUnidad());
        assertTrue(true);
    }
    
    @Test
    public void obtenerTiposUsuarioPorServicioSubservicio() throws Exception {
        System.out.println("obtenerTiposUsuarioPorServicioSubservicio");
        String strServicio = "CMP";
        String strSubservicio = "CMMU";
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        List<TipoUsuario> result = instance.obtenerTiposUsuarioPorServicioSubservicio(strServicio, strSubservicio);
        System.out.println("Valor: " + result.size());
        assertTrue(true);
    }
    
    @Test
    public void obtenerUnidadesPorServicioSubservicioTipoUsuario() throws Exception {
        System.out.println("obtenerUnidadesPorServicioSubservicioTipoUsuario");
        String strServicio = "CMP";
        String strSubservicio = "CMMU";
        String strTipoUsuario = "UI";
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        List<UnidadMedida> result = instance.obtenerUnidadesPorServicioSubservicioTipoUsuario(strServicio, strSubservicio, strTipoUsuario);
        System.out.println("Valor: " + result.size());
        assertTrue(true);
    }

    /**
     * Test of insertar method, of class ServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        ServicioXTipoUsuario servicioXtipousuario = new ServicioXTipoUsuario();
        servicioXtipousuario.setServicio("AZA");
        servicioXtipousuario.setSubservicio("AUD3");
        servicioXtipousuario.setTipoUsuario("UE");
        servicioXtipousuario.setUnidadMedida("HS");
        servicioXtipousuario.setValorUnidad(Long.parseLong("35000"));
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        instance.insertar(servicioXtipousuario);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class ServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        ServicioXTipoUsuario servicioXtipousuario = new ServicioXTipoUsuario();
        servicioXtipousuario.setCodigo(8);
        servicioXtipousuario.setServicio("AZA");
        servicioXtipousuario.setSubservicio("AUD3");
        servicioXtipousuario.setTipoUsuario("UE");
        servicioXtipousuario.setUnidadMedida("HS");
        servicioXtipousuario.setValorUnidad(Long.parseLong("25000"));
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        instance.actualizar(servicioXtipousuario);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class ServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        /*System.out.println("eliminar");
        Integer intCodigo = 8;
        ServicioXTipoUsuarioDAOImpl instance = new ServicioXTipoUsuarioDAOImpl();
        instance.eliminar(intCodigo);
        assertTrue(true);*/
    }
    
}
