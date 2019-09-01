package com.cn.service;

import com.cn.entity.PageDto;
import com.cn.entity.SysLog;
import com.cn.mapper.SysLogMapper;
import com.cn.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyun
 * @projectName springboot
 * @description: TODO
 * @date 2019/8/31 16:08
 */
@Service
public class SysLogService {

    @Autowired
    SysLogMapper sysLogMapper;

    public void save(SysLog logDO) {
        sysLogMapper.save(logDO);
    }

    public PageDto<SysLog> queryList(Query query) {
        int total = sysLogMapper.count(query);
        List<SysLog> logs = sysLogMapper.list(query);
        PageDto<SysLog> page = new PageDto<SysLog>();
        page.setTotal(total);
        page.setRows(logs);
        return page;
    }

    public int remove(Long id) {
        int count = sysLogMapper.remove(id);
        return count;
    }

    public int batchRemove(Long[] ids){
        return sysLogMapper.batchRemove(ids);
    }
}
