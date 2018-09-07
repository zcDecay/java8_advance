package com.newt.java8;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description java新特性：方法引用
 * @Author newt
 * @Date 18/08/22
 */
public class MethodCiteTester {

    /**
     * 方法引用
     * 方法引用通过方法的名字，指向一个方法
     * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
     * 方法引用使用一对冒号 ::
     *
     */
    @Test
    public void methodViteTest1(){
        List names = new ArrayList();

        names.add("Google");
        names.add("Alibaba");
        names.add("Baidu");

        names.forEach(System.out::println);
    }
    /**
     * @FunctionalInterface：声明函数式接口
     * 主要用于编译级错误检查，一个接口只能有一个抽象方法
     * 可以有多个默认方法及静态方法+允许定义java.lang.Object里的public方法（添加@Overwrite）
     * 主要用在Lambda和方法引用
     * 若不填加，接口只有一个抽象方法默认为函数式接口
     *
     */
    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

}

