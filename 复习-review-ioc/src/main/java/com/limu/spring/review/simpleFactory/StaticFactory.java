package com.limu.spring.review.simpleFactory;

public class StaticFactory {

    public static <T> T init(String name, Class<T> classType) {

        if ("a".equals(name)) {
            return (T) new A();
        } else if ("b".equals(name)) {
            return (T) new B();
        } else {
            throw new RuntimeException("暂不支持此类型对象的生成");
        }
    }
}
