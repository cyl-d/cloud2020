package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cyl
 * @create 2021/4/22 9:30
 */
@RestController
public class RateLimitController {

    @SentinelResource(value = "byResource", blockHandler = "handleException", blockHandlerClass = CustomerBlockHandler.class)
    @GetMapping("/byResource")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }


}
