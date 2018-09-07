package com.newt.java8;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @Description Java8:新特性：Base64
 * @Author newt
 * @Date 18/08/27
 */
public class Base64Tester {

    /**
     * static class Base64.Decoder
     *      该类实现一个解码器用于，使用 Base64 编码来解码字节数据。
     * static class Base64.Encoder
     *      该类实现一个编码器，使用 Base64 编码来编码字节数据。
     */
    @Test
    public  void Base64Tester1(){

        try {
            //基本编码
            String encodeStr = Base64.getEncoder().encodeToString("java8进阶之路".getBytes());
            System.out.println("基本编码:" + encodeStr);

            //解码
            byte[] decodeByte = Base64.getDecoder().decode(encodeStr);
            System.out.println("初始字符串:" + new String(decodeByte,"UTF-8"));

            //URL编码
            encodeStr = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (URL):" + encodeStr);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");

            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }


    }
    @Test
    public  void Base64Tester2(){

    }

}
