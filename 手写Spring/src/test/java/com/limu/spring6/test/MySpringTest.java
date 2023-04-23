package com.limu.spring6.test;

import com.limu.myspring.bean.UserService;
import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;


public class MySpringTest {

    @Test
    public void testSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("myspring.xml");
        Object user = context.getBean("user");
        System.out.println(user);

        UserService userService = (UserService) context.getBean("userService");
        userService.save();
    }
}
