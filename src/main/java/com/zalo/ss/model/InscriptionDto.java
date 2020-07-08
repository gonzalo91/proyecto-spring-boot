package com.zalo.ss.model;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class InscriptionDto {
    
    private List<Group> available_groups;

    private Set<Group> subscribe_groups;

}