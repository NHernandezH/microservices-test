/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noe.test.citibanamex.controller;

import com.noe.test.citibanamex.service.HeadersService;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.servlet.http.HttpServletRequest;
import org.assertj.core.internal.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author noe_5
 */
@RestController
@RequestMapping(path = "/headers")
public class HeadersController {

    
    private final HttpServletRequest request;
    private final HeadersService headersService;
    
    @Autowired
    public HeadersController(HttpServletRequest request, HeadersService headersService) {
        this.request = request;
        this.headersService = headersService;
    }

    
    @GetMapping
    public ResponseEntity<Map<String,List<String>>> get() {
        
        return new ResponseEntity<>(
                headersService.getHeaders(request),
                HttpStatus.OK);
                
    }

    @GetMapping(path = "/{headerNames}")
    public ResponseEntity<Map<String,List<String>>> getByFilters(@PathVariable List<String> headerNames) {
        
        return new ResponseEntity<>(
                headersService.getHeadersByFilter(request,headerNames),
                HttpStatus.OK);
                
    }
    
}
