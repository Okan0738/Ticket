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
                "Clk07",true,"876543567889987",adminRole, Gender.MALE);
        UserDTO user2= new UserDTO("Kaan","Celik","kaancelik@gmail.com",
                "Ka.clk07",true,"123456789987",employeeRole, Gender.MALE);
        UserDTO user3= new UserDTO("Belinay","Celik","belinaycelik@gmail.com",
                "Beli07",true,"123456789987",adminRole, Gender.FEMALE);
        UserDTO user4= new UserDTO("Kim","Celik","kimcelik@gmail.com",
                "Kmclk123",true,"123456789987",managerRole, Gender.FEMALE);
        UserDTO user5= new UserDTO("Ahmet","Doguc","ahmetdoguc@gmail.com",
                "Dgc123",true,"123456789987",managerRole, Gender.MALE);
        UserDTO user6= new UserDTO("jessica","Doguc","jesidoguc@gmail.com",
                "Jes123",true,"123456789987",employeeRole, Gender.FEMALE);
        UserDTO user7= new UserDTO("Lia","Doguc","liadgc@gmail.com",
                "lia1234",true,"123456789987",employeeRole, Gender.FEMALE);
        UserDTO user8= new UserDTO("elisa","paulman","elisaplm@gmail.com",
                "els123",true,"123456789987",employeeRole, Gender.FEMALE);

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
