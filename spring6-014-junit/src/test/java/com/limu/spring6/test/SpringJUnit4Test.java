package com.limu.spring6.test;

import com.limu.spring6.bean.User;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJUnit4Test {

    @Resource
    private User user;

    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = context.getBean("user", User.class);
        System.out.println(userBean.getName());
    }

    @Test
    public void testUser1() {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = context.getBean("userBean", User.class);*/
        System.out.println(user.getName());
    }

    @Test
    public void testUser2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = context.getBean("user", User.class);
        System.out.println(userBean.getName());
    }
}
