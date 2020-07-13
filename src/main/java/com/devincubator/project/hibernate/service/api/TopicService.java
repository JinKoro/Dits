package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.repository.TopicRepository;
import java.util.List;

public interface TopicService extends TopicRepository {

    Topic getById(long id);
    List<Topic> getAll();
    Topic createTopicByName(String nameTopic);
}
