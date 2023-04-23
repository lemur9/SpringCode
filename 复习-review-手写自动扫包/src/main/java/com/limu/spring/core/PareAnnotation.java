package com.limu.spring.core;

import com.limu.spring.annotation.Component;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PareAnnotation {
    public static BeanFactory packageScan(String packageName) throws URISyntaxException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        String path = ClassLoader.getSystemResource(packageName.replaceAll("\\.", "/")).toURI().getPath();
        File file = new File(path.substring(1));
        parseFile(file);
        for (int i = 0; i < fileNames.size(); i++) {
            String clazz = fileNames.get(i);
            clazz = clazz.substring(clazz.lastIndexOf(packageName), clazz.lastIndexOf("."));
            String beanName = clazz.substring(clazz.lastIndexOf(".")+1).toLowerCase();
            fileNames.set(i, clazz);
                Class<?> aClass = Class.forName(clazz);
                if (aClass.isAnnotationPresent(Component.class)) {
                    Component declaredAnnotation = aClass.getDeclaredAnnotation(Component.class);
                    String value = declaredAnnotation.value();
                    if (!"".equals(value)) {
                        beanName = value;
                    }
                    Constructor<?> constructor = aClass.getConstructor();
                    Object o = constructor.newInstance();
                    beanFactory.registerSingleton(beanName, o);
            }
        }

        return beanFactory;
    }

    private static List<String> fileNames = new ArrayList<>();

    private static void parseFile(File file) {

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                fileNames.add(file1.getAbsoluteFile().toURI().getPath().substring(1).replaceAll("/", "."));
                break;
            }
            parseFile(file1);
        }
    }
}
