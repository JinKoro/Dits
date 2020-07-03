package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Statistic;
import com.devincubator.project.hibernate.repository.StatisticRepository;

import java.util.List;

public interface StatisticService extends StatisticRepository {

    Statistic getById(long id);
    List<Statistic> getAll();
}
