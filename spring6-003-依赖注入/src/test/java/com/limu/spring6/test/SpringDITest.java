package com.limu.spring6.test;

import com.limu.spring6.bean.*;
import com.limu.spring6.jdbc.MyDataSource;
import com.limu.spring6.jdbc.MyDataSource1;
import com.limu.spring6.jdbc.MyDataSource2;
import com.limu.spring6.service.CustomerService;
import com.limu.spring6.service.OrderService;
import com.limu.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource myDateSourceBean = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(myDateSourceBean);
    }

    @Test
    public void testAutowire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
//        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
//        orderService.generate();
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        customerService.save();
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);
        System.out.println(ds1);
        System.out.println(ds2);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testMathBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println(mathBean);
    }

    @Test
    public void testCat() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Cat catBean = applicationContext.getBean("catBean", Cat.class);
        System.out.println(catBean);
    }

    @Test
    public void testCollection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testArray() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        StrArray strArrayBeans = applicationContext.getBean("strArrayBean", StrArray.class);
        System.out.println(strArrayBeans);
    }

    @Test
    public void testCascade() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
        Clazz clazz = applicationContext.getBean("clazzBean", Clazz.class);
        System.out.println(clazz);
    }

    @Test
    public void testMyDataSource() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource myDateSourceBean = applicationContext.getBean("myDateSourceBean", MyDataSource.class);
        System.out.println(myDateSourceBean);
    }

    @Test
    public void testSimpleTypeSet2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        SimpleValueType svt = applicationContext.getBean("svt", SimpleValueType.class);
        System.out.println(svt);
    }

    @Test
    public void testSimpleTypeSet() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }

    @Test
    public void testSetDI2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderService.generate();

        OrderService orderService2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderService2.generate();
    }

    @Test
    public void testConstructorDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        customerService.save();

        CustomerService customerService2 = applicationContext.getBean("customerService2", CustomerService.class);
        customerService2.save();

        CustomerService customerService3 = applicationContext.getBean("customerService3", CustomerService.class);
        customerService3.save();

    }

    @Test
    public void testSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.saveUser();
    }
}
