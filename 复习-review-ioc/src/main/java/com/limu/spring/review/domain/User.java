package com.limu.spring.review.domain;

import org.springframework.stereotype.Component;

@Component("user")
public class User {

    private Goods goods;

    public User() {
        System.out.println("User类的无参构造");
    }

    public User(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "User{" +
                "goods=" + goods +
                '}';
    }
}

