package com.okan.converter;

import com.okan.dto.ProjectDTO;
import com.okan.service.ProjectService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {

    ProjectService projectService;

    public ProjectDtoConverter(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }
        return projectService.findById(source);
    }
}
