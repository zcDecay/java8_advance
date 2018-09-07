package com.newt.java8;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @Description Java8新特性：时间日期类
 * @Author newt
 * @Date 18/08/27
 */
public class DateTimeTester {

    /**
     * java日期类遗留问题
     * 1、非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的
     * 2、时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在问题。
     *
     * java8添加API
     * 1、Local(本地) − 简化了日期时间的处理，没有时区的问题.
     * 2、Zoned(时区) − 通过制定的时区处理日期时间。
     */
    @Test
    public  void DateTimeTester1(){

        //获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);

        LocalDate localDate = currentTime.toLocalDate();
        System.out.println("localDate" + localDate);


        //年月日时分秒
        int year = currentTime.getYear();
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int seconds = currentTime.getSecond();
        System.out.println("年" + year + "月" + month + "日" + day + "时" + hour + "分" + minute + "秒" + seconds);


        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    /**
     * 时区的时间日期
     */
    @Test
    public  void DateTimeTester2(){
        //包含时区时间
        ZonedDateTime dateTime = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        //默认时区
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);

    }

    /**
     * java.time.temporal.ChronoUnit
     *      枚举代替旧的API用来代表日，月等整数值
     *
     */
    @Test
    public void DateTimeTester3(){
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);
        //add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);
        //add 1 month to the current date
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + nextMonth);
        //add 1 year to the current date
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: " + nextYear);
        //add 10 years to the current date
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("Date after ten year: " + nextDecade);
    }

}
