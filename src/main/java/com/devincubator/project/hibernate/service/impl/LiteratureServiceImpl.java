package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Literature;
import com.devincubator.project.hibernate.service.api.LiteratureService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("literatureService")
public class LiteratureServiceImpl implements LiteratureService {
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
    public Literature getById(long id) {
        return getById(Literature.class, id);
    }

    @Override
    public List<Literature> getAll() {
        return getAll(Literature.class);
    }
}
