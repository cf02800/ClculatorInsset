/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author insset
 */
public class RomanConverterServiceImplTest {
    
    public RomanConverterServiceImplTest() {
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
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabeOK() {
        //given
        int n = 1337;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "MCCCXXXVII";
        //when
        String result = instance.convertArabeToRoman(n);

        //then
        Assert.assertEquals(result, expResult);
    }
    
    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabeNOK() {
        //given
        int n = 523;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "DXXII";
        //when
        String result = instance.convertArabeToRoman(n);

        //then
        Assert.assertNotSame(result, expResult);
    }
    
}
