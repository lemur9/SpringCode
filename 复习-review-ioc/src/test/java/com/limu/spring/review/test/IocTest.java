package com.limu.spring.review.test;

import com.limu.spring.review.domain.Order;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {

    @Test
    public void testFactoryIoc(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println(order);
    }
}
