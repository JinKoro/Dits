package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.service.api.TestService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {
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
    public Test getById(long id) {
        return getById(Test.class, id);
    }

    @Override
    public List<Test> getAll() {
        return getAll(Test.class);
    }

    @Override
    public Test createTestByName(String nameTest, Topic topic) {
        Test newTest  = new Test();
        for (Test test: getAll()
        ) {
            if(nameTest.equals(test.getName())){
                newTest.setId(test.getId());
                newTest.setName(test.getName());
                newTest.setDescription(test.getDescription());
                newTest.setTopicId(test.getTopicId());
                return newTest;
            }
        }
        newTest.setName(nameTest);
        newTest.setDescription(nameTest);
        newTest.setTopicId(topic.getId());
        add(newTest);
        return newTest;
    }
}
