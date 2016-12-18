package com.zi.service.impl;

import com.zi.dal.piresource.entity.PiResource;
import com.zi.dal.piresource.entity.PiResourceExample;
import com.zi.service.PiResourceService;
import com.zi.sys.factory.MapperFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 */
@Service
public class PiResourceServiceImpl extends MapperFactory implements PiResourceService{

    public List<PiResource> findByAll() {
        List<PiResource> result = this.getPiResourceMapper().selectByExample(new PiResourceExample());
        return result;
    }

    @CacheEvict(value="shiroAuthorizationCache",allEntries = true)
    public void saveResource(PiResource resource){
        this.getPiResourceMapper().insertSelective(resource);
    }

    @CacheEvict(value="shiroAuthorizationCache",allEntries = true)
    public void deleteById(String id){
        this.getPiResourceMapper().deleteByPrimaryKey(id);
    }
}
