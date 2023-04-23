package com.limu.spring.review.cglib.handler;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        long begin = System.currentTimeMillis();

        Object o = methodProxy.invokeSuper(target, objects);

        long end = System.currentTimeMillis();

        long time = end - begin;

        System.out.println("程序耗时：" + time + "毫秒");

        return o;
    }
}
