package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.service.api.QuestionService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
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
    public Question getById(long id) {
        return getById(Question.class, id);
    }

    @Override
    public List<Question> getAll() {
        return getAll(Question.class);
    }

    @Override
    public Question getQuestionByDescription(String nameQuestion, Test test) {
        Question question  = new Question();
        for (Question q:getAll()
        ) {
            if(q.getDescription().equals(nameQuestion)){
                question.setDescription(q.getDescription());
                question.setTestId(q.getTestId());
                return question;
            }
        }
        question.setDescription(nameQuestion);
        question.setTestId(test.getId());
        add(question);
        return question;
    }



}
