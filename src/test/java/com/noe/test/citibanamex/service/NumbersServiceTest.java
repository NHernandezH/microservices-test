/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noe.test.citibanamex.service;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author noe_5
 */
public class NumbersServiceTest {
    
    public NumbersServiceTest() {
    }

    /**
     * Test of removeDuplicates method, of class NumbersService.
     */
    
    @Test
    public void testRemoveDuplicates_whenArrayIsNull() {
        System.out.println("testRemoveDuplicates_whenArrayIsNull");
        Integer[] numbers = null;
        NumbersService instance = new NumbersService();
        Integer[] expResult = new Integer[0];
        Integer[] result = instance.removeDuplicates(numbers);
        assertArrayEquals(expResult, result);
        
    }
    
    @Test
    public void testRemoveDuplicates_whenArrayIsEmpty() {
        System.out.println("testRemoveDuplicates_whenArrayIsEmpty");
        Integer[] numbers = new Integer[0];
        NumbersService instance = new NumbersService();
        Integer[] expResult = new Integer[0];
        Integer[] result = instance.removeDuplicates(numbers);
        assertArrayEquals(expResult, result);
        
    }
    
    @Test
    public void testRemoveDuplicates_whenArrayNoContainsDuplicates() {
        System.out.println("testRemoveDuplicates_whenArrayNoContainsDuplicates");
        Integer[] numbers = new Integer[]{1,3,5,4};
        NumbersService instance = new NumbersService();
        Integer[] expResult = new Integer[]{1,3,5,4};
        Integer[] result = instance.removeDuplicates(numbers);
        assertArrayEquals(expResult, result);
        
    }
    
    @Test
    public void testRemoveDuplicates_whenArrayContainsDuplicates() {
        System.out.println("testRemoveDuplicates_whenArrayContainsDuplicates");
        Integer[] numbers = new Integer[]{1,3,5,4,4,5};
        NumbersService instance = new NumbersService();
        Integer[] expResult = new Integer[]{1,3,5,4};
        Integer[] result = instance.removeDuplicates(numbers);
        assertArrayEquals(expResult, result);
        
    }
    
}
