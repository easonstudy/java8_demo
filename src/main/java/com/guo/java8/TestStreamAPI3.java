package com.guo.java8;

import com.guo.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 终止操作
 * 归约
 * reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
 * ——可以将流中元素反复结合起来，得到一个值。
 * 汇总
 * collect
 * 将流转换成 其他形式, 接收一个Collector接口实现, 用于给元素做汇总.
 */
public class TestStreamAPI3 {
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Integer sum = list.stream().reduce(1, (x, y) -> x + y);

        System.out.println(sum);

        System.out.println("----------------------------------------");

        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }


    //需求：搜索名字中 “六” 出现的次数
    @Test
    public void test2() {
        Optional<Integer> sum = emps.stream()
                .map(Employee::getName)
                .map((e) -> {
                    if (e.indexOf("六") != -1) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .reduce(Integer::sum);

        System.out.println(sum.get());

        /*Optional<Integer> sum = emps.stream()
                .map(Employee::getName)
                .flatMap(TestStreamAPI1::filterCharacter)
                .map((ch) -> {
                    if (ch.equals('六'))
                        return 1;
                    else
                        return 0;
                }).reduce(Integer::sum);

        System.out.println(sum.get());*/
    }


    //collect
    @Test
    public void test3() {
        List<Integer> list = emps.stream()
                .map(Employee::getAge).sorted()
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);


    }


    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );


}
