package com.limu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */


//标记注解的注解，叫做元注解。@Target注解用来修饰@Component可以出现的位置
//以下注解表示@Component注解可以出现在类上、属性上
//@Target({ElementType.TYPE,ElementType.FIELD})
//以下表示可以出现在类上
@Target(ElementType.TYPE)

//@Retention 也是一个元注解。用来标注@Component注解最终保留在class文件当中，并且可以被反射机制读取。
//RetentionPolicy.SOURCE 表示@Component注解只保留在java源文件中
//RetentionPolicy.CLASS 表示@Component注解存在源文件和字节码文件中，但是无法被反射机制读取。
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    //定义注解的属性
    //String是属性类型
    //value是属性名
    String value() default "";

    //属性类型是String
    //属性名是name
    //String name();

    //数组属性
    //属性类型是：String[]
    //属性名是：names
    //String[] names();
}
