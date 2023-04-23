package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger log = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析mySpring配置文件，然后初始化所有的Bean对象
     *
     * @param configLocation spring配置文件的路径。注意：使用ClassPathXmlApplicationContext，配置文件应当放到类路径下。
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            // 解析myspring配置文件，然后实例化Bean，将Bean存放到singletonObjects集合中
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);

            //获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");

            nodes.forEach(node -> {
                try {
                    //向下转型的目的是为了使用Element接口里更加丰富的方法
                    Element element = (Element) node;

                    //获取id属性
                    String id = element.attributeValue("id");
                    //获取class属性
                    String className = element.attributeValue("class");
                    log.info("beanName=" + id);
                    log.info("className=" + className);

                    //通过反射机制创建对象，将其放到Map集合中，提前曝光
                    //获取Class
                    Class<?> aClass = Class.forName(className);
                    //获取无参数构造方法
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                    //调用无参数构造方法实例化Bean
                    Object bean = declaredConstructor.newInstance();
                    //将Bean曝光，加入到Map集合
                    singletonObjects.put(id, bean);
                    //记录日志
                    log.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });


            //再次循环bean标签，这一次主要是个对象的属性赋值
            nodes.forEach(node -> {
                try {
                    Element beanElt = (Element) node;
                    //获取id
                    String id = beanElt.attributeValue("id");
                    //获取className
                    String className = beanElt.attributeValue("class");
                    //获取Class
                    Class<?> aClass = Class.forName(className);
                    //获取该bean标签下所有的属性properties标签
                    List<Element> properties = beanElt.elements("property");
                    //遍历所有的属性标签
                    properties.forEach(property -> {
                        try {
                            //获取属性名
                            String propertyName = property.attributeValue("name");
                            //获取属性类型
                            Field field = aClass.getDeclaredField(propertyName);
                            log.info("属性名：" + propertyName);
                            //获取set方法名
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            //获取set方法
                            Method setMethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                            //调用set方法
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");
                            Object actualValue = null;
                            if (value != null) {
                                //说明这个值是简单类型
                                //调用set方法（set方法没有返回值）

                                //获取属性类型名
                                String propertyTypeSimpleName = field.getType().getSimpleName();
                                switch (propertyTypeSimpleName) {
                                    case "byte":
                                        actualValue = Byte.parseByte(value);
                                        break;
                                    case "short":
                                        actualValue = Short.parseShort(value);
                                        break;
                                    case "int":
                                        actualValue = Integer.parseInt(value);
                                        break;
                                    case "long":
                                        actualValue = Long.parseLong(value);
                                        break;
                                    case "float":
                                        actualValue = Float.parseFloat(value);
                                        break;
                                    case "double":
                                        actualValue = Double.parseDouble(value);
                                        break;
                                    case "boolean":
                                        actualValue = Boolean.parseBoolean(value);
                                        break;
                                    case "char":
                                        actualValue = value.charAt(0);
                                        break;
                                    case "Byte":
                                        actualValue = Byte.valueOf(value);
                                        break;
                                    case "Short":
                                        actualValue = Short.valueOf(value);
                                        break;
                                    case "Integer":
                                        actualValue = Integer.valueOf(value);
                                        break;
                                    case "Long":
                                        actualValue = Long.valueOf(value);
                                        break;
                                    case "Float":
                                        actualValue = Float.valueOf(value);
                                        break;
                                    case "Double":
                                        actualValue = Double.valueOf(value);
                                        break;
                                    case "Boolean":
                                        actualValue = Boolean.valueOf(value);
                                        break;
                                    case "Character":
                                        actualValue = Character.valueOf(value.charAt(0));
                                        break;
                                    case "String":
                                        actualValue = value;
                                        break;
                                }
                                setMethod.invoke(singletonObjects.get(id), actualValue);
                            } else if (ref != null) {
                                setMethod.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                            }
                            //说明这个值不是简单类型
                            //调用set方法（set方法没有返回值）

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
