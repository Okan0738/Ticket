package com.okan.controller;

import com.okan.dto.TaskDTO;
import com.okan.enums.Status;
import com.okan.service.ProjectService;
import com.okan.service.TaskService;
import com.okan.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public TaskController(UserService userService, ProjectService projectService, TaskService taskService) {
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model) {

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/create";

    }

    @PostMapping("/create")
    public String insertTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("projects", projectService.findAll());
            model.addAttribute("employees", userService.findEmployees());
            model.addAttribute("tasks", taskService.findAll());

            return "/task/create";

        }

        taskService.save(task);

        return "redirect:/task/create";

    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, Model model) {

        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/update";

    }

//    @PostMapping("/update/{taskId}")
//    public String updateTask(@PathVariable("taskId") Long taskId, TaskDTO task) {
//
//        task.setId(taskId);
//        taskService.update(task);
//
//        return "redirect:/task/create";
//
//    }

    @PostMapping("/update/{id}")
    public String updateTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("projects", projectService.findAll());
            model.addAttribute("employees", userService.findEmployees());
            model.addAttribute("tasks", taskService.findAll());

            return "/task/update";

        }

        taskService.update(task);

        return "redirect:/task/create";

    }
    @GetMapping("/employee/pending-tasks")
    public String employeePendingTasks(Model model) {

        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETED));

        return "/task/pending-tasks";
    }


    @GetMapping("/employee/archive")
    public String employeeArchive(Model model) {

        model.addAttribute("tasks", taskService.findAllTasksByStatus(Status.COMPLETED));

        return "/task/archive";
    }

    @GetMapping("/employee/edit/{Id}")
    public String employeeEdit(@PathVariable("Id") Long Id, Model model) {

        model.addAttribute("task", taskService.findById(Id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETED));
        model.addAttribute("statuses", Status.values());
        return "/task/status-update";
    }

    @PostMapping("/task/employee/update/{id}")
    public String employeeUpdateTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("statuses", Status.values());
            model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETED));

            return "/task/status-update";

        }

        taskService.updateStatus(task);

        return "redirect:/task/employee/pending-tasks";

    }

}
