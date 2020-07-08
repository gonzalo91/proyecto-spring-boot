package com.zalo.ss.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zalo.ss.dao.GroupDao;
import com.zalo.ss.dao.SubjectDao;
import com.zalo.ss.model.Group;
import com.zalo.ss.model.GroupDto;
import com.zalo.ss.model.Subject;
import com.zalo.ss.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service(value = "groupService")
public class GroupServiceImpl implements GroupService {
    @Autowired    
    private GroupDao groupDao;

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Group save(GroupDto dto) {
        Group group = new Group();
        Subject subject = subjectDao.findById(dto.getSubject()).get();

        group.setStatus(dto.getStatus());
        group.setStudents_qty(dto.getStudents_qty());
        group.setSubject(subject);

        return groupDao.save(group);
    }

    @Override
    public List<Group> findAll() {
        List<Group> groups = new ArrayList<>();
		groupDao.findAll().iterator().forEachRemaining(groups::add);
        return groups;        
    }

    @Override
    public void delete(long id) {
        groupDao.deleteById(id);        
    }

    @Override
    public Group update(Long id, Group entity) {
        Group group = groupDao.findById(entity.getId()).get();
        Subject subject = subjectDao.findById(entity.getSubject().getId()).get();

        group.setStudents_qty(entity.getStudents_qty());
        group.setStatus(entity.getStatus());
        group.setSubject(subject);
        return groupDao.save(group);
    }

    @Override
    public Group findById(Long id) {
        return groupDao.findById(id).get();
    }

    @Override
    public List<Group> findByFilters(String code, Long status) {
        Group group = new Group();
        Subject subject = new Subject();
        subject.setCode(code);
        group.setStatus(status);
        group.setSubject(subject);
        
        ExampleMatcher matcher = ExampleMatcher.matching()
                                .withIgnoreNullValues().withIgnoreCase();        
                                
        Example<Group> example = Example.of(group, matcher);
        return (List<Group>) groupDao.findAll(example);                
    }
    
}