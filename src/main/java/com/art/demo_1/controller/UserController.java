package com.art.demo_1.controller;

import com.art.demo_1.model.MyUser;
import com.art.demo_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUserList(Model model) {
        List<MyUser> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/sign-up")
    public String showSignUpForm(@ModelAttribute("user") MyUser user) {
        return "addUser";
    }

    @PostMapping("/add-user")
    public String addUser(@Validated @ModelAttribute("user") MyUser user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addUser";
        } else {
            userService.save(user);
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    public String showUpdateUser(@PathVariable("id") Long id, @ModelAttribute("user") MyUser user, Model model) {
        user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Validated @ModelAttribute("user") MyUser user, BindingResult result) {
        if (result.hasErrors()) {
            return "editUser";
        } else {
            userService.save(user);
            return "redirect:/";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        userService.delete(id);
//        model.addAttribute("users",userService.findAll());
//
        return "redirect:/";
    }


}
