package com.devincubator.project.hibernate.repository;

import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.repository.abstracts.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TopicRepository extends CrudRepository<Topic> {
    default List<String> getNamesTopics(){
        List<String> namesTopicsL = new ArrayList<>();
        for (Topic t:getAll(Topic.class)
        ) {
            namesTopicsL.add(t.getName());
        }
        return namesTopicsL;
    }
}
