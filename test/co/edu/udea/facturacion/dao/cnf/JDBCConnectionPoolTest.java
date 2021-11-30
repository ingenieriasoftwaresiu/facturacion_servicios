/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.cnf;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge.correa
 */
public class JDBCConnectionPoolTest {
    
    public JDBCConnectionPoolTest() {
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
     * Test of getConexion method, of class JDBCConnectionPool.
     */
    @Test
    public void testGetConexion() throws Exception {
        System.out.println("getConexion");
        JDBCConnectionPool instance = new JDBCConnectionPool();
        Connection result = instance.getConexion();
        
        if (result == null){
            fail("No se conectó");
        }else{
            Assert.assertNotNull(result);
        }             
        
    }
    
}
