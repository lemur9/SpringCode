package com.limu.spring.review.domain;

public class Vip {

    private Order order;

    public Vip(Order order) {
        this.order = order;
    }

    public Vip() {
        System.out.println("Vip类的无参构造");
    }

    @Override
    public String toString() {
        return "Vip{" +
                "order=" + order +
                '}';
    }
}
