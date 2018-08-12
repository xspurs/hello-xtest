package com.brctl.dbunit.dao;

import com.brctl.dbunit.entity.StaticResource;
import java.util.List;

public interface IStaticResourceDAO {

    List<StaticResource> findAll();

}
