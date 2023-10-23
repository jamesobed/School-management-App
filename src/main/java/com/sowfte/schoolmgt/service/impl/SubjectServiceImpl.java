package com.sowfte.schoolmgt.service.impl;

import com.sowfte.schoolmgt.dto.EnrolmentDto;
import com.sowfte.schoolmgt.dto.SchoolDto;
import com.sowfte.schoolmgt.dto.SubjectDto;
import com.sowfte.schoolmgt.entity.SchoolEntity;
import com.sowfte.schoolmgt.entity.StudentEntity;
import com.sowfte.schoolmgt.entity.SubjectEntity;
import com.sowfte.schoolmgt.repository.SchoolRepository;
import com.sowfte.schoolmgt.repository.StudentRepository;
import com.sowfte.schoolmgt.repository.SubjectRepository;
import com.sowfte.schoolmgt.service.SchoolService;
import com.sowfte.schoolmgt.service.SubjectService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository Repository;
    private  final StudentRepository studentRepository;

    private static  final Logger LOGGER = LoggerFactory.getLogger(SubjectServiceImpl.class);
    @Override
    public SubjectEntity createSubject(SubjectDto payload) {
        SubjectEntity newSchool = SubjectEntity.builder()
                .name(payload.getName())
                .build();
        return Repository.save(newSchool);
    }

    @Override
    public List<SubjectEntity> getAllSubject() {
        return Repository.findAll();
    }

    @Override
    public SubjectEntity getSubject(Long Teacherid) {
        return Repository.findById(Teacherid).get();
    }

    @Override
    public SubjectEntity enrollStudent(EnrolmentDto payload) {

        StudentEntity student = studentRepository.findById(payload.getId()).get();
        SubjectEntity subject = Repository.findById(payload.getSubjectID()).get();
        subject.enrolledStudent(student);
        return Repository.save(subject);
    }
}
