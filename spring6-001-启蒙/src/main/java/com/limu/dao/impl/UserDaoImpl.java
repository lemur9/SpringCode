package com.limu.dao.impl;

import com.limu.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("数据库正在删除用户id");
    }
}
