package com.limu.review.simple;

public class SimpleFactory {
    public Food get(String name) {
        if ("apple".equals(name)) {
            return new Apple();
        } else if ("banana".equals(name)) {
            return new Banana();
        } else {
            throw new RuntimeException("该工厂不提供其他对象");
        }
    }
}
