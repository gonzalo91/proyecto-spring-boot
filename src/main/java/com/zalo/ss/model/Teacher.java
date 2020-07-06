package com.zalo.ss.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Teacher {
    @Id
    @Column
    private int id;

    @OneToOne
    @MapsId
    private User user;


    @Column
    private String n_employee;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
    private Type type;
    
}