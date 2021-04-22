package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author cyl
 * @create 2021/4/21 21:06
 */
@RestController
@Slf4j
public class FlowLimitController{
    @GetMapping("/testA")
    public String testA() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }
    @GetMapping("/testC")
    public String testC() {
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD(){
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHoKey(@RequestParam(value = "p1", required = false) String p1,
                            @RequestParam(value = "p2", required = false) String p2) {
        log.info("testHotKey 测试");
        int n = 10/ 0;
        return p1 + "---------------------" + p2;
    }

    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }


}

