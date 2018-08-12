package com.brctl.dbunit.service.impl;

import com.brctl.dbunit.dao.IStaticResourceDAO;
import com.brctl.dbunit.entity.StaticResource;
import com.brctl.dbunit.service.IStaticResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaticResourceService implements IStaticResourceService {

    @Autowired
    private IStaticResourceDAO staticResourceRepository;

    @Override
    public List<StaticResource> findAll() {
        return this.staticResourceRepository.findAll();
    }

}
