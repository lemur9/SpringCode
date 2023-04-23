package com.limu.spring6.aspect.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void generate(){
        System.out.println("生成订单");
        if (this != null) {
            throw new RuntimeException("运行时异常");
        }
    }
}
