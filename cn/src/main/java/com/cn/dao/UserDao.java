package com.cn.dao;

import com.cn.entity.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserDao {
    //根据用户查询用户
    User findByUserName(String username);

    //保存用户信息
    void save(User user);
}
