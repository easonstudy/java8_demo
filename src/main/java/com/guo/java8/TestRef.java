package com.guo.java8;

import com.guo.entity.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.function.*;

/**
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 * <p>
 * 1. 对象的引用 :: 实例方法名
 * <p>
 * 2. 类名 :: 静态方法名
 * <p>
 * 3. 类名 :: 实例方法名
 * <p>
 * 注意：
 * ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 * <p>
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * <p>
 * 1. 类名 :: new
 * <p>
 * 三、数组引用
 * <p>
 * 类型[] :: new;
 */
public class TestRef {

    @Test
    public void test1() {
        PrintStream ps = System.out;
        Consumer<String> con = (str) -> ps.println(str);
        con.accept("Hello World！");

        System.out.println("--------------------------------");

        Consumer<String> con2 = ps::println;
        con2.accept("Hello Java8！");

        Consumer<String> con3 = System.out::println;
    }

    /**
     * 对象::方法名
     */
    @Test
    public void test2() {
        Employee emp = new Employee(101, "张三", 18, 9999.99);
        Supplier<String> supplier = emp::getName;
        System.out.println(supplier.get());
    }

    /**
     * //类名:: 静态方法名
     */
    @Test
    public void test3() {
        BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
        System.out.println(fun.apply(1.5, 22.2));

        BiFunction<Double, Double, Double> fun2 = Math::max;
        System.out.println(fun2.apply(1.5, 223.2));

        /*Employee emp = new Employee(101, "张三", 18, 9999.99);
        Supplier<String> aa = Employee::getStatic;*/
    }

    /**
     * 类名 :: 实例方法名
     */
    @Test
    public void test5() {
        BiPredicate<String, String> bi = String::equals;
        System.out.println(bi.test("abcd", "abcd"));

        Function<Employee, String> fun = Employee::show;
        System.out.println(fun.apply(new Employee()));
    }

    /**
     * 构造器引用
     */
    @Test
    public void test6() {
        Supplier<Employee> sup = Employee::new;
        System.out.println(sup.get().toString());

        Function<String, Employee> fun = Employee::new;
        System.out.println(fun.apply("hh"));
    }

    /**
     * 数组 引用
     */
    @Test
    public void test8() {
        Function<Integer, Employee[]> fun   = Employee[]::new;

        System.out.println(fun.apply(20).length);
    }
}
