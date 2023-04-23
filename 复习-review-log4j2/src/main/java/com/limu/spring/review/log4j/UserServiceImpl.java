package com.limu.spring.review.log4j;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserServiceImpl() {
        System.out.println("创建userService对象");
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
