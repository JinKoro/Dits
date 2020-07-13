package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.model.Statistic;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.admin.ViewStatistic;
import com.devincubator.project.hibernate.model.admin.ViewStatisticUserTest;
import com.devincubator.project.hibernate.repository.StatisticRepository;
import java.util.List;

public interface StatisticService extends StatisticRepository {

    Statistic getById(long id);
    List<Statistic> getAll();
    ViewStatistic getQuestionInfo(Question question);
    List<ViewStatistic> getQuestionStatisticList();
    List<ViewStatistic> getTestStatisticList();
    ViewStatistic getTestInfo(Test test);
    List<ViewStatisticUserTest> getUserTestStatisticList();
}
