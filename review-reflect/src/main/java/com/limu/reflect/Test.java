package com.limu.reflect;

public class Test {

    public static void main(String[] args) {
        //不使用反射机制调用这些方法
        SomeService someService = new SomeService();
        someService.doSome();

        /**
         * 分析：调用一个方法，当中含有几个要素？四要素
         * 第一个要素：调用哪个对象
         * 第二个要素：调用哪个方法
         * 第三个要素：调用方法时传递什么参数
         * 第四个要素：返回值
         */
        String s1 = someService.doSome("张三");
        System.out.println(s1);

        String s2 = someService.doSome("张三", 1);
        System.out.println(s2);

    }

}
