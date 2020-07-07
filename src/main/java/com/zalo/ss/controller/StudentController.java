package com.zalo.ss.controller;

import java.util.List;

import com.zalo.ss.model.Student;
import com.zalo.ss.model.StudentDto;
import com.zalo.ss.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Student create(@RequestBody final StudentDto student) {
        System.out.println(student.getStatus());
        return studentService.save(student);
        
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Student> getAll(){        
        return studentService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/findById/{id}", method=RequestMethod.GET)
    public Student findById(@PathVariable(value = "id") final Long id){        
        return studentService.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value = "id") final Long id){  
        studentService.delete(id);                      
        return "OK";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/search", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Student> search(
        @RequestParam(value = "name" , required = false) final String name,
        @RequestParam(value = "username" , required = false) final String username,
        @RequestParam(value = "number" , required = false) final String number,
        @RequestParam(value = "status" , required = false) final Integer status
    ){                                  
        return studentService.findByFilters(name, username, number, status);                              
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Student update(
        @PathVariable Long id,
        @RequestBody final Student student
    ){                                       
        return studentService.update(id, student);
    }



}