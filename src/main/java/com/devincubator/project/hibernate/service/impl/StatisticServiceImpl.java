package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.model.Statistic;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.admin.ViewStatistic;
import com.devincubator.project.hibernate.model.admin.ViewStatisticUserTest;
import com.devincubator.project.hibernate.service.api.QuestionService;
import com.devincubator.project.hibernate.service.api.StatisticService;
import com.devincubator.project.hibernate.service.api.TestService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {

    private SessionFactory sessionFactory;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;

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

    @Override
    public ViewStatistic getQuestionInfo(Question question) {
        ViewStatistic viewStatistic;
        List<Statistic> statisticList = getAllStatisticByQuestionId(question.getId());
        if (!(statisticList.isEmpty())) {
            int numberOfTimes = statisticList.size();
            int countOfCorrectAnswers = 0;
            for (Statistic statistic : statisticList
            ) {
                if (statistic.isCorrect()) {
                    countOfCorrectAnswers++;
                }
            }
            if(numberOfTimes!=0){
            viewStatistic = new ViewStatistic(question.getDescription(), numberOfTimes, (int) Math.round(((double) countOfCorrectAnswers) / numberOfTimes * 100));}
            else{
                viewStatistic = new ViewStatistic(question.getDescription(),0,0);
            }
        } else {
            viewStatistic = null;
        }
        return viewStatistic;
    }

    public List<ViewStatistic> getQuestionStatisticList() {
        List<ViewStatistic> questionInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Question> questionList = questionService.getAll();
        for (Question question : questionList
        ) {
            viewStatistic = getQuestionInfo(question);
            if (viewStatistic != null) {
                questionInfoList.add(viewStatistic);
            }
        }
        questionInfoList.sort(Comparator.comparing(ViewStatistic::getNameQuestion));
        return questionInfoList;
    }

    @Override
    public ViewStatistic getTestInfo(Test test) {
        ViewStatistic viewStatistic;
        List<Statistic> statisticList = getFilteredStatisticByTestId(test.getId());
        if (!statisticList.isEmpty()) {
            int numberOfQuestionInTest = test.getQuestions().size();
            int numberOfTimes = statisticList.size();
            int countOfCorrectAnswers = 0;
            for (Statistic statistic : statisticList
            ) {
                if (statistic.isCorrect()) {
                    countOfCorrectAnswers++;
                }
            }
            viewStatistic = new ViewStatistic(test.getName(), numberOfTimes / numberOfQuestionInTest, (int) Math.round(((double) countOfCorrectAnswers) / numberOfTimes * 100));
        } else {
            viewStatistic = null;
        }
        return viewStatistic;
    }


    public List<ViewStatistic> getTestStatisticList() {
        List<ViewStatistic> testInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Test> testList = testService.getAll();
        for (Test test : testList
        ) {
            viewStatistic = getTestInfo(test);
            if (viewStatistic != null) {
                testInfoList.add(viewStatistic);
            }
        }
        testInfoList.sort(Comparator.comparing(ViewStatistic::getNameQuestion));
        return testInfoList;
    }

    private ViewStatisticUserTest getUserTestInfo(Statistic statistic) {
        ViewStatisticUserTest viewStatisticUserTest = null;
        List<Statistic> statisticList = getFilteredStatisticByTestUser(statistic);
        int countOfCorrectAnswers = 0;
        int numberOfAllQuestion = statisticList.size();
        int numberOfTimes = (int) Math.ceil((double)statisticList.size()/getQuestionInTest(statistic));
        if (!statisticList.isEmpty()) {
            for (Statistic st : statisticList
            ) {
                if (st.isCorrect()) {
                    countOfCorrectAnswers++;
                }
            }
            if(numberOfTimes==0){
                viewStatisticUserTest = null;
            }else {
                viewStatisticUserTest = new ViewStatisticUserTest(statistic.getUser().getFIO(),
                        statistic.getQuestion().getTest().getName(), numberOfTimes, (int) Math.round(((double) countOfCorrectAnswers) / numberOfAllQuestion * 100));
            }
        } else {
            viewStatisticUserTest = null;
        }

        return viewStatisticUserTest;
    }

    @Override
    public List<ViewStatisticUserTest> getUserTestStatisticList() {
        List<ViewStatisticUserTest> userTestInfoList = new ArrayList<>();
        ViewStatisticUserTest viewStatisticUserTest;
        for (Statistic statistic : getAll()
        ) {
            viewStatisticUserTest = getUserTestInfo(statistic);
            if (viewStatisticUserTest != null) {
                userTestInfoList.add(viewStatisticUserTest);
            }
        }
        Set<ViewStatisticUserTest> set = new HashSet<>(userTestInfoList);
        set.addAll(userTestInfoList);
        userTestInfoList.clear();
        userTestInfoList.addAll(set);
        userTestInfoList.sort(Comparator.comparing(ViewStatisticUserTest::getFIO));
        return userTestInfoList;
    }

}
