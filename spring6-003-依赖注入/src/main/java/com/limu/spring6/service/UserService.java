package com.limu.spring6.service;

import com.limu.spring6.dao.UserDao;
import com.limu.spring6.dao.VipDao;

public class UserService {

    private UserDao userDao;
    private VipDao vipDao;

    // set注入必须提供一个set方法。
    // spring容器会调用set方法给属性赋值。
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void saveUser(){
        //保存用户信息到数据库
        userDao.insert();
        vipDao.insert();
    }
}
