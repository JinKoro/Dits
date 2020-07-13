package com.devincubator.project.hibernate.repository;

import com.devincubator.project.hibernate.model.User;
import com.devincubator.project.hibernate.repository.abstracts.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserRepository extends CrudRepository<User> {

    default User update(User entity,PasswordEncoder passwordEncoder){
        entity.setRoles(entity.setRoleByNameRole(entity.getNameRole()));
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return (User) getBeanToBeAutowired().getCurrentSession().merge(entity);
    }

    default User add(User entity,PasswordEncoder passwordEncoder) {
        entity.setRoles(entity.setRoleByNameRole(entity.getNameRole()));
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return (User) getBeanToBeAutowired().getCurrentSession().merge(entity);
    }
}
