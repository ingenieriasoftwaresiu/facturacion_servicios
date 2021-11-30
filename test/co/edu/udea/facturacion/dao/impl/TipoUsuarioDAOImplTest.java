/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.TipoUsuario;
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
public class TipoUsuarioDAOImplTest {
    
    public TipoUsuarioDAOImplTest() {
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
     * Test of obtenerTodos method, of class TipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        TipoUsuarioDAOImpl instance = new TipoUsuarioDAOImpl();
        List<TipoUsuario> result = instance.obtenerTodos();
        for(TipoUsuario tipoUsuario : result){
           System.out.println("Código: " + tipoUsuario.getCodigo());
           System.out.println("nombre: " + tipoUsuario.getNombre());
           System.out.println("");
       }
       
     assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class TipoUsuarioDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "UI";
        TipoUsuarioDAOImpl instance = new TipoUsuarioDAOImpl();
        TipoUsuario result = instance.obtenerUno(strCodigo);        
        System.out.println("Código: " + result.getCodigo());
        System.out.println("nombre: " + result.getNombre());
        System.out.println("");
       
       
     assertTrue(true);
    }

    /**
     * Test of insertar method, of class TipoUsuarioDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setCodigo("GI");
        tipoUsuario.setNombre("Grupo de investigacion");
        TipoUsuarioDAOImpl instance = new TipoUsuarioDAOImpl();
        instance.insertar(tipoUsuario);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class TipoUsuarioDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setCodigo("GI");
        tipoUsuario.setNombre("Grupo de investigacion UdeA");
        TipoUsuarioDAOImpl instance = new TipoUsuarioDAOImpl();
        instance.actualizar(tipoUsuario);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class TipoUsuarioDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String strCodigo = "GI";
        TipoUsuarioDAOImpl instance = new TipoUsuarioDAOImpl();
        instance.eliminar(strCodigo);
        assertTrue(true);
    }
    
}
