package com.zalo.ss.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zalo.ss.dao.RoleDao;
import com.zalo.ss.dao.TeacherDao;
import com.zalo.ss.dao.TypeDao;
import com.zalo.ss.dao.UserDao;
import com.zalo.ss.model.Role;
import com.zalo.ss.model.Teacher;
import com.zalo.ss.model.TeacherDto;
import com.zalo.ss.model.Type;
import com.zalo.ss.model.User;
import com.zalo.ss.service.TeacherService;
import com.zalo.ss.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service(value = "teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired    
    private UserDao userDao;

    @Autowired    
    private RoleDao roleDao;

    @Autowired    
    private TypeDao typeDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    UserService userService;

    @Override
    public Teacher save(TeacherDto teacherDto){
        User user = userService.save(teacherDto);

        Set<Role> roles = new HashSet<Role>();
        Optional<Role> role = roleDao.findById(Role.TEACHER);
        roles.add(role.get());
        user.setRoles(roles);

        Type type = typeDao.findById(teacherDto.getType()).get();

        Teacher teacher = new Teacher();
        teacher.setN_employee(teacherDto.getN_employee());
        teacher.setUser(user);
        teacher.setType(type);

        return teacherDao.save(teacher);                
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> list = new ArrayList<>();
        teacherDao.findAll().iterator().forEachRemaining(list::add);
        return list;        
    }

    @Override
    public void delete(long id) {
        Optional<User> user = userDao.findById(id);
        user.get().setRoles(null);
        user.get().setTeacher(null);
        userDao.save(user.get());                   
    }

    @Override
    public Teacher update(Long id, Teacher teacherModel) {
        Teacher teacher = teacherDao.findById(id).get();
        Type    type    = typeDao.findById(teacherModel.getType().getId()).get();
        
        teacher.setN_employee(teacherModel.getN_employee());
        teacher.getUser().setName(teacherModel.getUser().getName());
        teacher.getUser().setUsername(teacherModel.getUser().getUsername());
        teacher.getUser().setStatus(teacherModel.getUser().getStatus());
        teacher.setType(type);

        return teacherDao.save(teacher);        
    }

    @Override
    public List<Teacher> findByFilters(String name, String username, Long type, Integer status) {
        Teacher teacher = new Teacher();
        
        teacher.getUser().setName(name);
        teacher.getUser().setUsername(username);
        teacher.getUser().setStatus(status);
        teacher.getType().setId(type);
        
        ExampleMatcher matcher = ExampleMatcher.matching()
                                .withIgnoreNullValues().withIgnoreCase();        
                                
        Example<Teacher> example = Example.of(teacher, matcher);
        return (List<Teacher>) teacherDao.findAll(example);        
    }

    @Override
    public Teacher findById(Long id) {
        return teacherDao.findById(id).get();
    }

    
    
}