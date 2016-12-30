package com.zi.service.impl;

import com.zi.dal.sysauthority.dao.SysAuthorityMapper;
import com.zi.dal.sysauthority.entity.SysAuthority;
import com.zi.dal.sysauthority.entity.SysAuthorityExample;
import com.zi.service.SysAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30 0030.
 */
@Service
public class SysAuthorityServiceImpl implements SysAuthorityService {
    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    /**
     * 查询所有权限
     * @return
     */
    public List<SysAuthority> findByAll(){
        List<SysAuthority> result = sysAuthorityMapper.selectByExample(new SysAuthorityExample());
        return result;
    }
}
