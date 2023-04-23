package com.limu.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) throws Exception {

        String className = "com.limu.reflect.User";
        String fieldName = "age";

        String methodName = "set" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1);

        Class<?> clazz = Class.forName(className);

        Field field = clazz.getDeclaredField(fieldName);

        Method setAgeMethod = clazz.getDeclaredMethod(methodName, field.getType());

        Object obj = clazz.newInstance();

        setAgeMethod.invoke(obj, 23);
        System.out.println(obj);
    }
}
