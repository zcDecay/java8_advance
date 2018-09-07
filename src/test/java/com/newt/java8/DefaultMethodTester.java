package com.newt.java8;

import org.junit.Test;

/**
 * @Description java8新特性：默认方法
 * @Author newt
 * @Date 18/08/22
 */
public class DefaultMethodTester {

    /**
     * 默认方法
     * 接口可以有实现方法，而且不需要实现类去实现其方法。
     * 只需要在方法名前面加上default关键字即可实现默认方法
     * 为了解决接口的修改与现有的实现不兼容的问题。
     */
    @Test
    public void defaultMethod1(){
    }

    /**
     * 实现的接口拥有相同的默认方法
     * 解决：
     *      1.创建默认方法，覆盖重写接口的默认方法
     *      2.使用super调用指定接口的默认方法
     * 静态默认方法
     * 接口可以声明（并且可以提供实现）静态方法。
     *
     */
    public class defaultA implements defaultM,defaultF {
        public void say(){
            defaultM.super.say();
            defaultF.super.say();
            defaultM.sayWay();
            defaultF.sayWay();
        }
    }

    public interface defaultM {
        default void say(){
            System.out.println("我是默认方法M!");
        }

        static void sayWay(){
            System.out.println("我是defaultM的静态方法");
        }
    }
    public interface defaultF {
        default void say(){
            System.out.println("我是默认方法F!");
        }

        static void sayWay(){
            System.out.println("我是defaultF的静态方法");
        }
    }


}
