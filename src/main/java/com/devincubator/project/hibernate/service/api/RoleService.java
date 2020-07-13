package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Role;
import com.devincubator.project.hibernate.repository.RoleRepository;
import java.util.List;

public interface RoleService extends RoleRepository {

    Role getById(long id);
    List<Role> getAll();
}
