package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Answer;
import com.devincubator.project.hibernate.repository.AnswerRepository;

import java.util.List;

public interface AnswerService extends AnswerRepository {

    Answer getById(long id);
    List<Answer> getAll();
}