package com.limu.review;

import java.lang.reflect.Proxy;

public class Test {

    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {
        UserService userService = (UserService) Proxy.newProxyInstance(userServiceImpl.getClass().getClassLoader(), userServiceImpl.getClass().getInterfaces(), new UserServiceProxy(userServiceImpl));
        System.out.println(userService.getUser());
    }
}
