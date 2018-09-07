package com.newt.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description Lambda进阶之路
 * @Author newt
 * @Date 18/08/22
 */
public class LambdaTester {

    String title = "newt的进阶之路";
    final static String salutation = "Hello";

    //类型声明
    MathOperation addition = (int a, int b) -> a + b;
    // 不用类型声明
    MathOperation subtraction = (a, b) -> a - b;
    // 大括号中的返回语句
    MathOperation multiplication = (int a, int b) -> { return a * b; };
    // 没有大括号及返回语句
    MathOperation division = (int a, int b) -> a / b;

    /**
     * lambda表达式
     *
     * lambda主要用来定义行内执行方法接口。
     * lambda免去了使用匿名方法的麻烦，java变得简单且拥有强大的函数化的编程能力
     *
     */
    @Test
    public void lambdaTest1(){
        LambdaTester LambdaTester = new LambdaTester();
        System.out.println(LambdaTester.operate(5,5,addition));
        System.out.println(LambdaTester.operate(5,5,subtraction));
        System.out.println(LambdaTester.operate(5,5,multiplication));
        System.out.println(LambdaTester.operate(5,5,division));

        //不需要括号
        GreetingService greetingService = message -> System.out.println(message);
        greetingService.sayMessage("我是谁！");

        //you括号
        GreetingService greetingService2 = (message) -> {
            System.out.println(message);
        };
        greetingService2.sayMessage("我bu是谁！");
    }

    /**
     * lambda变量作用域
     * lambda表达式的局部变量可以不用声明为final，但是不可被后面的代码修改，否则编译会报错（隐性的final定义）。
     * lambda不允许声明与局部变量同名的变量，否则编译会报错。
     */
    @Test
    public void lambdaTest2(){
        int num = 1;
        //Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        //s.convert(2);
        num = 5;

        String first = "";
        //Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());  //编译会出错

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    /**
     * Lambda案例
     */
    @Test
    public void lambdaTest3(){
        String[] strList = {"skr","呦","freestyle","嘻哈"};
        //foreach循环
        List<String> strings = Arrays.asList(strList);
        for (String string :strings) {
            System.out.println(string);
        }

        //Lambda循环
        strings.forEach(str -> System.out.print(str + "--"));
        System.out.println();
        //使用Lambda的【::】操作符，一种简写
        strings.forEach(System.out::println);
    }

    /**
     * Lambda实现Runable接口
     *
     */
    @Test
    public void lambdaTest4(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("普通匿名内部类");
            }
        }).start();

        new Thread(() -> System.out.println("Lambda")).start();

    }

    /**
     * Comparator 类被用来排序集合
     *
     */
    @Test
    public void lambdaTest5(){
        String[] names = {"Nick","Lou","Channing","Burgess","Keith",
                            "Pag","Mamie","Sally","Bing","Lisa",
                            "Wendy","Ethel","Vita","Angelo","Troy"};
        //匿名内部类
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                return (n1.compareTo(n2));
            }
        });

        //Lambda排序
        Comparator<String> sortByName = (String n1, String n2) -> (n1.compareTo(n2));
        Arrays.sort(names, sortByName);

        Arrays.sort(names, (String n1, String n2) -> (n1.compareTo(n2)));
    }
}
