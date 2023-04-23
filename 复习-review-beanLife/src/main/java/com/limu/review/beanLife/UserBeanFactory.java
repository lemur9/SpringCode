package com.limu.review.beanLife;

public class UserBeanFactory {
    public static User getUserBean() {
        User user = new User();
        user.setName("limu");
        return user;
    }
}
