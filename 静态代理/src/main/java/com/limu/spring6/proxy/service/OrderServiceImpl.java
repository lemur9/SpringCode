package com.limu.spring6.proxy.service;

public class OrderServiceImpl implements OrderService {
    @Override
    public void generate() {
        //模拟耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成！");
    }

    @Override
    public void modify() {
        //模拟耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改！");
    }

    @Override
    public void detail() {
        //模拟耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单详情");
    }
}
