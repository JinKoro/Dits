package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Role;
import com.devincubator.project.hibernate.model.enums.RoleName;
import com.devincubator.project.hibernate.service.api.RoleService;
import org.astashonok.assessmentsystem.service.impl.util.TestHibernateConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static com.devincubator.project.hibernate.service.impl.util.StaticService.resetDb;
import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = {TestHibernateConfig.class})
public class RoleServiceImplTest extends AbstractTestNGSpringContextTests{

    private static RoleService roleService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        roleService = (RoleService) context.getBean("roleService");
        resetDb();
    }

    @Test
    public void getById() {
        Role expected = new Role(RoleName.USER);
        Role actual = roleService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {
        int expected = 3;
        int actual = roleService.getAll().size();
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void add() {
        roleService.add(new Role(RoleName.ADMIN));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void update() {
        roleService.update(new Role(RoleName.USER));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void delete() {
        roleService.delete(new Role(RoleName.TUTOR));
    }
}