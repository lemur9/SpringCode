package com.limu.spring6.test;

import com.limu.spring6.bean.Student;
import com.limu.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

    @Test
    public void testRegisterBean() {
        //自己new的对象
        Student student = new Student();
        System.out.println(student);

        //将以上自己new的这个对象交给Spring容器来管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("student",student);

        //从Spring容器中获取
        Student student1 = factory.getBean("student", Student.class);
        System.out.println(student1);
    }

    /**
     * Spring容器只对singleton的Bean进行完整的生命周期管理。
     * 如果是prototype作用域的Bean，Spring容器只负责将该Bean初始化完毕。等客户端程序一旦获取到该Bean之后，Spring容器就不再管理这个对象的生命周期了
     */
    @Test
    public void testBeanLifecycleFive() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第六步：使用Bean：" + user);

        //注意：必须手动关闭Spring容器，这样Spring容器才会销毁Bean。
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }
}
