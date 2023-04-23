package com.limu.reflect;

import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.limu.reflect.SomeService");

        Method doSomeMethod = clazz.getDeclaredMethod("doSome");

        Object obj = clazz.newInstance();
        doSomeMethod.invoke(obj);
    }
}
