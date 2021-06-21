package com.art.demoOne.controller;

import com.art.demoOne.model.Address;
import com.art.demoOne.model.MyUser;
import com.art.demoOne.service.address.AddressService;
import com.art.demoOne.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final AddressService addressService;

    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
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
    public String addUser(@Validated @ModelAttribute("user") MyUser user, BindingResult result) {
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
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/update/job/{id}")
    public String updateJob(@PathVariable("id") Long id, @Validated @ModelAttribute("user") MyUser user,  BindingResult result) {
        if (result.hasErrors()) {
            return "editUser";
        } else {
            Address address = user.getAddress();
            addressService.save(address);
            user.setAddress(address);
            userService.save(user);
            return "editUser";
        }
    }


}
