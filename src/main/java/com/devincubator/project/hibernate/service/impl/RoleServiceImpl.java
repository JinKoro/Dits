package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Role;
import com.devincubator.project.hibernate.service.api.RoleService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }


    @Override
    public Role getById(long id) {
        return getById(Role.class, id);
    }

    @Override
    public List<Role> getAll() {
        return getAll(Role.class);
    }
}
