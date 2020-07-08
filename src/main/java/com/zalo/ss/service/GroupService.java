package com.zalo.ss.service;

import java.util.List;

import com.zalo.ss.model.Group;
import com.zalo.ss.model.GroupDto;

public interface GroupService extends GeneralCrud<Group, GroupDto> {    

    public List<Group> findByFilters(String code, Long status);
}