package com.cn.service;

import com.cn.entity.User;
import com.cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyun
 * @projectName springboot
 * @description: TODO
 * @date 2019/8/30 15:00
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
