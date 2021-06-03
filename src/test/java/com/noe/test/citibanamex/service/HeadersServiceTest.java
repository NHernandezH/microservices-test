/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noe.test.citibanamex.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 *
 * @author noe_5
 */
public class HeadersServiceTest {

    public HeadersServiceTest() {
    }

    /**
     * Test of getHeaders method, of class HeadersService.
     */
    
    @Test
    public void testGetHeaders_whenServletRequestNoContainsHeaders() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        Map<String, List<String>> expResult = new HashMap<>();

        HeadersService instance = new HeadersService();
        Map<String, List<String>> result = instance.getHeaders(request);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetHeaders() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("cookie", "JSESSIONID=276D58AC17ABB217997C59EA33414274");

        Map<String, List<String>> expResult = new HashMap<>();
        expResult.put("cookie", Arrays.asList("JSESSIONID=276D58AC17ABB217997C59EA33414274"));

        HeadersService instance = new HeadersService();
        Map<String, List<String>> result = instance.getHeaders(request);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeadersByFilter method, of class HeadersService.
     */
    
    @Test
    public void testGetHeadersByFilter_whenFiltersIsNull() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("cookie", "JSESSIONID=276D58AC17ABB217997C59EA33414274");
        request.addHeader("accept", "text/html");

        List<String> filters = null;
        Map<String, List<String>> expResult = new HashMap<>();

        HeadersService instance = new HeadersService();
        Map<String, List<String>> result = instance.getHeadersByFilter(request, filters);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetHeadersByFilter_whenFiltersIsEmpty() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("cookie", "JSESSIONID=276D58AC17ABB217997C59EA33414274");
        request.addHeader("accept", "text/html");

        List<String> filters = new ArrayList<>();
        Map<String, List<String>> expResult = new HashMap<>();
        
        
        HeadersService instance = new HeadersService();
        Map<String, List<String>> result = instance.getHeadersByFilter(request, filters);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetHeadersByFilter() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("cookie", "JSESSIONID=276D58AC17ABB217997C59EA33414274");
        request.addHeader("accept", "text/html");

        List<String> filters = Arrays.asList("cookie");
        Map<String, List<String>> expResult = new HashMap<>();
        expResult.put("cookie", Arrays.asList("JSESSIONID=276D58AC17ABB217997C59EA33414274"));

        HeadersService instance = new HeadersService();
        Map<String, List<String>> result = instance.getHeadersByFilter(request, filters);
        assertEquals(expResult, result);
    }

}
