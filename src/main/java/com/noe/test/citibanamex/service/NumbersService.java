/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noe.test.citibanamex.service;

import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 *
 * @author noe_5
 */
@Service
public class NumbersService {
    
    public Integer[] removeDuplicates(Integer[] numbers){
    
        if (numbers == null){
            return new Integer[0];
        }
        
        return Stream.of(numbers)
                        .distinct()
                        .toArray(s -> new Integer[s]);
    }
}
