package com.okan.service.impl;

import com.okan.dto.RoleDTO;
import com.okan.service.RoleService;

import java.util.List;

public abstract class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO role) {
        return null;
    }

    @Override
    public void deleteById(Long username) {

    }
/*
    @Override
    public T findById(ID username) {
        return null;
    }
 */

    @Override
    public List<RoleDTO> findAll() {
        return List.of();
    }
}
