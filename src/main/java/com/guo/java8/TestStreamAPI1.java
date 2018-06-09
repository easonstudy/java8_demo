package com.guo.java8;

import com.guo.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 中间操作
 * map
 * 1.接收Lambda表达式  元素转换成其他形式 或者 提取元素
 * 2.接收函数  作用在每个元素上  形成一个新的元素
 * flatMap
 * 接收函数 把流换成另一个流，然后把流连成一个流
 */
public class TestStreamAPI1 {


    @Test
    public void test() {
        emps.stream().map((e) -> e.getAge() > 35);

        emps.stream().map((e) -> {
            e.setAge(e.getAge() + 3);
            return e;
        }).forEach(System.out::println);

        //接收函数 把流换成另一个流，然后把流连成一个流
        List<String> strList = Arrays.asList("1", "2", "3", "4", "5");
        strList.stream().flatMap(TestStreamAPI1::flatMapInteger).forEach(System.out::println);
    }

    public static Stream<Integer> flatMapInteger(String str) {
        Stream<Integer> stream = Stream.of(Integer.parseInt(str));
        return stream;
    }

    @Test
    public void test1() {
        emps.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

        emps.stream()
                .sorted((x, y) -> x.getAge() - y.getAge())
        .forEach(System.out::println);
    }


    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );


}
