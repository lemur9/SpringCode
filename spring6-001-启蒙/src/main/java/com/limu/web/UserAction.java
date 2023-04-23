package com.limu.web;

import com.limu.service.UserService;
import com.limu.service.impl.UserServiceImpl;

public class UserAction {


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.deleteUser();
    }
}
