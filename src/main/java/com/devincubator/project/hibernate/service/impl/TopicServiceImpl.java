package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.service.api.TopicService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

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
    public Topic getById(long id) {
        return getById(Topic.class, id);
    }

    @Override
    public List<Topic> getAll() {
        return getAll(Topic.class);
    }

    @Override
    public Topic createTopicByName(String nameTopic) {
        Topic newTopic = new Topic();
        for (Topic t:getAll()
        ) {
            if(nameTopic.equals(t.getName())){
                newTopic.setId(t.getId());
                newTopic.setName(t.getName());
                newTopic.setDescription(t.getDescription());
                return newTopic;
            }
        }
        newTopic.setName(nameTopic);
        newTopic.setDescription(nameTopic);
        add(newTopic);
        return newTopic;
    }
}
