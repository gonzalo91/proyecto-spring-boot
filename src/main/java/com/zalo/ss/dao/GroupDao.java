package com.zalo.ss.dao;

import java.util.List;
import java.util.Set;

import com.zalo.ss.model.Group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends CrudRepository<Group, Long>, QueryByExampleExecutor<Group> {
    
    List<Group> findBySubjectIdNotIn(Set<Long> ids);
}