package com.guo.java8;

import org.junit.Test;

/**
 * 2.函数式接口
 *  Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 */
public class TestFunctionInterface {

    @Test
    public void fi1() {
        Runnable r = () -> {
            System.out.println("bb");
        };
        new Thread(r).start();
    }
}
