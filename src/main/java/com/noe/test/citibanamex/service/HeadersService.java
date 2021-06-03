/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noe.test.citibanamex.service;

import com.noe.test.citibanamex.util.EnumerationStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javafx.util.Pair;
import javax.servlet.http.HttpServletRequest;
import org.assertj.core.data.MapEntry;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

/**
 *
 * @author noe_5
 */
@Service
public class HeadersService {
    
    public Map<String,List<String>> getHeaders(HttpServletRequest request){
       
        Enumeration<String> headerNames = request.getHeaderNames();
        
        return EnumerationStream.stream(headerNames)
                .map((name) -> getData(name,request))
                .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                
    }
    
    public Map<String,List<String>> getHeadersByFilter(HttpServletRequest request, List<String> headersNames){
        
        if (headersNames == null ){
            return new HashMap<>();
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        
        return EnumerationStream.stream(headerNames)
                .filter((name) -> headersNames.contains(name))
                .map((name) -> getData(name,request))
                .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                
    }
    
    private Entry<String, List<String>> getData(String name, HttpServletRequest request){
        
        return new AbstractMap.SimpleEntry<>(
                name,Arrays.asList(request.getHeader(name).split(","))
        );
        
    }
}
