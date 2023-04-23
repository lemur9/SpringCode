package com.limu.spring6.test;

import cn.limu.spring6.Spring6Config;
import cn.limu.spring6.service.StudentService;
import com.limu.spring6.bean.Order;
import com.limu.spring6.bean.Student;
import com.limu.spring6.bean.User;
import com.limu.spring6.bean.Vip;
import com.limu.spring6.bean3.MyDataSource;
import com.limu.spring6.bean3.Product;
import com.limu.spring6.dao.OrderDao;
import org.junit.Test;
import org.limu.spring6.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocAnnotationTest {

    @Test
    public void testNoXML() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

    @Test
    public void testResource() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

    @Test
    public void testAutowired() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testDIByAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = context.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);

        Product product = context.getBean("product", Product.class);
        System.out.println(product);
    }

    @Test
    public void testBeanComponent2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-choose.xml");
    }

    @Test
    public void testBeanComponent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = context.getBean("userBean", User.class);
        Vip vip = context.getBean("vip", Vip.class);
        Order orderBean = context.getBean("orderBean", Order.class);
        Student studentBean = context.getBean("studentBean", Student.class);
        OrderDao orderDao = context.getBean("orderDao", OrderDao.class);
        System.out.println(userBean);
        System.out.println(vip);
        System.out.println(orderBean);
        System.out.println(studentBean);
        System.out.println(orderDao);
    }
}
