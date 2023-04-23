package com.limu.review.core;

import com.limu.review.annotation.Component;
import com.limu.review.annotation.ComponentScan;
import com.limu.review.annotation.Configuration;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnnotationConfigApplicationContext implements ApplicationContext {

    private static Map<String, Object> beanFactory = ClassPathXmlApplicationContext.beanMap;

    public AnnotationConfigApplicationContext(Class<?>[] classNames, String[] packageNames) {
        if (classNames != null) {
            for (Class<?> className : classNames) {
                if (className.isAnnotationPresent(Configuration.class)) {
                    ComponentScan componentScan = className.getDeclaredAnnotation(ComponentScan.class);
                    if (componentScan.value() != null) {
                        packageNames = componentScan.value();
                    }else if (componentScan.basePackageClasses() != null){
                        Class<?>[] classes = componentScan.basePackageClasses();
                        String[] names = {};
                        for (int i = 0; i < classes.length; i++) {
                            names[i] = classes[i].getPackage().getName();
                        }
                    }
                }
            }
        }

        if (packageNames != null) {
            try {
                for (String packageName : packageNames) {
                    String path = ClassLoader.getSystemResource(packageName.replaceAll("\\.", "/")).toURI().getPath();
                    File file = new File(path.substring(1));
                    parseFile(file);
                    for (int i = 0; i < fileNames.size(); i++) {
                        String clazz = fileNames.get(i);
                        clazz = clazz.substring(clazz.lastIndexOf(packageName), clazz.lastIndexOf("."));
                        String beanName = clazz.substring(clazz.lastIndexOf(".") + 1).toLowerCase();
                        fileNames.set(i, clazz);
                        Class<?> aClass = null;

                        aClass = Class.forName(clazz);

                        if (aClass.isAnnotationPresent(Component.class)) {
                            Component declaredAnnotation = aClass.getDeclaredAnnotation(Component.class);
                            String value = declaredAnnotation.value();
                            if (!"".equals(value)) {
                                beanName = value;
                            }
                            Constructor<?> constructor = aClass.getConstructor();
                            Object o = constructor.newInstance();
                            beanFactory.put(beanName, o);
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public AnnotationConfigApplicationContext(Class<?>... className) {
        this(className,null);
    }

    public AnnotationConfigApplicationContext(String... packageName) {
        this(null,packageName);
    }

    private static List<String> fileNames = new ArrayList<>();

    private static void parseFile(File file) {

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                fileNames.add(file1.getAbsoluteFile().toURI().getPath().substring(1).replaceAll("/", "."));
            } else {
                parseFile(file1);
            }
        }
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.get(name);
    }
}
