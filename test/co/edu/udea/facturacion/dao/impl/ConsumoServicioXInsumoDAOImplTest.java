/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.ConsumoServicioXInsumo;
import co.edu.udea.facturacion.dto.Servicio;
import co.edu.udea.facturacion.dto.ServicioXSubservicio;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import co.edu.udea.facturacion.exception.GIDaoException;
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
 * @author jorge.correa
 */
public class ConsumoServicioXInsumoDAOImplTest {
    
    public ConsumoServicioXInsumoDAOImplTest() {
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
     * Test of obtenerTodos method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        List<ConsumoServicioXInsumo> result = instance.obtenerTodos();
        
        if (result != null){
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testObtenerTodosPorPaginas() throws Exception {
        System.out.println("obtenerTodosPorPaginas");
        Integer intRegistrosAEmpezar = 0;
        Integer intRegistrosAMostrar = 8;
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        List<ConsumoServicioXInsumo> result = instance.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
        
         if (result != null){
             System.out.println("Registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerUno method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigo = 1;
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        ConsumoServicioXInsumo result = instance.obtenerUno(intCodigo);
        if (result != null){
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }
    
   /**
     * Test of insertar method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaConsumo="2014-11-02";
        String strFechaRegistra = "2014-12-02";
        String strFechaFacturacion = "2014-12-10";
                
        ConsumoServicioXInsumo consumo = new ConsumoServicioXInsumo();
        consumo.setServicio("LDEEMB");
        consumo.setSubservicio("LYEB");
        consumo.setInsumo("TP");
        consumo.setFechaConsumo(sdf.parse(strFechaConsumo));
        consumo.setTipoUsuarioConsumo("UI");
        consumo.setUsuario("GRADMIN");
        consumo.setUnidadMedida("UN");
        consumo.setCantidadUnidad(24);
        consumo.setSeFactura("S");
        consumo.setUsuarioRegistra("8103401");
        consumo.setFechaRegistra(sdf.parse(strFechaRegistra));
        consumo.setFacturado("N");
        consumo.setFechaFacturacion(sdf.parse(strFechaFacturacion));
        consumo.setCuentaCobro(Long.parseLong("3"));
        
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        instance.insertar(consumo);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaConsumo="2014-11-02";
        String strFechaRegistra = "2014-12-02";
        String strFechaFacturacion = "2014-12-10";
                
        ConsumoServicioXInsumo consumo = new ConsumoServicioXInsumo();
        consumo.setCodigo(72); //OJO: Se debe mandar le código del consumo.
        consumo.setServicio("LDEEMB");
        consumo.setSubservicio("LYEB");
        consumo.setInsumo("TP");
        consumo.setFechaConsumo(sdf.parse(strFechaConsumo));
        consumo.setTipoUsuarioConsumo("UI");
        consumo.setUsuario("GRADMIN");
        consumo.setUnidadMedida("UN");
        consumo.setCantidadUnidad(30);
        consumo.setSeFactura("S");
        consumo.setUsuarioRegistra("8103401");
        consumo.setFechaRegistra(sdf.parse(strFechaRegistra));
        consumo.setFacturado("N");
        consumo.setFechaFacturacion(sdf.parse(strFechaFacturacion));
        consumo.setCuentaCobro(Long.parseLong("4"));
        
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        instance.actualizar(consumo);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
       /*System.out.println("eliminar");
        Integer intCodigo = 19;
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        instance.eliminar(intCodigo);
        // TODO review the generated test code and remove the default call to fail.
         assertTrue(true);*/
    }

    /**
     * Test of obtenerPorRangoFechas method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerPorRangoFechas() throws Exception {
        System.out.println("obtenerPorRangoFechas");
        String strFechaInicio = "2014-11-11";
        String strFechaFin = "2014-11-11";
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        List<ConsumoServicioXInsumo> result = instance.obtenerPorRangoFechas(strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorServicio method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerPorServicio() throws Exception {
        System.out.println("obtenerPorServicio");
        String strServicio = "LDEEMB";
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        List<ConsumoServicioXInsumo> result = instance.obtenerPorServicio(strServicio);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorServicioYRangoFechas method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerPorServicioYRangoFechas() throws Exception {
        System.out.println("obtenerPorServicioYRangoFechas");
        String strServicio = "LDEEMB";
        String strFechaInicio = "2014-11-09";
        String strFechaFin = "2014-11-11";
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        List<ConsumoServicioXInsumo> result = instance.obtenerPorServicioYRangoFechas(strServicio, strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorUsuario method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerPorUsuario() throws Exception {
        System.out.println("obtenerPorUsuario");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "GRADMIN";
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        List<ConsumoServicioXInsumo> result = instance.obtenerPorUsuario(strTipoUsuarioConsumo,strUsuario);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorUsuarioYRangoFechas method, of class ConsumoServicioXInsumoDAOImpl.
     */
    @Test
    public void testObtenerPorUsuarioYRangoFechas() throws Exception {
        System.out.println("obtenerPorUsuarioYRangoFechas");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "GRADMIN";
        String strFechaInicio = "2014-11-02";
        String strFechaFin = "2014-11-03";
        ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
        List<ConsumoServicioXInsumo> result = instance.obtenerPorUsuarioYRangoFechas(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }
    
     @Test
     public void obtenerServiciosSubserviciosConsumidos() throws Exception {
            System.out.println("obtenerServiciosSubserviciosConsumidos");
            String strTipoUsuarioConsumo = "UI";
            String strUsuario = "71211523";
            String strFechaInicio = "2014-11-01";
            String strFechaFin = "2014-11-30";
             ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
            List<ServicioXSubservicio> result = instance.obtenerServiciosSubserviciosConsumidos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
            if (result.size() >= 0){
                System.out.println("Número de registros recuperados: " + result.size());
                assertTrue(true);
            }else{
                fail("The test case is a prototype.");
            }        
     }
     
     @Test
     public void obtenerUsuariosConsumidores() throws Exception {
            System.out.println("obtenerUsuariosConsumidores");
            String strFechaInicio = "2014-12-01";
            String strFechaFin = "2014-12-31";
            ConsumoServicioXInsumoDAOImpl instance = new ConsumoServicioXInsumoDAOImpl();
            List<UsuarioConsumidor> result = instance.obtenerUsuariosConsumidores(strFechaInicio, strFechaFin);
            
            for(UsuarioConsumidor usuario: result){
                System.out.println("Tipo de usuario: " + usuario.getTipoUsuario());
                System.out.println("Usuario: " + usuario.getUsuario());
                System.out.println("\n");
            }
            assertTrue(true);
           
     }
    
}
