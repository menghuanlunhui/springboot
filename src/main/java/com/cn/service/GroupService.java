package com.cn.service;

import com.cn.entity.Group;
import com.cn.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenyun
 * @projectName springboot
 * @description: 组织
 * @date 2019/10/23 15:43
 */
@Service
public class GroupService {

    @Autowired
    GroupMapper groupMapper;

    /**
     * 创建实体对象
     *
     * @param group
     * @return
     */
    public int create(Group group){
        return groupMapper.create(group);
    }

    /**
     * 更新实体对象
     *
     * @param group
     * @return
     */
    public int update(Group group){
        return groupMapper.update(group);
    }

    public Group getByCode(String code) {
        return groupMapper.getByCode(code);
    }

}
