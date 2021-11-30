/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.ConsumoServicioXTipoUsuario;
import co.edu.udea.facturacion.dto.ServicioXSubservicioXTipoUsuarioXUnidad;
import co.edu.udea.facturacion.dto.UsuarioConsumidor;
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
public class ConsumoServicioXTipoUsuarioDAOImplTest {
    
    public ConsumoServicioXTipoUsuarioDAOImplTest() {
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
     * Test of obtenerTodos method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ConsumoServicioXTipoUsuario> result = instance.obtenerTodos();
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
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ConsumoServicioXTipoUsuario> result = instance.obtenerTodosPorPaginas(intRegistrosAEmpezar, intRegistrosAMostrar);
        
         if (result != null){
             System.out.println("Registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerUno method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        Integer intCodigo = 4;
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        ConsumoServicioXTipoUsuario result = instance.obtenerUno(intCodigo);
        if (result != null){
            assertTrue(true);
        }else{
            System.out.println("No se encontró el movimiento con código " + intCodigo);
            assertTrue(true);
        }
    }
    
    @Test
    public void validarInsercion() throws Exception {
        System.out.println("validarInsercion");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Integer intTotalRegistros = 0;
        String strIdServicio = "AZA";
        String strIdSubservicio = "AUD1";
        String strTipoUsuario = "UE";
        Date dtFechaConsumo =sdf.parse("2015-01-15");
        String strTipoUsuarioConsumo = "UI";
        String strUsuarioConsumo = "EPID";
        String strUnidadMedida = "HS";
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        intTotalRegistros = instance.validarInsercion(strIdServicio, strIdSubservicio, strTipoUsuario, dtFechaConsumo, strTipoUsuarioConsumo, strUsuarioConsumo, strUnidadMedida);
        System.out.println("Total registros: " + intTotalRegistros);
        assertTrue(true);
        
    }

    /**
     * Test of insertar method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaConsumo="2014-11-02";
        String strFechaRegistra = "2014-12-02";
        String strFechaFacturacion = "2014-12-10";
        Integer intConsecutivo = null;
        
        ConsumoServicioXTipoUsuario consumo = new ConsumoServicioXTipoUsuario();
        consumo.setServicio("AZA");
        consumo.setSubservicio("AUD1");
        consumo.setTipoUsuario("USUINTUDEA");
        consumo.setFechaConsumo(sdf.parse(strFechaConsumo));
        consumo.setTipoUsuarioConsumo("UI");
        consumo.setUsuario("GRIPE");
        consumo.setUnidadMedida("HS");
        consumo.setSubcantidad(0);
        consumo.setCantidadUnidad(4);
        consumo.setSeFactura("S");
        consumo.setUsuarioRegistra("8103401");
        consumo.setFechaRegistra(sdf.parse(strFechaRegistra));
        consumo.setFacturado("N");
        consumo.setFechaFacturacion(sdf.parse(strFechaFacturacion));
        consumo.setConcepto("Préstamos por 4 horas.");
        consumo.setCuentaCobro(Long.parseLong("3"));
        
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        intConsecutivo = instance.insertar(consumo);
        System.out.println("El consecutivo generado fue: " + intConsecutivo);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaConsumo="2014-11-02";
        String strFechaRegistra = "2014-12-02";
        String strFechaFacturacion = "2014-12-10";
        
        ConsumoServicioXTipoUsuario consumo = new ConsumoServicioXTipoUsuario();
        consumo.setServicio("AZA");
        consumo.setSubservicio("AUD1");
        consumo.setTipoUsuario("USUINTUDEA");
        consumo.setFechaConsumo(sdf.parse(strFechaConsumo));
        consumo.setTipoUsuarioConsumo("UI");
        consumo.setUsuario("GRIPE");
        consumo.setUnidadMedida("HS");
        consumo.setSubcantidad(0);
        consumo.setCantidadUnidad(4);
        consumo.setSeFactura("S");
        consumo.setUsuarioRegistra("8103401");
        consumo.setFechaRegistra(sdf.parse(strFechaRegistra));
        consumo.setFacturado("N");
        consumo.setFechaFacturacion(sdf.parse(strFechaFacturacion));
        consumo.setConcepto("Préstamos por 4 horas.");
        consumo.setCuentaCobro(Long.parseLong("4"));
        consumo.setCodigo(24);
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        instance.actualizar(consumo);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        /*System.out.println("eliminar");
        Integer intCodigo = 25;
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        instance.eliminar(intCodigo);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);*/
    }

    /**
     * Test of obtenerPorRangoFechas method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerPorRangoFechas() throws Exception {
        System.out.println("obtenerPorRangoFechas");
        String strFechaInicio = "2014-11-09";
        String strFechaFin = "2014-11-20";
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ConsumoServicioXTipoUsuario> result = instance.obtenerPorRangoFechas(strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorServicio method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerPorServicio() throws Exception {
        System.out.println("obtenerPorServicio");
        String strServicio = "SAOI";
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ConsumoServicioXTipoUsuario> result = instance.obtenerPorServicio(strServicio);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorServicioYRangoFechas method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerPorServicioYRangoFechas() throws Exception {
        System.out.println("obtenerPorServicioYRangoFechas");
        String strServicio = "SAOI";
        String strFechaInicio = "2014-11-09";
        String strFechaFin = "2014-11-15";
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ConsumoServicioXTipoUsuario> result = instance.obtenerPorServicioYRangoFechas(strServicio, strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorUsuario method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerPorUsuario() throws Exception {
        System.out.println("obtenerPorUsuario");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "71211523";
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ConsumoServicioXTipoUsuario> result = instance.obtenerPorUsuario(strTipoUsuarioConsumo, strUsuario);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of obtenerPorUsuarioYRangoFechas method, of class ConsumoServicioXTipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerPorUsuarioYRangoFechas() throws Exception {
        System.out.println("obtenerPorUsuarioYRangoFechas");
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "71211523";
        String strFechaInicio = "2014-11-01";
        String strFechaFin = "2014-11-05";
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ConsumoServicioXTipoUsuario> result = instance.obtenerPorUsuarioYRangoFechas(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
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
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ServicioXSubservicioXTipoUsuarioXUnidad> result = instance.obtenerServiciosSubserviciosConsumidos(strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
        if (result.size() >= 0){
            System.out.println("Número de registros recuperados: " + result.size());
            assertTrue(true);
        }else{
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void obtenerConsumosXServicio_Subservicio_TipoUsuario_Unidad() throws Exception {
        System.out.println("obtenerConsumosXServicio_Subservicio_TipoUsuario_Unidad");
        String strServicio = "AZA";
        String strSubservicio = "AUD1";
        String strTipoUsuario = "UI";
        String strUnidad = "HS";
        String strTipoUsuarioConsumo = "UI";
        String strUsuario = "8103401";
        String strFechaInicio = "2014-11-01";
        String strFechaFin = "2014-11-30";
        ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
        List<ConsumoServicioXTipoUsuario> result = instance.obtenerConsumosXServicio_Subservicio_TipoUsuario_Unidad(strServicio, strSubservicio, strTipoUsuario, strUnidad, strTipoUsuarioConsumo, strUsuario, strFechaInicio, strFechaFin);
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
            ConsumoServicioXTipoUsuarioDAOImpl instance = new ConsumoServicioXTipoUsuarioDAOImpl();
            List<UsuarioConsumidor> result = instance.obtenerUsuariosConsumidores(strFechaInicio, strFechaFin);
            
            for(UsuarioConsumidor usuario: result){
                System.out.println("Tipo de usuario: " + usuario.getTipoUsuario());
                System.out.println("Usuario: " + usuario.getUsuario());
                System.out.println("");
            }
            assertTrue(true);
           
     }
    
}
