package com.zalo.ss.model;
import javax.persistence.*;

@Entity
public class Role {
    public static final Long ADMIN = (long) 1;    
    public static final Long STUDENT = (long) 2;
    public static final Long TEACHER = (long) 3;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
