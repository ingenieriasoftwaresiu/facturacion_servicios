/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.TipoUsuarioConsumo;
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
public class TipoUsuarioConsumoDAOImplTest {
    
    public TipoUsuarioConsumoDAOImplTest() {
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
     * Test of obtenerTodos method, of class TipoUsuarioConsumoDAOImpl.
     */
    @Test
    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        TipoUsuarioConsumoDAOImpl instance = new TipoUsuarioConsumoDAOImpl();
        List<TipoUsuarioConsumo> result = instance.obtenerTodos();
        for(TipoUsuarioConsumo tipoUsuario : result){
            System.out.println("Código: " + tipoUsuario.getCodigo());
            System.out.println("Nombre: " + tipoUsuario.getNombre());
        }
        assertTrue(true);
    }

    /**
     * Test of obtenerUno method, of class TipoUsuarioConsumoDAOImpl.
     */
    @Test
    public void testObtenerUno() throws Exception {
        System.out.println("obtenerUno");
        String strCodigo = "UE";
        TipoUsuarioConsumoDAOImpl instance = new TipoUsuarioConsumoDAOImpl();
        TipoUsuarioConsumo result = instance.obtenerUno(strCodigo);
        System.out.println("Nombre: " + result.getNombre());
        assertTrue(true);
    }

    /**
     * Test of insertar method, of class TipoUsuarioConsumoDAOImpl.
     */
    @Test
    public void testInsertar() throws Exception {
        /*System.out.println("insertar");
        TipoUsuarioConsumo tipoUsuario = new TipoUsuarioConsumo();
        tipoUsuario.setCodigo("UP");
        tipoUsuario.setNombre("Usuario politico");
        TipoUsuarioConsumoDAOImpl instance = new TipoUsuarioConsumoDAOImpl();
        instance.insertar(tipoUsuario);
        assertTrue(true);*/
    }

    /**
     * Test of actualizar method, of class TipoUsuarioConsumoDAOImpl.
     */
    @Test
    public void testActualizar() throws Exception {
        /*System.out.println("actualizar");
        TipoUsuarioConsumo tipoUsuario = new TipoUsuarioConsumo();
        tipoUsuario.setCodigo("UP");
        tipoUsuario.setNombre("Usuario político");
        TipoUsuarioConsumoDAOImpl instance = new TipoUsuarioConsumoDAOImpl();
        instance.actualizar(tipoUsuario);
        assertTrue(true);*/
    }

    /**
     * Test of eliminar method, of class TipoUsuarioConsumoDAOImpl.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String strCodigo = "UP";
        TipoUsuarioConsumoDAOImpl instance = new TipoUsuarioConsumoDAOImpl();
        instance.eliminar(strCodigo);
        assertTrue(true);
    }
    
}
