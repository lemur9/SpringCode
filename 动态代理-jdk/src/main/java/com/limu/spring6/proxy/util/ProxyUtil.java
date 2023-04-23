package com.limu.spring6.proxy.util;

import com.limu.spring6.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 *封装一个工具方法，可以通过这个方法获取代理对象
 */
public class ProxyUtil<T> {
    public static <T> T newProxyInstance(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
    }
}
