package com.okan.service;

import com.okan.dto.RoleDTO;

import java.util.List;

public interface OkanService<T,ID> {

    T save(T role);
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);

}
