package com.zalo.ss.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zalo.ss.dao.RoleDao;
import com.zalo.ss.dao.StudentDao;
import com.zalo.ss.dao.UserDao;
import com.zalo.ss.model.Student;
import com.zalo.ss.model.StudentDto;
import com.zalo.ss.model.User;
import com.zalo.ss.model.Role;
import com.zalo.ss.service.StudentService;
import com.zalo.ss.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    StudentDao studentDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    UserService userService;

    @Override
    public Student save(StudentDto studentDto) {

        User user = userService.save(studentDto);

        Set<Role> roles = new HashSet<Role>();
        Optional<Role> role = roleDao.findById(Role.STUDENT);
        roles.add(role.get());
        user.setRoles(roles);

        Student student = new Student();

        student.setNumber(studentDto.getNumber());
        student.setUser(user);

        return studentDao.save(student);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
		studentDao.findAll().iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public void delete(long id) {
        Optional<User> user = userDao.findById(id);
        user.get().setRoles(null);
        user.get().setStudent(null);
        userDao.save(user.get());                
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> student = studentDao.findById(id);
        return student.get();
    }

    @Override
    public List<Student> findByFilters(String name, String username, String number, Integer status) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                                .withIgnoreNullValues().withIgnoreCase();
                
        Example<Student> example = Example.of(new Student(name, username, number, status), matcher);
        return (List<Student>) studentDao.findAll(example);
    }

    @Override
    public Student update(Long id, Student student) {
        Student student2 = studentDao.findById(id).get();
        student2.setId(id);
        student2.setNumber(student.getNumber());
        student2.getUser().setName(student.getUser().getName());
        student2.getUser().setUsername(student.getUser().getUsername());
        student2.getUser().setStatus(student.getUser().getStatus());

        return studentDao.save(student2);
    }
    


}