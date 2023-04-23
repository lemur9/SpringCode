package com.limu.review.beanLife.test;

import com.limu.review.beanLife.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanLifeTest {

    @Test
    public void testBeanLife() {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring.xml");
        User user = new User();
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerSingleton("user",user);
        User userBean = defaultListableBeanFactory.getBean("user", User.class);
        userBean.toString();
        application.close();
    }
}
