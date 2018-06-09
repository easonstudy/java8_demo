package com.guo.java8;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 可重复注解 和 类型注解
 */
public class TestAnno {

    @Test
    public void test() {
        TestAnno obj = new TestAnno();
        Class clazz = obj.getClass();
        try {
            Method m = clazz.getMethod("show");
            m.invoke(obj);
           /* Method m = clazz.getDeclaredMethod("aa");
            m.setAccessible(true);*/
            TestAnnotation[] annotations = m.getAnnotationsByType(TestAnnotation.class);
            Stream<String> stream = Arrays.stream(annotations).map(TestAnnotation::value);
            stream.forEach(System.out::println);

           /* for (int i = 0; i < annotations.length; i++) {
                System.out.println(annotations[i].value());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @TestAnnotation("hello")
    @TestAnnotation("world")
    public void show(@TestAnnotation("abc") String str) {
        System.out.println("show");
    }

}
