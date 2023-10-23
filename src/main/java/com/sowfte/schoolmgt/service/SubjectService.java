package com.sowfte.schoolmgt.service;

import com.sowfte.schoolmgt.dto.EnrolmentDto;
import com.sowfte.schoolmgt.dto.SchoolDto;
import com.sowfte.schoolmgt.dto.SubjectDto;
import com.sowfte.schoolmgt.entity.SchoolEntity;
import com.sowfte.schoolmgt.entity.SubjectEntity;

import java.util.List;

public interface SubjectService {
    SubjectEntity createSubject (SubjectDto payload);
    List<SubjectEntity> getAllSubject ();
    SubjectEntity getSubject (Long id);

    SubjectEntity enrollStudent(EnrolmentDto payload);
}
