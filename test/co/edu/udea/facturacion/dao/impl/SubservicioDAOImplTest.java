/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.Subservicio;
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
public class SubservicioDAOImplTest {
    
    public SubservicioDAOImplTest() {
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
     * Test of obtenerTodos method, of class SubservicioDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        SubservicioDAOImpl instance = new SubservicioDAOImpl();
        List<Subservicio> result = instance.obtenerTodos();
        System.out.println("Registros obtenidos: " + result.size());
        assertTrue(true);
    }
    
    @Test
    public void obtenerPorServicio() throws Exception {
        System.out.println("obtenerPorServicio");
        String strIdServicio = "AZA";
        SubservicioDAOImpl instance = new SubservicioDAOImpl();
        List<Subservicio> result = instance.obtenerPorServicio(strIdServicio);
        for(Subservicio subservicio : result){
            System.out.println("Código: " + subservicio.getCodigo());
            System.out.println("Nombre: " + subservicio.getNombre());
        }
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class SubservicioDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "AUD1";
        SubservicioDAOImpl instance = new SubservicioDAOImpl();
        Subservicio result = instance.obtenerUno(strCodigo);
        if (result != null){
             assertTrue(true);
        }else{
            fail("No se recuperó el subservicio");
        }
       
    }

    /**
     * Test of insertar method, of class SubservicioDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        Subservicio subservicio = new Subservicio();
        subservicio.setCodigo("AUD5");
        subservicio.setNombre("Auditorio 5");
        subservicio.setTipoFacturacion("TIPOUSUARI");
        subservicio.setResponsable("1128446421");
        subservicio.setServicioPadre("AZA");
        subservicio.setInsumosFijos("N");
        subservicio.setAplicaSubcantidad("S");
        subservicio.setEtiquetaSubcantidad("Subvalor");
        SubservicioDAOImpl instance = new SubservicioDAOImpl();
        instance.insertar(subservicio);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class SubservicioDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        Subservicio subservicio = new Subservicio();
        subservicio.setCodigo("AUD5");
        subservicio.setNombre("Auditorio 5)");
        subservicio.setTipoFacturacion("TIPOUSUARI");
        subservicio.setResponsable("1128446421");
        subservicio.setServicioPadre("AZA");
        subservicio.setInsumosFijos("N");
        subservicio.setAplicaSubcantidad("N");
        subservicio.setEtiquetaSubcantidad("-");
        SubservicioDAOImpl instance = new SubservicioDAOImpl();
        instance.actualizar(subservicio);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class SubservicioDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String strCodigo = "AUD5";
        SubservicioDAOImpl instance = new SubservicioDAOImpl();
        instance.eliminar(strCodigo);
        assertTrue(true);
    }
    
}
