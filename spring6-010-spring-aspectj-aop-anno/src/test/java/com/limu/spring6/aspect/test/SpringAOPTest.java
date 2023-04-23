package com.limu.spring6.aspect.test;

import com.limu.spring6.aspect.service.OrderService;
import com.limu.spring6.aspect.service.Spring6Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {

    @Test
    public void testNoXml() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testBefore() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        /*UserService userService = context.getBean("userService", UserService.class);
        userService.login();
        userService.logout();*/
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
    }
}
