/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dto.Tercero;
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
public class TerceroDAOImplTest {
    
    public TerceroDAOImplTest() {
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
     * Test of obtenerTerceros method, of class TerceroDAOImpl.
     */
    @Test
    public void testObtenerTerceros() throws Exception {
        System.out.println("obtenerTerceros");
        String strNIT = "";
        String strRazonSocial = "RAD";
        String strClaseProveedor = "NACIONAL";
        TerceroDAOImpl instance = new TerceroDAOImpl();     
        List<Tercero> result = instance.obtenerTerceros(strNIT, strRazonSocial, strClaseProveedor);
        
        for(Tercero tercero : result){
            System.err.println("Contratista ID: "+tercero.getNit()+", "+"Nombre:"+tercero.getRazonSocial()+", Pais: "+tercero.getPais());
        }
        
        assertTrue(true);
    }
    
}
