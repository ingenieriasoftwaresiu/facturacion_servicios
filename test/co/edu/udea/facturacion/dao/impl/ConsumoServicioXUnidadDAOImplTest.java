/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.ConsumoServicioXUnidad;
import co.edu.udea.facturacion.dto.ServicioXSubservicioXUnidad;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ConsumoServicioXUnidadDAOImplTest {
    
    public ConsumoServicioXUnidadDAOImplTest() {
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
     * Test of obtenerTodos method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ConsumoServicioXUnidad> result = instance.obtenerTodos();
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
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ConsumoServicioXUnidad> result = instance.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
        
         if (result != null){
             System.out.println("Registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerUno method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigo = 2;
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        ConsumoServicioXUnidad result = instance.obtenerUno(intCodigo);
        if (result != null){
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void validarInsercion() throws Exception {
        System.out.println("validarInsercion");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Integer intTotalRegistros = 0;
        String strIdServicio = "RTRBD";
        String strIdSubservicio = "IRB";
        Date dtFechaConsumo =sdf.parse("2015-01-30");
        String strTipoUsuarioConsumo = "UI";
        String strUsuarioConsumo = "NEURO";
        String strUnidadMedida = "GR";
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        intTotalRegistros = instance.validarInsercion(strIdServicio, strIdSubservicio, dtFechaConsumo, strTipoUsuarioConsumo, strUsuarioConsumo, strUnidadMedida);
        System.out.println("Total registros: " + intTotalRegistros);
        assertTrue(true);
        
    }

    /**
     * Test of insertar method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaConsumo="2014-11-02";
        String strFechaRegistra = "2014-12-02";
        String strFechaFacturacion = "2014-12-10";
        BigDecimal bdCantidad = new BigDecimal(20.6);
        
        ConsumoServicioXUnidad consumo = new ConsumoServicioXUnidad();
        consumo.setServicio("RTRBD");
        consumo.setSubservicio("IRB");
        consumo.setFechaConsumo(sdf.parse(strFechaConsumo));
        consumo.setTipoUsuarioConsumo("UI");
        consumo.setUsuario("GRADMIN");
        consumo.setUnidadMedida("KG");
        consumo.setCantidadUnidad(bdCantidad);
        consumo.setSeFactura("S");
        consumo.setUsuarioRegistra("8103401");
        consumo.setFechaRegistra(sdf.parse(strFechaRegistra));
        consumo.setFacturado("N");
        consumo.setFechaFacturacion(sdf.parse(strFechaFacturacion));
        consumo.setConcepto("Incineración de residuo de Administración.");
        consumo.setCuentaCobro(Long.parseLong("4"));
        
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        instance.insertar(consumo);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaConsumo="2014-11-02";
        String strFechaRegistra = "2014-12-02";
        String strFechaFacturacion = "2014-12-10";
        BigDecimal bdCantidad = new BigDecimal(45);
        
        ConsumoServicioXUnidad consumo = new ConsumoServicioXUnidad();
        consumo.setServicio("RTRBD");
        consumo.setSubservicio("IRB");
        consumo.setFechaConsumo(sdf.parse(strFechaConsumo));
        consumo.setTipoUsuarioConsumo("UI");
        consumo.setUsuario("GRADMIN");
        consumo.setUnidadMedida("KG");
        consumo.setCantidadUnidad(bdCantidad);
        consumo.setSeFactura("S");
        consumo.setUsuarioRegistra("8103401");
        consumo.setFechaRegistra(sdf.parse(strFechaRegistra));
        consumo.setFacturado("N");
        consumo.setFechaFacturacion(sdf.parse(strFechaFacturacion));
        consumo.setConcepto("Incineración de residuo de Administración.");
        consumo.setCuentaCobro(Long.parseLong("3"));
        consumo.setCodigo(7);
        
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        instance.actualizar(consumo);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        /*System.out.println("eliminar");
        Integer intCodigo = 5;
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        instance.eliminar(intCodigo);
        assertTrue(true);*/
    }

    /**
     * Test of obtenerPorRangoFechas method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerPorRangoFechas() throws Exception {
        System.out.println("obtenerPorRangoFechas");
        String strFechaInicio = "2014-11-01";
        String strFechaFin = "2014-11-10";
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ConsumoServicioXUnidad> result = instance.obtenerPorRangoFechas(strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorServicio method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerPorServicio() throws Exception {
        System.out.println("obtenerPorServicio");
        String strServicio = "RTRBD";
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ConsumoServicioXUnidad> result = instance.obtenerPorServicio(strServicio);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorServicioYRangoFechas method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerPorServicioYRangoFechas() throws Exception {
        System.out.println("obtenerPorServicioYRangoFechas");
        String strServicio = "RTRBD";
        String strFechaInicio = "2014-11-10";
        String strFechaFin = "2014-11-20";
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ConsumoServicioXUnidad> result = instance.obtenerPorServicioYRangoFechas(strServicio, strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorUsuario method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerPorUsuario() throws Exception {
        System.out.println("obtenerPorUsuario");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "8103401";
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ConsumoServicioXUnidad> result = instance.obtenerPorUsuario(strTipoUsuarioConsumo, strUsuario);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorUsuarioYRangoFechas method, of class ConsumoServicioXUnidadDAOImpl.
     */
    @Test
    public void testObtenerPorUsuarioYRangoFechas() throws Exception {
        System.out.println("obtenerPorUsuarioYRangoFechas");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "71211523";
        String strFechaInicio = "2014-11-10";
        String strFechaFin = "2014-11-20";
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ConsumoServicioXUnidad> result = instance.obtenerPorUsuarioYRangoFechas(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
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
        String strUsuario = "8103401";
        String strFechaInicio = "2014-11-01";
        String strFechaFin = "2014-11-30";
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ServicioXSubservicioXUnidad> result = instance.obtenerServiciosSubserviciosConsumidos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void obtenerConsumosXServicio_Subservicio_Unidad() throws Exception {
        System.out.println("obtenerConsumosXServicio_Subservicio_Unidad");
        String strServicio = "RTRBD";
        String strSubservicio = "IRB";
        String strUnidadMedida = "KG";
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "8103401";
        String strFechaInicio = "2014-11-01";
        String strFechaFin = "2014-11-30";
        ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
        List<ConsumoServicioXUnidad> result = instance.obtenerConsumosXServicio_Subservicio_Unidad(strServicio, strSubservicio, strUnidadMedida, strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
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
            String strFechaInicio = "2015-02-01";
            String strFechaFin = "2015-02-28";
            ConsumoServicioXUnidadDAOImpl instance = new ConsumoServicioXUnidadDAOImpl();
            List<UsuarioConsumidor> result = instance.obtenerUsuariosConsumidores(strFechaInicio, strFechaFin);
            
            for(UsuarioConsumidor usuario: result){
                System.out.println("Tipo de usuario: " + usuario.getTipoUsuario());
                System.out.println("Usuario: " + usuario.getUsuario());
                System.out.println("");
            }
            assertTrue(true);
           
     }
    
}
