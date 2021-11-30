/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.RolXUsuario;
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
public class RolXUsuarioDAOImplTest {
    
    public RolXUsuarioDAOImplTest() {
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
     * Test of obtenerTodos method, of class RolXUsuarioDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        RolXUsuarioDAOImpl instance = new RolXUsuarioDAOImpl();    
        List<RolXUsuario> result = instance.obtenerTodos();
        System.out.println("Número de registros obtenidos: " + result.size());
    }

    /**
     * Test of obtenerUno method, of class RolXUsuarioDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strPersona = "8103401";
        String strRol = "DES";
        RolXUsuarioDAOImpl instance = new RolXUsuarioDAOImpl();
        RolXUsuario result = instance.obtenerUno(strPersona, strRol);
        System.out.println("Persona obtenida: " + result.getPersona());
    }

    /**
     * Test of obtenerPorPersona method, of class RolXUsuarioDAOImpl.
     */
    @Test
    public void testObtenerPorPersona() throws Exception {
        System.out.println("obtenerPorPersona");
        String strPersona = "8103401";
        RolXUsuarioDAOImpl instance = new RolXUsuarioDAOImpl();
        List<RolXUsuario> result = instance.obtenerPorPersona(strPersona);
        System.out.println("Número de registros obtenidos: " + result.size());
    }

    /**
     * Test of insertar method, of class RolXUsuarioDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        RolXUsuario rolXpersona = new RolXUsuario();
        rolXpersona.setPersona("8103401");
        rolXpersona.setRol("USU");
        RolXUsuarioDAOImpl instance = new RolXUsuarioDAOImpl();
        instance.insertar(rolXpersona);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class RolXUsuarioDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String strPersona = "8103401";
        String strRol = "USU";
        RolXUsuarioDAOImpl instance = new RolXUsuarioDAOImpl();
        instance.eliminar(strPersona, strRol);
        assertTrue(true);
    }
    
}
