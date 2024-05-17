package com.okan.service.impl;
import com.okan.dto.ProjectDTO;
import com.okan.dto.TaskDTO;
import com.okan.dto.UserDTO;
import com.okan.enums.Status;
import com.okan.service.ProjectService;
import com.okan.service.TaskService;
import com.okan.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {

    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {

        if(project.getStatus()==null) {
            project.setStatus(Status.OPEN);
        }
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

        if(object.getStatus()==null) {
            object.setStatus(findById(object.getProjectCode()).getStatus());
        }

        super.update(object.getProjectCode(),object);

    }

    @Override
    public void deleteById(String projectCode) {

        super.deleteById(projectCode);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setStatus(Status.COMPLETED);
    }
    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        List<ProjectDTO> projectList =
                findAll()
                        .stream()
                        .filter(project -> project.getAssignedManager().equals(manager))  //John
                        .map(project ->{

                          List<TaskDTO> taskList = taskService.findTasksByManager(manager);

                            int completeTaskCounts = (int) taskList.stream().filter(t-> t.getProject().equals(project)&& t.getTaskStatus()==Status.COMPLETED).count();
                            int unfinishedTaskCounts = (int) taskList.stream().filter(t -> t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETED).count();

                            project.setCompleteTaskCounts(completeTaskCounts);
                            project.setUnfinishedTaskCounts(unfinishedTaskCounts);

                            return project;

                        })
                        .collect(Collectors.toList());


        return List.of();
    }

}
