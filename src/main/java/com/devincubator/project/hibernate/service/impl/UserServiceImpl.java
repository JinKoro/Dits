package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.User;
import com.devincubator.project.hibernate.service.api.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
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
    public User getById(long id) {
        return getById(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return getAll(User.class);
    }

    @Override
    public User gerByName(String login) {
        return getByName(User.class,login);
    }


}
