package com.newt.java8.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description log4j2测试
 * @Author zcc
 * @Date 18/09/07
 */
@Slf4j
@RestController
@RequestMapping("log")
public class LoggingController {
    @RequestMapping("hello")
    public  String helloLog4j(){
        log.trace("trace...");
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error..");
        return "My First SpringBoot Logging Frame";
    }
}
