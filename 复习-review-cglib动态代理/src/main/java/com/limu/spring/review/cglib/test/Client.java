package com.limu.spring.review.cglib.test;

import com.limu.spring.review.cglib.handler.CglibInterceptor;
import com.limu.spring.review.cglib.service.UserService;
import net.sf.cglib.proxy.Enhancer;

public class Client {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(UserService.class);

        enhancer.setCallback(new CglibInterceptor());

        UserService userService = (UserService) enhancer.create();

        userService.insert();

    }


}
