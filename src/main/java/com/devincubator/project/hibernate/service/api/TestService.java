package com.devincubator.project.hibernate.service.api;

import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.repository.TestRepository;
import java.util.List;

public interface TestService extends TestRepository {

    Test getById(long id);
    List<Test> getAll();
    Test createTestByName(String nameTest,Topic topic);
}
