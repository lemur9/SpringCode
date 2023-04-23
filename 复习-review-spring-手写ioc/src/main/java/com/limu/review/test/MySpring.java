package com.limu.review.test;

import com.limu.review.config.TestConfiguration;
import com.limu.review.core.AnnotationConfigApplicationContext;
import com.limu.review.core.ApplicationContext;
import com.limu.review.core.ClassPathXmlApplicationContext;

public class MySpring {
    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object people = applicationContext.getBean("people");
        System.out.println(people);*/

        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        Object people = context.getBean("people");
        System.out.println(people);
        Object address = context.getBean("address");
        System.out.println("address = " + address);
    }

}
