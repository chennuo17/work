package com.cn.service;

import com.cn.entity.User;

public interface UserService {

    //注册用户
    void register(User user);

    //登录用户
    User login(String username,String password);
}
