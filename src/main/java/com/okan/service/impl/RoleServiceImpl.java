package com.okan.service.impl;

import com.okan.dto.RoleDTO;
import com.okan.service.RoleService;

import java.util.List;

public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService {
    @Override
    public RoleDTO save(RoleDTO role) {
        return super.save(role.getId(), role);
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
                super.deleteByID(id);
    }
}
