package com.devincubator.project.hibernate.repository;

import com.devincubator.project.hibernate.model.Role;
import com.devincubator.project.hibernate.repository.abstracts.CrudRepository;

public interface RoleRepository extends CrudRepository<Role> {

    @Override
    default Role add(Role entity) {
        // ignore
        throw new UnsupportedOperationException();
    }

    @Override
    default Role update(Role entity) {
        // ignore
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(Role entity) {
        // ignore
        throw new UnsupportedOperationException();
    }
}
