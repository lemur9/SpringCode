package com.limu.spring.review.domain;

public class BeanFactory {

    private String name;

    public BeanFactory() {
        System.out.println("BeanFactory");
    }

    public BeanFactory(String name) {
        this.name = name;
    }

    public Object init(){
        if ("goods".equals(name)) {
            return new Goods();
        } else if ("order".equals(name)){
            return new Order();
        } else if ("user".equals(name)) {
            return new User();
        } else if ("vip".equals(name)) {
            return new Vip();
        } else {
            System.out.println("该工厂无法构建此对象");
            return null;
        }
    }
}
