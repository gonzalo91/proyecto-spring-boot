package com.zalo.ss.dao;

import java.util.List;

import com.zalo.ss.model.Teacher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends CrudRepository<Teacher, Long>, QueryByExampleExecutor<Teacher> {        
    
}