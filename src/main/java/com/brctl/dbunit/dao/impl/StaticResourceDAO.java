package com.brctl.dbunit.dao.impl;

import com.brctl.dbunit.dao.IStaticResourceDAO;
import com.brctl.dbunit.entity.StaticResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaticResourceDAO implements IStaticResourceDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<StaticResource> findAll() {
        final String sql = "select * from static_resource";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StaticResource.class));
    }

}
