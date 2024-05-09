package com.okan.service;

import com.okan.dto.RoleDTO;

import java.util.List;

public interface OkanService<T,ID> {

    T save(T role);
    T findById(ID username);
    List<T> findAll();
    void deleteById(ID username);

}
