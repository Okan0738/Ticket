package com.okan.bootstrap;

import com.okan.dto.RoleDTO;
import com.okan.dto.UserDTO;
import com.okan.enums.Gender;
import com.okan.service.RoleService;
import com.okan.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataGenerator implements CommandLineRunner {

    private RoleService roleService;
    private final UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
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
                "beli07",true,"123456789987",adminRole, Gender.FEMALE);
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

    }
}
