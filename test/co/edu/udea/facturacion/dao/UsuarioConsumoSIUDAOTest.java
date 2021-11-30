/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dao.impl.UsuarioConsumoSIUDAOImpl;
import co.edu.udea.facturacion.dto.UsuarioConsumoSIU;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author George
 */
public class UsuarioConsumoSIUDAOTest {
    
    public UsuarioConsumoSIUDAOTest() {
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
     * Test of obtenerTodos method, of class UsuarioConsumoSIUDAO.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        UsuarioConsumoSIUDAOImpl instance = new UsuarioConsumoSIUDAOImpl();
        List<UsuarioConsumoSIU> result = instance.obtenerTodos();
        for(UsuarioConsumoSIU usuarioConsumo : result){
            System.out.println("Codigo: " + usuarioConsumo.getCodigo());
            System.out.println("Nombre: " + usuarioConsumo.getNombre());
        }
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class UsuarioConsumoSIUDAO.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "CIDEMAT";
        UsuarioConsumoSIUDAOImpl instance = new UsuarioConsumoSIUDAOImpl();
        UsuarioConsumoSIU result = instance.obtenerUno(strCodigo);
        System.out.println("Nombre: " + result.getNombre());
        assertTrue(true);
    }        
}
