package com.sowfte.schoolmgt.service.impl;

import com.sowfte.schoolmgt.dto.StudentDto;
import com.sowfte.schoolmgt.entity.StudentEntity;
import com.sowfte.schoolmgt.repository.StudentRepository;
import com.sowfte.schoolmgt.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public StudentEntity registerStud(StudentDto payload) {
        StudentEntity newStud = StudentEntity.builder()
                .studentAddress(payload.getStudentAddress())
                .studentClass(payload.getStudentClass())
                .studentEmail(payload.getStudentEmail())
                .studentName(payload.getStudentName())
                .studentDepartment(payload.getStudentDepartment())
                .build();
        return studentRepository.save(newStud);
    }

    @Override
    public List<StudentEntity> getAllStud() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStud(Long studid) {
        return studentRepository.findById(studid).get();
    }
}
