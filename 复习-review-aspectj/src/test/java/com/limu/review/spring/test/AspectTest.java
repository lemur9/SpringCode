package com.limu.review.spring.test;

import com.limu.review.spring.annotation.Async;
import com.limu.review.spring.aspectj.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
@ContextConfiguration(classes = AspectTest.class)
@Configuration
@ComponentScan("com.limu.review.spring")
@EnableAspectJAutoProxy
//@EnableAsync
public class AspectTest {

    @Autowired
    private UserService userService;

    @Test
    public void testJDKExecution() {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = applicationContext.getBean("userService", UserService.class);*/
        userService.insert();
        System.out.println("------------");
        userService.update(1);
        System.out.println("------------");
        userService.delete();
        System.out.println("------------");
    }

    @Test
    public void testAsync() {
        userService.insert();
        userService.select();
        userService.delete();
    }

}
