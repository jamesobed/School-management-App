package com.sowfte.schoolmgt.service;

import com.sowfte.schoolmgt.dto.StudentDto;
import com.sowfte.schoolmgt.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity registerStud (StudentDto payload);
    List<StudentEntity> getAllStud ();
    StudentEntity getStud (Long studid);
}
