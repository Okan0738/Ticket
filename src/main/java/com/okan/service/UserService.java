package com.okan.service;

import com.okan.dto.UserDTO;

import java.util.List;

public interface UserService {
 UserDTO save(UserDTO user);
 List<UserDTO> findAll();
 UserDTO findOne(Long id);
 void deleteById(Long id);

}
