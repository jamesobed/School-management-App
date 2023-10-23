package com.sowfte.schoolmgt.controller;

import com.sowfte.schoolmgt.dto.EnrolmentDto;
import com.sowfte.schoolmgt.dto.SchoolDto;
import com.sowfte.schoolmgt.dto.SubjectDto;
import com.sowfte.schoolmgt.entity.SchoolEntity;
import com.sowfte.schoolmgt.entity.SubjectEntity;
import com.sowfte.schoolmgt.service.SchoolService;
import com.sowfte.schoolmgt.service.SubjectService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
@AllArgsConstructor
public class Subject {
    private final SubjectService service;

    @GetMapping("/all-subject")
    public ResponseEntity<List<SubjectEntity>> getAllSchool(){
        var response = service.getAllSubject();
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectEntity> getOneSchool(@PathVariable Long id){
        var response = service.getSubject(id);
        return  ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<SubjectEntity> registerSchool(@RequestBody SubjectDto payload){
        var response = service.createSubject(payload);
        return  ResponseEntity.ok(response);
    }

    @PatchMapping("/")
    public  SubjectEntity enrollStudent(@RequestBody EnrolmentDto payload){
        return service.enrollStudent(payload);
    }
}
