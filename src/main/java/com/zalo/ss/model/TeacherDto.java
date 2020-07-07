package com.zalo.ss.model;

public class TeacherDto extends UserDto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String n_employee;
    private Long type;

    public String getN_employee() {
        return n_employee;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public void setN_employee(String n_employee) {
        this.n_employee = n_employee;
    }
    
}