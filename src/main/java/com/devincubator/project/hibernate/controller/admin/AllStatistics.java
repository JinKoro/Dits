package com.devincubator.project.hibernate.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllStatistics {

/*    private QuestionServiceInterface questionServiceInterface;

    @Autowired
    public void setQuestionServiceInterface(QuestionServiceInterface questionServiceInterface) {
        this.questionServiceInterface = questionServiceInterface;
    }

    @GetMapping(value = "/questionStatistic")
    public String adminStatistic(Model model){
        List<String> questionNames = questionServiceInterface.getNamesQuestions();
        model.addAttribute("statisticList",questionNames);
        return "admin/questionStatistic";
    }*/


}
