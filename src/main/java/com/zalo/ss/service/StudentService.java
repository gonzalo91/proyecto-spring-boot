package com.zalo.ss.service;

import java.util.List;

import com.zalo.ss.model.Student;
import com.zalo.ss.model.StudentDto;

public interface StudentService {
    
    
    Student save(StudentDto studentDto);

    List<Student> findAll();

    void delete(long id);

    Student update(Long id, Student student);

    Student findById(Long id);

    List<Student> findByFilters(String name, String username, String number, Integer status);
}