package com.okan.service.impl;

import com.okan.dto.ProjectDTO;
import com.okan.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {

    @Override
    public ProjectDTO findById(String projectcode) {
        return super.findById(projectcode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }


    @Override
    public ProjectDTO save(ProjectDTO project) {
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public void deleteById(String projectCode) {

        super.deleteByID(projectCode);
    }

    @Override
    public void update(ProjectDTO object) {
            super.update(object.getProjectCode(),object);
    }
}
