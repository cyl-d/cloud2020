package com.atguigu.springcloud.service;

/**
 * @Author cyl
 * @create 2021/4/20 19:07
 */
public interface PaymentService {

    String paymentInfo_OK(Integer id);
    String payment_Timeout(Integer id);
    String paymentCircuitBreaker(Integer id);
}
