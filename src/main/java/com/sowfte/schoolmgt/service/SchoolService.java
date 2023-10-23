package com.sowfte.schoolmgt.service;

import com.sowfte.schoolmgt.dto.SchoolDto;
import com.sowfte.schoolmgt.entity.SchoolEntity;

import java.util.List;

public interface SchoolService {
    SchoolEntity registerSchool (SchoolDto payload);
    List<SchoolEntity> getAllSchool ();
    SchoolEntity getSchool (Long id);
}
