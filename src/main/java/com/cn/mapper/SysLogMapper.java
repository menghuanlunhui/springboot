package com.cn.mapper;

import com.cn.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysLogMapper {

    SysLog get(Long id);

    List<SysLog> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(SysLog log);

    int update(SysLog log);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
