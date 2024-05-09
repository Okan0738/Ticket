package com.okan.controller;

import com.okan.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/create")
    public String createUser(Model model) {

    model.addAttribute("user", new UserDTO());


    model.addAttribute("roles", new ArrayList<UserDTO>());


        return "/user/create";
    }
}
