package com.zalo.ss.dao;

import java.util.List;

import com.zalo.ss.model.Type;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDao extends CrudRepository<Type, Long>{        
    
}