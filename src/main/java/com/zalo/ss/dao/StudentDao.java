package com.zalo.ss.dao;

import java.util.List;

import com.zalo.ss.model.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends CrudRepository<Student, Long>, QueryByExampleExecutor<Student> {

    
    List<Student> findByUserNameAndUserUsernameAndNumberAndUserStatus(String name, String username, String number, int status);
    
}