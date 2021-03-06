package com.devincubator.project.hibernate.service.impl;

import com.devincubator.project.hibernate.model.*;
import com.devincubator.project.hibernate.model.enums.RoleName;
import com.devincubator.project.hibernate.service.api.StatisticService;
import org.astashonok.assessmentsystem.service.impl.util.TestHibernateConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.devincubator.project.hibernate.service.impl.util.StaticService.resetDb;
import static com.devincubator.project.hibernate.service.impl.util.StaticService.resetStatistic;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@ContextConfiguration(classes = {TestHibernateConfig.class})
public class StatisticServiceImplTest extends AbstractTestNGSpringContextTests{

    private static StatisticService statisticService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        statisticService = (StatisticService) context.getBean("statisticService");
        resetDb();
    }

    @Test
    public void add() {
        Role role3 = new Role(RoleName.USER);
        role3.setId(3);
        User user3 = new User("User", "Userovic", "user", "userPassword"
                , role3);
        user3.setId(3);
        Topic topic3 = new Topic("Topic 3", "Description Topic 3");
        topic3.setId(3);
        com.devincubator.project.hibernate.model.Test test3 = new com.devincubator.project.hibernate.model.Test(
                "Test 3", "Description Test 3", topic3
        );
        test3.setId(3);
        Question question3 = new Question("Question 3", test3);
        question3.setId(3);
        Statistic expected = new Statistic(new Date(), true, question3, user3);
        Statistic actual = statisticService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() throws ParseException {
        User user3 = new User();
        user3.setId(3);
        Question question3 = new Question();
        question3.setId(3);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        Date date = formatter.parse("2020-01-12 10:39:22");

        Statistic expected = new Statistic(date, false, question3, user3);
        Statistic actual = statisticService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Role role3 = new Role(RoleName.USER);
        role3.setId(3);
        User user3 = new User("User", "Userovic", "user", "userPassword"
                , role3);
        user3.setId(3);
        Topic topic4 = new Topic("Topic 4", "Description Topic 4");
        topic4.setId(4);
        com.devincubator.project.hibernate.model.Test test4 = new com.devincubator.project.hibernate.model.Test(
                "Test 4", "Description Test 4", topic4
        );
        test4.setId(4);
        Question question4 = new Question("Question 4", test4);
        question4.setId(4);
        Statistic expected = new Statistic(new Date(), false, question4, user3);
        expected.setId(4);
        Statistic actual = statisticService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() throws ParseException {
        Role role3 = new Role(RoleName.USER);
        role3.setId(3);
        User user3 = new User("User", "Userovic", "user", "userPassword"
                , role3);
        user3.setId(3);
        Topic topic2 = new Topic("Topic 2", "Description Topic 2");
        topic2.setId(2);
        com.devincubator.project.hibernate.model.Test test2 = new com.devincubator.project.hibernate.model.Test(
                "Test 2", "Description Test 2", topic2
        );
        test2.setId(2);
        Question question2 = new Question("Question 2", test2);
        question2.setId(2);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
        Date date = formatter.parse("2020-01-12");
        Statistic statistic = new Statistic(date, true, question2, user3);
        statistic.setId(2);
        statisticService.delete(statistic);
        Statistic actual = statisticService.getById(2);
        assertNull(actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetStatistic();
        int expected = 5;
        int actual = statisticService.getAll().size();
        assertEquals(expected, actual);
    }
}