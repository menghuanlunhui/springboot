package com.cn.mapper;

import com.cn.entity.Group;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMapper {

    /**
     * 创建实体对象
     *
     * @param group
     * @return
     */
    int create(Group group);

    /**
     * 更新实体对象
     *
     * @param group
     * @return
     */
    int update(Group group);

    /**
     * 根据Code取定义对象。
     *
     * @param code
     * @return
     */
    Group getByCode(String code);
}
