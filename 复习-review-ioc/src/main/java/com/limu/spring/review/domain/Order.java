package com.limu.spring.review.domain;

public class Order {

    private String name;

    private Double price;

    public Order() {
        System.out.println("Order类的无参构造");
    }

    public Order(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
