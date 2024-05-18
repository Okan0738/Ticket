package com.okan.service;

import com.okan.dto.TaskDTO;
import com.okan.dto.UserDTO;
import com.okan.enums.Status;

import java.util.List;

public interface TaskService extends CrudService <TaskDTO,Long>{

    List<TaskDTO> findTasksByManager(UserDTO manager);
    List<TaskDTO> findAllTasksByStatusIsNot(Status status);
    List<TaskDTO> findAllTasksByStatus(Status status);

    void updateStatus(TaskDTO task);
}
