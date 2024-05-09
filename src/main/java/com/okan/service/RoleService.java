package com.okan.service;

import com.okan.dto.RoleDTO;
import com.okan.dto.UserDTO;

import java.util.List;

public interface RoleService {

    RoleDTO save(RoleDTO role);
    RoleDTO findById(long id);
    List<RoleDTO> findAll();
    void deleteById(long id);

}
