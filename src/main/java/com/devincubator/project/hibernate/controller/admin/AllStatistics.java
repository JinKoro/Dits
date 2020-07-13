package com.devincubator.project.hibernate.controller.admin;

import com.devincubator.project.hibernate.model.admin.ViewStatistic;
import com.devincubator.project.hibernate.model.admin.ViewStatisticUserTest;
import com.devincubator.project.hibernate.service.api.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AllStatistics {

    private StatisticService statisticService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(value = "/adminStatistic")
    public String adminStatistic(){
        return "admin/adminStatistic";
    }

    @GetMapping(value = "/questionStatistic")
    public String questionStatistic(Model model){
        List<ViewStatistic> viewStatisticList = statisticService.getQuestionStatisticList();
        model.addAttribute("statisticListQuestion",viewStatisticList);
        return "admin/questionStatistic";
    }

    @GetMapping(value = "/testStatistic")
    public String testStatistic(Model model){
        List<ViewStatistic> viewStatisticList = statisticService.getTestStatisticList();
        model.addAttribute("statisticListTest",viewStatisticList);
        return "admin/testStatistic";
    }

    @GetMapping(value = "/userTestStatistic")
    public String userTestStatistic(Model model){
        List<ViewStatisticUserTest> viewStatisticList = statisticService.getUserTestStatisticList();
        model.addAttribute("statisticListUserTest",viewStatisticList);
        return "admin/userTestStatistic";

    }
}
