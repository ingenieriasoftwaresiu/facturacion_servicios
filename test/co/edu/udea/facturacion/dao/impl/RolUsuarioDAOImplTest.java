/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.RolUsuario;
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
public class RolUsuarioDAOImplTest {
    
    public RolUsuarioDAOImplTest() {
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
     * Test of obtenerTodos method, of class RolUsuarioDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        RolUsuarioDAOImpl instance = new RolUsuarioDAOImpl();
        List<RolUsuario> result = instance.obtenerTodos();
        for(RolUsuario rolUsuario : result){
            System.out.println("Código: " + rolUsuario.getCodigo());
            System.out.println("Nombre: " + rolUsuario.getNombre());
            System.out.println("¿Se autentica?: " + rolUsuario.getSeAutentica());
            System.out.println("");
        }
    }

    /**
     * Test of obtenerUno method, of class RolUsuarioDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "DES";
        RolUsuarioDAOImpl instance = new RolUsuarioDAOImpl();
        RolUsuario result = instance.obtenerUno(strCodigo);
        System.out.println("Rol recuperado: " + result.getNombre());
        System.out.println("¿Se autentica?: " + result.getSeAutentica());
    }

    /**
     * Test of insertar method, of class RolUsuarioDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        RolUsuario rolUsuario = new RolUsuario();
        rolUsuario.setCodigo("COORD");
        rolUsuario.setNombre("Coordinador");
        rolUsuario.setSeAutentica("S");
        RolUsuarioDAOImpl instance = new RolUsuarioDAOImpl();        
        instance.insertar(rolUsuario);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class RolUsuarioDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        RolUsuario rolUsuario = new RolUsuario();
        rolUsuario.setCodigo("COORD");
        rolUsuario.setNombre("Coordinadores");
        rolUsuario.setSeAutentica("N");
        RolUsuarioDAOImpl instance = new RolUsuarioDAOImpl();
        instance.actualizar(rolUsuario);
         assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class RolUsuarioDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        /*System.out.println("eliminar");
        String strCodigo = "COORD";
        RolUsuarioDAOImpl instance = new RolUsuarioDAOImpl();
        instance.eliminar(strCodigo);
        assertTrue(true);*/
    }
    
}
