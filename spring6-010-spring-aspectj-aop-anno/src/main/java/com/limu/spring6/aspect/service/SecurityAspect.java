package com.limu.spring6.aspect.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
//安全切面
public class SecurityAspect {

    @Before("com.limu.spring6.aspect.service.LogAspect.common()")
    public void beforeAdvice() {
        System.out.println("前置通知：安全");
    }
}
