/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author insset
 */
public class RemiseTest {
    
    public RemiseTest() {
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
     * Test of CalculRemise method, of class Remise.
     */
    @Test
    public void testCalculRemise() {
        
        float prixInitial = 60;
        int taux = 20;
        Remise instance = new Remise();
        float expResult = 12;
        float result = instance.CalculRemise(prixInitial, taux);
        Assert.assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of CalculPrixFinal method, of class Remise.
     */
    @Test
    public void testCalculPrixFinal() {
        
        float prixInitial = 60;
        int taux = 20;
        Remise instance = new Remise();
        float expResult = 48;
        float result = instance.CalculPrixFinal(prixInitial, taux);
        Assert.assertEquals(expResult, result, 0.0);
        
    }
    
}
