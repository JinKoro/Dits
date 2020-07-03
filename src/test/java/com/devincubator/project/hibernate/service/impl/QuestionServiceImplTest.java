package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.service.api.QuestionService;
import org.astashonok.assessmentsystem.service.impl.util.TestHibernateConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static com.devincubator.project.hibernate.service.impl.util.StaticService.resetDb;
import static com.devincubator.project.hibernate.service.impl.util.StaticService.resetQuestion;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@ContextConfiguration(classes = {TestHibernateConfig.class})
public class QuestionServiceImplTest extends AbstractTestNGSpringContextTests{

    private static QuestionService questionService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        questionService = (QuestionService) context.getBean("questionService");
        resetDb();
    }

    @Test
    public void add() {
        Topic topic2 = new Topic("Topic 2", "Description Topic 2");
        topic2.setId(2);
        com.devincubator.project.hibernate.model.Test test = new com.devincubator.project.hibernate.model.Test(
                "Test 2", "Description Test 2", topic2
        );
        test.setId(2);
        Question expected = new Question("Вопрос 6", test);
        Question actual = questionService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        com.devincubator.project.hibernate.model.Test test = new com.devincubator.project.hibernate.model.Test();
        test.setId(1);
        Question expected = new Question("Question 1", test);
        Question actual = questionService.getById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Topic topic3 = new Topic("Topic 3", "Description Topic 3");
        topic3.setId(3);
        com.devincubator.project.hibernate.model.Test test = new com.devincubator.project.hibernate.model.Test(
                "Test 3", "Description Test 3", topic3
        );
        test.setId(3);
        Question expected = new Question("Вопрос 3", test);
        expected.setId(3);
        Question actual = questionService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Topic topic4 = new Topic("Topic 4", "Description Topic 4");
        topic4.setId(4);
        com.devincubator.project.hibernate.model.Test test = new com.devincubator.project.hibernate.model.Test(
                "Test 4", "Description Test 4", topic4
        );
        test.setId(4);
        Question question = new Question("Question 4", test);
        question.setId(4);
        questionService.delete(question);
        Question actual = questionService.getById(4);
        assertNull(actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetQuestion();
        int expected = 5;
        int actual = questionService.getAll().size();
        assertEquals(expected, actual);
    }
}