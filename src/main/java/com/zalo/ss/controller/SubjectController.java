package com.zalo.ss.controller;

import java.util.List;
import java.util.Optional;

import com.zalo.ss.model.Subject;
import com.zalo.ss.model.SubjectDto;
import com.zalo.ss.model.Teacher;
import com.zalo.ss.model.TeacherDto;
import com.zalo.ss.service.SubjectService;

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
@RequestMapping("/subject")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubjectController{
    @Autowired    
    private SubjectService subjectService;

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Subject create(@RequestBody final SubjectDto teacherDto) {
        return subjectService.save(teacherDto);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Subject> getAll(){        
        return subjectService.findAll();
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/findById/{id}", method=RequestMethod.GET)
    public Subject findById(@PathVariable(value = "id") final Long id){        
        return subjectService.findById(id);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value = "id") final Long id){   
        subjectService.delete(id);
        return "ok";
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/search", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Subject> search(
        @RequestParam(value = "name" , required = false) String name,
        @RequestParam(value = "code" , required = false)  String code,        
        @RequestParam(value = "status" , required = false)  Long status
    ){                            
        return subjectService.findByFilters(name, code, status);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Subject update(
        @PathVariable Long id,
        @RequestBody final Subject subject
    ){                                       
        return subjectService.update(id, subject);
    }
    
}