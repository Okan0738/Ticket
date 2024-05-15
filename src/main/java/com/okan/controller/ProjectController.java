package com.okan.controller;

import com.okan.dto.ProjectDTO;
import com.okan.enums.Status;
import com.okan.service.ProjectService;
import com.okan.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("manager",userService.findAll());
        model.addAttribute("projects",projectService.findAll());

        return "project/create";
    }

    @PostMapping("/create")
    public String saveProject(@ModelAttribute("project") ProjectDTO project, Model model){

        projectService.save(project);

            return "redirect:/project/create";
        }
    @GetMapping("/delete/{projectCode}")
    public String deleteUser(@PathVariable("projectCode") String projectCode) {

        projectService.deleteById(projectCode);

        return "redirect:/project/create";
    }


}
