package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Literature;
import com.devincubator.project.hibernate.repository.LiteratureRepository;
import java.util.List;

public interface LiteratureService extends LiteratureRepository {

    Literature getById(long id);
    List<Literature> getAll();
}

