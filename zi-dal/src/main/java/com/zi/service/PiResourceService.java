package com.zi.service;

import com.zi.dal.piresource.entity.PiResource;

import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 */
public interface PiResourceService {

    public List<PiResource> findByAll();

    public void saveResource(PiResource resource);

    public void deleteById(String id);
}
