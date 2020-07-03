package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.repository.abstracts.CrudRepository;

public interface TtqService extends CrudRepository {
    public Question createNewQuestion(String nameTopic, String nameTest, String nameQuestion);
}
