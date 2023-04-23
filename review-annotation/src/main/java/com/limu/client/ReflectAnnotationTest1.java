package com.limu.client;

import com.limu.annotation.Component;

public class ReflectAnnotationTest1 {
    public static void main(String[] args) {
        //通过反射机制如何读取注解
        try {
            Class<?> clazz = Class.forName("com.limu.bean.User");
            //判断类上面有没有注解
            if (clazz.isAnnotationPresent(Component.class)) {
                //获取类上的注解
                Component annotation = clazz.getDeclaredAnnotation(Component.class);
                //访问注解属性
                System.out.println(annotation.value());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
