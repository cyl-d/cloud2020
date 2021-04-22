package com.atguigu.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entites.CommonResult;

/**
 * @Author cyl
 * @create 2021/4/22 9:32
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException e) {
        return new CommonResult(444,e.getClass().getCanonicalName()+"\t 服务不可用");
    }

}
