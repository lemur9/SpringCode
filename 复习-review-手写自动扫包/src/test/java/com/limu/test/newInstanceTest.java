package com.limu.test;

import com.limu.spring.annotation.Component;
import org.junit.Test;

import java.util.ResourceBundle;

public class newInstanceTest {

    @Test
    public void testNewInstance() throws ClassNotFoundException {
        Class.forName("com.limu.spring.annotation.Component");
    }

    @Test
    public void testUserDir() throws Exception {
        String property = System.getProperty("user.dir");
        System.out.println("property = " + property);
    }



}
