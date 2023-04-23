package com.limu.spring6.aspect.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect //切面类是需要使用@Aspect注解进行标注的
@Order(0)//数字越小优先级越高
public class LogAspect { //切面

    //定义一个通用的切点表达式
    @Pointcut("execution(* *.*(..))")
    public void common() {

    }


    // 切面=切点+通知
    //通知就是增强,就是具体要编写的增强代码
    //前置通知
    @Before("common()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("这里有一个前置通知");

        Signature signature = joinPoint.getSignature();//获取目标方法的签名
        //通过方法的签名可以获取到一个方法的具体信息。
        //获取目标方法的方法名
        System.out.println("目标方法的方法名:" + signature.getName());
    }

    //后置通知
    @AfterReturning("common()")
    public void afterReturningAdvice() {
        System.out.println("这里有一个后置通知");
    }

    //环绕通知（环绕是最大的通知，在前置通知之前，在后置通知之后）
    @Around("common()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //前通知
        System.out.println("前环绕");

        //执行目标
        joinPoint.proceed();

        //后通知
        System.out.println("后环绕");
    }

    //异常通知
    @AfterThrowing("common()")
    public void afterThrowingAdvice() {
        System.out.println("异常通知");
    }

    //最终通知（finally语句块中的通知）
    @After("common()")
    public void afterAdvice() {
        System.out.println("最终通知");
    }
}
