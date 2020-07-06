package com.zalo.ss.model;

public class TeacherDto extends UserDto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String n_employee;
    private int type;

    public String getN_employee() {
        return n_employee;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setN_employee(String n_employee) {
        this.n_employee = n_employee;
    }
    
}