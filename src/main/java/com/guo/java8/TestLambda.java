package com.guo.java8;

import com.guo.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 箭头操作符将 Lambda 表达式拆分成两部分：
 * <p>
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 * <p>
 * 语法格式一：无参数，无返回值
 * () -> System.out.println("Hello Lambda!");
 * <p>
 * 语法格式二：有一个参数，并且无返回值
 * (x) -> System.out.println(x)
 * <p>
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * x -> System.out.println(x)
 * <p>
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 * Comparator<Integer> com = (x, y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x, y);
 * };
 * <p>
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * <p>
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * (Integer x, Integer y) -> Integer.compare(x, y);
 * <p>
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * <p>
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。
 * 可以使用注解 @FunctionalInterface 修饰  可以检查是否是函数式接口
 */
public class TestLambda {

    @Test
    public void lambda1() {
        int num = 1; // 1.7之前 需要加final
        Runnable r = () -> {
            System.out.println("num:" + num);
        };
        r.run();
    }

    @Test
    public void lambda2() {
        TreeSet set = new TreeSet(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        TreeSet<String> set1 = new TreeSet<>((x, y) -> Integer.compare(x.length(), y.length()));
    }

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    /**
     * stream api
     */
    @Test
    public void lambda3() {
        //年龄大于20
        emps.stream()
                .filter((e) -> e.getAge() > 20)
                .limit(2)
                .forEach(System.out::println);

        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
