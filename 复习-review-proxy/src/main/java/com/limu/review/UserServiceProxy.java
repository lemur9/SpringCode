package com.limu.review;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceProxy implements InvocationHandler {

    private Object target;

    public UserServiceProxy() {
    }

    public UserServiceProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String invoke = (String) method.invoke(target, args);
        return invoke + ",我是被代理类对象添加的。";
    }
}
