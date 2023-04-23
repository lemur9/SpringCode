package com.limu.spring.test;

import com.limu.spring.core.PareAnnotation;
import com.limu.spring.domain.User;
import com.limu.spring.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class Client {
    public static void main(String[] args) {
        try {
            BeanFactory beanFactory = PareAnnotation.packageScan("com.limu.spring");
            User user = beanFactory.getBean("ll", User.class);
            user.setAge(23);
            user.setName("李木");
            System.out.println(user);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
