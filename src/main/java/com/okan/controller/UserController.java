package com.okan.controller;

import com.okan.dto.RoleDTO;
import com.okan.dto.UserDTO;
import com.okan.service.OkanService;
import com.okan.service.RoleService;
import com.okan.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {

    model.addAttribute("user", new UserDTO());

    model.addAttribute("roles", roleService.findAll());

    model.addAttribute("users", userService.findAll());


        return "user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model) {


        userService.save(user);

        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")

    public String editUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("user", userService.findById(username));

        model.addAttribute("roles", roleService.findAll());

        model.addAttribute("users", userService.findAll());


        return "user/update";
    }
}
