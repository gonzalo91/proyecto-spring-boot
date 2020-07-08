package com.zalo.ss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


@Entity
public class Student {

    @Id
    @Column
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId    
    private User user;

    @Column(unique = true)
    private String number;

    

    public Student(String name, String username, String number2, Integer status) {
        this.user = new User();        
        this.user.setName(name);
        this.user.setUsername(username);        
        this.user.setStatus(status);        
        this.number = number2;
	}

	public Student() {
	}

	public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

}