package com.devincubator.project.hibernate.controller.admin;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.service.api.QuestionService;
import com.devincubator.project.hibernate.service.api.TestService;
import com.devincubator.project.hibernate.service.api.TopicService;
import com.devincubator.project.hibernate.service.api.TtqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreateTestController {

    private TopicService topicService;
    private TestService testService;
    private QuestionService questionService;
    private TtqService ttqService;

    @Autowired
    public void setTtqService(TtqService ttqService) {
        this.ttqService = ttqService;
    }

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }



    @GetMapping("/createTest")
    public String createTest(Model model){
        model.addAttribute("topics",topicService.getNamesTopics());
        model.addAttribute("tests",testService.getNamesTests());
        model.addAttribute("questions",questionService.getNamesQuestions());
        return "admin/createTest";
    }

    @GetMapping("/saveNewQuestion")
    public String addTest(@RequestParam(name = "topic")String nameTopic,
                          @RequestParam(name = "test")String nameTest,
                          @RequestParam(name = "question")String nameQuestion,
                          Model model){
        Question completed = ttqService.createNewQuestion(nameTopic,nameTest,nameQuestion);

        List<String> nameTopics = topicService.getNamesTopics();
        List<String> nameTests = testService.getNamesTests();
        List<String> nameQuestions = questionService.getNamesQuestions();
        model.addAttribute("topics",nameTopics);
        model.addAttribute("tests",nameTests);
        model.addAttribute("questions",nameQuestions);
        model.addAttribute("success","Добавлен вопрос "+completed.toString());

        return "admin/createTest";
    }
}
