package com.limu.reflect;

import java.lang.reflect.Method;

public class Test2 {

    public static void main(String[] args) throws Exception {

        //使用反射机制调用方法
        //获取类
        Class<?> clazz = Class.forName("com.limu.reflect.SomeService");

        //获取方法
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);

        //获取对象
        Object obj = clazz.newInstance();

        //调用方法
        // 四要素：哪个对象，哪个方法，传哪个参数，返回值
        Object o = doSomeMethod.invoke(obj, "李四", 23);
        System.out.println(o);
    }
}
