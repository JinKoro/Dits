package com.devincubator.project.hibernate.service.impl.admin;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.service.api.QuestionService;
import com.devincubator.project.hibernate.service.api.TestService;
import com.devincubator.project.hibernate.service.api.TopicService;
import com.devincubator.project.hibernate.service.api.TtqService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QQTService implements TtqService {
    private TopicService topicService;
    private TestService testService;
    private QuestionService questionService;

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Transactional
    public Question createNewQuestion(String nameTopic, String nameTest, String nameQuestion) {
        Topic topic = topicService.createTopicByName(nameTopic);
        Test test = testService.createTestByName(nameTest,topic);
        Question question = questionService.getQuestionByDescription(nameQuestion,test);
        return question ;
    }


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }

}
