package com.cn.mapper;


import com.cn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserList();

    User getUserById(@Param("id") Long id);

    int updateUser(User user);
}
