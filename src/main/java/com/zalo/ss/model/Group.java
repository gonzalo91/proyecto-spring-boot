package com.zalo.ss.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "school_group")
@Data
public class Group {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
    private Subject subject;
    
    @Column
    private Long status;

    @Column
    private Integer students_qty;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)    
    @JoinTable(name = "USER_GROUP", joinColumns = { @JoinColumn(name = "GROUP_ID") }, inverseJoinColumns = {
    @JoinColumn(name = "USER_ID") })
    @JsonIgnore
    private Set<User> users;
}