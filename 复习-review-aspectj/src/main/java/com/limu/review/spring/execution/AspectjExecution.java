package com.limu.review.spring.execution;

import com.limu.review.spring.annotation.Async;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Aspect
public class AspectjExecution {

    /*@Pointcut("execution(* insert(..))")
    public void exec() {

    }

    @Pointcut("execution(* update(..))")
    public void update() {
    }

    @Before("exec()")
    public void before() throws Throwable {
        System.out.println("前置通知");
    }

    @AfterReturning(value = "update()", returning = "rel")
    public void after(Object rel) throws Throwable {
        if (rel != null) {
            int i = (int) rel + 1;
            System.out.println("后置通知" + i);
        }
    }

    @Around("execution(int delete(..))")
    public Object advice( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aThis");
        int proceed = (int) proceedingJoinPoint.proceed();
        int i = proceed + 2;
        System.out.println("环绕通知" + i);
        return i;
    }*/

    @Around("execution(* *(..))")
    public Object adviceAsync(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Class<?> aClass = proceedingJoinPoint.getTarget().getClass();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Method declaredMethod = aClass.getDeclaredMethod(methodName);
        if (declaredMethod.isAnnotationPresent(Async.class)) {
            new Thread(() -> {
                try {
                    proceedingJoinPoint.proceed();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }).start();
        } else {
            return proceedingJoinPoint.proceed();
        }
        return null;
    }
}
