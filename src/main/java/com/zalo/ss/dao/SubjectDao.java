package com.zalo.ss.dao;

import com.zalo.ss.model.Subject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends CrudRepository<Subject, Long>, QueryByExampleExecutor<Subject> {
    
    
}