package com.newt.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Description java8新特性：流Stream
 * @Author newt
 * @Date 18/08/27
 */
public class StreamTester {

    /**
     * Java 8 API添加了一个新的抽象称为流Stream，可以以一种声明方式处理数据
     * 将要处理的元素集合看做为一种流，流在管道中传输，并且可以在管道中的节点上可行处理，比如筛选，排序，聚合等
     * 元素流在管道中经过中间操作（intermediate operation）的处理，最终由最终操作（terminal operation）得到处理结果
     *
     * +--------------------+       +------+   +------+   +---+   +-------+
     * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
     * +--------------------+       +------+   +------+   +---+   +-------+
     */
    /**
     *
     * Stream定义
     * Stream是一个来自数据源的元素队列并支持聚合操作
     * 1、元素是特定类型的对象，形成一个队列，Stream并不会存储元素，而是按需计算
     * 2、数据源 流的来源，可以是集合，数组，i/o channel，产生器generator等
     * 3、聚合操作 类似SQL语句一样的操作，例：filter，map，reduce，find，match，sorted等
     * 基础特征
     * 1、Pipelining 中间操作都会返回流对象本身，这样多个操作可以串联成一个管道。这样可以对操作进行优化。
     * 2、内部迭代 以前集合遍历都是通过iterator/for-each方式，显示在集合内部进行迭代（外部迭代），Stream提供了内部迭代的方式，通过访问者（Visitor）进行实现
     */

    /**
     *
     * Stream 生成流
     * stream()：为集合创建串行流（单线程操作）
     * parallelStream()：为集合创建并行流(把一个内容分为多个数据块，并用不同线程分别处理每个数据块流)及多线程操作
     */
    @Test
    public  void StreamTester1(){
        List<String> lists = Arrays.asList("a", "b", "c", "d", "f", "g", "h");
        List<String> collect = lists.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
    }
    /**
     * forEach
     * 迭代流中的每个数据
     *
     */
    @Test
    public  void StreamTester2(){

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    /**
     * map
     * 用于映射每个元素到对应结果.
     *
     */
    @Test
    public void StreamTester3(){
        List<Integer> intNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 6);
        //i * i 映射到 i
        intNum.stream().distinct().map(i -> i * i).forEach(num -> System.out.println(num));

    }

    /**
     *
     * filter
     * 通过设置的条件过滤出元素
     *
     */
    @Test
    public void StreamTester4(){
        List<String> strings = Arrays.asList("zc", "", "zcc", "zcc", "zzz","", "ccc");
        //过滤i不是空的值，去重，映射每个值拼接zc，生成list，遍历输出
        strings.stream().filter(i -> !i.isEmpty()).distinct().map(i -> i + "zc").collect(Collectors.toList()).forEach(System.out::println);

    }


    /**
     * limit
     * 获取指定数量的流
     * sorted
     * 对流进行排序
     */
    @Test
    public  void StreamTester5(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

    }
    /**
     * parallel
     * 并行（多线程操作）
     *
     */
    @Test
    public  void StreamTester6(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }

    /**
     * Collectors
     * 实现了很多的规约操作，将流转化为集合，聚合元素。也可用于返回列表/字符串
     *
     */
    @Test
    public void StreamTester7(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("Collectors：转换集合");
        strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()).forEach(System.out::println);

        String collect = strings.stream().collect(Collectors.joining(","));
        System.out.println("Collectors 合并字符串" + collect);

    }

    /**
     * 统计
     * 产生统计结果的收集器
     * 主要用于int，double，long等基本数据类型上
     *
     */
    @Test
    public void StreamTester8(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics statistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("总数" + statistics.getCount());
        System.out.println("最大值" + statistics.getMax());
        System.out.println("最小值" + statistics.getMin());
        System.out.println("总值" + statistics.getSum());

    }








}
