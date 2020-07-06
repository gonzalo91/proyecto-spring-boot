package com.zalo.ss.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "school_group")
public class Group {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
    private Subject subject;
    
    @Column
    private int status;

    @Column
    private int students_qty;
}