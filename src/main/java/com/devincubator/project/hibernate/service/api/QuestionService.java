package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.repository.QuestionRepository;

import java.util.List;

public interface QuestionService extends QuestionRepository {

    Question getById(long id);
    List<Question> getAll();
    public Question getQuestionByDescription(String nameQuestion, Test test);
}
