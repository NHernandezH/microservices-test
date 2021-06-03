/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noe.test.citibanamex.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * @author noe_5
 */
public class EnumerationStream {

    public static <T> Stream<T> stream(Enumeration<T> enumeration) {

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        new Iterator<T>() {
                    @Override
                    public T next() {
                        return enumeration.nextElement();
                    }

                    @Override
                    public boolean hasNext() {
                        return enumeration.hasMoreElements();
                    }

                    @Override
                    public void forEachRemaining(Consumer<? super T> action) {
                        while (enumeration.hasMoreElements()) {
                            action.accept(enumeration.nextElement());
                        }
                    }
                },
                        Spliterator.ORDERED), false);
    }

}
