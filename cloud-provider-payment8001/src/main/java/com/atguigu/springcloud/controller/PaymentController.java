package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author cyl
 * @create 2021/4/19 20:05
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    String port;

    @Value("${server.port}")
    String serverPort;
    @RequestMapping(value = "/payment/create", method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment){ //埋雷
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result>0){  //成功
            return new CommonResult(200,"插入数据库成功" + port,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @RequestMapping(value = "/payment/get/{id}", method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        if (payment != null){  //说明有数据，能查询成功
            return new CommonResult(200,"查询成功" + port,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e) {
            e.printStackTrace();
        } //单位秒
        System.out.println(port);
        System.out.println(serverPort);
        return serverPort;
    }
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi ,i'am paymentzipkin server，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
