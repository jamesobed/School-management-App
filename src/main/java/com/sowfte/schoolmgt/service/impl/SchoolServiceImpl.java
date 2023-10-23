package com.sowfte.schoolmgt.service.impl;

import com.sowfte.schoolmgt.dto.SchoolDto;
import com.sowfte.schoolmgt.entity.SchoolEntity;
import com.sowfte.schoolmgt.repository.SchoolRepository;
import com.sowfte.schoolmgt.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository Repository;
    @Override
    public SchoolEntity registerSchool(SchoolDto payload) {
        SchoolEntity newSchool = SchoolEntity.builder()
                .schoolLocation(payload.getSchoolLocation())
                .name(payload.getName())
                .build();
        return Repository.save(newSchool);
    }

    @Override
    public List<SchoolEntity> getAllSchool() {
        return Repository.findAll();
    }

    @Override
    public SchoolEntity getSchool(Long Teacherid) {
        return Repository.findById(Teacherid).get();
    }
}
