package com.limu.spring6.aspect.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {//目标类

    public void login(){//目标方法
        System.out.println("系统正在登录。。。");
    }

    public void logout(){
        System.out.println("退出系统。。。");
    }
}
