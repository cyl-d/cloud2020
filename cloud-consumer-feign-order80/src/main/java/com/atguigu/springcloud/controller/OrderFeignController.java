package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author cyl
 * @create 2021/4/20 18:21
 */
@RestController
public class OrderFeignController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/payment/create", method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment){ //埋雷
       return paymentFeignService.create(payment);
    }

    @RequestMapping(value = "/payment/get/{id}", method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }


}
