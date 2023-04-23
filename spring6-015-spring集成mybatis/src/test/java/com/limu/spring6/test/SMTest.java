package com.limu.spring6.test;

import com.limu.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
public class SMTest {

    @Test
    public void testSM() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
