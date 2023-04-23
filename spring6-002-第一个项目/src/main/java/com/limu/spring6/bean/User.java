package com.limu.spring6.bean;

public class User {
    //spring是如何实例化对象的
    //默认情况下spring会通过反射机制，调用类的无参数构造方法来实例化对象的。
    // 实现原理：
    //    Class<?> Clazz = Class.forName("com.limu.spring6.bean.User");
    //    Object obj = Clazz.newInstance();

    public User() {
        System.out.println("调用了User的无参数构造方法");
    }

    public User(String name) {

    }


}
