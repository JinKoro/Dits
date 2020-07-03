package com.devincubator.project.hibernate.controller.admin;

import com.devincubator.project.hibernate.model.User;


import com.devincubator.project.hibernate.model.enums.RoleName;
import com.devincubator.project.hibernate.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateUserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public String createUserGet(Model model,User user){
        userService.add(user,passwordEncoder);
        user = new User();
        model.addAttribute("user",user);
        model.addAttribute("allRoles", RoleName.values());
        model.addAttribute("success","Пользователь добавлен");
        return "admin/createUser";
    }

    @GetMapping(value = "/createUser")
    public String createUser(Model model){
        User user  = new User();
        model.addAttribute("user",user);
        model.addAttribute("allRoles", RoleName.values());
        return "admin/createUser";
    }

    @GetMapping(value = "/adminStatistic")
    public String adminStatistic(){
        return "admin/adminStatistic";
    }

    @GetMapping(value = "/goHomeAdmin")
    public String goHomeAdmin(){
        return "admin/admin";
    }
}
