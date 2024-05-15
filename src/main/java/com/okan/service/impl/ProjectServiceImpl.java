package com.okan.service.impl;
import com.okan.dto.ProjectDTO;
import com.okan.dto.UserDTO;
import com.okan.service.ProjectService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO project) {
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {

        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {

        super.update(object.getProjectCode(),object);

    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }



    @Override
    public void complete(ProjectDTO project) {

    }
    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        return List.of();
    }
}
