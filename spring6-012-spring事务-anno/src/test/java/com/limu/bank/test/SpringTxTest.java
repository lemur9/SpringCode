package com.limu.bank.test;

import com.limu.bank.Spring6Config;
import com.limu.bank.pojo.Account;
import com.limu.bank.service.AccountService;
import com.limu.bank.service.impl.IsolationService1;
import com.limu.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTxTest {

    @Test
    public void testNoXML() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);

        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }

    @Test
    public void testIsolation1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = context.getBean("i1", IsolationService1.class);
        i1.getByActNo("act-004");
    }

    @Test
    public void testIsolation2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = context.getBean("i2", IsolationService2.class);
        Account act = new Account("act-004",30000.0);
        i2.insert(act);
    }

    @Test
    public void testPropagation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);

        Account act = new Account("act-003", 20000.0);
        accountService.save(act);
    }

    @Test
    public void testSpringText() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);

        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }
}
