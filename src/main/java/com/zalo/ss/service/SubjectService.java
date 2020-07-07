package com.zalo.ss.service;

import java.util.List;

import com.zalo.ss.model.Subject;
import com.zalo.ss.model.SubjectDto;

public interface SubjectService extends GeneralCrud<Subject, SubjectDto>{
    List<Subject> findByFilters(String name, String code, Long status);
}