package com.devincubator.project.hibernate.controller.admin;

import com.devincubator.project.hibernate.model.User;
import com.devincubator.project.hibernate.model.enums.RoleName;
import com.devincubator.project.hibernate.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CreateUserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private SimpleMailMessage simpleMailMessage;
    private JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

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

        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setText("Вы были успешно зарегестрированы. Перейти по ссылке: http://localhost:8080/login");
        javaMailSender.send(simpleMailMessage);

        user = new User();
        List<User> userList = userService.getAll();
        model.addAttribute("user",user);
        model.addAttribute("userList",userList);
        model.addAttribute("allRoles", RoleName.values());
        model.addAttribute("success","Пользователь добавлен");
        return "admin/createUser";
    }

    @GetMapping(value = "/createUser")
    public String createUser(Model model){
        List<User> userList = userService.getAll(User.class);
        User user  = new User();
        model.addAttribute("userList",userList);
        model.addAttribute("user",user);
        model.addAttribute("allRoles", RoleName.values());
        return "admin/createUser";
    }

    @GetMapping(value = "/delete/{id}")
    public String deletePage(@PathVariable("id") int id,Model model){
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/admin/createUser";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id,Model model) {
        User user = userService.getById(id);
        model.addAttribute("allRoles", RoleName.values());
        model.addAttribute("user",user);
        return "admin/editPage";
    }

    @PostMapping("/edit")
    public String editPagePost(@ModelAttribute("user") User user,Model model) {
        userService.update(user,passwordEncoder);
        model.addAttribute("allRoles", RoleName.values());
        return "redirect:/admin/createUser";
    }
}
