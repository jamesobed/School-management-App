package com.sowfte.schoolmgt.service;

import com.sowfte.schoolmgt.dto.TeacherDto;
import com.sowfte.schoolmgt.entity.TeacherEntity;

import java.util.List;

public interface TeacherService {
    TeacherEntity registerTeacher (TeacherDto payload);
    List<TeacherEntity> getAllTeacher ();
    TeacherEntity getTeacher (Long id);
}
