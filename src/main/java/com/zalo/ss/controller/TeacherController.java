package com.zalo.ss.controller;

import java.util.List;
import java.util.Optional;



import com.zalo.ss.model.Teacher;
import com.zalo.ss.model.TeacherDto;

import com.zalo.ss.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeacherController {
    @Autowired    
    private TeacherService teacherService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Teacher create(@RequestBody final TeacherDto teacherDto) {
        return teacherService.save(teacherDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Teacher> getAll(){        
        return teacherService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/findById/{id}", method=RequestMethod.GET)
    public Teacher findById(@PathVariable(value = "id") final Long id){        
        return teacherService.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value = "id") final Long id){   
        teacherService.delete(id);
        return "ok";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/search", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> search(
        @RequestParam(value = "name" , required = false) String name,
        @RequestParam(value = "username" , required = false)  String username,
        @RequestParam(value = "type" , required = false)  Long type,
        @RequestParam(value = "status" , required = false)  Integer status
    ){                            
        return teacherService.findByFilters(name, username, type, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Teacher update(
        @PathVariable Long id,
        @RequestBody final Teacher student
    ){                                       
        return teacherService.update(id, student);
    }
    
}