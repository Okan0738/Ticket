package com.okan.service.impl;

import com.okan.dto.ProjectDTO;
import com.okan.dto.RoleDTO;
import com.okan.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public void deleteById(String projectCode) {

    }

    @Override
    public void update(ProjectDTO object) {

    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
                super.deleteByID(id);
    }

    @Override
    public void update(RoleDTO object) {

    }
}
