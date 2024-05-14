package com.okan.service.impl;

import com.okan.dto.ProjectDTO;
import com.okan.dto.UserDTO;
import com.okan.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {
    @Override
    public UserDTO save(UserDTO user) {return super.save(user.getUserName(),user);
    }

    @Override
    public UserDTO findById(String username) {return super.findById(username);
    }

    @Override
    public List<UserDTO> findAll() {return super.findAll();
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {
        return null;
    }

    @Override
    public void deleteById(String username) {super.deleteByID(username);
    }

    @Override
    public void update(ProjectDTO object) {

    }
    @Override
    public void update(UserDTO object) {super.update(object.getUserName(),object);
    }
}
