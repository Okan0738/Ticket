package com.okan.service;

import com.okan.dto.ProjectDTO;
import com.okan.dto.UserDTO;

import java.util.List;

public interface  ProjectService extends CrudService<ProjectDTO,String>{

    void complete(ProjectDTO project);
    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);

}
