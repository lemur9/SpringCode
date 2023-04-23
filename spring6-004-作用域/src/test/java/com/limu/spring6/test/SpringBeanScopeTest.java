package com.limu.spring6.test;

import com.limu.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {

    @Test
    public void testThreadScope() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean scope1 = appContext.getBean("scope", SpringBean.class);
        System.out.println(scope1);
        SpringBean scope2 = appContext.getBean("scope", SpringBean.class);
        System.out.println(scope2);

        new Thread(new Runnable() {

            @Override
            public void run() {
                SpringBean sb1 = appContext.getBean("scope", SpringBean.class);
                System.out.println(sb1);
                SpringBean sb2 = appContext.getBean("scope", SpringBean.class);
                System.out.println(sb2);
            }
        }).start();
    }

    @Test
    public void testBeanScope() {

        /**
         * 1.spring默认情况下是如何管理这个Bean的：
         *      默认情况下Bean是单例的。(单例：singleton)
         *      在spring上下文初始化的时候实例化
         *      每一次调用getBean()方法的时候，都返回那个单例的对象
         * 2.当将bean的scope属性设置成prototype：
         *      bean是多例的
         *      spring上下文初始化的时候，不会初始化这些prototype的bean
         *      每一次调用getBean()方法的时候，实例化该bean对象
         *      prototype翻译为:原型。
         */
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean scope = appContext.getBean("scope", SpringBean.class);
        System.out.println(scope);

        SpringBean scope2 = appContext.getBean("scope", SpringBean.class);
        System.out.println(scope2);

        SpringBean scope3 = appContext.getBean("scope", SpringBean.class);
        System.out.println(scope3);
    }
}
