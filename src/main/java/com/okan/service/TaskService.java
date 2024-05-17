package com.okan.service;

import com.okan.dto.TaskDTO;
import com.okan.dto.UserDTO;

import java.util.List;

public interface TaskService extends CrudService <TaskDTO,Long>{

    List<TaskDTO> findTasksByManager(UserDTO manager);
}
