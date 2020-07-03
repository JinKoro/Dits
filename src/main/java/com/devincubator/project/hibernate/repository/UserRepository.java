package com.devincubator.project.hibernate.repository;

import com.devincubator.project.hibernate.model.User;
import com.devincubator.project.hibernate.repository.abstracts.CrudRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
public interface UserRepository extends CrudRepository<User> {

    default User add(User entity,PasswordEncoder passwordEncoder) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return (User) getBeanToBeAutowired().getCurrentSession().merge(entity);
    }
}
