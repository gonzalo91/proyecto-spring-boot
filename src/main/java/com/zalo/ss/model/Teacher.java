package com.zalo.ss.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Teacher {
    @Id
    @Column
    private Long id;

    @OneToOne
    @MapsId
    private User user;


    @Column
    private String n_employee;

    
    //@OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=false)    
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)    
    private Type type;

    public Teacher(){
        this.user = new User();
        this.type = new Type();
    }
    
}