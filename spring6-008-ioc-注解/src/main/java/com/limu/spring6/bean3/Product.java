package com.limu.spring6.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {

//    @Value("李木")
    private String name;

//    @Value("23")
    private int age;

    public Product(@Value("王五") String name,@Value("12") int age) {
        this.name = name;
        this.age = age;
    }

    //@Value注解也可以使用在方法上
   /*@Value("张三")
    public void setName(String name) {
        this.name = name;
    }

    @Value("32")
    public void setAge(int age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
