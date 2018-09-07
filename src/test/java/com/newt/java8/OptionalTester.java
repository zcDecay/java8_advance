package com.newt.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * @Description java8新特性:Optional
 * @Author newt
 * @Date 18/08/28
 */
public class OptionalTester {
    Integer integer1 = null;
    Integer integer2 = new Integer(10);
    //返回空的Optional
    Optional<Integer> emptyOpt = Optional.empty();


    /**
     * Optional类是一个可以为null的容器，来处理代码表示可用不可用
     * Optional是一个容器，可以保存类型T的值/保存null。Optional提供了很多对于null的方法，不需要显示的进行控制
     * 很好的解决了空指针异常
     *
     */
    @Test
    public  void OptionalTester1(){}

    /**
     *
     * 	static <T> Optional<T> of(T value)
     * 	    返回一个指定非null值的Optional。(若值为null直接抛NullPointerException异常)
     *  static <T> Optional<T> ofNullable(T value)
     *      如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional。
     *  T get()
     *      如果在这个Optional中包含这个值，返回值，否则抛出异常：NoSuchElementException
     *  static <T> Optional<T> empty()
     *      返回空的Optional
     */
    @Test
    public void Optional2(){

        Optional<Object> emptyOpt = Optional.empty();

        Optional<Integer> opt1 = Optional.of(integer1);
        Optional<Integer> opt2 = Optional.ofNullable(integer1);

        System.out.println(opt1.get());
        System.out.println(opt2.get());
    }
    /**
     *  boolean isPresent()
     *      如果值存在返回true，否则返回 false。
     *  void ifPresent(Consumer<? super T> consumer)
     *      如果值存在则使用该值调用 consumer , 否则不执行
     */
    @Test
    public void Optional3(){
        boolean present = emptyOpt.isPresent();
        emptyOpt.ifPresent(i -> System.out.println(i));
        System.out.println(present);

    }
    /**
     *  Optional<T> filter(Predicate<? super <T> predicate)
     *      如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Optional。
     *
     */
    @Test
    public void Optional4(){
        Optional<Integer> opt = emptyOpt.filter(val -> val.intValue() > 5);
        System.out.println(opt.get());
    }
    /**
     *  T orElse(T other)
     *      如果存在该值，返回值， 否则返回 other。
     *  T orElseGet(Supplier<? extends T> other)
     *      如果存在该值，返回值， 否则触发 other，并返回 other 调用的结果。
     */
    @Test
    public void Optional5(){


        //如果存在该值，返回值， 否则返回 other。
        Integer integer = emptyOpt.orElse(-999);
        System.out.println(emptyOpt.orElseGet(() -> 123));


    }
    /**
     * <U>Optional<U> map(Function<? super T,? extends U> mapper)
     *      如果存在该值，提供的映射方法，如果返回非null，返回一个Optional描述结果。
     * <U> Optional<U> flatMap(Function<? super T,Optional<U>> mapper)
     *      如果值存在，返回基于Optional包含的映射方法的值，否则返回一个空的Optional
     */
    @Test
    public void Optional6(){
        Optional<String> test = Optional.ofNullable("abcD");

        //将值修改为大写
        Optional<String> less3 = test.map((value) -> value.toUpperCase());
        //打印结果 ABCD
        System.out.println(less3.orElse("值为null，不打印！"));

        //使用flatMap，将值修改为大写
        Optional<String> less4 = test.flatMap((value) -> Optional.ofNullable(value.toUpperCase()));
        //打印结果 ABCD
        System.out.println(less4.orElse("值为null，不打印！"));
    }

}
