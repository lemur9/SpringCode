package com.limu.service.impl;

import com.limu.dao.UserDao;
import com.limu.dao.impl.UserDaoImpl;
import com.limu.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void deleteUser() {
        UserDao userDao = new UserDaoImpl();
        userDao.deleteById();
    }
}
