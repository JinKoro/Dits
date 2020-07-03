package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Statistic;
import com.devincubator.project.hibernate.service.api.StatisticService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {
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
    public Statistic getById(long id) {
        return getById(Statistic.class, id);
    }

    @Override
    public List<Statistic> getAll() {
        return getAll(Statistic.class);
    }
}
