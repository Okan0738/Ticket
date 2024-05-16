package com.okan.bootstrap;

import com.okan.dto.ProjectDTO;
import com.okan.dto.RoleDTO;
import com.okan.dto.TaskDTO;
import com.okan.dto.UserDTO;
import com.okan.enums.Gender;
import com.okan.enums.Status;
import com.okan.service.ProjectService;
import com.okan.service.RoleService;
import com.okan.service.TaskService;
import com.okan.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
public class DataGenerator implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;


    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");


        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);


        UserDTO user1= new UserDTO("Okan","Celik","okancelik@gmail.com",
                "clk07",true,"876543567889987",managerRole, Gender.MALE);
        UserDTO user2= new UserDTO("Kaan","Celik","kaancelik@gmail.com",
                "ka.clk07",true,"123456789987",employeeRole, Gender.MALE);
        UserDTO user3= new UserDTO("Belinay","Celik","belinaycelik@gmail.com",
                "beli07",true,"123456789987",managerRole, Gender.FEMALE);
        UserDTO user4= new UserDTO("Filiz","Celik","filizcelik@gmail.com",
                "flzclk123",true,"123456789987",employeeRole, Gender.FEMALE);
        UserDTO user5= new UserDTO("Önder","celik","ondercelik@gmail.com",
                "onder123",true,"123456789987",managerRole, Gender.MALE);
        UserDTO user6= new UserDTO("Tahir","Celik","tahircelik@gmail.com",
                "tahir123",true,"123456789987",employeeRole, Gender.MALE);
        UserDTO user7= new UserDTO("Irfan","Er","irfaner@gmail.com",
                "irfan1234",true,"123456789987",employeeRole, Gender.MALE);
        UserDTO user8= new UserDTO("Ozgur","Azcan","ozgurazcan@gmail.com",
                "ozgur123",true,"123456789987",employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDTO project1 = new ProjectDTO("Spring MVC", "PR001", user1, LocalDate.now(), LocalDate.now().plusDays(25), "Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "PR002", user2, LocalDate.now(), LocalDate.now().plusDays(10), "Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container", "PR003", user3, LocalDate.now(), LocalDate.now().plusDays(32), "Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

        TaskDTO task1 = new TaskDTO(1L,project1, user8, "Controller", "Request Mapping", Status.IN_PROGRESS, LocalDate.now().minusDays(4));
        TaskDTO task2 = new TaskDTO(2L,project3, user3, "Configuration", "Database Connection", Status.COMPLETED, LocalDate.now().minusDays(12));
        TaskDTO task3 = new TaskDTO(3L,project3, user6, "Mapping", "One-To-Many", Status.COMPLETED, LocalDate.now().minusDays(8));
        TaskDTO task4 = new TaskDTO(4L,project2, user7, "Dependency Injection", "Autowired", Status.IN_PROGRESS, LocalDate.now().minusDays(20));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);

    }
}
