package com.limu.spring6.proxy.service;

public interface OrderService {

    String getName();

    /**
     * 生成订单
     */
    void generate();

    /**
     * 修改订单信息
     */
    void modify();

    /**
     * 查看订单详情
     */
    void detail();
}
