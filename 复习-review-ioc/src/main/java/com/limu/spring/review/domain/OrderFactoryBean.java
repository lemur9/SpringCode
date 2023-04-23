package com.limu.spring.review.domain;

import org.springframework.beans.factory.FactoryBean;

public class OrderFactoryBean implements FactoryBean<Order> {

    private Order order = new Order("棒棒糖",1.0);

    @Override
    public Order getObject() throws Exception {
        return order;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
