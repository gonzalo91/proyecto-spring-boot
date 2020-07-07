package com.zalo.ss.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zalo.ss.dao.SubjectDao;
import com.zalo.ss.model.Subject;
import com.zalo.ss.model.SubjectDto;
import com.zalo.ss.service.SubjectService;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(value = "subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Subject save(SubjectDto dto) {
        Subject subject = new Subject();
        subject.setCode(dto.getCode());
        subject.setName(dto.getName());
        subject.setStatus(dto.getStatus());
        return subjectDao.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        List<Subject> list = new ArrayList<>();
        subjectDao.findAll().iterator().forEachRemaining(list::add);                
        return list;
    }

    @Override
    public void delete(long id) {
        subjectDao.deleteById(id);
    }

    @Override
    public Subject update(Long id, Subject entity) {
        Subject subject = new Subject();
        subject.setId(entity.getId());
        subject.setCode(entity.getCode());
        subject.setName(entity.getName());
        subject.setStatus(entity.getStatus());
        return subjectDao.save(subject);
    }

    @Override
    public Subject findById(Long id) {        
        return subjectDao.findById(id).get();
    }

    public List<Subject> findByFilters(String name, String code, Long status){
        Subject subject = new Subject();
        subject.setCode(code);
        subject.setName(name);
        subject.setStatus(status);
        
        ExampleMatcher matcher = ExampleMatcher.matching()
                                .withIgnoreNullValues().withIgnoreCase();        
                                
        Example<Subject> example = Example.of(subject, matcher);
        return (List<Subject>) subjectDao.findAll(example); 
    }

   
    
}