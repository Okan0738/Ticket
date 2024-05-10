package com.okan.dto;

import com.okan.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private Boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;
}
