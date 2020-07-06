package com.zalo.ss.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    
    @JoinTable(name = "USER_GROUP", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "GROUP_ID") })
    private Set<Group> groups;    

    
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private Student student;

    @Column
    private Integer status;

    public Long getId() {
        return id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }
        

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setStudent(Student student){        
        this.student = student;
    }

    public Student getStudent(){
        return this.student;
    }
}

