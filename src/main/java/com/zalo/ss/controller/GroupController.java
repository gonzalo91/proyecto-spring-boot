package com.zalo.ss.controller;

import java.util.List;
import java.util.Optional;

import com.zalo.ss.model.Group;
import com.zalo.ss.model.GroupDto;
import com.zalo.ss.service.GroupService;

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
@RequestMapping("/group")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GroupController {

    @Autowired    
    private GroupService groupService;

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Group create(@RequestBody final GroupDto groupDto) {
        return groupService.save(groupDto);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Group> getAll(){        
        return groupService.findAll();
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/findById/{id}", method=RequestMethod.GET)
    public Group findById(@PathVariable(value = "id") final Long id){        
        return groupService.findById(id);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value = "id") final Long id){   
        groupService.delete(id);
        return "ok";
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/search", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Group> search(        
        @RequestParam(value = "code" , required = false)  String code,        
        @RequestParam(value = "status" , required = false)  Long status
    ){                            
        return groupService.findByFilters(code, status);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Group update(
        @PathVariable Long id,
        @RequestBody final Group group
    ){                                       
        return groupService.update(id, group);
    }
    
}
