package com.cn.service;


import com.cn.dao.UserDao;
import com.cn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public void register(User user) {
        //1.根据用户名查询数据库中是否存在该用户
        User userDB=userDao.findByUserName(user.getUsername());
        //2.判断用户是否存在
        if(!ObjectUtils.isEmpty(userDB)) throw new RuntimeException("当前用户已被注册！");
        //3.注册用户&&明文的密码加密 特点：相同的字符串多次使用MD5加密，加密的结果始终一致
        String newPassword = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(newPassword);
        userDao.save(user);

    }

    @Override
    public User login(String username, String password) {
        //1.根据用户名查询用户
        User user=userDao.findByUserName(username);
        if (ObjectUtils.isEmpty(user)) throw new RuntimeException("用户名不正确!");
        //2.比较密码
        String passwordSecret = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!user.getPassword().equals(passwordSecret)) throw new RuntimeException("密码输入错误!");
        return user;
    }
}























