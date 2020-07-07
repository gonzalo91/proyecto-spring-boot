package com.zalo.ss.service;

import java.util.List;

public interface GeneralCrud<T, DTO> {

    T save(DTO dto);

    List<T> findAll();

    void delete(long id);

    T update(Long id, T entity);

    T findById(Long i);

}