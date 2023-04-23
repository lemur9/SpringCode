package com.limu.review.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    public static final Map<String, Object> beanMap = new HashMap<>();

    public ClassPathXmlApplicationContext(String resource) {
        try {
            SAXReader reader = new SAXReader();
            Map<String, Object> map = new HashMap<>();
            //给命名空间取别名
            map.put("spring", "http://www.springframework.org/schema/beans");
            //设置命名空间
            reader.getDocumentFactory().setXPathNamespaceURIs(map);
            Document document = reader.read(ClassLoader.getSystemResourceAsStream(resource));
            List<Element> nodeList = document.selectNodes("//spring:bean");
            try {
                nodeList.forEach(node -> {
                    String beanName = node.attributeValue("id");
                    String clazz = node.attributeValue("class");
                    try {
                        Class<?> aClass = Class.forName(clazz);
                        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                        Object bean = declaredConstructor.newInstance();
                        beanMap.put(beanName, bean);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            nodeList.forEach(node -> {
                String id = node.attributeValue("id");
                String clazz = node.attributeValue("class");
                List<Element> properties = node.elements();
                Object o = beanMap.get(id);
                properties.forEach(property -> {
                    String name = property.attributeValue("name");
                    String value = property.attributeValue("value");
                    String ref = property.attributeValue("ref");
                    try {
                        Class<?> aClass = Class.forName(clazz);
                        Field declaredField = aClass.getDeclaredField(name);
                        Class<?> type = declaredField.getType();
                        Method declaredMethod = aClass.getDeclaredMethod("set" + name.toUpperCase().charAt(0) + name.substring(1), type);
                        String simpleName = type.getSimpleName();
                        Object propertyVal = null;
                        if (value != null) {
                            switch (simpleName) {
                                case "byte":
                                case "Byte":
                                    propertyVal = Byte.valueOf(value);
                                    break;
                                case "short":
                                case "Short":
                                    propertyVal = Short.valueOf(value);
                                    break;
                                case "int":
                                case "Integer":
                                    propertyVal = Integer.valueOf(value);
                                    break;
                                case "long":
                                case "Long":
                                    propertyVal = Long.valueOf(value);
                                    break;
                                case "float":
                                case "Float":
                                    propertyVal = Float.valueOf(value);
                                    break;
                                case "double":
                                case "Double":
                                    propertyVal = Double.valueOf(value);
                                    break;
                                case "boolean":
                                case "Boolean":
                                    propertyVal = Boolean.valueOf(value);
                                    break;
                                case "char":
                                case "Character":
                                    propertyVal = value.charAt(0);
                                    break;
                                case "String":
                                    propertyVal = value;
                                    break;
                            }
                            declaredMethod.invoke(o, propertyVal);
                        } else if (ref != null) {
                            declaredMethod.invoke(o, beanMap.get(ref));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            });


        } catch (
                Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Object getBean(String name) {
        return beanMap.get(name);
    }
}
