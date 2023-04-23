package com.limu.spring6.test;

import com.limu.spring6.bean.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {

    @Test
    public void testBeginInitBean() {
        //注意：不是在调用getBean方法时创建的对象，执行以下代码时就会实例化对象。
        new ClassPathXmlApplicationContext("spring.xml");

        //自己使用log4j2记录日志
        //第一步：创建日志记录器对象
        //获取FirstSpringTest类的日志记录器对象，当FirstSpringTest类中的代码执行记录日志的话，就会输出相关的日志信息。
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

        //第二步：记录日志，根据不同的级别来输出日志
        logger.info("记录一条info日志");
        logger.error("记录一条error日志");
    }

    @Test
    public void testBeanFactory() {
        //ApplicationContext接口的超级父接口是：BeanFactory（翻译为Bean工厂，生产Bean对象的一个工厂对象。）
        //BeanFactory是IoC容器的顶级接口
        //Spring的IoC容器底层实际上使用了：工厂模式。
        //Spring底层的IoC是如何实现的？通过XML解析 + 工厂模式 + 反射机制
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testFirstSpring(){
        //第一步：获取spring容器对象
        //ApplicationContext:应用上下文。就是spring容器
        //ApplicationContext是一个接口，里面有很多的实现类
        //ClassPathXmlApplicationContext是专门从类路径当中加载spring配置文件的一个spring上下文对象。
        //这句话的执行，就相当于启动了spring容器，解析spring.xml文件，并且实例化所有的bean对象，放到spring容器当中。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        //第二步：根据bean的id从spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        //如果bean的id不存在，会抛出异常
        //Object nowTime = applicationContext.getBean("nowTime2");

        //不想强制类型转换，可以指定返回值类型
        //Data nowTime = (Data) applicationContext.getBean("nowTime");
        Date nowTime = applicationContext.getBean("nowTime", Date.class);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strNowTime = sdf.format(nowTime);
        System.out.println(strNowTime);

    }
}
