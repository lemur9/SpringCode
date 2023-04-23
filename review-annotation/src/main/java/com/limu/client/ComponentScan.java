package com.limu.client;

import com.limu.annotation.Component;

import java.io.*;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String packageName = "com.limu.bean";

        Map<String, Object> singletonObjects = new HashMap<>();

        //.这个正则表达式代表任意字符。这里的"."必须是一个普通的"."字符。不能是正则表达式中的"."
        String packagePath = packageName.replaceAll("\\.", "/");
        //com是类的根路径下的一个目录
        URI uri = null;
        try {
            uri = ClassLoader.getSystemClassLoader().getResource(packagePath).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String path = uri.getPath();
        File file = new File(path);
        File[] list = file.listFiles();
        Arrays.stream(list).forEach(f -> {
            try {
                String className = packageName + "." + f.getName().split("\\.")[0];
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(Component.class)) {
                    Component component = clazz.getDeclaredAnnotation(Component.class);
                    String value = component.value();
                    Constructor<?> constructor = clazz.getConstructor();
                    Object obj = constructor.newInstance();
                    singletonObjects.put(value, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(singletonObjects);
    }
}
