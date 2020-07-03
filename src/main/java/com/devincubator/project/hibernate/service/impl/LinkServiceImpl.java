package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Link;
import com.devincubator.project.hibernate.service.api.LinkService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

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
    public Link getById(long id) {
        return getById(Link.class, id);
    }

    @Override
    public List<Link> getAll() {
        return getAll(Link.class);
    }
}
