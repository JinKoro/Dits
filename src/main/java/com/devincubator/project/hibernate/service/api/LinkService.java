package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Link;
import com.devincubator.project.hibernate.repository.LinkRepository;
import java.util.List;

public interface LinkService extends LinkRepository {

    Link getById(long id);
    List<Link> getAll();
}
