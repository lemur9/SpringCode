package com.limu.spring.review.cglib.service;

public class UserService {

    public void insert() {
        System.out.println("程序正在运行中，请稍等");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("新增了一条数据");
    }
}
