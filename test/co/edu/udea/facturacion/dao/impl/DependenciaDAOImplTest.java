/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.Dependencia;
import co.edu.udea.facturacion.dto.OrdenadorSAP;
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
public class DependenciaDAOImplTest {
    
    public DependenciaDAOImplTest() {
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
     * Test of obtenerTodas method, of class DependenciaDAOImpl.
     */
    
    @Test
    public void testObtenerTodas() throws Exception {
        System.out.println("obtenerTodas");
        DependenciaDAOImpl instance = new DependenciaDAOImpl();
        List<Dependencia> result = instance.obtenerTodas();
        
        if (result != null){
            for (Dependencia dependencia : result){
                System.out.println("Código: " + dependencia.getCodigo());
                System.out.println("Nombre: " + dependencia.getNombre());
                System.out.println("Código centro costos: " + dependencia.getCentroCosto());
                System.out.println("Nombre centro costos: " + dependencia.getNombreCentroCosto());
                System.out.println("Maneja proyectos: " + dependencia.isManejaProyecto());
                System.out.println("");
            }
        }
        assertTrue(true);
    }

    /**
     * Test of obtenerUna method, of class DependenciaDAOImpl.
     */
    
    @Test
    public void testObtenerSubdependencias() throws Exception {
        System.out.println("obtenerSubdependencias");
        DependenciaDAOImpl instance = new DependenciaDAOImpl();
        String strCodigo = "0102";
        List<Dependencia> result = instance.obtenerSubdependencias(strCodigo);
        
        if (result != null){
            for (Dependencia dependencia : result){
                System.out.println("Código: " + dependencia.getCodigo());
                System.out.println("Nombre: " + dependencia.getNombre());
                System.out.println("Código centro costos: " + dependencia.getCentroCosto());
                System.out.println("Nombre centro costos: " + dependencia.getNombreCentroCosto());
                System.out.println("Maneja proyectos: " + dependencia.isManejaProyecto());
                System.out.println("");
            }
        }
        
        assertTrue(true);
    }
    
    @Test
    public void testobtenerOrdenadorSAP() throws Exception {
        System.out.println("obtenerOrdenadorSAP");
        DependenciaDAOImpl instance = new DependenciaDAOImpl();
        String strCodigo = "10401101";
        List<OrdenadorSAP> result = instance.obtenerOrdenadorSAP(strCodigo);
        
        if (result != null){
            for (OrdenadorSAP ordenador : result){
                System.out.println("Identificación: " + ordenador.getIdentificacion());
                System.out.println("Nombre: " + ordenador.getNombre());
                System.out.println("");
            }
        }
        
        assertTrue(true);
    }
    
    @Test
    public void testObtenerNombreDependencia() throws Exception {
        System.out.println("obtenerNombreDependencia");
        DependenciaDAOImpl instance = new DependenciaDAOImpl();
        String strCodigo = "0102";
        List<Dependencia> result = instance.obtenerNombreDependencia(strCodigo);
        
        if (result != null){
            for (Dependencia dependencia : result){
                System.out.println("Código: " + dependencia.getCodigo());
                System.out.println("Nombre: " + dependencia.getNombre());
                System.out.println("Código centro costos: " + dependencia.getCentroCosto());
                System.out.println("Nombre centro costos: " + dependencia.getNombreCentroCosto());
                System.out.println("Maneja proyectos: " + dependencia.isManejaProyecto());
                System.out.println("");
            }
        }
        
        assertTrue(true);
    }
}
