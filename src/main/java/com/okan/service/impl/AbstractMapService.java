package com.okan.service.impl;

import com.okan.dto.ProjectDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService <T, ID> {

    public Map<ID, T> map=new HashMap<>(); //DB

    T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    List<T> findAll() {

        return new ArrayList<>(map.values());
    }


    public abstract ProjectDTO save(ProjectDTO project);

    T findById(ID id) {
        return map.get(id);
    }


    void deleteByID(ID id) {
        map.remove(id);
    }

    void update(ID id, T object) {
        map.put(id, object);
    }

    public abstract void deleteById(String projectCode);

    public abstract void update(ProjectDTO object);
}
