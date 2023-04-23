package com.limu.spring6.test;

import com.limu.spring6.bean.Husband;
import com.limu.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {

    @Test
    public void testConstructorOfSingleton() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Husband husbandBean = applicationContext.getBean("hus", Husband.class);
        Wife wifeBean = applicationContext.getBean("wf", Wife.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }

    @Test
    public void testCDofPrototype(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husband", Husband.class);
        Wife wifeBean = applicationContext.getBean("wife", Wife.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }

    @Test
        public void testCDofSingleton(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }
}
