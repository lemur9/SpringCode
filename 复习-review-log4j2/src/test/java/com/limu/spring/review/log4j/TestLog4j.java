package com.limu.spring.review.log4j;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
public class TestLog4j {
    Logger log = LoggerFactory.getLogger(TestLog4j.class);

    /*@Resource(name = "userService")
    private UserService userService;

    @Resource
    private User user;*/

    @Test
    public void testLog4j() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user = applicationContext.getBean("user", User.class);
        log.info(user.toString());
        int count = userService.insertUser(user);
        log.error("添加了" + count + "条数据！");
    }
}