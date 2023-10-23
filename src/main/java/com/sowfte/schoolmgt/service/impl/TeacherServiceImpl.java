package com.sowfte.schoolmgt.service.impl;

import com.sowfte.schoolmgt.dto.TeacherDto;
import com.sowfte.schoolmgt.entity.TeacherEntity;
import com.sowfte.schoolmgt.repository.TeacherRepository;
import com.sowfte.schoolmgt.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository Repository;
    @Override
    public TeacherEntity registerTeacher(TeacherDto payload) {
        TeacherEntity newTeacher = TeacherEntity.builder()
                .address(payload.getAddress())
                .email(payload.getEmail())
                .name(payload.getName())
                .phone(payload.getPhone())
                .build();
        return Repository.save(newTeacher);
    }

    @Override
    public List<TeacherEntity> getAllTeacher() {
        return Repository.findAll();
    }

    @Override
    public TeacherEntity getTeacher(Long Teacherid) {
        return Repository.findById(Teacherid).get();
    }
}
