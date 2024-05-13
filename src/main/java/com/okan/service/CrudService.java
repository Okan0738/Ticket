package com.okan.service;

import java.util.List;

public interface CrudService<T,ID> {

    T save(T role);
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    void update(T object);

}
