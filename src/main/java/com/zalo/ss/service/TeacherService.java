package com.zalo.ss.service;

import java.util.List;

import com.zalo.ss.model.Teacher;
import com.zalo.ss.model.TeacherDto;

public interface TeacherService extends GeneralCrud<Teacher, TeacherDto>{
            
    List<Teacher> findByFilters(String name, String username, Long type, Integer status);
}