package com.guo.java8;

import com.guo.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1:创建stream api
 * 2:中间操作
 * 3:终止操作(终端操作)
 */
public class TestStreamAPI {

    /**
     * 创建stream api
     */
    @Test
    public void test() {
        //Collection 新增的2个方法stream() 和 parallelStream()
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();
        Stream<Integer> parallelStream = list.parallelStream();

        //数组Arrays新增stream()方法
        int[] a = new int[10];
        IntStream intStream = Arrays.stream(a);

        //Stream
        //of
        Stream<String> stringStream = Stream.of("a", "b", "c");

        //迭代
        Stream<Integer> stream1 = Stream.iterate(0, (e) -> e + 2).limit(10);
        stream1.forEach(System.out::println);

        //生成
        Stream stream2 = Stream.generate(Math::random).limit(2);
        stream2.forEach(System.out::println);
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

    /**
     * 中间操作
     * 筛选和切片
     * filter——接收 Lambda ， 从流中排除某些元素。
     * limit——截断流，使其元素不超过给定数量。
     * skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
     * distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     */

    //内部迭代
    @Test
    public void tes1() {
        Stream<Employee> stream = emps.stream().filter((e) -> {
            System.out.println("测试中间操作");
            return e.getAge() > 35;
        });
        System.out.println("----------");
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void tes2() {
        Iterator<Employee> iterator = emps.stream().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test5(){
        emps.parallelStream()
                .filter((e) -> e.getSalary() >= 5000)
                //.skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test6(){
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
