package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.User;
import com.devincubator.project.hibernate.repository.UserRepository;
import java.util.List;

public interface UserService extends UserRepository {

    User getById(long id);
    List<User> getAll();
    User getByName(String login);

}
