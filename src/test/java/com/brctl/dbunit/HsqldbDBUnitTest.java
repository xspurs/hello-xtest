package com.brctl.dbunit;

import com.brctl.dbunit.entity.StaticResource;
import com.brctl.dbunit.service.IStaticResourceService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Hsqldb and DBUnit test
 * {@link /dbunit/sampleData.xml}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ApplicationConfiguration.class
})
@ActiveProfiles(value = "test")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DbUnitConfiguration(databaseConnection = "dataSource")
@DatabaseSetup("/dbunit/sampleData.xml")
public class HsqldbDBUnitTest {

    @Autowired
    private IStaticResourceService staticResourceService;

    @Test
    public void contextLoads() {
        List<StaticResource> all = staticResourceService.findAll();
        assertThat(all, is(notNullValue()));
        assertThat(all.size(), is(4));
    }

}
