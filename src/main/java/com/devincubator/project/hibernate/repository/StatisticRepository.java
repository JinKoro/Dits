package com.devincubator.project.hibernate.repository;

import com.devincubator.project.hibernate.model.Statistic;
import com.devincubator.project.hibernate.repository.abstracts.CrudRepository;
import java.util.ArrayList;
import java.util.List;

public interface StatisticRepository extends CrudRepository<Statistic> {
    default List<Statistic> getAllStatisticByQuestionId(long questionId){
        return getBeanToBeAutowired().getCurrentSession().createQuery("from Statistic where questionId="+questionId).list();
    };
    default List<Statistic> getFilteredStatisticByTestId(long testId){
        List<Statistic> statisticList = new ArrayList<>();
        List<Long> questions = getBeanToBeAutowired().getCurrentSession().createQuery("select id from Question where testId="+testId).list();
        for (Long id:questions
             ) {
           statisticList.addAll(getBeanToBeAutowired().getCurrentSession().createQuery("from Statistic where questionId="+id).list());
        }
        return statisticList;
    };

    default List<Statistic> getFilteredStatisticByTestUser(Statistic statistic){
        List<Long> questionId = getBeanToBeAutowired().getCurrentSession().createQuery("select id from Question where testId="+statistic.getQuestion().getTest().getId()).list();

        List<Statistic> list =new ArrayList<>();
        for (Long l:questionId
             ) {
            list.addAll(getBeanToBeAutowired().getCurrentSession().createQuery("from Statistic  where userId="+statistic.getUserId()+" and questionId="+l).list());
        };
        return list;
    }
    default Integer getQuestionInTest(Statistic statistic){
        int questionInTest= 0;
        List<Long> questionId = getBeanToBeAutowired().getCurrentSession().createQuery("select id from Question where testId="+statistic.getQuestion().getTest().getId()).list();
        questionInTest = questionId.size();
        return questionInTest;
    }
}
