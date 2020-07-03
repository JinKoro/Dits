package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Answer;
import com.devincubator.project.hibernate.service.api.AnswerService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

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
    public Answer getById(long id) {
        return getById(Answer.class, id);
    }

    @Override
    public List<Answer> getAll() {
        return getAll(Answer.class);
    }
}